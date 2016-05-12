package org.kuzdowicz.repoapps.tutorials.models;

import com.google.gson.annotations.SerializedName;

public class NoEmbedApiResponse {

	@SerializedName("author_name")
	private String authorName;
	@SerializedName("title")
	private String title;
	@SerializedName("thumbnail_url")
	private String thumbnailUrl;
	@SerializedName("error")
	private String error;
	@SerializedName("url")
	private String url;
	@SerializedName("provider_name")
	private String providerName;
	@SerializedName("provider_url")
	private String providerUrl;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

}
