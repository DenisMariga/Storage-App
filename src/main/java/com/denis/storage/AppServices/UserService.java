package com.denis.storage.AppServices;

import com.denis.storage.Models.Users;
import com.denis.storage.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void save(Users users) {

        repo.save(users);
    }

    public Users getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Optional<Users> getUserById(Long userid) {
        return repo.findById(userid);
    }
}
