package com.wugod.wg_framework2.bean.xml;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "telematics", strict = false)
public class BaseDataResult_XML {

	@Element
	public int error = -1;
	@Element
	public String status;
	@Element(required = false)
	public String message;
	@Element
	public Date date;
}
