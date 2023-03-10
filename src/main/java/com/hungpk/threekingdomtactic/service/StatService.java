package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.model.Stat;
import com.hungpk.threekingdomtactic.payload.request.StatRequest;
import com.hungpk.threekingdomtactic.payload.response.stats.StatResponse;
import com.hungpk.threekingdomtactic.repository.StatRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatService {

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;

    public List<StatResponse> getAll() {
        var entities = statRepository.findAll();
        return entities.stream().map(e -> modelMapper.map(e, StatResponse.class)).collect(Collectors.toList());
    }

    public StatResponse findById(Long id) {
        var entity = statRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, StatResponse.class);
    }

    public void create(StatRequest body) {
        var entity = modelMapper.map(body, Stat.class);
        statRepository.save(entity);
    }

    public void update(Long id, StatRequest body) {
        var entity = statRepository.findById(id).orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        entity = modelMapper.map(body, Stat.class);
        entity.setId(id);
        statRepository.save(entity);
    }

    public void delete(Long id) {
        statRepository.deleteById(id);
    }
}
