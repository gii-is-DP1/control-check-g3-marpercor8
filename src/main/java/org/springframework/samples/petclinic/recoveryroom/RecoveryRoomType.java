package org.springframework.samples.petclinic.recoveryroom;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class RecoveryRoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Size(min = 3, max = 50)
    @Column(unique = true)
    String name;
}
