package com.gmail.at.sichyuriyy.int20h.tvguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yuriy on 12.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {

    ImageData image;

    @JsonProperty("realtime_begin")
    Long realTimeBegin;

    @JsonProperty("realtime_end")
    Long realTimeEnd;

    String title;
    String subtitle;

    public ImageData getImage() {
        return image;
    }

    public void setImage(ImageData image) {
        this.image = image;
    }

    public Long getRealTimeBegin() {
        return realTimeBegin;
    }

    public void setRealTimeBegin(Long realTimeBegin) {
        this.realTimeBegin = realTimeBegin;
    }

    public Long getRealTimeEnd() {
        return realTimeEnd;
    }

    public void setRealTimeEnd(Long realTimeEnd) {
        this.realTimeEnd = realTimeEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
