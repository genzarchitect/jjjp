package com.stackroute.groundservice.service;

import com.stackroute.groundservice.model.Ground;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GroundService {

   //Ground addGround(Ground ground, MultipartFile imageFile) throws IOException;
   public Ground addGround(Ground ground);

   public String addImageToGround(String groundId, MultipartFile file);
 public List<Ground> getAllGround();

    public List<Ground> getGroundByCategory(String category);
    public Ground getGroundById(String groundId);
    public List<Ground> getGroundByOwnerEmail(String email);

    public List<Ground> getAllOpenGround();
    public Ground changeStatusofGround(Ground.Status status,int groundId);
    List<Ground> getAllGroundByCity(String city);
    boolean deleteGround(String id);
   Ground updateGround(String id, Ground updatedGround);


}
