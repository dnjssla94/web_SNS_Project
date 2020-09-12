package egovframework.example.book.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.book.service.BookService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class BookController {

	@Resource
	private BookService bookService;
	
	@RequestMapping(value = "/book.do")
	public String bookInit(ModelMap model) throws Exception {	
		
		int listLength = 0;
		List<EgovMap> bookListReverse = new ArrayList<EgovMap>();
		List<EgovMap> bookList = bookService.selectBookServiceList();
		
		for (listLength = bookList.size()-1; listLength >= 0 ; listLength--) {
			bookListReverse.add(bookList.get(listLength));
		}

		model.addAttribute("bookImagesList", bookListReverse);
		return "book/book.tiles";
	}
}