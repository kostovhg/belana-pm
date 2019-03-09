package com.belana.production.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientRegisterBindingModel {

    private String name;
    private String address;
    private String comment;
}
