package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.HeroTroopRequest;
import com.hungpk.threekingdomtactic.service.HeroTroopService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heroes/{heroId}/troops")
public class HeroTroopController {

    private final HeroTroopService heroTroopService;

    @GetMapping
    public Response<Object> getAllByHeroId(@PathVariable Long heroId) {
        var entities = heroTroopService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = heroTroopService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody HeroTroopRequest body) {
        heroTroopService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody HeroTroopRequest body) {
        heroTroopService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        heroTroopService.delete(id);
        return Response.ok();
    }
}
