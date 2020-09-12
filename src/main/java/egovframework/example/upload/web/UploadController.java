package egovframework.example.upload.web;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.sign.service.UserSessionVO;
import egovframework.example.upload.service.UploadFileVO;
import egovframework.example.upload.service.UploadService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class UploadController {

	@Resource
	private UploadService uploadService;
	
	@RequestMapping(value = "/upload.do")
	public String uploadInit() throws Exception {		
		
		List<EgovMap> uploadList = uploadService.selectUploadServiceList();
		System.out.println(uploadList);
		return "upload/upload.tiles";
	}
	
	@RequestMapping(value="/fileUpload.do") 
	public String deskUploadTest(MultipartHttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		UserSessionVO userSessionVO = (UserSessionVO) session.getAttribute("UserSession");
		
		String timeLine = req.getParameter("timeLine");
		
		System.out.println("어느 탐라?: "+ timeLine);
		System.out.println("세션으로 가져와보았다. ");
		System.out.println(userSessionVO.getUserId());
		
		System.out.println("파일 업로드 시작");
		Iterator<String> itr = req.getFileNames();
		
		boolean isLocal = false;
		UploadFileVO FileUploadVo = new UploadFileVO();
		FileUploadVo.setId(userSessionVO.getUserId());
		FileUploadVo.setPassword(userSessionVO.getUserPass());
		FileUploadVo.setMessage(req.getParameter("message"));
		FileUploadVo.setDate(new Date());
				
		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);		
		if (requestUrl.contains("localhost") || requestUrl.contains("127.0.0.1"))
		{
			isLocal = true;
		}

		
		
		while(itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());
			FileUploadVo.setMpfile(mpf);
			
			if (timeLine.equals("desk")) {
				uploadService.deskUpload(FileUploadVo, isLocal);
			}else if(timeLine.equals("book")){
				uploadService.bookUpload(FileUploadVo, isLocal);
			}else if(timeLine.equals("sight")) {
				uploadService.sightUpload(FileUploadVo, isLocal);
			}
			
		}
		
		return "upload/upload.tiles";
	}
	
}

