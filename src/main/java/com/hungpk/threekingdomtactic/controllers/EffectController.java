package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.EffectRequest;
import com.hungpk.threekingdomtactic.service.EffectService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/effects")
public class EffectController {

    private final EffectService effectService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = effectService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = effectService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody EffectRequest body) {
        effectService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody EffectRequest body) {
        effectService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        effectService.delete(id);
        return Response.ok();
    }
}
