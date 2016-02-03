package twitter4j.api;

import java.io.File;

import twitter4j.IDs;
import twitter4j.OEmbed;
import twitter4j.OEmbedRequest;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.UploadedMedia;

public abstract interface TweetsResources {
    public abstract Status destroyStatus(long paramLong);

    public abstract OEmbed getOEmbed(OEmbedRequest paramOEmbedRequest);

    public abstract IDs getRetweeterIds(long paramLong1, int paramInt, long paramLong2);

    public abstract IDs getRetweeterIds(long paramLong1, long paramLong2);

    public abstract ResponseList<Status> getRetweets(long paramLong);

    public abstract ResponseList<Status> lookup(long[] paramArrayOfLong);

    public abstract Status retweetStatus(long paramLong);

    public abstract Status showStatus(long paramLong);

    public abstract Status updateStatus(String paramString);

    public abstract Status updateStatus(StatusUpdate paramStatusUpdate);

    public abstract UploadedMedia uploadMedia(File paramFile);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/TweetsResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */