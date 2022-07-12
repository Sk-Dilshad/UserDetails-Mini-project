package in.skbuzz.rest;

import in.skbuzz.bindings.LogingForm;
import in.skbuzz.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginRestController {

    @Autowired
    private UserManagement service;

    @PostMapping("/login")
    public String login(@RequestBody LogingForm logingForm){
        return service.login(logingForm);
    }

}
