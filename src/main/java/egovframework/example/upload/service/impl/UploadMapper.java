package egovframework.example.upload.service.impl;

import java.util.List;

import egovframework.example.upload.service.UploadFileVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper
public interface UploadMapper {

	List<EgovMap> selectUploadServiceList() throws Exception;

	void deskUploadLog(UploadFileVO fileUploadVo) throws Exception;

	void bookUploadLog(UploadFileVO fileUploadVo) throws Exception;

	void sightUploadLog(UploadFileVO fileUploadVo) throws Exception;

}


