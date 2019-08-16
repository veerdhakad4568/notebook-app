package com.mynotebook.app.mapper;

import org.springframework.stereotype.Component;

import com.mynotebook.app.model.Note;
import com.mynotebook.app.model.NoteBook;
import com.mynotebook.app.response.NoteResponse;
import com.mynotebook.app.response.NotebookResponse;

@Component
public class ResponseMapper {

	 public NoteResponse mapToNoteResponse(Note note) {
	        NoteResponse noteResponse = new NoteResponse();
	        noteResponse.setTitle(note.getTitle());
	        noteResponse.setId(note.getId().toString());
	        noteResponse.setCreatedDate(note.getCreatedDate());
	        noteResponse.setLastUpdatedDate(note.getLastUpdatedDate());
	        noteResponse.setText(note.getText());
	        noteResponse.setNotebookId(note.getNotebook().getId().toString());
	        return noteResponse;
	    }
	 public NotebookResponse mapToNotebookResponse(NoteBook notebook) {
		 NotebookResponse notebookResponse=new NotebookResponse();
		 notebookResponse.setId(notebook.getId().toString());
		 notebookResponse.setName(notebook.getName());
		 return notebookResponse;
		 
	 }

}
