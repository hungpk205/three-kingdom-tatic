package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.GroupRequest;
import com.hungpk.threekingdomtactic.payload.request.LineupRequest;
import com.hungpk.threekingdomtactic.service.LineupService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lineups")
public class LineupController {

    private final LineupService lineupService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = lineupService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = lineupService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody LineupRequest body) {
        lineupService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody LineupRequest body) {
        lineupService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        lineupService.delete(id);
        return Response.ok();
    }
}
