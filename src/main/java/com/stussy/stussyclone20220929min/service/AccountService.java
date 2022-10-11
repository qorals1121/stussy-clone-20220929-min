package com.stussy.stussyclone20220929min.service;

import com.stussy.stussyclone20220929min.dto.account.RegisterReqDto;

public interface AccountService {
    public boolean checkDuplicateEmail(String email);


    boolean register(RegisterReqDto registerReqDto) throws Exception;
}
