/*
 * @Date: 2020-07-25 18:38:45
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 12:21:49
 */
package swu.smxy.banana.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;

public class DBConnection
{

    private static DBConnection instance = null;
    private static SqlSessionFactory factory = null;

    private DBConnection()
    {
    }

    public static SqlSessionFactory getFactory()
    {
        if (instance == null)
        {
            synchronized (DBConnection.class)
            {
                if (instance == null)
                {
                    instance = new DBConnection();
                    String configurationPath = "mybatis-config.xml";
                    InputStream inputStream = null;
                    try
                    {
                        inputStream = Resources.getResourceAsStream(configurationPath);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                        System.out.print("Cannot find configuration file.");
                    }
                    factory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }

        return factory;
    }

}