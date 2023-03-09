package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Lineup;
import com.hungpk.threekingdomtactic.payload.request.LineupRequest;
import com.hungpk.threekingdomtactic.repository.GroupRepository;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.LineupRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineupService {

    private final LineupRepository lineupRepository;
    private final HeroRepository heroRepository;
    private final GroupRepository groupRepository;

    private final ModelMapper modelMapper;

    public List<Lineup> getAll() {
        return lineupRepository.findAll();
    }

    public Lineup findById(Long id) {
        return lineupRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(LineupRequest body) {
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var group = groupRepository.findById(body.getGroup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, Lineup.class);
        entity.setHero(hero);
        entity.setGroup(group);
        lineupRepository.save(entity);
    }

    public void update(Long id, LineupRequest body) {
        var entity = lineupRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var hero = heroRepository.findById(body.getHero().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var group = groupRepository.findById(body.getGroup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setHero(hero);
        entity.setGroup(group);
        lineupRepository.save(entity);
    }

    public void delete(Long id) {
        lineupRepository.deleteById(id);
    }
}
