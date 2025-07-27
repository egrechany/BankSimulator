package com.example.banksim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = """
            SELECT * FROM UserRoles Where username = :name;
            """,nativeQuery = true)
    public User getUserByName(@Param("name") String name);

    @Query(value = """
            INSERT INTO
            """,nativeQuery = true)
    public Boolean registerUser(@Param("fullname") String fullname,
                                @Param("email") String email,
                                @Param("phonenumber") String phonenumber,
                                @Param("dateofbirth") LocalDateTime dateofbirth,
                                @Param("passportNumber") String passportNumber,
                                @Param("tinNumber") String tinNumber,
                                @Param("registrationaddress") String registrationaddress);

}
