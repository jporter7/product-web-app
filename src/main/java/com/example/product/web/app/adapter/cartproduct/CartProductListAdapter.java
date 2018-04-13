package com.example.product.web.app.adapter.cartproduct;

import com.kleancierge.product.api.repository.entity.CartProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class CartProductListAdapter {
    public List<CartProduct> toContract(Pageable pageable){
        List<CartProduct> cartProductList = new ArrayList<>();
        Page<CartProduct> cartProducts = new PageImpl<CartProduct>(cartProductList, pageable, pageable.getPageSize());
        cartProducts.forEach(cartProduct -> cartProductList.add(cartProduct));
        return cartProductList;
    }
}
