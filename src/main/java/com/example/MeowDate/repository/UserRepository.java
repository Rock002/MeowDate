package com.example.MeowDate.repository;

import com.example.MeowDate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("UPDATE User " +
            "SET username = :username, " +
            "password = :password, " +
            "email = :email " +
            "WHERE id = :id")
    void update(@Param("id") Long id,
                @Param("username") String username,
                @Param("password") String password,
                @Param("email") String email
    );
}
