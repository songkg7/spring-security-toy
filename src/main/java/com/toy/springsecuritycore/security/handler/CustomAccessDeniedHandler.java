package com.toy.springsecuritycore.security.handler;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException {
        String deniedUrl = errorPage + "?exception=" + accessDeniedException.getMessage();
        log.info("CustomAccessDeniedHandler.handle");
        response.sendRedirect(deniedUrl);
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

}
