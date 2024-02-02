package chardeck.accounting.service;

import chardeck.accounting.model.User;
import chardeck.accounting.domain.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return new ArrayList<User>(userRepository.findAll());
    }

    @Override
    public void save(User user) {
        System.out.println("reached service impl");
        userRepository.save(user);
    }
}