package in.skbuzz.rest;

import in.skbuzz.bindings.UserForm;
import in.skbuzz.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserRegTRestController {

    @Autowired
    private UserManagement service;

    @GetMapping("/email/{emailId}")
    public String emailCheck(@PathVariable("emailId") String emailId){
        return service.emailCheck(emailId);
    }
    @GetMapping("/countries")
    public Map<Integer,String> getCountries(){
        return service.loadCountries();

    }
    @GetMapping("/states/{countyId}")
    public Map<Integer,String> getStates(@PathVariable("countyId") Integer countryId){
        return service.loadStates(countryId);
    }
    @GetMapping("/cities/{stateId}")
    public Map<Integer,String> getCities(@PathVariable("stateId") Integer stateId){
        return service.loadStates(stateId);
    }

    @PostMapping("/user")
    public String userReg(@RequestBody UserForm userForm){
        System.out.println(userForm);
        return service.registerUser(userForm);
    }
}
