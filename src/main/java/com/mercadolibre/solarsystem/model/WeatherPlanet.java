package com.mercadolibre.solarsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WeatherPlanet {
	
	@Id
	private Long id;
	
	@Column
	private Integer day;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Weather weather;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Planet planet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	@Override
	public String toString() {
		if(weather!=null && planet !=null ) {
			return "WeatherPlanet [id=" + id + ", day=" + day + ", weather=" + weather.getDescription() + ", planet=" + planet.getName() + "]";
		}
		return "WeatherPlanet [id=" + id + ", day=" + day + ", weather=" + weather + ", planet=" + planet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherPlanet other = (WeatherPlanet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
