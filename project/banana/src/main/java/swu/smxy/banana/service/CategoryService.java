/*
 * @Date: 2020-08-31 01:54:51
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:20:33
 */
package swu.smxy.banana.service;

import java.util.List;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import swu.smxy.banana.dao.CategoryMapper;
import swu.smxy.banana.entity.Category;
import swu.smxy.banana.entity.ResponseType;

public class CategoryService extends BaseService<Category, CategoryMapper>
{
    private CategoryMapper categoryMapper = null;
    private CategoryMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    /**
     * @description: get category list
     * @param {@code String} cateId 
     * @return {@code List<Category>} 
     */
    public ResponseType<List<Category>> getChildCate(String cateId) {
        List<Category> list;
        mapper = sqlSessionFactory.openSession().getMapper(CategoryMapper.class);
        return list; 
    }
}