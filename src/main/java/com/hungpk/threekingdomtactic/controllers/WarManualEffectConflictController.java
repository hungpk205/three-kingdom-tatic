package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.WarManualApplyRequest;
import com.hungpk.threekingdomtactic.payload.request.WarManualEffectConflictRequest;
import com.hungpk.threekingdomtactic.service.WarManualEffectConflictService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/war-manual-effect-conflicts")
public class WarManualEffectConflictController {

    private final WarManualEffectConflictService warManualEffectConflictService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = warManualEffectConflictService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = warManualEffectConflictService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody WarManualEffectConflictRequest body) {
        warManualEffectConflictService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody WarManualEffectConflictRequest body) {
        warManualEffectConflictService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        warManualEffectConflictService.delete(id);
        return Response.ok();
    }
}
