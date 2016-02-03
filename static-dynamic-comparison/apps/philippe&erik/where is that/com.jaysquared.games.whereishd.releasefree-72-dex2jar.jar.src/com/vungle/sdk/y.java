package com.vungle.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.Timer;
import java.util.TimerTask;

final class y
  extends v
{
  private static final boolean c;
  private g A;
  private a B;
  private Handler C;
  n a;
  boolean b;
  private Context d;
  private View e;
  private ProgressBar f;
  private VideoView g;
  private ImageView h;
  private ImageView i;
  private Timer j;
  private AudioManager k;
  private TextView l;
  private String m;
  private boolean n;
  private boolean o;
  private boolean p;
  private Object q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private int v;
  private int w;
  private long x;
  private AlertDialog y;
  private boolean z;
  
  static
  {
    if (Build.VERSION.SDK_INT < 14) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  /* Error */
  public y(Context paramContext, String paramString, int paramInt1, int paramInt2, g paramg)
    throws v.a
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 83	com/vungle/sdk/v:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 85	com/vungle/sdk/y:d	Landroid/content/Context;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 87	com/vungle/sdk/y:e	Landroid/view/View;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 89	com/vungle/sdk/y:f	Landroid/widget/ProgressBar;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 91	com/vungle/sdk/y:g	Landroid/widget/VideoView;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 93	com/vungle/sdk/y:h	Landroid/widget/ImageView;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 95	com/vungle/sdk/y:i	Landroid/widget/ImageView;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 97	com/vungle/sdk/y:j	Ljava/util/Timer;
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 99	com/vungle/sdk/y:k	Landroid/media/AudioManager;
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 101	com/vungle/sdk/y:l	Landroid/widget/TextView;
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 103	com/vungle/sdk/y:n	Z
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 105	com/vungle/sdk/y:o	Z
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 107	com/vungle/sdk/y:p	Z
    //   64: aload_0
    //   65: new 109	java/lang/Object
    //   68: dup
    //   69: invokespecial 110	java/lang/Object:<init>	()V
    //   72: putfield 112	com/vungle/sdk/y:q	Ljava/lang/Object;
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 114	com/vungle/sdk/y:r	Z
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 116	com/vungle/sdk/y:s	Z
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 118	com/vungle/sdk/y:t	Z
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 120	com/vungle/sdk/y:u	Z
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 122	com/vungle/sdk/y:z	Z
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 124	com/vungle/sdk/y:A	Lcom/vungle/sdk/y$g;
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 126	com/vungle/sdk/y:B	Lcom/vungle/sdk/y$a;
    //   110: aload_0
    //   111: new 128	com/vungle/sdk/z
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 131	com/vungle/sdk/z:<init>	(Lcom/vungle/sdk/y;)V
    //   119: putfield 133	com/vungle/sdk/y:C	Landroid/os/Handler;
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 135	com/vungle/sdk/y:b	Z
    //   127: aload_0
    //   128: aload_1
    //   129: putfield 85	com/vungle/sdk/y:d	Landroid/content/Context;
    //   132: aload_2
    //   133: ifnull +10 -> 143
    //   136: aload_2
    //   137: invokevirtual 141	java/lang/String:length	()I
    //   140: ifne +12 -> 152
    //   143: new 79	com/vungle/sdk/v$a
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 144	com/vungle/sdk/v$a:<init>	(Lcom/vungle/sdk/v;)V
    //   151: athrow
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 147	com/vungle/sdk/y:a	(Landroid/content/Context;)V
    //   157: aload_0
    //   158: aload_1
    //   159: ldc -107
    //   161: invokevirtual 155	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   164: checkcast 157	android/media/AudioManager
    //   167: putfield 99	com/vungle/sdk/y:k	Landroid/media/AudioManager;
    //   170: aload_0
    //   171: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   174: putfield 165	com/vungle/sdk/y:x	J
    //   177: aload_0
    //   178: aload_2
    //   179: putfield 167	com/vungle/sdk/y:m	Ljava/lang/String;
    //   182: aload_0
    //   183: iload_3
    //   184: putfield 169	com/vungle/sdk/y:v	I
    //   187: aload_0
    //   188: iload 4
    //   190: putfield 171	com/vungle/sdk/y:w	I
    //   193: aload_0
    //   194: aload 5
    //   196: putfield 124	com/vungle/sdk/y:A	Lcom/vungle/sdk/y$g;
    //   199: aload_1
    //   200: checkcast 173	android/app/Activity
    //   203: getstatic 177	com/vungle/sdk/ak:C	I
    //   206: invokevirtual 181	android/app/Activity:setRequestedOrientation	(I)V
    //   209: aload_0
    //   210: getfield 87	com/vungle/sdk/y:e	Landroid/view/View;
    //   213: ldc -74
    //   215: invokevirtual 187	android/view/View:setBackgroundColor	(I)V
    //   218: aload_0
    //   219: getfield 89	com/vungle/sdk/y:f	Landroid/widget/ProgressBar;
    //   222: iconst_0
    //   223: invokevirtual 192	android/widget/ProgressBar:setVisibility	(I)V
    //   226: aload_0
    //   227: getfield 93	com/vungle/sdk/y:h	Landroid/widget/ImageView;
    //   230: invokevirtual 198	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   233: iconst_0
    //   234: invokevirtual 203	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   237: aload_0
    //   238: getfield 101	com/vungle/sdk/y:l	Landroid/widget/TextView;
    //   241: iconst_0
    //   242: invokevirtual 208	android/widget/TextView:setTextColor	(I)V
    //   245: aload_0
    //   246: getfield 91	com/vungle/sdk/y:g	Landroid/widget/VideoView;
    //   249: iconst_4
    //   250: invokevirtual 211	android/widget/VideoView:setVisibility	(I)V
    //   253: getstatic 212	com/vungle/sdk/ak:s	Z
    //   256: ifne +105 -> 361
    //   259: iconst_1
    //   260: istore 6
    //   262: aload_0
    //   263: iload 6
    //   265: putfield 103	com/vungle/sdk/y:n	Z
    //   268: aload_0
    //   269: invokespecial 214	com/vungle/sdk/y:e	()V
    //   272: aload_0
    //   273: getfield 91	com/vungle/sdk/y:g	Landroid/widget/VideoView;
    //   276: new 18	com/vungle/sdk/y$e
    //   279: dup
    //   280: aload_0
    //   281: iconst_0
    //   282: invokespecial 217	com/vungle/sdk/y$e:<init>	(Lcom/vungle/sdk/y;B)V
    //   285: invokevirtual 221	android/widget/VideoView:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   288: aload_0
    //   289: getfield 91	com/vungle/sdk/y:g	Landroid/widget/VideoView;
    //   292: new 9	com/vungle/sdk/y$b
    //   295: dup
    //   296: aload_0
    //   297: iconst_0
    //   298: invokespecial 222	com/vungle/sdk/y$b:<init>	(Lcom/vungle/sdk/y;B)V
    //   301: invokevirtual 226	android/widget/VideoView:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   304: aload_0
    //   305: getfield 91	com/vungle/sdk/y:g	Landroid/widget/VideoView;
    //   308: new 12	com/vungle/sdk/y$c
    //   311: dup
    //   312: aload_0
    //   313: iconst_0
    //   314: invokespecial 227	com/vungle/sdk/y$c:<init>	(Lcom/vungle/sdk/y;B)V
    //   317: invokevirtual 231	android/widget/VideoView:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   320: aload_0
    //   321: getfield 95	com/vungle/sdk/y:i	Landroid/widget/ImageView;
    //   324: new 15	com/vungle/sdk/y$d
    //   327: dup
    //   328: aload_0
    //   329: iconst_0
    //   330: invokespecial 232	com/vungle/sdk/y$d:<init>	(Lcom/vungle/sdk/y;B)V
    //   333: invokevirtual 236	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   336: aload_0
    //   337: new 6	com/vungle/sdk/y$a
    //   340: dup
    //   341: aload_0
    //   342: iconst_0
    //   343: invokespecial 237	com/vungle/sdk/y$a:<init>	(Lcom/vungle/sdk/y;B)V
    //   346: putfield 126	com/vungle/sdk/y:B	Lcom/vungle/sdk/y$a;
    //   349: aload_0
    //   350: getfield 93	com/vungle/sdk/y:h	Landroid/widget/ImageView;
    //   353: aload_0
    //   354: getfield 126	com/vungle/sdk/y:B	Lcom/vungle/sdk/y$a;
    //   357: invokevirtual 236	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   360: return
    //   361: iconst_0
    //   362: istore 6
    //   364: goto -102 -> 262
    //   367: astore_1
    //   368: aload_1
    //   369: invokestatic 242	com/vungle/sdk/ay:a	(Ljava/lang/Throwable;)V
    //   372: new 79	com/vungle/sdk/v$a
    //   375: dup
    //   376: aload_0
    //   377: invokespecial 144	com/vungle/sdk/v$a:<init>	(Lcom/vungle/sdk/v;)V
    //   380: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	y
    //   0	381	1	paramContext	Context
    //   0	381	2	paramString	String
    //   0	381	3	paramInt1	int
    //   0	381	4	paramInt2	int
    //   0	381	5	paramg	g
    //   260	103	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   152	259	367	java/lang/Throwable
    //   262	360	367	java/lang/Throwable
  }
  
  private void e()
  {
    this.k.setStreamMute(3, this.n);
    this.a.a(this.n);
  }
  
  private void f()
  {
    this.z = true;
    if (c)
    {
      ((RelativeLayout)this.e).removeView(this.g);
      this.g = null;
    }
    for (;;)
    {
      if (this.n) {
        this.k.setStreamMute(3, false);
      }
      return;
      this.g.setVisibility(4);
    }
  }
  
  private void g()
  {
    if (this.j != null) {
      return;
    }
    this.j = new Timer();
    this.j.schedule(new f((byte)0), 0L, 100L);
  }
  
  private void h()
  {
    if (this.j != null)
    {
      this.j.cancel();
      this.j.purge();
      this.j = null;
    }
  }
  
  private void i()
  {
    f();
    h();
    g localg = this.A;
    long l1 = this.x;
    localg.a();
  }
  
  public final View a()
  {
    return this.e;
  }
  
  protected final void a(Context paramContext)
  {
    this.a = new n(paramContext);
    this.e = this.a.a();
    this.f = this.a.b();
    this.g = this.a.f();
    this.h = this.a.d();
    this.i = this.a.e();
    this.l = this.a.c();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final void b()
  {
    try
    {
      this.r = false;
      if (this.u) {
        return;
      }
      this.u = true;
      if (this.y != null) {
        return;
      }
      this.B.a();
      this.b = false;
      if (!this.o)
      {
        this.g.setVisibility(0);
        this.g.setVideoPath(this.m);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.a(localThrowable);
      i();
      return;
    }
    synchronized (this.q)
    {
      this.l.setTextColor(0);
      this.l.setShadowLayer(2.0F, 0.0F, 0.0F, 0);
      this.h.getDrawable().setAlpha(0);
      this.s = false;
      this.t = false;
      this.g.seekTo(0);
      this.g.start();
      g();
      return;
    }
  }
  
  public final void c()
  {
    try
    {
      if (!this.u) {
        return;
      }
      this.u = false;
      if (this.y != null)
      {
        this.y.dismiss();
        this.y.hide();
        this.y = null;
      }
      if (this.g != null) {
        this.g.pause();
      }
      synchronized (this.q)
      {
        this.r = true;
        AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.l.getAnimation();
        if (localAlphaAnimation != null) {
          localAlphaAnimation.cancel();
        }
        this.l.setAnimation(null);
        localAlphaAnimation = (AlphaAnimation)this.h.getAnimation();
        if (localAlphaAnimation != null) {
          localAlphaAnimation.cancel();
        }
        this.h.setAnimation(null);
        this.l.setTextColor(0);
        this.l.setShadowLayer(2.0F, 0.0F, 0.0F, 0);
        this.h.getDrawable().setAlpha(0);
        h();
        this.s = false;
        this.t = false;
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.a(localThrowable);
      i();
    }
  }
  
  public final void d()
  {
    if (this.b) {}
    do
    {
      return;
      this.b = true;
      if (ak.D) {
        break;
      }
    } while (this.z);
    long l1 = this.g.getCurrentPosition();
    long l2 = this.g.getDuration();
    this.g.stopPlayback();
    f();
    h();
    this.A.a(this.x, l1, l2);
    return;
    this.g.pause();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.d);
    localBuilder.setTitle("Confirm Cancel");
    localBuilder.setMessage("Stopping this video early will prevent you from earning your reward. Continue?");
    localBuilder.setPositiveButton("Keep Watching", new aa(this));
    localBuilder.setNegativeButton("Cancel Video", new ab(this));
    localBuilder.setOnCancelListener(new ac(this));
    this.y = localBuilder.show();
  }
  
  private final class a
    implements View.OnClickListener
  {
    private boolean b = false;
    
    private a() {}
    
    public final void a()
    {
      this.b = false;
    }
    
    public final void onClick(View paramView)
    {
      if (y.e(y.this)) {}
      long l1;
      long l2;
      do
      {
        do
        {
          return;
        } while (this.b);
        this.b = true;
        l1 = y.b(y.this).getCurrentPosition();
        l2 = y.b(y.this).getDuration();
        if ((ak.D) && (y.j(y.this)) && (l1 / 1000.0D >= y.k(y.this)))
        {
          y.b(y.this).pause();
          paramView = new AlertDialog.Builder(y.c(y.this));
          paramView.setTitle("Confirm Cancel");
          paramView.setMessage("Stopping this video early will prevent you from earning your reward. Continue?");
          paramView.setPositiveButton("Keep Watching", new ad(this));
          paramView.setNegativeButton("Cancel Video", new ae(this));
          paramView.setOnCancelListener(new af(this));
          y.a(y.this, paramView.show());
          return;
        }
      } while ((!y.j(y.this)) || (l1 / 1000.0D < y.k(y.this)));
      y.b(y.this).stopPlayback();
      y.g(y.this);
      y.f(y.this);
      y.i(y.this).a(y.h(y.this), l1, l2);
    }
  }
  
  private final class b
    implements MediaPlayer.OnCompletionListener
  {
    private b() {}
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      if (y.e(y.this)) {
        return;
      }
      long l = paramMediaPlayer.getDuration();
      y.f(y.this);
      y.g(y.this);
      y.i(y.this).a(y.h(y.this), l);
    }
  }
  
  private final class c
    implements MediaPlayer.OnErrorListener
  {
    private c() {}
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      if (y.e(y.this)) {
        return false;
      }
      Log.e("OnErrorListener", "Error encountered during video playback: what(" + paramInt1 + ") extra(" + paramInt2 + ")");
      y.f(y.this);
      y.g(y.this);
      paramMediaPlayer = y.i(y.this);
      y.h(y.this);
      paramMediaPlayer.a();
      return true;
    }
  }
  
  private final class d
    implements View.OnClickListener
  {
    private d() {}
    
    public final void onClick(View paramView)
    {
      paramView = y.this;
      boolean bool;
      i locali;
      if (!y.l(y.this))
      {
        bool = true;
        y.a(paramView, bool);
        locali = ay.c();
        if (!y.l(y.this)) {
          break label58;
        }
      }
      label58:
      for (paramView = "muted";; paramView = "un-muted")
      {
        locali.a(paramView);
        y.m(y.this);
        return;
        bool = false;
        break;
      }
    }
  }
  
  private final class e
    implements MediaPlayer.OnPreparedListener
  {
    private e() {}
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      y.a(y.this).setVisibility(4);
      y.a(y.this, System.currentTimeMillis());
      y.b(y.this).setBackgroundDrawable(null);
      if (((Activity)y.c(y.this)).hasWindowFocus())
      {
        y.b(y.this).start();
        y.d(y.this);
      }
    }
  }
  
  private final class f
    extends TimerTask
  {
    private f() {}
    
    public final void run()
    {
      y.w(y.this).sendEmptyMessage(66);
    }
  }
  
  public static abstract class g
  {
    public abstract void a();
    
    public abstract void a(long paramLong1, long paramLong2);
    
    public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */