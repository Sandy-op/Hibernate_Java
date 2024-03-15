package org.jsp.JpaPractice;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable {
	private long phone;
	private String emial;

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return "UserId [phone=" + phone + ", emial=" + emial + "]";
	}

}
