package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Tactic;
import com.hungpk.threekingdomtactic.payload.request.TacticRequest;
import com.hungpk.threekingdomtactic.repository.TacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacticService {

    private final TacticRepository tacticRepository;

    private final ModelMapper modelMapper;

    public List<Tactic> getAll() {
        return tacticRepository.findAll();
    }

    public Tactic findById(Long id) {
        return tacticRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TacticRequest body) {
        var entity = modelMapper.map(body, Tactic.class);
        tacticRepository.save(entity);
    }

    public void update(Long id, TacticRequest body) {
        var entity = tacticRepository.findById(id).get();
        entity.setName(body.getName());
        tacticRepository.save(entity);
    }

    public void delete(Long id) {
        tacticRepository.deleteById(id);
    }
}
