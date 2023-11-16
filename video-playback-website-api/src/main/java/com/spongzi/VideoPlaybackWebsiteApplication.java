package com.spongzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 视频播放网站应用
 *
 * @author spong
 * @date 2023/11/16
 */
@MapperScan("com.spongzi.dao")
@SpringBootApplication
public class VideoPlaybackWebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoPlaybackWebsiteApplication.class, args);
    }
}
