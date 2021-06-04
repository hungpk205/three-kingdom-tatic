package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.TacticEffectConflict;
import com.hungpk.threekingdomtactic.payload.request.TacticEffectConflictRequest;
import com.hungpk.threekingdomtactic.repository.TacticEffectConflictRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacticEffectConflictService {

    private final TacticEffectConflictRepository tacticEffectConflictRepository;

    private final ModelMapper modelMapper;

    public List<TacticEffectConflict> getAll() {
        return tacticEffectConflictRepository.findAll();
    }

    public TacticEffectConflict findById(Long id) {
        return tacticEffectConflictRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TacticEffectConflictRequest body) {
        var entity = modelMapper.map(body, TacticEffectConflict.class);
        tacticEffectConflictRepository.save(entity);
    }

    public void update(Long id, TacticEffectConflictRequest body) {
        var entity = tacticEffectConflictRepository.findById(id).get();
        tacticEffectConflictRepository.save(entity);
    }

    public void delete(Long id) {
        tacticEffectConflictRepository.deleteById(id);
    }
}
