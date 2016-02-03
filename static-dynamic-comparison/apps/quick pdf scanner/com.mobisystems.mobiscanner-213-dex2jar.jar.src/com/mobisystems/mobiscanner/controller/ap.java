package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.a;
import com.drew.metadata.b;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.Image.RestrictMemory;
import com.mobisystems.mobiscanner.image.Image.a;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.photoimageview.TouchImageView;
import com.mobisystems.photoimageview.TouchImageView.a;
import com.mobisystems.photoimageview.TouchImageView.c;
import com.mobisystems.photoimageview.e.d;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ap
  extends SherlockFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, bh.a, TouchImageView.a, TouchImageView.c, e.d
{
  private Image aDo;
  private int aEA = -1;
  private ViewGroup aEB;
  private boolean aEC;
  private TextView aED;
  private Handler aEE = new Handler();
  private Runnable aEF = new Runnable()
  {
    public void run()
    {
      new ap.a(ap.this, ap.e(ap.this).getId()).execute(new Void[0]);
    }
  };
  private com.mobisystems.mobiscanner.model.c aEr;
  private TouchImageView aEs;
  private aq aEt;
  private boolean aEu = false;
  private boolean aEv = false;
  private float aEw = 1.0F;
  private float aEx = 0.0F;
  private float aEy = 0.0F;
  private int aEz = -1;
  private Activity mActivity;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  private void GH()
  {
    this.aEs.setOnClickListener(this);
    this.aEs.setOnLongClickListener(this);
    this.aEs.a(this);
    this.aEs.a(this);
  }
  
  private void GJ()
  {
    float f2 = 0.5F;
    Drawable localDrawable;
    int k;
    float f3;
    float f1;
    int j;
    int i;
    if (this.aEt != null)
    {
      localDrawable = this.aEs.getDrawable();
      k = this.aEs.KU();
      if ((!this.aEv) && (localDrawable != null)) {
        break label91;
      }
      f3 = this.aEw;
      f1 = this.aEx;
      f2 = this.aEy;
      j = this.aEA;
      i = this.aEz;
    }
    for (;;)
    {
      this.aEt.a(this.aEr.getId(), f3, f1, f2, i, j);
      return;
      label91:
      Matrix localMatrix = this.aEs.getImageMatrix();
      float[] arrayOfFloat = new float[9];
      localMatrix.getValues(arrayOfFloat);
      i = localDrawable.getIntrinsicWidth();
      j = localDrawable.getIntrinsicHeight();
      f3 = arrayOfFloat[0];
      float f4 = arrayOfFloat[2];
      f1 = arrayOfFloat[5];
      int m = this.aEs.getHeight();
      int n = this.aEs.getWidth();
      f4 = -f4;
      float f5 = n / 2;
      f1 = -f1;
      float f6 = m / 2;
      if (j * f3 <= m)
      {
        f1 = 0.5F;
        label198:
        if (i * f3 > n) {
          break label238;
        }
      }
      for (;;)
      {
        if (k != 90) {
          break label253;
        }
        f1 = 1.0F - f1;
        break;
        f1 = (f1 + f6) / (j * f3);
        break label198;
        label238:
        f2 = (f5 + f4) / (i * f3);
      }
      label253:
      if (k == 180)
      {
        f2 = 1.0F - f2;
        f4 = 1.0F - f1;
        f1 = f2;
        f2 = f4;
      }
      else if (k == 270)
      {
        f2 = 1.0F - f2;
      }
      else
      {
        f4 = f1;
        f1 = f2;
        f2 = f4;
      }
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.aEs.reset();
    }
    if ((-1 == paramInt2) || (-1 == paramInt1)) {}
    do
    {
      return;
      localObject = this.aEs.getDrawable();
    } while (localObject == null);
    int i = this.aEs.getMeasuredHeight();
    int j = this.aEs.getMeasuredWidth();
    int k = this.aEs.KU();
    int m = ((Drawable)localObject).getIntrinsicWidth();
    int n = ((Drawable)localObject).getIntrinsicHeight();
    Object localObject = new Matrix(this.aEs.getImageMatrix());
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f3 = arrayOfFloat[2];
    float f4 = arrayOfFloat[5];
    float f2 = arrayOfFloat[0];
    float f7 = paramFloat1 * paramInt1;
    float f8 = paramFloat1 * paramInt2;
    float f5 = f2 * m;
    float f6 = f2 * n;
    if (paramInt2 > paramInt1)
    {
      paramInt1 = 1;
      if (n <= m) {
        break label409;
      }
      paramInt2 = 1;
      label177:
      if (k != 270) {
        break label415;
      }
      paramFloat3 = 1.0F - paramFloat3;
    }
    for (;;)
    {
      label189:
      if ((paramInt1 != 0) && (paramInt2 == 0))
      {
        f1 = f7 / f6;
        paramFloat2 = paramFloat2 * f5 * f1;
        paramFloat3 = paramFloat3 * f6 * f1;
        paramFloat1 = paramFloat2;
        if (f5 * f1 < j) {
          paramFloat1 = paramFloat2 + (j - f5 * f1) / 2.0F;
        }
        paramFloat2 = paramFloat3;
        if (f6 * f1 < i) {
          paramFloat2 = paramFloat3 + (i - f6 * f1) / 2.0F;
        }
        paramFloat3 = j / 2;
        paramFloat2 -= i / 2;
        paramFloat1 -= paramFloat3;
      }
      for (paramFloat3 = f1 * f2;; paramFloat3 = f1 * f2)
      {
        if (n * paramFloat3 < i) {
          paramFloat2 = -(i - n * paramFloat3) / 2.0F;
        }
        if (m * paramFloat3 < j) {
          paramFloat1 = -(j - paramFloat3 * m) / 2.0F;
        }
        ((Matrix)localObject).postTranslate(-f3, -f4);
        ((Matrix)localObject).postScale(f1, f1, 0.0F, 0.0F);
        ((Matrix)localObject).postTranslate(-paramFloat1, -paramFloat2);
        this.aEs.setImageMatrix((Matrix)localObject);
        this.aEs.clearAnimation();
        return;
        paramInt1 = 0;
        break;
        label409:
        paramInt2 = 0;
        break label177;
        label415:
        if (k == 90)
        {
          paramFloat2 = 1.0F - paramFloat2;
          break label189;
        }
        if (k != 180) {
          break label679;
        }
        paramFloat1 = 1.0F - paramFloat3;
        paramFloat3 = 1.0F - paramFloat2;
        paramFloat2 = paramFloat1;
        break label189;
        if ((paramInt1 != 0) || (paramInt2 == 0)) {
          break label566;
        }
        f1 = f8 / f5;
        paramFloat2 = paramFloat2 * f5 * f1;
        paramFloat3 = paramFloat3 * f6 * f1;
        paramFloat1 = paramFloat2;
        if (f5 * f1 < j) {
          paramFloat1 = paramFloat2 + (j - f5 * f1) / 2.0F;
        }
        paramFloat2 = paramFloat3;
        if (f6 * f1 < i) {
          paramFloat2 = paramFloat3 + (i - f6 * f1) / 2.0F;
        }
        paramFloat3 = j / 2;
        paramFloat2 -= i / 2;
        paramFloat1 -= paramFloat3;
      }
      label566:
      paramFloat1 = j / (2.0F * f7);
      float f1 = paramFloat2 - i / (2.0F * f8);
      if (j > f7) {}
      for (paramFloat1 = paramFloat3 - f7 / (j * 2);; paramFloat1 = paramFloat3 - paramFloat1)
      {
        paramFloat3 = f1;
        if (i > f8) {
          paramFloat3 = paramFloat2 - f8 / (i * 2);
        }
        f1 = f7 / f5;
        f2 = f1 * f2;
        f5 = m;
        paramFloat2 = paramFloat3 * n * f2;
        paramFloat1 = paramFloat1 * f5 * f2;
        paramFloat3 = f2;
        break;
      }
      label679:
      paramFloat1 = paramFloat2;
      paramFloat2 = paramFloat3;
      paramFloat3 = paramFloat1;
    }
  }
  
  private void bi(boolean paramBoolean)
  {
    CheckBox localCheckBox;
    if ((this.aEt != null) && (!this.aEt.Gy()))
    {
      localCheckBox = (CheckBox)getView().findViewById(2131165452);
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 0;; i = 8)
    {
      localCheckBox.setVisibility(i);
      return;
    }
  }
  
  private void bj(boolean paramBoolean)
  {
    int i = 8;
    ImageView localImageView;
    int j;
    int k;
    if (this.aEt != null)
    {
      localImageView = (ImageView)getView().findViewById(2131165457);
      j = i;
      if (this.aEr.Jc() == -1L) {
        break label88;
      }
      if (paramBoolean) {
        i = 0;
      }
      j = i;
      if (this.aEr.Jd() == 1) {
        break label88;
      }
      k = 2130837783;
      j = i;
    }
    label88:
    for (i = k;; i = 2130837784)
    {
      localImageView.setVisibility(j);
      localImageView.setImageDrawable(getResources().getDrawable(i));
      return;
    }
  }
  
  private void bk(boolean paramBoolean)
  {
    int i = 8;
    ImageView localImageView;
    int j;
    int k;
    if (this.aEt != null)
    {
      localImageView = (ImageView)getView().findViewById(2131165456);
      j = i;
      if (this.aEr.Jw() == -1L) {
        break label90;
      }
      if (paramBoolean) {
        i = 0;
      }
      j = i;
      if (this.aEr.Jd() == 2) {
        break label90;
      }
      k = 2130837786;
      j = i;
    }
    label90:
    for (i = k;; i = 2130837785)
    {
      localImageView.setVisibility(j);
      localImageView.setImageDrawable(getResources().getDrawable(i));
      return;
    }
  }
  
  private void gn(int paramInt)
  {
    Object localObject1 = getView();
    if (localObject1 == null)
    {
      this.mLog.dl("setOcrStatus getView == NULL");
      return;
    }
    Object localObject2 = ((View)localObject1).findViewById(2131165453);
    if (localObject2 == null)
    {
      this.mLog.dl("setOcrStatus ocrStatusView == NULL");
      return;
    }
    localObject1 = (ImageView)((View)localObject2).findViewById(2131165454);
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131165455);
    if (paramInt >= 0)
    {
      ((ImageView)localObject1).clearAnimation();
      localImageView.clearAnimation();
      localImageView.setImageResource(2130837696);
      ((View)localObject2).setVisibility(8);
      this.aEr.gz(paramInt);
      return;
    }
    if (paramInt == -1)
    {
      localImageView.setImageResource(2130837696);
      ((View)localObject2).setVisibility(0);
      localObject2 = AnimationUtils.loadAnimation(getActivity(), 2130968576);
      Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968577);
      ((ImageView)localObject1).startAnimation((Animation)localObject2);
      localImageView.startAnimation(localAnimation);
      this.aEE.postDelayed(this.aEF, 10000L);
    }
    for (;;)
    {
      this.aEE.postDelayed(this.aEF, 10000L);
      break;
      if (paramInt == -2)
      {
        ((View)localObject2).setVisibility(0);
        ((ImageView)localObject1).clearAnimation();
        localImageView.clearAnimation();
        localImageView.setImageResource(2130837504);
        this.aEE.postDelayed(this.aEF, 10000L);
      }
    }
  }
  
  public void GI()
  {
    if (this.aEs != null) {
      GJ();
    }
  }
  
  public void GK()
  {
    k(getView(), 0);
  }
  
  public void GL()
  {
    if (this.aEv)
    {
      b(this.aEw, this.aEx, this.aEy, this.aEz, this.aEA, true);
      this.aEv = false;
    }
    this.aEs.bx(this.aEC);
    this.aEs.b(this.aED);
    k(getView(), 4);
  }
  
  public void GM()
  {
    if (this.aEt != null) {
      this.aEt.bh(true);
    }
  }
  
  public void GN()
  {
    if (this.aEt != null) {
      this.aEt.bh(false);
    }
  }
  
  public void GO()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle(2131296749);
    if (this.aDo == null) {
      return;
    }
    BufferedInputStream localBufferedInputStream = this.aDo.HZ();
    ArrayList localArrayList = new ArrayList();
    if (localBufferedInputStream == null) {}
    try
    {
      throw new IOException("Null image stream");
    }
    catch (ImageProcessingException localImageProcessingException)
    {
      localImageProcessingException.printStackTrace();
      Object localObject = new d[localArrayList.size()];
      localArrayList.toArray((Object[])localObject);
      localBuilder.setAdapter(new ArrayAdapter(getActivity(), 17367057, 16908308, (Object[])localObject), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ap.a(ap.this).dl("ImageDetailsListItem click");
        }
      });
      localBuilder.setPositiveButton(2131296831, this);
      localBuilder.create().show();
      return;
      localObject = a.a((BufferedInputStream)localObject, false).aC().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((b)((Iterator)localObject).next()).aB().iterator();
        while (localIterator.hasNext())
        {
          com.drew.metadata.e locale = (com.drew.metadata.e)localIterator.next();
          localArrayList.add(new d(locale.getTagName(), locale.getDescription()));
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void GP()
  {
    if (this.aEr.Jk() > 0)
    {
      double d1 = this.aEr.Jm();
      double d2 = this.aEr.Jl();
      Object localObject = this.aEr.Jq();
      localObject = Uri.parse("geo:0,0?q=" + d1 + "," + d2 + "(" + (String)localObject + ")");
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData((Uri)localObject);
      if (localIntent.resolveActivity(this.mActivity.getPackageManager()) != null) {
        startActivity(localIntent);
      }
      return;
    }
    Toast.makeText(this.mActivity, 2131296981, 1).show();
  }
  
  public long GQ()
  {
    return this.aEr.getId();
  }
  
  public com.mobisystems.mobiscanner.model.c GR()
  {
    return new com.mobisystems.mobiscanner.model.c(this.aEr);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.aEs != null)
    {
      if (this.aEs.getDrawable() != null)
      {
        b(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramBoolean);
        this.aEv = false;
      }
    }
    else {
      return;
    }
    this.aEv = true;
    this.aEw = paramFloat1;
    this.aEx = paramFloat2;
    this.aEy = paramFloat3;
    this.aEz = paramInt1;
    this.aEA = paramInt2;
  }
  
  public void b(TextView paramTextView)
  {
    this.aED = paramTextView;
  }
  
  public void d(com.mobisystems.mobiscanner.model.c paramc)
  {
    if (paramc != null)
    {
      this.aEr.gx(paramc.Jd());
      g(false, true);
      ((PageDetailActivity)getActivity()).bd(true);
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (this.aEt != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.aEs.getParent();
      this.aEs.bx(false);
      this.aEs.setImageDrawable(null);
      localViewGroup.removeView(this.aEs);
      this.aEs = new TouchImageView(getActivity());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.aEs.setId(2131165450);
      GH();
      this.aEv = true;
      localViewGroup.addView(this.aEs, 0, localLayoutParams);
      new c(null).execute(new Long[] { Long.valueOf(this.aEr.getId()) });
      if (!paramBoolean1) {
        break label166;
      }
      this.aEr.aL(-1L);
      paramBoolean2 = false;
      bj(paramBoolean2);
      if (!paramBoolean1) {
        break label190;
      }
      paramBoolean1 = bool;
    }
    for (;;)
    {
      bk(paramBoolean1);
      return;
      label166:
      if (this.aEr.Jc() != -1L)
      {
        paramBoolean2 = true;
        break;
      }
      paramBoolean2 = false;
      break;
      label190:
      paramBoolean1 = bool;
      if (this.aEr.Jw() != -1L) {
        paramBoolean1 = true;
      }
    }
  }
  
  protected void k(View paramView, int paramInt)
  {
    if (ProgressBar.class.isInstance(paramView)) {
      paramView = (ProgressBar)paramView;
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setIndeterminate(true);
        paramView.setVisibility(paramInt);
      }
      return;
      if (ViewGroup.class.isInstance(paramView)) {
        paramView = (ProgressBar)com.mobisystems.mobiscanner.common.d.a((ViewGroup)paramView, ProgressBar.class);
      } else {
        paramView = null;
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool2 = true;
    this.mLog.dl("onActivityCreated called, savedInstanceState=" + com.mobisystems.mobiscanner.common.d.ay(paramBundle));
    super.onActivityCreated(paramBundle);
    this.aEr = new com.mobisystems.mobiscanner.model.c(getArguments());
    this.aEs = ((TouchImageView)getView().findViewById(2131165450));
    GH();
    if (!this.aEt.Gy())
    {
      paramBundle = (CheckBox)getView().findViewById(2131165452);
      if (this.aEu) {
        break label224;
      }
      bool1 = true;
      bi(bool1);
      paramBundle.setChecked(this.aEt.X(this.aEr.getId()));
      paramBundle.setOnCheckedChangeListener(this);
      if (this.aEr.Jc() == -1L) {
        break label229;
      }
      bool1 = true;
      label153:
      bj(bool1);
      if (this.aEr.Jw() == -1L) {
        break label234;
      }
    }
    label224:
    label229:
    label234:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bk(bool1);
      ((ImageView)getView().findViewById(2131165457)).setOnClickListener(this);
      ((ImageView)getView().findViewById(2131165456)).setOnClickListener(this);
      gn(this.aEr.Jv());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label153;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach called");
    super.onAttach(paramActivity);
    if (aq.class.isInstance(paramActivity)) {
      this.aEt = ((aq)paramActivity);
    }
    this.mActivity = paramActivity;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    }
    this.aEt.a(this.aEr.getId(), paramBoolean);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = paramView.getId();
    int k = this.aEr.Jd();
    switch (j)
    {
    default: 
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j != 0) {
        new bh(this.aEr.getId(), i, this).execute(new Void[0]);
      }
      return;
      if (this.aEt == null) {
        break;
      }
      this.aEt.Gx();
      i = 0;
      j = 0;
      continue;
      if (1 != k)
      {
        j = 1;
        continue;
        if (2 != k)
        {
          j = 1;
          i = 2;
          continue;
        }
      }
      j = 1;
      i = 0;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mLog.dl("onConfigurationChanged called, orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    g(false, false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate called, savedInstanceState=" + com.mobisystems.mobiscanner.common.d.ay(paramBundle));
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mLog.dl("onCreateView called, savedInstanceState=" + com.mobisystems.mobiscanner.common.d.ay(paramBundle));
    return paramLayoutInflater.inflate(2130903112, paramViewGroup, false);
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach called");
    super.onDetach();
    this.mActivity = null;
    this.aEt = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    this.aEs.bx(false);
    this.aEs.setImageDrawable(null);
    super.onPause();
  }
  
  public void onReset()
  {
    b(this.aEw, this.aEx, this.aEy, this.aEz, this.aEA, false);
  }
  
  public void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
    g(false, true);
  }
  
  public void setFullscreen(boolean paramBoolean)
  {
    boolean bool = true;
    this.aEu = paramBoolean;
    if (!this.aEu)
    {
      paramBoolean = true;
      bi(paramBoolean);
      if (this.aEu) {
        break label55;
      }
      paramBoolean = true;
      label30:
      bj(paramBoolean);
      if (this.aEu) {
        break label60;
      }
    }
    label55:
    label60:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      bk(paramBoolean);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label30;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.aEC = paramBoolean;
    if (this.aEs != null) {
      this.aEs.bx(this.aEC);
    }
  }
  
  private class a
    extends AsyncTask<Void, Void, com.mobisystems.mobiscanner.model.c>
  {
    private final long axO;
    
    public a(long paramLong)
    {
      this.axO = paramLong;
    }
    
    protected com.mobisystems.mobiscanner.model.c b(Void... paramVarArgs)
    {
      return new DocumentModel().aj(this.axO);
    }
    
    protected void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      if (paramc == null)
      {
        ap.a(ap.this).dl("CheckForOCRUpdateTask result == NULL");
        return;
      }
      ap.a(ap.this, paramc.Jv());
    }
  }
  
  private class b
    extends AsyncTask<Image, Void, InputStream>
  {
    int aEI = 0;
    
    private b() {}
    
    protected InputStream b(Image... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      ImageOrientation localImageOrientation = paramVarArgs.HW().Ic();
      switch (ap.3.aDw[localImageOrientation.ordinal()])
      {
      }
      for (;;)
      {
        ap.c(ap.this).gJ(this.aEI);
        return paramVarArgs.HZ();
        this.aEI = 180;
        continue;
        this.aEI = 270;
        continue;
        this.aEI = 90;
      }
    }
    
    protected void d(InputStream paramInputStream)
    {
      switch (ap.3.aEH[ap.b(ap.this).HY().ordinal()])
      {
      default: 
        ap.c(ap.this).setImageBitmap(ap.b(ap.this).a(-1, -1, null, Image.RestrictMemory.aHw));
        return;
      }
      com.mobisystems.photoimageview.e.a(ap.c(ap.this), paramInputStream, null, ap.this, ap.d(ap.this), this.aEI);
    }
  }
  
  private class c
    extends AsyncTask<Long, Void, Image>
  {
    private c() {}
    
    protected void b(Image paramImage)
    {
      new ap.b(ap.this, null).execute(new Image[] { paramImage });
    }
    
    protected Image d(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      paramVarArgs = new DocumentModel();
      ap.a(ap.this, paramVarArgs.aq(l));
      return ap.b(ap.this);
    }
  }
  
  private class d
  {
    private String aEJ;
    private String aEK;
    private String aEL;
    
    public d(String paramString1, String paramString2)
    {
      this.aEJ = paramString1;
      this.aEK = paramString2;
    }
    
    public String toString()
    {
      if (this.aEL == null) {
        this.aEL = (this.aEJ + " : " + this.aEK);
      }
      return this.aEL;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */