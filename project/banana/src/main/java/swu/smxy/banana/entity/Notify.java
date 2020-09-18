package swu.smxy.banana.entity;

import org.springframework.stereotype.Component;

@Component
public class Notify {
    private String notifyId;
    // order agree reply
    private String notifyType; 
    private NotifyData notifyData;
    private String senderId;
    private String receiverId;
    private String chatId;
    private String status;
    
    /**
     * @return String return the notifyId
     */
    public String getNotifyId() {
        return notifyId;
    }

    /**
     * @param notifyId the notifyId to set
     */
    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }



    /**
     * @return NotifyData return the notifyData
     */
    public NotifyData getNotifyData() {
        return notifyData;
    }

    /**
     * @param notifyData the notifyData to set
     */
    public void setNotifyData(NotifyData notifyData) {
        this.notifyData = notifyData;
    }

    /**
     * @return String return the senderId
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * @return String return the receiverId
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * @param receiverId the receiverId to set
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * @return String return the chatId
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * @param chatId the chatId to set
     */
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * @return String return the notifyType
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * @param notifyType the notifyType to set
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

}