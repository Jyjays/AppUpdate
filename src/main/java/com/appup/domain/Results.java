package com.appup.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private String trackCensoredName;

    @JsonProperty("artworkUrl512")
    private String artworkURL512;

    // 构造函数、getter和setter等方法可以根据需要添加

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtworkURL512() {
        return artworkURL512;
    }

    public void setArtworkURL512(String artworkURL512) {
        this.artworkURL512 = artworkURL512;
    }
}

