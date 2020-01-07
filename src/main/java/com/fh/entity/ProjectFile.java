package com.fh.entity;


public class ProjectFile {

  private String id;
  private String fileName;
  private long fileType;
  private java.sql.Timestamp uploadDate;
  private String user;
  private String keyword;
  private String filePath;
  private String viewPath;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public long getFileType() {
    return fileType;
  }

  public void setFileType(long fileType) {
    this.fileType = fileType;
  }


  public java.sql.Timestamp getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(java.sql.Timestamp uploadDate) {
    this.uploadDate = uploadDate;
  }


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }


  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }


  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  public String getViewPath() {
    return viewPath;
  }

  public void setViewPath(String viewPath) {
    this.viewPath = viewPath;
  }

}
