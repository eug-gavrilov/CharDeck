
//import java.net.URI;
//import java.util.HashSet;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class TokenServiceConnector implements TokenService {
//
//    @Autowired
//    AccountsRepository repo;
//
//    @Override
//    public String createToken(AccountEntity accountEntity) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String endPoint = "http://token.herokuapp.com/validation/en/v1/create/entity";
////		String endPoint = "http://localhost:8082/validation/en/v1/create/entity";
//
//        URI uri;
//        try {
//            uri = new URI(endPoint);
//        } catch (Exception e) {
//            throw new NoContentException();
//        }
//
//        ResponseEntity<String> responseFromCreateToken;
//        try {
//            RequestEntity<AccountEntity> requestToCreateToken = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON)
//                    .body(accountEntity);
//
//            responseFromCreateToken = restTemplate.exchange(uri, HttpMethod.POST,
//                    requestToCreateToken, String.class);
//        } catch (Exception e) {
//            throw new BadTokenException();
//        }
//
//        return responseFromCreateToken.getBody().toString();
//    }
//
//    @Override
//    public String createToken(String email, String pass, HashSet<AccountingRoles> roles) {
//
//        String endPoint = "http://propets-token.herokuapp.com/validation/en/v1/create/email";
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri;
//        try {
//            uri = new URI(endPoint);
//        } catch (Exception e) {
//            throw new NoContentException();
//        }
//        RequestCreateTokenDto dto = new RequestCreateTokenDto(email, pass, roles);
//
//        ResponseEntity<String> responseFromCreateToken;
//        try {
//            RequestEntity<RequestCreateTokenDto> requestToCreateTokenByEmail = RequestEntity.post(uri)
//                    .accept(MediaType.APPLICATION_JSON).body(dto);
//
//            responseFromCreateToken = restTemplate.exchange(uri, HttpMethod.POST,
//                    requestToCreateTokenByEmail, String.class);
//        } catch (Exception e) {
//            throw new BadTokenException();
//        }
//
//        return responseFromCreateToken.getBody().toString();
//    }
//
//    @Override
//    public String validateToken(String token) {
//        String endPoint = "http://propets-token.herokuapp.com/validation/en/v1/validate";
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri;
//        try {
//            uri = new URI(endPoint);
//        } catch (Exception e) {
//            throw new NoContentException();
//        }
//
//        ResponseEntity<String> responseFromValidateToken;
//        try {
//            RequestEntity<String> requestToValidateToken = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON)
//                    .body(token);
//
//            responseFromValidateToken = restTemplate.exchange(uri, HttpMethod.POST,
//                    requestToValidateToken, String.class);
//        } catch (Exception e) {
//            throw new BadTokenException();
//        }
//
//        return responseFromValidateToken.getBody().toString();
//    }
//
//    @Override
//    public String[] decompileToken(String token) {
//        String endPoint = "http://propets-token.herokuapp.com/validation/en/v1/decompile";
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri;
//        try {
//            uri = new URI(endPoint);
//        } catch (Exception e) {
//            throw new NoContentException();
//        }
//
//        ResponseEntity<String[]> responseFromDecompile;
//        try {
//            RequestEntity<String> requestToDecompile = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON)
//                    .body(token);
//
//            responseFromDecompile = restTemplate.exchange(uri, HttpMethod.POST,
//                    requestToDecompile, String[].class);
//        } catch (Exception e) {
//            throw new BadTokenException();
//        }
//        return responseFromDecompile.getBody();
//    }
//
//    @Override
//    public String[] validateAuth(String token) {
//        String endPoint = "http://propets-token.herokuapp.com/validation/en/v1/auth";
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri;
//        try {
//            uri = new URI(endPoint);
//        } catch (Exception e) {
//            throw new NoContentException();
//        }
//
//        ResponseEntity<String[]> responseFromDecompile;
//        try {
//            RequestEntity<String> requestToValidateAuth = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON)
//                    .body(token);
//            responseFromDecompile = restTemplate.exchange(uri, HttpMethod.POST,
//                    requestToValidateAuth, String[].class);
//        } catch (Exception e) {
//            throw new BadTokenException();
//        }
//        return responseFromDecompile.getBody();
//    }
//
//}