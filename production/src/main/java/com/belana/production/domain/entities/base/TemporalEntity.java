package com.belana.production.domain.entities.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Abstract base class for all entities which unique keys will be a composite
 * between date and time of creation
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class TemporalEntity {

    @EmbeddedId
    private TemporalKey tempKey;

}
