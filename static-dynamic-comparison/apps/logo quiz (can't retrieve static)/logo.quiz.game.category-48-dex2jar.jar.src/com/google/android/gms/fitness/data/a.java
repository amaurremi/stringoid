package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kv;

public final class a
  implements SafeParcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  public static final a Sp = new a("com.google.android.gms", String.valueOf(6111000), null);
  private final int BR;
  private final String BZ;
  private final String Sq;
  private final String Sr;
  
  a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.BR = paramInt;
    this.BZ = ((String)n.i(paramString1));
    this.Sq = "";
    this.Sr = paramString3;
  }
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, "", paramString3);
  }
  
  private boolean a(a parama)
  {
    return (this.BZ.equals(parama.BZ)) && (m.equal(this.Sq, parama.Sq)) && (m.equal(this.Sr, parama.Sr));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof a)) && (a((a)paramObject)));
  }
  
  public String getPackageName()
  {
    return this.BZ;
  }
  
  public String getVersion()
  {
    return this.Sq;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.BZ, this.Sq, this.Sr });
  }
  
  a iA()
  {
    return new a(kv.bq(this.BZ), kv.bq(this.Sq), kv.bq(this.Sr));
  }
  
  public String iz()
  {
    return this.Sr;
  }
  
  public String toString()
  {
    return String.format("Application{%s:%s:%s}", new Object[] { this.BZ, this.Sq, this.Sr });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */