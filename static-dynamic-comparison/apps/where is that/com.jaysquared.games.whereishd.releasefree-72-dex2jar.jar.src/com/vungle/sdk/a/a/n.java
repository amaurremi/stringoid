package com.vungle.sdk.a.a;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.vungle.sdk.al;
import com.vungle.sdk.al.a;

public final class n
  extends k
{
  public static final Parcelable.Creator<n> CREATOR = new o();
  private al b;
  private al.a c;
  
  public n()
  {
    this.a = -1;
  }
  
  final void a(i parami)
  {
    this.b.a(parami.b(), this.c);
  }
  
  final void a(al.a parama)
  {
    this.c = parama;
  }
  
  final void a(al paramal)
  {
    this.b = paramal;
  }
  
  final n b(Parcel paramParcel)
  {
    this.b = ((b)paramParcel.readStrongBinder()).a();
    this.c = ((a)paramParcel.readStrongBinder()).a();
    super.a(paramParcel);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(new b(this.b));
    paramParcel.writeStrongBinder(new a(this.c));
    super.writeToParcel(paramParcel, paramInt);
  }
  
  private static final class a
    extends Binder
  {
    private al.a a;
    
    a(al.a parama)
    {
      this.a = parama;
    }
    
    final al.a a()
    {
      return this.a;
    }
  }
  
  private static final class b
    extends Binder
  {
    private al a;
    
    b(al paramal)
    {
      this.a = paramal;
    }
    
    final al a()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */