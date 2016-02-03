package twitter4j;

import java.io.Serializable;

import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuthSupport;

public abstract interface Twitter
        extends Serializable, OAuthSupport, OAuth2Support, TwitterBase, TimelinesResources, TweetsResources, SearchResource, DirectMessagesResources, FriendsFollowersResources, UsersResources, SuggestedUsersResources, FavoritesResources, ListsResources, SavedSearchesResources, PlacesGeoResources, TrendsResources, SpamReportingResource, HelpResources {
    public abstract DirectMessagesResources directMessages();

    public abstract FavoritesResources favorites();

    public abstract FriendsFollowersResources friendsFollowers();

    public abstract HelpResources help();

    public abstract ListsResources list();

    public abstract PlacesGeoResources placesGeo();

    public abstract SavedSearchesResources savedSearches();

    public abstract SearchResource search();

    public abstract SpamReportingResource spamReporting();

    public abstract SuggestedUsersResources suggestedUsers();

    public abstract TimelinesResources timelines();

    public abstract TrendsResources trends();

    public abstract TweetsResources tweets();

    public abstract UsersResources users();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Twitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */