package egovframework.example.sign.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import egovframework.example.sign.service.SignService;
import egovframework.example.sign.service.SignUpVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class SignServiceImpl implements SignService{
	
	@Inject 
	SignMapper dao;

	@Resource
	private SignMapper signMapper;
	
	@Override
	public void register(SignUpVO vo,  boolean isLocal) throws Exception {
		dao.register(vo);
		
	}

	@Override
	public 	List<EgovMap> selectSignServiceList(String id) throws Exception {
		
		return signMapper.selectSignServiceList(id);
	}
}
