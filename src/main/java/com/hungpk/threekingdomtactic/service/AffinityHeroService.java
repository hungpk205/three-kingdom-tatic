package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.model.AffinityHero;
import com.hungpk.threekingdomtactic.payload.request.affinityhero.AffinityHeroCreateRequest;
import com.hungpk.threekingdomtactic.payload.request.affinityhero.AffinityHeroUpdateRequest;
import com.hungpk.threekingdomtactic.payload.response.affinityheroes.AffinityHeroResponse;
import com.hungpk.threekingdomtactic.repository.AffinityHeroRepository;
import com.hungpk.threekingdomtactic.repository.AffinityRepository;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AffinityHeroService {

    private final AffinityHeroRepository affinityHeroRepository;
    private final HeroRepository heroRepository;
    private final AffinityRepository affinityRepository;

    private final ModelMapper modelMapper;

    public List<AffinityHeroResponse> getAll() {
        var entities = affinityHeroRepository.findAll();
        return entities.stream().map(e -> modelMapper.map(e, AffinityHeroResponse.class)).collect(Collectors.toList());
    }

    public AffinityHeroResponse findById(Long id) {
        var entity = affinityHeroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, AffinityHeroResponse.class);
    }


    @Transactional
    public void create(AffinityHeroCreateRequest body) {
        var affinity = affinityRepository.findById(body.getAffinityId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        body.getHero().forEach(e -> {
            var hero = heroRepository.findById(e)
                    .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
            var entity = modelMapper.map(body, AffinityHero.class);
            entity.setHero(hero);
            entity.setAffinity(affinity);
            affinityHeroRepository.save(entity);
        });
    }

    @Transactional
    public void update(Long id, AffinityHeroUpdateRequest body) {
        var entity = affinityHeroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHeroId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var affinity = affinityRepository.findById(body.getAffinityId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity = modelMapper.map(body, AffinityHero.class);
        entity.setId(id);
        entity.setHero(hero);
        entity.setAffinity(affinity);
        affinityHeroRepository.save(entity);
    }

    public void delete(Long id) {
        affinityHeroRepository.deleteById(id);
    }
}
