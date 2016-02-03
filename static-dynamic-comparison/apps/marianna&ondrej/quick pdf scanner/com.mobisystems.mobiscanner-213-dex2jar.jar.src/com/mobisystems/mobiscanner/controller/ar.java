package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.common.util.b;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.g;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.view.CropImageView;
import com.mobisystems.mobiscanner.view.CropImageView.b;
import java.util.List;

public class ar
  extends SherlockFragment
  implements View.OnClickListener, ad, CropImageView.b
{
  private CropImageView aEX;
  private ProgressDialog aEY;
  private ac aEZ;
  private com.mobisystems.mobiscanner.model.c aEr;
  private h aFa = null;
  private boolean aFb = false;
  private float aFc = 0.0F;
  private TextView aFd;
  private boolean axQ = false;
  private PageEnhanceActivity azT;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  private void Ha()
  {
    this.aEY = new ProgressDialog(this.azT);
    this.aEY.setIndeterminate(true);
    this.aEY.setMessage("Processing...");
    this.aEY.show();
  }
  
  private void He()
  {
    if (this.aFd != null) {
      this.aFd.animate().setDuration(1000L).alpha(0.0F);
    }
  }
  
  private void Hf()
  {
    if (this.aFd != null)
    {
      this.aFd.animate().cancel();
      this.aFd.setAlpha(1.0F);
    }
  }
  
  public void B(float paramFloat)
  {
    this.azT.B(paramFloat);
    if (this.aFd == null) {
      this.aFd = ((TextView)getView().findViewById(2131165459));
    }
    this.aFd.setText(String.valueOf(paramFloat));
    Hf();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        ar.a(ar.this);
      }
    }, 500L);
  }
  
  public void C(float paramFloat)
  {
    if (this.aEX != null)
    {
      this.aEX.C(paramFloat);
      return;
    }
    this.aFc = paramFloat;
  }
  
  public void El()
  {
    this.aEX.i(this.aEZ);
    GZ();
  }
  
  public void GY()
  {
    if (this.aEX != null)
    {
      this.aEX.GY();
      if (this.aEY != null)
      {
        this.aEY.dismiss();
        this.aEY = null;
      }
      return;
    }
    this.aFa = null;
    this.aFb = true;
  }
  
  public void GZ()
  {
    Ha();
    this.axQ = false;
    this.aEZ.f(true, true);
  }
  
  public void Gv()
  {
    this.mLog.dl("onPageImageLoaded");
    if (this.aEZ == null) {
      new a(null).execute(new Long[] { Long.valueOf(this.aEr.getId()) });
    }
  }
  
  public h Hb()
  {
    if (this.aEX != null)
    {
      List localList = this.aEX.JR();
      if (localList != null) {
        return new h(null, localList);
      }
    }
    return null;
  }
  
  public boolean Hc()
  {
    return this.aEX.JV();
  }
  
  public void Hd()
  {
    this.aEX.JW();
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, List<b> paramList, int paramInt)
  {
    Drawable localDrawable = this.aEX.getDrawable();
    if (localDrawable != null)
    {
      int i = localDrawable.getIntrinsicWidth();
      this.mLog.dl("drawableW = " + i + " ; usedBitmapW = " + paramInt);
      this.aEX.T(i / paramInt);
      if (this.aFb)
      {
        if (this.aFa == null) {
          break label177;
        }
        this.aEX.e(this.aFa);
      }
    }
    for (;;)
    {
      if (this.aEY != null)
      {
        this.aEY.dismiss();
        this.aEY = null;
      }
      if (this.aFc > 0.0F) {
        this.aEX.C(this.aFc);
      }
      new be(paramList).execute(new Long[] { Long.valueOf(this.aEr.getId()) });
      this.aEX.s(paramList);
      return;
      label177:
      this.aEX.GY();
    }
  }
  
  public void a(com.mobisystems.mobiscanner.model.c paramc) {}
  
  public void e(h paramh)
  {
    paramh = new h(paramh);
    if (this.aEX != null)
    {
      this.aEX.e(paramh);
      if (this.aEY != null)
      {
        this.aEY.dismiss();
        this.aEY = null;
      }
      return;
    }
    this.aFa = paramh;
    this.aFb = true;
  }
  
  public void f(h paramh)
  {
    if (this.aEX != null)
    {
      paramh = new h(paramh);
      this.aEX.f(paramh);
    }
  }
  
  public void m(List<h> paramList)
  {
    if (this.aEr.getId() > 0L)
    {
      this.mLog.dl("onQuadInfoAvailable size = " + paramList.size());
      if (paramList.size() <= 0) {
        break label132;
      }
      paramList = (h)paramList.get(0);
      if ((this.aFa == null) && (this.aEr.Jx() < 2))
      {
        new bf(paramList).execute(new Long[] { Long.valueOf(this.aEr.getId()) });
        e(paramList);
        if (this.azT != null) {
          this.azT.d(paramList);
        }
      }
    }
    return;
    label132:
    if (!this.axQ)
    {
      this.axQ = true;
      this.aEZ.f(false, false);
      return;
    }
    GY();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mLog.dl("onActivityCreated called, savedInstanceState=" + d.ay(paramBundle));
    super.onActivityCreated(paramBundle);
    this.aEr = new com.mobisystems.mobiscanner.model.c(getArguments());
    this.aEX = ((CropImageView)getView().findViewById(2131165458));
    this.azT.GW().a(this.aEr.IU(), this.aEX);
    this.aEX.a(this);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach called");
    super.onAttach(paramActivity);
    if (PageEnhanceActivity.class.isInstance(paramActivity)) {
      this.azT = ((PageEnhanceActivity)paramActivity);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mLog.dl("onConfigurationChanged called, orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate called, savedInstanceState=" + d.ay(paramBundle));
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mLog.dl("onCreateView called, savedInstanceState=" + d.ay(paramBundle));
    return paramLayoutInflater.inflate(2130903113, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.aEX.setImageDrawable(null);
    if (this.aEY != null)
    {
      this.aEY.dismiss();
      this.aEY = null;
    }
    super.onDestroy();
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach called");
    super.onDetach();
    this.azT = null;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
  }
  
  public void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
  }
  
  public void r(List<Point> paramList)
  {
    paramList = new h(null, paramList);
    this.azT.c(paramList);
  }
  
  private class a
    extends AsyncTask<Long, Void, Image>
  {
    private a() {}
    
    protected void b(Image paramImage)
    {
      ar.a(ar.this, new ac(paramImage, ar.b(ar.this), ar.this, ar.c(ar.this).getId(), true));
    }
    
    protected Image d(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      return new DocumentModel().ao(l);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */