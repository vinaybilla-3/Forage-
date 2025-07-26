package com.hoen.resources;

import com.hoen.core.HotelCarSearchResult;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
    private List<HotelCarSearchResult> listings;

    public SearchResource() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        listings = Arrays.asList(mapper.readValue(new File("data/hotels_and_cars.json"), HotelCarSearchResult[].class));
    }

    @GET
    public List<HotelCarSearchResult> search(@QueryParam("city") String city) {
        if (city == null || city.isEmpty()) return Collections.emptyList();
        city = city.toLowerCase();
        List<HotelCarSearchResult> results = new ArrayList<>();
        for (HotelCarSearchResult item : listings) {
            if (item.city != null && item.city.toLowerCase().contains(city)) {
                results.add(item);
            }
        }
        return results;
    }
}
