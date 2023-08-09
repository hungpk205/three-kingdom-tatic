package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.model.Hero;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.payload.request.HeroRequest;
import com.hungpk.threekingdomtactic.payload.response.heroes.HeroResponse;
import com.hungpk.threekingdomtactic.repository.CountryRepository;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.SeasonRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;
    private final TacticRepository tacticRepository;
    private final CountryRepository countryRepository;
    private final SeasonRepository seasonRepository;

    private final ModelMapper modelMapper;

    public List<HeroResponse> getAll() {
        var entities = heroRepository.findAll();
        return entities.stream().map(ele -> modelMapper.map(ele, HeroResponse.class)).collect(Collectors.toList());
    }

    public HeroResponse findById(Long id) {
        var entity = heroRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, HeroResponse.class);
    }

    public void create(HeroRequest body) {
        var entity = modelMapper.map(body, Hero.class);
        var tacticOfficial = tacticRepository.findById(body.getOfficialTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tacticInherit = tacticRepository.findById(body.getInheritTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var country = countryRepository.findById(body.getCountry().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var season = seasonRepository.findById(body.getSeason().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setOfficialTactic(tacticOfficial);
        entity.setInheritTactic(tacticInherit);
        entity.setCountry(country);
        entity.setSeason(season);
        heroRepository.save(entity);
    }

    public void update(Long id, HeroRequest body) {
        heroRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tacticOfficial = tacticRepository.findById(body.getOfficialTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tacticInherit = tacticRepository.findById(body.getInheritTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var country = countryRepository.findById(body.getCountry().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var season = seasonRepository.findById(body.getSeason().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, Hero.class);
        entity.setOfficialTactic(tacticOfficial);
        entity.setInheritTactic(tacticInherit);
        entity.setCountry(country);
        entity.setSeason(season);
        entity.setId(id);
        heroRepository.save(entity);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
