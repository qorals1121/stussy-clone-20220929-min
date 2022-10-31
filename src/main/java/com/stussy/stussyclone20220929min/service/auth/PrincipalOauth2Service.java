package com.stussy.stussyclone20220929min.service.auth;

import com.stussy.stussyclone20220929min.domain.User;
import com.stussy.stussyclone20220929min.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2Service extends DefaultOAuth2UserService {

    private final AccountRepository accountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        String provider = userRequest.getClientRegistration().getClientId();
        OAuth2User oauth2User = super.loadUser(userRequest);

        log.info("userRequest >>>> {} ", userRequest);
        log.info("userRequest >>>> {} ", userRequest.getClientRegistration());
        log.info("userRequest >>>> {} ", oAuth2User.getAttributes());

        return oAuth2User;
    }

    private User getOauth2User(String provider, Map<String, Object>attributes) {
        String oauth2_id = null;
        String id  = null;
        String email = null;

        User user = null;

        Map<String, Object> response = null;

        if(provider.equalsIgnoreCase("google")) {
            response = attributes;
            id = (String) response.get("sub");
        }else if(provider.equalsIgnoreCase("naver")) {
            response = (Map<String, Object>) attributes.get("response");
            id = (String) response.get("id");
        }

        oauth2_id = provider + "_" + id;
        email = (String) response.get("email");

        user = accountRepository.findUserByEmail(email);

        return user;
    }

}
