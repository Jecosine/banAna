/*
 * @Date: 2020-07-25 17:06:41
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 00:28:48
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\BusinessService.java
 */
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.BaseMapper;
import swu.smxy.banana.dao.BusinessMapper;
import swu.smxy.banana.entity.Business;
import swu.smxy.banana.util.DBConnection;

@Service
public class BusinessService extends BaseService<Business, BusinessMapper>
{
    
    // @Resource
    private BusinessMapper businessMapper = null;
    private BusinessMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    
    // public List<Business> getAll()
    // {
    //     businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
    //     return businessMapper.getAll();
    // }

    // public Business getById(String businessId)
    // {
    //     businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
    //     return businessMapper.getById(businessId);
    // }

    // public Business getByName(String businessName)
    // {
    //     businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
    //     return businessMapper.getByName(businessName);
    // }
}