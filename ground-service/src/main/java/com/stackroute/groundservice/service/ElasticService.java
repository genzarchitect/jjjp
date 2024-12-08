//package com.stackroute.groundservice.service;
//
//import com.stackroute.groundservice.model.ElasticGround;
//
//import com.stackroute.groundservice.repository.GroundElasticRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//
//@Service
//public class ElasticService {
//
//    private static final Logger log = LoggerFactory.getLogger(ElasticService.class);
//
//    @Autowired
//    GroundElasticRepository groundElasticRepository;
//
//    public ElasticGround addGroundElastic(ElasticGround ground) {
////        log.debug("attempting to save ground");
//        if (ground != null) {
//            return groundElasticRepository.save(ground);
//        }
//        return null;
//    }
////    public List<ElasticGround> searchGrounds(String groundName, String categories) {
////        if (groundName != null && categories != null) {
////            return groundElasticRepository.findByGroundNameContaining(groundName); // Just example, modify if both needed
////        } else if (groundName != null) {
////            return groundElasticRepository.findByGroundNameContaining(groundName);
////        }
////        return groundElasticRepository.findByCategoriesContaining(categories);
////    }
//}
