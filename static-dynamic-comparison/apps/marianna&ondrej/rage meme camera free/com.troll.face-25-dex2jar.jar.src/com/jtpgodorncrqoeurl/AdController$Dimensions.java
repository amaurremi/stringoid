package com.jtpgodorncrqoeurl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class AdController$Dimensions
  extends AdController.ReflectedParcelable
{
  public static final Parcelable.Creator CREATOR = new C();
  public int height;
  public int width;
  public int x;
  public int y;
  
  public AdController$Dimensions()
  {
    this.x = -1;
    this.y = -1;
    this.width = -1;
    this.height = -1;
  }
  
  protected AdController$Dimensions(Parcel paramParcel)
  {
    super(paramParcel);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdController$Dimensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */