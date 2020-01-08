package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Access(AccessType.FIELD)
@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    @Column(name = "year_of_issue")
    private Short year;


    public AbstractBaseEntity(Long id, String brand, String model, Short year) {
        this(id, brand, model, year, Collections.emptyList());
    }

    @OneToMany
    private List<Assessment> assessments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id.equals(that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model);
    }
}
