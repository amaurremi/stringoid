package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.ir;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class MetadataBuffer
  extends DataBuffer<Metadata>
{
  private static final String[] HO;
  private final String HP;
  private a HQ;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = e.gz().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((MetadataField)localIterator.next()).gx());
    }
    HO = (String[])localArrayList.toArray(new String[0]);
  }
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.HP = paramString;
    paramDataHolder.eP().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    a locala2 = this.HQ;
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (a.a(locala2) == paramInt) {}
    }
    else
    {
      locala1 = new a(this.DD, paramInt);
      this.HQ = locala1;
    }
    return locala1;
  }
  
  public String getNextPageToken()
  {
    return this.HP;
  }
  
  private static class a
    extends Metadata
  {
    private final DataHolder DD;
    private final int EA;
    private final int HR;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.DD = paramDataHolder;
      this.HR = paramInt;
      this.EA = paramDataHolder.ae(paramInt);
    }
    
    protected <T> T a(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.a(this.DD, this.HR, this.EA);
    }
    
    public Metadata gg()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.gA();
      Iterator localIterator = e.gz().iterator();
      while (localIterator.hasNext())
      {
        MetadataField localMetadataField = (MetadataField)localIterator.next();
        if ((!(localMetadataField instanceof b)) && (localMetadataField != ir.Kn)) {
          localMetadataField.a(this.DD, localMetadataBundle, this.HR, this.EA);
        }
      }
      return new l(localMetadataBundle);
    }
    
    public boolean isDataValid()
    {
      return !this.DD.isClosed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */