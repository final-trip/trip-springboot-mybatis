package com.ssafy.member.model.mapper;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;

	void joinMember(MemberDto memberDto) throws SQLException;

	MemberDto loginMember(MemberDto memberDto) throws SQLException;

	/* Admin */
	List<MemberDto> listMember() throws SQLException;

	MemberDto getMember(String userId) throws SQLException;

	void updateMember(MemberDto memberDto) throws SQLException;

	void deleteMember(String userId) throws SQLException;

	String modifyimg(File fileInfos, String string, String userId) throws SQLException;

	void registerfile(String imgurl, String userId) throws SQLException;

	void saveRefreshToken(Map<String, String> map) throws SQLException;
	
	MemberDto userInfo(String userId) throws SQLException;
	
	Object getRefreshToken(String userid) throws SQLException;
	
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
//	MemberDto getmemberinfo(String userId) throws SQLException;

}