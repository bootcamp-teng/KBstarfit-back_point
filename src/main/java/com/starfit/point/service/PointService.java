package com.starfit.point.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.point.domain.BenefitDomain;
import com.starfit.point.domain.CurrentPointDomain;
import com.starfit.point.domain.PointHistoryDomain;
import com.starfit.point.model.Benefit;
import com.starfit.point.model.CurrentPoint;
import com.starfit.point.model.PointHistory;

@Service
public class PointService {
	@Autowired
	private BenefitDomain benefitDomain;
	@Autowired
	private PointHistoryDomain pointHistoryDomain;
	@Autowired
	private CurrentPointDomain currentPointDomain;
//	
//	@Autowired
//	private TestDomain testDomain;
	
	public ResponseEntity <List<Benefit>> getBenefitList() { 
		return benefitDomain.getBenefitList();
	}
	
	public ResponseEntity <Optional<Benefit>> getBenefitById(Long Id) { 
		return benefitDomain.getBenefitById(Id);
	}
	
	public ResponseEntity <String > updateBenefit(Benefit benefit) throws Exception {
		return benefitDomain.updateBenefit(benefit);
	}
	
	public ResponseEntity <String > insertBenefit(Benefit benefit) throws Exception { 
		return benefitDomain.insertBenefit(benefit);		
	}

	public ResponseEntity <String > deleteBenefit(Long Id) throws Exception { 
		return benefitDomain.deleteBenefit(Id);
	}

	public ResponseEntity<String> insertPoint(PointHistory point) throws Exception {
		//ResponseEntity<Optional<CurrentPoint>> currPoint = currentPointDomain.getCurPoint(point.getId());
		if(!pointHistoryDomain.insertPoint(point).getStatusCode().equals(HttpStatus.OK)){
			throw new Exception();
		}
		ResponseEntity<List<CurrentPoint>> currPointEntity = currentPointDomain.getCurPointList(point.getUserId());
		List<CurrentPoint> currPointList  = currPointEntity.getBody();
		CurrentPoint currPoint = new CurrentPoint();
		if(!currPointList.isEmpty()) {
			currPoint = currPointList.get(0);
			int prevPoint = currPoint.getCurrentPoint();
			currPoint.setCurrentPoint(prevPoint + point.getPoint());
			return currentPointDomain.updateCurPoint(currPoint);
		}
		else {
			currPoint.setCurrentPoint(point.getPoint());
			currPoint.setUserId(point.getUserId());
			return currentPointDomain.insertCurPoint(currPoint);
		}
		//return pointHistoryDomain.insertPoint(point,currPoint);
	}

	public ResponseEntity<String> updatePoint( PointHistory point) throws Exception {
		return pointHistoryDomain.updatePoint(point);
	}

	public ResponseEntity<List<PointHistory>> getPointList(int userId) throws Exception {
		return pointHistoryDomain.getPointList(userId);
	}

	public ResponseEntity<Optional<PointHistory>> getPoint(Long Id) throws Exception {
		return pointHistoryDomain.getPoint(Id);
	}
	public ResponseEntity <List<CurrentPoint>> getCurPointList(int userId) { 
		return currentPointDomain.getCurPointList(userId);
	}
	
	public ResponseEntity <Optional<CurrentPoint>> getCurPoint(Long Id) throws Exception { 
		return currentPointDomain.getCurPoint(Id);
	}
	
	public ResponseEntity <String > updateCurrentPoint(CurrentPoint currentpoint) throws Exception {
		return currentPointDomain.updateCurPoint(currentpoint);
	}
	
	public ResponseEntity <String > insertCurPoint(CurrentPoint currentpoint) throws Exception { 
		return currentPointDomain.insertCurPoint(currentpoint);		
	}

	public ResponseEntity <String > deleteCurrentPoint(Long Id) throws Exception { 
		return currentPointDomain.deleteCurPoint(Id);
	}
	
//	public ResponseEntity <String > createTestGoals(int startGoalId, int goalCount) throws Exception { 
//		return goalDomain.createTestGoals(startGoalId, goalCount);
//	}
}
