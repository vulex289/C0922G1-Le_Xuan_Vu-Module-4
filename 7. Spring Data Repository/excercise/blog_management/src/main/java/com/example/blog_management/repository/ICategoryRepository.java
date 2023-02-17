package com.example.blog_management.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface ICategoryRepository extends JpaRepository<Locale.Category,Integer> {

}
