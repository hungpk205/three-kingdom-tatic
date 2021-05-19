package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Troop;
import com.hungpk.threekingdomtactic.payload.request.TroopRequest;
import com.hungpk.threekingdomtactic.repository.TroopRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TroopService {

    private final TroopRepository troopRepository;

    private final ModelMapper modelMapper;

    public List<Troop> getAll() {
        return troopRepository.findAll();
    }

    public Troop findById(Long id) {
        return troopRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TroopRequest body) {
        var entity = modelMapper.map(body, Troop.class);
        troopRepository.save(entity);
    }

    public void update(Long id, TroopRequest body) {
        var entity = troopRepository.findById(id).get();
        troopRepository.save(entity);
    }

    public void delete(Long id) {
        troopRepository.deleteById(id);
    }
}
