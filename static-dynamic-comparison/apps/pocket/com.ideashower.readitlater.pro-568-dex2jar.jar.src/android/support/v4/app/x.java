package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class x
{
  Context a;
  CharSequence b;
  CharSequence c;
  PendingIntent d;
  PendingIntent e;
  RemoteViews f;
  Bitmap g;
  CharSequence h;
  int i;
  int j;
  boolean k;
  af l;
  CharSequence m;
  int n;
  int o;
  boolean p;
  ArrayList q = new ArrayList();
  Notification r = new Notification();
  
  public x(Context paramContext)
  {
    this.a = paramContext;
    this.r.when = System.currentTimeMillis();
    this.r.audioStreamType = -1;
    this.j = 0;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = this.r;
      localNotification.flags |= paramInt;
      return;
    }
    Notification localNotification = this.r;
    localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public Notification a()
  {
    return t.a().a(this);
  }
  
  public x a(int paramInt)
  {
    this.r.icon = paramInt;
    return this;
  }
  
  public x a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 1;
    this.r.ledARGB = paramInt1;
    this.r.ledOnMS = paramInt2;
    this.r.ledOffMS = paramInt3;
    Notification localNotification;
    if ((this.r.ledOnMS != 0) && (this.r.ledOffMS != 0))
    {
      paramInt1 = 1;
      localNotification = this.r;
      paramInt2 = this.r.flags;
      if (paramInt1 == 0) {
        break label88;
      }
    }
    label88:
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      localNotification.flags = (paramInt2 & 0xFFFFFFFE | paramInt1);
      return this;
      paramInt1 = 0;
      break;
    }
  }
  
  public x a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramBoolean;
    return this;
  }
  
  public x a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.q.add(new u(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public x a(long paramLong)
  {
    this.r.when = paramLong;
    return this;
  }
  
  public x a(PendingIntent paramPendingIntent)
  {
    this.d = paramPendingIntent;
    return this;
  }
  
  public x a(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
    return this;
  }
  
  public x a(Uri paramUri)
  {
    this.r.sound = paramUri;
    this.r.audioStreamType = -1;
    return this;
  }
  
  public x a(af paramaf)
  {
    if (this.l != paramaf)
    {
      this.l = paramaf;
      if (this.l != null) {
        this.l.a(this);
      }
    }
    return this;
  }
  
  public x a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }
  
  public x a(boolean paramBoolean)
  {
    a(2, paramBoolean);
    return this;
  }
  
  public x b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public x b(PendingIntent paramPendingIntent)
  {
    this.r.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public x b(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    return this;
  }
  
  public x b(boolean paramBoolean)
  {
    a(8, paramBoolean);
    return this;
  }
  
  public x c(CharSequence paramCharSequence)
  {
    this.r.tickerText = paramCharSequence;
    return this;
  }
  
  public x c(boolean paramBoolean)
  {
    a(16, paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */