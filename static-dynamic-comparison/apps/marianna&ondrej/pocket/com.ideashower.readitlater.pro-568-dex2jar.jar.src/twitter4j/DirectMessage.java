package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface DirectMessage
  extends Serializable, EntitySupport, TwitterResponse
{
  public abstract Date getCreatedAt();
  
  public abstract long getId();
  
  public abstract User getRecipient();
  
  public abstract long getRecipientId();
  
  public abstract String getRecipientScreenName();
  
  public abstract User getSender();
  
  public abstract long getSenderId();
  
  public abstract String getSenderScreenName();
  
  public abstract String getText();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/DirectMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */