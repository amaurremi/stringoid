package twitter4j.api;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;

public abstract interface DirectMessagesResources
{
  public abstract DirectMessage destroyDirectMessage(long paramLong);
  
  public abstract ResponseList getDirectMessages();
  
  public abstract ResponseList getDirectMessages(Paging paramPaging);
  
  public abstract ResponseList getSentDirectMessages();
  
  public abstract ResponseList getSentDirectMessages(Paging paramPaging);
  
  public abstract DirectMessage sendDirectMessage(long paramLong, String paramString);
  
  public abstract DirectMessage sendDirectMessage(String paramString1, String paramString2);
  
  public abstract DirectMessage showDirectMessage(long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/DirectMessagesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */