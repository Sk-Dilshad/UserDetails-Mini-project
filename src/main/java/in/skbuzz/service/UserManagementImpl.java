package in.skbuzz.service;

import in.skbuzz.bindings.LogingForm;
import in.skbuzz.bindings.UnlockForm;
import in.skbuzz.bindings.UserForm;
import in.skbuzz.entity.CitiesMasterEntity;
import in.skbuzz.entity.CountryMasterEntity;
import in.skbuzz.entity.StateMasterEntity;
import in.skbuzz.entity.UserAccountEntity;
import in.skbuzz.repository.CityMasterRepo;
import in.skbuzz.repository.CountryMasterRepo;
import in.skbuzz.repository.StateMasterRepo;
import in.skbuzz.repository.UserAccountRepo;
import in.skbuzz.util.EmailUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserManagementImpl  implements UserManagement{

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private  CityMasterRepo cityMasterRepo;

    @Autowired
    private  StateMasterRepo stateMasterRepo;

    @Autowired
    private  CountryMasterRepo countryMasterRepo;
    @Autowired
    private EmailUtils emailUtils;

    @Override
    public String login(LogingForm logingForm) {
        UserAccountEntity entity=userAccountRepo.findByEmailAndPwd(logingForm.getEmail(),logingForm.getPwd());
        if(entity == null){
            return "Invalid Credentials";
        }
        if(entity != null && entity.getAccStatus().equals("LOCKED") ){
            return " Your Account Locked";
        }
        return "LOGIN";
    }

    @Override
    public String emailCheck(String emailId) {
        UserAccountEntity entity=userAccountRepo.findByEmail(emailId);
        if(entity == null){
            return "UNIQUE";
        }
        return "DUPLICATE";
    }

    @Override
    public Map<Integer, String> loadCountries() {
        Map<Integer,String> countries = new HashMap<>();
        List<CountryMasterEntity> count=countryMasterRepo.findAll();
        for(CountryMasterEntity country : count){
            countries.put(country.getCountryId(),country.getCountryName());
        }
        return countries;
    }

    @Override
    public Map<Integer, String> loadStates(Integer countryId) {
        List<StateMasterEntity> stateList=stateMasterRepo.findBycountryId(countryId);
        Map<Integer,String>  states=new HashMap<>();
        for(StateMasterEntity state :stateList ){
            states.put(state.getStateId(),state.getStateName());
        }
        return states;
    }

    @Override
    public Map<Integer, String> loadCities(Integer stateId) {
        List<CitiesMasterEntity>  citiesList= cityMasterRepo.findBystateId(stateId);
        Map<Integer,String> cities= new HashMap<>();
        for(CitiesMasterEntity city: citiesList){
            cities.put(city.getCityId(),city.getCityName());
        }
        return cities;
    }

    @Override
    public String registerUser(UserForm userForm) {
        UserAccountEntity entity = new UserAccountEntity();
        System.out.println(userForm.getEmail());
        BeanUtils.copyProperties(userForm,entity);
        entity.setAccStatus("LOCKED");
        entity.setPwd(generatePwd());
        UserAccountEntity userAccountEntity =userAccountRepo.save(entity);

        //TODO:Generate Email
        String email=userForm.getEmail();
        String subject="User Registration ";
        String fileName="UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt";
        String body=readMailBodyContent(fileName,entity);
        boolean isSent= emailUtils.sendEmail(email,subject,body);
        if(userAccountEntity.getUserId()!=null && isSent){
            return "SUCCESS";
        }
        return "FAIL";
    }

    @Override
    public String unlockAccount(UnlockForm unlockForm) {
        UserAccountEntity entity=userAccountRepo.findByEmailAndPwd(unlockForm.getEmail(),unlockForm.getTempPwd());
        if(!(unlockForm.getNewPwd().equals(unlockForm.getConfirmNewPwd()))){
            return "Password And Confirm Password Should Be Same";
        }
        if(entity == null){
            return "Incorrect Temporary password";
        }

        entity.setPwd(unlockForm.getNewPwd());
        entity.setAccStatus("UNLOCKED");
        userAccountRepo.save(entity);

        return "Account Unlocked, Please Proceed with login";
    }

    @Override
    public String forgetPwd(String email) {
        UserAccountEntity entity=userAccountRepo.findByEmail(email);
        if(entity == null){
            return "Invalid Email Id";
        }
        //TODO:Logic To Send Mail

        if(entity !=null){
            String subject="Recover Password";
            String fileName="RECOVER-PASSWORD-EMAIL-BODY-TEMPLATE.txt";
            String body=readMailBodyContent(fileName,entity);
            boolean isSent = emailUtils.sendEmail(entity.getEmail(),subject,body);
            if(isSent){
                return "Password Send to Registered email";
            }

        }
        return "ERROR";
    }
    private String generatePwd() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    private  String readMailBodyContent(String filename, UserAccountEntity entity){
        String mailBody=null;
        try{
            StringBuffer sb = new StringBuffer();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();//reading first line data
            while(line != null){
                sb.append(line);// appending line data to buffer obj
                line = br.readLine(); //reading next line data
            }
            mailBody = sb.toString();
            mailBody = mailBody.replace("{FNAME}",entity.getFname());
            mailBody = mailBody.replace("{LNAME}",entity.getLname());
            mailBody = mailBody.replace("{TEPM_PWD}",entity.getPwd());
            mailBody = mailBody.replace("{EMAIL}",entity.getEmail());
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return mailBody;
    }
}
