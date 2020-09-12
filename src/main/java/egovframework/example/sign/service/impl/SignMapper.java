package egovframework.example.sign.service.impl;

import java.util.List;

import egovframework.example.sign.service.SignUpVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface SignMapper {

	void register(SignUpVO vo) throws Exception;

	List<EgovMap> selectSignServiceList(String id) throws Exception;

}


