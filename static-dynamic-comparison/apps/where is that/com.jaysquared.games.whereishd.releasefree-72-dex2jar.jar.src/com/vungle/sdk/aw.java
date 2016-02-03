package com.vungle.sdk;

import android.os.Build.VERSION;
import org.json.JSONException;
import org.json.JSONObject;

final class aw
{
  public static int a(String paramString)
  {
    int i = e.l;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        if (ba.b(paramString)) {
          break label718;
        }
        localJSONObject = new JSONObject(paramString);
        new StringBuilder("responseJSON : ").append(localJSONObject.toString(3));
        if (!localJSONObject.isNull(e.R))
        {
          ak.a(localJSONObject.getInt(e.R) * e.s);
          return e.l;
        }
        if ((!localJSONObject.isNull(e.K)) && (!localJSONObject.isNull(e.F)) && (!localJSONObject.isNull(e.J)))
        {
          i = 1;
          if (i == 0) {
            break label707;
          }
          aj localaj = aj.e();
          if (localaj != null) {
            localaj.a(paramString);
          }
          paramString = new a();
          paramString.k = localJSONObject.getInt(e.O);
          paramString.l = localJSONObject.getInt(e.P);
          paramString.j = localJSONObject.getString(e.H);
          paramString.e = localJSONObject.getString(e.G);
          paramString.c = localJSONObject.getString(e.M);
          if (!localJSONObject.isNull(e.N)) {
            paramString.d = localJSONObject.getString(e.N);
          }
          paramString.g = localJSONObject.getString(e.I).replace('|', '_');
          if (localJSONObject.isNull(e.J)) {
            break label613;
          }
          paramString.b(localJSONObject.getString(e.J));
          if (localJSONObject.isNull(e.E)) {
            break label623;
          }
          paramString.a = localJSONObject.getString(e.E);
          if (localJSONObject.isNull(e.F)) {
            break label631;
          }
          paramString.a(localJSONObject.getString(e.F));
          if (localJSONObject.isNull(e.K)) {
            break label641;
          }
          paramString.c(localJSONObject.getString(e.K));
          if (!localJSONObject.isNull(e.U)) {
            paramString.m = localJSONObject.getLong(e.U);
          }
          if (!localJSONObject.isNull(e.S)) {
            paramString.p = localJSONObject.getInt(e.S);
          }
          if (!localJSONObject.isNull(e.T)) {
            paramString.o = localJSONObject.getInt(e.T);
          }
          if (!localJSONObject.isNull(e.Q)) {
            paramString.f = localJSONObject.getString(e.Q);
          }
          if (!localJSONObject.isNull(e.L)) {
            paramString.n = Long.parseLong(localJSONObject.getString(e.L));
          }
          if (localJSONObject.isNull(e.W)) {
            break label651;
          }
          paramString.a(localJSONObject.getInt(e.W));
          if (localJSONObject.isNull(e.V)) {
            break label661;
          }
          paramString.a(localJSONObject.getInt(e.V) * e.s);
          if (localJSONObject.isNull(e.ad)) {
            break label672;
          }
          i = localJSONObject.getInt(e.ad);
          paramString.q = i;
          e.a(i);
          if (Build.VERSION.SDK_INT < 9) {
            break label720;
          }
          i = 1;
          label497:
          if ((i == 0) || (!ak.r)) {
            break label682;
          }
          i = 10;
          ak.C = i;
          label514:
          int j = e.k;
          i = j;
          if (ay.a() == null) {
            break label718;
          }
          ay.a().e = paramString;
          return j;
        }
      }
      catch (JSONException paramString)
      {
        av.a(e.u, "JSONException", paramString);
        i = e.l;
        ay.a().e = null;
        return i;
      }
      if ((!localJSONObject.isNull(e.F)) && (!localJSONObject.isNull(e.J)))
      {
        i = 1;
      }
      else if (!localJSONObject.isNull(e.K))
      {
        i = 1;
      }
      else
      {
        if (!localJSONObject.isNull(e.J))
        {
          i = 1;
          continue;
          label613:
          paramString.b(e.B);
          continue;
          label623:
          paramString.a = null;
          continue;
          label631:
          paramString.a(e.B);
          continue;
          label641:
          paramString.c(e.B);
          continue;
          label651:
          paramString.a(e.f);
          continue;
          label661:
          paramString.a(e.g);
          continue;
          label672:
          paramString.q = e.ae;
          continue;
          label682:
          if (paramString.p <= paramString.o) {
            break label730;
          }
          if (i == 0) {
            break label725;
          }
        }
        label707:
        label718:
        label720:
        label725:
        for (i = 7;; i = 1)
        {
          ak.C = i;
          break label514;
          i = e.l;
          return i;
          i = 0;
          break;
          return i;
          i = 0;
          break label497;
        }
        label730:
        if (i != 0) {
          i = 6;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */