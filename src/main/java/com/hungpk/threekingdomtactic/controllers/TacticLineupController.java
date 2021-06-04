package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.LineupRequest;
import com.hungpk.threekingdomtactic.payload.request.TacticLineupRequest;
import com.hungpk.threekingdomtactic.service.TacticLineupService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tactic-lineups")
public class TacticLineupController {

    private final TacticLineupService tacticLineupService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = tacticLineupService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = tacticLineupService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody TacticLineupRequest body) {
        tacticLineupService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody TacticLineupRequest body) {
        tacticLineupService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        tacticLineupService.delete(id);
        return Response.ok();
    }
}
