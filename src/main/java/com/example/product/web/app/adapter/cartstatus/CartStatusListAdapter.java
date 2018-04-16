package com.example.product.web.app.adapter.cartstatus;

import com.kleancierge.product.api.repository.entity.CartStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class CartStatusListAdapter {
    public List<CartStatus> toContract(Pageable pageable) {
        List<CartStatus> cartStatusList = new ArrayList<>();
        Page<CartStatus> cartStatuses = new PageImpl<CartStatus>(cartStatusList, pageable, pageable.getPageSize());
        cartStatuses.forEach(cartStatus -> cartStatusList.add(cartStatus));
        return cartStatusList;
    }
}
