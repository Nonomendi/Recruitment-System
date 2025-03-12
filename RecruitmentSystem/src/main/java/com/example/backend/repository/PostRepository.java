package com.example.backend.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByClosingDateLessThan(Date currentDate);
}
