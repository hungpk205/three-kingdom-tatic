package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Tactic;
import com.hungpk.threekingdomtactic.payload.request.TacticRequest;
import com.hungpk.threekingdomtactic.payload.response.tactics.TacticResponse;
import com.hungpk.threekingdomtactic.repository.EffectRepository;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacticService {

    private final TacticRepository tacticRepository;
    private final EffectRepository effectRepository;

    private final ModelMapper modelMapper;

    public List<TacticResponse> getAll() {
         var entities = tacticRepository.findAll();
        return entities.stream().map(ele -> modelMapper.map(ele, TacticResponse.class)).collect(Collectors.toList());
    }

    public TacticResponse findById(Long id) {
        var entity = tacticRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, TacticResponse.class);
    }

    public void create(TacticRequest body) {
        var effect = effectRepository.findById(body.getEffect().getId())
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, Tactic.class);
        entity.setEffect(effect);
        tacticRepository.save(entity);
    }

    public void update(Long id, TacticRequest body) {
        var entity = tacticRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        modelMapper.map(body, Tactic.class);
        tacticRepository.save(entity);
    }

    public void delete(Long id) {
        tacticRepository.deleteById(id);
    }
}
