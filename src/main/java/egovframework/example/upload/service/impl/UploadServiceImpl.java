package egovframework.example.upload.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.upload.service.UploadFileVO;
import egovframework.example.upload.service.UploadService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Resource
	private UploadMapper uploadMapper;
	

	@Override
	public List<EgovMap> selectUploadServiceList() throws Exception {
	
		return uploadMapper.selectUploadServiceList();
	}
	
	@Override
	public void deskUpload(UploadFileVO fileUploadVo,boolean isLocal) throws Exception{
		
		String filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/main";
		if (isLocal) {
			filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/main";
		}
		
		MultipartFile file = fileUploadVo.getMpfile();
		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.')+1);
		String fileName =orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));
		
		String fullFileName =fileName +"_"+ new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;
		
		String path = "./images/main" + File.separator + fullFileName;
		
		System.out.println(fullFileName);
		
		try {
			
			file.transferTo(new File(filePath + File.separator + fullFileName));
			fileUploadVo.setFileName(fullFileName);
			fileUploadVo.setPath(path);
			uploadMapper.deskUploadLog(fileUploadVo);
			System.out.println(path);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bookUpload(UploadFileVO fileUploadVo, boolean isLocal) throws Exception {
		
		String filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/book";
		if (isLocal) {
			filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/book";
		}
		
		MultipartFile file = fileUploadVo.getMpfile();
		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.')+1);
		String fileName =orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));
		
		String fullFileName =fileName +"_"+ new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;
		
		String path = "./images/book" + File.separator + fullFileName;
		
		System.out.println(fullFileName);
		
		try {
			
			file.transferTo(new File(filePath + File.separator + fullFileName));
			fileUploadVo.setFileName(fullFileName);
			fileUploadVo.setPath(path);
			uploadMapper.bookUploadLog(fileUploadVo);
			System.out.println(path);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sightUpload(UploadFileVO fileUploadVo, boolean isLocal) {
		
		String filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/sight";
		if (isLocal) {
			filePath = "/Users/shinwonkim/eGovframeDev/workspace/web_SNS_project/src/main/webapp/images/sight";
		}
		
		MultipartFile file = fileUploadVo.getMpfile();
		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.')+1);
		String fileName =orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));
		
		String fullFileName =fileName +"_"+ new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;
		
		String path = "./images/sight" + File.separator + fullFileName;
		
		System.out.println(fullFileName);
		
		try {
			
			file.transferTo(new File(filePath + File.separator + fullFileName));
			fileUploadVo.setFileName(fullFileName);
			fileUploadVo.setPath(path);
			uploadMapper.sightUploadLog(fileUploadVo);
			System.out.println(path);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
