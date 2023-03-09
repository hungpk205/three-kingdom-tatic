package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.model.WarManualEffectConflict;
import com.hungpk.threekingdomtactic.payload.request.WarManualEffectConflictRequest;
import com.hungpk.threekingdomtactic.repository.EffectConflictRepository;
import com.hungpk.threekingdomtactic.repository.WarManualEffectConflictRepository;
import com.hungpk.threekingdomtactic.repository.WarManualRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarManualEffectConflictService {

    private final WarManualEffectConflictRepository warManualEffectConflictRepository;
    private final EffectConflictRepository effectConflictRepository;
    private final WarManualRepository warManualRepository;

    private final ModelMapper modelMapper;

    public List<WarManualEffectConflict> getAll() {
        return warManualEffectConflictRepository.findAll();
    }

    public WarManualEffectConflict findById(Long id) {
        return warManualEffectConflictRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    }

    public void create(WarManualEffectConflictRequest body) {
        var effect = effectConflictRepository.findById(body.getEffectConflict().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));

        var entity = modelMapper.map(body, WarManualEffectConflict.class);
        entity.setEffectConflict(effect);
        entity.setWarManual(warManual);
        warManualEffectConflictRepository.save(entity);
    }

    public void update(Long id, WarManualEffectConflictRequest body) {
        var entity = warManualEffectConflictRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var effect = effectConflictRepository.findById(body.getEffectConflict().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setEffectConflict(effect);
        entity.setWarManual(warManual);
        warManualEffectConflictRepository.save(entity);
    }

    public void delete(Long id) {
        warManualEffectConflictRepository.deleteById(id);
    }
}
