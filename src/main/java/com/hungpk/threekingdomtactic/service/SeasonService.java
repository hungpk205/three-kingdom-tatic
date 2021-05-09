package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.model.Season;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.payload.request.SeasonRequest;
import com.hungpk.threekingdomtactic.repository.CountryRepository;
import com.hungpk.threekingdomtactic.repository.SeasonRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final SeasonRepository seasonRepository;

    private final ModelMapper modelMapper;

    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    public Season findById(Long id) {
        return seasonRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.CountryMsg.NOT_FOUND));
    }

    public void create(SeasonRequest body) {
        var entity = modelMapper.map(body, Season.class);
        seasonRepository.save(entity);
    }

    public void update(Long id, SeasonRequest body) {
        var entity = seasonRepository.findById(id).get();
        var newEntity = modelMapper.map(body, Season.class);
        newEntity.setId(id);
        seasonRepository.save(newEntity);
    }

    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }
}
