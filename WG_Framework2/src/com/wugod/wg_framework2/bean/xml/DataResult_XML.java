package com.wugod.wg_framework2.bean.xml;

import java.util.List;

import org.simpleframework.xml.Element;

public class DataResult_XML extends BaseDataResult_XML{
	@Element(required = false)
	public MovieResult_XML result;
	@Element(required = false)
	public List<MovieResult_XML> results;

}
