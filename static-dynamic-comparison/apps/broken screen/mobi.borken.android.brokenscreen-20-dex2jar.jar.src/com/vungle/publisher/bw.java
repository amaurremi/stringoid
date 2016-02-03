package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class bw
  implements Parcelable
{
  private static final Pattern a = Pattern.compile("\\bcharset=([\\w\\-]+)\\b");
  
  public static String a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    localObject8 = null;
    int i = 1;
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      localObject1 = paramHttpURLConnection.getContentType();
      if (localObject1 == null) {
        break label291;
      }
      localObject1 = a.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject1).find()) {
        break label291;
      }
      localObject1 = ((Matcher)localObject1).group(1);
    }
    finally
    {
      for (;;)
      {
        int j;
        Object localObject1;
        label79:
        Object localObject6 = localObject8;
        continue;
        Object localObject4 = null;
      }
    }
    Logger.v("VungleNetwork", "response character set: " + (String)localObject1);
    if (j / 100 <= 3) {}
    for (;;)
    {
      Object localObject5;
      if (i != 0)
      {
        localObject5 = paramHttpURLConnection.getInputStream();
        Object localObject7 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject7 = "ISO-8859-1";
        }
        localObject5 = new InputStreamReader((InputStream)localObject5, (String)localObject7);
        try
        {
          localObject1 = new StringBuilder();
          localObject7 = new char[' '];
          for (;;)
          {
            i = ((Reader)localObject5).read((char[])localObject7);
            if (i <= 0) {
              break;
            }
            ((StringBuilder)localObject1).append((char[])localObject7, 0, i);
          }
          if (localObject5 == null) {}
        }
        finally {}
      }
      try
      {
        ((Reader)localObject5).close();
        if (paramHttpURLConnection != null) {
          paramHttpURLConnection.disconnect();
        }
        throw ((Throwable)localObject2);
        i = 0;
        continue;
        localObject5 = paramHttpURLConnection.getErrorStream();
        break label79;
        String str = ((StringBuilder)localObject2).toString();
        Logger.d("VungleNetwork", "response body: " + str);
        try
        {
          ((Reader)localObject5).close();
          if (paramHttpURLConnection != null) {
            paramHttpURLConnection.disconnect();
          }
          return str;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            Logger.w("VungleNetwork", "error closing input stream " + paramHttpURLConnection.getURL(), localIOException1);
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Logger.w("VungleNetwork", "error closing input stream " + paramHttpURLConnection.getURL(), localIOException2);
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (b(paramInt)) || (paramInt == 603) || (paramInt == 408);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt / 100 == 5) || (paramInt == 602);
  }
  
  public <T extends bw> T b(Parcel paramParcel)
  {
    return this;
  }
  
  public abstract void b(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */