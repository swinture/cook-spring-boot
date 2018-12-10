package com.swinture.customize.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CustomizeBannerApplication {

    /**
     * Banner有三种模式(类org.springframework.boot.Banner)：
     *      OFF ： 关闭不显示
     *      CONSOLE ：控制台输出
     *      LOG ：写入日志文件
     *
     * 控制Banner的模式，有两种方式
     * 1. 代码方式，可以通过下面的两种方法（任选一种即可，参考main方法）
     *      方法一：SpringApplication.setBannerMode()
     *      方法二：SpringApplicationBuilder.bannerMode()
     *
     * 2. 配置文件（优先级高于代码方式）
     *      application.properties（优先级高于application.yml）
     *      application.yml (当spring.main.banner-mode属性值为off时，一定要用双引号，写成"off"，否则会报类型转换错误)
     *
     * 备注：
     * （1）同时存在配置文件和代码两种方式时，以配置文件为准，代码中的设置值无效；
     * （2）当配置文件同时存在application.properties和application.yml，且都设置了
     *      spring.main.banner-mode属性值，以application.properties为准；
     * @param args
     */
    public static void main(String[] args) {
        // 方法一
        /*SpringApplication app = new SpringApplication(CustomizeBannerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);*/

        // 方法二
        new SpringApplicationBuilder(CustomizeBannerApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
