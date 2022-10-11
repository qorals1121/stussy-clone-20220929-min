package com.stussy.stussyclone20220929min.controller.api;

import com.stussy.stussyclone20220929min.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929min.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929min.dto.account.CMRespDto;
import com.stussy.stussyclone20220929min.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929min.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220929min.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {

        accountService.checkDuplicateEmail(registerReqDto.getEmail());

        accountService.register(registerReqDto);
//        if(bindingResult.hasErrors()){
//            log.error("유효성 검사 오류 발생");
//            Map<String, String> errorMap = new HashMap<String, String>();
//
//            List<List<FieldError>> codeList = new ArrayList<List<FieldError>>();
//            codeList.add(new ArrayList<FieldError>());  //Pattern
//            codeList.add(new ArrayList<FieldError>());  //NotBlank
//
//
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//
//                if(error.getCode().equals("Pattern")){
//                    codeList.get(0).add(error);
//                }else if(error.getCode().equals("NotBlank")) {
//                    codeList.get(1).add(error);
//                }
//            });
//
//            log.info("codeList: {}", codeList);
//
//            codeList.forEach(errorMapList -> {
//                errorMapList.forEach(error -> {
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                });
//                log.info("error: {}", errorMap);
//            });
//
//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
//        }
//
//        log.info("{}", registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto(-1, "Successfully registered", registerReqDto));
    }

}