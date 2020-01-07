package com.fh.service;


import com.fh.dao.ProjectFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service
public class ProjectFileService {
    @Autowired
    private ProjectFileMapper projectFileMapper;

    public Map test(String userId, String eventId){
        return  projectFileMapper.test(userId,eventId);
    }
    }


