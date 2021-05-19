package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.WarManual;
import com.hungpk.threekingdomtactic.payload.request.WarManualRequest;
import com.hungpk.threekingdomtactic.repository.WarManualRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarManualService {

    private final WarManualRepository warManualRepository;

    private final ModelMapper modelMapper;

    public List<WarManual> getAll() {
        return warManualRepository.findAll();
    }

    public WarManual findById(Long id) {
        return warManualRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(WarManualRequest body) {
        var entity = modelMapper.map(body, WarManual.class);
        warManualRepository.save(entity);
    }

    public void update(Long id, WarManualRequest body) {
        var entity = warManualRepository.findById(id).get();
        entity.setName(body.getName());
        warManualRepository.save(entity);
    }

    public void delete(Long id) {
        warManualRepository.deleteById(id);
    }
}
