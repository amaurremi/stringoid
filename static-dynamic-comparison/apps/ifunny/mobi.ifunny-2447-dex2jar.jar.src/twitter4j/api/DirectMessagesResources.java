package twitter4j.api;

import java.io.InputStream;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;

public abstract interface DirectMessagesResources {
    public abstract DirectMessage destroyDirectMessage(long paramLong);

    public abstract InputStream getDMImageAsStream(String paramString);

    public abstract ResponseList<DirectMessage> getDirectMessages();

    public abstract ResponseList<DirectMessage> getDirectMessages(Paging paramPaging);

    public abstract ResponseList<DirectMessage> getSentDirectMessages();

    public abstract ResponseList<DirectMessage> getSentDirectMessages(Paging paramPaging);

    public abstract DirectMessage sendDirectMessage(long paramLong, String paramString);

    public abstract DirectMessage sendDirectMessage(String paramString1, String paramString2);

    public abstract DirectMessage showDirectMessage(long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/DirectMessagesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */