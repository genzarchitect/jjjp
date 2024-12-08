package com.stackroute.groundservice.service;

import com.stackroute.groundservice.exception.GroundNotFoundException;
import com.stackroute.groundservice.exception.NoOpenGroundFound;

import com.stackroute.groundservice.model.Ground;
import com.stackroute.groundservice.repository.GroundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GroundServiceImpl implements GroundService{

//    @Autowired
//    GroundElasticRepository groundElasticRepository;
    @Autowired
    GroundRepo groundRepo;
    @Autowired
    GridFsService gridFsService;

    @Override
    public Ground addGround(Ground ground) {
//        log.debug("attempting to save ground");
        if(ground != null) {
            return groundRepo.save(ground);
        }
        return null;
    }

    public String addImageToGround(String groundId, MultipartFile file) {
        Ground ground = groundRepo.findByGroundId(groundId);
        if (ground != null) {
            try {
                String imageId = gridFsService.store(file);
                ground.setGroundImage(imageId);
                groundRepo.save(ground);
                return "Image added successfully to ground: " + groundId;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Error adding image or ground not found";
    }



    @Override
    public List<Ground> getAllGround() {
        List<Ground> allGrounds = groundRepo.findAll();
        if(allGrounds.size()>0){
            return allGrounds;
        }
        throw new GroundNotFoundException("No ground Found");
    }

    @Override
    public List<Ground> getGroundByCategory(String category) {
        List<Ground> groundListByCategory = groundRepo.findByCategories(category);
        if(groundListByCategory.size()>0){
            return groundListByCategory;
        }
        throw new GroundNotFoundException("No Ground Found By this Category");
    }

    @Override
    public Ground getGroundById(String id) {
       Ground ground =  groundRepo.findByGroundId(id);
       if(ground!=null){
           return ground;
       }
       throw new GroundNotFoundException("No ground exists with this id");
    }

    @Override
    public List<Ground> getGroundByOwnerEmail(String email) {
        List<Ground> groundList = groundRepo.findByGroundOwnerEmail(email);
        if(groundList.size()>0){
            return groundList;
        }
        throw new GroundNotFoundException("No Ground Found");
    }

    @Override
    public List<Ground> getAllOpenGround() {
        List<Ground> openGroundList = groundRepo.findByStatus(Ground.Status.OPEN);
        if(openGroundList.size()>0){
            return openGroundList;
        }
        throw new NoOpenGroundFound("No open Ground is available");
    }

    @Override
    public Ground changeStatusofGround(Ground.Status status, int groundId) {
       Optional<Ground> groundOptional = groundRepo.findById(groundId);
       if(!groundOptional.isPresent()){
            throw new GroundNotFoundException("No ground found with this id");
       }
       Ground ground = groundOptional.get();
       ground.setStatus(status);
       groundRepo.save(ground);
       return ground;
    }

    @Override
    public List<Ground> getAllGroundByCity(String city) {
       List<Ground> allGroundsByCity = groundRepo.findByGroundAddress_City(city);
       if(allGroundsByCity.size()>0){
           return allGroundsByCity;
       }
       throw new GroundNotFoundException("No ground found nearby");
    }

    public boolean deleteGround(String id) {
        boolean check = true;
        Ground ground = groundRepo.findByGroundId(id);
        if(ground!=null){
           check = false;
        }
        groundRepo.deleteGroundsByGroundId(id);
        return check;
    }

    @Override
    public Ground updateGround(String id, Ground updatedGround) {
        Ground existingGround = groundRepo.findByGroundId(id);
        if(existingGround==null){
            throw new GroundNotFoundException("No ground found with this id");
        }
        existingGround.setGroundName(updatedGround.getGroundName());
        existingGround.setCategories(updatedGround.getCategories());
        existingGround.setStatus(updatedGround.getStatus());
        existingGround.setGroundOwnerEmail(updatedGround.getGroundOwnerEmail());
        existingGround.setGroundAddress(updatedGround.getGroundAddress());
        existingGround.setGroundImage(updatedGround.getGroundImage());
        existingGround.setPricePerSlot(updatedGround.getPricePerSlot());
        groundRepo.save(existingGround);
        return existingGround;
    }



}
