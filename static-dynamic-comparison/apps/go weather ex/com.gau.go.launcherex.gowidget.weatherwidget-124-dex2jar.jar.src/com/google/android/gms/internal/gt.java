package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.b;
import java.util.Date;

public class gt
{
  public static final a Gs = new a("created", 4100000);
  public static final b Gt = new b("lastOpenedTime", 4300000);
  public static final d Gu = new d("modified", 4100000);
  public static final c Gv = new c("modifiedByMe", 4100000);
  public static final e Gw = new e("sharedWithMe", 4100000);
  
  public static class a
    extends b
    implements SortableMetadataField<Date>
  {
    public a(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class b
    extends b
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends b
    implements SortableMetadataField<Date>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends b
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends b
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */