package swu.smxy.banana.service;

import swu.smxy.banana.dao.CartMapper;
import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.ResponseType;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService extends BaseService<CartItem, CartMapper> {

	private CartMapper mapper;
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Transactional
	public ResponseType<List<CartItem>> getCartService(String userId)
	{
		ResponseType<List<CartItem>> response = new ResponseType<List<CartItem>>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		List<CartItem> cartItems = mapper.getByUserId(userId);
		int status = 0;
		String message = "Search Successfully";
		try {
			mapper.getByUserId(userId);
		} catch (Exception e) {
			status = -1;
			message = "Search failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItems);
			response.setStatus(status);
			response.setMessage(message);
			return response;
		} finally {
			session.commit();
			session.close();
		}
		response.setData(cartItems);
        response.setStatus(status);
        response.setMessage(message);
        return response;
	}
	
	
	
	@Transactional
	public ResponseType<CartItem> addItemToCartService(CartItem cartItem)
	{
		ResponseType<CartItem> response = new ResponseType<CartItem>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		int status = 0;
		String message = "Add Successfully!";
		try {
			mapper.addItemById(cartItem);
		} catch (Exception e) {
			status = -1;
			message = "Add failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItem);
			response.setStatus(status);
			response.setMessage(message);
			return response;
		} finally {
			session.commit();
			session.close();
		}
		response.setData(cartItem);
        response.setStatus(status);
        response.setMessage(message);
        return response;
	}
	
	@Transactional
	public ResponseType<CartItem> deleteItemFromCartService(CartItem cartItem)
	{
		ResponseType<CartItem> response = new ResponseType<CartItem>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		int status = 0;
		String message = "Delete Successfully!";
		try {
			mapper.deleteById(cartItem.getCartId());
		} catch (Exception e) {
			status = -1;
			message = "Delete failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItem);
			response.setStatus(status);
			response.setMessage(message);
			return response;
		} finally {
			session.commit();
			session.close();
		}
		response.setData(cartItem);
        response.setStatus(status);
        response.setMessage(message);
        return response;
	}
	
	@Transactional
	public ResponseType<List<CartItem>> batchDeleteService(String[] cartIdList)
	{
		ResponseType<List<CartItem>> response = new ResponseType<List<CartItem>>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		List<CartItem> cartItems = mapper.batchDeleteCartItem(cartIdList);
		int status = 0;
		String message = "Batch Delete Successfully!";
		try {
			mapper.batchDeleteCartItem(cartIdList);
		} catch (Exception e) {
			status = -1;
			message = "Batch Delete Failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItems);
			response.setStatus(status);
			response.setMessage(message);
			return response;
		} finally {
			session.commit();
			session.close();
		}
		response.setData(cartItems);
        response.setStatus(status);
        response.setMessage(message);
        return response;
	}
	
	
}
