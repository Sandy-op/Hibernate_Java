package org.jsp.manytooneuni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String answer;
	@Column(nullable = false)
	private String answredBy;
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionData question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswredBy() {
		return answredBy;
	}

	public void setAnswredBy(String answredBy) {
		this.answredBy = answredBy;
	}

	public QuestionData getQuestion() {
		return question;
	}

	public void setQuestion(QuestionData question) {
		this.question = question;
	}

}
