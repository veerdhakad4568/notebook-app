package com.mynotebook.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynotebook.app.model.Note;
import com.mynotebook.app.model.NoteBook;



public interface NoteRepository extends JpaRepository<Note, Integer> {

	List<Note> findAllByNoteBook(NoteBook noteBook);

}
