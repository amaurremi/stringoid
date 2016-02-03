package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;

public abstract interface TimelinesResources {
    public abstract ResponseList<Status> getHomeTimeline();

    public abstract ResponseList<Status> getHomeTimeline(Paging paramPaging);

    public abstract ResponseList<Status> getMentionsTimeline();

    public abstract ResponseList<Status> getMentionsTimeline(Paging paramPaging);

    public abstract ResponseList<Status> getRetweetsOfMe();

    public abstract ResponseList<Status> getRetweetsOfMe(Paging paramPaging);

    public abstract ResponseList<Status> getUserTimeline();

    public abstract ResponseList<Status> getUserTimeline(long paramLong);

    public abstract ResponseList<Status> getUserTimeline(long paramLong, Paging paramPaging);

    public abstract ResponseList<Status> getUserTimeline(String paramString);

    public abstract ResponseList<Status> getUserTimeline(String paramString, Paging paramPaging);

    public abstract ResponseList<Status> getUserTimeline(Paging paramPaging);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/TimelinesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */