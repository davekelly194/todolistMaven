package com.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodolistApplication {
	public static List<Task> taskList;

	public static void main(String[] args) {
		taskList = new ArrayList<Task>();
		SpringApplication.run(TodolistApplication.class, args);
	}
}
