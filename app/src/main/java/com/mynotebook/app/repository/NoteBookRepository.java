package com.mynotebook.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynotebook.app.model.NoteBook;

public interface NoteBookRepository extends JpaRepository<NoteBook, Integer>{
  
}
