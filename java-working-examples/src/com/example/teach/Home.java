package com.example.teach;

public class Home {

	private String name;

	private Conncret concret;

	public Home() {

	}

	public Home(String name, Conncret concret) {
		super();
		this.name = name;
		this.concret = concret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Conncret getConcret() {
		return concret;
	}

	public void setConcret(Conncret concret) {
		this.concret = concret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concret == null) ? 0 : concret.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Home other = (Home) obj;
		if (concret == null) {
			if (other.concret != null)
				return false;
		} else if (!concret.equals(other.concret))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [name=" + name + ", concret=" + concret + "]";
	}

}
