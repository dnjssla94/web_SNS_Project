package egovframework.example.upload.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface UploadService {

	List<EgovMap> selectUploadServiceList() throws Exception;

	void deskUpload(UploadFileVO fileUploadVo, boolean isLocal) throws Exception;

	void bookUpload(UploadFileVO fileUploadVo, boolean isLocal) throws Exception;

	void sightUpload(UploadFileVO fileUploadVo, boolean isLocal) throws Exception;


}


