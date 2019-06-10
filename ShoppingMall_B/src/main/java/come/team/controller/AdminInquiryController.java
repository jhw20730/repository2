package come.team.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import come.team.domain.InquiryVO;
import come.team.domain.ReplyVO;
import come.team.service.InquiryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/admin/inquiry/")
@Controller
@Log4j
@AllArgsConstructor
public class AdminInquiryController {
	private InquiryService inquiryService;
	
	@GetMapping("/register")
	public void Reply(int inquiryNo, Model model) {
		model.addAttribute("inquiryNo", inquiryNo);
	}
	
	@PostMapping("/register")
	public void PostReply(ReplyVO replyVO, HttpSession session) {
				
		log.info(replyVO.getTitle());
		log.info(replyVO.getContent());
		log.info(replyVO.getInquiryNo());
		
		replyVO.setId("admin");
		
		inquiryService.registerReplyInquiry(replyVO);
		
	}
	
	@GetMapping("/view")
	public void getReplyView(int replyNo, Model model) {
		model.addAttribute("reply", inquiryService.getReplyView(replyNo));		
	}

}

