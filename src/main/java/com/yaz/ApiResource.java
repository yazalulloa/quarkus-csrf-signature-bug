package com.yaz;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/api")
public class ApiResource {

  public static final SecureRandom RANDOM = new SecureRandom();
  private static final AtomicLong COUNTER = new AtomicLong(0);

  private final Template table;

  public ApiResource(Template table) {
    this.table = table;
  }

  @GET
  @Path("get")
  public Response getRequest() {
    return Response.noContent().build();
  }

  @POST
  @Path("post")
  public Response postRequest() {
    return Response.noContent().build();
  }

  @PUT
  @Path("put")
  public Response putRequest() {
    return Response.noContent().build();
  }

  @DELETE
  @Path("delete")
  public Response deleteRequest() {
    return Response.noContent().build();
  }

  @GET
  @Path("table")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance table() {

    final var list = Stream.generate(COUNTER::incrementAndGet)
        .limit(10)
        .map(Objects::toString)
        .collect(Collectors.toList());

    return table.data("list", list);
  }
}
