package com.ssafy.mountain.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;
import com.ssafy.mountain.model.MountainDto;
 
@Mapper
public interface MountainMapper {

	// 산 추가
	void AddMountain(MountainDto mountainDto) throws SQLException;

	// 정복하지않은산
	List<MountainDto> getUnconqueredMountains(int memberid) throws SQLException;

	// 정복하지않은산 높이로 오름차순
	List<MountainDto> getUnconqueredMountainsAscendingByHeight(int memberid) throws SQLException;

	// 정복하지않은산 가까운 순
	List<MountainDto> getNearestUnconqueredMountains(int memberid) throws SQLException;

	List<MountainDto> getAllMountains() throws SQLException;
	
	List<MountainDto> getSearchResult(String word) throws SQLException;
}
