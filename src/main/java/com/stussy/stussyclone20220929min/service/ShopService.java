package com.stussy.stussyclone20220929min.service;

import com.stussy.stussyclone20220929min.dto.shop.CollectionListRespDto;
import com.stussy.stussyclone20220929min.dto.shop.ProductDetailRespDto;

import java.util.List;

public interface ShopService {
    public List<CollectionListRespDto> getCollections(String category, int page) throws Exception;
    public ProductDetailRespDto getProductDetails(int groupId) throws Exception;
}