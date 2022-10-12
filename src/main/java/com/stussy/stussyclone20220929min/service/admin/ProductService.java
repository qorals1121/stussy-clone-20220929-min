package com.stussy.stussyclone20220929min.service.admin;

import com.stussy.stussyclone20220929min.dto.admin.ProductAdditionReqDto;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
}
