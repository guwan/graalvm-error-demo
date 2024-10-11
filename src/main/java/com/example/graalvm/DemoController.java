package com.example.graalvm;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequestMapping
@Controller
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<byte[]> getBlueImage() throws IOException {
        // 创建一个空白的蓝色图片
        int width = 800;
        int height = 600;
        BufferedImage blueImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = blueImage.createGraphics();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        // 将图片写入字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(blueImage, "png", baos);
        byte[] imageBytes = baos.toByteArray();

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/png");
        headers.set("Content-Length", String.valueOf(imageBytes.length));

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
