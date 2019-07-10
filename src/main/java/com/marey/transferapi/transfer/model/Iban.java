package com.marey.transferapi.transfer.model;


import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor(staticName = "of")
public class Iban{

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}[ ]*[0-9]{2}([ ]*[0-9]{4}){6}")
    private String value;

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        Iban comparedIban = (Iban) o;
        return this.value.replace(" ","")
                .equalsIgnoreCase(comparedIban.getValue().replace(" ",""));
    }

}
