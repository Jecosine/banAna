/*
 * @Date: 2020-07-25 17:06:41
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 22:34:21
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
public class BusinessService extends BaseService<Business>
{
    
    // @Resource
    private BusinessMapper businessMapper = null;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    
    /**
     * @description: get all business instances
     * @param <empty>
     * @return: return list of Business instance
     */
    public List<Business> getAll()
    {
        businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
        return businessMapper.getAll();
    }

    /**
     * @description: get Business instance by business instance id
     * @param businessId String length 10
     * @return: Business instance
     */
    public Business getById(String businessId)
    {
        businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
        return businessMapper.getById(businessId);
    }

    /**
     * @description: get Business instance by business instance name
     * @param businessName String length 10
     * @return: Business instance
     */
    public Business getByName(String businessName)
    {
        businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
        return businessMapper.getByName(businessName);
    }
}