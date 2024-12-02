package com.electronicregion.de2.conrollers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String login() {

        return "login"; // Находится в папке: src/main/resources/templates/login.html
    }
    @PostMapping("")
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        System.out.println("1234");
            session.setAttribute("session_id", session.getId());
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            // Сохранение логина и пароля в сессии

            // Установка времени жизни сессии (30 дней)
            session.setMaxInactiveInterval(30 * 24 * 60 * 60); // 30 дней в секундах

            return "redirect:/admin"; // Перенаправление на главную страницу

    }
}
