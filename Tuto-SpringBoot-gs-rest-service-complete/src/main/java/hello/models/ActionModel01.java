package hello.models;

import javax.validation.constraints.NotNull;

public class ActionModel01 {

	@NotNull
	private Integer a;
	@NotNull
	private Integer b;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

}
