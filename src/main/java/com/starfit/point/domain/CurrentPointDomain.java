package com.starfit.point.domain;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.point.data.BenefitRepository;
import com.starfit.point.data.CurrentPointRepository;
import com.starfit.point.data.PointHistoryRepository;
import com.starfit.point.model.CurrentPoint;
import com.starfit.point.model.PointHistory;

@Service
public class CurrentPointDomain {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CurrentPointRepository CurrentPointRepo;
	
	public ResponseEntity<String> insertCurPoint(CurrentPoint point) throws Exception {
		log.info("Start db insert");
		CurrentPoint re  = CurrentPointRepo.save(point);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}

	public ResponseEntity<String> updateCurPoint(CurrentPoint point) throws Exception {
		log.info("Start db update==>"+point.getId());
		Optional<CurrentPoint> entity = CurrentPointRepo.findById(point.getId());
		
		if(entity.isPresent()) {
			entity.get().setCurrentPoint(point.getCurrentPoint());
			entity.get().setUserId(point.getCurrentPoint());
		}

		
		log.debug("result :"+ entity);
		
		return new ResponseEntity<String> (entity+"", HttpStatus.OK);
	}

	public ResponseEntity<List<CurrentPoint>> getCurPointList(String userId) {
		List<CurrentPoint> re = null;
		try {
			log.info("Start db select");
			re = CurrentPointRepo.findByuserId(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<CurrentPoint>> (re, HttpStatus.OK);
	}

	public ResponseEntity<Optional<CurrentPoint>> getCurPoint(Long Id) throws Exception {
		Optional<CurrentPoint> re = null;
		try {
			log.info("Start db select");
			re = CurrentPointRepo.findById(Id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<CurrentPoint>> (re, HttpStatus.OK);
	}
	public ResponseEntity <String > deleteCurPoint(Long Id) throws Exception { 
		log.info("Start db insert");
		CurrentPointRepo.deleteById(Id);
		log.debug("result :"+ "delete");
		
		return new ResponseEntity<String> ("delete", HttpStatus.OK);
	}
}
