package com.spongzi.api;

import com.spongzi.domain.JsonResponse;
import com.spongzi.domain.po.UserPO;
import com.spongzi.service.UserService;
import com.spongzi.util.RSAUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserApi {

    @Resource
    private UserService userService;

    @GetMapping("/rsa-pks")
    public JsonResponse<String> getRSAPublicKeys() {
        String pk = RSAUtil.getPublicKeyStr();
        return JsonResponse.success(pk);
    }

    @PostMapping("/users")
    public JsonResponse<String> addUser(@RequestBody UserPO userPO) {
        userService.addUser(userPO);
        return JsonResponse.success();
    }

}
