package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nl
  implements SafeParcelable
{
  public static final nm CREATOR = new nm();
  public final int akG;
  public final int akH;
  public final String akI;
  public final String akJ;
  public final boolean akK;
  public final String packageName;
  public final int versionCode;
  
  public nl(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.packageName = paramString1;
    this.akG = paramInt2;
    this.akH = paramInt3;
    this.akI = paramString2;
    this.akJ = paramString3;
    this.akK = paramBoolean;
  }
  
  public nl(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = 1;
    this.packageName = ((String)n.i(paramString1));
    this.akG = paramInt1;
    this.akH = paramInt2;
    this.akI = paramString2;
    this.akJ = paramString3;
    this.akK = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof nl)) {
        break;
      }
      paramObject = (nl)paramObject;
    } while ((this.packageName.equals(((nl)paramObject).packageName)) && (this.akG == ((nl)paramObject).akG) && (this.akH == ((nl)paramObject).akH) && (m.equal(this.akI, ((nl)paramObject).akI)) && (m.equal(this.akJ, ((nl)paramObject).akJ)) && (this.akK == ((nl)paramObject).akK));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.packageName, Integer.valueOf(this.akG), Integer.valueOf(this.akH), this.akI, this.akJ, Boolean.valueOf(this.akK) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("versionCode=").append(this.versionCode).append(',');
    localStringBuilder.append("logSource=").append(this.akH).append(',');
    localStringBuilder.append("uploadAccount=").append(this.akI).append(',');
    localStringBuilder.append("loggingId=").append(this.akJ).append(',');
    localStringBuilder.append("logAndroidId=").append(this.akK);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nm.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */