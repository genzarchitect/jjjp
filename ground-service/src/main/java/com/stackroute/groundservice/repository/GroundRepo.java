package com.stackroute.groundservice.repository;

import com.stackroute.groundservice.model.Ground;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroundRepo extends MongoRepository<Ground,Integer> {
    List<Ground> findByCategories(String categories);

    Ground findByGroundName(String GroundName);
    List<Ground> findByGroundOwnerEmail(String email);
    List<Ground> findByStatus(Ground.Status status);
    List<Ground> findByGroundAddress_City(String city);
    Ground findByGroundId(String id);

    Ground deleteGroundsByGroundId(String string);



}
