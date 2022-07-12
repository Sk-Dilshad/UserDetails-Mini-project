package in.skbuzz.rest;

import in.skbuzz.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgetPwdRestController {
    @Autowired
    private UserManagement service;

    @GetMapping("/forgotPwd/{email}")
    public String forgetPwd(@PathVariable("email") String email){
        return service.forgetPwd(email);
    }
}
