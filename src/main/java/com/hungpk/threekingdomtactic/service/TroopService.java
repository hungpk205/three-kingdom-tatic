package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Troop;
import com.hungpk.threekingdomtactic.payload.request.TroopRequest;
import com.hungpk.threekingdomtactic.payload.response.troop.TroopResponse;
import com.hungpk.threekingdomtactic.repository.TroopRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TroopService {

    private final TroopRepository troopRepository;

    private final ModelMapper modelMapper;

    public List<TroopResponse> getAll() {
        var entities = troopRepository.findAll();
        return entities.stream().map(e -> modelMapper.map(e, TroopResponse.class)).collect(Collectors.toList());
    }

    public TroopResponse findById(Long id) {
        var entity = troopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        return modelMapper.map(entity, TroopResponse.class);
    }

    public void create(TroopRequest body) {
        var entity = modelMapper.map(body, Troop.class);
        troopRepository.save(entity);
    }

    public void update(Long id, TroopRequest body) {
        troopRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
        var entity = modelMapper.map(body, Troop.class);
        entity.setId(id);
        troopRepository.save(entity);
    }

    public void delete(Long id) {
        troopRepository.deleteById(id);
    }
}
