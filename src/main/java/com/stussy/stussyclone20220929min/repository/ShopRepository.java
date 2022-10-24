package com.stussy.stussyclone20220929min.repository;

import com.stussy.stussyclone20220929min.domain.CollectionProduct;
import com.stussy.stussyclone20220929min.dto.shop.CollectionListRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopRepository {
    public List<CollectionProduct> getCollectionList(Map<String, Object> map) throws Exception;
}
