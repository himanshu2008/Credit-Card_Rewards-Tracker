package com.project2008.credit_card_rewards;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<User>();

    List<User> findAll() {
        return users;
    }

    Optional<User> findByUsername(String username) {
        return users.stream()
        .filter(user -> user.username().equals(username))
        .findFirst();
    }

    void create(User user) {
        users.add(user);
    }

    void update(User user, String username) {
        Optional<User> expectedUser = findByUsername(username);
        if (expectedUser.isPresent()) {
            users.set(users.indexOf(expectedUser.get()), user);
        }
    }

    void delete(String username) {
        users.removeIf(user -> user.username().equals(username));
    }

    @PostConstruct
    public void init() {
        users.add(new User("UsernameTest1", 
        "FirstNameTest1", 
        "LastNameTest1", 
        "PasswordTest1"));

        users.add(new User("UsernameTest2",
        "FirstNameTest2",
        "LastNameTest2",
        "PasswordTest2"));
    }
}