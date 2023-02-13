package com.example.booklibrary.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    static int count1 = 0;
    static int count2 = 0;

    @Pointcut(value = "within(com.example.booklibrary.controller.BookController)")
    public void visitLibrary() {
    }

    @After(value = "visitLibrary()")
    public void afterExecuteController() {
        count1++;
        System.out.println("Số lượt người ghé thăm" + " " + count1);
    }

    @Pointcut("execution(* com.example.booklibrary.controller.BookController.borrow(..))" +
            "||execution(* com.example.booklibrary.controller.BookController.pay(..))")
    public void showChange() {
    }

    @After(value = "showChange()")
    public void afterChange() {
        count2++;
        System.out.println("Trạng thái sách đã thay đổi lần:" + " " + count2);
    }
}
