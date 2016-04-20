package com.creativedna.vortex.data;

import com.creativedna.vortex.data.callbacks.EventCallback;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.AutoSuggestSearchResult;
import com.creativedna.vortex.models.Event;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Bryan Lamtoo on 04/10/2016.
 */
public interface API {
    String BASE_URL = "http://localhost/vortex/index.php/api/";
    static int EVENTS_LIMIT = 20;

    @GET("events?limit=" + EVENTS_LIMIT)
    Observable<EventCallback> getEvents();

    @GET("events")
    Observable<EventCallback> getPopularEvents();

    @GET("events?limit=6")
    Observable<EventCallback> getRecommendedEvents();

    @GET("autoSuggest/artist")
    Observable<AutoSuggestSearchResult> getUpcomingEvents(@Query("term") String artist);

    @POST("events/{id}")
    Observable<Event> getEvent(@Path("id") int id);

    @GET("artists/{id}")
    Observable<Artist> getArtist(@Path("id") int id);

    @GET("artists/")
    Observable<EventCallback> getArtists();

    @GET("artists/")
    Observable<Artist> searchArtists(@Query("artist") String artist);

    @GET("autoSuggest/artist")
    Observable<AutoSuggestSearchResult> autoSuggestArtist(@Query("term") String artist);

    @GET("autoSuggest/event")
    Observable<AutoSuggestSearchResult> autoSuggestEvent(@Query("term") String event);

    @GET("autoSuggest/event")
    Observable<AutoSuggestSearchResult> getMyArtistEvents2(@Query("term") String event);

    @GET("autoSuggest/venue")
    Observable<AutoSuggestSearchResult> autoSuggestVenue(@Query("term") String venue);

    @GET("autoSuggest/location")
    Observable<AutoSuggestSearchResult> autoSuggestLocation(@Query("term") String venue);

}