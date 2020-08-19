/*
 * @Date: 2020-07-25 16:06:19
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-26 12:59:30
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Business.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Business implements Serializable {
    private String businessId;
    private String businessName;
    private String openDateTime;
}