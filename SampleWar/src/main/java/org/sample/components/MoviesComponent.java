package org.sample.components;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.springframework.stereotype.Component;

@Component
public class MoviesComponent {
	
	private String url;
	
	
	public String getMovie(){
		
		String movie = null;
	HttpClient httpClient = new DefaultHttpClient();
	HttpGet request = new HttpGet(url);
	try {
		HttpResponse response = httpClient.execute(request);
		HttpParams httpParams = response.getParams();
		movie = (String) httpParams.getParameter("name");
		
	} catch (Exception e) {
		movie = "localUrl";
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
