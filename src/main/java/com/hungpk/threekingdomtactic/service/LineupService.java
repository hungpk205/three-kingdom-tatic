package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Lineup;
import com.hungpk.threekingdomtactic.payload.request.LineupRequest;
import com.hungpk.threekingdomtactic.repository.LineupRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineupService {

    private final LineupRepository lineupRepository;

    private final ModelMapper modelMapper;

    public List<Lineup> getAll() {
        return lineupRepository.findAll();
    }

    public Lineup findById(Long id) {
        return lineupRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(LineupRequest body) {
        var entity = modelMapper.map(body, Lineup.class);
        lineupRepository.save(entity);
    }

    public void update(Long id, LineupRequest body) {
        var entity = lineupRepository.findById(id).get();
        lineupRepository.save(entity);
    }

    public void delete(Long id) {
        lineupRepository.deleteById(id);
    }
}
