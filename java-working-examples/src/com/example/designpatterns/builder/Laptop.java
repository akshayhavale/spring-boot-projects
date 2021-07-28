package com.example.designpatterns.builder;

public class Laptop {

	// mandatory field
	private String ram;
	private String hdd;
	// optional field
	private boolean hasInBuiltOs = false;

	public String getRam() {
		return ram;
	}

	public String getHdd() {
		return hdd;
	}

	public boolean isHasInBuiltOs() {
		return hasInBuiltOs;
	}

	private Laptop(LaptopBuilder laptopBuilder) {
		this.ram = laptopBuilder.ram;
		this.hdd = laptopBuilder.hdd;
		this.hasInBuiltOs = laptopBuilder.hasInBuiltOs;
	}

	public static class LaptopBuilder {
		private String ram;
		private String hdd;
		// optional field
		private boolean hasInBuiltOs = false;

		public LaptopBuilder(String ram, String hdd) {
			this.ram = ram;
			this.hdd = hdd;
		}

		public LaptopBuilder isHasInbuiltOs(boolean isHas) {
			this.hasInBuiltOs = isHas;
			return this;
		}

		public Laptop build() {
			return new Laptop(this);
		}
	}

	@Override
	public String toString() {
		return "Laptop [ram=" + ram + ", hdd=" + hdd + ", hasInBuiltOs=" + hasInBuiltOs + "]";
	}


}
