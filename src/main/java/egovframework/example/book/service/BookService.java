package egovframework.example.book.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface BookService {

	List<EgovMap> selectBookServiceList() throws Exception;


}


