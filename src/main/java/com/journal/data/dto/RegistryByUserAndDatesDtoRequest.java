package com.journal.data.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder
public class RegistryByUserAndDatesDtoRequest {

    @NotNull
    private Long userId;

    private LocalDate from;

    private LocalDate to;
}
