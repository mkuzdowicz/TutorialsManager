package org.kuzdowicz.repoapps.tutorials.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TUTORIALS_CATEGORIES")
public class TutorialCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1221658658953762459L;

	@Id
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_NAME")
	private List<Tutorial> tutorials;

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
