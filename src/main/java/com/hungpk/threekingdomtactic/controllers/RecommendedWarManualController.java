package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.RecommendedWarManualRequest;
import com.hungpk.threekingdomtactic.service.RecommendedWarManualService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommended-war-manuals")
public class RecommendedWarManualController {

    private final RecommendedWarManualService recommendedWarManualService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = recommendedWarManualService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = recommendedWarManualService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody RecommendedWarManualRequest body) {
        recommendedWarManualService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody RecommendedWarManualRequest body) {
        recommendedWarManualService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        recommendedWarManualService.delete(id);
        return Response.ok();
    }
}
