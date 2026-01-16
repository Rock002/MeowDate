package com.example.MeowDate.repository;

import com.example.MeowDate.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByUserId(long userId);
}
