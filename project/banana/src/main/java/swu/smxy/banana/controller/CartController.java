package swu.smxy.banana.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController<CartService> {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/getCartService", method = RequestMethod.POST)
	@ResponseBody
	public ResponseType<List<CartItem>> getCartService(@RequestParam String userId,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResponseType<List<CartItem>> responseType = cartService.getCartService(userId);
		return responseType;
	}
	
	@RequestMapping(value = "/addItemToCartService", method = RequestMethod.GET)
	@ResponseBody
	public ResponseType<CartItem> addItemToCartService(@RequestParam CartItem cartItem,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResponseType<CartItem> responseType = cartService.addItemToCartService(cartItem);
		return responseType;
	}
	
	@RequestMapping(value = "/deleteItemFromCartService", method = RequestMethod.GET)
	@ResponseBody
	public ResponseType<CartItem> deleteItemFromCartService(@RequestParam CartItem cartItem,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResponseType<CartItem> responseType = cartService.deleteItemFromCartService(cartItem);
		return responseType;
	}
	
	@RequestMapping(value = "/batchDeleteService", method = RequestMethod.GET)
	@ResponseBody
	public ResponseType<List<CartItem>> batchDeleteService(@RequestParam String[] cartIdList,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResponseType<List<CartItem>> responseType = cartService.batchDeleteService(cartIdList);
		return responseType;
	}
}
