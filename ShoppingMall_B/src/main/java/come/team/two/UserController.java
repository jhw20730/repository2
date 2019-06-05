package come.team.two;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import come.team.domain.UserVO;
import come.team.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user")
@Log4j
@AllArgsConstructor
public class UserController {
	
	private UserService service;
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/join") //회원가입하고 로그인폼으로 이동
	public String join(UserVO vo) {
		service.join(vo);
		
		log.info("UserVO: " + vo);
		
		return "redirect:/product/list";
		
	}
}
