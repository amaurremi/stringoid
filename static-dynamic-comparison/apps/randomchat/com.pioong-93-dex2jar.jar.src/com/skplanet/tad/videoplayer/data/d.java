package com.skplanet.tad.videoplayer.data;

public class d
{
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public int e = 0;
  public String f = "";
  public String g = "";
  public int h = 0;
  
  public d() {}
  
  public d(String paramString)
  {
    this.b = paramString;
  }
  
  public d(String paramString, int paramInt)
  {
    this.b = paramString;
    this.h = paramInt;
  }
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.f = paramString2;
    this.g = paramString3;
  }
  
  public String a()
  {
    if (h() == null) {
      return null;
    }
    return f() + "|" + g() + "|" + h() + "|" + i();
  }
  
  public String b()
  {
    return f() + "|" + l();
  }
  
  public String c()
  {
    return f() + "|" + j() + "|" + k();
  }
  
  public String d()
  {
    return f();
  }
  
  public String e()
  {
    return f() + "|" + m();
  }
  
  public String f()
  {
    return "Log_Type=" + this.b;
  }
  
  public String g()
  {
    return "Play_State=" + this.c;
  }
  
  public String h()
  {
    return "Play_Start_Time=" + this.d;
  }
  
  public String i()
  {
    return "Play_Duration=" + this.e;
  }
  
  public String j()
  {
    return "Section_Start=" + this.f;
  }
  
  public String k()
  {
    return "Section_Stop=" + this.g;
  }
  
  public String l()
  {
    return "Menu_ID=" + this.h;
  }
  
  public String m()
  {
    return "Fail_Code=" + this.h;
  }
  
  public String toString()
  {
    return "StatsData [multiType=" + this.a + ", logType=" + this.b + ", play_state=" + this.c + ", play_startTime=" + this.d + ", section_start=" + this.f + ", section_stop=" + this.g + ", play_duration=" + this.e + ", menu_id=" + this.h + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */