package com.gau.go.gostaticsdk.a;

import android.content.ContentValues;
import android.database.Cursor;

public class a
{
  public int a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f = 0;
  public int g = 0;
  public String h;
  public int i;
  public String j;
  public String k;
  public int l;
  public String m;
  public String n;
  public int o;
  public String p;
  public int q = 3;
  public String r;
  public boolean s;
  public boolean t = false;
  public String u = "-1";
  private boolean v = false;
  
  public void a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      this.a = paramCursor.getInt(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.b));
      this.b = paramCursor.getLong(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.c));
      this.c = paramCursor.getString(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.d));
      this.h = paramCursor.getString(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.g));
      this.p = paramCursor.getString(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.o));
      this.q = paramCursor.getInt(paramCursor.getColumnIndex(com.gau.go.gostaticsdk.c.a.p));
      this.v = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean a()
  {
    return this.v;
  }
  
  public ContentValues b()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(com.gau.go.gostaticsdk.c.a.b, Integer.valueOf(this.a));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.c, Long.valueOf(this.b));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.d, this.c);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.e, Boolean.valueOf(false));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.f, this.e);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.g, this.h);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.l, this.m);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.h, Integer.valueOf(this.i));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.j, this.k);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.n, Integer.valueOf(this.o));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.i, this.j);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.m, this.n);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.k, Integer.valueOf(this.l));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.o, this.p);
    localContentValues.put(com.gau.go.gostaticsdk.c.a.p, Integer.valueOf(this.q));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.q, Boolean.valueOf(this.s));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.r, Boolean.valueOf(this.t));
    localContentValues.put(com.gau.go.gostaticsdk.c.a.s, this.u);
    return localContentValues;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */