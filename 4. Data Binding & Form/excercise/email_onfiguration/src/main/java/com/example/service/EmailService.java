package com.example.service;

import com.example.model.Email;
import com.example.repository.EmailRepository;
import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService{
    IEmailRepository emailRepository = new EmailRepository();
    @Override
    public List<String> showLanguages() {
        return emailRepository.showLanguages();
    }

    @Override
    public List<Integer> showPageSize() {
        return emailRepository.showPageSize();
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void edit(Email email) {
    emailRepository.edit(email);
    }
}
