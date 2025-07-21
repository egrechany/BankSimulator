package com.example.banksim.service;

import com.example.banksim.repository.UserRoles;
import com.example.banksim.repository.UserRolesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class InitRolesService implements IInitRolesService{

    private final UserRolesRepository userRolesRepository;

    public InitRolesService(UserRolesRepository userRolesRepository){this.userRolesRepository = userRolesRepository;}

    @Override
    public List<UserRoles> getRoles() {
        return userRolesRepository.getUserRoles();
    }
}
