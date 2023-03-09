package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.TacticEffectConflict;
import com.hungpk.threekingdomtactic.payload.request.TacticEffectConflictRequest;
import com.hungpk.threekingdomtactic.repository.EffectConflictRepository;
import com.hungpk.threekingdomtactic.repository.TacticEffectConflictRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacticEffectConflictService {

    private final TacticEffectConflictRepository tacticEffectConflictRepository;
    private final TacticRepository tacticRepository;
    private final EffectConflictRepository effectConflictRepository;

    private final ModelMapper modelMapper;

    public List<TacticEffectConflict> getAll() {
        return tacticEffectConflictRepository.findAll();
    }

    public TacticEffectConflict findById(Long id) {
        return tacticEffectConflictRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    }

    public void create(TacticEffectConflictRequest body) {
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var effectConflict = effectConflictRepository.findById(body.getEffectConflict().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));

        var entity = modelMapper.map(body, TacticEffectConflict.class);
        entity.setTactic(tactic);
        entity.setEffectConflict(effectConflict);
        tacticEffectConflictRepository.save(entity);
    }

    public void update(Long id, TacticEffectConflictRequest body) {
        var entity = tacticEffectConflictRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var tactic = tacticRepository.findById(body.getTactic().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var effectConflict = effectConflictRepository.findById(body.getEffectConflict().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setTactic(tactic);
        entity.setEffectConflict(effectConflict);
        tacticEffectConflictRepository.save(entity);
    }

    public void delete(Long id) {
        tacticEffectConflictRepository.deleteById(id);
    }
}
