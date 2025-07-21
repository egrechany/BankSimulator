package com.example.banksim.service;

import com.example.banksim.repository.UserRoles;

import java.util.List;

public interface IInitRolesService {
    public List<UserRoles> getRoles();
}
