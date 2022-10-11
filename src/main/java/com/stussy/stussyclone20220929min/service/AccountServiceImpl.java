package com.stussy.stussyclone20220929min.service;

import com.stussy.stussyclone20220929min.domain.User;
import com.stussy.stussyclone20220929min.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929min.exception.CustomValidationException;
import com.stussy.stussyclone20220929min.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public boolean checkDuplicateEmail(String email) {
        User user = accountRepository.findUserByEmail(email);
        if(user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 이메일입니다.");
            throw new CustomValidationException("duplicateEmail Error", errorMap);
        }
        return true;
    }

    @Override
    public boolean register(RegisterReqDto registerReqDto) throws Exception {
        User userEntity =registerReqDto.toUserEntity();
        int result = accountRepository.save(userEntity);
        //int result = accountRepository.save(registerReqDto.toUserEntity()); 한줄로 줄일 수 있음

        return result != 0;
    }
}
