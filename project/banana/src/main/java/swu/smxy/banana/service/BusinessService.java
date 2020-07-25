/*
 * @Date: 2020-07-25 17:06:41
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 17:08:54
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\BusinessService.java
 */ 
package swu.smxy.banana.service;

import java.util.List;
import swu.smxy.banana.entity.Business;
public interface BusinessService {
  /**
   * @description: get all business instances
   * @param <empty> 
   * @return: return list of Business instance
   */  
  public List<Business> getAllBusinesses();

  /**
   * @description: get Business instance by business instance id
   * @param businessId String
   * @return: Business instance
   */  
  public Business getBusinessById(String businessId);
}