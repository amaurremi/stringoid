package com.atomic.apps.ringtone.cutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.atomic.apps.ringtone.a.j;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RingtoneEditActivity
  extends Activity
  implements ai, h
{
  private ImageButton A;
  private boolean B;
  private String C = "";
  private int D;
  private int E;
  private int F;
  private int G;
  private boolean H;
  private boolean I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private Handler R;
  private boolean S;
  private MediaPlayer T;
  private boolean U;
  private boolean V;
  private float W;
  private int X;
  private int Y;
  private int Z;
  private long a;
  private long aa;
  private float ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private e ag;
  private f ah;
  private Runnable ai = new q(this);
  private View.OnClickListener aj = new F(this);
  private View.OnClickListener ak = new R(this);
  private View.OnClickListener al = new S(this);
  private View.OnClickListener am = new T(this);
  private View.OnClickListener an = new U(this);
  private View.OnClickListener ao = new V(this);
  private View.OnClickListener ap = new W(this);
  private TextWatcher aq;
  private boolean b;
  private ProgressDialog c;
  private com.atomic.apps.ringtone.a.h d;
  private File e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private int k;
  private Uri l;
  private boolean m;
  private WaveView n;
  private MarkerView o;
  private MarkerView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private ImageButton v;
  private ImageButton w;
  private ImageButton x;
  private ImageButton y;
  private ImageButton z;
  
  public RingtoneEditActivity()
  {
    new X(this);
    this.aq = new r(this);
  }
  
  private int a(int paramInt)
  {
    int i1;
    if (paramInt < 0) {
      i1 = 0;
    }
    do
    {
      return i1;
      i1 = paramInt;
    } while (paramInt <= this.E);
    return this.E;
  }
  
  private String a(CharSequence paramCharSequence, String paramString)
  {
    int i2 = 0;
    String str;
    Object localObject1;
    int i1;
    switch (this.k)
    {
    default: 
      str = "/sdcard/media/audio/music";
      localObject1 = new File(str);
      ((File)localObject1).mkdirs();
      if (!((File)localObject1).isDirectory()) {
        str = "/sdcard";
      }
      localObject1 = "";
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= paramCharSequence.length())
      {
        i1 = i2;
        if (i1 < 100) {
          break label173;
        }
        return null;
        str = "/sdcard/media/audio/alarms";
        break;
        str = "/sdcard/media/audio/notifications";
        break;
        str = "/sdcard/media/audio/ringtones";
        break;
      }
      Object localObject2 = localObject1;
      if (Character.isLetterOrDigit(paramCharSequence.charAt(i1))) {
        localObject2 = localObject1 + paramCharSequence.charAt(i1);
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    label173:
    if (i1 > 0) {}
    for (paramCharSequence = str + "/" + (String)localObject1 + i1 + paramString;; paramCharSequence = str + "/" + (String)localObject1 + paramString) {
      try
      {
        new RandomAccessFile(new File(paramCharSequence), "r");
        i1 += 1;
      }
      catch (Exception paramString) {}
    }
    return paramCharSequence;
  }
  
  public static void a(Activity paramActivity)
  {
    new AlertDialog.Builder(paramActivity).setTitle(2130968682).setMessage(2130968683).setPositiveButton(2130968666, null).setCancelable(false).show();
  }
  
  private void a(Exception paramException, int paramInt)
  {
    CharSequence localCharSequence = getResources().getText(paramInt);
    if (paramException != null)
    {
      Log.e("Ringdroid", "Error: " + localCharSequence);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramException.printStackTrace(new PrintWriter(localByteArrayOutputStream, true));
      Log.e("Ringdroid", localByteArrayOutputStream.toString());
      paramException = getResources().getText(2130968665);
      setResult(0, new Intent());
    }
    for (;;)
    {
      new AlertDialog.Builder(this).setTitle(paramException).setMessage(localCharSequence).setPositiveButton(2130968666, new I(this)).setCancelable(false).show();
      return;
      Log.i("Ringdroid", "Success: " + localCharSequence);
      paramException = getResources().getText(2130968664);
    }
  }
  
  private void b(int paramInt)
  {
    c(paramInt);
    f();
  }
  
  private void c(int paramInt)
  {
    if (this.V) {}
    do
    {
      return;
      this.M = paramInt;
      if (this.M + this.D / 2 > this.E) {
        this.M = (this.E - this.D / 2);
      }
    } while (this.M >= 0);
    this.M = 0;
  }
  
  private String d(int paramInt)
  {
    if ((this.n != null) && (this.n.a()))
    {
      double d1 = this.n.b(paramInt);
      int i2 = (int)d1;
      int i3 = (int)((d1 - i2) * 100.0D + 0.5D);
      paramInt = i3;
      int i1 = i2;
      if (i3 >= 100)
      {
        i2 += 1;
        i3 -= 100;
        paramInt = i3;
        i1 = i2;
        if (i3 < 10)
        {
          paramInt = i3 * 10;
          i1 = i2;
        }
      }
      if (paramInt < 10) {
        return i1 + ".0" + paramInt;
      }
      return i1 + "." + paramInt;
    }
    return "";
  }
  
  private void d()
  {
    setContentView(2130903043);
    if (Build.VERSION.SDK_INT > 8)
    {
      localObject = (LinearLayout)findViewById(2131099675);
      this.ag = new e(this);
      this.ag.a("ca-app-pub-8029630852891329/2482807096");
      this.ag.a(com.google.android.gms.ads.d.g);
      b localb = new c().b(b.a).a();
      this.ag.a(localb);
      ((LinearLayout)localObject).addView(this.ag);
      this.ah = new f(this);
      this.ah.a("ca-app-pub-8029630852891329/1006073898");
      localObject = new c().b(b.a).a();
      this.ah.a((b)localObject);
      this.ah.a(new u(this));
    }
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.ab = ((DisplayMetrics)localObject).density;
    this.ac = ((int)(46.0F * this.ab));
    this.ad = ((int)(48.0F * this.ab));
    this.ae = ((int)(this.ab * 10.0F));
    this.af = ((int)(this.ab * 10.0F));
    this.q = ((TextView)findViewById(2131099678));
    this.r = ((TextView)findViewById(2131099679));
    this.s = ((TextView)findViewById(2131099692));
    this.s.addTextChangedListener(this.aq);
    this.t = ((TextView)findViewById(2131099696));
    this.t.addTextChangedListener(this.aq);
    this.v = ((ImageButton)findViewById(2131099688));
    this.v.setOnClickListener(this.ak);
    this.w = ((ImageButton)findViewById(2131099689));
    this.w.setOnClickListener(this.an);
    this.x = ((ImageButton)findViewById(2131099690));
    this.x.setOnClickListener(this.ao);
    this.y = ((ImageButton)findViewById(2131099687));
    this.y.setOnClickListener(this.al);
    this.z = ((ImageButton)findViewById(2131099686));
    this.z.setOnClickListener(this.am);
    this.A = ((ImageButton)findViewById(2131099681));
    this.A.setOnClickListener(this.aj);
    ((TextView)findViewById(2131099691)).setOnClickListener(this.ap);
    ((TextView)findViewById(2131099695)).setOnClickListener(this.ap);
    g();
    this.n = ((WaveView)findViewById(2131099682));
    this.n.a(this);
    this.u = ((TextView)findViewById(2131099685));
    this.u.setText(this.C);
    this.E = 0;
    this.J = -1;
    this.K = -1;
    if (this.d != null)
    {
      this.n.a(this.d);
      this.n.a(this.ab);
      this.E = this.n.g();
    }
    this.o = ((MarkerView)findViewById(2131099683));
    this.o.a(this);
    this.o.setAlpha(255);
    this.o.setFocusable(true);
    this.o.setFocusableInTouchMode(true);
    this.H = true;
    this.p = ((MarkerView)findViewById(2131099684));
    this.p.a(this);
    this.p.setAlpha(255);
    this.p.setFocusable(true);
    this.p.setFocusableInTouchMode(true);
    this.I = true;
    f();
  }
  
  private void e()
  {
    this.e = new File(this.f);
    Object localObject = this.f;
    this.i = ((String)localObject).substring(((String)localObject).lastIndexOf('.'), ((String)localObject).length());
    localObject = new aa(this, this.f);
    this.h = ((aa)localObject).a;
    this.g = ((aa)localObject).b;
    String str = ((aa)localObject).c;
    int i1 = ((aa)localObject).e;
    localObject = ((aa)localObject).d;
    str = this.h;
    localObject = str;
    if (this.g != null)
    {
      localObject = str;
      if (this.g.length() > 0) {
        localObject = str + " - " + this.g;
      }
    }
    setTitle((CharSequence)localObject);
    this.q.setText(this.h);
    this.r.setText(this.g);
    System.currentTimeMillis();
    this.a = System.currentTimeMillis();
    this.b = true;
    this.c = new ProgressDialog(this);
    this.c.setProgressStyle(1);
    this.c.setTitle(2130968624);
    this.c.setCancelable(true);
    this.c.setOnCancelListener(new v(this));
    this.c.show();
    localObject = new w(this);
    this.U = false;
    new x(this).start();
    new z(this, (j)localObject).start();
  }
  
  /* Error */
  private void e(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 905	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:S	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: invokespecial 907	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:k	()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull -11 -> 13
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   32: iload_1
    //   33: invokevirtual 909	com/atomic/apps/ringtone/cutter/WaveView:d	(I)I
    //   36: putfield 911	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:O	I
    //   39: iload_1
    //   40: aload_0
    //   41: getfield 331	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:F	I
    //   44: if_icmpge +233 -> 277
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   52: aload_0
    //   53: getfield 331	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:F	I
    //   56: invokevirtual 909	com/atomic/apps/ringtone/cutter/WaveView:d	(I)I
    //   59: putfield 913	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:Q	I
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 915	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:P	I
    //   67: aload_0
    //   68: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   71: aload_0
    //   72: getfield 911	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:O	I
    //   75: i2d
    //   76: ldc2_w 916
    //   79: dmul
    //   80: invokevirtual 422	com/atomic/apps/ringtone/cutter/WaveView:a	(D)I
    //   83: istore_2
    //   84: aload_0
    //   85: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   88: aload_0
    //   89: getfield 913	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:Q	I
    //   92: i2d
    //   93: ldc2_w 916
    //   96: dmul
    //   97: invokevirtual 422	com/atomic/apps/ringtone/cutter/WaveView:a	(D)I
    //   100: istore_1
    //   101: aload_0
    //   102: getfield 155	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:d	Lcom/atomic/apps/ringtone/a/h;
    //   105: iload_2
    //   106: invokevirtual 919	com/atomic/apps/ringtone/a/h:a	(I)I
    //   109: istore_2
    //   110: aload_0
    //   111: getfield 155	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:d	Lcom/atomic/apps/ringtone/a/h;
    //   114: iload_1
    //   115: invokevirtual 919	com/atomic/apps/ringtone/a/h:a	(I)I
    //   118: istore_1
    //   119: aload_0
    //   120: getfield 659	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:U	Z
    //   123: istore_3
    //   124: iload_3
    //   125: ifeq +75 -> 200
    //   128: iload_2
    //   129: iflt +71 -> 200
    //   132: iload_1
    //   133: iflt +67 -> 200
    //   136: aload_0
    //   137: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   140: invokevirtual 924	android/media/MediaPlayer:reset	()V
    //   143: aload_0
    //   144: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   147: iconst_3
    //   148: invokevirtual 927	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   151: new 929	java/io/FileInputStream
    //   154: dup
    //   155: aload_0
    //   156: getfield 847	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:e	Ljava/io/File;
    //   159: invokevirtual 932	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   162: invokespecial 933	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   171: aload 4
    //   173: invokevirtual 937	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   176: iload_2
    //   177: i2l
    //   178: iload_1
    //   179: iload_2
    //   180: isub
    //   181: i2l
    //   182: invokevirtual 941	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   185: aload_0
    //   186: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   189: invokevirtual 944	android/media/MediaPlayer:prepare	()V
    //   192: aload_0
    //   193: aload_0
    //   194: getfield 911	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:O	I
    //   197: putfield 915	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:P	I
    //   200: aload_0
    //   201: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   204: new 946	com/atomic/apps/ringtone/cutter/H
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 947	com/atomic/apps/ringtone/cutter/H:<init>	(Lcom/atomic/apps/ringtone/cutter/RingtoneEditActivity;)V
    //   212: invokevirtual 951	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   215: aload_0
    //   216: iconst_1
    //   217: putfield 905	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:S	Z
    //   220: aload_0
    //   221: getfield 915	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:P	I
    //   224: ifne +14 -> 238
    //   227: aload_0
    //   228: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   231: aload_0
    //   232: getfield 911	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:O	I
    //   235: invokevirtual 954	android/media/MediaPlayer:seekTo	(I)V
    //   238: aload_0
    //   239: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   242: invokevirtual 955	android/media/MediaPlayer:start	()V
    //   245: aload_0
    //   246: invokespecial 324	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:f	()V
    //   249: aload_0
    //   250: invokespecial 814	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:g	()V
    //   253: goto -240 -> 13
    //   256: astore 4
    //   258: aload_0
    //   259: aload 4
    //   261: ldc_w 956
    //   264: invokespecial 416	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:a	(Ljava/lang/Exception;I)V
    //   267: goto -254 -> 13
    //   270: astore 4
    //   272: aload_0
    //   273: monitorexit
    //   274: aload 4
    //   276: athrow
    //   277: iload_1
    //   278: aload_0
    //   279: getfield 191	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:G	I
    //   282: if_icmple +21 -> 303
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   290: aload_0
    //   291: getfield 175	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:E	I
    //   294: invokevirtual 909	com/atomic/apps/ringtone/cutter/WaveView:d	(I)I
    //   297: putfield 913	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:Q	I
    //   300: goto -238 -> 62
    //   303: aload_0
    //   304: aload_0
    //   305: getfield 160	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:n	Lcom/atomic/apps/ringtone/cutter/WaveView;
    //   308: aload_0
    //   309: getfield 191	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:G	I
    //   312: invokevirtual 909	com/atomic/apps/ringtone/cutter/WaveView:d	(I)I
    //   315: putfield 913	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:Q	I
    //   318: goto -256 -> 62
    //   321: astore 4
    //   323: getstatic 960	java/lang/System:out	Ljava/io/PrintStream;
    //   326: ldc_w 962
    //   329: invokevirtual 967	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   336: invokevirtual 924	android/media/MediaPlayer:reset	()V
    //   339: aload_0
    //   340: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   343: iconst_3
    //   344: invokevirtual 927	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   347: aload_0
    //   348: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   351: aload_0
    //   352: getfield 847	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:e	Ljava/io/File;
    //   355: invokevirtual 932	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   358: invokevirtual 969	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 405	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:T	Landroid/media/MediaPlayer;
    //   365: invokevirtual 944	android/media/MediaPlayer:prepare	()V
    //   368: aload_0
    //   369: iconst_0
    //   370: putfield 915	com/atomic/apps/ringtone/cutter/RingtoneEditActivity:P	I
    //   373: goto -173 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	RingtoneEditActivity
    //   0	376	1	paramInt	int
    //   83	98	2	i1	int
    //   123	2	3	bool	boolean
    //   20	152	4	localObject1	Object
    //   256	4	4	localException1	Exception
    //   270	5	4	localObject2	Object
    //   321	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	62	256	java/lang/Exception
    //   62	124	256	java/lang/Exception
    //   200	238	256	java/lang/Exception
    //   238	253	256	java/lang/Exception
    //   277	300	256	java/lang/Exception
    //   303	318	256	java/lang/Exception
    //   323	373	256	java/lang/Exception
    //   2	13	270	finally
    //   16	22	270	finally
    //   27	62	270	finally
    //   62	124	270	finally
    //   136	200	270	finally
    //   200	238	270	finally
    //   238	253	270	finally
    //   258	267	270	finally
    //   277	300	270	finally
    //   303	318	270	finally
    //   323	373	270	finally
    //   136	200	321	java/lang/Exception
  }
  
  private void f()
  {
    for (;;)
    {
      int i2;
      try
      {
        if (this.S)
        {
          i1 = this.T.getCurrentPosition() + this.P;
          i2 = this.n.c(i1);
          this.n.e(i2);
          c(i2 - this.D / 2);
          if (i1 >= this.Q) {
            k();
          }
        }
        if (!this.V)
        {
          if (this.N == 0) {
            break label518;
          }
          i1 = this.N;
          i1 = this.N / 30;
          if (this.N > 80)
          {
            this.N -= 80;
            this.L = (i1 + this.L);
            if (this.L + this.D / 2 > this.E)
            {
              this.L = (this.E - this.D / 2);
              this.N = 0;
            }
            if (this.L < 0)
            {
              this.L = 0;
              this.N = 0;
            }
            this.M = this.L;
          }
        }
        else
        {
          this.n.a(this.F, this.G, this.L);
          this.n.invalidate();
          this.o.setContentDescription(getResources().getText(2130968626) + " " + d(this.F));
          this.p.setContentDescription(getResources().getText(2130968627) + " " + d(this.G));
          i1 = this.F - this.L - this.ac;
          if (this.o.getWidth() + i1 < 0) {
            break label566;
          }
          if (this.H) {
            break label614;
          }
          this.R.postDelayed(new E(this), 0L);
          int i3 = this.G - this.L - this.p.getWidth() + this.ad;
          if (this.p.getWidth() + i3 < 0) {
            break label589;
          }
          i2 = i3;
          if (!this.I)
          {
            this.R.postDelayed(new G(this), 0L);
            i2 = i3;
          }
          label415:
          this.o.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i1, this.ae));
          this.p.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i2, this.n.getMeasuredHeight() - this.p.getHeight() - this.af));
          return;
        }
        if (this.N < -80)
        {
          this.N += 80;
          continue;
        }
        this.N = 0;
      }
      finally {}
      continue;
      label518:
      int i1 = this.M - this.L;
      if (i1 > 10) {
        i1 /= 10;
      }
      for (;;)
      {
        label539:
        this.L = (i1 + this.L);
        break;
        for (;;)
        {
          if (i1 < -10)
          {
            i1 /= 10;
            break label539;
            label566:
            if (!this.H) {
              break label640;
            }
            this.o.setAlpha(0);
            this.H = false;
            break label640;
            label589:
            if (this.I)
            {
              this.p.setAlpha(0);
              this.I = false;
            }
            i2 = 0;
            break label415;
            label614:
            break;
            if (i1 > 0)
            {
              i1 = 1;
              break label539;
            }
          }
        }
        if (i1 < 0) {
          i1 = -1;
        } else {
          i1 = 0;
        }
      }
      label640:
      i1 = 0;
    }
  }
  
  private void g()
  {
    if (this.S)
    {
      this.v.setImageResource(17301539);
      this.v.setContentDescription(getResources().getText(2130968630));
      return;
    }
    this.v.setImageResource(17301540);
    this.v.setContentDescription(getResources().getText(2130968629));
  }
  
  private void h()
  {
    this.F = this.n.b(0.0D);
    this.G = this.n.b(15.0D);
  }
  
  private void i()
  {
    b(this.F - this.D / 2);
  }
  
  private void j()
  {
    b(this.G - this.D / 2);
  }
  
  private void k()
  {
    try
    {
      if ((this.T != null) && (this.T.isPlaying())) {
        this.T.pause();
      }
      this.n.e(-1);
      this.S = false;
      g();
      return;
    }
    finally {}
  }
  
  private void l()
  {
    if (this.S) {
      k();
    }
    Message localMessage = Message.obtain(new Q(this));
    new d(this, getResources(), this.h, localMessage).show();
  }
  
  private void m()
  {
    this.y.setEnabled(this.n.c());
    this.z.setEnabled(this.n.e());
  }
  
  public final void a()
  {
    this.B = false;
    f();
  }
  
  public final void a(float paramFloat)
  {
    this.V = true;
    this.W = paramFloat;
    this.Y = this.F;
    this.Z = this.G;
  }
  
  public final void a(MarkerView paramMarkerView)
  {
    this.V = false;
    if (paramMarkerView == this.o)
    {
      i();
      return;
    }
    j();
  }
  
  public final void a(MarkerView paramMarkerView, float paramFloat)
  {
    paramFloat -= this.W;
    if (paramMarkerView == this.o)
    {
      this.F = a((int)(this.Y + paramFloat));
      this.G = a((int)(paramFloat + this.Z));
    }
    for (;;)
    {
      f();
      return;
      this.G = a((int)(paramFloat + this.Z));
      if (this.G < this.F) {
        this.G = this.F;
      }
    }
  }
  
  public final void a(MarkerView paramMarkerView, int paramInt)
  {
    this.B = true;
    if (paramMarkerView == this.o)
    {
      int i1 = this.F;
      this.F = a(this.F - paramInt);
      this.G = a(this.G - (i1 - this.F));
      i();
    }
    if (paramMarkerView == this.p)
    {
      if (this.G != this.F) {
        break label105;
      }
      this.F = a(this.F - paramInt);
    }
    label105:
    for (this.G = this.F;; this.G = a(this.G - paramInt))
    {
      j();
      f();
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ah != null) && (this.ah.a())) {
      this.ah.b();
    }
    super.finish();
  }
  
  public final void b()
  {
    this.D = this.n.getMeasuredWidth();
    if ((this.M != this.L) && (!this.B)) {
      f();
    }
    do
    {
      return;
      if (this.S)
      {
        f();
        return;
      }
    } while (this.N == 0);
    f();
  }
  
  public final void b(float paramFloat)
  {
    this.V = true;
    this.W = paramFloat;
    this.X = this.L;
    this.N = 0;
    this.aa = System.currentTimeMillis();
  }
  
  public final void b(MarkerView paramMarkerView)
  {
    this.B = false;
    if (paramMarkerView == this.o) {
      c(this.F - this.D / 2);
    }
    for (;;)
    {
      this.R.postDelayed(new t(this), 100L);
      return;
      c(this.G - this.D / 2);
    }
  }
  
  public final void b(MarkerView paramMarkerView, int paramInt)
  {
    this.B = true;
    if (paramMarkerView == this.o)
    {
      int i1 = this.F;
      this.F += paramInt;
      if (this.F > this.E) {
        this.F = this.E;
      }
      int i2 = this.G;
      this.G = (this.F - i1 + i2);
      if (this.G > this.E) {
        this.G = this.E;
      }
      i();
    }
    if (paramMarkerView == this.p)
    {
      this.G += paramInt;
      if (this.G > this.E) {
        this.G = this.E;
      }
      j();
    }
    f();
  }
  
  public final void c()
  {
    this.V = false;
    this.M = this.L;
    if (System.currentTimeMillis() - this.aa < 300L)
    {
      if (!this.S) {
        break label89;
      }
      int i1 = this.n.d((int)(this.W + this.L));
      if ((i1 >= this.O) && (i1 < this.Q)) {
        this.T.seekTo(i1 - this.P);
      }
    }
    else
    {
      return;
    }
    k();
    return;
    label89:
    e((int)(this.W + this.L));
  }
  
  public final void c(float paramFloat)
  {
    this.L = a((int)(this.X + (this.W - paramFloat)));
    f();
  }
  
  public final void d(float paramFloat)
  {
    this.V = false;
    this.M = this.L;
    this.N = ((int)-paramFloat);
    f();
  }
  
  public void finish()
  {
    a(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    if (paramInt1 == 2) {
      finish();
    }
    while (paramInt1 != 1) {
      return;
    }
    if (paramInt2 != -1)
    {
      finish();
      return;
    }
    if (paramIntent == null)
    {
      finish();
      return;
    }
    this.l = paramIntent.getData();
    paramIntent = managedQuery(this.l, null, "", null, null);
    if (paramIntent.getCount() == 0) {}
    for (paramIntent = (Intent)localObject;; paramIntent = paramIntent.getString(paramIntent.getColumnIndexOrThrow("_data")))
    {
      this.j = paramIntent;
      this.f = this.j;
      e();
      return;
      paramIntent.moveToFirst();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i1 = this.n.b();
    super.onConfigurationChanged(paramConfiguration);
    d();
    m();
    this.q.setText(this.h);
    this.r.setText(this.g);
    this.R.postDelayed(new s(this, i1), 500L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.j = null;
    this.l = null;
    this.T = null;
    this.S = false;
    paramBundle = getIntent();
    this.m = paramBundle.getBooleanExtra("was_get_content_intent", false);
    this.f = paramBundle.getData().toString();
    this.d = null;
    this.B = false;
    if (this.f.equals("record")) {}
    try
    {
      startActivityForResult(new Intent("android.provider.MediaStore.RECORD_SOUND"), 1);
      this.R = new Handler();
      d();
      this.R.postDelayed(this.ai, 100L);
      if (!this.f.equals("record")) {
        e();
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        a(paramBundle, 2130968675);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    paramMenu.add(0, 1, 0, 2130968635).setIcon(2130837555);
    paramMenu.add(0, 2, 0, 2130968636).setIcon(2130837554);
    return true;
  }
  
  protected void onDestroy()
  {
    Log.i("Ringdroid", "EditActivity OnDestroy");
    if ((this.T != null) && (this.T.isPlaying())) {
      this.T.stop();
    }
    this.T = null;
    if (this.j != null) {}
    try
    {
      if (!new File(this.j).delete()) {
        a(new Exception(), 2130968674);
      }
      getContentResolver().delete(this.l, null, null);
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        a(localSecurityException, 2130968674);
      }
    }
    if (this.ag != null) {
      this.ag.a();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 62)
    {
      e(this.F);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 1: 
      l();
      return true;
    case 2: 
      h();
      this.M = 0;
      f();
      return true;
    }
    a(this);
    return true;
  }
  
  public void onPause()
  {
    if (this.ag != null) {
      this.ag.b();
    }
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    paramMenu.findItem(1).setVisible(true);
    paramMenu.findItem(2).setVisible(true);
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.ag != null) {
      this.ag.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/RingtoneEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */