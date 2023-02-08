package com.example.blog_management.repository;

import com.example.blog_management.model.Blog;
import com.example.blog_management.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
