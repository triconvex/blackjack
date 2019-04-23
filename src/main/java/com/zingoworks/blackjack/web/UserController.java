package com.zingoworks.blackjack.web;

import com.zingoworks.blackjack.domain.player.User;
import com.zingoworks.blackjack.security.HttpSessionUtils;
import com.zingoworks.blackjack.security.LoginUser;
import com.zingoworks.blackjack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String joinForm() {
        return "user/form";
    }

    @PostMapping("")
    public String create(User user) {
        System.out.println(user);
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, String userId, String password, Model model) {
        try {
            User user = userService.login(userId, password);
            session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
            log.info("*** userId : " + userId + ", password : " + password);
        } catch (Exception e) {
            log.debug("*** error : {}, {}", e.getMessage(), e.getStackTrace());
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀립니다. 다시 로그인 해주세요.");
            return "user/login";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        return "redirect:/";
    }

    @GetMapping
    public String list(HttpSession session, Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);

        User loginUser = HttpSessionUtils.getUserFromSession(session);

        if(loginUser != null) {
            log.debug("내랭크는: {}", userService.getRank(loginUser, allUsers));
            model.addAttribute("userRank", userService.getRank(loginUser, allUsers));
        }

        return "/user/list";
    }

    @GetMapping("/{id}")
    public String profile(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/user/profile";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@LoginUser User loginUser, @PathVariable long id, Model model) {
        log.debug("LoginUser : {}", loginUser);
        model.addAttribute("user", userService.findById(loginUser, id));
        return "/user/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@LoginUser User loginUser, @PathVariable long id, User target) {
        userService.update(loginUser, id, target);
        return "redirect:/users";
    }

}
