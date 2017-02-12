package com.gmail.at.sichyuriyy.int20h.tvguide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.List;

/**
 * Created by Yuriy on 12.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuideData {

    Date date;
    List<Program> programs;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
