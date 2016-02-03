package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class fr
  implements SafeParcelable
{
  public static final fs CREATOR = new fs();
  public final String mP;
  final int xM;
  final fi yq;
  final long yr;
  final int ys;
  final fg yt;
  
  fr(int paramInt1, fi paramfi, long paramLong, int paramInt2, String paramString, fg paramfg)
  {
    this.xM = paramInt1;
    this.yq = paramfi;
    this.yr = paramLong;
    this.ys = paramInt2;
    this.mP = paramString;
    this.yt = paramfg;
  }
  
  public fr(fi paramfi, long paramLong, int paramInt)
  {
    this(1, paramfi, paramLong, paramInt, null, null);
  }
  
  public fr(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList)
  {
    this(1, a(paramString1, paramIntent), System.currentTimeMillis(), 0, null, a(paramIntent, paramString2, paramUri, paramString3, paramList));
  }
  
  static fg a(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ab(paramString1));
    if (paramUri != null) {
      localArrayList.add(f(paramUri));
    }
    if (paramList != null) {
      localArrayList.add(a(paramList));
    }
    paramString1 = paramIntent.getAction();
    if (paramString1 != null) {
      localArrayList.add(f("intent_action", paramString1));
    }
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null) {
      localArrayList.add(f("intent_data", paramString1));
    }
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null) {
      localArrayList.add(f("intent_activity", paramString1.getClassName()));
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null) {
        localArrayList.add(f("intent_extra_data", paramIntent));
      }
    }
    return new fg(paramString2, true, (fk[])localArrayList.toArray(new fk[localArrayList.size()]));
  }
  
  public static fi a(String paramString, Intent paramIntent)
  {
    return new fi(paramString, "", f(paramIntent));
  }
  
  private static fk a(List<AppIndexApi.AppIndexingLink> paramList)
  {
    iv.a locala = new iv.a();
    iv.a.a[] arrayOfa = new iv.a.a[paramList.size()];
    int i = 0;
    while (i < arrayOfa.length)
    {
      arrayOfa[i] = new iv.a.a();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfa[i].UA = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfa[i].UB = localAppIndexingLink.webUrl.toString();
      arrayOfa[i].viewId = localAppIndexingLink.viewId;
      i += 1;
    }
    locala.Uy = arrayOfa;
    return new fk(me.d(locala), new fp.a("outlinks").w(true).aa(".private:outLinks").Z("blob").dQ());
  }
  
  private static fk ab(String paramString)
  {
    return new fk(paramString, new fp.a("title").I(1).x(true).aa("name").dQ(), "text1");
  }
  
  private static fk f(Uri paramUri)
  {
    return new fk(paramUri.toString(), new fp.a("web_url").I(4).w(true).aa("url").dQ());
  }
  
  private static fk f(String paramString1, String paramString2)
  {
    return new fk(paramString2, new fp.a(paramString1).w(true).dQ(), paramString1);
  }
  
  private static String f(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      throw new IllegalStateException(paramIntent);
    }
  }
  
  public int describeContents()
  {
    fs localfs = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[] { this.yq, Long.valueOf(this.yr), Integer.valueOf(this.ys) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fs localfs = CREATOR;
    fs.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */