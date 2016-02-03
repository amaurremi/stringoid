package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.d;
import java.util.Date;

public class it
{
  public static final a Kt = new a("created", 4100000);
  public static final b Ku = new b("lastOpenedTime", 4300000);
  public static final d Kv = new d("modified", 4100000);
  public static final c Kw = new c("modifiedByMe", 4100000);
  public static final e Kx = new e("sharedWithMe", 4100000);
  
  public static class a
    extends d
    implements SortableMetadataField<Date>
  {
    public a(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class b
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends d
    implements SortableMetadataField<Date>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/it.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */