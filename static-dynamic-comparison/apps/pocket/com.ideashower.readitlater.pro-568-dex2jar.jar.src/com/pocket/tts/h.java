package com.pocket.tts;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.db.operation.action.af;
import com.ideashower.readitlater.e.v;
import com.ideashower.readitlater.h.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

@SuppressLint({"InlinedApi"})
public class h
  extends Binder
  implements TextToSpeech.OnUtteranceCompletedListener, c
{
  private static h a;
  private j A;
  private boolean B = true;
  private final TTSPlayerService b;
  private AudioManager c;
  private ComponentName d;
  private com.pocket.l.a e;
  private final ArrayList f = new ArrayList();
  private final ArrayList g = new ArrayList();
  private final float h;
  private final String i;
  private TextToSpeech j;
  private boolean k;
  private boolean l;
  private String m;
  private boolean n;
  private boolean o;
  private boolean p;
  private b q;
  private int r;
  private Locale s;
  private float t;
  private float u;
  private Runnable v;
  private boolean w;
  private BroadcastReceiver x;
  private boolean y;
  private com.pocket.l.a.e z;
  
  private h(TTSPlayerService paramTTSPlayerService)
  {
    this.b = paramTTSPlayerService;
    this.h = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.as);
    this.i = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.at);
  }
  
  private boolean A()
  {
    return this.k;
  }
  
  private void B()
  {
    if (this.r > 0) {}
    for (float f1 = this.q.a(this.r - 1).e / this.q.e(); f1 == this.u; f1 = 0.0F) {
      return;
    }
    this.u = f1;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).b(f1);
    }
    C();
  }
  
  private void C()
  {
    int i1 = this.q.a(this.r).e;
    this.z.a(i1 / this.q.e());
  }
  
  private void D()
  {
    if (this.s != null) {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.as, this.t).a(com.ideashower.readitlater.h.a.at, this.s.toString()).a();
    }
  }
  
  private int E()
  {
    int i1;
    if ((!A()) || (!i()))
    {
      i1 = 0;
      return i1;
    }
    int i2 = this.r;
    for (;;)
    {
      if (i2 < 0) {
        break label52;
      }
      int i3 = this.q.a(i2).c;
      i1 = i3;
      if (i3 != 0) {
        break;
      }
      i2 -= 1;
    }
    label52:
    return 0;
  }
  
  private j F()
  {
    if (this.A == null) {
      this.A = new j(this);
    }
    return this.A;
  }
  
  public static h a(TTSPlayerService paramTTSPlayerService)
  {
    if (a == null) {
      a = new h(paramTTSPlayerService);
    }
    return a;
  }
  
  public static j a(TTSMediaButtonReceiver paramTTSMediaButtonReceiver)
  {
    if ((paramTTSMediaButtonReceiver != null) && (a != null)) {
      return a.F();
    }
    return null;
  }
  
  public static void a(Context paramContext, i parami)
  {
    i.a(parami, true);
    paramContext.bindService(new Intent(paramContext, TTSPlayerService.class), parami, 1);
  }
  
  private void a(d paramd)
  {
    b(true);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramd);
    }
  }
  
  private void a(i parami)
  {
    this.f.add(parami);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.y == paramBoolean) {
      return;
    }
    if (com.ideashower.readitlater.util.a.b())
    {
      if (paramBoolean) {
        this.c.registerMediaButtonEventReceiver(this.d);
      }
      for (;;)
      {
        this.y = paramBoolean;
        return;
        this.c.unregisterMediaButtonEventReceiver(this.d);
      }
    }
    this.y = false;
  }
  
  public static boolean a()
  {
    if (a != null) {
      return a.o;
    }
    return false;
  }
  
  public static String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a != null)
    {
      localObject1 = localObject2;
      if (a.q != null) {
        localObject1 = a.q.c();
      }
    }
    return (String)localObject1;
  }
  
  public static void b(Context paramContext, i parami)
  {
    parami.b = true;
    paramContext.unbindService(parami);
  }
  
  private void b(i parami)
  {
    this.f.remove(parami);
    if (this.f.isEmpty()) {}
  }
  
  private void b(boolean paramBoolean)
  {
    int i1;
    Object localObject;
    if (this.o != paramBoolean)
    {
      i1 = 1;
      if (i1 != 0) {
        this.o = paramBoolean;
      }
      if ((i1 == 0) || (this.w)) {
        return;
      }
      if (!this.w)
      {
        localObject = this.z;
        if (!paramBoolean) {
          break label98;
        }
        i1 = 3;
        label48:
        ((com.pocket.l.a.e)localObject).a(i1);
      }
      localObject = this.f.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      i locali = (i)((Iterator)localObject).next();
      if (paramBoolean)
      {
        locali.c();
        continue;
        i1 = 0;
        break;
        label98:
        i1 = 2;
        break label48;
      }
      locali.b();
    }
  }
  
  public static String c()
  {
    if (a != null) {
      return a.m;
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramInt);
    }
  }
  
  private void d(int paramInt)
  {
    if (this.q == null) {
      if (this.m != null)
      {
        this.r = paramInt;
        this.n = true;
      }
    }
    ArrayList localArrayList;
    int i1;
    do
    {
      return;
      throw new RuntimeException("No article is loaded");
      this.e.a();
      this.n = false;
      this.r = paramInt;
      this.j.speak("", 0, null);
      localArrayList = this.q.a();
      i1 = localArrayList.size();
    } while (i1 == 0);
    this.r = paramInt;
    a((d)localArrayList.get(paramInt));
    if (paramInt < i1)
    {
      d locald = (d)localArrayList.get(paramInt);
      if (locald.d) {
        this.j.playSilence(444L, 1, null);
      }
      this.j.speak(locald.a, 1, locald.h);
      TextToSpeech localTextToSpeech = this.j;
      if (locald.d) {}
      for (long l1 = 555L;; l1 = 333L)
      {
        localTextToSpeech.playSilence(l1, 1, null);
        paramInt += 1;
        break;
      }
    }
    B();
  }
  
  public static ag r()
  {
    new ag()
    {
      public void a()
      {
        if (h.s() != null) {
          h.l(h.s());
        }
      }
      
      public void b() {}
      
      public void c() {}
    };
  }
  
  @SuppressLint({"NewApi"})
  private void t()
  {
    boolean bool2 = true;
    if ((this.l) || (this.k)) {}
    for (;;)
    {
      return;
      if (!as.l())
      {
        c(-4);
        return;
      }
      final Object localObject = new Intent();
      ((Intent)localObject).setAction("android.speech.tts.engine.CHECK_TTS_DATA");
      if (com.pocket.p.o.a(this.b, (Intent)localObject))
      {
        this.l = true;
        localObject = p.a().c();
        final boolean bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 14) {
          if (localObject != null) {
            break label119;
          }
        }
        TextToSpeech.OnInitListener local1;
        label119:
        for (bool1 = bool2;; bool1 = false)
        {
          local1 = new TextToSpeech.OnInitListener()
          {
            public void onInit(int paramAnonymousInt)
            {
              h.a(h.this, false);
              if (paramAnonymousInt == 0)
              {
                h.a(h.this);
                if (!h.b(h.this).isEmpty())
                {
                  h.c(h.this);
                  if ((bool1) && (localObject != null)) {
                    h.d(h.this).setEngineByPackageName(localObject.a);
                  }
                  h.e(h.this);
                  return;
                }
                h.a(h.this, -3);
                return;
              }
              h.a(h.this, -2);
            }
          };
          if (!bool1) {
            break;
          }
          this.j = new TextToSpeech(this.b, local1);
          return;
        }
        this.j = new TextToSpeech(this.b, local1, ((o)localObject).a);
        return;
      }
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).a(-1);
      }
    }
  }
  
  private void u()
  {
    this.c = ((AudioManager)this.b.getSystemService("audio"));
    this.e = new com.pocket.l.a(this.c, new com.pocket.l.b()
    {
      public void a() {}
      
      public void a(boolean paramAnonymousBoolean)
      {
        if (!h.f(h.this)) {}
        while (paramAnonymousBoolean) {
          return;
        }
        h.this.h();
      }
    });
    this.d = new ComponentName(this.b, TTSMediaButtonReceiver.class);
    a(true);
    this.z = new com.pocket.l.a.e();
    this.z.a(new k(this.b));
    if (com.ideashower.readitlater.util.a.i())
    {
      Object localObject = new Intent("android.intent.action.MEDIA_BUTTON");
      ((Intent)localObject).setComponent(this.d);
      localObject = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject, 0);
      localObject = new com.pocket.l.a.c(this.c, (PendingIntent)localObject);
      this.z.a((com.pocket.l.a.a)localObject);
    }
    this.z.b(181);
    this.z.c();
  }
  
  private void v()
  {
    if (this.z != null) {
      this.z.d();
    }
    a(false);
    if (this.e != null) {
      this.e.b();
    }
  }
  
  private void w()
  {
    this.k = true;
    this.j.setOnUtteranceCompletedListener(this);
    y();
    this.x = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (!"android.speech.tts.engine.TTS_DATA_INSTALLED".equals(paramAnonymousIntent.getAction())) {
          return;
        }
        h.a(h.this);
      }
    };
    this.b.registerReceiver(this.x, new IntentFilter("android.speech.tts.engine.TTS_DATA_INSTALLED"));
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(this);
    }
  }
  
  private void x()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      locali.c(-5);
      if (!locali.b) {
        throw new RuntimeException("TTS connection did not disconnect as requested. " + locali.toString());
      }
    }
    d();
  }
  
  private void y()
  {
    Object localObject;
    if (this.j.areDefaultsEnforced())
    {
      localObject = f.a(this.j.getLanguage(), this.g);
      this.s = ((Locale)localObject);
      this.j.setLanguage((Locale)localObject);
      this.t = this.h;
      this.j.setSpeechRate(this.t);
      return;
    }
    if (this.i == null)
    {
      localObject = Locale.getDefault();
      if ((!((Locale)localObject).getLanguage().equals(Locale.ENGLISH.getLanguage())) || (!((Locale)localObject).getCountry().equals(Locale.US.getCountry()))) {
        break label202;
      }
      localObject = new Locale(((Locale)localObject).getLanguage(), Locale.UK.getCountry(), ((Locale)localObject).getVariant());
    }
    label202:
    for (;;)
    {
      Locale localLocale = f.a((Locale)localObject, this.g);
      localObject = localLocale;
      if (localLocale != null) {
        break;
      }
      localObject = this.f.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((i)((Iterator)localObject).next()).a();
          continue;
          localObject = new Locale(this.i);
          break;
        }
      }
      localObject = (Locale)this.g.get(0);
      break;
    }
  }
  
  private void z()
  {
    Object localObject = e.a(this.j);
    if (!((ArrayList)localObject).equals(this.g))
    {
      this.g.clear();
      this.g.addAll((Collection)localObject);
      if (this.k)
      {
        localObject = this.f.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).a(this.g);
        }
      }
    }
  }
  
  public void a(float paramFloat)
  {
    boolean bool = a();
    this.w = true;
    h();
    this.t = paramFloat;
    this.j.setSpeechRate(paramFloat);
    if (bool) {
      f();
    }
    this.w = false;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 0;; paramInt = this.q.b(paramInt).g)
    {
      d(paramInt);
      return;
    }
  }
  
  public void a(String paramString)
  {
    e();
    this.B = false;
    this.m = paramString;
    this.z.a(8);
    new a(paramString, this).a();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((!org.apache.a.c.k.a(this.m, paramString)) || (!this.k)) {}
    for (;;)
    {
      return;
      this.m = null;
      this.z.a(9);
      paramString = this.f.iterator();
      while (paramString.hasNext()) {
        ((i)paramString.next()).b(paramInt);
      }
    }
  }
  
  public void a(String paramString, final b paramb)
  {
    if ((!org.apache.a.c.k.a(this.m, paramString)) || (!this.k)) {
      return;
    }
    this.m = null;
    this.q = paramb;
    this.z.a(true).a(com.ideashower.readitlater.util.g.a(paramString)).b(paramb.d()).c(paramb.b()).a();
    com.ideashower.readitlater.db.operation.h.a(paramString, new com.ideashower.readitlater.db.operation.i()
    {
      public void a(com.ideashower.readitlater.e.o paramAnonymouso)
      {
        if ((paramAnonymouso == null) || (paramb != h.i(h.this))) {}
        do
        {
          return;
          paramAnonymouso = paramAnonymouso.X();
        } while (paramAnonymouso == null);
        h.j(h.this).a(false).d(paramAnonymouso.a()).a();
      }
    });
    if (this.n) {
      f();
    }
    for (;;)
    {
      paramb = this.f.iterator();
      while (paramb.hasNext()) {
        ((i)paramb.next()).b(paramString);
      }
      break;
      this.z.a(1);
    }
  }
  
  public void a(Locale paramLocale)
  {
    boolean bool = a();
    this.w = true;
    h();
    this.s = paramLocale;
    this.j.setLanguage(paramLocale);
    if (bool) {
      f();
    }
    this.w = false;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(paramLocale);
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = this.r + paramInt;
    if ((i1 < 0) || (i1 >= this.q.a().size())) {
      return;
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).d(paramInt);
    }
    if (this.o)
    {
      this.w = true;
      h();
      d(i1);
      this.w = false;
      return;
    }
    this.r = i1;
    B();
  }
  
  public void d()
  {
    this.k = false;
    if ((this.x != null) && (this.b != null))
    {
      this.b.unregisterReceiver(this.x);
      this.x = null;
    }
    if (this.j != null)
    {
      e();
      this.j.shutdown();
    }
    v();
    D();
    a = null;
  }
  
  public void e()
  {
    if (this.B) {}
    for (;;)
    {
      return;
      this.B = true;
      h();
      this.q = null;
      this.r = 0;
      this.n = false;
      this.u = 0.0F;
      if (this.z != null) {
        this.z.a(1);
      }
      this.e.b();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d();
      }
    }
  }
  
  public void f()
  {
    d(this.r);
  }
  
  public boolean g()
  {
    if (this.o)
    {
      h();
      return false;
    }
    f();
    return true;
  }
  
  public void h()
  {
    if (!A()) {
      return;
    }
    if (!this.w) {
      q();
    }
    this.p = true;
    this.j.stop();
    b(false);
  }
  
  public boolean i()
  {
    return this.q != null;
  }
  
  public boolean j()
  {
    return this.m != null;
  }
  
  public float k()
  {
    return this.u;
  }
  
  public Locale l()
  {
    return this.s;
  }
  
  public ArrayList m()
  {
    return this.g;
  }
  
  public float n()
  {
    return this.t;
  }
  
  public boolean o()
  {
    return this.j.areDefaultsEnforced();
  }
  
  public void onUtteranceCompleted(String paramString)
  {
    if ((this.p) || (!this.o))
    {
      this.p = false;
      return;
    }
    this.r = Integer.valueOf(paramString).intValue();
    C();
    if (this.v == null) {
      this.v = new Runnable()
      {
        public void run()
        {
          h.k(h.this);
        }
      };
    }
    com.ideashower.readitlater.a.g.o().post(this.v);
    if (this.r == this.q.a().size() - 1)
    {
      b(false);
      this.z.a(1);
      C();
      q();
      return;
    }
    this.r += 1;
    a(this.q.a(this.r));
  }
  
  public d p()
  {
    if (this.q != null) {
      return this.q.a(this.r);
    }
    return null;
  }
  
  public void q()
  {
    if ((!A()) || (!i())) {
      return;
    }
    B();
    final long l1 = System.currentTimeMillis() / 1000L;
    final int i1 = (int)(this.u * 100.0F);
    final int i2 = E();
    com.ideashower.readitlater.db.operation.h.a(this.q.c(), new com.ideashower.readitlater.db.operation.i()
    {
      public void a(com.ideashower.readitlater.e.o paramAnonymouso)
      {
        if (paramAnonymouso == null) {}
        v localv1;
        v localv2;
        do
        {
          return;
          localv1 = new v(1, 0, 0, i2, i1, l1);
          localv2 = paramAnonymouso.d(1);
        } while ((localv2 != null) && (localv2.d() == localv1.d()) && (paramAnonymouso.B() == localv1.e()));
        new af(localv1, paramAnonymouso).j();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */