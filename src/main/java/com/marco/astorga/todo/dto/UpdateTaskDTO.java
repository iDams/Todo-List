package com.marco.astorga.todo.dto;

public class UpdateTaskDTO {


	private Long id;
	
    private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UpdateTaskDTO [id=" + id + ", status=" + status + "]";
	}









    
}