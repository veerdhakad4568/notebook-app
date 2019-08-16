package com.mynotebook.app.dao;

import java.util.List;

import com.mynotebook.app.model.Note;

public interface NoteDao {
	List<Note> getNotesByNoteBookId(Integer id);
	void saveNote(Note note);
}
