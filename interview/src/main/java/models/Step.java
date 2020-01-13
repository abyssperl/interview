package models;

public class Step {
	private int id;
	private String instructionStep;
	private int order;
	private int time;
	
	public Step(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getInstructionStep() {
		return instructionStep;
	}

	public void setInstructionStep(String steps) {
		this.instructionStep = steps;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + order;
		result = prime * result + ((instructionStep == null) ? 0 : instructionStep.hashCode());
		result = prime * result + time;
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
		Step other = (Step) obj;
		if (id != other.id)
			return false;
		if (order != other.order)
			return false;
		if (instructionStep == null) {
			if (other.instructionStep != null)
				return false;
		} else if (!instructionStep.equals(other.instructionStep))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Step [id=" + id + ", instructionStep=" + instructionStep + ", order=" + order + ", time=" + time + "]";
	}
	
	

}
