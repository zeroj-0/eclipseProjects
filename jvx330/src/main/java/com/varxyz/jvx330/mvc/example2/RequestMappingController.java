package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// controller를 거쳐 jsp를 보여줌
// 뒤에 확장자를 보여주지않아서 뭘로만들었는지 모름
@Controller
public class RequestMappingController {
	
	// 이 메소드는 컨테이너가 불러줘야하는데 불러주려면 url이 필요함 -> requestMapping
	// value = url(이 url에 접근했을때 메소드 부른다) method = get인지 post방식인지
	// mapping => 경로설정 
	@RequestMapping(value="/example2/mapping", method = RequestMethod.GET)
	public String getMapping() {
		// 화면만 보여주겠다 !!!!!!!!
		return "example2/mapping_result";
	}
	
	// serlvet과 같이 하나의 매핑에 get과 post 쓰려면 get / post만 바꿔주면됨
	@RequestMapping(value="/example2/mapping", method = RequestMethod.POST)
	public ModelAndView postMapping() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result");
		// get방식으로 이미 jsp페이지로 들어가있는 상태라서 post방식인 결과값이 나오지않음
		// 그러기위해서는 post방식으로 넘겨주는 form이 필요함 -> jsp
		mav.addObject("result", "post 요청 결과 메세지");
		
		return mav;
	}
}
