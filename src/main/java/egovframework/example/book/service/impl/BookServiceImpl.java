package egovframework.example.book.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.book.service.BookService;
import egovframework.example.main.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class BookServiceImpl implements BookService{
	
	@Resource
	private BookMapper bookMapper;

	@Override
	public List<EgovMap> selectBookServiceList() throws Exception {
	
		return bookMapper.selectBookServiceList();
	}
	
	

}
