package com.example.banksim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,String> {
    @Query(value = """
            SELECT * FROM UserRoles
            """,nativeQuery = true)
    public List<UserRoles> getUserRoles();
}
