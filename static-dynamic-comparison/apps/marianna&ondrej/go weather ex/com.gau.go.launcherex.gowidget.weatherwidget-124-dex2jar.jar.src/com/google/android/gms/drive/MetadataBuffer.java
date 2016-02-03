package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class MetadataBuffer
  extends DataBuffer<Metadata>
{
  private static final String[] EL;
  private final String EM;
  private a EN;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.fS().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((MetadataField)localIterator.next()).fR());
    }
    EL = (String[])localArrayList.toArray(new String[0]);
  }
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.EM = paramString;
  }
  
  public Metadata get(int paramInt)
  {
    a locala2 = this.EN;
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (a.a(locala2) == paramInt) {}
    }
    else
    {
      locala1 = new a(this.BB, paramInt);
      this.EN = locala1;
    }
    return locala1;
  }
  
  public String getNextPageToken()
  {
    return this.EM;
  }
  
  private static class a
    extends Metadata
  {
    private final DataHolder BB;
    private final int BE;
    private final int EO;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.BB = paramDataHolder;
      this.EO = paramInt;
      this.BE = paramDataHolder.G(paramInt);
    }
    
    protected <T> T a(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.a(this.BB, this.EO, this.BE);
    }
    
    public Metadata fB()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.fT();
      Iterator localIterator = c.fS().iterator();
      while (localIterator.hasNext()) {
        ((MetadataField)localIterator.next()).a(this.BB, localMetadataBundle, this.EO, this.BE);
      }
      return new b(localMetadataBundle);
    }
    
    public boolean isDataValid()
    {
      return !this.BB.isClosed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */