package com.yafimchyk.draft.controller;

import com.yafimchyk.draft.dto.NoteDTO;
import com.yafimchyk.draft.entity.Note;
import com.yafimchyk.draft.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/new")
    public ResponseEntity<Note> addNote(@RequestBody NoteDTO noteDTO) {
        return new ResponseEntity<>(noteService.create(noteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/upd")
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.update(note), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public HttpStatus deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return HttpStatus.OK;
    }

}
