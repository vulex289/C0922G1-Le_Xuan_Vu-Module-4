package com.example.blog_management.repository;

import com.example.blog_management.model.Blog;
import com.example.blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
