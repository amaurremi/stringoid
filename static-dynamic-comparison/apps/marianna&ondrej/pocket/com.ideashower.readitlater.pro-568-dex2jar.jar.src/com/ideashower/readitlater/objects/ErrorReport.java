package com.ideashower.readitlater.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.a.g;
import org.apache.a.c.h;

public class ErrorReport
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public ErrorReport a(Parcel paramAnonymousParcel)
    {
      return new ErrorReport(paramAnonymousParcel);
    }
    
    public ErrorReport[] a(int paramAnonymousInt)
    {
      return new ErrorReport[paramAnonymousInt];
    }
  };
  public static int a = 5;
  private final String b;
  private final int c;
  private final String d;
  private String e;
  private String f;
  private String g;
  
  public ErrorReport(int paramInt, String paramString)
  {
    this.e = paramString;
    this.b = g();
    this.c = paramInt;
    this.d = null;
  }
  
  public ErrorReport(int paramInt, String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.b = g();
    this.c = paramInt;
    this.d = null;
  }
  
  public ErrorReport(Parcel paramParcel)
  {
    String[] arrayOfString = new String[6];
    paramParcel.readStringArray(arrayOfString);
    this.b = arrayOfString[0];
    this.e = arrayOfString[1];
    this.f = arrayOfString[2];
    this.c = Integer.valueOf(arrayOfString[3]).intValue();
    this.d = arrayOfString[4];
    this.g = arrayOfString[5];
  }
  
  public ErrorReport(Throwable paramThrowable, int paramInt)
  {
    this(paramThrowable, paramInt, null);
  }
  
  public ErrorReport(Throwable paramThrowable, int paramInt, String paramString)
  {
    this.b = g();
    this.e = paramString;
    if (paramThrowable != null)
    {
      this.f = "";
      String str = paramThrowable.getClass().getName();
      paramString = str;
      if (str == null) {
        paramString = paramThrowable.toString();
      }
      this.f = (this.f + paramString + " ");
      if (paramThrowable.getMessage() != null) {
        this.f += paramThrowable.getMessage();
      }
    }
    for (this.d = org.apache.a.c.c.a.a(paramThrowable);; this.d = null)
    {
      this.c = paramInt;
      return;
    }
  }
  
  private String g()
  {
    com.ideashower.readitlater.activity.a locala = g.n();
    if (locala != null) {
      return locala.getClass().getSimpleName().replace("Activity", "");
    }
    return "";
  }
  
  public String a()
  {
    if (this.f == null) {
      return "";
    }
    return this.f;
  }
  
  public String a(String paramString)
  {
    if (this.e == null) {
      return paramString;
    }
    return h.a(this.e);
  }
  
  public String b()
  {
    return a("");
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean c()
  {
    return this.e != null;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(new String[] { this.b, this.e, this.f, String.valueOf(this.c), this.d, this.g });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/ErrorReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */