package br.com.online.complete.school.more.api_restFU_school.domain.people;

import br.com.online.complete.school.more.api_restFU_school.domain.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active;
    private String name;
    private String email;
    private String phone;
    @Column(name = "mobilePhone")
    private String mobilePhone;
    private String registration;
    private String rg;
    private String cpf;
    @Column(name = "motherName")
    private String motherName;
    @Embedded
    private Address address;

    public PersonEntity(PersonRequestRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.mobilePhone = data.mobilePhone();
        this.registration = data.registration();
        this.rg = data.rg();
        this.cpf = data.cpf();
        this.motherName = data.motherName();
        this.address = new Address(data.address());
    }

    public void updateData(
            @Valid
            PersonUpdateData data
    ) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.mobilePhone() != null) {
            this.mobilePhone = data.mobilePhone();
        }
        if (data.rg() != null) {
            this.rg = data.rg();
        }
        if (data.motherName() != null) {
            this.motherName = data.motherName();
        }
        if (data.address() != null) {
            this.address.updateData(data.address());
        }
    }

    public void deactivateRegistration() {
        this.active = false;
    }
}
