package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ASSESSMENT")
@ToString
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assessed_value")
    private BigDecimal assessedValue;

    @Column(name = "assessment_date")
    private LocalDate localDate = LocalDate.now();

    public Assessment(BigDecimal assessedValue) {
        this.assessedValue = assessedValue;
    }
}
