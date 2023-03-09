package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.WarManual;
import com.hungpk.threekingdomtactic.model.WarManualApply;
import com.hungpk.threekingdomtactic.payload.request.WarManualApplyRequest;
import com.hungpk.threekingdomtactic.payload.request.WarManualRequest;
import com.hungpk.threekingdomtactic.repository.TroopRepository;
import com.hungpk.threekingdomtactic.repository.WarManualApplyRepository;
import com.hungpk.threekingdomtactic.repository.WarManualRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarManualApplyService {

    private final WarManualApplyRepository warManualApplyRepository;
    private final TroopRepository troopRepository;
    private final WarManualRepository warManualRepository;

    private final ModelMapper modelMapper;

    public List<WarManualApply> getAll() {
        return warManualApplyRepository.findAll();
    }

    public WarManualApply findById(Long id) {
        return warManualApplyRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    }

    public void create(WarManualApplyRequest body) {
        var troop = troopRepository.findById(body.getTroop().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));

        var entity = modelMapper.map(body, WarManualApply.class);
        entity.setTroop(troop);
        entity.setWarManual(warManual);
        warManualApplyRepository.save(entity);
    }

    public void update(Long id, WarManualApplyRequest body) {
        var entity = warManualApplyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var troop = troopRepository.findById(body.getTroop().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var warManual = warManualRepository.findById(body.getWarManual().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setTroop(troop);
        entity.setWarManual(warManual);
        warManualApplyRepository.save(entity);
    }

    public void delete(Long id) {
        warManualApplyRepository.deleteById(id);
    }
}
