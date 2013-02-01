package org.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

@Produces("application/json")
@Path(value = "/mvc/json")
public class MoviesResource {

	public MoviesResource() {
		insertFavouriteMovies();
	}

	private List<String> favouriteMovies;

	private List<String> insertFavouriteMovies() {
		favouriteMovies = new ArrayList<String>();
		favouriteMovies.add(0, "My Best Friends wedding");
		favouriteMovies.add(1, "Aviator");
		favouriteMovies.add(2, "Sound of Music");
		favouriteMovies.add(3, "Mary Poppins");
		favouriteMovies.add(4, "My Big Fat Greek Wedding");
		favouriteMovies.add(5, "Pride and Prejudice");
		favouriteMovies.add(6, "Mamamia");
		favouriteMovies.add(7, "27 Dresses");
		favouriteMovies.add(8, "Break Up");
		favouriteMovies.add(9, "Beauty Shop");
		return favouriteMovies;
	}

	/**
	 * Get a random movie within the list of movies
	 * 
	 * @return 
	 */
	@GET
	public String getRandomMovie() {
		Random random = new Random();
		int i = random.nextInt(10);
		String randomMovie = favouriteMovies.get(i);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject().put("name", randomMovie);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String jsonMovie = jsonObject.toString(); 
		return jsonMovie;
	}

}
