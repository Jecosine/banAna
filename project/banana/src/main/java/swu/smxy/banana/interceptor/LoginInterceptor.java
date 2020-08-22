/*
 * @Date: 2020-08-22 21:38:55
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 21:51:59
 */
package swu.smxy.banana.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import swu.smxy.banana.entity.User;

public class LoginInterceptor implements HandlerInterceptor
{
    /**
     * @description: call before handling request
     * @param {type}
     * @return {@code bool}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("Intercepted by LoginInterceptor");
        try
        {
            User user = (User) request.getSession().getAttribute("user_auth");
            if (user != null)
            {
                // TODO: jump back to referer
                return true;
            }
            response.sendRedirect(request.getContextPath() + "user/login");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @description: call after handling request and before rendering view
     * @param {type}
     * @return {type}
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView)
    {
        System.out.println("  in postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
    {
        System.out.println("  in afterCompletion");
    }
}