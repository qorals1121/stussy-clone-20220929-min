package com.stussy.stussyclone20220929min.controller.api;

import com.stussy.stussyclone20220929min.dto.account.CMRespDto;
import com.stussy.stussyclone20220929min.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopApi {

    private final ShopService shopService;

    @GetMapping("/api/collections/{category}")
    public ResponseEntity<?> getCollection(@PathVariable String category, int page) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Load Successfully", shopService.getCollections(category, page)));
    }
}
