package com.homelibrary.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homelibrary.domain.Book;
import com.homelibrary.service.BookService;

@Controller
@RequestMapping("/image")
public class BookImageController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book")
	public void getBookImage(@RequestParam("id") Integer bookId, HttpServletResponse response) throws IOException {
		Book book = bookService.getBookById(bookId);
		response.setContentType("image/png");
		String headerValue = String.format("inline; filename=%s.png", book.getTitle());
		response.setHeader("Content-Disposition", headerValue);
		response.getOutputStream().write(book.getBookImage());
		response.getOutputStream().close();
	}

}
