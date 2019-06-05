package come.team.two;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import come.team.domain.Criteria;
import come.team.domain.PageDTO;
import come.team.domain.ProductVO;
import come.team.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	private ProductService service;
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {

		criteria.setAmount(10);
		
		log.info("list: " + criteria);
		
		model.addAttribute("list", service.findPagingList(criteria));
		
		int total = service.countAll(criteria);
		
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		
	}
	
	@GetMapping("/view")
	public void view(String productCode, Model model) {
		model.addAttribute("product", service.productView(productCode));
	}
	

	@GetMapping("/register")
	public void register() {
		
	}
	
	
	@PostMapping("/register") //관리자가 제품 등록하는
	public String register(ProductVO vo) {
		service.register(vo);
		
		log.info("productVO: " + vo);
		
		return "redirect:/admin/list";
	}
	
	@GetMapping("/update")
	public void update(String productCode, Model model) {
		model.addAttribute("board", service.productView(productCode));
	}
	
	@GetMapping("/updateCheck")
	public void list(ProductVO vo, Model model) {
		
		log.info(vo);
		service.update(vo);
	}
	
	@GetMapping("/delete")
	public void delete(String productCode, Model model) {
		log.info("delete sequence start "+productCode);
		service.delete(productCode);
		log.info("delete sequence ");
	}
	
}
