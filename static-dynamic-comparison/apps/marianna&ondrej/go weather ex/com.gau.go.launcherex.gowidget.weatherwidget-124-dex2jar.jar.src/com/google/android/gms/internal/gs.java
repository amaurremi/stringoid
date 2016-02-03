package com.google.android.gms.internal;

import android.graphics.Bitmap;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.a;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.h;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.j;

public class gs
{
  public static final MetadataField<DriveId> FR = gu.Gx;
  public static final MetadataField<String> FS = new j("alternateLink", 4300000);
  public static final MetadataField<String> FT = new j("description", 4300000);
  public static final MetadataField<String> FU = new j("embedLink", 4300000);
  public static final MetadataField<String> FV = new j("fileExtension", 4300000);
  public static final MetadataField<Long> FW = new e("fileSize", 4300000);
  public static final MetadataField<Boolean> FX = new a("hasThumbnail", 4300000);
  public static final MetadataField<String> FY = new j("indexableText", 4300000);
  public static final MetadataField<Boolean> FZ = new a("isAppData", 4300000);
  public static final MetadataField<Boolean> Ga = new a("isCopyable", 4300000);
  public static final MetadataField<Boolean> Gb = new a("isEditable", 4100000);
  public static final a Gc = new a("isPinned", 4100000);
  public static final MetadataField<Boolean> Gd = new a("isRestricted", 4300000);
  public static final MetadataField<Boolean> Ge = new a("isShared", 4300000);
  public static final MetadataField<Boolean> Gf = new a("isTrashable", 4400000);
  public static final MetadataField<Boolean> Gg = new a("isViewed", 4300000);
  public static final b Gh = new b("mimeType", 4100000);
  public static final MetadataField<String> Gi = new j("originalFilename", 4300000);
  public static final b<String> Gj = new i("ownerNames", 4300000);
  public static final c Gk = new c("parents", 4100000);
  public static final d Gl = new d("quotaBytesUsed", 4300000);
  public static final e Gm = new e("starred", 4100000);
  public static final MetadataField<Bitmap> Gn = new h("thumbnail", 4400000)
  {
    protected Bitmap i(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final f Go = new f("title", 4100000);
  public static final g Gp = new g("trashed", 4100000);
  public static final MetadataField<String> Gq = new j("webContentLink", 4300000);
  public static final MetadataField<String> Gr = new j("webViewLink", 4300000);
  
  public static class a
    extends a
    implements SearchableMetadataField<Boolean>
  {
    public a(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class b
    extends j
    implements SearchableMetadataField<String>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends g<DriveId>
    implements SearchableCollectionMetadataField<DriveId>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends e
    implements SortableMetadataField<Long>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends a
    implements SearchableMetadataField<Boolean>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class f
    extends j
    implements SearchableMetadataField<String>, SortableMetadataField<String>
  {
    public f(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class g
    extends a
    implements SearchableMetadataField<Boolean>
  {
    public g(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    protected Boolean d(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      if (paramDataHolder.getInteger(getName(), paramInt1, paramInt2) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */