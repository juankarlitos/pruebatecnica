package com.apitest.apirestpueba.entity;

import jakarta.validation.constraints.NotBlank;

public class Telefono {
	
	@NotBlank
    private String number;

    @NotBlank
    private String citycode;

    @NotBlank
    private String contrycode;

}
