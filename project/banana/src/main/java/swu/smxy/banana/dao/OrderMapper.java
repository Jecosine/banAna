package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import swu.smxy.banana.entity.Order;

@Component
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from `order` where userId=#{userId}")
    public List<Order> getByUserId(String userId);

    @Select("select * from `order` where orderId=#{orderId}")
    public Order getById(String orderId);

    @Select("select * from `order` where parentId=#{parentId}")
    public List<Order> getByParentId(String parentId);

    @Insert("insert into `order` values(#{orderId}, NOW(), #{businessId}, #{userId}, #{businessName}, #{orderPrice}, #{orderItemListParsed}, #{orderStatus}, #{orderParentId})")
    public Integer newOrder(Order order);

}