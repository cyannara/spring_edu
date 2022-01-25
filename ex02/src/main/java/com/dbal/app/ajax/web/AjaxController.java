package com.dbal.app.ajax.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbal.app.ajax.SampleVO;
import com.dbal.app.ajax.SampleVoList;

import lombok.extern.java.Log;

@RestController  // @Controller + @ResponseBody
@Log
public class AjaxController {

	
	@RequestMapping("/ex08")   
	public List<SampleVO> ex07( ) {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO("choi",10,new Date()));
		list.add(new SampleVO("park",20,new Date()));
		list.add(new SampleVO("kim",30,new Date()));
		return list;
	}	

	@RequestMapping("/ex09") 
	@ResponseBody   //자바객체 ->json 스트링 변환
	public SampleVO ex09(SampleVO sample ) {
		//SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(50);
		return sample;
	}
	

	@RequestMapping("/ex07")   
	public SampleVO ex07(SampleVO sample ) {
		//SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(50);
		return sample;
	}
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name,
			         @PathVariable int age ) {
		log.info("name="+ name);
		log.info("age="+ age);
	}
	
	@RequestMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info(list.toString());
	}
	
	@RequestMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
	}
	
	@RequestMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		//String[] ids = request.getParameterValues("ids");
		log.info(Arrays.toString(ids));
	}
	
	@PostMapping("/ex02")
	public void ex02(@RequestParam(name = "username") String name ,			        
			         @RequestParam(required = false, defaultValue = "10") int age 
			        ) {
		//String name = request.getParameter("username");
		log.info("name="+name);
		log.info("age="+age);
	}
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("sam") SampleVO vo,
			           Model model) {   //dto = vo = do
		log.info(vo.toString());
		//model.addAttribute("sam", vo);
		model.addAttribute("pageNo", "10");
		return "sample/ex01";
	}
	
	//@RequestMapping(value="/a", method = RequestMethod.POST )
	@GetMapping("/a")
	public String basic1() {
		log.info("basic1.......");
		return "sample/basica";  //jsp 뷰페이지 리턴
	}
	
	@RequestMapping("/b")
	public void basic2() {      //void 인경우 url과 일치하는 뷰페이지로 포워드
		log.info("basic2.......");
	}
}
