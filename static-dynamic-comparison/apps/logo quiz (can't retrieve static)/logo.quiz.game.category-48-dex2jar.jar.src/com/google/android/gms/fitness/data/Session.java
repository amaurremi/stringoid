package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.FitnessActivities;

public class Session
  implements SafeParcelable
{
  public static final Parcelable.Creator<Session> CREATOR = new p();
  private final int BR;
  private final long KL;
  private final a SJ;
  private final long Si;
  private final int Sv;
  private final String Tf;
  private final String Tg;
  private final String mName;
  
  Session(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, a parama)
  {
    this.BR = paramInt1;
    this.KL = paramLong1;
    this.Si = paramLong2;
    this.mName = paramString1;
    this.Tf = paramString2;
    this.Tg = paramString3;
    this.Sv = paramInt2;
    this.SJ = parama;
  }
  
  private Session(Builder paramBuilder)
  {
    this.BR = 2;
    this.KL = Builder.a(paramBuilder);
    this.Si = Builder.b(paramBuilder);
    this.mName = Builder.c(paramBuilder);
    this.Tf = Builder.d(paramBuilder);
    this.Tg = Builder.e(paramBuilder);
    this.Sv = Builder.f(paramBuilder);
    this.SJ = Builder.g(paramBuilder);
  }
  
  private boolean a(Session paramSession)
  {
    return (this.KL == paramSession.KL) && (this.Si == paramSession.Si) && (m.equal(this.mName, paramSession.mName)) && (m.equal(this.Tf, paramSession.Tf)) && (m.equal(this.Tg, paramSession.Tg)) && (m.equal(this.SJ, paramSession.SJ)) && (this.Sv == paramSession.Sv);
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)c.a(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Session)) && (a((Session)paramObject)));
  }
  
  public int getActivity()
  {
    return this.Sv;
  }
  
  public String getAppPackageName()
  {
    if (this.SJ == null) {
      return null;
    }
    return this.SJ.getPackageName();
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public long getEndTimeMillis()
  {
    return this.Si;
  }
  
  public String getIdentifier()
  {
    return this.Tf;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getStartTimeMillis()
  {
    return this.KL;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Long.valueOf(this.KL), Long.valueOf(this.Si), this.mName, this.Tf, Integer.valueOf(this.Sv), this.SJ, this.Tg });
  }
  
  public a iH()
  {
    return this.SJ;
  }
  
  public boolean isOngoing()
  {
    return this.Si == 0L;
  }
  
  public String toString()
  {
    return m.h(this).a("startTime", Long.valueOf(this.KL)).a("endTime", Long.valueOf(this.Si)).a("name", this.mName).a("identifier", this.Tf).a("description", this.Tg).a("activity", Integer.valueOf(this.Sv)).a("application", this.SJ).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long KL = 0L;
    private a SJ;
    private long Si = 0L;
    private int Sv = 4;
    private String Tf;
    private String Tg;
    private String mName = null;
    
    public Session build()
    {
      boolean bool2 = false;
      boolean bool1;
      StringBuilder localStringBuilder;
      if (this.KL > 0L)
      {
        bool1 = true;
        n.a(bool1, "Start time should be specified.");
        if (this.Si != 0L)
        {
          bool1 = bool2;
          if (this.Si <= this.KL) {}
        }
        else
        {
          bool1 = true;
        }
        n.a(bool1, "End time should be later than start time.");
        if (this.Tf == null)
        {
          localStringBuilder = new StringBuilder();
          if (this.mName != null) {
            break label111;
          }
        }
      }
      label111:
      for (String str = "";; str = this.mName)
      {
        this.Tf = (str + this.KL);
        return new Session(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setActivity(int paramInt)
    {
      this.Sv = FitnessActivities.cw(paramInt);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      if (paramString.length() <= 1000) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Session description cannot exceed %d characters", new Object[] { Integer.valueOf(1000) });
        this.Tg = paramString;
        return this;
      }
    }
    
    public Builder setEndTimeMillis(long paramLong)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "End time should be positive.");
        this.Si = paramLong;
        return this;
      }
    }
    
    public Builder setIdentifier(String paramString)
    {
      this.Tf = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      if (paramString.length() <= 100) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Session name cannot exceed %d characters", new Object[] { Integer.valueOf(100) });
        this.mName = paramString;
        return this;
      }
    }
    
    public Builder setStartTimeMillis(long paramLong)
    {
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Start time should be positive.");
        this.KL = paramLong;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */