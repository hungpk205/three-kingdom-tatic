package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Affinity;
import com.hungpk.threekingdomtactic.model.AffinityHero;
import com.hungpk.threekingdomtactic.payload.request.AffinityHeroRequest;
import com.hungpk.threekingdomtactic.payload.request.AffinityRequest;
import com.hungpk.threekingdomtactic.repository.AffinityHeroRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AffinityHeroService {

    private final AffinityHeroRepository affinityHeroRepository;

    private final ModelMapper modelMapper;

    public List<AffinityHero> getAll() {
        return affinityHeroRepository.findAll();
    }

    public AffinityHero findById(Long id) {
        return affinityHeroRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(AffinityHeroRequest body) {
        var entity = modelMapper.map(body, AffinityHero.class);
        affinityHeroRepository.save(entity);
    }

    public void update(Long id, AffinityHeroRequest body) {
        var entity = affinityHeroRepository.findById(id)
                .orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        entity.setHeroId(body.getHero().getId());
        entity.setAffinityId(body.getAffinity().getId());
        affinityHeroRepository.save(entity);
    }

    public void delete(Long id) {
        affinityHeroRepository.deleteById(id);
    }
}
