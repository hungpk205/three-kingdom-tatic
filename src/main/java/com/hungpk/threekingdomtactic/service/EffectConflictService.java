package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.EffectConflict;
import com.hungpk.threekingdomtactic.payload.request.EffectConflictRequest;
import com.hungpk.threekingdomtactic.repository.EffectConflictRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EffectConflictService {

    private final EffectConflictRepository effectConflictRepository;

    private final ModelMapper modelMapper;

    public List<EffectConflict> getAll() {
        return effectConflictRepository.findAll();
    }

    public EffectConflict findById(Long id) {
        return effectConflictRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(EffectConflictRequest body) {
        var entity = modelMapper.map(body, EffectConflict.class);
        effectConflictRepository.save(entity);
    }

    public void update(Long id, EffectConflictRequest body) {
        var entity = effectConflictRepository.findById(id).get();
        entity.setName(body.getName());
        effectConflictRepository.save(entity);
    }

    public void delete(Long id) {
        effectConflictRepository.deleteById(id);
    }
}
