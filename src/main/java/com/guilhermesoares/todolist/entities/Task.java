package com.guilhermesoares.todolist.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.guilhermesoares.todolist.entities.enums.TaskPriority;
import com.guilhermesoares.todolist.entities.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private Instant createdAt;
	private Instant finishedAt;
	private Integer taskPriority;
	private Integer taskStatus = TaskStatus.PENDING.getCode();
	private String notes;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User taskOwner;
	
	public Task(){
	}

	public Task(Long id, String description, TaskPriority taskPriority, String notes, User taskOwner) {
		this.id = id;
		this.description = description;
		this.createdAt = Instant.now();
		setTaskPriority(taskPriority);
		this.notes = notes;
		this.taskOwner = taskOwner;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Instant finishedAt) {
		this.finishedAt = finishedAt;
	}

	public TaskPriority getTaskPriority() {
		return TaskPriority.valueOf(taskPriority);
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		if(taskPriority != null) {
			this.taskPriority = taskPriority.getCode();
		}
	}

	public TaskStatus getTaskStatus() {
		return TaskStatus.valueOf(taskStatus);
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		if(taskStatus != null) {
			this.taskStatus = taskStatus.getCode();
		}
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public User getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(User taskOwner) {
		this.taskOwner = taskOwner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", createdAt=" + createdAt + ", finishedAt="
				+ finishedAt + ", taskPriority=" + taskPriority + ", taskStatus=" + taskStatus + ", notes=" + notes
				+ ", taskOwner=" + taskOwner.getName() + "]";
	}
	
	public void finishTask() {
		setFinishedAt(Instant.now());
	}
	
}
