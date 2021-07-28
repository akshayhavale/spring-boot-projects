package com.example.designpatterns;

public class BuildPughSingletonClass {

	private BuildPughSingletonClass() {

	}

	private static class BuildPughSingletonInnerclass {
		private static final BuildPughSingletonClass INSTANCE = new BuildPughSingletonClass();
	}

	public static BuildPughSingletonClass getInstance() {
		return BuildPughSingletonInnerclass.INSTANCE;
	}

}
