package com.manageruser.classroom.repository;

import com.manageruser.classroom.document.ClassRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRoomRepository extends MongoRepository<ClassRoom, String> {

}
