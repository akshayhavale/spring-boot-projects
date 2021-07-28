package com.example.teach;

public class Conncret {

	private String concretName;

	public Conncret() {
		// TODO Auto-generated constructor stub
	}

	public Conncret(String concretName) {
		super();
		this.concretName = concretName;
	}

	public String getConcretName() {
		return concretName;
	}

	public void setConcretName(String concretName) {
		this.concretName = concretName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concretName == null) ? 0 : concretName.hashCode());
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
		Conncret other = (Conncret) obj;
		if (concretName == null) {
			if (other.concretName != null)
				return false;
		} else if (!concretName.equals(other.concretName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conncret [concretName=" + concretName + "]";
	}

}
