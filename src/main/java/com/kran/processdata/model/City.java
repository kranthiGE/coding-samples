package com.kran.processdata.model;

public class City {

	private String cityName;
	private Person person;
	
	public City(String cityName, Person person) {
		this.cityName = cityName;
		this.person = person;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cityName == null ? 0 : cityName.hashCode());
		result = prime * result + (person == null ? 0 : person.hashCode());
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
		City other = (City) obj;
		if (cityName == null || person == null) {
			return false;
		} 
		if (!cityName.equals(other.cityName))
			return false;
		if (!person.equals(other.person))
			return false;
		return true;
	}
	
}
