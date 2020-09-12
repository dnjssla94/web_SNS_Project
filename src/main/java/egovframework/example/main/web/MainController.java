package egovframework.example.main.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.main.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class MainController {

	@Resource
	private MainService mainService;
	
	@RequestMapping(value = "/main.do")
	public String mainInt(ModelMap model) throws Exception {		
		
		int listLength = 0;
		List<EgovMap> mainListReverse = new ArrayList<EgovMap>();
		List<EgovMap> mainList = mainService.selectMainServiceList();
		
		for (listLength = mainList.size()-1; listLength >= 0 ; listLength--) {
			mainListReverse.add(mainList.get(listLength));
		}

		model.addAttribute("deskImagesList", mainListReverse);
		return "main/main.tiles";
	}

	@RequestMapping(value = "/signMain.do")
	public String signMainInt(ModelMap model) throws Exception {		
//		
//		List<EgovMap> mainList = mainService.selectMainServiceList();
//		System.out.println(mainList);
//		
//		model.addAttribute("deskImagesList", mainList);
		return "sign/sign.sign";
	}

}