package in.skbuzz.service;

import in.skbuzz.bindings.LogingForm;
import in.skbuzz.bindings.UnlockForm;
import in.skbuzz.bindings.UserForm;

import java.util.Map;

public interface UserManagement {

   String login(LogingForm logingForm);
   String emailCheck(String emailId);
   Map<Integer,String> loadCountries();
   Map<Integer,String> loadStates(Integer countryId);
   Map<Integer,String> loadCities(Integer stateId);
   String registerUser(UserForm userForm);
   String unlockAccount(UnlockForm unlockForm);
   String forgetPwd(String email);




}
