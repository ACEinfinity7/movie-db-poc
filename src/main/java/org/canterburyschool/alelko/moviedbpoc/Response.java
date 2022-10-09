package org.canterburyschool.alelko.moviedbpoc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Response {
	private static final Logger LOG = LogManager.getLogger(Response.class);

	private String routing;
	private Request req;

	public Response() {
		super();
		req = new Request();
	}

	public Response(String routing, Request req) {
		this.routing = routing;
		this.req = req;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	public Request getReq() {
		return req;
	}

	public void setReq(Request req) {
		this.req = req;
	}

}
