package chardeck.api;

import chardeck.domain.entities.AccountingRoles;

import java.util.HashSet;

public class ResponseDto {
    public String login;
//    public String avatar;
    public HashSet<AccountingRoles> roles;

    public ResponseDto(String login,
//                       String avatar,
                       HashSet<AccountingRoles> roles) {
        super();
        this.login = login;
//        this.avatar = avatar;
        this.roles = roles;
    }

    public ResponseDto() {
    }


}

