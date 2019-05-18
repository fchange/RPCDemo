package bean;

import java.io.Serializable;

public class Hitokoto implements Serializable {

	private String hitokoto;
	private String from;

	public Hitokoto(String hitokoto, String from) {
		this.hitokoto = hitokoto;
		this.from = from;
	}

	public String getHitokoto() {
		return hitokoto;
	}

	public void setHitokoto(String hitokoto) {
		this.hitokoto = hitokoto;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "Hitokoto{" +
			"hitokoto='" + hitokoto + '\'' +
			", from=" + from +
			'}';
	}
}
