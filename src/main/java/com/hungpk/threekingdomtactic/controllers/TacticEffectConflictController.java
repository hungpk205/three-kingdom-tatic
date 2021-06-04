package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.TacticEffectConflictRequest;
import com.hungpk.threekingdomtactic.service.TacticEffectConflictService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tactic-effect-conflicts")
public class TacticEffectConflictController {

    private final TacticEffectConflictService tacticEffectConflictService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = tacticEffectConflictService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = tacticEffectConflictService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody TacticEffectConflictRequest body) {
        tacticEffectConflictService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody TacticEffectConflictRequest body) {
        tacticEffectConflictService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        tacticEffectConflictService.delete(id);
        return Response.ok();
    }
}
