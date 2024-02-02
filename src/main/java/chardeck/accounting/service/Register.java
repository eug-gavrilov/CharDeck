//package chardeck.service;
//
//public class Register {
//
//    @Override
//    public ResponseDto registerUser(RegistrationDto registrationDto) {
//        if (!checkRegistrationDto(registrationDto)) {
//            throw new NoContentException();
//        }
//
//        if (repository.existsById(registrationDto.email)) {
//            throw new AlreadyExistsException();
//        }
//
//        String pass = encoder.encode(registrationDto.password);
//        AccountEntity newUser = new AccountEntity(registrationDto.email, registrationDto.name, pass);
//
//        repository.save(newUser);
//        ResponseDto responseDto = new ResponseDto(newUser.getEmail(), newUser.getName(), newUser.getAvatar(),
//                newUser.getPhone(), newUser.getRoles());
//
//        return responseDto;
//    }
//}
