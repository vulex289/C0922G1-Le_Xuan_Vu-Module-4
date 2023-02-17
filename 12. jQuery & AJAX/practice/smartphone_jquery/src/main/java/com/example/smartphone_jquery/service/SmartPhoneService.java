package com.example.smartphone_jquery.service;

import com.example.smartphone_jquery.model.Smartphone;
import com.example.smartphone_jquery.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(long id) {
        smartPhoneRepository.deleteById(id);
    }
}
