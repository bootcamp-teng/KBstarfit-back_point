package com.starfit.point.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="pointhistory")
public class PointHistory {
	public PointHistory(Long id, int userId, int point, String description, LocalDateTime date) {
		super();
		this.id = id;
		this.userId = userId;
		this.point = point;
		this.description = description;
		this.date = date;
	}
	public PointHistory() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long id; 			// 포인트 정보 아이디 (pk)
	private int userId; 		// 회원 아이디(Fk).
	private int point; 			// point 소유 양
	private String description; // 포인트 기록 설명
	private LocalDateTime date; // 사용 날짜
	
}
