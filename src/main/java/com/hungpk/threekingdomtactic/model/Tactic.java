package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;
import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;

import com.hungpk.threekingdomtactic.enums.TargetTypeEnum;
import com.hungpk.threekingdomtactic.enums.converter.QualityEnumConverter;
import com.hungpk.threekingdomtactic.enums.converter.TacticTypeEnumConverter;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "tactic")
@Table(name = "tactic", schema = AppConfig.SCHEMA)
public class Tactic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @Column(name = "max_lv_info")
    private String maxLvInfo;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quality")
//    @Convert(converter = QualityEnumConverter.class)
    private QualityEnum quality;

    @Column(name = "tactic_type")
//    @Convert(converter = TacticTypeEnumConverter.class)
    private TacticTypeEnum tacticType;

    @Column(name = "target_type")
    private TargetTypeEnum targetType;

    @Column(name = "change_to_trigger")
    private Long changeToTrigger;

    @ManyToOne(fetch = FetchType.LAZY)
    private Effect effect;

    @OneToMany(mappedBy = "officialTactic")
    private List<Hero> heroes;

    @OneToMany(mappedBy = "inheritTactic")
    private List<Hero> inheritHeroes;

    @OneToMany(mappedBy = "tactic")
    private List<TacticEffectConflict> tacticEffectConflicts;
}
