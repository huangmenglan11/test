package com.fh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ProjectFileMapper {
    Map test(String userId, String eventId);

    void saveFileInfo(@Param("fileName") String fileName, @Param("fileType") Integer fileType, @Param("user") String user);
}
