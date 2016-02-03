package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.j;
import com.google.android.gms.drive.metadata.internal.k;
import com.google.android.gms.drive.metadata.internal.l;
import java.util.Collection;
import java.util.Collections;

public class ir
{
  public static final MetadataField<DriveId> JQ = iu.Ky;
  public static final MetadataField<String> JR = new l("alternateLink", 4300000);
  public static final a JS = new a(5000000);
  public static final MetadataField<String> JT = new l("description", 4300000);
  public static final MetadataField<String> JU = new l("embedLink", 4300000);
  public static final MetadataField<String> JV = new l("fileExtension", 4300000);
  public static final MetadataField<Long> JW = new g("fileSize", 4300000);
  public static final MetadataField<Boolean> JX = new com.google.android.gms.drive.metadata.internal.b("hasThumbnail", 4300000);
  public static final MetadataField<String> JY = new l("indexableText", 4300000);
  public static final MetadataField<Boolean> JZ = new com.google.android.gms.drive.metadata.internal.b("isAppData", 4300000);
  public static final MetadataField<Boolean> Ka = new com.google.android.gms.drive.metadata.internal.b("isCopyable", 4300000);
  public static final MetadataField<Boolean> Kb = new com.google.android.gms.drive.metadata.internal.b("isEditable", 4100000);
  public static final b Kc = new b("isPinned", 4100000);
  public static final MetadataField<Boolean> Kd = new com.google.android.gms.drive.metadata.internal.b("isRestricted", 4300000);
  public static final MetadataField<Boolean> Ke = new com.google.android.gms.drive.metadata.internal.b("isShared", 4300000);
  public static final MetadataField<Boolean> Kf = new com.google.android.gms.drive.metadata.internal.b("isTrashable", 4400000);
  public static final MetadataField<Boolean> Kg = new com.google.android.gms.drive.metadata.internal.b("isViewed", 4300000);
  public static final c Kh = new c("mimeType", 4100000);
  public static final MetadataField<String> Ki = new l("originalFilename", 4300000);
  public static final com.google.android.gms.drive.metadata.b<String> Kj = new k("ownerNames", 4300000);
  public static final d Kk = new d("parents", 4100000);
  public static final e Kl = new e("quotaBytesUsed", 4300000);
  public static final f Km = new f("starred", 4100000);
  public static final MetadataField<a> Kn = new j("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000)
  {
    protected a i(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final g Ko = new g("title", 4100000);
  public static final h Kp = new h("trashed", 4100000);
  public static final MetadataField<String> Kq = new l("webContentLink", 4300000);
  public static final MetadataField<String> Kr = new l("webViewLink", 4300000);
  public static final MetadataField<String> Ks = new l("uniqueIdentifier", 5000000);
  
  public static class a
    extends is
    implements SearchableMetadataField<AppVisibleCustomProperties>
  {
    public a(int paramInt)
    {
      super();
    }
  }
  
  public static class b
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends l
    implements SearchableMetadataField<String>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends i<DriveId>
    implements SearchableCollectionMetadataField<DriveId>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends g
    implements SortableMetadataField<Long>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class f
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public f(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class g
    extends l
    implements SearchableMetadataField<String>, SortableMetadataField<String>
  {
    public g(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class h
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public h(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    protected Boolean d(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      if (paramDataHolder.b(getName(), paramInt1, paramInt2) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */