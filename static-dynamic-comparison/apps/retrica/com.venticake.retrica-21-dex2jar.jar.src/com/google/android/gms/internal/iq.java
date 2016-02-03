package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.j;
import com.google.android.gms.drive.metadata.internal.k;
import com.google.android.gms.drive.metadata.internal.l;
import java.util.Collection;
import java.util.Collections;

public class iq
{
  public static final MetadataField<DriveId> JT = it.KB;
  public static final MetadataField<String> JU = new l("alternateLink", 4300000);
  public static final iq.a JV = new iq.a(5000000);
  public static final MetadataField<String> JW = new l("description", 4300000);
  public static final MetadataField<String> JX = new l("embedLink", 4300000);
  public static final MetadataField<String> JY = new l("fileExtension", 4300000);
  public static final MetadataField<Long> JZ = new g("fileSize", 4300000);
  public static final MetadataField<Boolean> Ka = new com.google.android.gms.drive.metadata.internal.b("hasThumbnail", 4300000);
  public static final MetadataField<String> Kb = new l("indexableText", 4300000);
  public static final MetadataField<Boolean> Kc = new com.google.android.gms.drive.metadata.internal.b("isAppData", 4300000);
  public static final MetadataField<Boolean> Kd = new com.google.android.gms.drive.metadata.internal.b("isCopyable", 4300000);
  public static final MetadataField<Boolean> Ke = new com.google.android.gms.drive.metadata.internal.b("isEditable", 4100000);
  public static final iq.b Kf = new iq.b("isPinned", 4100000);
  public static final MetadataField<Boolean> Kg = new com.google.android.gms.drive.metadata.internal.b("isRestricted", 4300000);
  public static final MetadataField<Boolean> Kh = new com.google.android.gms.drive.metadata.internal.b("isShared", 4300000);
  public static final MetadataField<Boolean> Ki = new com.google.android.gms.drive.metadata.internal.b("isTrashable", 4400000);
  public static final MetadataField<Boolean> Kj = new com.google.android.gms.drive.metadata.internal.b("isViewed", 4300000);
  public static final iq.c Kk = new iq.c("mimeType", 4100000);
  public static final MetadataField<String> Kl = new l("originalFilename", 4300000);
  public static final com.google.android.gms.drive.metadata.b<String> Km = new k("ownerNames", 4300000);
  public static final iq.d Kn = new iq.d("parents", 4100000);
  public static final iq.e Ko = new iq.e("quotaBytesUsed", 4300000);
  public static final iq.f Kp = new iq.f("starred", 4100000);
  public static final MetadataField<a> Kq = new j("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000)
  {
    protected a c(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final iq.g Kr = new iq.g("title", 4100000);
  public static final iq.h Ks = new iq.h("trashed", 4100000);
  public static final MetadataField<String> Kt = new l("webContentLink", 4300000);
  public static final MetadataField<String> Ku = new l("webViewLink", 4300000);
  public static final MetadataField<String> Kv = new l("uniqueIdentifier", 5000000);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */