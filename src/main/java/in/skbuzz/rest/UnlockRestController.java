package in.skbuzz.rest;

import in.skbuzz.bindings.UnlockForm;
import in.skbuzz.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnlockRestController {

    @Autowired
    private UserManagement service;

    @PostMapping("/unlock")
    public String unlockAccount(@RequestBody UnlockForm unlockForm){
        return service.unlockAccount(unlockForm);
    }
}
