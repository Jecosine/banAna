/*
 * @Date: 2020-09-22 10:39:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-22 11:49:17
 */
package swu.smxy.banana.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import swu.smxy.banana.dao.BaseMapper;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.UploadFile;
import swu.smxy.banana.util.UuidGenerator;
@Service
public class FileService {

    @Value("${banana.upload.path}")
    String uploadPath;
    public ResponseType<String> uploadFile(MultipartFile file)
    {
        ResponseType<String> response = new ResponseType<String>();
        if(file.isEmpty())
        {
            response.setStatus(-1);
            response.setMessage("Empty file");
            return response;
        }

        String fileName = file.getOriginalFilename();
        String[] splited = fileName.split("\\.");
        if(splited.length == 0)
        {
            response.setStatus(-1);
            response.setMessage("Error file name");
            return response;
        }
        System.out.println(file.getOriginalFilename() + " " + file.getContentType() + splited[0]);
        // TODO judge mimetype
        fileName = UuidGenerator.getUuid(32) + "." + splited[splited.length - 1];
        // response.setMessage("Success");
        response.setMessage(fileName);
        File dest = new File(uploadPath + fileName);
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            //TODO: handle exception
            response.setStatus(-1);
            response.setMessage("Failed to upload");
            response.setData(e.getMessage());
        }
        return response;
    }
}