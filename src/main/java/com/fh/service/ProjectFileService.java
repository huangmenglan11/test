package com.fh.service;


import com.fh.dao.ProjectFileMapper;
import com.fh.entity.ProjectFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@Service
public class ProjectFileService {
    @Autowired
    private ProjectFileMapper projectFileMapper;

    public Map test(String userId, String eventId){
        return  projectFileMapper.test(userId,eventId);
    }
    }


