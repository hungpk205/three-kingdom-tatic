package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Country;
import com.hungpk.threekingdomtactic.model.HeroStat;
import com.hungpk.threekingdomtactic.payload.request.CountryRequest;
import com.hungpk.threekingdomtactic.payload.request.HeroStatRequest;
import com.hungpk.threekingdomtactic.repository.CountryRepository;
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

    private final ModelMapper modelMapper;

    public HeroStat findByHero(Long heroId) {
        return heroStatRepository.findByHeroId(heroId).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(HeroStatRequest body) {
        if (body.getHeroStat().stream().distinct().count() != 6
                || isExistedByHero(body.getHeroId())) {
            throw new SystemException(MessageUtils.INVALID_DATA);
        }
        body.getHeroStat().forEach(ele -> {
            var heroStat = modelMapper.map(ele, HeroStat.class);
            heroStat.setHeroId(body.getHeroId());
            heroStatRepository.save(heroStat);
        });
    }

    public void update(HeroStatRequest body) {
        if (body.getHeroStat().stream().distinct().count() != 6) {
            throw new SystemException(MessageUtils.INVALID_DATA);
        }
        body.getHeroStat().forEach(ele -> {
            var heroStat = modelMapper.map(ele, HeroStat.class);
            heroStat.setHeroId(body.getHeroId());
            heroStatRepository.save(heroStat);
        });
    }

    public void deleteByHero(Long heroId) {
        heroStatRepository.deleteByHeroId(heroId);
    }

    public boolean isExistedByHero(Long heroId) {
        return heroStatRepository.existsByHeroId(heroId);
    }
}
