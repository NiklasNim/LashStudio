package model;

public class Material {
	private String lashes;
	private String nails;
	private String hairColour;
	private String scissors;

	public Material(String lashes, String nails, String hairColour, String scissors) {
		this.lashes = lashes;
		this.nails = nails;
		this.hairColour = hairColour;
		this.scissors = scissors;
	}

	public String getLashes() {
		return lashes;
	}

	public void setLashes(String lashes) {
		this.lashes = lashes;
	}

	public String getNails() {
		return nails;
	}

	public void setNails(String nails) {
		this.nails = nails;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	public String getScissors() {
		return scissors;
	}

	public void setScissors(String scissors) {
		this.scissors = scissors;
	}

}
