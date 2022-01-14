package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Size(min = 3, max = 50)
    String name;

    @Min(0)
    double size;

    boolean secure;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id" ,name = "recovery_room_type")
    RecoveryRoomType roomType;
}
