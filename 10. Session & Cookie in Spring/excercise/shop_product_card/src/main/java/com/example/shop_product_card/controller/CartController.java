package com.example.shop_product_card.controller;

import com.example.shop_product_card.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cart) {
        return new ModelAndView("shopping-cart", "cart", cart);
    }
}
