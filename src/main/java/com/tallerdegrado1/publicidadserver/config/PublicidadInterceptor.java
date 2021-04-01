package com.tallerdegrado1.publicidadserver.config;

import io.jsonwebtoken.Jwts;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.charset.StandardCharsets;

import static com.tallerdegrado1.publicidadserver.config.ConstantePublicidad.CLAVE_BEARER;
import static com.tallerdegrado1.publicidadserver.config.ConstantePublicidad.CLAVE_TOKEN;


@Configuration
public class PublicidadInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("hola");
//        System.out.println(request.getRequestURI());
//        String rutaLogin="/publicidad/rest/usuario/login";
//
//        String rutaRegistroUsuario="/publicidad/rest/usuario/registrar";
//        if(!request.getRequestURI().equals(rutaLogin) && !request.getRequestURI().equals(rutaRegistroUsuario)) {
//
//        }
//        String token = request.getHeader("Authorization");
//        System.out.println("token");
//        System.out.println(token);
//        byte[] clave = CLAVE_TOKEN.getBytes();
//        if(token!=null) {
//            String user = Jwts.parser()
//                    .setSigningKey(CLAVE_TOKEN)
//                    .parseClaimsJws(token.replace("Bearer ",""))
//                    .getBody()
//                    .getSubject();
//            System.out.println("user");
//            System.out.println(user);
//        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
