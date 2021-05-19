package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Stat;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.payload.request.StatRequest;
import com.hungpk.threekingdomtactic.repository.StatRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatService {

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;

    public List<Stat> getAll() {
        return statRepository.findAll();
    }

    public Stat findById(Long id) {
        return statRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(StatRequest body) {
        var entity = modelMapper.map(body, Stat.class);
        statRepository.save(entity);
    }

    public void update(Long id, StatRequest body) {
        var entity = statRepository.findById(id).get();
        entity.setName(body.getName());
        statRepository.save(entity);
    }

    public void delete(Long id) {
        statRepository.deleteById(id);
    }
}
