package com.ssafy.board.model.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.util.PageNavigation;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws Exception;

//	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	List<BoardDto> listArticle() throws Exception;

//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
//	void updateHit(int articleNo) throws Exception;

	void modifyArticle(BoardDto boardDto) throws Exception;

	void deleteArticle(int articleNo) throws Exception;

	List<BoardDto> alllistArticle() throws Exception;

	String getfilelist(int articleNo) throws Exception;

	void toggleLike(int articleNo) throws Exception;

	String registerfile(MultipartFile imageFile, String string, int articleNo) throws Exception;
}
