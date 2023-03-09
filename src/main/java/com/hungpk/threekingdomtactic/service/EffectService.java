package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Effect;
import com.hungpk.threekingdomtactic.payload.request.EffectRequest;
import com.hungpk.threekingdomtactic.payload.response.effects.EffectResponse;
import com.hungpk.threekingdomtactic.repository.EffectRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final EffectRepository effectRepository;

    private final ModelMapper modelMapper;

    public List<EffectResponse> getAll() {
        var entities = effectRepository.findAll();
        return entities.stream().map(ele -> modelMapper.map(ele, EffectResponse.class)).collect(Collectors.toList());
    }

    public EffectResponse findById(Long id) {
        var entity = effectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, EffectResponse.class);
    }

    public void create(EffectRequest body) {
        var entity = modelMapper.map(body, Effect.class);
        effectRepository.save(entity);
    }

    public void update(Long id, EffectRequest body) {
        var entity = effectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity.setName(body.getName());
        effectRepository.save(entity);
    }

    public void delete(Long id) {
        effectRepository.deleteById(id);
    }
}
