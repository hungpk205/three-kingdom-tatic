package com.hungpk.threekingdomtactic.controllers;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import com.hungpk.threekingdomtactic.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public Response<Object> getAll() {
        var entities = countryService.getAll();
        return Response.ok().setPayload(entities);
    }

    @GetMapping("/{id}")
    public Response<Object> findOne(@PathVariable("id") Long id) {
        var entity = countryService.findById(id);
        return Response.ok().setPayload(entity);
    }

    @PostMapping
    public Response<Object> create(@RequestBody CountryRequest body) {
        countryService.create(body);
        return Response.ok();
    }

    @PutMapping("/{id}")
    public Response<Object> update(@PathVariable("id") Long id, @RequestBody CountryRequest body) {
        countryService.update(id, body);
        return Response.ok();
    }

    @DeleteMapping("/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {
        countryService.delete(id);
        return Response.ok();
    }
}
