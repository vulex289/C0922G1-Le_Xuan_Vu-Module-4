package com.example.blog_management_restful.service;

import com.example.blog_management_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findByNameContaining(String name, Pageable pageable);
    Blog findById(int id);
    void editBlog(Blog blog);
    void deleteBlog(int id);
    void save(Blog blog);
    Page<Blog> findByCategory( int id,Pageable pageable);

}
