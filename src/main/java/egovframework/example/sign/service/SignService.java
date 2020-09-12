package egovframework.example.sign.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface SignService {

	public void register(SignUpVO vo, boolean isLocal) throws Exception;

	List<EgovMap> selectSignServiceList(String id) throws Exception;



}


