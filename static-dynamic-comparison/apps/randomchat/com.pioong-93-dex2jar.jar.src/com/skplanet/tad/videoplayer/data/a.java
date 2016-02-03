package com.skplanet.tad.videoplayer.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public a a(Parcel paramAnonymousParcel)
    {
      return new a(paramAnonymousParcel);
    }
    
    public a[] a(int paramAnonymousInt)
    {
      return new a[paramAnonymousInt];
    }
  };
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public a() {}
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
  }
  
  public a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MenuData [menuId=" + this.a + ", menuTitle=" + this.b + ", menuType=" + this.c + ", landingURL=" + this.d + ", videoTitle=" + this.e + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */