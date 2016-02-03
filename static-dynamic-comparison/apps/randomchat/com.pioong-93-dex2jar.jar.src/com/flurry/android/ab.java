package com.flurry.android;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

final class ab
  extends AsyncTask<Void, Void, String>
{
  private Context J;
  private String ae;
  private final String d = getClass().getSimpleName();
  
  public ab(FlurryAds paramFlurryAds, Context paramContext, String paramString)
  {
    this.J = paramContext;
    this.ae = paramString;
  }
  
  private String g()
  {
    Object localObject3 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject3;
      label232:
      Object localObject2;
      if (i < 5)
      {
        try
        {
          if (!Uri.parse(this.ae).getScheme().equals("http")) {
            break label232;
          }
          if ((FlurryAds.j(this.J) == true) && (!FlurryAds.k(this.J)))
          {
            localObject1 = bd.a(this.ae, 10000, 15000, false);
            if (localObject1 == null) {
              break label258;
            }
            int j = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
            if (j == 200)
            {
              new StringBuilder().append("Redirect URL found for: ").append(this.ae).toString();
              return this.ae;
            }
            if ((j >= 300) && (j < 400))
            {
              new StringBuilder().append("NumRedirects: ").append(i + 1).toString();
              if (!((HttpResponse)localObject1).containsHeader("Location")) {
                break label258;
              }
              this.ae = ((HttpResponse)localObject1).getFirstHeader("Location").getValue();
              break label258;
            }
            new StringBuilder().append("Bad Response status code: ").append(j).toString();
            return null;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return null;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.getMessage();
        }
        localObject2 = localObject3;
        if (FlurryAds.a(this.J, this.ae, "android.intent.action.VIEW")) {
          localObject2 = this.ae;
        }
      }
      return (String)localObject2;
      label258:
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */