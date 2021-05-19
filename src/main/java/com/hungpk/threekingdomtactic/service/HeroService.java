package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.model.Hero;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.repository.CountryRepository;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    private final ModelMapper modelMapper;

    public List<Hero> getAll() {
        return heroRepository.findAll();
    }

    public Hero findById(Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(CountryRequest body) {
        var entity = modelMapper.map(body, Hero.class);
        heroRepository.save(entity);
    }

    public void update(Long id, CountryRequest body) {
        var entity = heroRepository.findById(id).get();
        entity.setName(body.getName());
        heroRepository.save(entity);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
