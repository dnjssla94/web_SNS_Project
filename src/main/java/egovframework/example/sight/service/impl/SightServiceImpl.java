package egovframework.example.sight.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.book.service.impl.BookMapper;
import egovframework.example.sight.service.SightService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class SightServiceImpl implements SightService{
	
	@Resource
	private SightMapper sightMapper;

	@Override
	public List<EgovMap> selectSightServiceList() throws Exception {
	
		return sightMapper.selectSightServiceList();
	}
	
	

}
