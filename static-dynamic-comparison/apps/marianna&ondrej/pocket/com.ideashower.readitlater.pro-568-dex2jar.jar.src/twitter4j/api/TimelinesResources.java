package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;

public abstract interface TimelinesResources
{
  public abstract ResponseList getHomeTimeline();
  
  public abstract ResponseList getHomeTimeline(Paging paramPaging);
  
  public abstract ResponseList getMentions();
  
  public abstract ResponseList getMentions(Paging paramPaging);
  
  public abstract ResponseList getMentionsTimeline();
  
  public abstract ResponseList getMentionsTimeline(Paging paramPaging);
  
  public abstract ResponseList getRetweetsOfMe();
  
  public abstract ResponseList getRetweetsOfMe(Paging paramPaging);
  
  public abstract ResponseList getUserTimeline();
  
  public abstract ResponseList getUserTimeline(long paramLong);
  
  public abstract ResponseList getUserTimeline(long paramLong, Paging paramPaging);
  
  public abstract ResponseList getUserTimeline(String paramString);
  
  public abstract ResponseList getUserTimeline(String paramString, Paging paramPaging);
  
  public abstract ResponseList getUserTimeline(Paging paramPaging);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/TimelinesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */