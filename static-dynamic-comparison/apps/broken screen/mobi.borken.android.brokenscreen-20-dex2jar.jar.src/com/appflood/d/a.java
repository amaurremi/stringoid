package com.appflood.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.appflood.AFListActivity.1;
import com.appflood.c.f;
import com.appflood.e.h;
import com.appflood.e.i;
import com.appflood.e.j;
import com.appflood.e.k;
import com.appflood.mraid.AFBannerWebView;
import com.appflood.mraid.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class a
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, View.OnClickListener, com.appflood.b.b.a, b.a, b.b, b.c, b.d
{
  private int A = 0;
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private com.appflood.c.b F;
  private HashMap<String, Object> G;
  private HashMap<String, Object> H;
  private HashMap<String, Object> I;
  private ArrayList<HashMap<String, Object>> J;
  private boolean K = false;
  private AFBannerWebView L;
  private boolean M = true;
  private boolean N = false;
  private HashMap<String, String> a;
  private SurfaceView b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private a h;
  private b i;
  private boolean j = true;
  private RelativeLayout k;
  private ImageView l;
  private TextView m;
  private TextView n;
  private com.appflood.f.d o;
  private Button p;
  private String q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  public a(Context paramContext, AFBannerWebView paramAFBannerWebView, JSONObject paramJSONObject)
  {
    super(paramContext);
    this.L = paramAFBannerWebView;
    this.K = true;
    this.q = j.a(paramJSONObject, "url", "");
    this.t = j.a(paramJSONObject, "width", 0);
    this.u = j.a(paramJSONObject, "height", 0);
    new StringBuilder("json ").append(paramJSONObject).toString();
    j.a();
    if (j.a(paramJSONObject, "show_type", 0) == 25) {}
    for (;;)
    {
      this.M = bool;
      if (this.M)
      {
        this.w = this.u;
        this.v = this.t;
      }
      return;
      bool = false;
    }
  }
  
  public a(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    super(paramContext);
    this.a = new HashMap();
    a(paramContext);
    this.G = paramHashMap;
    paramContext = ((HashMap)this.G.get("VAST")).get("Ad");
    if (paramContext != null)
    {
      if (!(paramContext instanceof ArrayList)) {
        break label320;
      }
      paramContext = (ArrayList)paramContext;
      if (!j.a(paramContext))
      {
        if (this.H != null) {
          break label284;
        }
        this.H = ((HashMap)paramContext.get(0));
      }
    }
    paramContext = (HashMap)this.H.get("InLine");
    paramHashMap = (String)paramContext.get("Impression");
    this.a.put("Impression", paramHashMap);
    paramContext = (HashMap)paramContext.get("Creatives");
    paramHashMap = paramContext.get("Creative");
    if ((paramHashMap instanceof ArrayList)) {
      this.J = ((ArrayList)paramHashMap);
    }
    for (;;)
    {
      d();
      if (!j.a(null)) {
        this.e = true;
      }
      return;
      label284:
      int i1 = paramContext.indexOf(this.H);
      if (i1 >= paramContext.size() - 1) {
        break;
      }
      this.H = ((HashMap)paramContext.get(i1 + 1));
      break;
      label320:
      if (!(paramContext instanceof HashMap)) {
        break;
      }
      this.H = ((HashMap)paramContext);
      break;
      if (((paramHashMap instanceof HashMap)) && (this.J == null)) {
        this.J.add(paramContext);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while ((this.r <= 0) || (this.s <= 0)) {
      return;
    }
    int i1;
    if (!this.M)
    {
      float f1 = this.s / this.r;
      if (!this.M) {
        break label403;
      }
      i1 = 0;
      float f2 = (i1 + paramInt2) / paramInt1;
      new StringBuilder("resetLayout adRatio : ").append(f1).append(" vv=  ").append(f2).append(" mWidth ").append(this.r).toString();
      j.a();
      if (f1 <= f2) {
        break label424;
      }
      i1 = this.r;
      paramInt1 = paramInt2 * i1 / paramInt1;
      paramInt2 = i1;
      label130:
      if (!this.e) {
        break label460;
      }
    }
    label403:
    label424:
    label460:
    for (Object localObject = this.l;; localObject = this.b)
    {
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.width = paramInt2;
      localLayoutParams.height = paramInt1;
      new StringBuilder("resized w ").append(paramInt2).append(" resizedH ").append(paramInt1).append(" higher ").append(this.y + (this.A << 1) + this.x).toString();
      j.a();
      this.k.updateViewLayout((View)localObject, localLayoutParams);
      localObject = this.k.getLayoutParams();
      this.v = paramInt2;
      this.w = (paramInt1 + this.y + (this.A << 1) + this.x);
      ((ViewGroup.LayoutParams)localObject).height = this.w;
      ((ViewGroup)this.k.getParent()).updateViewLayout(this.k, (ViewGroup.LayoutParams)localObject);
      if (this.F != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("result", Boolean.valueOf(true));
        ((HashMap)localObject).put("w", Integer.valueOf(this.v));
        ((HashMap)localObject).put("h", Integer.valueOf(this.w));
        this.F.onFinish((HashMap)localObject);
      }
      localObject = getContext();
      if ((this.o != null) && (this.o.getVisibility() == 0)) {
        a((Context)localObject, false);
      }
      a((Context)localObject, true);
      return;
      i1 = this.y + (this.A << 1) + this.x;
      break;
      i1 = this.s - (this.y + (this.A << 1) + this.x);
      paramInt2 = i1 * paramInt1 / paramInt2;
      paramInt1 = i1;
      break label130;
    }
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(0);
    this.k = new RelativeLayout(paramContext);
    this.k.setBackgroundColor(0);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    if (!this.e)
    {
      this.b = new SurfaceView(paramContext);
      this.b.setBackgroundColor(0);
      this.b.setOnClickListener(this);
      this.k.addView(this.b, (ViewGroup.LayoutParams)localObject);
      this.i = new b(this.b, this.q);
      this.i.a(this);
      this.i.a(this);
      this.i.a(this);
      this.i.a(this);
      this.i.a(this);
      this.i.a(this);
      this.i.a(this);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      addView(this.k, (ViewGroup.LayoutParams)localObject);
      this.x = AFListActivity.1.a(paramContext, 34);
      this.y = AFListActivity.1.a(paramContext, 20);
      this.z = AFListActivity.1.a(paramContext, 30);
      this.A = AFListActivity.1.a(paramContext, 6);
      this.k.setBackgroundColor(-16777216);
      if (this.M) {
        break label476;
      }
      this.p = new Button(paramContext);
      AFListActivity.1.a(this.p, "close_press.png", "close_pressed.png");
      this.p.setOnClickListener(this);
      localObject = new RelativeLayout.LayoutParams(this.y, this.y);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.A;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = this.A;
      this.k.addView(this.p, (ViewGroup.LayoutParams)localObject);
      this.h = new a(paramContext);
      this.h.a().setOnClickListener(this);
      this.h.b().setOnClickListener(this);
      paramContext = new RelativeLayout.LayoutParams(-1, this.x);
      paramContext.addRule(12);
      this.k.addView(this.h, paramContext);
    }
    for (;;)
    {
      a(getContext(), true);
      return;
      this.l = new ImageView(paramContext);
      this.l.setScaleType(ImageView.ScaleType.FIT_XY);
      this.l.setOnClickListener(this);
      this.k.addView(this.l, (ViewGroup.LayoutParams)localObject);
      localObject = new com.appflood.b.b(null);
      ((com.appflood.b.b)localObject).a(this);
      ((com.appflood.b.b)localObject).f();
      break;
      label476:
      this.h = new a(paramContext);
      this.n = new TextView(paramContext);
      this.n.setBackgroundColor(0);
      this.n.setTextColor(-7829368);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(10);
      paramContext.addRule(11);
      this.k.addView(this.n, paramContext);
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (this.o == null) {
      this.o = new com.appflood.f.d(paramContext);
    }
    if (this.o.getParent() != null) {}
    for (boolean bool = true; bool == paramBoolean; bool = false) {
      return;
    }
    if (paramBoolean)
    {
      if (this.t > this.u) {}
      for (int i1 = this.u;; i1 = this.t)
      {
        paramContext = new RelativeLayout.LayoutParams(i1 / 3, i1 / 3);
        new StringBuilder("show progress!!!!!!!!!!! size ").append(i1 / 3).toString();
        j.a();
        paramContext.addRule(13);
        this.k.addView(this.o, paramContext);
        this.o.setVisibility(0);
        return;
      }
    }
    j.a();
    this.k.removeView(this.o);
    this.o.setVisibility(4);
  }
  
  private void a(s params)
  {
    new StringBuilder("fireTrackEvent ").append(params.toString()).toString();
    j.a();
    if (this.K) {
      this.L.a(params);
    }
    Context localContext;
    do
    {
      do
      {
        return;
        switch (5.a[params.ordinal()])
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 1: 
          k.c((String)this.a.get("start"));
          k.c((String)this.a.get("Impression"));
          return;
        case 2: 
          k.c((String)this.a.get("ClickTracking"));
          params = ((String)this.a.get("ClickThrough")).toString();
        }
      } while (j.a(params));
      localContext = getContext();
    } while (j.a(params));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(params));
    localContext.startActivity(localIntent);
    return;
    k.c((String)this.a.get("pause"));
    return;
    k.c((String)this.a.get("complete"));
  }
  
  private void b()
  {
    
    if (this.e)
    {
      this.D = 0;
      c(this.E);
      this.h.a(this.E);
    }
    f.a(new Runnable()
    {
      public final void run()
      {
        if (a.f(a.this))
        {
          if (!a.g(a.this)) {
            a.h(a.this);
          }
          if ((a.i(a.this) >= a.j(a.this)) && (!a.k(a.this)))
          {
            a.a(a.this, s.f);
            a.l(a.this);
          }
        }
        int i;
        if (a.f(a.this))
        {
          i = a.i(a.this);
          if (!a.g(a.this))
          {
            if (i == a.n(a.this).c()) {
              break label384;
            }
            a.n(a.this).b(i);
            if (a.o(a.this) != null) {
              a.o(a.this).setText(j.a(a.m(a.this).f() - i));
            }
            a.a(a.this, a.this.getContext(), false);
          }
          label175:
          if ((!a.p(a.this)) && (i / 1000 == a.q(a.this) / 1000))
          {
            j.a();
            a.r(a.this);
            if (!a.s(a.this)) {
              k.c((String)a.t(a.this).get("firstQuartile"));
            }
          }
          if ((!a.u(a.this)) && (i / 1000 == a.v(a.this) / 1000))
          {
            j.a();
            a.w(a.this);
            if (!a.s(a.this)) {
              k.c((String)a.t(a.this).get("thirdQuartile"));
            }
          }
          if ((a.this.hasWindowFocus()) || (!a.m(a.this).e())) {
            break label402;
          }
          a.m(a.this).c();
          a.x(a.this);
        }
        for (;;)
        {
          if (!a.k(a.this)) {
            f.a(this, 500L);
          }
          return;
          i = a.m(a.this).g();
          break;
          label384:
          a.a(a.this, a.this.getContext(), true);
          break label175;
          label402:
          if ((a.this.hasWindowFocus()) && (!a.g(a.this)) && (!a.y(a.this))) {
            a.m(a.this).d();
          }
        }
      }
    }, 500L);
  }
  
  private void b(int paramInt)
  {
    this.i.a(paramInt);
    this.i.d();
    this.f = false;
    AFListActivity.1.a(this.h.a(), "pause_press.png", "pause_pressed.png");
  }
  
  private void b(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap == null) && (paramHashMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    label22:
    label97:
    label125:
    for (;;)
    {
      String str;
      if (localIterator.hasNext())
      {
        paramHashMap = (Map.Entry)localIterator.next();
        str = (String)paramHashMap.getKey();
        paramHashMap = paramHashMap.getValue();
        if (!(paramHashMap instanceof String)) {
          break label97;
        }
        paramHashMap = (String)paramHashMap;
      }
      for (;;)
      {
        if ((j.a(str)) || (j.a(paramHashMap))) {
          break label125;
        }
        this.a.put(str, paramHashMap);
        break label22;
        break;
        if ((paramHashMap instanceof HashMap)) {
          paramHashMap = (String)((HashMap)paramHashMap).get("data");
        } else {
          paramHashMap = "";
        }
      }
    }
  }
  
  private void c()
  {
    a(s.h);
    if (!this.e)
    {
      this.i.b();
      this.i.h();
    }
    if (this.F != null) {
      this.F.onComplete();
    }
    a();
  }
  
  private void c(int paramInt)
  {
    this.B = (paramInt / 4);
    this.C = (paramInt * 3 / 4);
  }
  
  private void d()
  {
    Object localObject1;
    if (this.I == null)
    {
      this.I = ((HashMap)this.J.get(0));
      if (!this.I.containsKey("Linear")) {
        break label485;
      }
      localObject1 = (HashMap)this.I.get("Linear");
      this.E = (j.g((String)((HashMap)localObject1).get("Duration")) * 1000);
      localObject1 = ((HashMap)localObject1).get("MediaFiles");
      if (!(localObject1 instanceof HashMap)) {
        break label312;
      }
      localObject1 = (HashMap)localObject1;
    }
    for (;;)
    {
      this.t = ((Integer)((HashMap)localObject1).get("width")).intValue();
      this.u = ((Integer)((HashMap)localObject1).get("height")).intValue();
      this.q = ((String)((HashMap)localObject1).get("data"));
      Object localObject2 = (HashMap)((HashMap)localObject1).get("TrackingEvents");
      Object localObject3;
      if ((localObject2 != null) || (((HashMap)localObject2).size() > 0))
      {
        localObject3 = ((HashMap)localObject2).get("Tracking");
        if ((localObject3 instanceof ArrayList)) {
          localObject2 = (ArrayList)localObject3;
        }
      }
      for (;;)
      {
        label181:
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Object localObject4 = (HashMap)((Iterator)localObject2).next();
              localObject3 = (String)((HashMap)localObject4).get("event");
              localObject4 = (String)((HashMap)localObject4).get("data");
              if ((!j.a((CharSequence)localObject3)) && (!j.a((CharSequence)localObject4)))
              {
                this.a.put(localObject3, localObject4);
                continue;
                int i1 = this.J.indexOf(this.I);
                if (i1 >= this.J.size() - 1) {
                  break;
                }
                this.I = ((HashMap)this.J.get(i1 + 1));
                break;
                label312:
                if (!(localObject1 instanceof ArrayList)) {
                  break label504;
                }
                localObject3 = ((ArrayList)localObject1).iterator();
                localObject2 = null;
                do
                {
                  localObject1 = localObject2;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = (HashMap)((Iterator)localObject3).next();
                  localObject4 = ((String)((HashMap)localObject1).get("type")).toLowerCase();
                } while ((((String)localObject4).contains("flash")) || (((String)localObject4).contains("flv")));
                if (((String)localObject4).contains("mp4")) {
                  this.e = false;
                }
                for (;;)
                {
                  localObject2 = localObject1;
                  break;
                  if (((String)localObject4).contains("image")) {
                    this.e = true;
                  }
                }
                if (!(localObject3 instanceof HashMap)) {
                  break label499;
                }
                localObject2 = new ArrayList();
                ((ArrayList)localObject2).add((HashMap)localObject3);
                break label181;
              }
            }
          }
        }
        b((HashMap)((HashMap)localObject1).get("VideoClicks"));
        for (;;)
        {
          this.I.containsKey("CompanionAds");
          return;
          label485:
          this.I.containsKey("NonLinearAds");
        }
        label499:
        localObject2 = null;
      }
      label504:
      localObject1 = null;
    }
  }
  
  public final void a()
  {
    a(s.g);
    this.g = true;
    if (this.i != null) {
      this.i.h();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.f = true;
      if (this.h != null) {
        this.h.b(paramInt);
      }
      a(getContext(), true);
    }
  }
  
  public final void a(final com.appflood.b.b paramb)
  {
    paramb = paramb.d();
    if (paramb != null)
    {
      this.t = paramb.getWidth();
      this.u = paramb.getHeight();
      f.a(new Runnable()
      {
        public final void run()
        {
          a.b(a.this, a.this.getContext());
          a.e(a.this).setImageBitmap(paramb);
        }
      });
    }
  }
  
  public final void a(com.appflood.b.b paramb, int paramInt) {}
  
  public final void a(com.appflood.c.b paramb)
  {
    this.F = paramb;
    if (this.F != null)
    {
      paramb = new HashMap();
      paramb.put("result", Boolean.valueOf(true));
      paramb.put("w", Integer.valueOf(this.v));
      paramb.put("h", Integer.valueOf(this.w));
      this.F.onFinish(paramb);
    }
  }
  
  public final void a(HashMap<String, Integer> paramHashMap)
  {
    this.t = ((Integer)paramHashMap.get("result_width")).intValue();
    this.u = ((Integer)paramHashMap.get("result_height")).intValue();
    a(this.t, this.u);
  }
  
  public final void a(boolean paramBoolean)
  {
    new StringBuilder(" onFinished view result ").append(paramBoolean).toString();
    j.a();
    if (paramBoolean)
    {
      this.f = false;
      this.i.d();
      int i1 = this.i.f();
      c(i1);
      if (this.h != null) {
        this.h.a(i1);
      }
      this.N = false;
      b();
      a(s.a);
      return;
    }
    c();
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = getLayoutParams().width;
    this.s = getLayoutParams().height;
    if ((this.r <= 0) || (this.s <= 0)) {
      f.a(new Runnable()
      {
        public final void run()
        {
          a.a(a.this, a.this.getWidth());
          a.b(a.this, a.this.getHeight());
          if ((a.a(a.this) <= 0) || (a.b(a.this) <= 0))
          {
            f.a(this, 500L);
            return;
          }
          f.a(new Runnable()
          {
            public final void run()
            {
              new StringBuilder("mVideoWidth ").append(a.c(a.this)).append(" ").append(a.d(a.this)).toString();
              j.a();
              a.a(a.this, a.this.getContext());
              a.a(a.this, a.c(a.this), a.d(a.this));
            }
          });
        }
      }, 500L);
    }
  }
  
  public final void onClick(View paramView)
  {
    if (paramView == this.h.a()) {
      if (this.i.a()) {
        b(1);
      }
    }
    do
    {
      do
      {
        return;
        if (!this.f)
        {
          if (!this.e) {
            this.i.c();
          }
          this.f = true;
          a(s.c);
          AFListActivity.1.a(this.h.a(), "play_press.png", "play_pressed.png");
          return;
        }
        if (!this.e) {
          this.i.d();
        }
        a(s.d);
        this.f = false;
        AFListActivity.1.a(this.h.a(), "pause_press.png", "pause_pressed.png");
        return;
        if (paramView == this.h.b())
        {
          c();
          return;
        }
        if (paramView != this.p) {
          break;
        }
        a();
      } while (this.F == null);
      this.F.onClose();
      return;
    } while ((paramView == null) || ((paramView != this.b) && (paramView != this.l)));
    a(s.b);
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    j.a();
    a(s.f);
    if (this.F != null) {
      this.F.onComplete();
    }
    if (!this.N)
    {
      this.i.a(this.i.f() - 1);
      this.i.c();
      this.f = true;
      this.i.b();
      if (this.h != null)
      {
        this.h.b(this.i.f());
        AFListActivity.1.a(this.h.a(), "play_press.png", "play_pressed.png");
      }
    }
    do
    {
      return;
      paramMediaPlayer = getContext();
      a(paramMediaPlayer, false);
      this.m = new TextView(paramMediaPlayer);
      this.m.setTextSize(20.0F);
      this.m.setBackgroundColor(-16777216);
      this.m.setGravity(17);
      this.m.setText("Please try later");
      this.k.addView(this.m, this.b.getLayoutParams());
    } while (this.F == null);
    j.a();
    paramMediaPlayer = new HashMap();
    paramMediaPlayer.put("result", Boolean.valueOf(false));
    paramMediaPlayer.put("w", Integer.valueOf(this.v));
    paramMediaPlayer.put("h", Integer.valueOf(this.w));
    paramMediaPlayer.put("video_error", Boolean.valueOf(true));
    this.F.onFinish(paramMediaPlayer);
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    j.a(null, " error what " + paramInt1 + " extra " + paramInt2);
    this.N = true;
    return false;
  }
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer) {}
  
  final class a
    extends RelativeLayout
    implements SeekBar.OnSeekBarChangeListener
  {
    private Button a;
    private Button b;
    private SeekBar c;
    
    public a(Context paramContext)
    {
      super();
      a(paramContext);
    }
    
    private void a(Context paramContext)
    {
      new com.appflood.b.b(com.appflood.c.d.z + "video_controller_bg1.jpg", (byte)0).a(this);
      this.a = new Button(paramContext);
      this.a.setId(21760);
      this.a.setBackgroundColor(0);
      AFListActivity.1.a(this.a, "pause_press.png", "pause_pressed.png");
      Object localObject1 = new RelativeLayout.LayoutParams(a.z(a.this), a.z(a.this));
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = AFListActivity.1.a(paramContext, 2);
      addView(this.a, (ViewGroup.LayoutParams)localObject1);
      this.b = new Button(paramContext);
      this.b.setId(26112);
      this.b.setBackgroundColor(0);
      this.b.setVisibility(8);
      AFListActivity.1.a(this.b, "next_press.png", "next_pressed.png");
      localObject1 = new RelativeLayout.LayoutParams(a.z(a.this) * 3 / 4, a.z(a.this) * 3 / 4);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = (a.z(a.this) / 4);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = AFListActivity.1.a(paramContext, 2);
      addView(this.b, (ViewGroup.LayoutParams)localObject1);
      this.c = new SeekBar(paramContext);
      this.c.setId(35209);
      this.c.setBackgroundColor(0);
      this.c.setProgress(0);
      this.c.setMax(100);
      this.c.setSecondaryProgress(100);
      localObject1 = (LayerDrawable)this.c.getProgressDrawable();
      Object localObject2 = new Drawable[((LayerDrawable)localObject1).getNumberOfLayers()];
      int i = 0;
      if (i < ((LayerDrawable)localObject1).getNumberOfLayers())
      {
        switch (((LayerDrawable)localObject1).getId(i))
        {
        }
        for (;;)
        {
          i += 1;
          break;
          localObject2[i] = new ColorDrawable(0);
          new StringBuilder(" bgg i =  ").append(i).toString();
          j.a();
          continue;
          localObject3 = (ClipDrawable)((LayerDrawable)localObject1).getDrawable(i);
          ClipDrawable localClipDrawable = new ClipDrawable(new ColorDrawable(-16777216), 3, 1);
          localClipDrawable.setLevel(((ClipDrawable)localObject3).getLevel());
          new StringBuilder(" second  i =  ").append(i).append("  llll ").append(((ClipDrawable)localObject3).getLevel()).toString();
          j.a();
          localObject2[i] = localClipDrawable;
          continue;
          localObject3 = (ClipDrawable)((LayerDrawable)localObject1).getDrawable(i);
          localClipDrawable = new ClipDrawable(new ColorDrawable(-1282264), 3, 1);
          localClipDrawable.setLevel(((ClipDrawable)localObject3).getLevel());
          new StringBuilder(" progress  i =  ").append(i).append("  llll ").append(((ClipDrawable)localObject3).getLevel()).toString();
          j.a();
          localObject2[i] = localClipDrawable;
        }
      }
      localObject1 = new LayerDrawable((Drawable[])localObject2);
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      this.c.setProgressDrawable((Drawable)localObject1);
      AFListActivity.1.a(this.c, "mMaxHeight", Integer.valueOf(AFListActivity.1.a(getContext(), 5)));
      AFListActivity.1.a(this.c, "mMinHeight", Integer.valueOf(AFListActivity.1.a(getContext(), 5)));
      localObject1 = this.c;
      localObject2 = new StateListDrawable();
      Object localObject3 = new com.appflood.b.b(com.appflood.c.d.z + "slide_pressed.png", (byte)0);
      ((com.appflood.b.b)localObject3).a(new h((StateListDrawable)localObject2, (View)localObject1));
      ((com.appflood.b.b)localObject3).f();
      localObject3 = new com.appflood.b.b(com.appflood.c.d.z + "slide_press.png", (byte)0);
      ((com.appflood.b.b)localObject3).a(new i((StateListDrawable)localObject2, (View)localObject1));
      ((com.appflood.b.b)localObject3).f();
      this.c.setThumbOffset(AFListActivity.1.a(getContext(), 5));
      this.c.setOnSeekBarChangeListener(this);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.b.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.a.getId());
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = AFListActivity.1.a(paramContext, 5);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = AFListActivity.1.a(paramContext, 5);
      addView(this.c, (ViewGroup.LayoutParams)localObject1);
    }
    
    public final Button a()
    {
      return this.a;
    }
    
    public final void a(int paramInt)
    {
      this.c.setMax(paramInt);
      this.c.setSecondaryProgress(paramInt);
    }
    
    public final Button b()
    {
      return this.b;
    }
    
    public final void b(final int paramInt)
    {
      if (f.g())
      {
        this.c.setProgress(paramInt);
        return;
      }
      f.a(new Runnable()
      {
        public final void run()
        {
          a.a.a(a.a.this).setProgress(paramInt);
        }
      });
    }
    
    public final int c()
    {
      return this.c.getProgress();
    }
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (a.m(a.this).a()) {
          a.c(a.this, paramInt);
        }
      }
      else {
        return;
      }
      if (!a.f(a.this)) {
        a.m(a.this).a(paramInt);
      }
      for (;;)
      {
        a.a(a.this, s.e);
        return;
        a.d(a.this, paramInt);
      }
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar) {}
    
    public final void setEnabled(boolean paramBoolean)
    {
      super.setEnabled(paramBoolean);
      this.c.setEnabled(paramBoolean);
      this.a.setEnabled(paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */