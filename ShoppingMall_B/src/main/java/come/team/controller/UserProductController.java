package come.team.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import come.team.domain.CartVO;
import come.team.domain.Criteria;
import come.team.domain.PageDTO;
import come.team.domain.ProductVO;
import come.team.domain.ReviewVO;
import come.team.domain.UserVO;
import come.team.service.CartService;
import come.team.service.ProductService;
import come.team.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/product")
public class UserProductController {
	
	private ProductService productService;
	private CartService cartservice;
	private ReviewService reviewService;
	
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
		ProductVO productVO = productService.productView(productCode);
		Criteria criteria = new Criteria(1, 10, productService.priceTotal());
		List<ReviewVO> reviewList = reviewService.getReviewList(criteria, productCode);
				
		model.addAttribute("board", productVO);
		model.addAttribute("review", reviewList);
	}
	//카드담기
	
	@GetMapping("/view/addcart")
	public void addCart() {
		
	}
	
	@ResponseBody
	@PostMapping("/view/addcart")
	public void addCart(CartVO cart, HttpSession session) throws Exception {
	
		UserVO userId = (UserVO) session.getAttribute("id"); 
		ProductVO productCode = (ProductVO) session.getAttribute("productCode");
		cart.setId(userId.getId());
		cart.setProductCode(productCode.getProductCode());
			
			cartservice.addCart(cart);
	 
	}
	
}
