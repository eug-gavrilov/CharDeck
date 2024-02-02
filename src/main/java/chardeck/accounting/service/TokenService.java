package chardeck.accounting.service;

import java.util.Base64;
import java.util.HashSet;

import chardeck.accounting.domain.entities.AccountingRoles;
import chardeck.accounting.model.User;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

	String createToken(User user);
	String createToken(String email, String pass, HashSet<AccountingRoles> roles);
	String validateToken(String token);
	String[] decompileToken(String token);

	default String[] validateAuth(String token) {
		token = token.split(" ")[1];
		String[] credentials = new String(Base64.getDecoder().decode(token)).split(":");
		return credentials;
	}
}
