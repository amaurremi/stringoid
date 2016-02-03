package com.ideashower.readitlater.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Toast;
import com.ideashower.readitlater.a.ah;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.ax;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.ab;
import com.ideashower.readitlater.db.operation.action.al;
import com.ideashower.readitlater.db.operation.action.am;
import com.ideashower.readitlater.reader.ReaderChromeClient;
import com.ideashower.readitlater.reader.ReaderToolbarLayout;
import com.ideashower.readitlater.reader.ReaderWebView;
import com.ideashower.readitlater.reader.r;
import com.ideashower.readitlater.views.BaseWebView;
import com.ideashower.readitlater.views.ErrorView;
import com.ideashower.readitlater.views.RainbowBar;
import com.ideashower.readitlater.views.ResizeDetectFrameLayout;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.ac;
import com.ideashower.readitlater.views.ad;
import com.ideashower.readitlater.views.ak;
import com.pocket.webkit.JsInterface;
import com.pocket.widget.ThemedView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.jackson.node.ObjectNode;

@SuppressLint({"SetJavaScriptEnabled", "ValidFragment"})
public class ReaderFragment
  extends f
  implements com.ideashower.readitlater.d.c, com.ideashower.readitlater.f.g, com.ideashower.readitlater.i.d, com.ideashower.readitlater.reader.d, com.ideashower.readitlater.reader.q, com.ideashower.readitlater.views.o, com.pocket.m.a.n
{
  private static final com.pocket.webkit.a aA = new com.pocket.webkit.a("article", "didFreeze");
  private static final com.pocket.webkit.a aB = new com.pocket.webkit.a("article", "requestContentHeight");
  private static final com.pocket.webkit.a aC = new com.pocket.webkit.a("article", "fixLayout");
  private static final Pattern ad = Pattern.compile("(?:vnd.youtube:|(?:(?:https?://)(?:www\\.)?(?:youtu\\.be/|youtube\\.com)(?:/embed/|/v/|/watch\\?v=)?))([\\w-]{10,12})\\b");
  private static WeakReference ae;
  private static final com.pocket.webkit.a at = new com.pocket.webkit.a("article", "scrollStarted");
  private static final com.pocket.webkit.a au = new com.pocket.webkit.a("article", "didRotate");
  private static final com.pocket.webkit.a av = new com.pocket.webkit.a("article", "swipedLeft");
  private static final com.pocket.webkit.a aw = new com.pocket.webkit.a("article", "swipedRight");
  private static final com.pocket.webkit.a ax = new com.pocket.webkit.a("article", "changedFullscreen").a(false);
  private static final com.pocket.webkit.a ay = new com.pocket.webkit.a("article", "changedFullscreen").a(true);
  private static final com.pocket.webkit.a az = new com.pocket.webkit.a("article", "setPageMode").a(false);
  public ReaderWebView Y = null;
  public FrameLayout Z = null;
  private boolean aD;
  private boolean aE;
  private AudioManager aF;
  private long aG = 0L;
  private av aH;
  private com.ideashower.readitlater.reader.e aI;
  private String aJ;
  private View aK;
  private View aL;
  private boolean aM = false;
  private boolean aN;
  private boolean aO;
  private boolean aP;
  private com.ideashower.readitlater.reader.a aQ;
  private boolean aR;
  private boolean aS;
  private boolean aT = true;
  private ReaderFragment.JSInterfaceArticle aU;
  private ReaderFragment.JSInterfaceVideo aV;
  private com.ideashower.readitlater.reader.g aW;
  private int aX;
  private boolean aY;
  private com.ideashower.readitlater.reader.t aZ;
  public com.ideashower.readitlater.reader.e aa = null;
  public boolean ab = false;
  public float ac;
  private com.ideashower.readitlater.reader.n af;
  private ErrorView ag = null;
  private ReaderChromeClient ah;
  private ResizeDetectFrameLayout ai;
  private final ArrayList aj = new ArrayList();
  private boolean ak;
  private String[] al;
  private String[] am;
  private com.ideashower.readitlater.reader.f an;
  private boolean ao = false;
  private final AtomicInteger ap = new AtomicInteger(0);
  private final AtomicInteger aq = new AtomicInteger(0);
  private final SparseIntArray ar = new SparseIntArray();
  private boolean as = false;
  private com.ideashower.readitlater.reader.w ba;
  private ap bb;
  private RainbowBar bc;
  private boolean bd;
  private int be;
  private ResizeDetectRelativeLayout bf;
  private boolean bg;
  
  private com.ideashower.readitlater.e.o a(String paramString, com.ideashower.readitlater.e.o paramo, UiTrigger paramUiTrigger)
  {
    paramUiTrigger = b(paramUiTrigger);
    int i;
    if (paramo == null)
    {
      paramString = new com.ideashower.readitlater.db.operation.action.d(false, paramString, this.Y.getTitle(), paramUiTrigger);
      if (paramo != null) {
        break label115;
      }
      i = 0;
      label35:
      paramo = paramString.a(true);
      this.aT = false;
      switch (paramString.k())
      {
      default: 
        if (i != 0) {
          i = 2131493758;
        }
        break;
      }
    }
    for (;;)
    {
      Toast.makeText(m(), i, 0).show();
      return paramo;
      paramString = new com.ideashower.readitlater.db.operation.action.d(true, paramo, paramUiTrigger);
      break;
      label115:
      i = 1;
      break label35;
      i = 2131493731;
      continue;
      i = 2131493730;
      continue;
      i = 2131493729;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.ap.set(paramInt);
    if (paramInt != 3)
    {
      this.aq.set(paramInt);
      com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.ao, paramInt);
    }
    Object localObject;
    boolean bool1;
    if (this.Y != null)
    {
      localObject = this.Y.getSettings();
      if (paramInt == 2)
      {
        bool1 = true;
        a((WebSettings)localObject, bool1);
      }
    }
    else
    {
      if (this.af != null) {
        this.af.b(paramBoolean);
      }
      if (aw() != null)
      {
        localObject = aw();
        if (paramInt == 1) {
          break label121;
        }
      }
    }
    label121:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((ReaderToolbarLayout)localObject).setAutoLayoutEnabled(paramBoolean);
      ab();
      aP();
      aQ();
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(long paramLong)
  {
    final com.ideashower.readitlater.e.o localo = this.an.b();
    com.ideashower.readitlater.a.g.o().postDelayed(new Runnable()
    {
      public void run()
      {
        if ((ReaderFragment.c(ReaderFragment.this).b() == null) || (ReaderFragment.c(ReaderFragment.this).b().c() != localo.c())) {
          return;
        }
        ReaderFragment.b(ReaderFragment.this, true);
        if (ReaderFragment.q(ReaderFragment.this) == null) {
          ReaderFragment.a(ReaderFragment.this, (ResizeDetectRelativeLayout)((ViewStub)ReaderFragment.this.c(2131230868)).inflate());
        }
        for (;;)
        {
          final Object localObject = (FrameLayout.LayoutParams)ReaderFragment.q(ReaderFragment.this).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).bottomMargin = ReaderFragment.this.aw().getLayoutInsetBottom();
          ReaderFragment.q(ReaderFragment.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
          ReaderFragment.q(ReaderFragment.this).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              ReaderFragment.c(ReaderFragment.this, true);
            }
          });
          ReaderFragment.q(ReaderFragment.this).findViewById(2131230774).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              ReaderFragment.c(ReaderFragment.this, true);
              new ab(ReaderFragment.16.this.a.c(), ReaderFragment.this.b(UiTrigger.u)).j();
            }
          });
          com.b.c.a.e(ReaderFragment.q(ReaderFragment.this), com.ideashower.readitlater.util.j.a(150.0F));
          com.b.c.c.a(ReaderFragment.q(ReaderFragment.this)).f(0.0F).a(333L).a(com.pocket.i.a.e.a);
          localObject = ReaderFragment.q(ReaderFragment.this);
          com.ideashower.readitlater.a.g.o().postDelayed(new Runnable()
          {
            public void run()
            {
              if (ReaderFragment.q(ReaderFragment.this) == localObject) {
                ReaderFragment.c(ReaderFragment.this, true);
              }
            }
          }, 10000L);
          return;
          com.ideashower.readitlater.util.z.a(true, new View[] { ReaderFragment.q(ReaderFragment.this) });
        }
      }
    }, paramLong);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, paramInt2, 0, paramInt1));
    paramView.setVisibility(0);
  }
  
  private void a(final View paramView, long paramLong)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localAlphaAnimation.setDuration(paramLong);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private void a(WebSettings paramWebSettings, boolean paramBoolean)
  {
    paramWebSettings.setBuiltInZoomControls(paramBoolean);
    paramWebSettings.setSupportZoom(paramBoolean);
    paramWebSettings.setLoadWithOverviewMode(paramBoolean);
    paramWebSettings.setUseWideViewPort(paramBoolean);
  }
  
  private void a(UiContext paramUiContext)
  {
    if (!this.ao) {
      return;
    }
    if (this.an.b() != null)
    {
      new com.ideashower.readitlater.db.operation.action.v(this.an.b(), paramUiContext).j();
      return;
    }
    new com.ideashower.readitlater.db.operation.action.v(this.an.a(), paramUiContext).j();
  }
  
  private void a(com.ideashower.readitlater.e.b paramb, com.ideashower.readitlater.e.o paramo, String paramString)
  {
    if (paramb != null) {}
    for (paramb = new aw(this, paramb);; paramb = new aw(this, paramo.V()))
    {
      a(paramo, paramString, com.ideashower.readitlater.a.j.a(true, true) + "video/video.html", false, true, paramb);
      return;
    }
  }
  
  private void a(com.ideashower.readitlater.e.o paramo, String paramString)
  {
    this.an.a(paramo);
    aZ();
    this.af.c();
  }
  
  private void a(com.ideashower.readitlater.e.o paramo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, aw paramaw)
  {
    this.ak = false;
    this.an.a(paramaw);
    this.an.b(paramString2);
    this.an.a(paramString2);
    this.an.a(paramBoolean1);
    if (paramBoolean2)
    {
      paramo = this.Y.getSettings();
      if ((!paramBoolean1) || (this.ap.get() != 2))
      {
        paramBoolean1 = true;
        paramo.setJavaScriptEnabled(paramBoolean1);
        aW();
        g(false);
        this.an.a(0);
        if ((paramaw == null) || (!paramaw.b())) {
          break label163;
        }
        if (this.ba == null) {
          this.ba = new com.ideashower.readitlater.reader.w(this);
        }
        this.ba.a(paramaw);
        label135:
        if (!this.an.s()) {
          aV();
        }
      }
    }
    for (;;)
    {
      this.af.c();
      return;
      paramBoolean1 = false;
      break;
      label163:
      if (this.ap.get() == 1)
      {
        this.Y.setContentVisible(false);
        this.an.b(aX());
        this.Y.loadUrl(this.an.d());
        break label135;
      }
      this.Y.loadUrl(com.ideashower.readitlater.e.o.i(this.an.c()));
      break label135;
      aV();
    }
  }
  
  private void a(com.ideashower.readitlater.e.o paramo, boolean paramBoolean)
  {
    this.an.d(paramo.i());
    a(paramo, paramo.i(), com.pocket.m.a.l.c().e(paramo.f()), true, false, null);
    com.pocket.m.a.a(paramo, 1, true, true, com.pocket.m.a.k.a, paramBoolean);
  }
  
  private void a(JsInterface paramJsInterface, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramJsInterface == null)) {
      return;
    }
    paramJsInterface.setEnabled(paramBoolean);
  }
  
  public static void a(String paramString)
  {
    if ((ae != null) && (ae.get() != null))
    {
      ReaderFragment localReaderFragment = (ReaderFragment)ae.get();
      Object localObject = localReaderFragment.at();
      if (localObject != null)
      {
        localObject = com.ideashower.readitlater.a.a.a.c().a(com.ideashower.readitlater.util.g.a(((com.ideashower.readitlater.reader.f)localObject).a()));
        if ((localObject != null) && (((com.ideashower.readitlater.a.a.e)localObject).b().equals(paramString)) && (localReaderFragment.am() == 1)) {
          localReaderFragment.a(true, localReaderFragment.b(UiTrigger.s));
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    af();
    new com.pocket.webkit.a("article", "load").a(paramString).a(paramInt1).a(paramInt2).a(paramInt3).a(paramInt4).a(paramFloat).a(com.ideashower.readitlater.util.j.b(false)).a(com.ideashower.readitlater.util.f.b()).a(Build.VERSION.SDK_INT).a(this.Y);
    ah();
    ae();
  }
  
  private void a(String paramString, com.ideashower.readitlater.e.o paramo, UiContext paramUiContext)
  {
    a(paramString, paramo, false, paramUiContext);
  }
  
  private void a(String paramString, com.ideashower.readitlater.e.o paramo, boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 1;
    this.an.a(-2);
    this.an.a(paramo, paramString);
    aZ();
    boolean bool3 = this.ab;
    this.ab = false;
    int i;
    Object localObject1;
    if ((paramo != null) && (paramo.M()))
    {
      i = 1;
      if ((i == 0) || (!paramo.L()) || (paramo.ak() <= 0)) {
        break label184;
      }
      localObject1 = null;
      i = 1;
      label78:
      if (i != 0) {
        a(3, true);
      }
      if (com.ideashower.readitlater.a.g.k()) {
        break label726;
      }
      if (i == 0) {
        break label245;
      }
      this.ag.a(d(2131493126), d(2131493125), d(2131492932), new com.ideashower.readitlater.views.m()
      {
        public void a()
        {
          ReaderFragment.this.a(UiTrigger.p);
        }
      }, false, com.ideashower.readitlater.h.m.b(m()));
      h(2);
      i = j;
    }
    label184:
    label215:
    label239:
    label245:
    Object localObject2;
    String str1;
    for (;;)
    {
      if ((i != 0) && (!paramBoolean))
      {
        a(paramo, paramString, null, false, false, null);
        k(false);
      }
      return;
      i = 0;
      break;
      if ((i != 0) && (!paramo.L()))
      {
        localObject1 = null;
        i = 0;
        break label78;
      }
      if (paramo != null)
      {
        localObject1 = paramo.k();
        localObject1 = com.ideashower.readitlater.e.b.a((String)localObject1);
        if (localObject1 == null) {
          break label239;
        }
      }
      for (i = 1;; i = 0)
      {
        break;
        localObject1 = paramString;
        break label215;
      }
      if (paramo == null) {
        break label670;
      }
      if ((this.ap.get() == 1) && (paramo.R()) && (aI()))
      {
        b(paramo);
        i = 0;
      }
      else if ((this.ap.get() == 2) && (paramo.Q()) && (aI()))
      {
        c(paramo);
        i = 0;
      }
      else if ((!this.ak) && (paramo.Q()) && (aI()))
      {
        a(2, false, null);
        c(paramo);
        i = 0;
      }
      else if ((!this.ak) && (paramo.R()) && (aI()))
      {
        a(1, false, null);
        b(paramo);
        i = 0;
      }
      else
      {
        if (!aJ()) {
          break label474;
        }
        localObject1 = d(2131493592);
        localObject2 = d(2131493597);
        str1 = d(2131493596);
        label433:
        this.ag.a((String)localObject1, (String)localObject2, str1, new com.ideashower.readitlater.views.m()
        {
          public void a()
          {
            ReaderFragment.p(ReaderFragment.this);
          }
        }, false, com.ideashower.readitlater.h.m.b(m()));
        h(2);
        i = j;
      }
    }
    label474:
    boolean bool1;
    if (this.ak) {
      if (this.ap.get() == 1)
      {
        localObject2 = d(2131493499);
        bool1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.C);
        label509:
        localObject1 = String.format(d(2131493598), new Object[] { localObject2 });
        if (bool1) {
          break label992;
        }
        localObject1 = (String)localObject1 + String.format(d(2131493599), new Object[] { localObject2 });
      }
    }
    label670:
    label726:
    label975:
    label992:
    for (;;)
    {
      String str2 = String.format(d(2131493600), new Object[] { localObject2 });
      str1 = d(2131493595);
      this.ak = false;
      localObject2 = localObject1;
      localObject1 = str2;
      break label433;
      localObject2 = d(2131493533);
      bool1 = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.D);
      break label509;
      localObject1 = d(2131493592);
      localObject2 = d(2131493601);
      str1 = d(2131493596);
      break label433;
      this.ag.a(d(2131493592), d(2131493601), d(2131493596), new com.ideashower.readitlater.views.m()
      {
        public void a()
        {
          ReaderFragment.p(ReaderFragment.this);
        }
      }, false, com.ideashower.readitlater.h.m.b(m()));
      h(2);
      i = j;
      break;
      if (i != 0)
      {
        a((com.ideashower.readitlater.e.b)localObject1, paramo, paramString);
        i = 0;
        break;
      }
      if ((!paramBoolean) && (paramo != null))
      {
        if (this.ap.get() == 1)
        {
          if (bool3)
          {
            b(paramo.i(), true);
            i = 0;
            break;
          }
          if ((paramo.R()) && (aI()))
          {
            b(paramo);
            i = 0;
            break;
          }
          if (aI())
          {
            a(paramo, false);
            i = 0;
            break;
          }
          b(paramo.i(), false);
          i = 0;
          break;
        }
        if ((paramo.Q()) && (aI()))
        {
          c(paramo);
          i = 0;
          break;
        }
        b(paramo, paramBoolean);
        i = 0;
        break;
      }
      if ((paramBoolean) && (paramo != null))
      {
        if (this.ap.get() == 1)
        {
          a(paramo, true);
          i = 0;
          break;
        }
        com.pocket.m.a.a(paramo, 2, true, false, com.pocket.m.a.k.a, true);
        b(paramo, paramBoolean);
        i = 0;
        break;
      }
      if (this.ap.get() == 1)
      {
        bool1 = bool2;
        if (!paramBoolean) {
          if (!bool3) {
            break label975;
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          b(paramString, bool1);
          i = 0;
          break;
        }
      }
      g(paramString);
      i = 0;
      break;
    }
  }
  
  private void a(final String paramString, com.ideashower.readitlater.e.o paramo, final boolean paramBoolean, UiContext paramUiContext)
  {
    av.a(this.aH);
    String str;
    if (!this.aY)
    {
      this.aY = true;
      if (this.aI != null) {
        this.aI.dismiss();
      }
      this.Y.setVisibility(0);
      h(1);
      if (this.ba != null) {
        this.ba.c(false);
      }
      this.aR = false;
      this.aQ.a();
      this.Y.stopLoading();
      ab();
      this.Y.i();
      this.Y.invalidate();
      this.Y.clearView();
      g(0);
      this.ar.clear();
      m(false);
      k(true);
      aw().a(false, true);
      this.aZ.a();
      str = paramString;
      if (org.apache.a.c.k.h(paramString, "vnd.youtube:"))
      {
        paramString = paramString.substring("vnd.youtube:".length());
        str = "http://www.youtube.com/watch?v=" + paramString;
      }
      if (str != null) {
        break label260;
      }
    }
    for (;;)
    {
      this.an = new com.ideashower.readitlater.reader.f(paramo, str, paramUiContext);
      this.an.c(paramBoolean);
      aZ();
      this.an.a(-4);
      this.aH.b();
      if (paramo == null) {
        break label372;
      }
      a(str, paramo, paramBoolean);
      return;
      a(paramUiContext);
      break;
      label260:
      paramString = new aq(this, str, this.ap.get());
      if (this.aj.size() == 0)
      {
        this.aj.add(paramString);
      }
      else
      {
        aq localaq = (aq)this.aj.get(this.aj.size() - 1);
        if (localaq.a().equals(paramString.a()))
        {
          if (localaq.b() == paramString.b()) {
            localaq.a(paramString.b());
          }
        }
        else {
          this.aj.add(paramString);
        }
      }
    }
    label372:
    this.an.a(-3);
    paramString = new com.ideashower.readitlater.db.operation.h(str);
    paramString.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        paramAnonymousk = paramString.g();
        if ((ReaderFragment.c(ReaderFragment.this).a() == null) || (!paramAnonymousk.equals(ReaderFragment.c(ReaderFragment.this).a()))) {
          return;
        }
        com.ideashower.readitlater.e.e locale = paramString.e();
        ReaderFragment.a(ReaderFragment.this, paramAnonymousk, locale, paramBoolean);
      }
    }, true);
    paramString.f();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int k = 1;
    int j = 0;
    int i;
    label59:
    Object localObject1;
    if ((this.an != null) && ((!this.an.p()) || (!this.Y.g()) || (aM())))
    {
      i = 1;
      if (i == 0) {
        break label95;
      }
      if (this.an.g()) {
        break label90;
      }
      i = k;
      localObject1 = paramString;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.an.c((String)localObject1);
        this.Y.loadUrl((String)localObject1);
      }
      return;
      i = 0;
      break;
      label90:
      i = 0;
      break label59;
      label95:
      i = j;
      localObject1 = paramString;
      if (!paramString.equals("file:///android_asset/webkit/")) {
        if (d(paramString))
        {
          e(paramString);
          i = j;
          localObject1 = paramString;
        }
        else if (paramString.equals("http://ideashower.com/support/read-it-later/report-pages-not-saving-well-offline-here/"))
        {
          com.pocket.stats.f.a(this.an.a(), m());
          i = j;
          localObject1 = paramString;
        }
        else
        {
          Object localObject2;
          if (paramString.startsWith("mailto:"))
          {
            localObject2 = new Intent("android.intent.action.SEND");
            ((Intent)localObject2).setType("plain/text");
            ((Intent)localObject2).putExtra("android.intent.extra.EMAIL", new String[] { org.apache.a.c.k.a(paramString, "mailto:", "") });
            i = j;
            localObject1 = paramString;
            if (com.pocket.p.o.a(m(), (Intent)localObject2))
            {
              a((Intent)localObject2);
              i = j;
              localObject1 = paramString;
            }
          }
          else
          {
            if (com.ideashower.readitlater.reader.w.a(m()))
            {
              localObject1 = ad.matcher(paramString);
              if (((Matcher)localObject1).find())
              {
                localObject1 = ((Matcher)localObject1).group(1);
                localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:".concat((String)localObject1)));
                if (com.pocket.p.o.a(m(), (Intent)localObject2)) {
                  break label474;
                }
              }
            }
            label326:
            localObject1 = paramString;
            if (this.an.g())
            {
              localObject2 = paramString.replaceFirst("file://", "");
              localObject1 = localObject2;
              if (((String)localObject2).startsWith(com.pocket.m.a.l.c().a()))
              {
                localObject2 = paramString.replace(this.an.c().substring(0, this.an.c().lastIndexOf(File.separator)), "");
                localObject1 = localObject2;
                if (((String)localObject2).startsWith("/")) {
                  localObject1 = ((String)localObject2).replaceFirst("/", "");
                }
              }
            }
            try
            {
              localObject1 = new URL(new URL(this.an.a()), (String)localObject1).toString();
              if (paramBoolean)
              {
                b((String)localObject1);
                i = j;
                continue;
                label474:
                if ((!paramString.endsWith("embedded")) && (!paramString.startsWith("vnd.youtube:")) && ((this.an.e() == null) || (!this.an.e().a((String)localObject1)))) {
                  break label326;
                }
                a((Intent)localObject2);
              }
            }
            catch (MalformedURLException localMalformedURLException)
            {
              String str;
              for (;;)
              {
                com.ideashower.readitlater.util.e.a(localMalformedURLException);
                str = paramString;
              }
              a(str, false, UiTrigger.n);
              a(str, null, b(UiTrigger.n));
              i = j;
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, UiContext paramUiContext)
  {
    String str1 = this.an.n();
    if ((str1 == null) || (paramString == null)) {}
    while (!paramString.contains("_pktpp")) {
      return;
    }
    String str2 = this.an.a();
    if (this.an.b() != null) {}
    for (int i = this.an.b().c();; i = 0)
    {
      new com.ideashower.readitlater.db.operation.action.z(str1, str2, i, paramString, paramBoolean, paramUiContext).j();
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, UiTrigger paramUiTrigger)
  {
    a(paramString, paramBoolean, b(paramUiTrigger));
  }
  
  private void a(boolean paramBoolean, UiContext paramUiContext)
  {
    a(this.an.a(), null, paramBoolean, paramUiContext);
  }
  
  private void a(boolean paramBoolean, UiTrigger paramUiTrigger)
  {
    if (this.an.b() == null) {
      e(paramUiTrigger);
    }
    new com.ideashower.readitlater.db.operation.action.m(paramBoolean, this.an.b(), b(paramUiTrigger)).j();
    this.aT = false;
    if (paramBoolean) {}
    for (int i = 2131493757;; i = 2131493760)
    {
      Toast.makeText(m(), i, 0).show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Q()) {
      return;
    }
    if (this.Y.getPaging() != null) {
      this.Y.getPaging().a(paramBoolean1);
    }
    if ((paramBoolean1) && (this.aE) && (!aw().b())) {
      aw().a(true, true);
    }
    android.support.v4.app.f localf = m();
    if (paramBoolean1) {}
    for (int i = 2131493766;; i = 2131493765)
    {
      a.a(localf, null, i, 0).show();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, UiTrigger paramUiTrigger)
  {
    int i = 0;
    String str3 = null;
    if (this.ba != null) {
      this.ba.o();
    }
    com.ideashower.readitlater.e.o localo = this.an.b();
    com.pocket.m.a.a locala;
    UiContext localUiContext;
    String str1;
    if (localo != null)
    {
      locala = localo.ab();
      localUiContext = b(paramUiTrigger);
      if ((!paramBoolean1) || (!this.Y.e())) {
        break label173;
      }
      str1 = this.Y.getSelectedText();
      paramUiTrigger = str1;
      if (str1 == null)
      {
        Toast.makeText(m(), 2131493754, 0).show();
        paramUiTrigger = str1;
      }
      label96:
      if (localo == null) {
        break label178;
      }
      str1 = localo.i();
      label108:
      if (localo == null) {
        break label190;
      }
    }
    label173:
    label178:
    label190:
    for (String str2 = localo.q();; str2 = this.Y.getTitle())
    {
      if (localo != null) {
        i = localo.f();
      }
      if (locala != null) {
        str3 = locala.e();
      }
      if (paramBoolean2) {
        break label202;
      }
      ad.a(m(), str1, str2, i, str3, paramUiTrigger, localUiContext);
      return;
      locala = null;
      break;
      paramUiTrigger = null;
      break label96;
      str1 = this.an.a();
      break label108;
    }
    label202:
    ba.a(m(), new ak(str1, str2, i, str3, paramUiTrigger), localUiContext);
    com.pocket.stats.f.a(str1, "Send To Friend with Quote", localUiContext);
  }
  
  private boolean aI()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.an.b() != null)
    {
      bool1 = bool2;
      if (this.an.b().al() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean aJ()
  {
    if (this.an.b() != null) {
      return this.an.b().al() == 1;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private void aK()
  {
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bY)) {}
    for (;;)
    {
      return;
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.bY, true).a();
      try
      {
        Object localObject = m().getSharedPreferences("webViewSettings", 0);
        if (((SharedPreferences)localObject).getInt("double_tap_toast_count", 1) > 0)
        {
          localObject = ((SharedPreferences)localObject).edit().putInt("double_tap_toast_count", 0);
          if (com.ideashower.readitlater.util.a.b())
          {
            ((SharedPreferences.Editor)localObject).apply();
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.ideashower.readitlater.util.e.a(localThrowable);
        return;
      }
    }
    localThrowable.commit();
  }
  
  private void aL()
  {
    int k = 1;
    int j;
    int i;
    if (m() != null)
    {
      j = az();
      if ((j != 3) && (j != 2)) {
        break label48;
      }
      i = 2;
    }
    for (;;)
    {
      a(i, false);
      this.aD = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.K);
      return;
      j = 0;
      break;
      label48:
      i = k;
      if (j != 4) {
        if (this.an.b() != null)
        {
          if (this.an.b().L())
          {
            i = 3;
          }
          else if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.z))
          {
            i = k;
            if (!this.an.b().d(true)) {
              i = 2;
            }
          }
          else
          {
            i = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ao);
            if ((i != 1) && (i != 2)) {
              i = com.ideashower.readitlater.h.a.ao.a;
            }
          }
        }
        else {
          i = com.ideashower.readitlater.h.a.ao.a;
        }
      }
    }
  }
  
  private boolean aM()
  {
    return (this.bd) && (this.be < 17);
  }
  
  private void aN()
  {
    aP();
    this.aD = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.K);
    if (this.aD) {
      this.aF.setStreamMute(2, true);
    }
    this.aE = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.az);
    aO();
  }
  
  private void aO()
  {
    if ((this.Y.getPaging().a()) && (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ay))) {
      ag();
    }
  }
  
  private void aP()
  {
    if (this.Y == null) {
      return;
    }
    WebSettings localWebSettings = this.Y.getSettings();
    if (this.ap.get() == 2) {}
    for (String str = ax.a(false);; str = null)
    {
      localWebSettings.setUserAgentString(str);
      return;
    }
  }
  
  private void aQ()
  {
    if (this.Y == null) {
      return;
    }
    if (am() == 3) {}
    for (WebSettings.PluginState localPluginState = WebSettings.PluginState.OFF;; localPluginState = WebSettings.PluginState.ON)
    {
      this.Y.getSettings().setPluginState(localPluginState);
      return;
    }
  }
  
  private void aR()
  {
    com.ideashower.readitlater.a.a.e locale = com.ideashower.readitlater.a.a.a.c().a(com.ideashower.readitlater.util.g.a(this.an.a()));
    if (locale != null) {
      be.a(m(), locale.b());
    }
  }
  
  private void aS()
  {
    this.ag = ((ErrorView)c(2131230867));
    this.Y = ((ReaderWebView)c(2131230866));
    this.Y.setLongClickable(true);
    this.Y.setOnLongClickLinkListener(new com.ideashower.readitlater.reader.u()
    {
      public void a(String paramAnonymousString)
      {
        ReaderFragment.a(ReaderFragment.this, paramAnonymousString, true);
      }
    });
    WebSettings localWebSettings = this.Y.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    if (this.ap.get() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(localWebSettings, bool);
      aQ();
      this.ah = ReaderChromeClient.getNew(this, (ViewGroup)X());
      this.Y.setWebChromeClient(this.ah);
      this.Y.setWebViewClient(new au(this, null));
      this.Y.setOnContentDisplayedListener(new com.ideashower.readitlater.views.e()
      {
        public void a() {}
        
        public void b()
        {
          av.b(ReaderFragment.h(ReaderFragment.this));
        }
      });
      this.Y.setOnResizeListener(new com.ideashower.readitlater.views.g()
      {
        private int b;
        
        public void a() {}
        
        public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          if ((ReaderFragment.this.ai()) && (this.b != paramAnonymousInt1)) {
            ReaderFragment.aE().a(ReaderFragment.this.Y);
          }
          if (ReaderFragment.this.Y.e()) {}
          for (;;)
          {
            this.b = paramAnonymousInt1;
            return;
            ReaderFragment.this.af();
            if ((paramAnonymousInt1 != paramAnonymousInt3) && (paramAnonymousInt2 != paramAnonymousInt4)) {
              ReaderFragment.this.ag();
            }
          }
        }
      });
      this.Y.setDownloadListener(new DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          ReaderFragment.a(ReaderFragment.this, paramAnonymousString1);
        }
      });
      this.Y.setOnInteractionListener(new com.ideashower.readitlater.views.f()
      {
        public void a()
        {
          if (!ReaderFragment.i(ReaderFragment.this).i()) {
            ReaderFragment.i(ReaderFragment.this).n();
          }
        }
        
        public void b()
        {
          ReaderFragment.c(ReaderFragment.this).o();
        }
      });
      this.Y.setScrollBarStyle(0);
      this.Y.setOnScrollListener(new ac()
      {
        public void a()
        {
          boolean bool = ReaderFragment.j(ReaderFragment.this);
          ReaderFragment.a(ReaderFragment.this, false, ReaderFragment.k(ReaderFragment.this));
          if ((!ReaderFragment.this.Y.getPaging().a()) || (bool)) {
            return;
          }
          ReaderFragment.this.g(true);
          ReaderFragment.this.aa();
        }
        
        public void a(int paramAnonymousInt)
        {
          if (!ReaderFragment.l(ReaderFragment.this)) {
            return;
          }
          ReaderFragment.this.aw().a(false, true);
        }
        
        public boolean a(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          boolean bool = false;
          if ((!ReaderFragment.l(ReaderFragment.this)) || (!paramAnonymousBoolean) || (ReaderFragment.this.aw().d()) || (ReaderFragment.this.Y.getScale() != ReaderFragment.this.ac) || (ReaderFragment.this.Y.e())) {
            return false;
          }
          ReaderToolbarLayout localReaderToolbarLayout = ReaderFragment.this.aw();
          paramAnonymousBoolean = bool;
          if (paramAnonymousInt == 1) {
            paramAnonymousBoolean = true;
          }
          localReaderToolbarLayout.a(paramAnonymousBoolean, true);
          return true;
        }
        
        public void b()
        {
          ReaderFragment.this.aw().c();
          ReaderFragment.this.ac = ReaderFragment.this.Y.getScale();
        }
      });
      this.Y.setSwipeListener(this);
      this.Y.setOnTextSelectionChangeListener(new com.ideashower.readitlater.reader.v()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          boolean bool = true;
          Object localObject = ReaderFragment.a(ReaderFragment.this);
          int i;
          if (paramAnonymousBoolean)
          {
            i = 2;
            ((com.ideashower.readitlater.reader.n)localObject).a(i);
            if (paramAnonymousBoolean) {
              ReaderFragment.this.aw().a(false, false);
            }
            localObject = ReaderFragment.this.aw();
            if ((!paramAnonymousBoolean) || (!com.ideashower.readitlater.util.a.e())) {
              break label72;
            }
          }
          label72:
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            ((ReaderToolbarLayout)localObject).setContextualActionBarVisible(paramAnonymousBoolean);
            return;
            i = 1;
            break;
          }
        }
        
        public void b(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            ReaderFragment.this.ag();
          }
        }
      });
      this.Y.setContentVisible(false);
      return;
    }
  }
  
  private void aT()
  {
    this.ai = ((ResizeDetectFrameLayout)c(2131230864));
    this.bc = ((RainbowBar)c(2131230873));
    this.af = new com.ideashower.readitlater.reader.n(this, (ReaderToolbarLayout)X(), this.ai, new com.ideashower.readitlater.reader.o()
    {
      public void a()
      {
        ReaderFragment.this.a(UiTrigger.j);
      }
      
      public void a(int paramAnonymousInt)
      {
        ReaderFragment.this.a(paramAnonymousInt, true, UiTrigger.q);
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        ReaderFragment.a(ReaderFragment.this, paramAnonymousBoolean, paramAnonymousBoolean, UiTrigger.j);
      }
      
      public void b()
      {
        boolean bool2 = true;
        boolean bool1 = true;
        if (com.ideashower.readitlater.util.j.c())
        {
          localReaderFragment = ReaderFragment.this;
          localf = ReaderFragment.this.m();
          int i = com.ideashower.readitlater.util.j.a(340.0F);
          if (!ReaderFragment.this.al()) {}
          for (;;)
          {
            ReaderFragment.a(localReaderFragment, new com.ideashower.readitlater.reader.e(localf, i, -2, bool1));
            ReaderFragment.b(ReaderFragment.this).setAnimationStyle(2131558428);
            ReaderFragment.b(ReaderFragment.this).setBackgroundDrawable(ReaderFragment.this.n().getDrawable(2130837736));
            ReaderFragment.b(ReaderFragment.this).showAsDropDown(ReaderFragment.a(ReaderFragment.this).f());
            ReaderFragment.b(ReaderFragment.this).setOnDismissListener(new PopupWindow.OnDismissListener()
            {
              public void onDismiss()
              {
                ReaderFragment.a(ReaderFragment.this, null);
                if (ReaderFragment.m(ReaderFragment.this) != null) {
                  ReaderFragment.m(ReaderFragment.this).i();
                }
              }
            });
            if (ReaderFragment.m(ReaderFragment.this) != null) {
              ReaderFragment.m(ReaderFragment.this).h();
            }
            return;
            bool1 = false;
          }
        }
        ReaderFragment localReaderFragment = ReaderFragment.this;
        android.support.v4.app.f localf = ReaderFragment.this.m();
        if (!ReaderFragment.this.al()) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ReaderFragment.a(localReaderFragment, new com.ideashower.readitlater.reader.e(localf, -1, -2, bool1));
          ReaderFragment.b(ReaderFragment.this).setAnimationStyle(2131558429);
          ReaderFragment.b(ReaderFragment.this).showAtLocation(ReaderFragment.this.aw(), 81, 0, ReaderFragment.this.aw().getSystemInsets().bottom);
          break;
        }
      }
      
      public void b(boolean paramAnonymousBoolean)
      {
        ReaderFragment.a(ReaderFragment.this, paramAnonymousBoolean, UiTrigger.j);
      }
      
      public void c()
      {
        ReaderFragment.this.au();
      }
      
      public void d()
      {
        ReaderFragment.b(ReaderFragment.this, UiTrigger.j);
      }
      
      public void e()
      {
        ReaderFragment.n(ReaderFragment.this);
      }
      
      public void f()
      {
        ReaderFragment.c(ReaderFragment.this, UiTrigger.j);
      }
      
      public void g()
      {
        ReaderFragment.o(ReaderFragment.this);
      }
    });
    aw().setFullscreenListener(new r()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (!ReaderFragment.this.Y.f()) {
          ReaderFragment.this.ah();
        }
      }
    });
    this.aW = new com.ideashower.readitlater.reader.g(this);
    aw().a(this.aW);
    aw().setEnabler(this);
    aw().setOnLayoutInsetsChangedListener(new com.ideashower.readitlater.reader.s()
    {
      public void a()
      {
        if (ReaderFragment.this.am() == 1) {
          ReaderFragment.this.ae();
        }
      }
    });
  }
  
  private void aU()
  {
    com.ideashower.readitlater.util.k.a(3, (a)m());
  }
  
  private void aV()
  {
    UiContext localUiContext = this.an.q();
    com.ideashower.readitlater.e.o localo = this.an.b();
    String str = this.an.a();
    int i = this.ap.get();
    if (localo != null) {
      new com.ideashower.readitlater.db.operation.action.u(i, localo, str, localUiContext).j();
    }
    for (;;)
    {
      this.an.r();
      return;
      new com.ideashower.readitlater.db.operation.action.u(i, str, localUiContext).j();
    }
  }
  
  private void aW()
  {
    boolean bool2 = false;
    int i = this.ap.get();
    if (i == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((i == 3) || (i == 1)) {
        bool2 = true;
      }
      if ((bool1) && (this.aU == null)) {
        this.aU = new ReaderFragment.JSInterfaceArticle(this);
      }
      if ((bool2) && (this.aV == null)) {
        this.aV = new ReaderFragment.JSInterfaceVideo(this);
      }
      a(this.aU, bool1);
      a(this.aV, bool2);
      return;
    }
  }
  
  private String aX()
  {
    if (this.aJ == null)
    {
      str = com.ideashower.readitlater.util.j.b(true);
      if (str == null) {
        break label80;
      }
    }
    label80:
    for (String str = "-" + str;; str = "")
    {
      this.aJ = (com.ideashower.readitlater.a.j.a(true, true) + "article-mobile" + str + ".html");
      return this.aJ;
    }
  }
  
  private void aY()
  {
    if (this.an == null) {
      return;
    }
    final String str = this.an.a();
    com.ideashower.readitlater.db.operation.h.a(str, new com.ideashower.readitlater.db.operation.i()
    {
      public void a(com.ideashower.readitlater.e.o paramAnonymouso)
      {
        if (!org.apache.a.c.k.a(ReaderFragment.c(ReaderFragment.this).a(), str)) {}
        do
        {
          do
          {
            do
            {
              return;
              if (paramAnonymouso != null)
              {
                ReaderFragment.a(ReaderFragment.this, paramAnonymouso, str);
                return;
              }
              paramAnonymouso = ReaderFragment.c(ReaderFragment.this).b();
            } while (paramAnonymouso == null);
            if (paramAnonymouso.f() >= 0) {
              break;
            }
          } while (paramAnonymouso.al() != 2);
          ReaderFragment.a(ReaderFragment.this, null, str);
          return;
          if (paramAnonymouso.al() == 2)
          {
            ReaderFragment.a(ReaderFragment.this, null, str);
            return;
          }
        } while (paramAnonymouso.al() != 0);
        paramAnonymouso.k(1);
        ReaderFragment.a(ReaderFragment.this, paramAnonymouso, str);
      }
    });
  }
  
  private void aZ()
  {
    com.ideashower.readitlater.e.o localo = this.an.b();
    this.aW.setItem(localo);
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    ThemedView localThemedView = new ThemedView(m());
    a(localThemedView, paramInt1, paramInt2);
    localThemedView.setBackgroundResource(2130837764);
    this.Y.a(localThemedView, (AbsoluteLayout.LayoutParams)localThemedView.getLayoutParams(), 0);
    this.Y.b(localThemedView, true);
    return localThemedView;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    this.aG = 0L;
    boolean bool;
    if (paramInt == 25)
    {
      bool = true;
      if ((!paramBoolean) && (this.ap.get() != 2) && (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ay))) {
        break label90;
      }
      g(true);
      aa();
      if (!bool) {
        break label78;
      }
      this.Y.pageDown(paramBoolean);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.Y.performHapticFeedback(0);
      }
      return;
      bool = false;
      break;
      label78:
      this.Y.pageUp(paramBoolean);
    }
    label90:
    l(bool);
  }
  
  private void b(com.ideashower.readitlater.e.o paramo)
  {
    a(paramo, paramo.i(), com.pocket.m.a.l.c().e(paramo.f()), true, true, null);
  }
  
  private void b(com.ideashower.readitlater.e.o paramo, boolean paramBoolean)
  {
    if ((as.m()) && (paramo.c() != 0) && (!paramBoolean) && (paramo.al() != 3)) {}
    for (String str = com.pocket.p.q.a(paramo);; str = com.ideashower.readitlater.e.o.i(paramo.i()))
    {
      a(paramo, paramo.i(), str, false, true, null);
      return;
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    this.an.d(null);
    String str = com.pocket.m.a.l.c().a(paramString);
    if (new File(str).exists())
    {
      a(null, paramString, com.pocket.m.a.l.c().b(str), true, true, null);
      return;
    }
    this.an.d(paramString);
    com.pocket.m.a.a(paramString, paramBoolean);
    a(null, paramString, com.pocket.m.a.l.c().b(str), true, false, null);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aP = paramBoolean1;
    this.aO = paramBoolean2;
  }
  
  private boolean ba()
  {
    return (this.aP) || (this.aO);
  }
  
  private void bb()
  {
    if (!this.ao)
    {
      this.ao = true;
      a(this.an.a(), this.an.b(), this.an.q());
    }
  }
  
  private String bc()
  {
    if (this.an.b() != null) {
      return String.valueOf(this.an.b().f());
    }
    return this.an.a();
  }
  
  private SparseArray bd()
  {
    SparseArray localSparseArray1 = null;
    if (this.an.b() != null) {
      localSparseArray1 = this.an.b().W();
    }
    SparseArray localSparseArray2 = localSparseArray1;
    if (localSparseArray1 == null)
    {
      localSparseArray2 = localSparseArray1;
      if (this.an.a() != null) {
        localSparseArray2 = com.pocket.m.a.b(this.an.a());
      }
    }
    return localSparseArray2;
  }
  
  private SparseArray be()
  {
    SparseArray localSparseArray1 = null;
    if (this.an.b() != null) {
      localSparseArray1 = this.an.b().V();
    }
    SparseArray localSparseArray2 = localSparseArray1;
    if (localSparseArray1 == null) {
      localSparseArray2 = com.pocket.m.a.c(this.an.a());
    }
    return localSparseArray2;
  }
  
  private float bf()
  {
    return n().getDisplayMetrics().density;
  }
  
  private void bg()
  {
    com.ideashower.readitlater.e.o localo = this.an.b();
    if (localo == null) {
      return;
    }
    UiTrigger localUiTrigger = UiTrigger.j;
    new com.ideashower.readitlater.db.operation.action.i(localo, b(localUiTrigger)).j();
    this.aT = false;
    c(localUiTrigger);
    com.pocket.widget.undobar.a.a(m(), new al(localo, b(UiTrigger.h)));
  }
  
  private void bh()
  {
    if (this.an.b() == null) {
      return;
    }
    ((ReaderActivity)m()).a(this.an.b());
  }
  
  private void c(com.ideashower.readitlater.e.o paramo)
  {
    if (paramo.O() == 2) {}
    for (String str = com.pocket.m.a.a.a(paramo.i()).c();; str = com.pocket.m.a.l.c().c(paramo.f()))
    {
      a(paramo, paramo.i(), str, true, true, null);
      return;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (this.ap.get() != 1) {
      return;
    }
    Object localObject;
    String str;
    int k;
    int m;
    int i;
    if (paramBoolean1)
    {
      localObject = bd();
      this.an.a((SparseArray)localObject);
      if ((localObject != null) && (((SparseArray)localObject).size() > 0))
      {
        str = bc();
        k = com.ideashower.readitlater.reader.c.a(m());
        m = ((SparseArray)localObject).size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < m)
      {
        com.ideashower.readitlater.e.a locala = (com.ideashower.readitlater.e.a)((SparseArray)localObject).valueAt(i);
        try
        {
          com.pocket.k.f localf = new com.pocket.k.f(false, k);
          if (this.an.b() != null) {}
          for (com.pocket.m.a.d locald = this.an.b().ad();; locald = com.pocket.m.a.d.a())
          {
            com.ideashower.readitlater.f.f.a(locala.a(), localf, locald).a(locala.b()).a(str).a(true, com.pocket.m.a.k.a).a(this, false, true).b();
            break;
          }
          if (!paramBoolean2) {
            break;
          }
        }
        catch (Throwable localThrowable)
        {
          com.ideashower.readitlater.util.e.a(localThrowable);
        }
      }
      SparseArray localSparseArray = be();
      if ((localSparseArray == null) || (localSparseArray.size() <= 0)) {
        break;
      }
      k = localSparseArray.size();
      i = j;
      while (i < k)
      {
        localObject = (com.ideashower.readitlater.e.b)localSparseArray.valueAt(i);
        ((com.ideashower.readitlater.e.b)localObject).g();
        new com.pocket.webkit.a("article", "loadVideo").a(((com.ideashower.readitlater.e.b)localObject).i()).a(this.Y);
        ((com.ideashower.readitlater.e.b)localObject).h();
        i += 1;
      }
      ReaderFragment.JSInterfaceArticle.access$3700(this.aU);
      return;
      i += 1;
    }
  }
  
  private boolean c(UiTrigger paramUiTrigger)
  {
    paramUiTrigger = b(paramUiTrigger);
    if (this.aj.size() > 1)
    {
      this.aj.remove(this.aj.size() - 1);
      aq localaq = (aq)this.aj.get(this.aj.size() - 1);
      if (localaq.b != 3) {
        a(localaq.b, true);
      }
      a(localaq.a, null, paramUiTrigger);
      return true;
    }
    a(paramUiTrigger);
    P();
    return false;
  }
  
  private void d(UiTrigger paramUiTrigger)
  {
    com.ideashower.readitlater.e.o localo = this.an.b();
    if (localo == null) {
      return;
    }
    int i = localo.al();
    new com.ideashower.readitlater.db.operation.action.k(localo, b(paramUiTrigger)).j();
    this.aT = false;
    c(paramUiTrigger);
    com.pocket.widget.undobar.a.a(m(), new am(localo, b(UiTrigger.h), i));
  }
  
  private void d(com.ideashower.readitlater.e.o paramo)
  {
    int i = 1;
    if (paramo != null)
    {
      this.an.a(paramo);
      aZ();
      if (this.an.b().R())
      {
        boolean bool = this.an.t();
        a(this.an.a(), this.an.b(), this.an.q());
        this.an.c(bool);
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.ag.a(d(2131493594), d(2131493593), d(2131492932), new com.ideashower.readitlater.views.m()
        {
          public void a()
          {
            ReaderFragment.this.a(UiTrigger.p);
          }
        }, false, com.ideashower.readitlater.h.m.b(m()));
        h(2);
      }
      this.an.d(null);
      return;
      paramo = com.pocket.m.a.l.c().a(this.an.j());
      if (new File(paramo).exists())
      {
        a(null, this.an.j(), com.pocket.m.a.l.c().b(paramo), true, true, null);
        i = 0;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return (paramString.startsWith("ISRIL:")) || (paramString.startsWith("isril:"));
  }
  
  public static ReaderFragment e(int paramInt)
  {
    ReaderFragment localReaderFragment = new ReaderFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uniqueId", paramInt);
    localReaderFragment.g(localBundle);
    return localReaderFragment;
  }
  
  private void e(UiTrigger paramUiTrigger)
  {
    com.ideashower.readitlater.e.o localo = this.an.b();
    Iterator localIterator = null;
    Object localObject1 = localIterator;
    if (localo != null)
    {
      Object localObject2 = localo.T();
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localIterator = new ArrayList((Collection)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.ideashower.readitlater.e.x)localIterator.next();
          if (((com.ideashower.readitlater.e.x)localObject2).g() == 0)
          {
            ((com.ideashower.readitlater.e.x)localObject2).a(1);
            ((ArrayList)localObject1).add(new com.ideashower.readitlater.db.operation.action.b((com.ideashower.readitlater.e.x)localObject2, localo, b(paramUiTrigger)));
          }
        }
      }
    }
    paramUiTrigger = a(this.an.a(), localo, paramUiTrigger);
    if (paramUiTrigger == null)
    {
      localObject1 = new StringBuilder().append(this.an.a()).append(" did not fetch an item. ");
      if (paramUiTrigger != null) {}
      for (paramUiTrigger = paramUiTrigger.i();; paramUiTrigger = "") {
        throw new NullPointerException(paramUiTrigger);
      }
    }
    paramUiTrigger.g(this.af.e());
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.ideashower.readitlater.db.operation.action.b)((Iterator)localObject1).next()).j();
      }
    }
    a(paramUiTrigger, this.an.a());
  }
  
  private void e(String paramString)
  {
    if (Q()) {}
    label122:
    do
    {
      return;
      paramString = org.apache.a.c.k.a(org.apache.a.c.k.a(paramString, "ISRIL:", ""), "isril:", "");
      try
      {
        if (!paramString.startsWith("LINKIMG")) {
          break label122;
        }
        paramString = paramString.split("\\|\\|");
        if (paramString[2].equals(this.an.a()))
        {
          ImageViewerActivity.a(m(), com.ideashower.readitlater.e.t.b(this.an.h()), Integer.valueOf(paramString[1]).intValue());
          return;
        }
      }
      catch (Exception paramString)
      {
        com.ideashower.readitlater.a.g.s().a(paramString, this.an.a());
        return;
      }
      a(Integer.valueOf(paramString[1]).intValue(), paramString[2]);
      return;
      if (paramString.startsWith("IMG"))
      {
        paramString = paramString.split("\\|\\|");
        ImageViewerActivity.a(m(), com.ideashower.readitlater.e.t.b(this.an.h()), Integer.valueOf(paramString[1]).intValue());
        return;
      }
    } while (!paramString.equals("LOGIN"));
    aR();
  }
  
  private void f(final String paramString)
  {
    this.ag.a(d(2131493606), d(2131493605), d(2131493604), new com.ideashower.readitlater.views.m()
    {
      public void a()
      {
        com.ideashower.readitlater.a.g.a(ReaderFragment.this.m(), paramString);
      }
    }, false, com.ideashower.readitlater.h.m.b(m()));
    h(2);
  }
  
  private void g(int paramInt)
  {
    this.be = paramInt;
  }
  
  private void g(String paramString)
  {
    a(null, paramString, com.ideashower.readitlater.e.o.i(paramString), false, true, null);
  }
  
  private void h(int paramInt)
  {
    this.aX = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ag.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, this.af.g(), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      this.ag.setLayoutParams(localLayoutParams);
      this.ag.setVisibility(0);
      this.Y.scrollTo(0, 0);
      this.Y.a(true);
      aw().a(false, true);
      return;
    }
    this.ag.setVisibility(8);
    this.Y.a(false);
  }
  
  private void k(boolean paramBoolean)
  {
    this.bd = paramBoolean;
    if (paramBoolean)
    {
      this.bc.getRainbow().a();
      if (!com.ideashower.readitlater.util.a.i()) {
        break label82;
      }
      com.ideashower.readitlater.util.z.c(this.bc, true);
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (float f = 1.0F;; f = 0.0F)
    {
      com.b.c.c.a(this.bc).k(f).a(333L).a(com.pocket.i.a.e.a);
      return;
      this.bc.getRainbow().b();
      break;
    }
    label82:
    com.ideashower.readitlater.util.z.c(this.bc, paramBoolean);
  }
  
  private com.ideashower.readitlater.reader.f l(Bundle paramBundle)
  {
    String str;
    if (az() == 4)
    {
      str = com.pocket.tts.h.b();
      if ((str != null) && (com.pocket.tts.h.a())) {
        return new com.ideashower.readitlater.reader.f(null, str, null);
      }
      if (paramBundle != null) {
        return null;
      }
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        paramBundle = m().getIntent();
        if ((l().getInt("uniqueId") != 0) && ((az() == 3) || (az() == 1)))
        {
          paramBundle = (UiContext)paramBundle.getParcelableExtra("com.pocket.reader.extra.internal.uiContext");
          return new com.ideashower.readitlater.reader.f(ah.a(l().getInt("uniqueId"), false), str, paramBundle);
        }
        if (paramBundle.hasExtra("com.pocket.reader.extra.internal.itemUrl")) {
          str = paramBundle.getStringExtra("com.pocket.reader.extra.internal.itemUrl");
        }
        for (paramBundle = (UiContext)paramBundle.getParcelableExtra("com.pocket.reader.extra.internal.uiContext");; paramBundle = a.a(m()).y())
        {
          return new com.ideashower.readitlater.reader.f(null, str, paramBundle);
          if (!paramBundle.hasExtra("com.pocket.reader.external.extra.url")) {
            break;
          }
          if (!as.l())
          {
            Log.e("Pocket", "User is not logged in.");
            return null;
          }
          str = paramBundle.getStringExtra("com.pocket.reader.external.extra.url");
        }
        Log.e("Pocket", "Missing url");
        return null;
      }
      str = paramBundle.getString("com.pocket.reader.state.itemUrl");
      if (str != null) {
        return new com.ideashower.readitlater.reader.f(null, str, null);
      }
      return new com.ideashower.readitlater.reader.f(ah.a(paramBundle), str, null);
      str = null;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (!ai()) {
      return;
    }
    b(true, true);
    this.Y.a(true, false);
    if (paramBoolean)
    {
      av.a(this.Y);
      return;
    }
    aw.a(this.Y);
  }
  
  private void m(boolean paramBoolean)
  {
    if (!this.bg) {
      return;
    }
    this.bg = false;
    final ResizeDetectRelativeLayout localResizeDetectRelativeLayout = this.bf;
    View localView = localResizeDetectRelativeLayout.findViewById(2131230774);
    localResizeDetectRelativeLayout.setOnClickListener(null);
    localResizeDetectRelativeLayout.setClickable(false);
    localView.setOnClickListener(null);
    localView.setClickable(false);
    if ((paramBoolean) && (localResizeDetectRelativeLayout.getHeight() > 0))
    {
      com.b.c.c.a(localResizeDetectRelativeLayout).f(localResizeDetectRelativeLayout.getHeight() + 1).a(300L).a(com.pocket.i.a.e.b).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          if (!ReaderFragment.r(ReaderFragment.this)) {
            com.ideashower.readitlater.util.z.a(false, new View[] { localResizeDetectRelativeLayout });
          }
        }
      });
      return;
    }
    com.ideashower.readitlater.util.z.a(false, new View[] { localResizeDetectRelativeLayout });
  }
  
  public String K()
  {
    return "reader";
  }
  
  public void M()
  {
    super.M();
    aN();
  }
  
  protected boolean S()
  {
    return false;
  }
  
  public boolean W()
  {
    if (this.aI != null)
    {
      this.aI.dismiss();
      this.aI = null;
    }
    while (((this.ba != null) && (this.ba.n())) || (this.ah.onBackPressed()) || (c(UiTrigger.d))) {
      return true;
    }
    this.as = true;
    return super.W();
  }
  
  public void Y()
  {
    if (this.Y == null) {
      return;
    }
    this.Y.l();
    this.ah.onResume();
  }
  
  public void Z()
  {
    this.Y.stopLoading();
    this.Y.loadUrl("about:blank");
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.aQ.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    ar localar = new ar(this);
    localar.a(paramString);
    localar.b(paramInt);
    localar.a(paramString, null);
    com.pocket.p.k.a(localar, m());
  }
  
  public void a(int paramInt, boolean paramBoolean, UiTrigger paramUiTrigger)
  {
    if ((paramInt == this.ap.get()) || ((paramInt != 1) && (paramInt != 2))) {
      return;
    }
    if (paramInt != 1) {
      this.Y.setContentVisible(true);
    }
    this.ak = paramBoolean;
    a(paramInt, false);
    a(false, b(paramUiTrigger));
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ai()) {
      return;
    }
    new com.pocket.webkit.a("article", "newFontSize").a(paramInt).a(this.Y);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    aY();
  }
  
  public void a(ap paramap)
  {
    this.bb = paramap;
  }
  
  public void a(UiTrigger paramUiTrigger)
  {
    if (!com.ideashower.readitlater.a.g.k())
    {
      com.ideashower.readitlater.activity.a.b.b(2131493071, 2131493136).a(m());
      return;
    }
    a(true, b(paramUiTrigger));
  }
  
  public void a(com.ideashower.readitlater.e.o paramo)
  {
    if ((this.an.b() != null) && (paramo.f() == this.an.b().f())) {
      a(paramo, this.an.a());
    }
  }
  
  public void a(com.ideashower.readitlater.f.e parame, com.ideashower.readitlater.util.a.b paramb)
  {
    if (!a(parame))
    {
      parame.m();
      return;
    }
    com.ideashower.readitlater.e.a locala = (com.ideashower.readitlater.e.a)this.an.h().get(parame.d());
    com.pocket.webkit.a locala1 = new com.pocket.webkit.a("article", "loadImage").a(parame.d()).a(com.pocket.m.a.l.c().b(parame.c()));
    if (locala.d() != null)
    {
      paramb = locala.d();
      locala1 = locala1.a(paramb);
      if (locala.c() == null) {
        break label129;
      }
    }
    label129:
    for (paramb = locala.c();; paramb = "")
    {
      locala1.a(paramb).a(this.Y);
      parame.m();
      ReaderFragment.JSInterfaceArticle.access$3700(this.aU);
      return;
      paramb = "";
      break;
    }
  }
  
  public void a(com.pocket.p.s params)
  {
    super.a(params);
    if (this.an != null) {
      params.a(this.an.a());
    }
  }
  
  public void a(String paramString, int paramInt, UiTrigger paramUiTrigger)
  {
    UiContext localUiContext = b(paramUiTrigger);
    a(paramString, false, localUiContext);
    if (paramInt == -1)
    {
      if (!com.ideashower.readitlater.a.g.a(m(), paramString))
      {
        a(2, true, paramUiTrigger);
        a(paramString, null, localUiContext);
      }
      return;
    }
    if (paramInt == 1) {
      this.ab = true;
    }
    a(paramInt, true, paramUiTrigger);
    a(paramString, null, localUiContext);
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((com.ideashower.readitlater.e.o)paramList.next());
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = this.Y.a(this.Y.getScrollY()) + this.Y.a(paramFloat2);
    int i = this.ar.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramFloat1 < this.ar.keyAt(i)) {}
      }
      else {
        return paramFloat1 > this.ar.valueAt(i);
      }
      i -= 1;
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if ((this.aD) && (this.ap.get() != 3)) {}
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.aM);
      if (this.aG == 0L)
      {
        this.aG = System.currentTimeMillis();
        return true;
      }
      bool1 = bool2;
    } while (System.currentTimeMillis() - this.aG < 750L);
    this.aM = true;
    b(paramInt, true);
    return true;
  }
  
  public boolean a(com.ideashower.readitlater.f.e parame)
  {
    if ((!this.an.l()) || (this.ap.get() != 1) || (this.an.h() == null)) {
      return false;
    }
    return org.apache.a.c.k.a(parame.b(), bc());
  }
  
  public boolean a(com.pocket.m.b.i parami, boolean paramBoolean)
  {
    if (this.an.i())
    {
      if ((!paramBoolean) || (this.an.b() == null)) {
        break label58;
      }
      localo = parami.v();
      if (this.an.b().f() == parami.v().f()) {
        break label51;
      }
    }
    label51:
    label58:
    while (!this.an.j().equals(parami.u()))
    {
      com.ideashower.readitlater.e.o localo;
      return false;
      d(localo);
      return false;
    }
    d(null);
    return false;
  }
  
  public boolean a(String paramString, final JsResult paramJsResult)
  {
    if (Q()) {
      return true;
    }
    paramString = new AlertDialog.Builder(m()).setMessage(paramString).setTitle(String.format(d(2131493105), new Object[] { com.ideashower.readitlater.util.g.a(this.an.a()) })).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramJsResult.confirm();
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramJsResult.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramJsResult.cancel();
      }
    }).create();
    paramString.setCanceledOnTouchOutside(true);
    paramString.show();
    return true;
  }
  
  public boolean aA()
  {
    return (this.aS) || (this.aR) || (this.aQ.c());
  }
  
  public void aB()
  {
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        if (com.pocket.p.k.a(ReaderFragment.this)) {
          return;
        }
        ReaderFragment.a(ReaderFragment.this, false, ReaderFragment.this.b(UiTrigger.x));
      }
    });
  }
  
  public boolean aC()
  {
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        if (com.pocket.p.k.a(ReaderFragment.this)) {
          return;
        }
        ReaderFragment.a(ReaderFragment.this, false, ReaderFragment.this.b(UiTrigger.w));
      }
    });
    return true;
  }
  
  public void aD()
  {
    this.aW.l();
    if (this.aI != null) {
      this.aI.dismiss();
    }
  }
  
  protected void aa()
  {
    if ((!ai()) || (!this.Y.getPaging().a())) {
      return;
    }
    at.a(this.Y);
  }
  
  public void ab()
  {
    if ((this.Y == null) || (Q())) {
      return;
    }
    if (this.ap.get() == 3) {}
    for (int i = -16777216;; i = com.ideashower.readitlater.h.m.c(m()))
    {
      this.Y.setBackgroundColor(i);
      return;
    }
  }
  
  public void ac()
  {
    this.Y.loadUrl(com.ideashower.readitlater.e.o.i(this.an.c()));
  }
  
  public void ad()
  {
    if (m() == null) {
      break label7;
    }
    label7:
    while (this.an.m()) {
      return;
    }
    k(false);
    this.an.a(3);
    if ((this.ap.get() == 3) && (this.an.f()))
    {
      ObjectNode localObjectNode = ((com.ideashower.readitlater.e.b)this.an.e().a().valueAt(0)).i();
      new com.pocket.webkit.a("loadVideo").a(localObjectNode).a(this.Y);
      this.an.a(5);
    }
    for (;;)
    {
      this.aZ.a(this.ap.get());
      if ((!this.an.t()) || (!as.m()) || (this.an.b() == null) || (this.an.b().c() == 0) || ((this.ap.get() != 1) && (this.ap.get() != 2))) {
        break;
      }
      a(3000L);
      return;
      if (this.ap.get() == 1)
      {
        this.an.a(4);
        int k = com.ideashower.readitlater.reader.c.a();
        int i;
        if (com.ideashower.readitlater.reader.c.b())
        {
          i = 1;
          label218:
          if (!com.ideashower.readitlater.reader.c.c()) {
            break label259;
          }
        }
        label259:
        for (int j = 1;; j = 0)
        {
          a(this.an.c(), k, i, j, com.ideashower.readitlater.h.m.a(this.Y), bf());
          break;
          i = 0;
          break label218;
        }
      }
      this.an.a(5);
      av.b(this.aH);
    }
  }
  
  public void ae()
  {
    if ((!ai()) || (this.Y.f())) {
      return;
    }
    ReaderToolbarLayout localReaderToolbarLayout = aw();
    int i = (int)com.ideashower.readitlater.util.j.a(localReaderToolbarLayout.getLayoutInsetTop());
    int j = (int)com.ideashower.readitlater.util.j.a(localReaderToolbarLayout.getLayoutInsetBottom());
    new com.pocket.webkit.a("article", "setOverlayPadding").a(i).a(j).a(this.Y);
  }
  
  public void af()
  {
    if (!ai()) {
      return;
    }
    new com.pocket.webkit.a("article", "updateMaxViewHeight").a(this.Y.a(this.Y.getHeight())).a(this.Y);
  }
  
  public void ag()
  {
    if ((!ai()) || (!this.Y.getPaging().a())) {
      return;
    }
    g(false);
    az.a(this.Y);
  }
  
  public void ah()
  {
    if (!ai()) {
      return;
    }
    if (aw().b())
    {
      ay.a(this.Y);
      return;
    }
    ax.a(this.Y);
    ag();
  }
  
  public boolean ai()
  {
    return (am() == 1) && (this.an != null) && (this.an.m());
  }
  
  public void aj()
  {
    aY();
  }
  
  public BaseWebView ak()
  {
    return this.Y;
  }
  
  public boolean al()
  {
    return this.ap.get() == 1;
  }
  
  public int am()
  {
    return this.ap.get();
  }
  
  public boolean an()
  {
    return true;
  }
  
  public com.ideashower.readitlater.e.o ao()
  {
    return this.an.b();
  }
  
  public String ap()
  {
    return this.an.a();
  }
  
  public com.ideashower.readitlater.reader.n aq()
  {
    return this.af;
  }
  
  public ReaderWebView ar()
  {
    return (ReaderWebView)ak();
  }
  
  public boolean as()
  {
    return (this.Y != null) && (this.ap.get() == 1) && (!this.Y.e()) && (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.ay));
  }
  
  public com.ideashower.readitlater.reader.f at()
  {
    return this.an;
  }
  
  public void au()
  {
    this.aZ.a();
    UiTrigger localUiTrigger = UiTrigger.j;
    UiContext localUiContext = b(localUiTrigger);
    if (this.ap.get() == 1) {
      if (this.an.l())
      {
        this.aR = false;
        this.aS = false;
        new com.ideashower.readitlater.db.operation.action.w(com.ideashower.readitlater.db.operation.action.x.a, this.an.a(), localUiContext).j();
        this.aQ.a(this.an.a(), this.aH.c());
      }
    }
    while (this.ap.get() != 2)
    {
      return;
      this.aR = true;
      return;
    }
    a(1, true, localUiTrigger);
    this.aR = true;
  }
  
  public boolean av()
  {
    return (this.aT) && (this.aj.size() <= 1);
  }
  
  public ReaderToolbarLayout aw()
  {
    return (ReaderToolbarLayout)X();
  }
  
  public boolean ax()
  {
    if (this.Y.e()) {}
    while (this.aX != 1) {
      return false;
    }
    return true;
  }
  
  public com.ideashower.readitlater.reader.g ay()
  {
    return this.aW;
  }
  
  public int az()
  {
    return ((ReaderActivity)m()).C();
  }
  
  public UiContext b(UiTrigger paramUiTrigger)
  {
    int i = Math.round(this.Y.getScrollY() / (this.Y.getContentHeight() * this.Y.getScale()) * 100.0F);
    int j = Math.round((this.Y.getScrollY() + this.Y.getHeight()) / (this.Y.getContentHeight() * this.Y.getScale()) * 100.0F);
    return UiContext.a(paramUiTrigger, am(), i, j, aw().b());
  }
  
  public void b(float paramFloat)
  {
    com.ideashower.readitlater.a.k.a((a)m());
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if (ai()) {
      new com.pocket.webkit.a("article", "newTextStyle").a(paramInt).a(this.Y);
    }
    if (this.af != null)
    {
      this.af.c(true);
      ab();
    }
  }
  
  public void b(String paramString)
  {
    at localat = new at(this);
    localat.a(paramString);
    localat.a(paramString, null);
    com.pocket.p.k.a(localat, m());
  }
  
  public boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.aD) && (this.ap.get() != 3)) {}
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.aM) {
      this.aM = false;
    }
    for (;;)
    {
      return true;
      b(paramInt, false);
    }
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903060, paramViewGroup, false);
  }
  
  public void c(String paramString)
  {
    this.aS = true;
    a(paramString, null, b(UiTrigger.v));
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.aH = new av(this, null);
    this.an = l(paramBundle);
    if (this.an == null)
    {
      Log.e("Pocket", "Could not start ReaderActivity, see logs for details");
      P();
      return;
    }
    if ((com.pocket.tts.h.a()) && (org.apache.a.c.k.a(com.pocket.tts.h.b(), this.an.a()))) {
      this.aS = true;
    }
    aL();
    aS();
    aT();
    this.aF = ((AudioManager)m().getSystemService("audio"));
    if (com.ideashower.readitlater.util.f.a()) {}
    for (;;)
    {
      try
      {
        this.Y.loadUrl(com.ideashower.readitlater.a.j.a(true, true) + "htc_flyer_fixer.html");
        this.aQ = new com.ideashower.readitlater.reader.a(this, this.Y);
        this.aZ = new com.ideashower.readitlater.reader.t(this, aw());
        aK();
        com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.bK);
        com.ideashower.readitlater.i.c.a(this);
        com.ideashower.readitlater.i.c.a(this);
        return;
      }
      catch (com.ideashower.readitlater.b.b paramBundle)
      {
        com.ideashower.readitlater.util.e.a(paramBundle);
        continue;
      }
      this.Y.loadUrl("file:///android_asset/blank.html");
    }
  }
  
  public void e(Bundle paramBundle)
  {
    com.ideashower.readitlater.e.o localo = this.an.b();
    if (localo != null) {
      ah.a(localo, paramBundle);
    }
    for (;;)
    {
      super.e(paramBundle);
      return;
      paramBundle.putString("com.pocket.reader.state.itemUrl", this.an.a());
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    ReaderWebView localReaderWebView = this.Y;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localReaderWebView.setVisibility(i);
      if (!paramBoolean) {
        a(true, null);
      }
      return;
    }
  }
  
  public void f(int paramInt)
  {
    if (!this.an.i())
    {
      g(paramInt);
      if (paramInt == 100) {
        k(false);
      }
      return;
    }
    g(0);
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.aK != null)
    {
      if ((this.aK.getVisibility() != 0) || (!this.aN)) {
        break label52;
      }
      a(this.aK, 333L);
      a(this.aL, 333L);
    }
    for (;;)
    {
      this.aN = false;
      return;
      label52:
      this.aK.setVisibility(8);
      this.aL.setVisibility(8);
    }
  }
  
  public void h()
  {
    super.h();
    if (this.as) {
      Z();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    l(paramBoolean);
  }
  
  public void i(boolean paramBoolean)
  {
    if (!ai()) {
      return;
    }
    com.pocket.webkit.a locala = new com.pocket.webkit.a("article", "newFontType");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locala.a(i).a(this.Y);
      return;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (!ai()) {
      return;
    }
    com.pocket.webkit.a locala = new com.pocket.webkit.a("article", "newTextAlign");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locala.a(i).a(this.Y);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.aI != null) && (com.ideashower.readitlater.util.j.c())) {
      com.ideashower.readitlater.a.g.o().post(new Runnable()
      {
        public void run()
        {
          ReaderFragment.b(ReaderFragment.this).update(ReaderFragment.a(ReaderFragment.this).f(), -1, -1);
        }
      });
    }
  }
  
  public void w()
  {
    ae = new WeakReference(this);
    super.w();
    aN();
    if (aw() != null) {
      aw().a();
    }
    if (this.ba != null) {
      this.ba.j();
    }
    com.pocket.m.a.l.a(this);
    com.ideashower.readitlater.reader.c.a(this);
    com.ideashower.readitlater.reader.c.a(this, false, false, true, true);
  }
  
  public void x()
  {
    av.a(this.aH);
    super.x();
    if (this.aD) {
      this.aF.setStreamMute(2, false);
    }
    com.pocket.m.a.a(4);
    this.ah.onPause(R());
    this.Y.k();
    if (R()) {
      this.aQ.a();
    }
    com.pocket.m.a.l.b(this);
    com.ideashower.readitlater.reader.c.b(this);
    if (this.aI != null) {
      this.aI.dismiss();
    }
  }
  
  public void y()
  {
    if (this.Y != null)
    {
      this.Y.getSettings().setBuiltInZoomControls(true);
      this.Y.setVisibility(8);
    }
    if (this.aQ != null) {
      this.aQ.b();
    }
    super.y();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ReaderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */