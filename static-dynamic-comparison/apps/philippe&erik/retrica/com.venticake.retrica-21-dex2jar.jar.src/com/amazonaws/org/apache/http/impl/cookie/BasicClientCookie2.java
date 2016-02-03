package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.SetCookie2;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicClientCookie2
  extends BasicClientCookie
  implements SetCookie2, Serializable
{
  private String commentURL;
  private boolean discard;
  private int[] ports;
  
  public BasicClientCookie2(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public Object clone()
  {
    BasicClientCookie2 localBasicClientCookie2 = (BasicClientCookie2)super.clone();
    if (this.ports != null) {
      localBasicClientCookie2.ports = ((int[])this.ports.clone());
    }
    return localBasicClientCookie2;
  }
  
  public int[] getPorts()
  {
    return this.ports;
  }
  
  public boolean isExpired(Date paramDate)
  {
    return (this.discard) || (super.isExpired(paramDate));
  }
  
  public void setCommentURL(String paramString)
  {
    this.commentURL = paramString;
  }
  
  public void setDiscard(boolean paramBoolean)
  {
    this.discard = paramBoolean;
  }
  
  public void setPorts(int[] paramArrayOfInt)
  {
    this.ports = paramArrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicClientCookie2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */