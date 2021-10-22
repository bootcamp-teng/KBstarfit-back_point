package com.starfit.point.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.point.model.CurrentPoint;

@Repository
public interface CurrentPointRepository extends JpaRepository<CurrentPoint, Long> {
	List<CurrentPoint> findByuserId(int userId);
}
