package com.wugod.wg_framework2.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "telematics", strict = false)
public class telematics {
	@Element
	public int error = -1;
	@Element
	public String status;
	@Element
	public Date date;
	@Element
	public result result;

	@Root(name = "result", strict = false)
	class result {

		@Element
		public int cityid;
		@Element
		public String cityname = "";
		@ElementList
		public List<movie> movie = new ArrayList<telematics.result.movie>();

		@Root(name = "movie", strict = false)
		class movie {

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
			@Element
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

		}
	}
}
