package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.j;

public class dz
{
  public static final b<DriveId> Mg = eb.MC;
  public static final b<Boolean> Mh;
  public static final b<Boolean> Mi;
  public static final b<Boolean> Mj;
  public static final b<String> Mk = new j("alternateLink", 4300000);
  public static final com.google.android.gms.drive.metadata.a<String> Ml = new i("ownerNames", 4300000);
  public static final b<String> Mm = new j("description", 4300000);
  public static final b<Boolean> Mn = new com.google.android.gms.drive.metadata.internal.a("isCopyable", 4300000);
  public static final b<String> Mo = new j("embedLink", 4300000);
  public static final b<String> Mp = new j("fileExtension", 4300000);
  public static final b<Long> Mq = new e("fileSize", 4300000);
  public static final b<Boolean> Mr = new com.google.android.gms.drive.metadata.internal.a("isViewed", 4300000);
  public static final b<Boolean> Ms = new com.google.android.gms.drive.metadata.internal.a("isRestricted", 4300000);
  public static final b<String> Mt = new j("originalFilename", 4300000);
  public static final b<Long> Mu = new e("quotaBytesUsed", 4300000);
  public static final b<String> Mv = new j("webContentLink", 4300000);
  public static final b<String> Mw = new j("webViewLink", 4300000);
  public static final b<String> Mx = new j("indexableText", 4300000);
  public static final b<Boolean> My = new com.google.android.gms.drive.metadata.internal.a("hasThumbnail", 4300000);
  public static final b<String> ug = new j("title", 4100000);
  public static final b<String> uh = new j("mimeType", 4100000);
  public static final b<Boolean> ui;
  public static final com.google.android.gms.drive.metadata.a<DriveId> uj;
  public static final b<Boolean> ul = new com.google.android.gms.drive.metadata.internal.a("starred", 4100000);
  public static final b<Boolean> uo;
  
  static
  {
    ui = new com.google.android.gms.drive.metadata.internal.a("trashed", 4100000)
    {
      protected Boolean d(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousDataHolder.b(getName(), paramAnonymousInt1, paramAnonymousInt2) != 0) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    };
    Mh = new com.google.android.gms.drive.metadata.internal.a("isEditable", 4100000);
    uo = new com.google.android.gms.drive.metadata.internal.a("isPinned", 4100000);
    Mi = new com.google.android.gms.drive.metadata.internal.a("isAppData", 4300000);
    Mj = new com.google.android.gms.drive.metadata.internal.a("isShared", 4300000);
    uj = new g("parents", 4100000);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */