package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.RecommendedTactic;
import com.hungpk.threekingdomtactic.payload.request.RecommendedTacticRequest;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.RecommendedTacticRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendedTacticService {

    private final RecommendedTacticRepository recommendedTacticRepository;
    private final HeroRepository heroRepository;
    private final TacticRepository tacticRepository;

    private final ModelMapper modelMapper;

    public List<RecommendedTactic> getAll() {
        return recommendedTacticRepository.findAll();
    }

    public RecommendedTactic findById(Long id) {
        return recommendedTacticRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(RecommendedTacticRequest body) {
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));

        var entity = modelMapper.map(body, RecommendedTactic.class);
        entity.setHero(hero);
        entity.setTactic(tactic);
        recommendedTacticRepository.save(entity);
    }

    public void update(Long id, RecommendedTacticRequest body) {
        var entity = recommendedTacticRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setHero(hero);
        entity.setTactic(tactic);
        recommendedTacticRepository.save(entity);
    }

    public void delete(Long id) {
        recommendedTacticRepository.deleteById(id);
    }
}
