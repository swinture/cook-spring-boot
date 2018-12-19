package com.swinture.global.exception.handler.controller;

import com.swinture.global.exception.handler.model.CommonAns;
import com.swinture.global.exception.handler.model.GetUserListReq;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author swinture
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("list")
    public CommonAns getUserList(@RequestBody @Valid GetUserListReq req) {
        return new CommonAns().ok();
    }
}
