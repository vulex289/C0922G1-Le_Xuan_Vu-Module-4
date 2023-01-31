package com.codegym.service;

import com.codegym.repository.DictionaryRepository;
import com.codegym.repository.IDictionaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    IDictionaryRepository dictionaryRepository = new DictionaryRepository();
    @Override
    public String search(String name) {
        return dictionaryRepository.search(name);
    }
}
