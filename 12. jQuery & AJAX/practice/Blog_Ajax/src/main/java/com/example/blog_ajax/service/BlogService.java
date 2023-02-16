package com.example.blog_ajax.service;


import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return null;
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

    @Override
    public List<Blog> findByContentContaining(String content) {
        return blogRepository.findByContentContaining(content);
    }
}

