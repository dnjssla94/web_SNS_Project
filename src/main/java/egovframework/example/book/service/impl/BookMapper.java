package egovframework.example.book.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface BookMapper {

	List<EgovMap> selectBookServiceList() throws Exception;


}


