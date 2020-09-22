/*
 * @Date: 2020-09-22 10:41:15
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-22 11:07:20
 */
package swu.smxy.banana.entity;

import org.springframework.stereotype.Component;

@Component
public class UploadFile {
    private String fileId;
    private String filePath;
    private String fileType;
    private Integer fileSize;

    /**
     * @return String return the fileId
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * @param fileId the fileId to set
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * @return String return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return Integer return the fileSize
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

}