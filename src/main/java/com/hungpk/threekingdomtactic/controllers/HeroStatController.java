package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.HeroStatRequest;
import com.hungpk.threekingdomtactic.service.HeroStatService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heroes/{heroId}/stat")
public class HeroStatController {

    private final HeroStatService heroStatService;

    @GetMapping
    public Response<Object> getAllByHeroId(@PathVariable Long heroId) {
        var entities = heroStatService.findByHero(heroId);
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable Long heroId, @PathVariable("id") Long id) {
        var entity = heroStatService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@PathVariable Long heroId, @RequestBody List<HeroStatRequest> body) {
        heroStatService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody HeroStatRequest body) {
        heroStatService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping()
    public Response<Object> deleteByHeroId(@PathVariable Long heroId) {
        heroStatService.deleteByHero(heroId);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> deleteById(@PathVariable Long heroId, @PathVariable Long id) {
        heroStatService.deleteById(id);
        return Response.ok();
    }
}
