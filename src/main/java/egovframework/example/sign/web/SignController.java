package egovframework.example.sign.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.example.sign.service.SignService;
import egovframework.example.sign.service.SignUpVO;
import egovframework.example.sign.service.UserSessionVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class SignController {


	@Resource
	private SignService signService;
		

	// 회원가입 post
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String postRegister(HttpServletRequest req) throws Exception {

		System.out.println("회원가입 시 시작");
		
		boolean isLocal = false;
		SignUpVO signUpVO = new SignUpVO();
		signUpVO.setUserId(req.getParameter("userId"));
		signUpVO.setUserPass(req.getParameter("userPass"));
		signUpVO.setUserName(req.getParameter("userName"));
		signUpVO.setRegDate(new Date());
				
		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);		
		if (requestUrl.contains("localhost") || requestUrl.contains("127.0.0.1"))
		{
			isLocal = true;
		}
		
		
		signService.register(signUpVO, isLocal);
		
		return "sign/sign.sign";
	}
	
	@RequestMapping(value = "/signIn.do", method = RequestMethod.POST)
	public String studentStatusInit(HttpServletRequest req, RedirectAttributes rttr, UserSessionVO userSessionVO) throws Exception{	
		
		
		//사용자의 로그인 정보 
		String inputId = req.getParameter("id");
		String inputPass = req.getParameter("password");
		System.out.println("InputID, InputPass: " + inputId + ", " +inputPass);
		
		List<EgovMap> idList = signService.selectSignServiceList(req.getParameter("id"));
		
		System.out.println("가져왔다");
		
		
		if(inputId != null && inputPass.equals(idList.get(0).get("userPass"))) {
			System.out.println("여기가 돌아가");
			//세션 가져옴.. 가져올 세선이 없다면 세션 생성. 보통은 일반적인 상황에서는 후자일것.
			HttpSession session = req.getSession();
			
			userSessionVO.setUserId(idList.get(0).get("userId").toString());
			userSessionVO.setUserPass(idList.get(0).get("userPass").toString());
			userSessionVO.setUserName(idList.get(0).get("userName").toString());
			
			session.setAttribute("UserSession", userSessionVO);
			
		}else {
			System.out.println("아니면 여기가? ");
			rttr.addFlashAttribute("errorMsg", false);
			return "redirect:/sign.do";
		}
		
		return "redirect:/main.do";
		
		//model.addAttribute("idInfo", idList);
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/sign.do";
	}

	@RequestMapping(value = "/sign.do")
	public String signUpOrIn() throws Exception {
		
		return "sign/sign.sign";
	}

}



