package com.mynotebook.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mynotebook.app.model.Note;
import com.mynotebook.app.model.NoteBook;
import com.mynotebook.app.repository.NoteBookRepository;
import com.mynotebook.app.repository.NoteRepository;

@Repository("NoteDao")
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private NoteRepository noteRepository ;
	
	@Autowired
    private NoteBookRepository noteBookRepository;
    
	@Override
	public List<Note> getNotesByNoteBookId(Integer id) {
		
		Optional<NoteBook> noteBook=noteBookRepository.findById(id);
		List<Note> note =new ArrayList<Note>();
		if(noteBook.isPresent())
		{
			 note=noteRepository.findAllByNoteBook(noteBook.get());	
		}
		return note;
	}

	@Override
	public void saveNote(Note note) {
		
		noteRepository.save(note);
		
	}

}
