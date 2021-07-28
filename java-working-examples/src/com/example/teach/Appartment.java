package com.example.teach;

public class Appartment extends Home {

	private boolean parkingArea;

	public Appartment() {
		// TODO Auto-generated constructor stub
	}

	public Appartment(boolean parkingArea) {
		super();
		this.parkingArea = parkingArea;
	}

	public boolean isParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(boolean parkingArea) {
		this.parkingArea = parkingArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (parkingArea ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appartment other = (Appartment) obj;
		if (parkingArea != other.parkingArea)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appartment [parkingArea=" + parkingArea + "HOME[ " + "HOME NAME  = " + super.getName()
				+ " HOME CONCRET = " + super.getConcret() + " ]" + "]";
	}

}
