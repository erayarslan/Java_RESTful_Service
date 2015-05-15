package com.toyota.tshop.util;

import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.toyota.tshop.dao.TokenDAO;
import com.toyota.tshop.dto.CustomResponseDTO;
import com.toyota.tshop.entity.Token;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor {
    @Autowired
    TokenDAO tokenDAO;

    private static final ServerResponse ACCESS_DENIED = new ServerResponse(
            new CustomResponseDTO("Access denied for this resource"),
            401,
            new Headers<Object>()
    );
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse(
            new CustomResponseDTO("Nobody can access this resource"),
            403,
            new Headers<Object>()
    );
    private static final ServerResponse SERVER_ERROR = new ServerResponse(
            new CustomResponseDTO("INTERNAL SERVER ERROR"),
            500,
            new Headers<Object>()
    );

    @Override
    public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethod resourceMethod) throws Failure, WebApplicationException {
        Method method = resourceMethod.getMethod();
        HttpHeaders httpHeaders = httpRequest.getHttpHeaders();
        if (method.isAnnotationPresent(NeedAuth.class)) {
            try {
                Token tokenObj = tokenDAO.existToken(httpHeaders.getRequestHeaders().get("token").get(0));
                httpRequest.setAttribute("user", tokenObj.getUser());
                httpRequest.setAttribute("token", tokenObj.getToken());
                return null;
            } catch (NoResultException ex) {
                return ACCESS_DENIED;
            }
        } else {
            return null;
        }
    }
}
