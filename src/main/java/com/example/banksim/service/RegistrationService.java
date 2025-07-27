package com.example.banksim.service;

import com.example.banksim.repository.User;
import com.example.banksim.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService{

    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean registerUser(User user) {
        userRepository.save(user);
        return true;
    }
}
