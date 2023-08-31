package com.gestionEcole.GesiotEcolde.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass // pour pouvoir utiliser le id dans les classe fils
public class AbstractClasse  {

    @Id
    @SequenceGenerator(
            name = "Sequence_GE",
            sequenceName = "Sequence_GE",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "Sequence_GE"
    )
    private Long id;


}
