package com.hungpk.threekingdomtactic.model;

import com.hungpk.threekingdomtactic.config.AppConfig;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tactic_effect_conflict")
@Table(name = "tactic_effect_conflict", schema = AppConfig.SCHEMA)
public class TacticEffectConflict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tactic_id")
    private Long tacticId;

    @Column(name = "effect_conflict_id")
    private Long effectConflictId;

    @ManyToOne
    @JoinColumn(name = "tactic_id", updatable = false, insertable = false)
    private Tactic tactic;

    @ManyToOne
    @JoinColumn(name = "effect_conflict_id", updatable = false, insertable = false)
    private EffectConflict effectConflict;

}
