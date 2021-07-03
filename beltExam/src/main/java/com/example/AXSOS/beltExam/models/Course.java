package com.example.AXSOS.beltExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Courses")
public class Course {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=3, max=255, message="Course name is requird")
    @NotNull
    private String title;
    
    @Size(min=3,max=255, message="Instructor name is required")
    @NotNull
    private String firstName;
    
    private Integer signUps;
  
    
    
    @NotNull
    private Integer capacity;
    
    
    public Integer getSignUps() {
		return signUps;
	}
	public void setSignUps(Integer signUps) {
		this.signUps = signUps;
	}

    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_course", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> joining;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Course() {
		
	}

	public Course( String title,
			 String firstName,
			Integer signUps,  Integer capacity, List<User> joining) {
		
		this.title = title;
		this.firstName = firstName;
		this.signUps = signUps;
		this.capacity = capacity;
		
		this.joining = joining;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}



	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<User> getJoining() {
		return joining;
	}
	public void setJoining(List<User> joining) {
		this.joining = joining;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
    
    

}
