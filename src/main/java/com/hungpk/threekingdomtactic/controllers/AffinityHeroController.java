package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.affinityhero.AffinityHeroCreateRequest;
import com.hungpk.threekingdomtactic.payload.request.affinityhero.AffinityHeroUpdateRequest;
import com.hungpk.threekingdomtactic.service.AffinityHeroService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/affinity-heroes")
public class AffinityHeroController {

    private final AffinityHeroService affinityHeroService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = affinityHeroService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = affinityHeroService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody AffinityHeroCreateRequest body) {
        affinityHeroService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody AffinityHeroUpdateRequest body) {
        affinityHeroService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        affinityHeroService.delete(id);
        return Response.ok();
    }
}
