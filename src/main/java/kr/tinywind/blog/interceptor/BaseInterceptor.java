package kr.tinywind.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tinywind on 2016-06-20.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
    protected void redirect(HttpServletResponse response, String url) throws Exception {
        response.getWriter().write(String.format(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta http-equiv=\"refresh\" content=\"0;url=%s\" data-state=\"false\">\n" +
                        "    <title>Redirecting</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "</body>\n" +
                        "</html>",
                url
        ));
        response.setContentType("text/html;charset=UTF-8");
    }
}
