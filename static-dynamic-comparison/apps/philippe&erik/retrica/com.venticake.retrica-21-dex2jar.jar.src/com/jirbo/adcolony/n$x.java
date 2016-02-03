package com.jirbo.adcolony;

import java.util.ArrayList;

class n$x
{
  boolean a;
  boolean b;
  int c;
  int d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  double m;
  n.g n;
  n.g o;
  
  boolean a()
  {
    if (!this.a) {}
    do
    {
      return true;
      if (!a.l.c.a(this.e)) {
        return false;
      }
      if (!this.n.a()) {
        return false;
      }
      if (!this.o.a()) {
        return false;
      }
      if ((a.l.b.j.i.equals("online")) && (!q.c()))
      {
        a.Y = 9;
        return l.c.b("Video not ready due to VIEW_FILTER_ONLINE");
      }
      if ((a.l.b.j.i.equals("wifi")) && (!q.a()))
      {
        a.Y = 9;
        return l.c.b("Video not ready due to VIEW_FILTER_WIFI");
      }
      if ((a.l.b.j.i.equals("cell")) && (!q.b()))
      {
        a.Y = 9;
        return l.c.b("Video not ready due to VIEW_FILTER_CELL");
      }
    } while ((!a.l.b.j.i.equals("offline")) || (!q.c()));
    a.Y = 9;
    return l.c.b("Video not ready due to VIEW_FILTER_OFFLINE");
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        return false;
        this.a = paramg.h("enabled");
        if (!this.a) {
          return true;
        }
        this.c = paramg.g("width");
        this.d = paramg.g("height");
        this.e = paramg.e("url");
        a.V.add(this.e);
        this.g = paramg.e("last_modified");
        this.h = paramg.e("video_frame_rate");
        this.i = paramg.e("audio_channels");
        this.j = paramg.e("audio_codec");
        this.k = paramg.e("audio_sample_rate");
        this.l = paramg.e("video_codec");
        this.m = paramg.f("duration");
        this.n = new n.g();
      } while (!this.n.a(paramg.b("skip_video")));
      this.o = new n.g();
    } while (!this.o.a(paramg.b("in_video_engagement")));
    return true;
  }
  
  String b()
  {
    return a.l.c.b(this.e);
  }
  
  void c()
  {
    a.l.c.a(this.e, this.g);
    this.o.b();
    this.n.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */