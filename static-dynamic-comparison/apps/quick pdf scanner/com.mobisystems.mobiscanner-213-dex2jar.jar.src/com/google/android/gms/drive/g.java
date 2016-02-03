package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class g
  extends a<f>
{
  private static final String[] sU;
  private final String sV;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.nu().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((b)localIterator.next()).nr());
    }
    sU = (String[])localArrayList.toArray(new String[0]);
  }
  
  public g(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.sV = paramString;
  }
  
  public f bs(int paramInt)
  {
    return new a(this.rM, paramInt);
  }
  
  private static class a
    extends f
  {
    private final DataHolder rM;
    private final int sW;
    private final int sf;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.rM = paramDataHolder;
      this.sW = paramInt;
      this.sf = paramDataHolder.bo(paramInt);
    }
    
    protected <T> T a(b<T> paramb)
    {
      return (T)paramb.c(this.rM, this.sW, this.sf);
    }
    
    public f mZ()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.ns();
      Iterator localIterator = c.nu().iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).a(this.rM, localMetadataBundle, this.sW, this.sf);
      }
      return new j(localMetadataBundle);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */