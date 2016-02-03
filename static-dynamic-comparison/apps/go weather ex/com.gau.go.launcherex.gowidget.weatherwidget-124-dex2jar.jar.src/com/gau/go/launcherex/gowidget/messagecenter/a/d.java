package com.gau.go.launcherex.gowidget.messagecenter.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.util.am;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends b
{
  public boolean A = false;
  public boolean B = false;
  public int C = 4;
  public Bitmap D;
  public ArrayList E;
  public f F;
  public boolean y = false;
  public boolean z = false;
  
  public d() {}
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.l = paramInt2;
    this.d = paramString3;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.F = new f();
      this.F.a(paramJSONObject.optString("ccode"));
      String str = paramJSONObject.optString("stime");
      paramJSONObject = paramJSONObject.optString("etime");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        long l1 = am.a(str + " +0800");
        long l2 = am.a(paramJSONObject + " +0800");
        this.F.a(l1);
        this.F.b(l2);
      }
    }
  }
  
  public void a(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramCursor.getColumnIndex("mesageid");
        int j = paramCursor.getColumnIndex("title");
        int k = paramCursor.getColumnIndex("readed");
        int m = paramCursor.getColumnIndex("isdeleted");
        int n = paramCursor.getColumnIndex("type");
        int i1 = paramCursor.getColumnIndex("viewtype");
        int i2 = paramCursor.getColumnIndex("date");
        int i3 = paramCursor.getColumnIndex("url");
        int i4 = paramCursor.getColumnIndex("stime_start");
        int i5 = paramCursor.getColumnIndex("stime_end");
        int i6 = paramCursor.getColumnIndex("icon");
        int i7 = paramCursor.getColumnIndex("intro");
        int i8 = paramCursor.getColumnIndex("acttype");
        int i9 = paramCursor.getColumnIndex("actvalue");
        int i10 = paramCursor.getColumnIndex("zicon1");
        int i11 = paramCursor.getColumnIndex("zicon2");
        int i12 = paramCursor.getColumnIndex("zpos");
        int i13 = paramCursor.getColumnIndex("ztime");
        int i14 = paramCursor.getColumnIndex("isclosed");
        int i15 = paramCursor.getColumnIndex("filter_pkgs");
        int i16 = paramCursor.getColumnIndex("whitelist");
        int i17 = paramCursor.getColumnIndex("clickclosed");
        int i18 = paramCursor.getColumnIndex("dynamic");
        int i19 = paramCursor.getColumnIndex("iconpos");
        int i20 = paramCursor.getColumnIndex("fullscreenicon");
        int i21 = paramCursor.getColumnIndex("removed");
        int i22 = paramCursor.getColumnIndex("packagename");
        int i23 = paramCursor.getColumnIndex("mapid");
        if ((-1 != i) && (m != -1) && (i1 != -1) && (k != -1) && (n != -1) && (j != -1) && (i2 != -1) && (i3 != -1) && (i4 != -1) && (i5 != -1) && (i6 != -1) && (i7 != -1) && (i8 != -1) && (i9 != -1) && (i10 != -1) && (i11 != -1) && (i12 != -1) && (i14 != -1) && (i15 != -1) && (i16 != -1) && (i17 != -1) && (i18 != -1) && (i19 != -1) && (i20 != -1) && (i21 != -1) && (i22 != -1) && (i23 != -1))
        {
          this.a = paramCursor.getString(i);
          this.y = com.jiubang.b.a.a.a(paramCursor.getInt(k));
          this.z = com.jiubang.b.a.a.a(paramCursor.getInt(m));
          this.c = paramCursor.getInt(n);
          this.d = paramCursor.getString(i2);
          this.l = paramCursor.getInt(i1);
          this.b = paramCursor.getString(j);
          this.e = paramCursor.getString(i3);
          this.f = paramCursor.getString(i4);
          this.g = paramCursor.getString(i5);
          this.h = paramCursor.getString(i6);
          this.i = paramCursor.getString(i7);
          this.j = paramCursor.getInt(i8);
          this.k = paramCursor.getString(i9);
          this.q = paramCursor.getString(i10);
          this.r = paramCursor.getString(i11);
          this.s = paramCursor.getInt(i12);
          this.u = com.jiubang.b.a.a.a(paramCursor.getInt(i14));
          this.m = paramCursor.getString(i15);
          this.n = paramCursor.getString(i16);
          this.A = com.jiubang.b.a.a.a(paramCursor.getInt(i17));
          this.v = paramCursor.getInt(i18);
          this.w = paramCursor.getInt(i19);
          this.x = paramCursor.getString(i20);
          this.B = com.jiubang.b.a.a.a(paramCursor.getInt(i21));
          if (i13 != -1) {
            this.t = paramCursor.getLong(i13);
          }
          this.o = paramCursor.getString(i22);
          this.p = paramCursor.getString(i23);
          return;
        }
      }
      catch (Exception paramCursor)
      {
        paramCursor.printStackTrace();
      }
    }
  }
  
  public void a(d paramd)
  {
    this.y = paramd.y;
    this.z = paramd.z;
    this.A = paramd.u;
    this.B = paramd.B;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      if (this.E == null) {
        this.E = new ArrayList();
      }
      for (;;)
      {
        int j = paramJSONArray.length();
        int i = 0;
        label29:
        if (i < j) {
          try
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            a locala = new a();
            locala.a(localJSONObject.getString("ycode"));
            locala.a(localJSONObject.getInt("yvalue"));
            locala.b(localJSONObject.getString("stime"));
            locala.c(localJSONObject.getString("etime"));
            c.a("MSGCenter", locala.toString());
            this.E.add(locala);
            i += 1;
            break label29;
            this.E.clear();
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (c.a()) {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(this.d))) {}
    while ((!am.a(this.d, "yyyy-MM-dd HH:mm:ss")) || ((this.c != 2) && (this.c != 3) && (this.c != 1) && (this.c != 4) && (this.c != 100) && (this.c != 5))) {
      return true;
    }
    switch (this.c)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (!TextUtils.isEmpty(this.i));
          return true;
          return false;
        } while (!TextUtils.isEmpty(this.e));
        return true;
        if (((TextUtils.isEmpty(this.e)) && (this.j == 0)) || (this.E == null)) {
          break;
        }
      } while (this.E.size() != 0);
      return true;
      return false;
      if ((this.F == null) || (TextUtils.isEmpty(this.F.c())) || (this.F.a() <= 0L)) {
        break;
      }
    } while (this.F.b() > 0L);
    return true;
  }
  
  public boolean b(d paramd)
  {
    if (!paramd.a.equals(this.a)) {}
    while ((!paramd.b.equals(this.b)) || (paramd.c != this.c) || (!paramd.d.equals(this.d)) || (!paramd.e.equals(this.e)) || (!paramd.f.equals(this.f)) || (!paramd.g.equals(this.g)) || (!paramd.h.equals(this.h)) || (!paramd.i.equals(this.i)) || (paramd.j != this.j) || (!paramd.k.equals(this.k)) || (!paramd.q.equals(this.q)) || (!paramd.r.equals(this.r)) || (paramd.s != this.s) || (paramd.t != this.t) || (paramd.u != this.u) || (paramd.v != this.v) || (paramd.w != this.w) || (!paramd.x.equals(this.x)) || (paramd.l != this.l) || (paramd.m.equals(this.m)) || (paramd.n.equals(this.n))) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */