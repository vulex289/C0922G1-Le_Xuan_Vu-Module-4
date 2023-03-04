package com.example.cinema.controller;

import com.example.cinema.dto.CinemaDto;
import com.example.cinema.model.Cinema;
import com.example.cinema.service.ICinemaService;
import com.example.cinema.service.IMoiveNameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CinemaController {
    @Autowired
    private ICinemaService cinemaService;
    @Autowired
    private IMoiveNameService movieNameService;

    @GetMapping("/cinema")
    public String showList(Model model, @RequestParam(defaultValue = "") String date,
                           @RequestParam(defaultValue = "-1") long idMovieName,
                           @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Cinema> cinemas;
        if (idMovieName == -1) {
            cinemas = cinemaService.getAll(pageable, date);
        } else {
            cinemas = cinemaService.getAllByNameMovie(pageable, date, idMovieName);
        }
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("idMovieName", idMovieName);
        model.addAttribute("date", date);
        model.addAttribute("movieNames", movieNameService.findAll());
        model.addAttribute("cinemaDetail", new Cinema());
        if (model.getAttribute("cinemaDtoCreate") != null) {
            model.addAttribute("cinemaDtoCreate", model.getAttribute("cinemaDtoCreate"));
            model.addAttribute("flagCreate", "true");
        } else {
            model.addAttribute("cinemaDtoCreate", new CinemaDto());
            model.addAttribute("flagCreate", "false");
        }
        if (model.getAttribute("cinemaDtoEdit") != null) {
            model.addAttribute("cinemaDtoEdit", model.getAttribute("cinemaDtoEdit"));
            model.addAttribute("flagEdit", "true");
        } else {
            model.addAttribute("cinemaDtoEdit", new CinemaDto());
            model.addAttribute("flagEdit", "false");
        }
        return "list";
    }

    @PostMapping("/delete")
    public String deleteCinema(RedirectAttributes attributes, String idDelete) {
        cinemaService.deleteById(idDelete);
        attributes.addFlashAttribute("msg", "Xoa Thanh cong");
        return "redirect:/cinema";
    }

    @PostMapping("/create")
    public String createCinema(@Validated @ModelAttribute CinemaDto cinemaDtoCreate, BindingResult bindingResult, RedirectAttributes attributes) {
        new CinemaDto().validate(cinemaDtoCreate, bindingResult);
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("cinemaDto", cinemaDtoCreate);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.cinemaDto", bindingResult);
            return "redirect:/cinema";
        }
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaDtoCreate, cinema);
        cinemaService.save(cinema);
        attributes.addFlashAttribute("msg", "Tao moi Thanh cong");
        return "redirect:/cinema";
    }

    @PostMapping("/edit")
    public String editCinema(@Validated @ModelAttribute CinemaDto cinemaDtoEdit, BindingResult bindingResult, RedirectAttributes attributes) {
        new CinemaDto().validate(cinemaDtoEdit, bindingResult);
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("cinemaDtoEdit", cinemaDtoEdit);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.cinemaDtoEdit", bindingResult);
            return "redirect:/cinema";
        }
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaDtoEdit, cinema);
        cinemaService.save(cinema);
        attributes.addFlashAttribute("msg", "Sua Thanh cong");
        return "redirect:/cinema";
    }
}
