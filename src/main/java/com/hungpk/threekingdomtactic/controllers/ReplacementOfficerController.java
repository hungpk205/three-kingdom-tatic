package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.payload.request.ReplacementOfficerRequest;
import com.hungpk.threekingdomtactic.service.ReplacementOfficerService;
import com.hungpk.threekingdomtactic.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/replacement-officers")
public class ReplacementOfficerController {

    private final ReplacementOfficerService replacementOfficerService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = replacementOfficerService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = replacementOfficerService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody ReplacementOfficerRequest body) {
        replacementOfficerService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody ReplacementOfficerRequest body) {
        replacementOfficerService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        replacementOfficerService.delete(id);
        return Response.ok();
    }
}
