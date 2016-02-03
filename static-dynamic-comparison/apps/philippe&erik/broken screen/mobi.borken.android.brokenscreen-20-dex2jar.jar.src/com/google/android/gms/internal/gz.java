package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class gz
{
  private final View DG;
  private final a FR;
  
  public gz(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.FR = new a(paramString1, paramCollection, paramInt, paramString2);
    this.DG = paramView;
  }
  
  public String fe()
  {
    return this.FR.fe();
  }
  
  public int ff()
  {
    return this.FR.ff();
  }
  
  public List<String> fg()
  {
    return this.FR.fg();
  }
  
  public String[] fh()
  {
    return (String[])this.FR.fg().toArray(new String[0]);
  }
  
  public String fi()
  {
    return this.FR.fi();
  }
  
  public View fj()
  {
    return this.DG;
  }
  
  public String getAccountName()
  {
    return this.FR.getAccountName();
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final hm CREATOR = new hm();
    private final int DF;
    private final String DH;
    private final List<String> Ec = new ArrayList();
    private final int xJ;
    private final String yN;
    
    a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.xJ = paramInt1;
      this.yN = paramString1;
      this.Ec.addAll(paramList);
      this.DF = paramInt2;
      this.DH = paramString2;
    }
    
    public a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String fe()
    {
      if (this.yN != null) {
        return this.yN;
      }
      return "<<default account>>";
    }
    
    public int ff()
    {
      return this.DF;
    }
    
    public List<String> fg()
    {
      return new ArrayList(this.Ec);
    }
    
    public String fi()
    {
      return this.DH;
    }
    
    public String getAccountName()
    {
      return this.yN;
    }
    
    public int getVersionCode()
    {
      return this.xJ;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      hm.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */