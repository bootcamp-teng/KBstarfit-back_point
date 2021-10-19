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
import com.starfit.point.data.PointHistoryRepository;
import com.starfit.point.model.PointHistory;

@Service
public class PointHistoryDomain {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PointHistoryRepository PointHistoryRepo;
	
	public ResponseEntity<String> insertPoint(PointHistory point) throws Exception {
		log.info("Start db insert");
		PointHistory re  = PointHistoryRepo.save(point);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}

	public ResponseEntity<String> updatePoint(PointHistory point) throws Exception {
		log.info("Start db update==>"+point.getId());
		Optional<PointHistory> entity = PointHistoryRepo.findById(point.getId());
		
		if(entity.isPresent()) {
			entity.get().setDate(point.getDate());
			entity.get().setDescription(point.getDescription());
			entity.get().setPoint(point.getPoint());
			entity.get().setUserId(point.getUserId());
			PointHistory re  = PointHistoryRepo.save(point);
		}

		
		log.debug("result :"+ entity);
		
		return new ResponseEntity<String> (entity+"", HttpStatus.OK);
	}

	public ResponseEntity<List<PointHistory>> getPointList(String userId) {
		List<PointHistory> re = null;
		try {
			log.info("Start db select");
			re = PointHistoryRepo.findByuserId(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<PointHistory>> (re, HttpStatus.OK);
	}

	public ResponseEntity<Optional<PointHistory>> getPoint(Long Id) throws Exception {
		Optional<PointHistory> re = null;
		try {
			log.info("Start db select");
			re = PointHistoryRepo.findById(Id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<PointHistory>> (re, HttpStatus.OK);
	}
}
