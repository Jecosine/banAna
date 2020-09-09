/*
 * @Date: 2020-09-08 07:56:40
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-08 10:39:47
 */
package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import swu.smxy.banana.entity.CartItem;
// import swu.smxy.banana.service.cart;
// import swu.smxy.banana.service.delete;
// import swu.smxy.banana.service.foreach;

@Component
public interface CartMapper extends BaseMapper<CartItem>
{
    @Select("select * from cart")
    public List<CartItem> getAll();

    @Select("select * from cart where cartId=#{cartId}")
    public CartItem getByCartId(String cartId);

    @Select("select * from cart where userId=#{userId}")
    public List<CartItem> getByUserId(String userId);

    @Insert("insert into cart (cartId,itemId,itemCount,businessId,userId,price where itemId=#{itemId}")
    public int addItemById(CartItem cartItem);

    @Update("update cart set cartId=#{cartId}, itemId=#{itemId}, itemCount=#{itemCount}, businessId=#{businessId}, userId=#{userId}, price=#{price} where itemId=#{itemId}")
    public int update(CartItem cartItem);

    @Delete("delete from cart where cartId=#{cartId}")
    public int deleteById(String cartID);

    public List<CartItem> batchDeleteCartItem(String[] cartIdlist);
    // <delete id="deleteMoreCartItem" parameterType="cartIdList">
    // delete from cart where 1>2
    // or id in
    // <foreach collection="list" cartItem="cartItem" open="(" separator=","
    // close=")" >
    // #{cartItem}
    // </foreach>
    // </delete>
}
