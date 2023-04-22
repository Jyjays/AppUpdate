package com.appup.domain;


public class Information {
    private String version;
    private String url;
    private String platform;
    private String description;


    public Information() {
    }

    public Information(String version, String url, String platform, String description) {
        this.version = version;
        this.url = url;
        this.platform = platform;
        this.description = description;
    }

    /**
     * 获取
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 设置
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Information{version = " + version + ", url = " + url + ", platform = " + platform + ", description = " + description + "}";
    }
}
