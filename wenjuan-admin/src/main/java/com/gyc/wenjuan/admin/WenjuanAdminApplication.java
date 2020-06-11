package com.gyc.wenjuan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 * @author gyc
 * @date Oct 29, 2018
 */
@SpringBootApplication(scanBasePackages={"com.gyc.wenjuan"})
public class WenjuanAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenjuanAdminApplication.class, args);
	}
}
