package com.api.redisDemo.repositories;

import com.api.redisDemo.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo  extends JpaRepository<Note,String> {



}
