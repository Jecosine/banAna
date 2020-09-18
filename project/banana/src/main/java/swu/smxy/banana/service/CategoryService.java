/*
 * @Date: 2020-08-31 01:54:51
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:51:37
 */
package swu.smxy.banana.service;

import java.util.List;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.CategoryMapper;
import swu.smxy.banana.entity.Category;
import swu.smxy.banana.entity.ResponseType;

@Service
public class CategoryService extends BaseService<Category, CategoryMapper>
{
    private CategoryMapper categoryMapper = null;
    private CategoryMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public List<Category> cateGetter(List<Category> list) {
        List<Category> childList;
        for(int i=0; i < list.size(); i++) {
            childList = mapper.getByParentId(list.get(i).getCateId());
            // System.out.println(list.get(i).getCateName() + ":" + childList.size());
            if (childList != null && !childList.isEmpty()) {
                childList = cateGetter(childList);
                list.get(i).setData(childList);
            }
        }
        return list;
    }
    /**
     * @description: get category list
     * @param {@code String} cateId 
     * @return {@code List<Category>} 
     */
    public ResponseType<List<Category>> getChildCate(String cateId) {
        List<Category> list;
        mapper = sqlSessionFactory.openSession().getMapper(CategoryMapper.class);
        list = mapper.getByParentId(cateId);
        list = cateGetter(list);
        ResponseType<List<Category>> response = new ResponseType<List<Category>>();
        response.setStatus(0);
        response.setMessage("data");
        response.setData(list);
        return response; 
    }
    
}