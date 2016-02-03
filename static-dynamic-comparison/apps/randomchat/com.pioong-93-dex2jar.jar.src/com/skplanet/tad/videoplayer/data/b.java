package com.skplanet.tad.videoplayer.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public b a(Parcel paramAnonymousParcel)
    {
      return new b(paramAnonymousParcel);
    }
    
    public b[] a(int paramAnonymousInt)
    {
      return new b[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public a[] f;
  
  public b() {}
  
  public b(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    paramParcel = paramParcel.readParcelableArray(a.class.getClassLoader());
    this.f = new a[paramParcel.length];
    int i = 0;
    for (;;)
    {
      if (i >= paramParcel.length) {
        return;
      }
      this.f[i] = ((a)paramParcel[i]);
      i += 1;
    }
  }
  
  public b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, a[] paramArrayOfa)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramArrayOfa;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str = "";
    a[] arrayOfa = this.f;
    int j = arrayOfa.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return "MetaData [multiType=" + this.a + ", tagURL=" + this.b + ", scenarioNo=" + this.c + ", videoURL=" + this.d + ", videoTitle=" + this.e + ", menuDatas=" + str + "]";
      }
      a locala = arrayOfa[i];
      str = str + locala.toString();
      i += 1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeParcelableArray(this.f, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */