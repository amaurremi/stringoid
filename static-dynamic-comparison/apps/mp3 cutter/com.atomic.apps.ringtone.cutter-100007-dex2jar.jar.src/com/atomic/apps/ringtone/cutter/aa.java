package com.atomic.apps.ringtone.cutter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Audio.Genres;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import com.google.a.b;
import com.google.android.gms.common.f;
import com.google.android.gms.internal.Y;
import com.google.android.gms.internal.Z;
import com.google.android.gms.internal.aH;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.ak;
import com.google.android.gms.internal.bA;
import com.google.android.gms.internal.bD;
import com.google.android.gms.internal.bI;
import com.google.android.gms.internal.bT;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bi;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dx;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class aa
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public int e = -1;
  private Uri f = MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI;
  private Activity g = null;
  private String h = "";
  
  aa(Activity paramActivity, String paramString)
  {
    this.g = paramActivity;
    this.h = paramString;
    this.a = g(paramString);
    try
    {
      a();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static int a(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int k = a(paramParcel, j);
    int i = paramParcel.dataPosition();
    if ((0xFFFF & j) != 20293) {
      throw new com.google.android.gms.common.internal.safeparcel.a("Expected object header. Got 0x" + Integer.toHexString(j), paramParcel);
    }
    j = i + k;
    if ((j < i) || (j > paramParcel.dataSize())) {
      throw new com.google.android.gms.common.internal.safeparcel.a("Size read is invalid start=" + i + " end=" + j, paramParcel);
    }
    return j;
  }
  
  public static int a(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  public static Parcelable a(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    paramInt = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static com.google.a.c a(ak paramak)
  {
    int i = 0;
    com.google.a.c[] arrayOfc = new com.google.a.c[6];
    arrayOfc[0] = com.google.a.c.a;
    arrayOfc[1] = com.google.a.c.b;
    arrayOfc[2] = com.google.a.c.c;
    arrayOfc[3] = com.google.a.c.d;
    arrayOfc[4] = com.google.a.c.e;
    arrayOfc[5] = com.google.a.c.f;
    while (i < arrayOfc.length)
    {
      if ((arrayOfc[i].a() == paramak.f) && (arrayOfc[i].b() == paramak.c)) {
        return arrayOfc[i];
      }
      i += 1;
    }
    return new com.google.a.c(com.google.android.gms.ads.c.a(paramak.f, paramak.c, paramak.b));
  }
  
  public static com.google.android.gms.ads.a.a a(ah paramah)
  {
    HashSet localHashSet;
    Date localDate;
    b localb;
    if (paramah.e != null)
    {
      localHashSet = new HashSet(paramah.e);
      localDate = new Date(paramah.b);
      switch (paramah.d)
      {
      default: 
        localb = b.a;
      }
    }
    for (;;)
    {
      return new com.google.android.gms.ads.a.a(localDate, localb, localHashSet, paramah.f, paramah.k);
      localHashSet = null;
      break;
      localb = b.c;
      continue;
      localb = b.b;
    }
  }
  
  public static bI a(Context paramContext, cx paramcx, bg parambg)
  {
    if (paramcx.k.e)
    {
      a("Fetching ad response from local ad request service.");
      paramContext = new bi(paramContext, paramcx, parambg);
      paramContext.e();
      return paramContext;
    }
    a("Fetching ad response from remote ad request service.");
    if (f.a(paramContext) != 0)
    {
      e("Failed to connect to remote ad request service.");
      return null;
    }
    return new bj(paramContext, paramcx, parambg);
  }
  
  public static Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("null reference");
    }
    return paramObject;
  }
  
  public static Object a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException(String.valueOf(paramObject2));
    }
    return paramObject1;
  }
  
  private static String a(Cursor paramCursor, String paramString)
  {
    paramCursor = paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
    if ((paramCursor != null) && (paramCursor.length() > 0)) {
      return paramCursor;
    }
    return null;
  }
  
  public static List a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(i));
        i += 1;
      }
      return Collections.unmodifiableList(paramString);
    }
    return null;
  }
  
  private void a()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = this.g.managedQuery(this.f, new String[] { "_id", "name" }, null, null, null);
    ((Cursor)localObject2).moveToFirst();
    if (((Cursor)localObject2).isAfterLast())
    {
      this.d = "";
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      label71:
      if (((Iterator)localObject2).hasNext()) {
        break label239;
      }
    }
    for (;;)
    {
      localObject1 = MediaStore.Audio.Media.getContentUriForPath(this.h);
      localObject2 = this.g;
      String str1 = "_data LIKE \"" + this.h + "\"";
      localObject1 = ((Activity)localObject2).managedQuery((Uri)localObject1, new String[] { "_id", "title", "artist", "album", "year", "_data" }, str1, null, null);
      if (((Cursor)localObject1).getCount() != 0) {
        break label377;
      }
      this.a = g(this.h);
      this.b = "";
      this.c = "";
      this.e = -1;
      return;
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), ((Cursor)localObject2).getString(1));
      ((Cursor)localObject2).moveToNext();
      break;
      label239:
      str1 = (String)((Iterator)localObject2).next();
      Activity localActivity = this.g;
      Uri localUri = Uri.parse(this.f.toString() + "/" + str1 + "/" + "members");
      String str2 = "_data LIKE \"" + this.h + "\"";
      if (localActivity.managedQuery(localUri, new String[] { "_data" }, str2, null, null).getCount() == 0) {
        break label71;
      }
      this.d = ((String)((HashMap)localObject1).get(str1));
    }
    label377:
    ((Cursor)localObject1).moveToFirst();
    this.a = a((Cursor)localObject1, "title");
    if ((this.a == null) || (this.a.length() == 0)) {
      this.a = g(this.h);
    }
    this.b = a((Cursor)localObject1, "artist");
    this.c = a((Cursor)localObject1, "album");
    localObject1 = Integer.valueOf(((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("year")));
    if (localObject1 != null) {}
    for (int i = ((Integer)localObject1).intValue();; i = -1)
    {
      this.e = i;
      return;
    }
  }
  
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
    paramWebSettings.setAppCacheMaxSize(0L);
    paramWebSettings.setAppCacheEnabled(true);
    paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
    paramWebSettings.setDatabaseEnabled(true);
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setDisplayZoomControls(false);
    paramWebSettings.setBuiltInZoomControls(true);
    paramWebSettings.setSupportZoom(true);
  }
  
  public static void a(Context paramContext, String paramString1, bA parambA, String paramString2, boolean paramBoolean, List paramList)
  {
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", parambA.o.f).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", bD.a).replaceAll("@gw_seqnum@", parambA.i);
        paramList = str2;
        if (parambA.l != null) {
          paramList = str2.replaceAll("@gw_adnetid@", parambA.l.b).replaceAll("@gw_allocid@", parambA.l.d);
        }
        new bT(paramContext, paramString1, paramList).e();
      }
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    c(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    c(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = k(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    l(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null) {
      return;
    }
    paramInt = k(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    l(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null) {
      return;
    }
    paramInt1 = k(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    l(paramParcel, paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramInt = k(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    l(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    paramInt = k(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    l(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    c(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable[] paramArrayOfParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfParcelable == null) {
      return;
    }
    int i = k(paramParcel, 8);
    int j = paramArrayOfParcelable.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      Parcelable localParcelable = paramArrayOfParcelable[paramInt1];
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        int k = paramParcel.dataPosition();
        paramParcel.writeInt(1);
        int m = paramParcel.dataPosition();
        localParcelable.writeToParcel(paramParcel, paramInt2);
        int n = paramParcel.dataPosition();
        paramParcel.setDataPosition(k);
        paramParcel.writeInt(n - m);
        paramParcel.setDataPosition(n);
      }
    }
    l(paramParcel, i);
  }
  
  public static void a(String paramString)
  {
    if (a(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static boolean a(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
  }
  
  public static boolean a(Context paramContext, cb paramcb, aH paramaH)
  {
    if (paramcb == null)
    {
      e("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramcb.c))
    {
      e("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramcb.d)) {
      localIntent.setDataAndType(Uri.parse(paramcb.c), paramcb.d);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramcb.e)) {
        localIntent.setPackage(paramcb.e);
      }
      if (TextUtils.isEmpty(paramcb.f)) {
        break label174;
      }
      arrayOfString = paramcb.f.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      e("Could not parse component name from open GMSG: " + paramcb.f);
      return false;
      localIntent.setData(Uri.parse(paramcb.c));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label174:
      d("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramaH.q();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      e(paramContext.getMessage());
    }
    return false;
  }
  
  public static int b(Parcel paramParcel)
  {
    return k(paramParcel, 20293);
  }
  
  public static void b(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(a(paramParcel, paramInt) + paramParcel.dataPosition());
  }
  
  private static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramParcel, paramInt1);
    if (paramInt1 != paramInt2) {
      throw new com.google.android.gms.common.internal.safeparcel.a("Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + Integer.toHexString(paramInt1) + ")", paramParcel);
    }
  }
  
  public static void b(String paramString)
  {
    if (a(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (a(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  private static void c(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void c(String paramString)
  {
    if (a(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static boolean c(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static int d(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static void d(String paramString)
  {
    if (a(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static long e(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static void e(String paramString)
  {
    if (a(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static String f(Parcel paramParcel, int paramInt)
  {
    paramInt = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  public static void f(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static IBinder g(Parcel paramParcel, int paramInt)
  {
    paramInt = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    return localIBinder;
  }
  
  private static String g(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf('/') + 1, paramString.lastIndexOf('.'));
  }
  
  public static Bundle h(Parcel paramParcel, int paramInt)
  {
    paramInt = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    return localBundle;
  }
  
  public static ArrayList i(Parcel paramParcel, int paramInt)
  {
    paramInt = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static void j(Parcel paramParcel, int paramInt)
  {
    l(paramParcel, paramInt);
  }
  
  private static int k(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void l(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */