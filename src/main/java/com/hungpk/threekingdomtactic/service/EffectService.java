package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Effect;
import com.hungpk.threekingdomtactic.payload.request.EffectRequest;
import com.hungpk.threekingdomtactic.repository.EffectRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final EffectRepository effectRepository;

    private final ModelMapper modelMapper;

    public List<Effect> getAll() {
        return effectRepository.findAll();
    }

    public Effect findById(Long id) {
        return effectRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(EffectRequest body) {
        var entity = modelMapper.map(body, Effect.class);
        effectRepository.save(entity);
    }

    public void update(Long id, EffectRequest body) {
        var entity = effectRepository.findById(id).get();
        entity.setName(body.getName());
        effectRepository.save(entity);
    }

    public void delete(Long id) {
        effectRepository.deleteById(id);
    }
}
