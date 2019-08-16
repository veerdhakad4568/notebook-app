package com.mynotebook.app.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotebook.app.dao.NoteDao;
import com.mynotebook.app.mapper.RequestMapper;
import com.mynotebook.app.mapper.ResponseMapper;
import com.mynotebook.app.model.Note;
import com.mynotebook.app.request.NoteRequest;
import com.mynotebook.app.response.NoteResponse;



@RestController
@RequestMapping("api/v1/note")
public class NoteController {

	@Autowired
	private NoteDao noteDao; 
	
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private ResponseMapper responseMapper;
	
	@GetMapping("/getnotesbynotebookid/{notebookId}")
	public ResponseEntity<List<NoteResponse>> byNotebook(@PathVariable Integer notebookId) {
		List<NoteResponse> response=new ArrayList<NoteResponse>();
		List<Note> notes= noteDao.getNotesByNoteBookId(notebookId);
		if(notes==null||notes.size()==0)
		{
			return new ResponseEntity<List<NoteResponse>>(response,HttpStatus.OK);
		}
		response=notes.stream().map(n-> responseMapper.mapToNoteResponse(n)).collect(Collectors.toList());
		return new ResponseEntity<List<NoteResponse>>(response,HttpStatus.OK);
		

	}
	@PostMapping("/addnote")
	public ResponseEntity<String> addNoteBook(@RequestBody NoteRequest noteRequest,BindingResult bindingResult) {
		
		 if (bindingResult.hasErrors()) {
	            throw new ValidationException();
	        }
		Note note=requestMapper.mapToNote(noteRequest);
		noteDao.saveNote(note);
		return new ResponseEntity<String>("Note added successfully",HttpStatus.OK);
	}
}

