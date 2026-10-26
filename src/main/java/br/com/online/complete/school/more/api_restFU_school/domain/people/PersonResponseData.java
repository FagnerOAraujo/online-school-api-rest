package br.com.online.complete.school.more.api_restFU_school.domain.people;

import br.com.online.complete.school.more.api_restFU_school.domain.address.Address;


public record PersonResponseData(
        Long id,
        String name,
        String email,
        String phone,
        String mobilePhone,
        String registration,
        String rg,
        String cpf,
        String motherName,
        Address address
) {
    public PersonResponseData(PersonEntity entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getMobilePhone(),
                entity.getRegistration(),
                entity.getRg(),
                entity.getCpf(),
                entity.getMotherName(),
                entity.getAddress()
                );
    }
}
