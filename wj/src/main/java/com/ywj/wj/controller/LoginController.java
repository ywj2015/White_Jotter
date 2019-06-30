package com.ywj.wj.controller;

import com.ywj.wj.result.Result;
import com.ywj.wj.pojo.User;
import com.ywj.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user1 = userService.get(username, user.getPassword());
        if (user == null) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
