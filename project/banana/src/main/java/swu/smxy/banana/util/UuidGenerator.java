/*
 * @Date: 2020-08-21 20:19:06
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 22:07:21
 */
package swu.smxy.banana.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UuidGenerator
{
    /**
     * @descript: get uuid
     * @param length - Required uuid length range from [1,32]
     * @return: A specified length random uuid String
     */
    public static String getUuid(int length)
    {
        length = (length > 32)?32:length;
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    }
}