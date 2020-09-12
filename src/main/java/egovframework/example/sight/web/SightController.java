package egovframework.example.sight.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sight.service.SightService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class SightController {

	@Resource
	private SightService sightService;

	@RequestMapping(value = "/sight.do")
	public String sightInit(ModelMap model) throws Exception{		
		
		int listLength = 0;
		List<EgovMap> sightListReverse = new ArrayList<EgovMap>();
		List<EgovMap> sightList = sightService.selectSightServiceList();
		
		for (listLength = sightList.size()-1; listLength >= 0 ; listLength--) {
			sightListReverse.add(sightList.get(listLength));
		}

		model.addAttribute("sightImagesList", sightListReverse);
		return "sight/sight.tiles";
	}
}