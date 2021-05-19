package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Affinity;
import com.hungpk.threekingdomtactic.payload.request.AffinityRequest;
import com.hungpk.threekingdomtactic.repository.AffinityRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AffinityService {

    private final AffinityRepository affinityRepository;

    private final ModelMapper modelMapper;

    public List<Affinity> getAll() {
        return affinityRepository.findAll();
    }

    public Affinity findById(Long id) {
        return affinityRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(AffinityRequest body) {
        var entity = modelMapper.map(body, Affinity.class);
        affinityRepository.save(entity);
    }

    public void update(Long id, AffinityRequest body) {
        var entity = affinityRepository.findById(id).get();
        entity.setName(body.getName());
        affinityRepository.save(entity);
    }

    public void delete(Long id) {
        affinityRepository.deleteById(id);
    }
}
