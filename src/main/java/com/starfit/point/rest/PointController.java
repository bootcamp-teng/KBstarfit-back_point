package com.starfit.point.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starfit.point.model.Benefit;
import com.starfit.point.model.CurrentPoint;
import com.starfit.point.model.PointHistory;
import com.starfit.point.service.PointService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="User API")
@RestController
public class PointController {
	@Autowired
	private PointService pointService;
	
	@GetMapping("/v1/benefit")	
	@ApiOperation(value="혜택 정보 가져오기", notes="혜탹 정보를 제공합니다. ")
	public ResponseEntity<List<Benefit>> getBenefitList() { 
		return pointService.getBenefitList();
	}
	
	@GetMapping("/v1/benefit/{benefitId}")
	@ApiOperation(value="아이디로 혜택 상세 정보 가져오기 ")
	public ResponseEntity <Optional<Benefit>> getBenefitById(
				@PathVariable (name="benefitId", required = true) Long benefitId
			) { 
		return pointService.getBenefitById(benefitId);
	}
	
	@PutMapping("/v1/benefit/{benefitId}")
	@ApiOperation(value="혜택 정보 변경하기 ")
	public ResponseEntity <String > updateBenefit(
			@RequestBody Benefit benefit
		) throws Exception { 
		
		return pointService.updateBenefit(benefit);
	}
	
	@PostMapping("/v1/benefit")
	@ApiOperation(value="혜탹 정보 등록하기 ")
	public ResponseEntity <String > insertBenefit(
			@RequestBody Benefit benefit
		) throws Exception { 
		
		return pointService.insertBenefit(benefit);
	}
	
	@DeleteMapping("/v1/benefit/{benefitId}")
	@ApiOperation(value="혜탹 정보 삭제하기 ")
	public ResponseEntity <String > deleteGoal(
			@PathVariable(name="benefitId",required = true ) Long benefitId
		) throws Exception { 
		
		return pointService.deleteBenefit(benefitId);
	}
	
	@GetMapping("/v1/point/{userId}")
	@ApiOperation(value="포인트 기록 조회하기")
	public ResponseEntity <List<PointHistory>> getUserPointList(
				@PathVariable(name="userId", required = true) String userId
			) throws Exception {
		return pointService.getPointList(userId);
	}
	
	@GetMapping("/v1/point/{Id}")
	@ApiOperation(value = "기록 상세 조회")
	public ResponseEntity <Optional<PointHistory>> getPoint(
			@PathVariable(name="Id", required = true) Long Id
		) throws Exception {
	return pointService.getPoint(Id);
	}
	
	@PostMapping("/v1/point")
	@ApiOperation(value="포인트 기록 추가하기")
	public ResponseEntity<String> insertPoint(
			@RequestBody PointHistory point
			) throws Exception {
			return pointService.insertPoint(point);
	}
	
	@PutMapping("/v1/point")
	@ApiOperation(value="유저 정보 수정하기")
	public ResponseEntity<String> updatePoint(
			@RequestBody PointHistory point
			) throws Exception{
		return pointService.updatePoint(point);
	}
	
	@GetMapping("/v1/current/{userId}")	
	@ApiOperation(value="유저의 현재 포인트 정보 가져오기", notes="유저의 현재 포인트 정보를 제공합니다. ")
	public ResponseEntity<List<CurrentPoint>> getCurPointList(
			@PathVariable(name="userId", required = true) String userId
			) { 
		return pointService.getCurPointList(userId);
	}
	
	@GetMapping("/v1/current/{currentPointId}")
	@ApiOperation(value="아이디로 포인트 정보 가져오기 ")
	public ResponseEntity <Optional<CurrentPoint>> getCurPointById(
				@PathVariable (name="currentPointId", required = true) Long curPointId
			) throws Exception { 
		return pointService.getCurPoint(curPointId);
	}
	
	@PutMapping("/v1/current/{currentPointId}")
	@ApiOperation(value="현재 포인트 정보 변경하기 ")
	public ResponseEntity <String > updateCurPoint(
			@RequestBody CurrentPoint currentPoint
		) throws Exception { 
		
		return pointService.updateCurrentPoint(currentPoint);
	}
	
	@PostMapping("/v1/current")
	@ApiOperation(value="현재 포인트 정보 등록하기 ")
	public ResponseEntity <String > insertCurPoint(
			@RequestBody CurrentPoint currentPoint
		) throws Exception { 
		
		return pointService.insertCurPoint(currentPoint);
	}
	
	@DeleteMapping("/v1/current/{currentId}")
	@ApiOperation(value="현재 포인트 정보 삭제하기 ")
	public ResponseEntity <String > deleteCurPoint(
			@PathVariable(name="currentId",required = true ) Long currentId
		) throws Exception { 
		
		return pointService.deleteCurrentPoint(currentId);
	}
//	@GetMapping("/createtestusers/{startUserId}/{userCount}")
//	@ApiOperation(value="테스트 사용자를 userCount명 등록하기 ")
//	public ResponseEntity <String > createTestUsers(
//			@PathVariable (name="startUserId", required = true) int startUserId,
//			@PathVariable (name="userCount", required = true) int userCount
//		) throws Exception { 
//		
//		return userService.createTestUsers(startUserId, userCount);
//	}	
}
