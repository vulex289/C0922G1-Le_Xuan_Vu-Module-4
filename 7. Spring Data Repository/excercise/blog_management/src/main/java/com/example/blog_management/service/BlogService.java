package com.example.blog_management.service;


import com.example.blog_management.model.Blog;
import com.example.blog_management.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name,pageable);
    }


    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void editBlog(Blog blog) {
    blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
    blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
    blogRepository.save(blog);
    }
}
