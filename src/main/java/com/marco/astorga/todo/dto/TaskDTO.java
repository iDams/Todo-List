package com.marco.astorga.todo.dto;

public class TaskDTO {


    private String username;

    private String name;

    private String description;

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TaskDTO [description=" + description + ", name=" + name + ", username=" + username + "]";
	}

    
}