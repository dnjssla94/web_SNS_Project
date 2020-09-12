package egovframework.example.main.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface MainMapper {

	List<EgovMap> selectMainServiceList() throws Exception;


}


