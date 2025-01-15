package com.biblioteca.prestamo.controller;

import com.biblioteca.prestamo.model.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "getalllibro", value = "/getalllibro")
public class GetAllLibroServlet extends HttpServlet {
	private ObjectMapper mapper;

	public void init() {
		mapper = new ObjectMapper();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		mapper.registerModule(new JavaTimeModule());

		List<Libro> libros = Libros.selectAll();
		String json;
		if (libros.isEmpty()) {
			json = mapper.writeValueAsString("No hat libros en la base de datos");
		} else {
			json = mapper.writeValueAsString(libros);
		}
		out.write(json);
	}
}
