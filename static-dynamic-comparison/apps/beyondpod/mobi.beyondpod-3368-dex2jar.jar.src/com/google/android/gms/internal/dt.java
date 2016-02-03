package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class dt
{
  private final View nu;
  private final a oX;
  
  public dt(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.oX = new a(paramString1, paramCollection, paramInt, paramString2);
    this.nu = paramView;
  }
  
  public String bF()
  {
    return this.oX.bF();
  }
  
  public int bG()
  {
    return this.oX.bG();
  }
  
  public List<String> bH()
  {
    return this.oX.bH();
  }
  
  public String[] bI()
  {
    return (String[])this.oX.bH().toArray(new String[0]);
  }
  
  public String bJ()
  {
    return this.oX.bJ();
  }
  
  public View bK()
  {
    return this.nu;
  }
  
  public String getAccountName()
  {
    return this.oX.getAccountName();
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final ef CREATOR = new ef();
    private final String jG;
    private final int kg;
    private final int nt;
    private final String nv;
    private final List<String> oY = new ArrayList();
    
    a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
    {
      this.kg = paramInt1;
      this.jG = paramString1;
      this.oY.addAll(paramList);
      this.nt = paramInt2;
      this.nv = paramString2;
    }
    
    public a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
    {
      this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }
    
    public String bF()
    {
      if (this.jG != null) {
        return this.jG;
      }
      return "<<default account>>";
    }
    
    public int bG()
    {
      return this.nt;
    }
    
    public List<String> bH()
    {
      return new ArrayList(this.oY);
    }
    
    public String bJ()
    {
      return this.nv;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAccountName()
    {
      return this.jG;
    }
    
    public int getVersionCode()
    {
      return this.kg;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ef.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */