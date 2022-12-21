package com.ebie.fileservice.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileService {

	public void zipFile(ZipOutputStream zipOutputStream, MultipartFile file) throws IOException {
		zipOutputStream.putNextEntry(new ZipEntry(Objects.requireNonNull(file.getOriginalFilename())));
		InputStream inputStream = file.getInputStream();
		IOUtils.copy(inputStream, zipOutputStream);
		inputStream.close();
		zipOutputStream.closeEntry();
		zipOutputStream.close();
	}
}
