package com.stackroute.groundservice.controller;


import com.stackroute.groundservice.exception.GroundAlreadyExistsException;
import com.stackroute.groundservice.exception.GroundNotFoundException;


import com.stackroute.groundservice.model.Ground;

import com.stackroute.groundservice.service.GridFsService;
import com.stackroute.groundservice.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "*")
public class GroundController {

    ResponseEntity<?> responseEntity;



    @Autowired
    GroundService groundService;
    @Autowired
    GridFsService gridFsService;

    //just to check
    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('Owner')")
    public String welcome(){
        return "hello";
    }

    @GetMapping("/allgrounds")
    public ResponseEntity<?> getAllGrounds(){
        try {
            if(groundService.getAllGround().size()>0){
                responseEntity =  new ResponseEntity<>(groundService.getAllGround(),HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/addground")
    public ResponseEntity<?> addGround(@RequestBody Ground ground){
        try {
            Ground addedGround = groundService.addGround(ground);
            if(addedGround != null){
                return new ResponseEntity<>(addedGround, HttpStatus.CREATED);
            }
        }
        catch (GroundAlreadyExistsException e){
            return new ResponseEntity<>("Ground Already Exists", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/addImage/{groundId}")
    public ResponseEntity<Map<String, String>> addImageToGround(@PathVariable String groundId, @RequestParam("file") MultipartFile file) {
        String response = groundService.addImageToGround(groundId, file);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", response);
        return ResponseEntity.ok(responseBody);
    }



    //how will i get that ground on that page willthat be by ID;
    
    @GetMapping("/groundId/{id}")
    public ResponseEntity<?> getGroundById(@PathVariable("id") String id){
        try {
            Ground ground = groundService.getGroundById(id);
            if(ground!=null){
                responseEntity = new ResponseEntity<>(ground,HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
//    @CrossOrigin(origins = "*")
    @GetMapping("/ground/{email}")
    public ResponseEntity<?> getGroundByOwner(@PathVariable("email") String email){
        try {
            List<Ground> groundList = groundService.getGroundByOwnerEmail(email);
            if(groundList.size()>0){
                responseEntity = new ResponseEntity<>(groundList,HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/status/open")
    public ResponseEntity<?> getAllOpenGrounds() {
        return new ResponseEntity<>(groundService.getAllOpenGround(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Ground>> getGroundsByCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(groundService.getGroundByCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/ground/{id}")
    public ResponseEntity<?> deleteGround(@PathVariable String id) {
        try {
          boolean check=  groundService.deleteGround(id);
            if(check){
                responseEntity = new ResponseEntity<>("Ground Deleted Successfully",HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/ground/image/{groundId}")
    public ResponseEntity<?> getGroundImage(@PathVariable String groundId) {
        Ground ground = groundService.getGroundById(groundId);
        if (ground != null) {
            InputStreamResource resource = gridFsService.retrieveFile(ground.getGroundImage());
            if (resource != null) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header("Content-Disposition", "inline;filename=" + ground.getGroundImage())
                        .body(resource);
            } else {
                return new ResponseEntity<>("No image found for ground", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("No ground found with id: " + groundId, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/status/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable("id") int id, @RequestParam("status") String statusStr) {
        try {
            Ground.Status status  = Ground.Status.valueOf(statusStr.toUpperCase());
           Ground ground =  groundService.changeStatusofGround(status, id);
            responseEntity = new ResponseEntity<>(ground, HttpStatus.OK);
        }
        catch (GroundNotFoundException e){
           responseEntity = new  ResponseEntity<>("Ground Don't Exists", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/updateground/{id}")
    public ResponseEntity<?> updateGround(@PathVariable("id") String id, @RequestBody Ground updatedGround) {
        try {
            Ground ground = groundService.updateGround(id, updatedGround);
            if(ground != null){
                responseEntity = new ResponseEntity<>(ground, HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found to Update", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

//    @GetMapping("/search")
//    public List<ElasticGround> searchGrounds(@RequestParam(required = false) String groundName,
//                                             @RequestParam(required = false) String categories) {
//        return elasticService.searchGrounds(groundName, categories);
//    }

}
