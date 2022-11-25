package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class interceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果登入session存在就放行
        if (request.getSession().getAttribute(Constant.LoginUser) !=null){
            return true;
        }
        return false;
    }
}
