package org.kuzdowicz.repoapps.tutorials.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TUTORIALS")
public class Tutorial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TUTORIAL_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "SERVICE_DOMAIN")
	private String serviceDomain;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "URL")
	private String url;

	@Column(name = "RATING")
	private Long rating;

	@Column(name = "PROGRESS", columnDefinition = "int default 0", length = 100)
	private Integer progress;

	@Column(name = "START_DATE_TO_DO")
	private Date startDateToDo;

	@Column(name = "END_DATE_TO_DO")
	private Date endDateToDo;

	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category tutorialCategory;

	@Column(name = "USER_ID")
	private Long userId;

	@Transient
	private Long daysLeft;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Tutorial() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServiceDomain() {
		return serviceDomain;
	}

	public void setServiceDomain(String serviceDomain) {
		this.serviceDomain = serviceDomain;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Date getStartDateToDo() {
		return startDateToDo;
	}

	public void setStartDateToDo(Date startDateToDo) {
		this.startDateToDo = startDateToDo;
	}

	public Date getEndDateToDo() {
		return endDateToDo;
	}

	public void setEndDateToDo(Date endDateToDo) {
		this.endDateToDo = endDateToDo;
	}

	public Category getTutorialCategory() {
		return tutorialCategory;
	}

	public void setTutorialCategory(Category tutorialCategory) {
		this.tutorialCategory = tutorialCategory;
	}

	public Long getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(Long daysLeft) {
		this.daysLeft = daysLeft;
	}

}
