/*
 * @Date: 2020-09-02 23:07:34
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-03 23:31:20
 */
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.ItemMapper;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.ResponseType;

@Service
public class ItemService extends BaseService<Item, ItemMapper> {
    private ItemMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    public ResponseType<Item> getByIdAndType(String itemId, String typeCode)
    {
        ResponseType<Item> response = new ResponseType<Item>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        response.setStatus(0);
        Item item;
        if (typeCode == null)
        {
            response.setMessage("Get Main Item Successfully");
            item = mapper.getById(itemId);
        }
        else 
        {
            response.setMessage("Get Sub Item Successfully");
            item = mapper.getByIdAndType(itemId, typeCode);
        }
        if (item == null)
        {
            response.setMessage("No such item");
            response.setStatus(-1);
        }
        return response;
    }
}