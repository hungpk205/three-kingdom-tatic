package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.WarManualApplyRequest;
import com.hungpk.threekingdomtactic.service.WarManualApplyService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/war-manual-applies")
public class WarManualApplyController {

    private final WarManualApplyService warManualApplyService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = warManualApplyService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = warManualApplyService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody WarManualApplyRequest body) {
        warManualApplyService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody WarManualApplyRequest body) {
        warManualApplyService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        warManualApplyService.delete(id);
        return Response.ok();
    }
}
