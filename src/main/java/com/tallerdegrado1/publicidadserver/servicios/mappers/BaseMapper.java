package com.tallerdegrado1.publicidadserver.servicios.mappers;


import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapper<Request, Response, Modelo> {

    public abstract Modelo toEntity(Request request);

    public abstract Response toDto(Modelo modelo);

    public List<Modelo> toEntity(List<Request> requests) {
        List<Modelo> entities = new ArrayList<>();
        for (Request request : requests) {
            entities.add(toEntity(request));
        }
        return entities;
    }

    public List<Response> toDto(List<Modelo> entities) {
        List<Response> responses = new ArrayList<>();
        for (Modelo modelo : entities) {
            responses.add(toDto(modelo));
        }
        return responses;
    }

}