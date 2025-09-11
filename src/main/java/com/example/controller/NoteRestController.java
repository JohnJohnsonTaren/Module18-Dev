package com.example.controller;

import com.example.entity.Note;
import com.example.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes")
public class NoteRestController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> listAllNotes() {
        return ResponseEntity.ok(noteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getById(id);
        return ResponseEntity.ok(note);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        Note createdNote = noteService.add(note);
        return ResponseEntity.ok(createdNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        note.setId(id);
        Note updatedNote = noteService.update(note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}