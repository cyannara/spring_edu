package com.dbal.app.pdf;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbal.app.insa.domain.EmpVO;
import com.dbal.app.insa.service.EmpService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class EmpController {

    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    EmpService empService;
    
    @Value("#{global['path']}")
    String path;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("serverTime", new Date());
	
        return "home";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String emp(Locale locale, Model model, EmpVO empVO) {

        model.addAttribute("emp", empService.getEmp(empVO));
        System.out.println("path"+path);
        return "emp/emp";
    }
}
