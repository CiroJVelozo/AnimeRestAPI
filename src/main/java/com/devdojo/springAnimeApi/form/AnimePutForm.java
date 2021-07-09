package com.devdojo.springAnimeApi.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimePutForm {

    @NotEmpty
    @NotNull
    private long id;
    private String name;
}
