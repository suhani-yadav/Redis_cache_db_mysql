package com.api.redisDemo.services;

import com.api.redisDemo.entities.Note;
import com.api.redisDemo.repositories.NoteRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    //constructor create
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    //save
    @CachePut(value="notes",key = "#note.id")
    public Note createNote(Note note)
    {
        note.setId(UUID.randomUUID().toString());
        return noteRepo.save(note);
    }
    //get
    public List<Note>getAll(){
        return noteRepo.findAll();
    }
    //name of cashe  "users" if not data in redis fetch it fromdb
    @Cacheable(value = "notes",key = "#noteId")
    public  Note getById(String noteId){
        return noteRepo.findById(noteId).orElseThrow(()-> new RuntimeException("note with given id not found"));
    }
    //update
    public  Note updateNote(String noteId,Note note)
    {
        Note note1= noteRepo.findById(noteId).orElseThrow(()-> new RuntimeException("note with given id not found"));
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setLive(note.isLive());
        Note save=noteRepo.save(note1);
        return save;
    }
    //delete
    @CacheEvict(value="notes",key = "noteId")
    public void  delete(String noteId)
    {
        Note note1= noteRepo.findById(noteId).orElseThrow(()-> new RuntimeException("note with given id not found"));
        noteRepo.delete(note1);
    }




}
