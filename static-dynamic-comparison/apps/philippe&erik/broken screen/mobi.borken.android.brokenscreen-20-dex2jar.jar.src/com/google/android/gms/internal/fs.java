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

public class fs
  implements SafeParcelable
{
  public static final ft CREATOR = new ft();
  public final String mN;
  final int xJ;
  final fj yn;
  final long yo;
  final int yp;
  final fh yq;
  
  fs(int paramInt1, fj paramfj, long paramLong, int paramInt2, String paramString, fh paramfh)
  {
    this.xJ = paramInt1;
    this.yn = paramfj;
    this.yo = paramLong;
    this.yp = paramInt2;
    this.mN = paramString;
    this.yq = paramfh;
  }
  
  public fs(fj paramfj, long paramLong, int paramInt)
  {
    this(1, paramfj, paramLong, paramInt, null, null);
  }
  
  public fs(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList)
  {
    this(1, a(paramString1, paramIntent), System.currentTimeMillis(), 0, null, a(paramIntent, paramString2, paramUri, paramString3, paramList));
  }
  
  static fh a(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ab(paramString1));
    if (paramUri != null) {
      localArrayList.add(e(paramUri));
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
    return new fh(paramString2, true, (fl[])localArrayList.toArray(new fl[localArrayList.size()]));
  }
  
  public static fj a(String paramString, Intent paramIntent)
  {
    return new fj(paramString, "", f(paramIntent));
  }
  
  private static fl a(List<AppIndexApi.AppIndexingLink> paramList)
  {
    iw.a locala = new iw.a();
    iw.a.a[] arrayOfa = new iw.a.a[paramList.size()];
    int i = 0;
    while (i < arrayOfa.length)
    {
      arrayOfa[i] = new iw.a.a();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfa[i].Ux = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfa[i].Uy = localAppIndexingLink.webUrl.toString();
      arrayOfa[i].viewId = localAppIndexingLink.viewId;
      i += 1;
    }
    locala.Uv = arrayOfa;
    return new fl(mf.d(locala), new fq.a("outlinks").w(true).aa(".private:outLinks").Z("blob").dL());
  }
  
  private static fl ab(String paramString)
  {
    return new fl(paramString, new fq.a("title").I(1).x(true).aa("name").dL(), "text1");
  }
  
  private static fl e(Uri paramUri)
  {
    return new fl(paramUri.toString(), new fq.a("web_url").I(4).w(true).aa("url").dL());
  }
  
  private static fl f(String paramString1, String paramString2)
  {
    return new fl(paramString2, new fq.a(paramString1).w(true).dL(), paramString1);
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
    ft localft = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[] { this.yn, Long.valueOf(this.yo), Integer.valueOf(this.yp) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ft localft = CREATOR;
    ft.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */