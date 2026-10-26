package br.com.online.complete.school.more.api_restFU_school.domain.people;

import br.com.online.complete.school.more.api_restFU_school.domain.address.AddressRequestData;
import jakarta.validation.constraints.NotNull;

public record PersonUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String phone,
        String mobilePhone,
        String rg,
        String motherName,
        AddressRequestData address
) {
}
