package com.creativedna.vortex.data;

import com.creativedna.vortex.data.callbacks.ArtistCallback;
import com.creativedna.vortex.data.callbacks.ArtistEventCallback;
import com.creativedna.vortex.data.callbacks.EventCallback;
import com.creativedna.vortex.data.callbacks.NotificationCallback;
import com.creativedna.vortex.data.callbacks.TicketsCallback;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.AutoSuggestSearchResult;
import com.creativedna.vortex.models.Category;
import com.creativedna.vortex.models.Event;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Bryan Lamtoo on 04/10/2016.
 */
public interface API {

    int EVENTS_LIMIT = 20;

    @GET("events?limit="+ EVENTS_LIMIT)
    Observable<EventCallback> getEvents();

    @GET("events")
    Observable<EventCallback> getPopularEvents();

    @GET("events?limit=6")
    Observable<EventCallback> getRecommendedEvents();

    @GET("autoSuggest/artist")
    Observable<AutoSuggestSearchResult> getUpcomingEvents(@Query("term") String artist);

    @POST("events/{id}")
    Observable<Event> getEvent(@Path("id") int id);

    @GET("categories")
    Observable<Category> getCategories();

    @GET("artists/{id}")
    Observable<Artist> getArtist(@Path("id") int id);

    @GET("artists/")
    Observable<ArtistCallback> getArtists();

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

    @GET("event_artists/{id}")
    Observable<ArtistEventCallback> getCategoryEvents(@Path("id") int id);

    @GET("notifications")
    Observable<NotificationCallback> getNotifications();

    @GET("tickets/{userID}")
    Observable<TicketsCallback> getTickets(@Path("userID") int userID);

}
