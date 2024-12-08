package com.stackroute.service;


import com.stackroute.model.UserCredential;

import java.util.Map;

public interface TokenGeneratorService {

    Map<String,String> generateToken(UserCredential credential);
}
