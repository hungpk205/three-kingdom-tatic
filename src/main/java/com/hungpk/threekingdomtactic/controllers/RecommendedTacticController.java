package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.RecommendedTacticRequest;
import com.hungpk.threekingdomtactic.service.RecommendedTacticService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommended-tactics")
public class RecommendedTacticController {

    private final RecommendedTacticService recommendedTacticService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = recommendedTacticService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = recommendedTacticService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody RecommendedTacticRequest body) {
        recommendedTacticService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody RecommendedTacticRequest body) {
        recommendedTacticService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        recommendedTacticService.delete(id);
        return Response.ok();
    }
}
