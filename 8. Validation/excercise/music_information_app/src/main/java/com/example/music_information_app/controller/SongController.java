package com.example.music_information_app.controller;

import com.example.music_information_app.model.Song;
import com.example.music_information_app.model.SongDto;
import com.example.music_information_app.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("/song")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "/list";
    }

    @GetMapping("/song/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/song/save")
    public String save(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
        Song song = new Song();
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "create";
        }else {
            BeanUtils.copyProperties(songDto, song);
            attributes.addFlashAttribute("msg", "Tạo mới thành công");
            songService.save(song);
            return "redirect:/song";
        }
    }
    @GetMapping("/song/edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id){
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(songService.findById(id),songDto);
        model.addAttribute("songDto",songDto);
        return "edit";
    }
    @PostMapping("/song/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto,BindingResult bindingResult,Model model,RedirectAttributes attributes){
        Song song = new Song();
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "edit";
        }
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        attributes.addFlashAttribute("msg","Sửa thành công");
        return "redirect:/song";
    }
}
