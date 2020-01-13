package models;

import java.util.List;

public class Receipe {
	private int id;
	private String receipeName;
	private String cookTime;
	private String prepTime;
	private int servingSize;
	private Region region;
	private EntreeType entreeList;
	private List<Step> instructionSteps;
	
	public Receipe() {}

	public Receipe(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getReceipeName() {
		return receipeName;
	}

	public void setReceipeName(String receipeName) {
		this.receipeName = receipeName;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public int getServingSize() {
		return servingSize;
	}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public EntreeType getEntreeList() {
		return entreeList;
	}

	public void setEntreeList(EntreeType entreeList) {
		this.entreeList = entreeList;
	}

	public List<Step> getInstructionSteps() {
		return instructionSteps;
	}

	public void setInstructionSteps(List<Step> instructionSteps) {
		this.instructionSteps = instructionSteps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cookTime == null) ? 0 : cookTime.hashCode());
		result = prime * result + ((entreeList == null) ? 0 : entreeList.hashCode());
		result = prime * result + id;
		result = prime * result + ((instructionSteps == null) ? 0 : instructionSteps.hashCode());
		result = prime * result + ((prepTime == null) ? 0 : prepTime.hashCode());
		result = prime * result + ((receipeName == null) ? 0 : receipeName.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + servingSize;
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
		Receipe other = (Receipe) obj;
		if (cookTime == null) {
			if (other.cookTime != null)
				return false;
		} else if (!cookTime.equals(other.cookTime))
			return false;
		if (entreeList != other.entreeList)
			return false;
		if (id != other.id)
			return false;
		if (instructionSteps == null) {
			if (other.instructionSteps != null)
				return false;
		} else if (!instructionSteps.equals(other.instructionSteps))
			return false;
		if (prepTime == null) {
			if (other.prepTime != null)
				return false;
		} else if (!prepTime.equals(other.prepTime))
			return false;
		if (receipeName == null) {
			if (other.receipeName != null)
				return false;
		} else if (!receipeName.equals(other.receipeName))
			return false;
		if (region != other.region)
			return false;
		if (servingSize != other.servingSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receipe [id=" + id + ", receipeName=" + receipeName + ", cookTime=" + cookTime + ", prepTime="
				+ prepTime + ", servingSize=" + servingSize + ", region=" + region + ", entreeList=" + entreeList
				+ ", instructionSteps=" + instructionSteps + "]";
	}

}
