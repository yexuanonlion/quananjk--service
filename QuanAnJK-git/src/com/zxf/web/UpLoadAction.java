package com.zxf.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.zxf.dao.UpLoadDao;


public class UpLoadAction extends BaseAction{
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    //上传文件的名字 ,FileName 固定的写法  
    private String fileFileName;
    //上传文件的类型， ContentType 固定的写法 
    private String fileContentType;
    private String upFileMessage;
    
    
	public String upLoadFile(){
		UpLoadDao fileDao = new UpLoadDao();
		
		String root = ServletActionContext.getServletContext().getRealPath("upload");
		File destFile = new File(root+ "/" + fileFileName);
		try {
			FileUtils.copyFile(file, destFile);
	   	 	fileDao.saveFileInformation(fileFileName,fileFileName.substring(fileFileName.lastIndexOf("v")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setUpFileMessage("上传失败");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 	
		setUpFileMessage("文件："+fileFileName+"上传成功");
        return "success";
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getUpFileMessage() {
		return upFileMessage;
	}

	public void setUpFileMessage(String upFileMessage) {
		this.upFileMessage = upFileMessage;
	}

}
