package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.model.Hero;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.payload.request.HeroRequest;
import com.hungpk.threekingdomtactic.repository.CountryRepository;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    private final TacticRepository tacticRepository;

    private final ModelMapper modelMapper;

    public List<Hero> getAll() {
        return heroRepository.findAll();
    }

    public Hero findById(Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(HeroRequest body) {
        var entity = modelMapper.map(body, Hero.class);
        var tacticOfficial = tacticRepository.findById(body.getOfficialTactic().getId())
                .orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        var tacticInherit = tacticRepository.findById(body.getInheritTactic().getId())
                .orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        entity.setOfficialTactic(tacticOfficial);
        entity.setInheritTactic(tacticInherit);
        heroRepository.save(entity);
    }

    public void update(Long id, HeroRequest body) {
        var entity = heroRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        entity.setName(body.getName());
        entity.setNameVn(body.getNameVn());
        entity.setCost(body.getCost());
        entity.setStar(body.getStar());
        entity.setInfo(body.getInfo());
        entity.setImage(body.getImage());
        heroRepository.save(entity);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
