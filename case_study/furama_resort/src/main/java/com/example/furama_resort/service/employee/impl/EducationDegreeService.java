package com.example.furama_resort.service.employee.impl;
import com.example.furama_resort.model.employee.EducationDegree;
import com.example.furama_resort.repository.employee.IEducationIDegreeRepository;
import com.example.furama_resort.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationIDegreeRepository educationIDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationIDegreeRepository.findAll();
    }
}
