package org.kuzdowicz.repoaps.dto;

import java.util.Date;

public class TutorialDTO {

	private Long id;

	private String title;

	private String serviceDomain;

	private String author;

	private String url;

	private Long rating;

	private Integer reworkedInPercents;

	private Date startDateToDo;

	private Date endDateToDo;

	private String categryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getReworkedInPercents() {
		return reworkedInPercents;
	}

	public void setReworkedInPercents(Integer reworkedInPercents) {
		this.reworkedInPercents = reworkedInPercents;
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

	public String getCategryName() {
		return categryName;
	}

	public void setCategryName(String categryName) {
		this.categryName = categryName;
	}

}
