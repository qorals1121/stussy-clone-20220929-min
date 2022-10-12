package com.stussy.stussyclone20220929min.controller.admin.api;

import com.stussy.stussyclone20220929min.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929min.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929min.dto.account.CMRespDto;
import com.stussy.stussyclone20220929min.dto.admin.ProductAdditionReqDto;
import com.stussy.stussyclone20220929min.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220929min.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220929min.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @ValidAspect
    @LogAspect
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) throws Exception {

    productService.addProduct(productAdditionReqDto);

    return ResponseEntity.created(null).body(new CMRespDto<>(1, "Successfully", null));



    }


}
