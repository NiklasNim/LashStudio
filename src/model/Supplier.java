package model;

public class Supplier {
	private String name;
	private int cvr;

	public Supplier(String name, int cvr) {
		this.name = name;
		this.cvr = cvr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCvr() {
		return cvr;
	}

	public void setCvr(int cvr) {
		this.cvr = cvr;
	}
}
