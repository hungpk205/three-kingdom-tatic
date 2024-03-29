package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.TacticLineup;
import com.hungpk.threekingdomtactic.payload.request.AffinityRequest;
import com.hungpk.threekingdomtactic.payload.request.TacticLineupRequest;
import com.hungpk.threekingdomtactic.repository.LineupRepository;
import com.hungpk.threekingdomtactic.repository.TacticLineupRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacticLineupService {

    private final TacticLineupRepository tacticLineupRepository;
    private final TacticRepository tacticRepository;
    private final LineupRepository lineupRepository;

    private final ModelMapper modelMapper;

    public List<TacticLineup> getAll() {
        return tacticLineupRepository.findAll();
    }

    public TacticLineup findById(Long id) {
        return tacticLineupRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TacticLineupRequest body) {
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var lineup = lineupRepository.findById(body.getLineup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, TacticLineup.class);
        entity.setTactic(tactic);
        entity.setLineup(lineup);
        tacticLineupRepository.save(entity);
    }

    public void update(Long id, TacticLineupRequest body) {
        var entity = tacticLineupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var lineup = lineupRepository.findById(body.getLineup().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setTactic(tactic);
        entity.setLineup(lineup);
        tacticLineupRepository.save(entity);
    }

    public void delete(Long id) {
        tacticLineupRepository.deleteById(id);
    }
}
