package com.mercadolibre.solarsystem.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.mercadolibre.solarsystem.utils.MathUtil;

@Entity
public class Planet {
	
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private Long distanceOfTheSun;
	@Column
	private Integer daysOfTheYear;
	@Column
	private Boolean clockwise;
	@Column
	private Integer velocityInDegrees;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDistanceOfTheSun() {
		return distanceOfTheSun;
	}
	public void setDistanceOfTheSun(Long distanceOfTheSun) {
		this.distanceOfTheSun = distanceOfTheSun;
	}
	public Integer getDaysOfTheYear() {
		return daysOfTheYear;
	}
	public void setDaysOfTheYear(Integer daysOfTheYear) {
		this.daysOfTheYear = daysOfTheYear;
	}
	public Boolean getClockwise() {
		return clockwise;
	}
	public void setClockwise(Boolean clockwise) {
		this.clockwise = clockwise;
	}
	public Integer getVelocityInDegrees() {
		return velocityInDegrees;
	}
	public void setVelocityInDegrees(Integer velocityInDegrees) {
		this.velocityInDegrees = velocityInDegrees;
	}
	
	public Double calculateDegressOfPosition(Integer days) {
		Integer degrees = 0;
		Integer auxDay = new Integer(days);
		if(auxDay > this.daysOfTheYear) {
			auxDay = MathUtil.restYearsFromDays(auxDay,this.daysOfTheYear);
			degrees = auxDay * this.velocityInDegrees;
		}else {
			degrees = auxDay * this.velocityInDegrees;
		}
		if(!this.clockwise) {
			degrees = 360 - degrees;
		}
		return Math.toRadians(degrees);
	}
	
	public Double calculateXPosition(Integer days) {
		Double xPositions = 0D;
		xPositions =  new BigDecimal(this.distanceOfTheSun * Math.cos(this.calculateDegressOfPosition(days))).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		return xPositions;
	}
	
	public Double calculateYPosition(Integer days) {
		Double yPositions = 0D;
		yPositions = new BigDecimal(this.distanceOfTheSun * Math.sin(this.calculateDegressOfPosition(days))).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		return yPositions;
	}
	
	public Integer getDayOfTheYear(Integer days) {
		Integer auxDay = new Integer(days);
		return  MathUtil.restYearsFromDays(auxDay,this.daysOfTheYear);
	}
	
	public Integer getYear(Integer days) {
		Integer years = 0;
		
		if(days > this.daysOfTheYear && !days.equals(0)) {
			years = new Integer(days) / this.daysOfTheYear;
		}
		return years;
	}
	
}
