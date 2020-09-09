/*
 * @Date: 2020-08-31 19:05:55
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 19:07:53
 */
package swu.smxy.banana.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String name;
    private String address;
    private String phone;
    private List<String> tag;
}