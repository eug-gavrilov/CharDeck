package chardeck.controllers;

import chardeck.api.AccountingApiConstants;
import chardeck.api.RegistrationDto;
import chardeck.api.ResponseDto;
import chardeck.domain.entities.AccountingRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@RestController
public class AccountingController {

    PasswordEncoder encoder;

    // "/account/en/v1/registration"
    @PostMapping(value = AccountingApiConstants.REGISTER)
    public void registerAccount(@RequestBody RegistrationDto accountDto) {

        System.out.println(accountDto.login);
        System.out.println(accountDto.password);

        String email = accountDto.login;
        String pass = encoder.encode(accountDto.password);
        HashSet<AccountingRoles> roles = new HashSet<AccountingRoles>();
        roles.add(AccountingRoles.USER);

        ResponseDto responseDto = new ResponseDto();

//        ResponseDto resp = accounting.registerUser(accountDto);
//        String token = tokenService.createToken(email, pass, roles);
//        if (token != null) {
//            responce.addHeader("X-Token", token);
//        }
//        return resp;
    }

}

