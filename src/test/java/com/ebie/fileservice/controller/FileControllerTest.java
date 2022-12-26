package com.ebie.fileservice.controller;

import com.ebie.fileservice.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.InputStream;
import java.util.zip.ZipOutputStream;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileController.class)
public class FileControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FileService fileService;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.png");
		final MockMultipartFile file = new MockMultipartFile("file", "test.png", "image/png", inputStream);

		doNothing().when(fileService).zipFile(isA(ZipOutputStream.class), isA(MockMultipartFile.class));

		mockMvc.perform(MockMvcRequestBuilders.multipart("/file/zip")
						.file(file))
				.andExpect(status().is(200))
				.andReturn();
	}
}
