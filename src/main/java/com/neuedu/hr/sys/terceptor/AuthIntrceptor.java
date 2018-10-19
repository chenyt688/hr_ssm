package com.neuedu.hr.sys.terceptor;

import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.entity.User;
import com.neuedu.hr.sys.annotation.RequirePremission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AuthIntrceptor extends HandlerInterceptorAdapter {
    /**
     * 权限控制拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //RequirePremission annotation = method.getAnnotation(RequirePremission.class);

        HttpSession session = request.getSession(false);
        //判断session是否为空，如果是空，代表肯定没登录，直接冲重定向到login界面
        if (session != null){
            ArrayList<User> user = (ArrayList<User>) session.getAttribute("principal");
            if (user.get(0) != null) {
                boolean status = false;
                for (Menu m : user.get(0).getRoleList().get(0).getMenuList()) {
                    String url = request.getRequestURI();
                    String[] split = url.split("/");
                    if (m.getMenu_url().contains(split[1])) {
                        status = true;
                        break;
                    }
                }
                if (status) {
                    return true;
                } else {
                    response.sendRedirect(request.getContextPath() + "/");
                    return false;
                }


            }else {
                session.invalidate();
            }
        }
        response.sendRedirect(request.getContextPath() + "/");
        return false;
    }



}






















