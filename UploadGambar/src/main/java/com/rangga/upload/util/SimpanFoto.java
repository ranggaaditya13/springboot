package com.rangga.upload.util;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SimpanFoto implements WebMvcConfigurer {
	
	public void addResouceHandlers(ResourceHandlerRegistry reg)
	{
		reg.addResourceHandler("/gbr/**").
		addResourceLocations("file:G:/ALL FOR WEB/Github/SpringbootGit/UploadGambar")
		.setCachePeriod(0);
	}

}
