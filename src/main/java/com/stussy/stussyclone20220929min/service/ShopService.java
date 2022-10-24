package com.stussy.stussyclone20220929min.service;

import com.stussy.stussyclone20220929min.dto.shop.CollectionListRespDto;

import java.util.List;

public interface ShopService {
    public List<CollectionListRespDto> getCollections(String category, int page) throws Exception;
}
