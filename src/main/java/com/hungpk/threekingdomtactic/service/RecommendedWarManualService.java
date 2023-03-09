package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.RecommendedWarManual;
import com.hungpk.threekingdomtactic.payload.request.RecommendedWarManualRequest;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.RecommendedWarManualRepository;
import com.hungpk.threekingdomtactic.repository.WarManualRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendedWarManualService {

    private final RecommendedWarManualRepository recommendedWarManualRepository;
    private final HeroRepository heroRepository;
    private final WarManualRepository warManualRepository;

    private final ModelMapper modelMapper;

    public List<RecommendedWarManual> getAll() {
        return recommendedWarManualRepository.findAll();
    }

    public RecommendedWarManual findById(Long id) {
        return recommendedWarManualRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(RecommendedWarManualRequest body) {
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, RecommendedWarManual.class);
        entity.setHero(hero);
        entity.setWarManual(warManual);
        recommendedWarManualRepository.save(entity);
    }

    public void update(Long id, RecommendedWarManualRequest body) {
        var entity = recommendedWarManualRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setHero(hero);
        entity.setWarManual(warManual);
        recommendedWarManualRepository.save(entity);
    }

    public void delete(Long id) {
        recommendedWarManualRepository.deleteById(id);
    }
}
