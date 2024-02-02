package chardeck.accounting.controllers;

import chardeck.accounting.api.AccountingApiConstants;
import chardeck.accounting.api.RegistrationDto;
import chardeck.accounting.domain.dao.UserRepository;
import chardeck.accounting.model.User;
import chardeck.accounting.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    IUserService iUserService;

    @Autowired
    UserRepository userRepository;

    // "/en/v1/registration"
    @PostMapping(value = AccountingApiConstants.REGISTER)
    public void registerAccount(@RequestBody RegistrationDto accountDto) {

        System.out.println(accountDto.login);
        System.out.println(accountDto.password);
        String login = accountDto.login;
        String pass = encoder.encode(accountDto.password);
        System.out.println("encoded pass = " + pass);
        User user = new User(login, pass);
//        iUserService.save(user);
        System.out.println("new user is saved to database");

//        HashSet<AccountingRoles> roles = new HashSet<AccountingRoles>();
//        roles.add(AccountingRoles.USER);
//        ResponseDto responseDto = new ResponseDto();
//        String token = tokenService.createToken(email, pass, roles);
//        if (token != null) {
//            response.addHeader("X-Token", token);
//        }
//        return resp;
    }

}

