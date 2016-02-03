package com.google.android.gms.tagmanager;

import java.util.Collections;
import java.util.List;

public class cq$e
{
  private final List<cq.a> ahc;
  private final List<cq.a> ahd;
  private final List<cq.a> ahe;
  private final List<cq.a> ahf;
  private final List<cq.a> ahg;
  private final List<cq.a> ahh;
  private final List<String> ahi;
  private final List<String> ahj;
  private final List<String> ahk;
  private final List<String> ahl;
  
  private cq$e(List<cq.a> paramList1, List<cq.a> paramList2, List<cq.a> paramList3, List<cq.a> paramList4, List<cq.a> paramList5, List<cq.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
  {
    this.ahc = Collections.unmodifiableList(paramList1);
    this.ahd = Collections.unmodifiableList(paramList2);
    this.ahe = Collections.unmodifiableList(paramList3);
    this.ahf = Collections.unmodifiableList(paramList4);
    this.ahg = Collections.unmodifiableList(paramList5);
    this.ahh = Collections.unmodifiableList(paramList6);
    this.ahi = Collections.unmodifiableList(paramList7);
    this.ahj = Collections.unmodifiableList(paramList8);
    this.ahk = Collections.unmodifiableList(paramList9);
    this.ahl = Collections.unmodifiableList(paramList10);
  }
  
  public static cq.f mv()
  {
    return new cq.f(null);
  }
  
  public List<cq.a> mA()
  {
    return this.ahg;
  }
  
  public List<String> mB()
  {
    return this.ahi;
  }
  
  public List<String> mC()
  {
    return this.ahj;
  }
  
  public List<String> mD()
  {
    return this.ahk;
  }
  
  public List<String> mE()
  {
    return this.ahl;
  }
  
  public List<cq.a> mF()
  {
    return this.ahh;
  }
  
  public List<cq.a> mw()
  {
    return this.ahc;
  }
  
  public List<cq.a> mx()
  {
    return this.ahd;
  }
  
  public List<cq.a> my()
  {
    return this.ahe;
  }
  
  public List<cq.a> mz()
  {
    return this.ahf;
  }
  
  public String toString()
  {
    return "Positive predicates: " + mw() + "  Negative predicates: " + mx() + "  Add tags: " + my() + "  Remove tags: " + mz() + "  Add macros: " + mA() + "  Remove macros: " + mF();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */