package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.ReplacementOfficer;
import com.hungpk.threekingdomtactic.payload.request.ReplacementOfficerRequest;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.LineupRepository;
import com.hungpk.threekingdomtactic.repository.ReplacementOfficerRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplacementOfficerService {

    private final ReplacementOfficerRepository replacementOfficerRepository;
    private final LineupRepository lineupRepository;
    private final HeroRepository heroRepository;

    private final ModelMapper modelMapper;

    public List<ReplacementOfficer> getAll() {
        return replacementOfficerRepository.findAll();
    }

    public ReplacementOfficer findById(Long id) {
        return replacementOfficerRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(ReplacementOfficerRequest body) {
        var lineup = lineupRepository.findById(body.getLineup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, ReplacementOfficer.class);
        entity.setHero(hero);
        entity.setLineup(lineup);
        replacementOfficerRepository.save(entity);
    }

    public void update(Long id, ReplacementOfficerRequest body) {
        var entity = replacementOfficerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var lineup = lineupRepository.findById(body.getLineup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setHero(hero);
        entity.setLineup(lineup);
        replacementOfficerRepository.save(entity);
    }

    public void delete(Long id) {
        replacementOfficerRepository.deleteById(id);
    }
}
