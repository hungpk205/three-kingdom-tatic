package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.TacticApplyRequest;
import com.hungpk.threekingdomtactic.service.TacticApplyService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tactic-applies")
public class TacticApplyController {

    private final TacticApplyService tacticApplyService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = tacticApplyService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = tacticApplyService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody TacticApplyRequest body) {
        tacticApplyService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody TacticApplyRequest body) {
        tacticApplyService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        tacticApplyService.delete(id);
        return Response.ok();
    }
}
