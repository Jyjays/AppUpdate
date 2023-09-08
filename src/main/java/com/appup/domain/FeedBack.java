package com.appup.domain;

public class FeedBack {
    private int id;
    private String title;
    private String content;
    private String imagePath;

    public FeedBack() {
    }

    public FeedBack(int id, String title, String content, String imagePath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * @return imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 设置
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String toString() {
        return "FeedBack{id = " + id + ", title = " + title + ", content = " + content + ", imagePath = " + imagePath + "}";
    }
}
