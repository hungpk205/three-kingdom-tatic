package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.RecommendedTactic;
import com.hungpk.threekingdomtactic.payload.request.RecommendedTacticRequest;
import com.hungpk.threekingdomtactic.repository.RecommendedTacticRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendedTacticService {

    private final RecommendedTacticRepository recommendedTacticRepository;

    private final ModelMapper modelMapper;

    public List<RecommendedTactic> getAll() {
        return recommendedTacticRepository.findAll();
    }

    public RecommendedTactic findById(Long id) {
        return recommendedTacticRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(RecommendedTacticRequest body) {
        var entity = modelMapper.map(body, RecommendedTactic.class);
        recommendedTacticRepository.save(entity);
    }

    public void update(Long id, RecommendedTacticRequest body) {
        var entity = recommendedTacticRepository.findById(id).get();
        recommendedTacticRepository.save(entity);
    }

    public void delete(Long id) {
        recommendedTacticRepository.deleteById(id);
    }
}
