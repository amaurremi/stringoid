package com.vungle.publisher.net.http;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.inject.annotations.WrapperFrameworkVersion;
import java.util.regex.Pattern;
import javax.inject.Inject;

public abstract class HttpRequest
  implements Parcelable
{
  public static final Pattern a = Pattern.compile("^https://");
  public String b;
  public Bundle c;
  public String d;
  
  public abstract a a();
  
  public <T extends HttpRequest> T a(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readBundle();
    this.d = paramParcel.readString();
    return this;
  }
  
  public abstract b b();
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{" + b() + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeBundle(this.c);
    paramParcel.writeString(this.d);
  }
  
  public static abstract class Factory<T extends HttpRequest>
  {
    @Inject
    protected WrapperFramework a;
    @WrapperFrameworkVersion
    @Inject
    protected String b;
    private String c;
    
    public abstract T b();
    
    public T c()
    {
      HttpRequest localHttpRequest = b();
      Bundle localBundle = new Bundle();
      Object localObject2 = this.c;
      Object localObject1 = localObject2;
      String str;
      int i;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder("VungleDroid/3.0.7");
        localObject2 = this.a;
        str = this.b;
        if (localObject2 == null) {
          break label137;
        }
        i = 1;
        if (str == null) {
          break label142;
        }
      }
      label137:
      label142:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0))
        {
          ((StringBuilder)localObject1).append(';');
          if (i != 0) {
            ((StringBuilder)localObject1).append(localObject2);
          }
          if (j != 0)
          {
            ((StringBuilder)localObject1).append('/');
            ((StringBuilder)localObject1).append(str);
          }
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        this.c = ((String)localObject1);
        localBundle.putString("User-Agent", (String)localObject1);
        localHttpRequest.c = localBundle;
        return localHttpRequest;
        i = 0;
        break;
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */