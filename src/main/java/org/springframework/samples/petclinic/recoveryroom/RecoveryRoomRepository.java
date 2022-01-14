package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {


    List<RecoveryRoom> findAll();

    @Query("Select roomType From RecoveryRoom recoveryRoom")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();


    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("Select roomType From RecoveryRoom r WHERE r.roomType.name LIKE ?1")
    RecoveryRoomType getRecoveryRoomType(String name);

    @Query("Select r From RecoveryRoom r Where r.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);


    @Query("Select r.roomType From RecoveryRoom r")
    List<RecoveryRoomType> getAllRecoveryRoomTypes();
}
