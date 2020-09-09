package swu.smxy.banana.entity;

import org.springframework.stereotype.Component;

@Component
public class Notify {
    private String notifyId;
    private String notifyType; // order agree reply
    private String notifyData;

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
     * @return String return the notifyData
     */
    public String getNotifyData() {
        return notifyData;
    }

    /**
     * @param notifyData the notifyData to set
     */
    public void setNotifyData(String notifyData) {
        this.notifyData = notifyData;
    }

}