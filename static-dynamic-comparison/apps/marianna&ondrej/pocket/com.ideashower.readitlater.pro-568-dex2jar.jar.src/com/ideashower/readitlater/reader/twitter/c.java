package com.ideashower.readitlater.reader.twitter;

import android.content.Context;
import android.widget.Toast;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.util.e;
import com.pocket.oauth.q;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class c
  extends m
{
  Context a;
  private final long b;
  private int c;
  
  public c(Context paramContext, long paramLong)
  {
    this.b = paramLong;
    this.a = paramContext;
  }
  
  protected void a()
  {
    try
    {
      q.a(this.a).retweetStatus(this.b);
      this.c = 0;
      return;
    }
    catch (TwitterException localTwitterException)
    {
      e.a(localTwitterException);
      if (localTwitterException.getStatusCode() != 401) {
        break label65;
      }
    }
    if (localTwitterException.getErrorCode() == 89) {
      q.c(this.a);
    }
    for (this.c = -1;; this.c = 1) {
      label65:
      do
      {
        this.c = -1;
        return;
      } while ((localTwitterException.getStatusCode() != 403) || (localTwitterException.getErrorCode() != -1));
    }
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    switch (this.c)
    {
    default: 
      return;
    case 0: 
      Toast.makeText(this.a, 2131493767, 0).show();
      return;
    case -1: 
      Toast.makeText(this.a, 2131493752, 0).show();
      return;
    }
    Toast.makeText(this.a, 2131493750, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/twitter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */