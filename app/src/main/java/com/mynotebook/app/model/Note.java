package com.mynotebook.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Note")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Note implements Serializable {
  
	  
	    private static final long serialVersionUID = -2813185210497916021L;
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
 	    private Integer id;
	    private String title;
	    private String text;
	
	    @ManyToOne(fetch = FetchType.LAZY)
	    private NoteBook noteBook;
	    
	    private Date createdDate;
	    
	    private Date lastUpdatedDate;
	    
	 

		public Note(String title, String text, NoteBook noteBook, Date createdDate, Date lastUpdatedDate) {
			super();
			this.title = title;
			this.text = text;
			this.noteBook = noteBook;
			this.createdDate = createdDate;
			this.lastUpdatedDate = lastUpdatedDate;
		}

		public Note() {
	    	this.createdDate=new Date();
	    	this.lastUpdatedDate=new Date();
	    }
       
	    public Note(String title, String text, NoteBook notebook) {
	        this();
	        this.title = title;
	        this.text = text;
	        this.noteBook = notebook;
	    }

	    public Note(Integer id, String title, String text, NoteBook notebook) {
	        this(title, text, notebook);
	            this.id = id;
	        
	    }


	    public Integer getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getText() {
	        return text;
	    }

	    public NoteBook getNotebook() {
	        return noteBook;
	    }

	    public Integer getNotebookId() {
	        return this.noteBook.getId();
	    }

	   public Date getCreatedDate() {
		    return createdDate;
	   }

	   public Date getLastUpdatedDate() {
		  return lastUpdatedDate;
	   }

	   public void setLastUpdatedDate(Date lastUpdatedDate) {
		   this.lastUpdatedDate = lastUpdatedDate;
	   }


}
