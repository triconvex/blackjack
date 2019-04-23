package com.zingoworks.blackjack.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //TODO 홈컨트롤러 필요한가? config에서 해결하는 게 나을까?
    @GetMapping("/")
    public String main() {
        return "/index";
    }

}
