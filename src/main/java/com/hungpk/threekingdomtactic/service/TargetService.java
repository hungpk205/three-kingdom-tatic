package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Target;
import com.hungpk.threekingdomtactic.payload.request.TargetRequest;
import com.hungpk.threekingdomtactic.repository.TargetRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TargetService {

    private final TargetRepository targetRepository;

    private final ModelMapper modelMapper;

    public List<Target> getAll() {
        return targetRepository.findAll();
    }

    public Target findById(Long id) {
        return targetRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TargetRequest body) {
        var entity = modelMapper.map(body, Target.class);
        targetRepository.save(entity);
    }

    public void update(Long id, TargetRequest body) {
        var entity = targetRepository.findById(id).get();
        entity.setName(body.getName());
        targetRepository.save(entity);
    }

    public void delete(Long id) {
        targetRepository.deleteById(id);
    }
}
