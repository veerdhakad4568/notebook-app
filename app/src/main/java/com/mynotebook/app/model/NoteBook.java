package com.mynotebook.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Notebook")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NoteBook  implements Serializable{
	
	private static final long serialVersionUID = 3734264111797896402L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="noteBook",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Note> notes;
	
	
	public NoteBook() {
		this.notes=new ArrayList<Note>();
	}
	
	 public NoteBook(String name) {
	        this();
	        this.name = name;
	    }

	    public NoteBook(Integer id, String name) {
	        this();
	            this.id = id;
	        this.name = name;
	    }


	    public Integer getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public List<Note> getNotes() {
	        return notes;
	    }

	    public int getNbOfNotes() {
	        return this.notes.size();
	    }	

}
