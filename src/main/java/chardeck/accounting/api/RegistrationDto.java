package chardeck.accounting.api;

public class RegistrationDto {

    public String login;
    public String password;

    public RegistrationDto(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public RegistrationDto() {
        super();
    }

}