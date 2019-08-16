package com.mynotebook.app.dao;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.mynotebook.app.model.NoteBook;

@Repository
public interface NoteBookDao  {
    public void saveNoteBook(NoteBook noteBook);
    public List<NoteBook> getAllNoteBook();
	NoteBook getNoteBookById(Integer id);
	void deleteNoteBookById(Integer id);
}
