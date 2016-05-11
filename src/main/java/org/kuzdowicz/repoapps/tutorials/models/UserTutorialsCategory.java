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
public class UserTutorialsCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_NAME")
	private List<UserTutorial> tutorials;

	@Column(name = "USER_ID")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<UserTutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<UserTutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
