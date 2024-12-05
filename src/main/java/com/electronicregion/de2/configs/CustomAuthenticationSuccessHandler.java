package com.electronicregion.de2.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = request.getContextPath();

        String rememberMe = request.getParameter("remember_me");


        if ("on".equals(rememberMe)) {
            request.getSession().setMaxInactiveInterval(60 * 60 * 24);
            System.out.println("Сессия после обработки: СОЗДАНА вручную на 1 день");
        } else {
            request.getSession().setMaxInactiveInterval(0);
            System.out.println("Сессия после обработки: Не создаём сессию, флаг отсутствует");
        }


        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            redirectURL = "/admin";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            redirectURL = "/user";
        }

        response.sendRedirect(redirectURL);
    }
}
