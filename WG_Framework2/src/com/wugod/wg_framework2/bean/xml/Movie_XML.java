package com.wugod.wg_framework2.bean.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "movie", strict = false)
public class Movie_XML {

	@Element
	private String movie_id;
	@Element
	private String movie_name;
	@Element
	private String movie_type;
	@Element
	private java.util.Date movie_release_date;
	@Element
	private String movie_nation;
	@Element
	private String movie_starring;
	@Element
	private String movie_length;
	@Element
	private String movie_picture;
	@Element(required = false)
	private String movie_score;
	@Element
	private String movie_director;
	@Element
	private String movie_tags;
	@Element
	private String movie_message;
	@Element
	private String is_imax;
	@Element
	private String is_new;
	@Element
	private String movie_big_picture;
	@Element
	private String movies_wd;
	public Movie_XML() {
	}

	public Movie_XML(String movie_id) {
		this.movie_id = movie_id;
	}

	public Movie_XML(String movie_id, String movie_name, String movie_type,
			java.util.Date movie_release_date, String movie_nation,
			String movie_starring, String movie_length, String movie_picture,
			String movie_score, String movie_director, String movie_tags,
			String movie_message, String is_imax, String is_new,
			String movie_big_picture, String movies_wd) {
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.movie_type = movie_type;
		this.movie_release_date = movie_release_date;
		this.movie_nation = movie_nation;
		this.movie_starring = movie_starring;
		this.movie_length = movie_length;
		this.movie_picture = movie_picture;
		this.movie_score = movie_score;
		this.movie_director = movie_director;
		this.movie_tags = movie_tags;
		this.movie_message = movie_message;
		this.is_imax = is_imax;
		this.is_new = is_new;
		this.movie_big_picture = movie_big_picture;
		this.movies_wd = movies_wd;
	}

	/** Not-null value. */
	public String getMovie_id() {
		return movie_id;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	/** Not-null value. */
	public String getMovie_name() {
		return movie_name;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_type() {
		return movie_type;
	}

	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}

	public java.util.Date getMovie_release_date() {
		return movie_release_date;
	}

	public void setMovie_release_date(java.util.Date movie_release_date) {
		this.movie_release_date = movie_release_date;
	}

	public String getMovie_nation() {
		return movie_nation;
	}

	public void setMovie_nation(String movie_nation) {
		this.movie_nation = movie_nation;
	}

	public String getMovie_starring() {
		return movie_starring;
	}

	public void setMovie_starring(String movie_starring) {
		this.movie_starring = movie_starring;
	}

	public String getMovie_length() {
		return movie_length;
	}

	public void setMovie_length(String movie_length) {
		this.movie_length = movie_length;
	}

	public String getMovie_picture() {
		return movie_picture;
	}

	public void setMovie_picture(String movie_picture) {
		this.movie_picture = movie_picture;
	}

	public String getMovie_score() {
		return movie_score;
	}

	public void setMovie_score(String movie_score) {
		this.movie_score = movie_score;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public String getMovie_tags() {
		return movie_tags;
	}

	public void setMovie_tags(String movie_tags) {
		this.movie_tags = movie_tags;
	}

	public String getMovie_message() {
		return movie_message;
	}

	public void setMovie_message(String movie_message) {
		this.movie_message = movie_message;
	}

	public String getIs_imax() {
		return is_imax;
	}

	public void setIs_imax(String is_imax) {
		this.is_imax = is_imax;
	}

	public String getIs_new() {
		return is_new;
	}

	public void setIs_new(String is_new) {
		this.is_new = is_new;
	}

	public String getMovie_big_picture() {
		return movie_big_picture;
	}

	public void setMovie_big_picture(String movie_big_picture) {
		this.movie_big_picture = movie_big_picture;
	}

	public String getMovies_wd() {
		return movies_wd;
	}

	public void setMovies_wd(String movies_wd) {
		this.movies_wd = movies_wd;
	}
}
