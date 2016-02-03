package com.pocket.gsf;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.a.c;
import com.ideashower.readitlater.util.j;
import java.util.ArrayList;
import java.util.Iterator;

public class GSFConfiguation
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public GSFConfiguation a(Parcel paramAnonymousParcel)
    {
      return new GSFConfiguation(paramAnonymousParcel);
    }
    
    public GSFConfiguation[] a(int paramAnonymousInt)
    {
      return new GSFConfiguation[paramAnonymousInt];
    }
  };
  private String a;
  private int b;
  private String c;
  private String d;
  private String e;
  private ArrayList f;
  private String g;
  private boolean h;
  private boolean i = true;
  private boolean j = true;
  
  public GSFConfiguation() {}
  
  public GSFConfiguation(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.g = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.h = bool1;
      if (paramParcel.readInt() != 1) {
        break label155;
      }
      bool1 = true;
      label81:
      this.j = bool1;
      if (paramParcel.readInt() != 1) {
        break label160;
      }
    }
    label155:
    label160:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.i = bool1;
      this.e = paramParcel.readString();
      this.f = new ArrayList();
      while (paramParcel.dataAvail() > 0) {
        this.f.add((GSFDemoStep)paramParcel.readParcelable(GSFDemoStep.class.getClassLoader()));
      }
      bool1 = false;
      break;
      bool1 = false;
      break label81;
    }
  }
  
  public Intent a(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.d.equals("browser"))
    {
      String str = c.c();
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        ((Intent)localObject1).setPackage(this.a);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = paramContext.getPackageManager().getLaunchIntentForPackage(this.a);
      ((Intent)localObject2).addFlags(268435456);
    }
    return (Intent)localObject2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.f = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.j = paramBoolean1;
    this.i = paramBoolean2;
  }
  
  public int b(int paramInt)
  {
    if (j.c())
    {
      paramInt = 56;
      if (!j.c()) {
        break label55;
      }
    }
    label55:
    for (int k = 25;; k = 10)
    {
      if (!this.g.equals("top")) {
        break label61;
      }
      return j.a(paramInt + k);
      if (paramInt == 1)
      {
        paramInt = 48;
        break;
      }
      paramInt = 40;
      break;
    }
    label61:
    if (this.g.equals("bottom-toolbar")) {
      return j.a(paramInt + k);
    }
    return j.a(k);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public ArrayList d()
  {
    return this.f;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    if (j.c()) {
      return this.i;
    }
    return this.j;
  }
  
  public int i()
  {
    int k = 80;
    if (this.g.equals("top")) {
      k = 48;
    }
    while (!this.g.startsWith("bottom")) {
      return k;
    }
    return 80;
  }
  
  public String toString()
  {
    if (this.f != null) {}
    for (int k = this.f.size();; k = 0) {
      return "GSFConfiguation [packageName=" + this.a + ", title=" + this.c + ", stepList=" + k + ", position=" + this.g + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.g);
    if (this.h)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.j) {
        break label141;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.i) {
        break label146;
      }
    }
    label141:
    label146:
    for (paramInt = k;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.e);
      if (this.f == null) {
        return;
      }
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((GSFDemoStep)localIterator.next(), 0);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/GSFConfiguation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */