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
import swu.smxy.banana.util.UuidGenerator;

@Service
public class CartService extends BaseService<CartItem, CartMapper> {

	private CartMapper mapper;
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	@Transactional
	public ResponseType<List<CartItem>> getCartService(String userId) {
		ResponseType<List<CartItem>> response = new ResponseType<List<CartItem>>();
		if (userId == null || userId.isEmpty()) {
			response.setStatus(-1);
			response.setMessage("Not login");
			return response;
		}
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
			session.close();
		}
		response.setData(cartItems);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}

	@Transactional
	public ResponseType<CartItem> addItemToCartService(CartItem cartItem) {
		ResponseType<CartItem> response = new ResponseType<CartItem>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		int status = 0;
		cartItem.setCartId(UuidGenerator.getUuid(20));
		String message = "Add Successfully!";
		// check if is in cart
		List<CartItem> origins = mapper.getByItemId(cartItem.getItemId());
		if (origins != null && !origins.isEmpty()) {
			for (CartItem origin : origins) {
				if (origin.getTypeCode().equals(cartItem.getTypeCode())) {
					origin.setItemCount(origin.getItemCount() + cartItem.getItemCount());
					try {
						mapper.update(origin);
					} catch (Exception e) {
						status = -1;
						message = "Add failed:" + e.getMessage();
						System.out.println("status: " + status + " " + message + "\n" + cartItem);
						response.setStatus(status);
						response.setMessage(message);
						session.clearCache();
						return response;
					}
					session.commit();
					response.setData(cartItem);
					response.setStatus(status);
					response.setMessage(message);
					return response;
				}
			}

		}
		try {
			mapper.addItemById(cartItem);
		} catch (Exception e) {
			status = -1;
			message = "Add failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItem);
			response.setStatus(status);
			response.setMessage(message);
			session.commit();
			return response;
		} finally {
			session.commit();
		}
		response.setData(cartItem);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}

	@Transactional
	public ResponseType<CartItem> deleteItemFromCartService(CartItem cartItem) {
		ResponseType<CartItem> response = new ResponseType<CartItem>();
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CartMapper.class);
		int status = 0;
		String message = "Delete Successfully!";
		try {
			mapper.deleteById(cartItem.getCartId());
			session.commit();
		} catch (Exception e) {
			status = -1;
			message = "Delete failed:" + e.getMessage();
			System.out.println("status: " + status + " " + message + "\n" + cartItem);
			response.setStatus(status);
			response.setMessage(message);
			return response;
		}
		response.setData(cartItem);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}

	
	@Transactional
	public ResponseType<List<CartItem>> batchDeleteService(String[] cartIdList) {
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
		}
		response.setData(cartItems);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}

}
