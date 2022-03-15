package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpUser(){
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue( value = "setUser" , defaultValue = "") String setUser, Model model){
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request){
        if (user.getEmail().equals("admin@gmail1.com") & user.getPassword().equals("1234")){
            if (user.getEmail() != null){
                setUser = user.getEmail();
            }

            // tao cookie va set cookie o respone

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);

            // get all cookie

            Cookie[] cookies = request.getCookies();

            //

            for (Cookie ck : cookies){
                // chi hien cookie co ten cua setUser
                if (ck.getName().equals("setUser")){
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue",ck);
                    break;
                }
            }

            model.addAttribute("message","dang nhap thanh cong, wellcome");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser",setUser);
            model.addAttribute("cookieVlue", cookie);
            model.addAttribute("message", "dang nhap that bia");
        }
        return "/login";


    }
}
