package com.example.blog_management_restful.repository;


import com.example.blog_management_restful.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
