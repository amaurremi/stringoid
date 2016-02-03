package com.flurry.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class bn
  extends p
  implements DialogInterface.OnKeyListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, bm
{
  private ProgressDialog B;
  private Context J;
  private FlurryAds Q;
  private aj cJ;
  private final String d = getClass().getSimpleName();
  private int dA;
  private Dialog dB;
  private FrameLayout dC;
  private boolean dD;
  private boolean dE;
  private AlertDialog dF;
  private List<AdFrame> dG;
  private boolean dH;
  private Map<String, AdUnit> dI;
  private Map<String, cz> dJ;
  private Activity dK;
  private String dL = null;
  private List<String> dM;
  private View dh;
  private int di;
  private FrameLayout dk;
  private ce dt;
  private WebView du;
  private boolean dv;
  private WebViewClient dw;
  private WebChromeClient dx;
  private WebChromeClient.CustomViewCallback dy;
  private Dialog dz;
  
  bn(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, int paramInt)
  {
    super(paramContext, paramFlurryAds, paramcz);
    this.J = paramContext;
    if ((paramContext instanceof Activity)) {
      this.dK = ((Activity)paramContext);
    }
    setClickable(true);
    this.M = paramAdUnit;
    this.N = paramInt;
    this.L = paramcz;
    if (this.M != null)
    {
      this.dG = this.M.getAdFrames();
      if (this.M.getCombinable().intValue() != 1) {
        break label226;
      }
    }
    for (;;)
    {
      this.dH = bool;
      if (this.dH)
      {
        this.dJ = new HashMap();
        this.dI = new HashMap();
        this.dJ.put(paramcz.at(), paramcz);
        this.dI.put(((AdFrame)paramAdUnit.getAdFrames().get(0)).getAdGuid().toString(), paramAdUnit);
      }
      this.Q = paramFlurryAds;
      this.cJ = this.Q.cJ;
      this.M = this.M;
      this.L = this.L;
      this.dM = new LinkedList();
      return;
      label226:
      bool = false;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.dB == null) {
      return;
    }
    new StringBuilder().append("collapse(").append(paramInt1).append(",").append(paramInt2).append(")").toString();
    if ((this.dB != null) && (this.dB.isShowing()))
    {
      this.dB.hide();
      this.dB.setOnDismissListener(null);
      this.dB.dismiss();
    }
    this.dB = null;
    ax.a(this.dK, this.dA);
    if (this.dC != null)
    {
      if ((this.du != null) && (-1 != this.dC.indexOfChild(this.du))) {
        this.dC.removeView(this.du);
      }
      this.dC = null;
    }
    if ((this.du != null) && (this.du.getParent() == null)) {
      addView(this.du);
    }
    this.K.j(this.M.getAdSpace().toString());
  }
  
  private void ac()
  {
    if (ag()) {}
    try
    {
      ((Activity)this.J).finish();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      new StringBuilder().append("caught class cast exception: ").append(localClassCastException).toString();
    }
  }
  
  private String ae()
  {
    return ah().getDisplay().toString();
  }
  
  private String af()
  {
    return ah().getAdSpaceLayout().getFormat().toString();
  }
  
  private AdFrame ah()
  {
    return (AdFrame)this.dG.get(this.N);
  }
  
  private List<AdUnit> b(int paramInt1, int paramInt2)
  {
    List localList = this.cJ.b(this.M.getAdSpace().toString(), paramInt2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      AdUnit localAdUnit = (AdUnit)localIterator.next();
      if (localAdUnit.getAdFrames().size() > 0) {
        this.dI.put(((AdFrame)localAdUnit.getAdFrames().get(0)).getAdGuid().toString(), localAdUnit);
      }
    }
    return localList;
  }
  
  private static String f(List<AdUnit> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'{\"adComponents\":[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(bd.s(((AdFrame)((AdUnit)paramList.next()).getAdFrames().get(0)).getContent().toString()));
      if (paramList.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    localStringBuilder.append("]}'");
    return localStringBuilder.toString();
  }
  
  private cz u(String paramString)
  {
    if (this.dJ == null) {
      localObject = null;
    }
    cz localcz;
    do
    {
      return (cz)localObject;
      localcz = (cz)this.dJ.get(paramString);
      localObject = localcz;
    } while (localcz != null);
    Object localObject = cx.a(this.Q, paramString);
    this.dJ.put(paramString, localObject);
    return (cz)localObject;
  }
  
  private AdUnit v(String paramString)
  {
    if (this.dI == null) {
      return null;
    }
    return (AdUnit)this.dI.get(paramString);
  }
  
  final void a(String paramString, Map<String, String> paramMap, AdUnit paramAdUnit, cz paramcz, int paramInt1, int paramInt2)
  {
    new StringBuilder().append("fireEvent(event=").append(paramString).append(",params=").append(paramMap).append(")").toString();
    this.K.onEvent(new cw(paramString, paramMap, this.J, paramAdUnit, paramcz, paramInt1), this, paramInt2);
  }
  
  final boolean a(View paramView)
  {
    paramView = paramView.getParent();
    return (paramView != null) && (paramView == this);
  }
  
  final int ad()
  {
    return ah().getBinding().intValue();
  }
  
  final boolean ag()
  {
    return af().equals("takeover");
  }
  
  public final void initLayout(Context paramContext)
  {
    new StringBuilder().append("initLayout: ad creative layout: {width = ").append(ah().getAdSpaceLayout().getAdWidth()).append(", height = ").append(ah().getAdSpaceLayout().getAdHeight()).append("}").toString();
    removeAllViews();
    setFocusable(true);
    setFocusableInTouchMode(true);
    switch (ad())
    {
    default: 
      a("renderFailed", Collections.emptyMap(), this.M, this.L, this.N, 0);
      return;
    case 3: 
      if (this.dt == null)
      {
        this.dt = new ce(paramContext);
        this.dt.setOnPreparedListener(this);
        this.dt.setOnCompletionListener(this);
        this.dt.setOnErrorListener(this);
        this.dt.setMediaController(new MediaController(paramContext));
      }
      this.dt.setVideoURI(Uri.parse(ae()));
      db.c(this.d, "URI: " + Uri.parse(ae()).toString());
      this.dt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      addView(this.dt);
      ((RelativeLayout)this.dt.getParent()).setGravity(17);
      this.B = new ProgressDialog(paramContext);
      this.B.setProgressStyle(0);
      this.B.setMessage("Loading...");
      this.B.setCancelable(true);
      this.B.setOnKeyListener(this);
      this.B.show();
      return;
    }
    if (this.du == null)
    {
      this.du = new WebView(paramContext);
      this.du.getSettings().setJavaScriptEnabled(true);
      this.du.setVerticalScrollBarEnabled(false);
      this.du.setHorizontalScrollBarEnabled(false);
      this.du.setBackgroundColor(0);
      this.du.clearCache(false);
      this.dx = new cs(this);
      this.du.setWebChromeClient(this.dx);
      this.dw = new bz(this);
      this.du.setWebViewClient(this.dw);
    }
    a("rendered", Collections.emptyMap(), this.M, this.L, this.N, 0);
    if (ad() == 1) {
      if (this.dL != null) {
        this.du.loadUrl(this.dL);
      }
    }
    for (;;)
    {
      this.du.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      return;
      paramContext = ae();
      this.du.loadUrl(paramContext);
      continue;
      if (ad() == 2) {
        this.du.loadDataWithBaseURL("base://url/", ae(), "text/html", "utf-8", "base://url/");
      }
    }
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a("videoCompleted", Collections.emptyMap(), this.M, this.L, this.N, 0);
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.B != null) && (this.B.isShowing())) {
      this.B.dismiss();
    }
    a("renderFailed", Collections.emptyMap(), this.M, this.L, this.N, 0);
    removeView(this.dt);
    return false;
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    new StringBuilder().append("onkey,keycode=").append(paramInt).append(",event=").append(paramKeyEvent.getAction()).toString();
    boolean bool1 = bool2;
    if (paramDialogInterface == this.B)
    {
      bool1 = bool2;
      if (paramInt == 4)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0)
        {
          a("adWillClose", Collections.emptyMap(), this.M, this.L, this.N, 0);
          paramDialogInterface.dismiss();
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (ad() == 3)
    {
      if (this.B.isShowing()) {
        this.B.dismiss();
      }
      if ((this.dF == null) || (!this.dF.isShowing())) {
        this.dt.start();
      }
      a("rendered", Collections.emptyMap(), this.M, this.L, this.N, 0);
      a("videoStart", Collections.emptyMap(), this.M, this.L, this.N, 0);
    }
  }
  
  public final void performAction$3deb3ec3(af paramaf, FlurryAds paramFlurryAds, int paramInt)
  {
    String str = paramaf.bu;
    cw localcw = paramaf.bw;
    Object localObject2 = paramaf.bv;
    if (paramInt > 10)
    {
      new StringBuilder().append("Maximum depth for event/action loop exceeded when performing action:").append(str).append(",").append(localObject2).append(",triggered by:").append(localcw.eW).toString();
      return;
    }
    new StringBuilder().append("performAction(action=").append(str).append(",params=").append(paramaf.bv).append(",triggering event=").append(localcw.eW).append(")").toString();
    if (str.equals("nextAdUnit")) {}
    label181:
    int i;
    Object localObject1;
    for (;;)
    {
      try
      {
        paramFlurryAds = (ac)getParent();
        if (paramFlurryAds == null) {}
      }
      catch (ClassCastException paramFlurryAds)
      {
        long l;
        paramFlurryAds.toString();
        ac();
        if (ag()) {
          continue;
        }
        try
        {
          this.Q.d(this.J, this.M.getAdSpace().toString());
        }
        catch (Exception paramFlurryAds)
        {
          new StringBuilder().append("remove ad exception: ").append(paramFlurryAds).toString();
        }
        continue;
      }
      try
      {
        paramInt = Integer.parseInt((String)paramaf.bv.get("delay"));
        l = paramInt * 1000;
        paramFlurryAds.a(l);
        if ((!this.dM.contains(paramaf.bw.eW)) || (this.du == null)) {
          break;
        }
        this.du.loadUrl("javascript:flurryadapter.callComplete('" + paramaf.bw.eW + "');");
        this.dM.remove(paramaf.bw.eW);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramInt = 0;
        continue;
      }
      if (localNumberFormatException.equals("nextFrame"))
      {
        i = this.N + 1;
        paramFlurryAds = (String)((Map)localObject2).get("offset");
        paramInt = i;
        if (paramFlurryAds != null)
        {
          if (!paramFlurryAds.equals("next")) {
            break label560;
          }
          paramInt = this.N + 1;
        }
        for (;;)
        {
          a("clicked", Collections.emptyMap());
          if (this.dH) {
            break label625;
          }
          if ((paramInt == this.N) || (paramInt >= this.dG.size())) {
            break label181;
          }
          localObject1 = (AdFrame)this.M.getAdFrames().get(paramInt);
          paramFlurryAds = af();
          localObject1 = ((AdFrame)localObject1).getAdSpaceLayout().getFormat().toString();
          if (((String)localObject1).equals(paramFlurryAds)) {
            break label609;
          }
          if (!((String)localObject1).equals("takeover")) {
            break label181;
          }
          this.Q.b(this.L);
          this.Q.a(this.M);
          paramFlurryAds = new Intent(this.J, FlurryFullscreenTakeoverActivity.class);
          paramFlurryAds.putExtra("frameIndex", paramInt);
          this.Q.a(this.J, paramFlurryAds, this.M.getAdSpace().toString());
          break label181;
          label560:
          if (paramFlurryAds.equals("current")) {
            break;
          }
          try
          {
            paramInt = Integer.parseInt(paramFlurryAds);
          }
          catch (NumberFormatException paramFlurryAds)
          {
            new StringBuilder().append("caught: ").append(paramFlurryAds.getMessage()).toString();
            paramInt = i;
          }
        }
        label609:
        this.N = paramInt;
        initLayout(this.J);
        continue;
        label625:
        paramFlurryAds = (String)paramaf.bw.bv.get("guid");
        if (paramFlurryAds != null)
        {
          this.M = v(paramFlurryAds);
          this.dG = this.M.getAdFrames();
          this.L = paramaf.bw.L;
          if (ag())
          {
            this.Q.a(this.M);
            this.Q.b(this.L);
          }
          this.N = paramInt;
          this.dH = false;
          initLayout(this.J);
        }
      }
      else if (((String)localObject1).equals("closeAd"))
      {
        ac();
      }
      else
      {
        if (((String)localObject1).equals("notifyUser"))
        {
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.J);
          if ((((Map)localObject2).containsKey("message")) && (((Map)localObject2).containsKey("confirmDisplay")) && (((Map)localObject2).containsKey("cancelDisplay")))
          {
            paramFlurryAds = (String)((Map)localObject2).get("message");
            localObject1 = (String)((Map)localObject2).get("confirmDisplay");
          }
          for (localObject2 = (String)((Map)localObject2).get("cancelDisplay");; localObject2 = "OK")
          {
            localBuilder.setMessage(paramFlurryAds).setCancelable(false).setPositiveButton((CharSequence)localObject2, new bx(this, localcw, paramInt)).setNegativeButton((CharSequence)localObject1, new bt(this, localcw, paramInt));
            this.dF = localBuilder.create();
            if ((this.dt != null) && (ad() == 3)) {
              this.dt.pause();
            }
            this.dF.show();
            break;
            paramFlurryAds = "Are you sure?";
            localObject1 = "Cancel";
          }
        }
        if (!((String)localObject1).equals("loadAdComponents")) {
          break label1314;
        }
        int j = 1;
        int k = 3;
        paramInt = k;
        i = j;
        if (((Map)localObject2).containsKey("min"))
        {
          paramInt = k;
          i = j;
          if (!((Map)localObject2).containsKey("max")) {}
        }
        try
        {
          i = Integer.parseInt((String)((Map)localObject2).get("min"));
          paramInt = Integer.parseInt((String)((Map)localObject2).get("max"));
          this.M.getAdSpace().toString();
          paramFlurryAds = b(i, paramInt);
          if (paramFlurryAds.size() <= 0) {
            break label1288;
          }
          this.M.getAdSpace().toString();
          localObject1 = f(paramFlurryAds);
          if (this.du != null)
          {
            this.du.loadUrl("javascript:(function() {var multiadwraps=document.getElementsByClassName('multiAdWrap');if(multiadwraps.length>0){var template=document.getElementsByClassName('multiAdWrap')[0];var compiled=Hogan.compile(template.innerHTML);template.innerHTML='';template.innerHTML=compiled.render(JSON.parse(" + (String)localObject1 + "));}})();");
            this.du.loadUrl("javascript:flurryadapter.callComplete();");
          }
          paramFlurryAds = paramFlurryAds.iterator();
          while (paramFlurryAds.hasNext())
          {
            localObject1 = (AdUnit)paramFlurryAds.next();
            localObject2 = new HashMap();
            ((Map)localObject2).put("guid", ((AdFrame)((AdUnit)localObject1).getAdFrames().get(0)).getAdGuid().toString());
            a("rendered", (Map)localObject2, (AdUnit)localObject1, u(((AdFrame)((AdUnit)localObject1).getAdFrames().get(0)).getAdGuid().toString()), 0, 0);
          }
        }
        catch (NumberFormatException paramFlurryAds)
        {
          for (;;)
          {
            i = 1;
            paramInt = 3;
          }
        }
        if ((this.du != null) && (!a(this.du)))
        {
          addView(this.du);
          continue;
          label1288:
          a("renderFailed", Collections.emptyMap(), this.M, this.L, this.N, 0);
        }
      }
    }
    label1314:
    if (((String)localObject1).equals("doExpand"))
    {
      i = bd.l(this.J);
      paramInt = bd.m(this.J);
      if ((!paramaf.bw.bv.containsKey("width")) || (!paramaf.bw.bv.containsKey("height"))) {
        break label2004;
      }
    }
    label2004:
    for (;;)
    {
      try
      {
        i = bd.b(this.J, Integer.parseInt((String)paramaf.bw.bv.get("width")));
        paramInt = bd.b(this.J, Integer.parseInt((String)paramaf.bw.bv.get("height")));
        new StringBuilder().append("expand to width = ").append(i).append(" height = ").append(paramInt).toString();
        try
        {
          if ((ac)getParent() != null)
          {
            a("clicked", Collections.emptyMap());
            if (this.dB == null)
            {
              new StringBuilder().append("expand(").append(i).append(",").append(paramInt).append(")").toString();
              if ((this.du != null) && (-1 != indexOfChild(this.du))) {
                removeView(this.du);
              }
              this.dA = this.dK.getRequestedOrientation();
              if (this.dC == null)
              {
                this.dC = new FrameLayout(this.J);
                this.dC.setBackgroundColor(-16777216);
                if ((this.du != null) && (this.du.getParent() == null)) {
                  this.dC.addView(this.du, new FrameLayout.LayoutParams(-1, -1, 17));
                }
              }
              if (this.dB == null)
              {
                this.dB = new Dialog(this.J, 16973834);
                x.a(this.dB.getWindow());
                this.dB.setContentView(this.dC, new ViewGroup.LayoutParams(-1, -1));
                this.dB.setOnDismissListener(new bv(this));
                this.dB.setCancelable(true);
                this.dB.show();
              }
              ax.a(this.dK, ax.I(), true);
              this.K.b(this.M.getAdSpace().toString(), false);
            }
          }
          if (!paramaf.bw.bv.containsKey("url")) {
            break;
          }
          this.dL = ((String)paramaf.bw.bv.get("url"));
          initLayout(this.J);
        }
        catch (ClassCastException paramFlurryAds)
        {
          paramFlurryAds.getMessage();
        }
      }
      catch (NumberFormatException paramFlurryAds)
      {
        paramFlurryAds.getMessage();
        i = bd.l(this.J);
        paramInt = bd.m(this.J);
        continue;
      }
      if (((String)localObject1).equals("doCollapse"))
      {
        i = ah().getAdSpaceLayout().getAdWidth().intValue();
        paramInt = ah().getAdSpaceLayout().getAdHeight().intValue();
        i = bd.b(this.J, i);
        paramInt = bd.b(this.J, paramInt);
        if (this.dL != null)
        {
          this.dL = null;
          initLayout(this.J);
        }
        try
        {
          if ((ac)getParent() == null) {
            break;
          }
          a(i, paramInt);
        }
        catch (ClassCastException paramFlurryAds)
        {
          new StringBuilder().append("action doCollapse failed:").append(paramFlurryAds.getMessage()).toString();
        }
        break;
      }
      if (((String)localObject1).equals("directOpen")) {
        a("clicked", Collections.emptyMap());
      }
      this.K.performAction$3deb3ec3(paramaf, paramFlurryAds, paramInt);
      break;
    }
  }
  
  final boolean shouldRotate()
  {
    if (this.dB != null)
    {
      i = 1;
      if (i != 0) {
        break label38;
      }
      if (this.dz == null) {
        break label33;
      }
    }
    label33:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label38;
      }
      return true;
      i = 0;
      break;
    }
    label38:
    return false;
  }
  
  public final void stop()
  {
    if (ad() == 3)
    {
      if ((this.B != null) && (this.B.isShowing())) {
        this.B.dismiss();
      }
      if ((this.dt != null) && (this.dt.isPlaying())) {
        this.dt.stopPlayback();
      }
    }
    if (this.du != null)
    {
      if ((this.dh != null) && (this.dx != null)) {
        this.dx.onHideCustomView();
      }
      if (this.dB != null) {
        a(0, 0);
      }
      removeView(this.du);
      this.du.stopLoading();
      if (l.SDK_INT >= 11) {
        this.du.onPause();
      }
      this.du.destroy();
      this.du = null;
    }
    if (ag()) {
      a("adClosed", Collections.emptyMap(), this.M, this.L, this.N, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */