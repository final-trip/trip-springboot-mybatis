package com.ssafy.board.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "BoardDto (게시판정보)", description = "게시판 내용을 가진 Domain Class")
public class BoardDto {

	@ApiModelProperty(value = "게시판 번호")
	private int articleNo;

	@ApiModelProperty(value = "유저 번호")
	private String userId;

	@ApiModelProperty(value = "유저 이름")
	private String userName;

	@ApiModelProperty(value = "게시판 제목")
	private String subjects;

	@ApiModelProperty(value = "게시판 내용")
	private String content;

	@ApiModelProperty(value = "게시판 번호")
	private String registerTime;

	@ApiModelProperty(value = "게시판 파일")
//	private List<FileInfoDto> fileInfos;
//	private FileInfoDto fileInfos;
	private MultipartFile fileInfos;
 
	private String save_file;

//	public File getFiles() {
//		if (fileInfos != null && !fileInfos.isEmpty()) {
//			String filePath = "C:\\Users\\SSAFY\\Downloads\\" + fileInfos.getOriginalFilename();
//			this.save_file = filePath;
//
//			return new File(filePath);
//		} else {
//			return null; // Or handle the case when no file is uploaded
//		}
//	}

	private int likes;

}