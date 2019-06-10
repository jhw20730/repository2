package come.team.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import come.team.domain.Criteria;
import come.team.domain.InquiryVO;
import come.team.domain.PageDTO;
import come.team.domain.ReplyVO;
import come.team.service.InquiryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/inquiry")
public class UserInquiryController {
	
	private InquiryService inquiryService;
	
	@GetMapping("/list")
	public void getInquiryList(Criteria criteria, Model model) {
		
		List<InquiryVO> inquiry = inquiryService.getInquiryList(criteria);
		model.addAttribute("inquiry", inquiry);
		
		List<ReplyVO> reply = inquiryService.getReplyList();
		model.addAttribute("reply", reply);
		
		
		int total = inquiryService.getInquiryNum() + inquiryService.getReplyNum();
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		
	}
	
	@GetMapping("/view")
	public void getInquiryView(int inquiryNo, Model model) {
		
		model.addAttribute("inquiry", inquiryService.getInquiryView(inquiryNo));
		model.addAttribute("reply", inquiryService.getReplyListByInquiryNo(inquiryNo));
		
	}
	
	@PostMapping("/register")
	public void registerInquiry() {
		
	}
	
	@DeleteMapping("/delete")
	public void deleteInquiry() {
		
	}

}
