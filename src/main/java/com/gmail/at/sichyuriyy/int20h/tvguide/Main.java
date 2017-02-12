package com.gmail.at.sichyuriyy.int20h.tvguide;

import com.gmail.at.sichyuriyy.int20h.tvguide.model.Guide;
import com.gmail.at.sichyuriyy.int20h.tvguide.model.Program;
import java.io.File;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Yuriy on 12.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Guide guide = restTemplate.getForObject("https://api.ovva.tv/v2/ua/tvguide/1plus1/2017-02-18", Guide.class);

        Program program = guide.getData().getPrograms().get(0);

        ImageMapper mapper = new ImageMapper();
        BufferedImage image = mapper.getGuideImage(guide);
        try {
            ImageIO.write(image, "JPEG", new File("guide.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
