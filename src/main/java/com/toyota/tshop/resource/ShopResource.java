package com.toyota.tshop.resource;

import com.toyota.tshop.dto.CustomResponseDTO;
import com.toyota.tshop.dto.ShopDTO;
import com.toyota.tshop.entity.User;
import com.toyota.tshop.service.ShopService;
import com.toyota.tshop.util.NeedAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/shops/")
public class ShopResource {
    @Context
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ShopService shopService;

    @GET
    @NeedAuth
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShops() {
        User user = (User)httpServletRequest.getAttribute("user");
        //
        return Response.ok(shopService.getAll()).build();
    }

    @GET
    @NeedAuth
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShopWithID(@PathParam("id") int id) {
        User user = (User)httpServletRequest.getAttribute("user");
        //
        return Response.ok(shopService.getByID(id)).build();
    }

    @POST
    @NeedAuth
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShop(ShopDTO shopDTO) {
        User user = (User)httpServletRequest.getAttribute("user");
        //
        shopService.persistShop(shopDTO);
        return Response.ok(new CustomResponseDTO("OK")).build();
    }

    @PUT
    @NeedAuth
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateShop(@PathParam("id") int id, ShopDTO shopDTO) {
        User user = (User)httpServletRequest.getAttribute("user");
        //
        shopService.updateShop(id, shopDTO);
        return Response.ok(new CustomResponseDTO("OK")).build();
    }

    @DELETE
    @NeedAuth
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeShop(@PathParam("id") int id) {
        User user = (User)httpServletRequest.getAttribute("user");
        //
        shopService.deleteShop(id);
        return Response.ok(new CustomResponseDTO("OK")).build();
    }
}
