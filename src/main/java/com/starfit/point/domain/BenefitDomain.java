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
import com.starfit.point.model.Benefit;

@Service
public class BenefitDomain {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BenefitRepository BenefitRepo;
	
	public ResponseEntity<List<Benefit>> getBenefitList() { 
		
		List<Benefit> list = null;

		System.out.println(list);
		try {
			log.info("Start db select");
			list = BenefitRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<Benefit>> (list, HttpStatus.OK);
	}
	
	public ResponseEntity <Optional<Benefit>> getBenefitById(Long Id) { 
		Optional<Benefit> re = null;
		try {
			log.info("Start db select");
			re = BenefitRepo.findById(Id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<Benefit>> (re, HttpStatus.OK);
	}
	
	public ResponseEntity <String > updateBenefit(Benefit benefit) throws Exception { 
		log.info("Start db update==>"+benefit.getId());
		Benefit re;
		Optional<Benefit> entity = BenefitRepo.findById(benefit.getId());
		if(entity.isPresent()) {
		}
		
		log.debug("result :"+ "update");
		
		return new ResponseEntity<String> ("update", HttpStatus.OK);
	}

	public ResponseEntity <String > insertBenefit(Benefit benefit) throws Exception { 
		log.info("Start db insert");
		Benefit re  = BenefitRepo.save(benefit);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	public ResponseEntity <String > deleteBenefit(Long Id) throws Exception { 
		log.info("Start db insert");
		BenefitRepo.deleteById(Id);
		log.debug("result :"+ "delete");
		
		return new ResponseEntity<String> ("delete", HttpStatus.OK);
	}


}
