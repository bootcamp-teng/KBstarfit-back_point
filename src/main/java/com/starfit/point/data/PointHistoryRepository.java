package com.starfit.point.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.point.model.PointHistory;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {
	List<PointHistory> findByuserId(String userId);
}
