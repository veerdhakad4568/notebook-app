package com.mynotebook.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mynotebook.app.model.Note;
import com.mynotebook.app.model.NoteBook;
import com.mynotebook.app.repository.NoteBookRepository;
import com.mynotebook.app.request.NoteRequest;

@Component
public class RequestMapper {
	
	@Autowired
	private NoteBookRepository notebookRepository;
	
	public Note mapToNote(NoteRequest NoteRequest) {
	        NoteBook notebook = notebookRepository.findById(new Integer(NoteRequest.getNotebookId())).get();
	        Note note = new Note(NoteRequest.getTitle(), NoteRequest.getText(), notebook);
	        return note;
	    }
}
