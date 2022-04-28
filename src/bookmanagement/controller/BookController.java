package bookmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookmanagement.dao.BookDAO;
import bookmanagement.dto.BookRequestDTO;
import bookmanagement.dto.BookResponseDTO;
import bookmanagement.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;

	@RequestMapping("/")
	public String display(ModelMap model) {
		ArrayList<BookResponseDTO> list = dao.selectAll();
		model.addAttribute("list", list);
		return "display";
	}

	@RequestMapping("/setupAddBook")
	public ModelAndView setupAddBook() {
		return new ModelAndView("addBook", "bean", new Book());
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bean") Book book, ModelMap model) {
		BookRequestDTO dto = new BookRequestDTO();
		if (dao.checkId(book.getCode())) {
			model.addAttribute("error", "ID already exists");
			return "addBook";
		}
		dto.setCode(book.getCode());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(Double.valueOf(book.getPrice()));
		dto.setTitle(book.getTitle());
		dao.insertData(dto);
		return "redirect:/";
	}

	@RequestMapping("/setupUpdateBook/{code}")
	public ModelAndView setupUpdateBook(@PathVariable String code, ModelMap model) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setCode(code);
		return new ModelAndView("update", "bean", dao.selectOne(dto));
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("bean") Book book, ModelMap model) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setCode(book.getCode());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(Double.valueOf(book.getPrice()));
		dto.setTitle(book.getTitle());
		dao.updateData(dto);
		return "redirect:/";
	}

	@RequestMapping("/deleteBook/{code}")
	public String deleteBook(@PathVariable String code) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setCode(code);
		dao.deleteData(dto);
		return "redirect:/";
	}

}
