package chardeck.accounting.service;

import chardeck.accounting.model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    void save(User user);
}