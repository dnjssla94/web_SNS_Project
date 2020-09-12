package egovframework.example.sight.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface SightMapper {

	List<EgovMap> selectSightServiceList() throws Exception;


}


