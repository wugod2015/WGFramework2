package com.wugod.wg_framework2.bean.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.wugod.wg_framework2.bean.Movie;

@Root(name = "result", strict = false)
public class MovieResult_XML {

	@Element
	public int cityid;
	@Element
	public String cityname = "";
	@ElementList
	public List<Movie> movie = new ArrayList<Movie>();

}