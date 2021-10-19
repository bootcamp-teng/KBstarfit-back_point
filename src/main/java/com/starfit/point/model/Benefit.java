package com.starfit.point.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Benefit")
public class Benefit {
	
	public Benefit(Long id, String description, String benefit, String type, int point) {
		super();
		this.id = id;
		this.description = description;
		this.benefit = benefit;
		this.type = type;
		this.point = point;
	}
	public Benefit() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long  id 			; // 혜택 아이디
	private String description	; // 혜택 설명
	private String benefit		; // 혜택 양
	private String type 		; // 혜택 타입 (적금, 현금성,등 등)
	private int point 			; // 소요 포인트
	

}
