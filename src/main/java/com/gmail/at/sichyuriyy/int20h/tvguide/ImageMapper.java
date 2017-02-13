package com.gmail.at.sichyuriyy.int20h.tvguide;

import com.gmail.at.sichyuriyy.int20h.tvguide.model.Guide;
import com.gmail.at.sichyuriyy.int20h.tvguide.model.Program;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yuriy on 12.02.2017.
 */
public class ImageMapper {


    private static final int PROGRAM_IMAGE_WIDTH = 500;
    private static final int PROGRAM_IMAGE_HEIGHT = 102;
    private static final int PREVIEW_IMAGE_WIDTH = 150;
    private static final int PREVIEW_IMAGE_HEIGHT = 100;
    private static final int BACKGROUND_HEIGHT = 100;


    private final Color textColor = Color.WHITE;
    private final Font titleFont = new Font("TimesRoman", Font.PLAIN, 20);
    private final Font subtitleFont = new Font("TimesRoman", Font.ITALIC, 14);
    private final Font timeFont = new Font("TimesRoman", Font.BOLD, 18);

    private final Color backgroundColor = new Color(255, 32, 32);

    private final ZoneOffset uaOffset = ZoneOffset.ofHours(2);

    private final int imageType = BufferedImage.TYPE_3BYTE_BGR;



    public BufferedImage getGuideImage(Guide guide) {
        List<BufferedImage> programImages = guide.getData().getPrograms()
                .stream()
                .map(this::getProgramImage)
                .collect(Collectors.toList());
        BufferedImage guideImage = new BufferedImage(
                PROGRAM_IMAGE_WIDTH, PROGRAM_IMAGE_HEIGHT * programImages.size(),
                imageType);
        Graphics2D g = (Graphics2D) guideImage.getGraphics();
        for (int i = 0; i < programImages.size(); i++) {
            g.drawImage(programImages.get(i),0, i * PROGRAM_IMAGE_HEIGHT, null);
        }

        return guideImage;
    }

    public BufferedImage getProgramImage(Program program) {
        BufferedImage image = getImageByUrl(program.getImage().getPreview());
        BufferedImage previewImage = resizeImage(image, imageType,
                PREVIEW_IMAGE_WIDTH, PREVIEW_IMAGE_HEIGHT);
        BufferedImage programImage = new BufferedImage(PROGRAM_IMAGE_WIDTH, PROGRAM_IMAGE_HEIGHT,
                imageType);
        Graphics2D g = (Graphics2D) programImage.getGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, PROGRAM_IMAGE_WIDTH, PROGRAM_IMAGE_HEIGHT);

        g.setColor(backgroundColor);
        g.fillRoundRect(0, 0, PROGRAM_IMAGE_WIDTH, BACKGROUND_HEIGHT, 20, 20);

        g.setColor(textColor);
        g.setFont(titleFont);
        g.drawString(program.getTitle(), 20, 20);

        g.setFont(subtitleFont);
        g.drawString(program.getSubtitle(), 20, 40);


        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime timeBegin = LocalDateTime.ofEpochSecond(
                program.getRealTimeBegin(), 0, uaOffset);

        LocalDateTime timeEnd = LocalDateTime.ofEpochSecond(
                program.getRealTimeEnd(), 0, uaOffset);

        g.setFont(timeFont);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        g.drawString(timeBegin.format(formatter) + " - " + timeEnd.format(formatter),
                20, 70);
        if (previewImage != null) {
            int x = PROGRAM_IMAGE_WIDTH - PREVIEW_IMAGE_WIDTH;
            g.drawImage(previewImage, x, 0, null);
        }

        g.dispose();
        return programImage;
    }

    private BufferedImage getImageByUrl(URL url) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int type,
                                      int width, int height){
        BufferedImage result = new BufferedImage(width, height, type);
        Graphics2D g = result.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return result;
    }
}
