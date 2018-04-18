package com.example.product.web.app.adapter.cart;

import com.kleancierge.product.api.repository.entity.Cart;
import com.kleancierge.product.api.repository.entity.Cleaner;
import com.kleancierge.product.api.repository.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class CleanerPastCartsListAdapter {
    public List<Cart> toContract(Pageable pageable, @RequestParam("pageSize") int pageSize) {
        List<Cart> cartList = new ArrayList<>();
        Page<Cart> carts = new PageImpl<Cart>(cartList, pageable, pageSize);
        carts.forEach(product -> cartList.add(product));
        return cartList;
    }
}
