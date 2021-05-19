package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.TacticApply;
import com.hungpk.threekingdomtactic.payload.request.TacticApplyRequest;
import com.hungpk.threekingdomtactic.repository.TacticApplyRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacticApplyService {

    private final TacticApplyRepository tacticApplyRepository;

    private final ModelMapper modelMapper;

    public List<TacticApply> getAll() {
        return tacticApplyRepository.findAll();
    }

    public TacticApply findById(Long id) {
        return tacticApplyRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(TacticApplyRequest body) {
        var entity = modelMapper.map(body, TacticApply.class);
        tacticApplyRepository.save(entity);
    }

    public void update(Long id, TacticApplyRequest body) {
        var entity = tacticApplyRepository.findById(id).get();
        tacticApplyRepository.save(entity);
    }

    public void delete(Long id) {
        tacticApplyRepository.deleteById(id);
    }
}
