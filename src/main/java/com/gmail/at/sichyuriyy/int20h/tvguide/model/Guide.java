package com.gmail.at.sichyuriyy.int20h.tvguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Yuriy on 12.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guide {

    GuideData data;

    public GuideData getData() {
        return data;
    }

    public void setData(GuideData data) {
        this.data = data;
    }
}
