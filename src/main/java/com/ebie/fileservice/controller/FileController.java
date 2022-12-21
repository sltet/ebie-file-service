package com.ebie.fileservice.controller;

import com.ebie.fileservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

	private final FileService fileService;

	@PostMapping(
			value = "/zip",
			produces = "application/zip",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	public ResponseEntity<StreamingResponseBody> zipFile(@RequestParam("file") MultipartFile file) {
		String finalName = FilenameUtils.removeExtension(file.getOriginalFilename()) +".zip";
		return ResponseEntity
				.ok()
				.header("Content-Disposition", "attachment; filename=" + finalName)
				.body(out -> {
					var zipOutputStream = new ZipOutputStream(out);
					fileService.zipFile(zipOutputStream, file);
				});
	}
}
