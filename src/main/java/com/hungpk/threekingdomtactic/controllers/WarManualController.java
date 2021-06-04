package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.WarManualRequest;
import com.hungpk.threekingdomtactic.service.WarManualService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/war-manuals")
public class WarManualController {

    private final WarManualService warManualService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = warManualService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = warManualService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody WarManualRequest body) {
        warManualService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody WarManualRequest body) {
        warManualService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        warManualService.delete(id);
        return Response.ok();
    }
}
