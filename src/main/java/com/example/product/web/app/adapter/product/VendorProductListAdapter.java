package com.example.product.web.app.adapter.product;

import com.kleancierge.product.api.repository.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class VendorProductListAdapter {
    public List<Product> toContract(Pageable pageable) {
        List<Product> productList = new ArrayList<>();
        Page<Product> products = new PageImpl<Product>(productList, pageable, pageable.getPageSize());
        products.forEach(product -> productList.add(product));
        return productList;
    }
}
