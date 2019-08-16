package com.mynotebook.app.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mynotebook.app.model.NoteBook;
import com.mynotebook.app.repository.NoteBookRepository;


@Repository("NoteBookDao")
public class NoteBookDaoImpl  implements NoteBookDao{

    @Autowired
    private NoteBookRepository noteBookRepository;
    
	@Override
	public void saveNoteBook(NoteBook noteBook) {
		noteBookRepository.save(noteBook);
	}

	@Override
	public List<NoteBook> getAllNoteBook() {
		return noteBookRepository.findAll();
	}
 
	@Override
	public NoteBook getNoteBookById(Integer id) {
		 NoteBook noteBook=null;
		 try {
		 noteBook=noteBookRepository.getOne(id);
		 }catch(EntityNotFoundException e)
		 {
			 
		 }
		 return noteBook;
	}
	
	@Override
	public void deleteNoteBookById(Integer id) {
		noteBookRepository.deleteById(id);
	}

}
