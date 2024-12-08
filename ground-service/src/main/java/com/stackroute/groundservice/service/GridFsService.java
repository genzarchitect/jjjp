package com.stackroute.groundservice.service;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GridFsService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;

    public String store(MultipartFile file) throws IOException {
        ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
        return id.toString();
    }

    public InputStreamResource retrieveFile(String id) {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        if (file != null) {
            try {
                return new InputStreamResource(gridFsOperations.getResource(file).getInputStream());
            } catch (IOException e) {
                // handle IOException
                e.printStackTrace();
            }
        }
        return null;
    }
}