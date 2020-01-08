package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ASSESSMENTS")
//, uniqueConstraints = {@UniqueConstraint(columnNames = "id", name = "ASSESSMENTS_unique_id_datetime_idx")}
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "object_id")
//    private Long objectId;
    private AbstractBaseEntity baseEntity;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "assessed_value")
    private BigDecimal assessedValue;

}
