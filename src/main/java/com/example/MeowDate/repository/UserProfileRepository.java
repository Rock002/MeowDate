package com.example.MeowDate.repository;

import com.example.MeowDate.models.User;
import com.example.MeowDate.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Modifying
    @Query("UPDATE UserProfile " +
            "SET firstName = :firstName, " +
            "birthDate = :birthDate, " +
            "sex = :sex, " +
            "location = :location, " +
            "info = :info " +
            "WHERE user = :user")
    void update(@Param("user") User user,
                @Param("firstName") String firstName,
                @Param("birthDate") LocalDate birthDate,
                @Param("sex") char sex,
                @Param("location") String location,
                @Param("info") String info
    );
}
