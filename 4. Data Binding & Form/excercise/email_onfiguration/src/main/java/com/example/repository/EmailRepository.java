package com.example.repository;

import com.example.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{
     static List<Email>emailList ;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1,"lexuanvu70@gmail.com","EngLish",5,false,"Vu"));
        emailList.add(new Email(2,"maitagiau@gmail.com","VietNam",10,true,"Haaaaa"));
        emailList.add(new Email(3,"nghisebuon@gmail.com","Spanish",15,false,"ádasdasd"));
    }
    @Override
    public List<String> showLanguages() {
        List<String>languages= new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    @Override
    public List<Integer> showPageSize() {
        List<Integer>pageSize= new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        return pageSize;
    }

    @Override
    public Email findById(int id) {
        Email email = null;
        for (Email email1:emailList) {
            if (email1.getId()==id){
                email = email1;
                break;
            }
        }
        return email;
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void edit(Email email) {
        for (Email email1:emailList) {
            if (email1.getId()==email.getId()){
                email1.setLanguage(email.getLanguage());
                email1.setPageSize(email.getPageSize());
                email1.setSpamsFilter(email.isSpamsFilter());
                email1.setSignature(email.getSignature());
                break;
            }
        }
    }
}
