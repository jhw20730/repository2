package come.team.controller;


import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole{'ROLE_ADMIN'}")
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	private ProductService productService;
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/list")
	public void list(Criteria criteria, String price, Model model) {
		int price_total = 0;
		
		if(price == null) {
			price_total = productService.priceTotal();
		} else {
			log.info("백분율: " + price);
			log.info("최대 가격 : " + productService.priceTotal());
			price_total = (int) (Math.ceil(Integer.parseInt(price)*productService.priceTotal()/100000)*1000+1000);
		}
		
		log.info("설정된 price total: "+price_total);
		
		model.addAttribute("pricetotal", productService.priceTotal());
		
		criteria.setAmount(10);
		criteria.setPrice(price_total);
		
		log.info("list: " + criteria);
		
		model.addAttribute("list", productService.findPagingList(criteria));
		
		int total = productService.countAll(criteria);
		
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		
	}
	
	@GetMapping("/view")
	public void view(String productCode, Model model) {
		model.addAttribute("product", productService.productView(productCode));
	}
	

	@GetMapping("/register")
	public void register() {
		
	}
	
	
	@PostMapping("/register") //관리자가 제품 등록하는
	public String register(ProductVO vo) {
		productService.register(vo);
		
		log.info("productVO: " + vo);
		
		return "redirect:/admin/list";
	}
	
	@GetMapping("/update")
	public void update(String productCode, Model model) {
		model.addAttribute("board", productService.productView(productCode));
	}
	
	@GetMapping("/updateCheck")
	public void list(ProductVO vo, Model model) {
		
		log.info(vo);
		productService.update(vo);
	}
	
	@GetMapping("/delete")
	public void delete(String productCode, Model model) {
		log.info("delete sequence start "+productCode);
		productService.delete(productCode);
		log.info("delete sequence ");
	}
	
}
