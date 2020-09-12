package egovframework.example.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.main.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class MainServiceImpl implements MainService{
	
	@Resource
	private MainMapper mainMapper;

	@Override
	public List<EgovMap> selectMainServiceList() throws Exception {
	
		return mainMapper.selectMainServiceList();
	}
	
	

}
