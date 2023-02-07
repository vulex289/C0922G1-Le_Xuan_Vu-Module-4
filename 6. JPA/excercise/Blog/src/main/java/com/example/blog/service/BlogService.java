package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
