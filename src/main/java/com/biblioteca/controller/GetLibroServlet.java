package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "getlibro", value = "/getlibro")
public class GetLibroServlet extends HttpServlet {
	private String isbn;
	private ObjectMapper mapper;

	public void init() {
		isbn = "";
		mapper = new ObjectMapper();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		mapper.registerModule(new JavaTimeModule());

		isbn = request.getParameter("isbn");

		Libro libro = Libros.select(isbn);
		String json;
		if (libro == null) {
			json = mapper.writeValueAsString("Libro no encontrado");
		} else {
			json = mapper.writeValueAsString(libro);
		}
		out.write(json);
	}
}
