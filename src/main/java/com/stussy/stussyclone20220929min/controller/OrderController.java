package com.stussy.stussyclone20220929min.controller;

import com.stussy.stussyclone20220929min.dto.order.OrderReqDto;
import com.stussy.stussyclone20220929min.service.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("")
    public String loadOrder(Model model, OrderReqDto orderReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("order", orderReqDto);
        model.addAttribute("principalUser", principalDetails.getUser());
        return "order/order";
    }
}
