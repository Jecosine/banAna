/*
 * @Date: 2020-09-02 16:59:53
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 17:07:12
 */
package swu.smxy.banana.entity;

public class Comment {
    private String commentId;
    private String commentContent;
    private String commentDateTime;
    private Float rate;
    private String replyId;

    /**
     * @return String return the commentId
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * @return String return the commentContent
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent the commentContent to set
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * @return String return the commentDateTime
     */
    public String getCommentDateTime() {
        return commentDateTime;
    }

    /**
     * @param commentDateTime the commentDateTime to set
     */
    public void setCommentDateTime(String commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    /**
     * @return Float return the rate
     */
    public Float getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Float rate) {
        this.rate = rate;
    }

    /**
     * @return String return the replyId
     */
    public String getReplyId() {
        return replyId;
    }

    /**
     * @param replyId the replyId to set
     */
    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

}