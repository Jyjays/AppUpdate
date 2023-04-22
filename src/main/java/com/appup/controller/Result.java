package com.appup.controller;

public class Result {
        private String version;
        private String url;
        private String  description;
        private String platform;
        private String isForceUpgrade;


    public Result() {
    }

    public Result(String version, String url, String description, String platform, String isForceUpgrade) {
        this.version = version;
        this.url = url;
        this.description = description;
        this.platform = platform;
        this.isForceUpgrade = isForceUpgrade;
    }

    public Result(String s) {
        description=s;
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
     * @return isForceUpgrade
     */
    public String getIsForceUpgrade() {
        return isForceUpgrade;
    }

    /**
     * 设置
     * @param isForceUpgrade
     */
    public void setIsForceUpgrade(String isForceUpgrade) {
        this.isForceUpgrade = isForceUpgrade;
    }

    public String toString() {
        return "Result{version = " + version + ", url = " + url + ", description = " + description + ", platform = " + platform + ", isForceUpgrade = " + isForceUpgrade + "}";
    }
}

