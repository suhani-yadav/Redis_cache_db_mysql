package com.api.redisDemo.controllers;


import com.api.redisDemo.entities.Note;
import com.api.redisDemo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.redis.connection.ReactiveStreamCommands.AddStreamRecord.body;

@RestController
@RequestMapping("/api/v1")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //create
    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        return  ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
    }

    //get
    @GetMapping
    public ResponseEntity<List<Note>>getAll(){
        return ResponseEntity.ok(noteService.getAll());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getSingle(@PathVariable String noteId){
        return ResponseEntity.ok(noteService.getById(noteId));
    }

    //delete
    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String noteId){
        noteService.delete(noteId);
    }

}
