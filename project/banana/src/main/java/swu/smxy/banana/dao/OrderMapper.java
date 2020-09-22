package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import swu.smxy.banana.entity.Order;

@Component
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from order where userId=#{userId}")
    public List<Order> getByUserId(String userId);

    @Insert("insert into order values(#{orderId}, NOW(), #{businessId}, #{userId}, #{businessName}, #{orderPrice}, #{orderItemList}, #{orderStatus})")
    public Integer newOrder(Order order);
}