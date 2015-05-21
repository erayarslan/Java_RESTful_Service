package com.toyota.tshop.resource;

import com.toyota.tshop.dto.AuthDTO;
import com.toyota.tshop.dto.CustomResponseDTO;
import com.toyota.tshop.dto.RegisterDTO;
import com.toyota.tshop.service.MainService;
import com.toyota.tshop.util.NeedAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class MainResource {
    @Context
    private HttpServletRequest httpServletRequest;

    @Autowired
    private MainService mainService;

    @POST
    @Path("auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doAuth(AuthDTO authDTO) {
        String token;
        try {
            token = mainService.doAuth(
                    authDTO.getUsername(),
                    authDTO.getPassword(),
                    httpServletRequest.getHeader("User-Agent"),
                    httpServletRequest.getRemoteAddr()
            );
        } catch (Exception ex) {
            return Response.status(500).entity(new CustomResponseDTO(ex.getMessage())).build();
        }
        return Response.ok(new CustomResponseDTO(token)).build();
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doRegister(RegisterDTO registerDTO) {
        try {
            mainService.doRegister(
                    registerDTO.getUsername(),
                    registerDTO.getPassword()
            );
        } catch (Exception ex) {
            return Response.status(500).entity(new CustomResponseDTO(ex.getMessage())).build();
        }
        return Response.ok(new CustomResponseDTO("OK")).build();
    }

    @POST
    @Path("logout")
    @NeedAuth
    @Produces(MediaType.APPLICATION_JSON)
    public Response doLogout() {
        try {
            mainService.doLogout(
                    (String) httpServletRequest.getAttribute("token")
            );
        } catch (Exception ex) {
            return Response.status(500).entity(new CustomResponseDTO(ex.getMessage())).build();
        }
        return Response.ok(new CustomResponseDTO("OK")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response version() {
        return Response.ok(new CustomResponseDTO("0.0.1")).build();
    }
}
