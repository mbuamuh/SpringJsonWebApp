package org.sample.json.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.sample.service.MoviesResource;

public class JsonRESTApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public JsonRESTApplication() {
		singletons.add(new MoviesResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
