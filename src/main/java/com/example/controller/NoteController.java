package com.example.controller;

import com.example.entity.Note;
import com.example.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/create")
    public String createNote(@Valid @ModelAttribute Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "note/create"; // Повернути користувача на форму з помилками
        }
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("note", new Note());
        return "note/create";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String updateNote(@Valid @ModelAttribute Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "note/edit"; // Повернути користувача на форму з помилками
        }
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}




















