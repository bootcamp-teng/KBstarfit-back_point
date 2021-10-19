package com.starfit.point.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.point.model.Benefit;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {

}
