package com.example.product.web.app.adapter.cartproductstatus;

import com.kleancierge.product.api.repository.entity.CartProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class CartProductStatusListAdapter {
    public List<CartProductStatus> toContract(Pageable pageable){
        List<CartProductStatus> cartProductStatusList = new ArrayList<>();
        Page<CartProductStatus> cartProductStatuses = new PageImpl<CartProductStatus>(cartProductStatusList, pageable, pageable.getPageSize());
        cartProductStatuses.forEach(cartProductStatus -> cartProductStatusList.add(cartProductStatus));
        return cartProductStatusList;
    }
}
