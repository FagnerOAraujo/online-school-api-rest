package br.com.online.complete.school.more.api_restFU_school.domain.people;

public record PersonListData(
        Long id,
        String name,
        String email,
        String phone,
        String rg,
        String motherName
) {
    public PersonListData(PersonEntity entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getRg(),
                entity.getMotherName()
        );
    }
}
