package com.ssafy.mountain.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.mountain.model.MountainDto;
import com.ssafy.mountain.model.service.MountainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(tags = { "마운틴 컨트롤러  API V1" })

@RequestMapping("/mountain")
public class Mountaincontroller {

	private MountainService mountainservice;

	public Mountaincontroller(MountainService mountainservice) {
		super();
		this.mountainservice = mountainservice;
	}

	@ApiOperation(value = "산 추가", notes = "산의 정보를 추가한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Mountain added successfully"),
			@ApiResponse(code = 404, message = "Failed to add mountain"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@PostMapping("/add")
	public ResponseEntity<String> addMountain(@RequestBody MountainDto mountainDto) {
		try {
			mountainservice.addmountain(mountainDto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Mountain added successfully");
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add mountain");
		}
	}

	@ApiOperation(value = "정복한 산 추가", notes = "회원이 정복한 산 정보를 추가한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Mountain added successfully"),
			@ApiResponse(code = 404, message = "Failed to add mountain"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@PostMapping("/add/conqueredMountain")
	public ResponseEntity<String> AddconqueredMountain(@RequestParam("memberId") String memberId,
			@RequestParam("mntilistno") int mntilistno) {
		try {

			if (mountainservice.IsconqueredMountain(memberId, mntilistno) == 1) {
				mountainservice.Updateconquerednum(mntilistno);

			} else {

				mountainservice.AddConqueredMountain(memberId, mntilistno);
			}

			return ResponseEntity.status(HttpStatus.CREATED).body("Mountain added successfully");
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add mountain");
		}
	}

	@ApiOperation(value = "아직 정복하지 않은 산 목록 가져오기", notes = "회원이 아직 정복하지 않은 산 목록을 가져온다.")

	@GetMapping("/unconquered")
	public ResponseEntity<List<MountainDto>> getUnconqueredMountains(@RequestParam("memberId") String memberId) {
		try {
			List<MountainDto> unconqueredMountains = mountainservice.getUnconqueredMountains(memberId);
			return ResponseEntity.ok(unconqueredMountains);
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		}
	}

	@ApiOperation(value = "모든 산 목록 가져오기", notes = "모든 산의 목록을 가져온다.")

	@GetMapping("/all")
	public ResponseEntity<List<MountainDto>> allmountains() throws SQLException {
		List<MountainDto> allMountainDtos = mountainservice.allmountains();
		return ResponseEntity.ok(allMountainDtos);
	}

	@ApiOperation(value = "아직 정복하지 않은 산을 높이 순으로 가져오기", notes = "회원이 아직 정복하지 않은 산을 높이 순으로 가져온다.")

	@GetMapping("/unconquered/ascending")
	public ResponseEntity<List<MountainDto>> getUnconqueredMountainsAscendingByHeight(
			@RequestParam("memberId") String memberId) {
		try {
			List<MountainDto> unconqueredMountainsAscending = mountainservice
					.getUnconqueredMountainsAscendingByHeight(memberId);
			return ResponseEntity.ok(unconqueredMountainsAscending);
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		}
	}

	@ApiOperation(value = "아직 정복하지 않은 산 중 가장 가까운 산 목록 가져오기", notes = "회원이 아직 정복하지 않은 산 중에서 가장 가까운 산 목록을 가져온다.")

	@GetMapping("/unconquered/nearest")
	public ResponseEntity<List<MountainDto>> getNearestUnconqueredMountains(@RequestParam("memberId") String memberId) {
		try {
			List<MountainDto> nearestUnconqueredMountains = mountainservice.getNearestUnconqueredMountains(memberId);
			return ResponseEntity.ok(nearestUnconqueredMountains);
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		}
	}

//
//	@PostMapping()
//	public void addmountain(MountainDto mountainDto) throws SQLException {
//		mountainservice.addmountain(mountainDto);
//	}
//
//	@GetMapping
//	public ResponseEntity<List<MountainDto>> getUnconqueredMountains(MemberDto memberDto) throws SQLException {
//		// TODO Auto-generated method stub
//		return mountainservice.getUnconqueredMountains(memberDto);
//	}
//
//	@GetMapping
//	public List<MountainDto> getUnconqueredMountainsAscendingByHeight(MemberDto memberDto) throws SQLException {
//		// TODO Auto-generated method stub
//		return mountainservice.getUnconqueredMountainsAscendingByHeight(memberDto);
//	}
//
//	@GetMapping
//	public List<MountainDto> getNearestUnconqueredMountains(MemberDto memberDto) throws SQLException {
//		// TODO Auto-generated method stub
//		return mountainservice.getNearestUnconqueredMountains(memberDto);
//	}
}