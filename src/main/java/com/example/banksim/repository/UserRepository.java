package com.example.banksim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = """
            SELECT * FROM UserRoles Where username = :name;
            """,nativeQuery = true)
    public User getUserByName(@Param("name") String name);

}
