package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public abstract interface TimelinesResources {
    public abstract ResponseList<Status> getHomeTimeline()
            throws TwitterException;

    public abstract ResponseList<Status> getHomeTimeline(Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getMentions()
            throws TwitterException;

    public abstract ResponseList<Status> getMentions(Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getMentionsTimeline()
            throws TwitterException;

    public abstract ResponseList<Status> getMentionsTimeline(Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getRetweetsOfMe()
            throws TwitterException;

    public abstract ResponseList<Status> getRetweetsOfMe(Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline()
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline(long paramLong)
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline(long paramLong, Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline(String paramString)
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline(String paramString, Paging paramPaging)
            throws TwitterException;

    public abstract ResponseList<Status> getUserTimeline(Paging paramPaging)
            throws TwitterException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/api/TimelinesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */