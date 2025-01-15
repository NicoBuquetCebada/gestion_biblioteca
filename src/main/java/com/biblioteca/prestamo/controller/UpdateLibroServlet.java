package com.biblioteca.prestamo.controller;

import com.biblioteca.prestamo.model.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "updatelibro", value = "/updatelibro")
public class UpdateLibroServlet extends HttpServlet {
	private String isbn;
	private String titulo;
	private String autor;
	private ObjectMapper mapper;

	public void init() {
		isbn = "";
		titulo = "";
		autor = "";
		mapper = new ObjectMapper();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		mapper.registerModule(new JavaTimeModule());

		isbn = request.getParameter("isbn");
		titulo = request.getParameter("titulo");
		autor = request.getParameter("autor");
		Libro libro = Libros.update(isbn, titulo, autor);
		String json;
		if (libro == null) {
			json = mapper.writeValueAsString("Libro no encontrado");
		} else {
			json = mapper.writeValueAsString(libro);
		}
		out.write(json);
	}
}
