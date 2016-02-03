package com.ideashower.readitlater.reader.twitter;

import android.content.Context;
import android.widget.Toast;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.util.e;
import com.pocket.oauth.q;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class b
  extends m
{
  Context a;
  boolean b;
  long c;
  int d;
  
  public b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    this.a = paramContext;
    this.c = paramLong;
    this.b = paramBoolean;
  }
  
  protected void a()
  {
    Twitter localTwitter = q.a(this.a);
    if (localTwitter != null)
    {
      try
      {
        if (this.b)
        {
          localTwitter.destroyFavorite(this.c);
          this.d = 0;
          return;
        }
        localTwitter.createFavorite(this.c);
        this.d = 1;
        return;
      }
      catch (TwitterException localTwitterException)
      {
        e.a(localTwitterException);
        if ((localTwitterException.getStatusCode() == 403) && (localTwitterException.getErrorCode() == 139))
        {
          if (!this.b) {
            break label122;
          }
          this.d = 0;
        }
      }
      for (;;)
      {
        if ((localTwitterException.getStatusCode() == 401) && (localTwitterException.getErrorCode() == 89)) {
          q.c(this.a);
        }
        this.d = -1;
        return;
        label122:
        this.d = 1;
      }
    }
    this.d = -1;
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (this.d == 1) {
      Toast.makeText(this.a, 2131493753, 0).show();
    }
    do
    {
      return;
      if (this.d == 0)
      {
        Toast.makeText(this.a, 2131493775, 0).show();
        return;
      }
    } while (this.d != -1);
    Toast.makeText(this.a, 2131493751, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/twitter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */