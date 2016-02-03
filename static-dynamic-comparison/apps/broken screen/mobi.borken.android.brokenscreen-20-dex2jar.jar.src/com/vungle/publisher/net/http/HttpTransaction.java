package com.vungle.publisher.net.http;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.vungle.publisher.bw;
import com.vungle.publisher.bx;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class HttpTransaction
  implements Parcelable
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  public HttpRequest a;
  bw b;
  bx c = new bx();
  @Inject
  HttpTransport d;
  
  HttpTransaction() {}
  
  public HttpTransaction(HttpRequest paramHttpRequest, bw parambw)
  {
    this.a = paramHttpRequest;
    this.b = parambw;
  }
  
  public final void a(a parama)
  {
    Object localObject = this.c;
    if (((bx)localObject).a <= 0L) {
      ((bx)localObject).a = SystemClock.elapsedRealtime();
    }
    ((bx)localObject).b += 1;
    ((bx)localObject).c += 1;
    localObject = this.b;
    HttpTransport localHttpTransport = this.d;
    ((bw)localObject).b(this, HttpTransport.a(this.a), parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{" + this.a + ", " + this.c + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<HttpTransaction>
  {
    @Inject
    Provider<HttpTransaction> a;
  }
  
  public static abstract interface a
  {
    public abstract void a(HttpTransaction paramHttpTransaction);
    
    public abstract void a(HttpTransaction paramHttpTransaction, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */