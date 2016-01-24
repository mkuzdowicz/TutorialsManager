package org.kuzdowicz.repoapps.tutorials.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TUTORIALS_CATEGORIES")
public class TutorialCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TUTORIALS_CATEGORIES_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private List<Tutorial> tutorials;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public Long getId() {
		return id;
	}

}
