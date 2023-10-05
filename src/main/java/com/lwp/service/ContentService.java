package com.lwp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lwp.model.Content;
import com.lwp.model.Pages;
import com.lwp.repo.ContentRepo;

@Service
public class ContentService {

	@Autowired
	private ContentRepo contentRepo;
	
	
	public Content createNewConten(Content content, String imgName, Pages page) {
		content.setImg(imgName);
		content.setPage(page);
		return contentRepo.save(content);
	}
	
	// saving image in local folder
	public void saveImage(MultipartFile image) throws IOException {
		File file = new ClassPathResource("static/images").getFile();
		Path path = Paths.get(file.getAbsolutePath() + File.separator + image.getOriginalFilename());
		Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	}
	
	// get lastest content
	public Content getLatestContent(Pages page) {
		List<Content> findAllByPage = contentRepo.findAllByPage(page);
		if(findAllByPage.size() > 0) {
			return findAllByPage.get(findAllByPage.size() - 1);
		}
		return null;
	}
}
