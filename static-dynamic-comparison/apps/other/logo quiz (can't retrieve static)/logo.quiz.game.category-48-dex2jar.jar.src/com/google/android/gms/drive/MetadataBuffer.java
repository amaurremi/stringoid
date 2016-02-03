package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.kd;
import java.util.Collection;
import java.util.Iterator;

public final class MetadataBuffer
  extends DataBuffer<Metadata>
{
  private final String Ni;
  private a Nj;
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.Ni = paramString;
    paramDataHolder.gz().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    a locala2 = this.Nj;
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (a.a(locala2) == paramInt) {}
    }
    else
    {
      locala1 = new a(this.IC, paramInt);
      this.Nj = locala1;
    }
    return locala1;
  }
  
  public String getNextPageToken()
  {
    return this.Ni;
  }
  
  private static class a
    extends Metadata
  {
    private final DataHolder IC;
    private final int JR;
    private final int Nk;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.IC = paramDataHolder;
      this.Nk = paramInt;
      this.JR = paramDataHolder.ar(paramInt);
    }
    
    protected <T> T a(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.a(this.IC, this.Nk, this.JR);
    }
    
    public Metadata hR()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.io();
      Iterator localIterator = e.in().iterator();
      while (localIterator.hasNext())
      {
        MetadataField localMetadataField = (MetadataField)localIterator.next();
        if ((!(localMetadataField instanceof b)) && (localMetadataField != kd.Qd)) {
          localMetadataField.a(this.IC, localMetadataBundle, this.Nk, this.JR);
        }
      }
      return new l(localMetadataBundle);
    }
    
    public boolean isDataValid()
    {
      return !this.IC.isClosed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */