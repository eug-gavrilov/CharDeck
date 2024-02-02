//package telran.validation.service.impl;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Base64;
//import java.util.HashSet;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import telran.validation.api.codes.NotExistsException;
//import telran.validation.api.codes.TokenExpiredException;
//import telran.validation.dao.AccountsRepository;
//import telran.validation.domain.entities.AccountEntity;
//import telran.validation.domain.entities.AccountingRoles;
//import telran.validation.service.interfaces.ITokenService;
//
//@Service
//public class JWTTokenServiceImpl implements ITokenService{
//
//    @Autowired
//    AccountsRepository repo;
//
//    String secret = "ProPetsEvgeniiMichael19911995";
//
//    @Override
//    public String createToken(AccountEntity accountEntity) {
//        return createToken(accountEntity.getEmail(), accountEntity.getPass(), accountEntity.getRoles());
//    }
//
//    @Override
//    public String createToken(String email, String pass, HashSet<AccountingRoles> roles) {
//        Instant time = Instant.now();
//        return Jwts.builder().claim("login", email).claim("password", pass)
//                .claim("timestamp", time.plus(30, ChronoUnit.DAYS).toEpochMilli())
//                .claim("role", roles).signWith(SignatureAlgorithm.HS256, secret).compact();
//    }
//
//    @Override
//    public String validateToken(String token) {
//        Jws<Claims> jws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//        Claims claims = jws.getBody();
//
//        String login = claims.get("login").toString();
//        AccountEntity user = repo.findById(login).orElse(null);
//
//        if(user == null) {
//            throw new NotExistsException();
//        }
//
//        Instant time = Instant.ofEpochMilli(Long.parseLong("" + claims.get("timestamp")));
//
//        if (time.isBefore(Instant.now())) {
//            throw new TokenExpiredException();
//        }
//
//        claims.put("timestamp", Instant.now().plus(30, ChronoUnit.DAYS).toEpochMilli());
//        token = Jwts.builder().setClaims(claims).compact();
//
//        return token;
//    }
//
//    @Override
//    public String[] decompileToken(String token) {
//        Claims claims;
//        try {
//            Jws<Claims> jws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            claims = jws.getBody();
//        } catch (Exception e) {
//            throw new NotExistsException();
//        }
//        String[] res = new String[4];
//        res[0] = claims.get("login").toString();
//        res[1] = claims.get("password").toString();
//        res[2] = claims.get("timestamp").toString();
//        String roles = claims.get("role").toString();
//        res[3] = roles.substring(1, roles.length()-1);
//        //[login, pass, 3463457, "USER, ADMIN"]
//        return res;
//    }
//
//    @Override
//    public String[] validateAuth(String token) {
//        token = token.split(" ")[1];
//        String[] credentials = new String(Base64.getDecoder().decode(token)).split(":");
//        return credentials;
//    }
//
//}