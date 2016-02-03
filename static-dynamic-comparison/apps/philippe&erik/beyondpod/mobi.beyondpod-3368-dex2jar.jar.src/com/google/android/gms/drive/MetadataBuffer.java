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
  private static final String[] qS;
  private final String qT;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.cW().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((MetadataField)localIterator.next()).cV());
    }
    qS = (String[])localArrayList.toArray(new String[0]);
  }
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.qT = paramString;
  }
  
  public Metadata get(int paramInt)
  {
    return new a(this.nE, paramInt);
  }
  
  public String getNextPageToken()
  {
    return this.qT;
  }
  
  private static class a
    extends Metadata
  {
    private final DataHolder nE;
    private final int nH;
    private final int qU;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.nE = paramDataHolder;
      this.qU = paramInt;
      this.nH = paramDataHolder.C(paramInt);
    }
    
    protected <T> T a(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.c(this.nE, this.qU, this.nH);
    }
    
    public Metadata cK()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.cX();
      Iterator localIterator = c.cW().iterator();
      while (localIterator.hasNext()) {
        ((MetadataField)localIterator.next()).a(this.nE, localMetadataBundle, this.qU, this.nH);
      }
      return new b(localMetadataBundle);
    }
    
    public boolean isDataValid()
    {
      return !this.nE.isClosed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */