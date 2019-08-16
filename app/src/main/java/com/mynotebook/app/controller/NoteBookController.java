package com.mynotebook.app.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynotebook.app.dao.NoteBookDao;
import com.mynotebook.app.mapper.ResponseMapper;
import com.mynotebook.app.model.NoteBook;
import com.mynotebook.app.response.NotebookResponse;

@RestController
@RequestMapping("api/v1/notebook")
public class NoteBookController {
  
	@Autowired
	private NoteBookDao noteBookDao;
	
	@Autowired
	private ResponseMapper responseMapper;
	
	@PostMapping("/addnotebook")
	public ResponseEntity<String> addNoteBook(@Valid @RequestBody NoteBook noteBook) {
	   noteBookDao.saveNoteBook(noteBook);
	   return ResponseEntity.ok().body("NoteBook created");
	}
	
	@GetMapping("/getallnotebook")
	public List<NoteBook> getAllNoteBook(){
		return noteBookDao.getAllNoteBook();	
	}
	
	@GetMapping("/getnotebook/{id}")
	public ResponseEntity<NotebookResponse> getNoteBookById(@PathVariable Integer id){
		NoteBook noteBook= noteBookDao.getNoteBookById(id);
		
		NotebookResponse notebookResponse=responseMapper.mapToNotebookResponse(noteBook);
		if(noteBook==null)
		{
			return ResponseEntity.ok().body(notebookResponse);
		}
		return ResponseEntity.ok().body(notebookResponse);
	}
	
	@DeleteMapping("/deletenotebookbyid/{id}")
	public ResponseEntity<NoteBook> deleteNoteBookById(@PathVariable(value="id")Integer id){
		NoteBook noteBook= noteBookDao.getNoteBookById(id);
		if(noteBook==null)
		{
			return ResponseEntity.notFound().build();
		}
		noteBookDao.deleteNoteBookById(id);
		return ResponseEntity.ok().body(noteBook);
	}
}
