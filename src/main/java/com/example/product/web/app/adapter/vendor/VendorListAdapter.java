package com.example.product.web.app.adapter.vendor;

import com.kleancierge.product.api.repository.entity.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class VendorListAdapter {
    public List<Vendor> toContract(Pageable pageable){
        List<Vendor> vendorList = new ArrayList<>();
        Page<Vendor> vendors = new PageImpl<Vendor>(vendorList, pageable, pageable.getPageSize());
        vendors.forEach(vendor -> vendorList.add(vendor));
        return vendorList;
    }
}
