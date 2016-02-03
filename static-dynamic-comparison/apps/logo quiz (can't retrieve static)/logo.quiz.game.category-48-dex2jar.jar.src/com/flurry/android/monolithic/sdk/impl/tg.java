package com.flurry.android.monolithic.sdk.impl;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

class tg
{
  final HashMap<adb, qu<Object>> a = new HashMap();
  
  private tg()
  {
    a(new xc());
    Object localObject = new wy();
    a((vo)localObject, String.class);
    a((vo)localObject, CharSequence.class);
    a(new ue());
    a(new vs(Boolean.class, null));
    a(new vt(Byte.class, null));
    a(new wb(Short.class, null));
    a(new vu(Character.class, null));
    a(new vx(Integer.class, null));
    a(new vy(Long.class, null));
    a(new vw(Float.class, null));
    a(new vv(Double.class, null));
    a(new vs(Boolean.TYPE, Boolean.FALSE));
    a(new vt(Byte.TYPE, Byte.valueOf((byte)0)));
    a(new wb(Short.TYPE, Short.valueOf((short)0)));
    a(new vu(Character.TYPE, Character.valueOf('\000')));
    a(new vx(Integer.TYPE, Integer.valueOf(0)));
    a(new vy(Long.TYPE, Long.valueOf(0L)));
    a(new vw(Float.TYPE, Float.valueOf(0.0F)));
    a(new vv(Double.TYPE, Double.valueOf(0.0D)));
    a(new vz());
    a(new vq());
    a(new vr());
    a(new ud());
    a(new uh());
    a(new ud(GregorianCalendar.class), GregorianCalendar.class);
    a(new wc());
    a(new xa());
    localObject = um.d().iterator();
    while (((Iterator)localObject).hasNext()) {
      a((um)((Iterator)localObject).next());
    }
    a(new wd());
    a(new tz());
    a(new xb());
    a(new uw());
  }
  
  public static HashMap<adb, qu<Object>> a()
  {
    return new tg().a;
  }
  
  private void a(vo<?> paramvo)
  {
    a(paramvo, paramvo.f());
  }
  
  private void a(vo<?> paramvo, Class<?> paramClass)
  {
    this.a.put(new adb(paramClass), paramvo);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */