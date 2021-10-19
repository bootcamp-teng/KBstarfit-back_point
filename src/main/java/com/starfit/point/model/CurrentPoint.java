package com.starfit.point.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="currentpoint")
public class CurrentPoint {
	
	public CurrentPoint(Long id, int userId, int currentPoint) {
		super();
		this.id = id;
		this.userId = userId;
		this.currentPoint = currentPoint;
	}
	public CurrentPoint() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long id; 			// 포인트 정보 아이디 (pk)
	private int userId; 		// 회원 아이디(Fk).
	private int currentPoint; 			// 현재 point 소유 양
}
