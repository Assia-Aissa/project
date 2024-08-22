package com.pfe.project.modeles;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public static String getSiteURL(HttpServletRequest request) {
        String protocol = request.getScheme();
        String host = request.getServerName();
        int port = request.getServerPort();
        return protocol + "://" + host + ":" + port;
    }
}