package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.NotFoundException;
import com.hungpk.threekingdomtactic.config.exception.ValidationException;
import com.hungpk.threekingdomtactic.enums.StatEnum;
import com.hungpk.threekingdomtactic.model.HeroStat;
import com.hungpk.threekingdomtactic.payload.request.HeroStatRequest;
import com.hungpk.threekingdomtactic.payload.response.herostats.HeroStatResponse;
import com.hungpk.threekingdomtactic.repository.HeroRepository;
import com.hungpk.threekingdomtactic.repository.HeroStatRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroStatService {

  private final HeroStatRepository heroStatRepository;
  private final HeroRepository heroRepository;

  private final ModelMapper modelMapper;

  public List<HeroStatResponse> findByHero(Long heroId) {
    var entities = heroStatRepository.findByHeroId(heroId);
    return entities.stream().map(e -> modelMapper.map(e, HeroStatResponse.class)).collect(Collectors.toList());
  }

  public HeroStatResponse findById(Long id) {
    var entity = heroStatRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    return modelMapper.map(entity, HeroStatResponse.class);
  }

  @Transactional
  public void create(Long heroId, List<HeroStatRequest> body) {
    var hero = heroRepository.findById(heroId)
        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    if (body.stream().map(HeroStatRequest::getStat).distinct().count() != body.size()
        || body.size() != StatEnum.values().length) {
      throw new ValidationException(MessageUtils.INVALID_DATA);
    }
    body.forEach(ele -> {
      var entity = modelMapper.map(ele, HeroStat.class);
      entity.setHero(hero);
      heroStatRepository.save(entity);
    });
  }

  public void update(Long heroId, Long id, HeroStatRequest body) {
    var entity = heroStatRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    if (isExistedByHeroIdAndStat(heroId, body.getStat())) {
      throw new ValidationException(MessageUtils.INVALID_DATA);
    }
    var hero = heroRepository.findById(heroId)
        .orElseThrow(() -> new NotFoundException(MessageUtils.NOT_FOUND));
    entity = modelMapper.map(body, HeroStat.class);
    entity.setId(id);
    entity.setHero(hero);
    heroStatRepository.save(entity);
  }

  public void deleteByHero(Long heroId) {
    heroStatRepository.deleteByHeroId(heroId);
  }

  public void deleteById(Long id) {
    heroStatRepository.deleteById(id);
  }

  public boolean isExistedByHeroIdAndStat(Long heroId, StatEnum stat) {
    return heroStatRepository.existsByHeroIdAndStat(heroId, stat);
  }
}
