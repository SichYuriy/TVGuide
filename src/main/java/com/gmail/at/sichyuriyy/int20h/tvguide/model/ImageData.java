package com.gmail.at.sichyuriyy.int20h.tvguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

/**
 * Created by Yuriy on 12.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageData {

    URL preview;

    public URL getPreview() {
        return preview;
    }

    public void setPreview(URL preview) {
        this.preview = preview;
    }
}
