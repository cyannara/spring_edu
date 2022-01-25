package com.dbal.app.board.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dbal.app.board.domain.BoardAttachVO;
import com.dbal.app.board.domain.BoardVO;

import lombok.extern.java.Log;

@Log
@Controller
public class UploadController {

	
	@GetMapping("page2")
	public ResponseEntity<BoardVO> page2(@RequestParam int h){
		//참고페이지 364
		ResponseEntity<BoardVO> result = null;
		if(h<10) {
			result = ResponseEntity.status(HttpStatus.NOT_FOUND)
				               .body(new BoardVO());
		}
		else {
			result = ResponseEntity.status(HttpStatus.OK)
		               .body(new BoardVO());
		}
		
		return result;
	}
	
	
	@GetMapping("page1") 
	public void page1(HttpServletResponse response) throws IOException {
		String mimetype = "application/xml";
		response.setContentType(mimetype);
		//response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>test</div>");
		out.println("<div>안녕하세요</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile ) throws IllegalStateException, IOException {
		for(int i=0; i< uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if(!ufile.isEmpty() && ufile.getSize()>0 ) {
				String filename = ufile.getOriginalFilename();
				//String saveName = System.currentTimeMillis()+""; //
				UUID uuid = UUID.randomUUID();
				File file = new File("c:/upload",uuid+filename);
				ufile.transferTo(file);
			}
		}
	}
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public List<BoardAttachVO> uploadAjaxAction(MultipartFile[] uploadFile,
			                        BoardVO vo) throws IllegalStateException, IOException {
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String path = "c:/upload";
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String filename = ufile.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				File file = new File(path, uuid + filename);
				ufile.transferTo(file);
				// 파일정보
				BoardAttachVO attachvo = new BoardAttachVO();
				attachvo.setUuid(uuid.toString());
				attachvo.setFileName(filename);
				attachvo.setUploadPath(path);
				list.add(attachvo);
			}
		}
		return list;
	}	
}
