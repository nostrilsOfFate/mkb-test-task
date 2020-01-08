package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("assessment")
public class AssessmentDto implements Collateral {
    private Long id;
    private Long objectId;
    private Short year;
    private BigDecimal assessedValue;
}
