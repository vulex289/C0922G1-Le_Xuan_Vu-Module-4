package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String get() {
        return "index";
    }

    @PostMapping("/calculator")
    public String showList(@RequestParam double num1, double num2, String calculator, Model model) {
        String result;
        result = Calculator(calculator, num1, num2);
        model.addAttribute("result", result);
        return "index";
    }

    public String Calculator(String calculator, double num1, double num2) {
        double result;
        String resultStr = "";
        switch (calculator) {
            case "Addition(+)":
                result = num1 + num2;
                resultStr = String.valueOf(result);
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                resultStr = String.valueOf(result);
                break;
            case "Multiplication(*)":
                result = num1 * num2;
                resultStr = String.valueOf(result);
                break;
            case "Division(/)":
                if (num2 == 0) {
                    resultStr = "Nhập số thứ 2 phải lớn hơn 0";
                } else {
                    result = num1 / num2;
                    resultStr = String.valueOf(result);
                }
                break;
        }
        return resultStr;
    }
}