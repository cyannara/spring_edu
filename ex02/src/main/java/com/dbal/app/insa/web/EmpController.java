package com.dbal.app.insa.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbal.app.insa.domain.EmpVO;
import com.dbal.app.insa.service.DepartmentsService;
import com.dbal.app.insa.service.EmpService;
import com.dbal.app.insa.service.JobsService;

@Controller
public class EmpController {

    @Autowired  EmpService empService;
    @Autowired  JobsService jobsService;
    @Autowired  DepartmentsService departmentsService;
    
    @ModelAttribute("opt")
    public Map<String, Object> jobs(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("jobs", jobsService.getJobList());
    	map.put("depts", departmentsService.getDeptList());
    	return map;
    }
    
    // 등록폼
    @GetMapping("insertEmp")
    public String insertFormEmp(EmpVO vo) {
    	return "insa/insertEmp";
    }

    // 수정폼
    @GetMapping("updateEmp")
    public String insertFormEmp(EmpVO vo, Model model) {
    	model.addAttribute("emp", empService.getEmp(vo));
        return "insa/insertEmp";

    }
    
    // 등록처리
    @PostMapping("insertEmp")
    public String insertEmp(@ModelAttribute("evo") EmpVO vo)  {

        // 서비스호출
        empService.empInsert(vo);
        return "redirect:empList";
    }
   
    // 수정처리
    @PostMapping("updateEmp")
    public String updateEmp(@ModelAttribute("evo") EmpVO vo)  {

        // 서비스호출
        empService.empUpdate(vo);
        return "redirect:empList";
    }

    // 단건조회   getEmp?employeeId=100
    @RequestMapping("getEmp/{employeeId}") // getEmp?employeeId=aaaa
    public String getEmp(@PathVariable String employeeId
                        , Model model, EmpVO empVO) {
        empVO.setEmployeeId(employeeId);
        model.addAttribute("emp", empService.getEmp(empVO));
        return "insa/getEmp";
    }

    // 목록조회
    @RequestMapping("empList")
    public String empList(Model model, EmpVO empVO) {
        model.addAttribute("empList", empService.getEmpList(empVO));
        return "no/insa/empList";
    }

    // 사원검색
    @RequestMapping("empSearch")
    public String empSearch(Model model, EmpVO empVO) {
        model.addAttribute("empList", empService.getEmpList(empVO));
        return "insa/empSearch";
    }
    
    @RequestMapping("ajaxEmp")
    @ResponseBody
    public EmpVO ajaxEmp(EmpVO vo) {
    	return empService.getEmp(vo);
    }
    
}


