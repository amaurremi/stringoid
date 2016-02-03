package com.vungle.publisher;

import android.util.SparseArray;
import com.vungle.publisher.log.Logger;
import java.net.HttpURLConnection;

public final class bv
{
  private static final SparseArray<bv> c = new SparseArray();
  public final int a;
  public final HttpURLConnection b;
  
  private bv(int paramInt)
  {
    this(paramInt, null);
  }
  
  private bv(int paramInt, HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramInt;
    this.b = paramHttpURLConnection;
  }
  
  public static bv a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bv a(int paramInt, HttpURLConnection paramHttpURLConnection)
  {
    int i;
    if (paramInt / 100 == 6) {
      i = 1;
    }
    while (i != 0)
    {
      paramHttpURLConnection = (bv)c.get(paramInt);
      if (paramHttpURLConnection == null)
      {
        paramHttpURLConnection = new bv(paramInt);
        Logger.d("VungleNetwork", "caching response: " + paramInt);
        c.put(paramInt, paramHttpURLConnection);
        return paramHttpURLConnection;
        i = 0;
      }
      else
      {
        Logger.d("VungleNetwork", "using cached response: " + paramInt);
        return paramHttpURLConnection;
      }
    }
    Logger.v("VungleNetwork", "response not cacheable: " + paramInt);
    return new bv(paramInt, paramHttpURLConnection);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */