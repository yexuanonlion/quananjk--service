package com.zxf.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.zxf.dao.UpLoadDao;


public class UpLoadAction extends BaseAction{
	//ע�⣬file������ָǰ��jsp�ϴ��������ļ����������ļ��ϴ������������ʱ�ļ���������ļ�
    private File file;
    //�ϴ��ļ������� ,FileName �̶���д��  
    private String fileFileName;
    //�ϴ��ļ������ͣ� ContentType �̶���д�� 
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
			setUpFileMessage("�ϴ�ʧ��");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 	
		setUpFileMessage("�ļ���"+fileFileName+"�ϴ��ɹ�");
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
