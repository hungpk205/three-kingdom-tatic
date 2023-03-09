package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.HeroTroop;
import com.hungpk.threekingdomtactic.payload.request.HeroTroopRequest;
import com.hungpk.threekingdomtactic.repository.HeroTroopRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroTroopService {

    private final HeroTroopRepository heroTroopRepository;

    private final ModelMapper modelMapper;

    public List<HeroTroop> getAll() {
        return heroTroopRepository.findAll();
    }

    public HeroTroop findById(Long id) {
        return heroTroopRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(HeroTroopRequest body) {
        var entity = modelMapper.map(body, HeroTroop.class);
        heroTroopRepository.save(entity);
    }

    public void update(Long id, HeroTroopRequest body) {
        var entity = heroTroopRepository.findById(id)
                .orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        entity.setQuality(body.getQuality());
        entity.setHeroId(body.getHero().getId());
        entity.setTroopId(body.getTroop().getId());
        heroTroopRepository.save(entity);
    }

    public void delete(Long id) {
        heroTroopRepository.deleteById(id);
    }
}
