package com.appup.domain;

public class FeedDto {
    private String title;
    private String content;
    private String imageCode;

    public FeedDto() {
    }

    public FeedDto(String title, String content, String imageCode) {
        this.title = title;
        this.content = content;
        this.imageCode = imageCode;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return imageCode
     */
    public String getImageCode() {
        return imageCode;
    }

    /**
     * 设置
     * @param imageCode
     */
    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String toString() {
        return "FeedDto{title = " + title + ", content = " + content + ", imageCode = " + imageCode + "}";
    }
}
