package com.example.blog_management_restful.repository;


import com.example.blog_management_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);
    @Query(value = "select * from blog where category_id = :id",nativeQuery = true)
    Page<Blog> findByCategory(@Param("id") int id,Pageable pageable);

    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
