package come.team.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import come.team.domain.CartVO;
import come.team.domain.Criteria;
import come.team.domain.ProductVO;
import come.team.domain.ReviewPageDTO;
import come.team.domain.UserVO;
import come.team.service.CartService;
import come.team.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/cart")
public class UserCartController {

	CartService cartService;
	ProductService productService;

	// 카트담기
	@ResponseBody
	@PostMapping("/add")
	public void addCart(CartVO cart, HttpSession session) throws Exception {
		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		cart.setId(id);

		cartService.addCart(cart);

	}

	// 카트 리스트
	@GetMapping("/list")
	public void getCartList(HttpSession session, Model model) {
		
		String id = (String) session.getAttribute("id");
		
		List<CartVO> cartList = cartService.getCartList(id);

		for (int i = 0; i < cartList.size(); i++) {
			ProductVO productVO = productService.productView(cartList.get(i).getProductCode());
			cartList.get(i).setProductName(productVO.getProductName());
			cartList.get(i).setDescription(productVO.getDescription());
			cartList.get(i).setPrice(productVO.getPrice());
		}

		model.addAttribute("cart", cartList);
	}

	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public void deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr) throws Exception {
		log.info("delete cart");

		int cartNo = 0;

		for (String i : chArr) {
			CartVO cart = new CartVO();
			cartNo = Integer.parseInt(i);
			cart.setCartNo(cartNo);
			cartService.deleteCart(cart);
		}
	}
	
	@GetMapping(value = "/list/json",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<CartVO>> getReviewList(HttpSession session, Model model){
		
		String id = (String) session.getAttribute("id");
		

		List<CartVO> cartList = cartService.getCartList(id);

		for (int i = 0; i < cartList.size(); i++) {
			ProductVO productVO = productService.productView(cartList.get(i).getProductCode());
			cartList.get(i).setProductName(productVO.getProductName());
			cartList.get(i).setDescription(productVO.getDescription());
			cartList.get(i).setPrice(productVO.getPrice());
		}
			
			return new ResponseEntity<List<CartVO>>(cartList, HttpStatus.OK);
		}
}
