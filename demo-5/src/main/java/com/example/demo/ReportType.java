package com.example.demo;

public enum ReportType {

	RESET_ID("RESET_ID"), 
	STORE_NUMBER("STORE_NUMBER"),
	INSTANCE_ID("INSTANCE_ID"),
	AILE("AILE"),
	POG_FLOW_BAY("POG FLOW (BAY)"),
	MPOG_ID("MPOG_ID"),
	MPOG_NAME("MPOG_NAME (base/live)"),
	FIXTURE_HWD("Fixture HWD (interior)"),
	MULTIPROGRAM("MULTIPROGRAM"),
	MPOG_FUTURE("mPOG future"),
	POG_FLOW_FUTURE("POG Flow future")
	;

	private final String name;

	private ReportType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
