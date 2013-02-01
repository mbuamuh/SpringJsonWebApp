package org.sample.components;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("moviesComponent")
public class MoviesComponent {
	
	private String url;
	
//	public MoviesComponent(String url){
//		this.url = url;
//	}
	
	
	public String getMovie(){
		
		String movie = null;
	HttpClient httpClient = new DefaultHttpClient();
	HttpGet request = new HttpGet(url);
	request.setHeader(new BasicHeader("Accept", "application/json"));
	try {
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		ObjectMapper mapper = new ObjectMapper();
		movie = mapper.readValue(entity.getContent(), String.class);
		//entity.g
		
//		HttpParams httpParams = response.getParams();
//		movie = (String) httpParams.getParameter("name");
	
	} catch (Exception e) {
		movie = "localUrl";
	} 
	
	finally{
		httpClient.getConnectionManager().shutdown();
	}
	return movie;
	
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
