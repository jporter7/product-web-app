$(function(){
    var url = '/test/persons';

    $(".list-people").on("click", function(){
        ajax('GET', url, {});
    });

    $(".find-person").on("click", function(){
        var personId = $(this).prevAll(".form-inline-control:first").val();

        if(personId){
            ajax('GET', url + '/' + personId, {});
        } else {
            alert("Enter a Person ID");

            $("#output").text("");
        }
    });

    $(".create-person").on("click", function(){
        var form = $(this).closest("form");
        var data = form.serialize();

        ajax('POST', url, data);
    });

    $(".update-person").on("click", function(){
        var form = $(this).closest("form");
        var personId = form.find("input[name='id']").val();
        var data = form.serialize();

        ajax('PUT', url + '/' + personId, data);
    });

    $(".delete-person").on("click", function(){
        var personId = $(this).prevAll(".form-inline-control:first").val();

        ajax('DELETE', url + '/' + personId, {});
    });

    $(".btn-group").on("click", ".btn", function(){
        var btn = $(this);
        var text = btn.text();

        $(".btn-group .btn").removeClass("active");

        if(text === "Memory"){
            url = '/test/persons';
        } else {
            url = '/persons';
        }

        btn.addClass("active");
    });

    var ajax = function(method, url, data){
        $.ajax({
            method: method,
            dataType: "json",
            url: url,
            data: data
        }).done(function(resp){
            $("#output").text(JSON.stringify(resp, undefined, 4));
        }).fail(function(er){
            $("#output").text("Error: " + JSON.stringify(er, undefined, 4));
        });
    };
});