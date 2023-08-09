package com.hungpk.threekingdomtactic.service;

import java.util.List;
import java.util.Optional;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    private final ModelMapper modelMapper;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(CountryRequest body) {
        var entity = modelMapper.map(body, Country.class);
        countryRepository.save(entity);
    }

    public void update(Long id, CountryRequest body) {
        countryRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        var newEntity = modelMapper.map(body, Country.class);
        newEntity.setId(id);
        countryRepository.save(newEntity);
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
