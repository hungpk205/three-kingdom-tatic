package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.HeroStat;
import com.hungpk.threekingdomtactic.payload.request.HeroStatRequest;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.HeroStatRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroStatService {

    private final HeroStatRepository heroStatRepository;

    private final HeroRepository heroRepository;

    private final ModelMapper modelMapper;

    public List<HeroStat> findByHero(Long heroId) {
        return heroStatRepository.findByHeroId(heroId);
    }

    public HeroStat findById(Long id) {
        return heroStatRepository.findById(id)
                .orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(List<HeroStatRequest> body) {
        if (body.size() != 6) {
            throw new SystemException(MessageUtils.INVALID_DATA);
        }
        body.forEach(ele -> {
            if (isExistedByHeroIdAndStatId(ele.getHeroId(), ele.getStatId())) {
                throw new SystemException(MessageUtils.INVALID_DATA);
            }
            var heroStat = modelMapper.map(ele, HeroStat.class);
            heroStatRepository.save(heroStat);
        });
    }

    public void update(Long id, HeroStatRequest body) {
        heroRepository.findById(body.getHeroId()).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        heroStatRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
        var heroStat = modelMapper.map(body, HeroStat.class);
        heroStatRepository.save(heroStat);
    }

    public void deleteByHero(Long heroId) {
        heroStatRepository.deleteByHeroId(heroId);
    }

    public void deleteById(Long id) {
        heroStatRepository.deleteById(id);
    }

    public boolean isExistedByHeroIdAndStatId(Long heroId, Long statId) {
        return heroStatRepository.existsByHeroIdAndStatId(heroId, statId);
    }
}
