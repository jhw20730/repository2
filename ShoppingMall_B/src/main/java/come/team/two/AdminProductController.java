package come.team.two;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import come.team.domain.CartVO;
import come.team.domain.Criteria;
import come.team.domain.PageDTO;
import come.team.domain.ProductVO;
import come.team.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminProductController {
	
	private ProductService service;

	
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
		model.addAttribute("board", service.productView(productCode));
	}
	
	@GetMapping("/update")
	public void update(String productCode, Model model) {
		model.addAttribute("board", service.productView(productCode));
	}
	
	@GetMapping("/updateCheck")
	public String updateCheck(String code, String name, String manu, BigDecimal price, String desc, String os, String type, BigDecimal stock, String usab, Model model) {
//		String code = request.getParameter("productCode");
//		String name = request.getParameter("productName");
//		String manu = request.getParameter("manufacturer");
//		int price = Integer.getInteger(request.getParameter("price"));
//		String desc = request.getParameter("description");
//		String os = request.getParameter("os");
//		String type = request.getParameter("productType");
//		int stock = Integer.getInteger(request.getParameter("stock"));
//		String usab = request.getParameter("usability");
		ProductVO vo = new ProductVO(code, name, manu, price, desc, os, type, stock, usab);
		service.update(vo);
		return "redirect:/admin/list";
	}
	
	@GetMapping("/delete")
	public String delete(String productCode, Model model) {
		service.delete(productCode);
		return "redirect:/admin/list";
	}
	
	
	
	
}
