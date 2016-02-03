package com.mobisystems.mobiscanner.controller;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.api.a.a.a.b;
import com.google.api.a.a.a.b.a;
import com.google.api.a.a.a.b.b;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.i;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.t;
import com.jfeinstein.jazzyviewpager.ImageViewPager.f;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.OCRLanguage;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.ImageProcessing.ImageOperation;
import com.mobisystems.mobiscanner.image.g.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.view.GalleryViewPager;
import com.mobisystems.photoimageview.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class PageDetailActivity
  extends SherlockFragmentActivity
  implements View.OnClickListener, View.OnLongClickListener, View.OnSystemUiVisibilityChangeListener, c.c, c.d, ImageViewPager.f, aq, ba.a, k, g.c
{
  private int Eo;
  private com.google.api.client.googleapis.extensions.android.gms.auth.a aAL;
  private Menu aAk;
  private AdView aAr;
  private boolean aBE = false;
  private Object aBF = new Object();
  private String aDI;
  private com.google.api.a.a.a aDJ;
  private int aDX;
  private long aDY = -1L;
  private long aDZ = -1L;
  private String aEa = "";
  private GalleryViewPager aEb;
  private ap aEc;
  private com.mobisystems.mobiscanner.image.g aEd = null;
  private boolean aEe;
  private boolean aEf = false;
  private boolean aEg = false;
  private int aEh = -1;
  private int aEi = -1;
  private int aEj = -1;
  private int aEk;
  private boolean aEl = false;
  private float alP = 1.0F;
  private com.mobisystems.mobiscanner.model.b axZ;
  private SparseArray<ap> azV;
  private HashSet<Long> mCheckedIds;
  private boolean mIsPaidForAdsRemoval = false;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  private boolean mResumed = false;
  private float mTranslationX = 0.0F;
  private float mTranslationY = 0.0F;
  
  public static String DH()
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = localRandom.nextInt(10);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)(localRandom.nextInt(96) + 32));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void Ef()
  {
    ActionBar localActionBar = getSupportActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(true);
    localActionBar.setBackgroundDrawable(getResources().getDrawable(2130837886));
  }
  
  private void Er()
  {
    Object localObject2 = getSupportActionBar();
    Object localObject1;
    if (this.aEf) {
      localObject1 = findViewById(2131165312);
    }
    for (;;)
    {
      if (this.aEf)
      {
        localObject2 = String.format(getResources().getString(2131297012), new Object[] { Integer.valueOf(this.mCheckedIds.size()) });
        ((TextView)((View)localObject1).findViewById(2131165315)).setText((CharSequence)localObject2);
        label69:
        if (this.Eo != 1) {
          break label231;
        }
        localObject1 = (ViewGroup)findViewById(2131165326);
      }
      for (;;)
      {
        label87:
        if (((this.aEf) || (this.aEg)) && (this.Eo != 1)) {
          ((TextView)((ViewGroup)localObject1).findViewById(2131165318)).setText(this.aDX + "/" + this.axZ.IL());
        }
        for (;;)
        {
          if (this.aAk != null) {
            onPrepareOptionsMenu(this.aAk);
          }
          return;
          if (!this.aEg) {
            break label341;
          }
          localObject1 = findViewById(2131165319);
          break;
          if (this.aEg)
          {
            ((TextView)((View)localObject1).findViewById(2131165315)).setText(this.axZ.getName());
            break label69;
          }
          ((ActionBar)localObject2).setTitle(this.axZ.getName());
          break label69;
          label231:
          if ((this.aEf) || (this.aEg))
          {
            localObject1 = (ViewGroup)localObject1;
            break label87;
          }
          if (this.aAk == null) {
            break label336;
          }
          localObject1 = (ViewGroup)this.aAk.findItem(2131165559).getActionView();
          break label87;
          if (localObject1 != null) {
            ((TextView)((ViewGroup)localObject1).findViewById(2131165327)).setText(this.aDX + "/" + this.axZ.IL());
          }
        }
        label336:
        localObject1 = null;
      }
      label341:
      localObject1 = null;
    }
  }
  
  private void Es()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131165326);
    int j = localViewGroup.getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = localViewGroup.getChildAt(i);
      if (localView != null)
      {
        localView.setOnClickListener(this);
        localView.setOnLongClickListener(this);
      }
      i += 1;
    }
    if (this.aEf) {
      localViewGroup = (ViewGroup)findViewById(2131165312);
    }
    for (;;)
    {
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localView = localViewGroup.getChildAt(i);
            if (localView != null)
            {
              localView.setOnClickListener(this);
              localView.setOnLongClickListener(this);
            }
            i += 1;
            continue;
            if (!this.aEg) {
              break label150;
            }
            localViewGroup = (ViewGroup)findViewById(2131165319);
            break;
          }
        }
      }
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
      return;
      label150:
      localViewGroup = null;
    }
  }
  
  private void Fn()
  {
    if (!this.mIsPaidForAdsRemoval) {
      this.aAr = com.mobisystems.mobiscanner.common.d.a(this, (ViewGroup)findViewById(2131165299), this.aAr, "_pd", false, true);
    }
  }
  
  private void GA()
  {
    this.aEf = false;
    getSupportActionBar().show();
    findViewById(2131165326).setBackgroundResource(2131427372);
    findViewById(2131165326).bringToFront();
    findViewById(2131165312).clearAnimation();
    findViewById(2131165312).setVisibility(8);
    this.mCheckedIds.clear();
    Gz();
  }
  
  private void GB()
  {
    android.support.v4.view.l locall = this.aEb.D();
    if (locall != null) {
      gm(locall.getCount() - 1 - this.aEb.F());
    }
  }
  
  private void GC()
  {
    this.aDZ = this.aEd.gv(this.aDX).getId();
    b(new as(), "PAGE_EXPORT_FOR_EDIT");
  }
  
  private void GD()
  {
    b(new ay(), "PAGE_RESET");
  }
  
  private void GE()
  {
    Intent localIntent = new Intent(this, PageGridActivity.class);
    localIntent.addFlags(67108864);
    this.axZ.f(localIntent);
    setResult(-1, localIntent);
    finish();
  }
  
  private void GF()
  {
    if (this.aEf)
    {
      long[] arrayOfLong = new long[this.mCheckedIds.size()];
      Object localObject = this.mCheckedIds.iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        arrayOfLong[i] = ((Long)((Iterator)localObject).next()).longValue();
        i += 1;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("PAGE_SELECTION_MODE_RESULT", arrayOfLong);
      ((Intent)localObject).putExtra("PAGE_DETAIL_DOC_ID", this.axZ.getId());
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  private void GG()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          DocumentModel localDocumentModel = new DocumentModel();
          long l = PageDetailActivity.d(PageDetailActivity.this).GQ();
          com.mobisystems.mobiscanner.model.c localc = localDocumentModel.aj(l);
          File localFile = new File(localDocumentModel.aq(l).Ia().getPath());
          CommonPreferences.OCRLanguage localOCRLanguage = localc.Jt();
          Object localObject = localOCRLanguage;
          if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh))
          {
            localOCRLanguage = PageDetailActivity.h(PageDetailActivity.this).IQ();
            localObject = localOCRLanguage;
            if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh)) {
              localObject = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apW.Dl());
            }
          }
          String str = PageDetailActivity.a(PageDetailActivity.this, localFile, ((CommonPreferences.OCRLanguage)localObject).getValue());
          localOCRLanguage = localc.Ju();
          localObject = localOCRLanguage;
          if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh))
          {
            localOCRLanguage = PageDetailActivity.h(PageDetailActivity.this).IR();
            localObject = localOCRLanguage;
            if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh)) {
              localObject = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apX.Dl());
            }
          }
          localObject = PageDetailActivity.a(PageDetailActivity.this, localFile, ((CommonPreferences.OCRLanguage)localObject).getValue());
          localDocumentModel.a(l, str, (String)localObject);
          localc.dS(str);
          localc.dT((String)localObject);
          PageDetailActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                AlertDialog.Builder localBuilder = new AlertDialog.Builder(PageDetailActivity.this);
                localBuilder.setTitle(2131296755);
                localBuilder.setPositiveButton(2131296831, null);
                localBuilder.create().show();
                Toast.makeText(PageDetailActivity.this, 2131296755, 1).show();
                return;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          });
          return;
        }
        catch (UserRecoverableAuthIOException localUserRecoverableAuthIOException)
        {
          PageDetailActivity.this.startActivityForResult(localUserRecoverableAuthIOException.getIntent(), 4);
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }).start();
  }
  
  private void Gt()
  {
    if (this.aEd == null)
    {
      this.aEd = new com.mobisystems.mobiscanner.image.g(getApplicationContext(), getSupportFragmentManager(), this.axZ);
      this.aEd.a(this);
      return;
    }
    this.aEd.d(this.axZ, true);
  }
  
  private void Gw()
  {
    Object localObject = this.aEc.GR();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, 2131361880));
    localBuilder.setTitle(2131296756);
    View localView = getLayoutInflater().inflate(2130903105, null);
    final EditText localEditText = (EditText)localView.findViewById(2131165430);
    StringBuilder localStringBuilder = new StringBuilder();
    if (((com.mobisystems.mobiscanner.model.c)localObject).Jk() > 0) {
      localStringBuilder.append(((com.mobisystems.mobiscanner.model.c)localObject).Jq());
    }
    localStringBuilder.append("\n");
    if (((com.mobisystems.mobiscanner.model.c)localObject).Jv() > 0)
    {
      localStringBuilder.append(((com.mobisystems.mobiscanner.model.c)localObject).Jr());
      localStringBuilder.append("\n");
      localStringBuilder.append(((com.mobisystems.mobiscanner.model.c)localObject).Js());
    }
    localEditText.setText(localStringBuilder.toString());
    localBuilder.setView(localView);
    localObject = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = String.valueOf(localEditText.getText());
        com.mobisystems.mobiscanner.common.d.l(PageDetailActivity.this, paramAnonymousDialogInterface);
      }
    };
    localBuilder.setNegativeButton(2131296839, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.setPositiveButton(2131296838, (DialogInterface.OnClickListener)localObject);
    localBuilder.create().show();
  }
  
  private void Gz()
  {
    int i;
    if (this.aEe)
    {
      findViewById(2131165299).setVisibility(8);
      getSupportActionBar().hide();
      bg(false);
      bf(false);
      if (com.mobisystems.mobiscanner.common.d.DC())
      {
        i = 5894;
        getWindow().getDecorView().setSystemUiVisibility(i);
      }
    }
    label105:
    label273:
    label283:
    do
    {
      return;
      i = 1797;
      break;
      findViewById(2131165299).setVisibility(0);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      View localView = null;
      if (this.aEf)
      {
        localView = findViewById(2131165312);
        if ((!this.aEf) && (!this.aEg)) {
          break label273;
        }
        localView.bringToFront();
        bg(true);
      }
      for (;;)
      {
        if (this.Eo != 1) {
          break label283;
        }
        bf(true);
        if ((this.aEf) || (this.aEg))
        {
          localView.findViewById(2131165318).setVisibility(8);
          localView.findViewById(2131165317).setVisibility(8);
          localView.findViewById(2131165316).setVisibility(8);
        }
        if (this.aAk == null) {
          break;
        }
        this.aAk.findItem(2131165559).setVisible(false);
        this.aAk.findItem(2131165562).setVisible(false);
        this.aAk.findItem(2131165563).setVisible(false);
        return;
        if (!this.aEg) {
          break label105;
        }
        localView = findViewById(2131165319);
        break label105;
        getSupportActionBar().show();
      }
      bf(false);
      if ((this.aEf) || (this.aEg))
      {
        localView.findViewById(2131165318).setVisibility(0);
        localView.findViewById(2131165317).setVisibility(0);
        localView.findViewById(2131165316).setVisibility(0);
      }
    } while (this.aAk == null);
    this.aAk.findItem(2131165559).setVisible(true);
    this.aAk.findItem(2131165562).setVisible(true);
    this.aAk.findItem(2131165563).setVisible(true);
  }
  
  private com.google.api.a.a.a a(com.google.api.client.googleapis.extensions.android.gms.auth.a parama)
  {
    return new com.google.api.a.a.a.a(com.google.api.client.a.a.a.a.wI(), new com.google.api.client.json.gson.a(), parama).yY();
  }
  
  private static InputStream a(com.google.api.a.a.a parama, com.google.api.a.a.a.a parama1)
  {
    parama1 = (String)parama1.zb().get("text/plain");
    System.out.println("url = " + parama1);
    if ((parama1 != null) && (parama1.length() > 0)) {
      try
      {
        parama = parama.wY().f(new i(parama1)).xJ().getContent();
        return parama;
      }
      catch (IOException parama)
      {
        parama.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private String a(File paramFile, String paramString)
  {
    paramFile = new com.google.api.client.http.g("image/jpeg", paramFile);
    Object localObject = new com.google.api.a.a.a.a();
    ((com.google.api.a.a.a.a)localObject).cH(DH());
    ((com.google.api.a.a.a.a)localObject).cG("image/jpeg");
    paramFile = (com.google.api.a.a.a.a)this.aDJ.yX().a((com.google.api.a.a.a.a)localObject, paramFile).e(Boolean.valueOf(true)).d(Boolean.valueOf(true)).cE(paramString).xe();
    if (paramFile != null)
    {
      localObject = a(this.aDJ, paramFile);
      if (localObject == null)
      {
        this.mLog.dl("Stream from gDrive is NULL");
        return "";
      }
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject));
      paramString = new StringBuilder();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        paramString.append(str);
      }
      try
      {
        ((InputStream)localObject).close();
        a(this.aDJ, paramFile.getId());
        return paramString.toString();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    return "";
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, Animation.AnimationListener paramAnimationListener)
  {
    if (paramView != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
      localAlphaAnimation.setDuration(300L);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setFillAfter(true);
      if (paramAnimationListener != null) {
        localAlphaAnimation.setAnimationListener(paramAnimationListener);
      }
      paramView.clearAnimation();
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  private static void a(com.google.api.a.a.a parama, String paramString)
  {
    try
    {
      parama.yX().cD(paramString).xe();
      return;
    }
    catch (IOException parama)
    {
      System.out.println("An error occurred: " + parama);
    }
  }
  
  private void a(ImageProcessing.ImageOperation paramImageOperation)
  {
    com.mobisystems.mobiscanner.model.c localc = this.aEd.gv(this.aDX);
    if (localc != null) {
      new ba(localc, this).execute(new ImageProcessing.ImageOperation[] { paramImageOperation });
    }
  }
  
  private void b(bd parambd, String paramString)
  {
    this.mLog.dl("startPageProgressTask: action=" + paramString);
    com.mobisystems.mobiscanner.model.c localc = this.aEd.gv(this.aDX);
    if (localc != null)
    {
      long l = localc.getId();
      this.aDY = l;
      Bundle localBundle = new Bundle();
      localc.p(localBundle);
      localBundle.putLongArray("PAGES", new long[] { l });
      parambd.setArguments(localBundle);
      parambd.show(getSupportFragmentManager(), paramString);
    }
  }
  
  private void be(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131165326);
    int j = localViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (localView != null) {
        localView.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  private void bf(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131165326);
    if (paramBoolean)
    {
      if (this.Eo == 1) {
        localViewGroup.setVisibility(0);
      }
      c(localViewGroup, true);
      return;
    }
    c(localViewGroup, false);
    localViewGroup.setVisibility(8);
  }
  
  private void bg(boolean paramBoolean)
  {
    ViewGroup localViewGroup = null;
    if (this.aEf) {
      localViewGroup = (ViewGroup)findViewById(2131165312);
    }
    for (;;)
    {
      if (localViewGroup != null)
      {
        if (!paramBoolean) {
          break;
        }
        localViewGroup.setVisibility(0);
        d(localViewGroup, true);
      }
      return;
      if (this.aEg) {
        localViewGroup = (ViewGroup)findViewById(2131165319);
      }
    }
    d(localViewGroup, false);
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1;
    if (paramView != null)
    {
      if (!paramBoolean) {
        break label27;
      }
      f1 = 0.0F;
      if (!paramBoolean) {
        break label32;
      }
    }
    for (;;)
    {
      a(paramView, f1, f2, null);
      return;
      label27:
      f1 = 1.0F;
      break;
      label32:
      f2 = 0.0F;
    }
  }
  
  private void d(final View paramView, boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (paramView != null) {
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      if (paramBoolean) {
        f2 = 1.0F;
      }
      Animation.AnimationListener local3 = null;
      if (!paramBoolean) {
        local3 = new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            paramView.clearAnimation();
            paramView.setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        };
      }
      a(paramView, f1, f2, local3);
      return;
    }
  }
  
  private boolean gm(int paramInt)
  {
    boolean bool2 = false;
    paramInt = this.aEb.F() + paramInt;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.aEb.D().getCount())
      {
        this.aEb.a(paramInt, false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void r(Bundle paramBundle)
  {
    int j = 0;
    this.aEf = true;
    getSupportActionBar().hide();
    findViewById(2131165326).setBackgroundResource(2131427359);
    findViewById(2131165312).setVisibility(0);
    findViewById(2131165312).bringToFront();
    int k;
    int i;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getLongArray("PAGE_SELECTION_MODE_INITIAL");
      if (paramBundle != null)
      {
        k = paramBundle.length;
        i = 0;
        while (i < k)
        {
          long l = paramBundle[i];
          this.mCheckedIds.add(Long.valueOf(l));
          i += 1;
        }
      }
    }
    if (this.mCheckedIds.isEmpty()) {
      GA();
    }
    paramBundle = (ViewGroup)findViewById(2131165312);
    if (paramBundle != null)
    {
      k = paramBundle.getChildCount();
      i = j;
      while (i < k)
      {
        View localView = paramBundle.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(this);
          localView.setOnLongClickListener(this);
        }
        i += 1;
      }
    }
    Gz();
  }
  
  public void Gu()
  {
    this.mLog.dl("onPageListLoaded called");
    this.azV.clear();
    b localb = new b(getSupportFragmentManager());
    this.aEb.a(localb);
    this.aEb.a(this);
    this.aEb.j(this.aDX - 1);
    Er();
    be(true);
    this.aEb.fB(1);
  }
  
  public void Gv()
  {
    this.aEc.a(this.alP, this.mTranslationX, this.mTranslationY, this.aEi, this.aEj, true);
  }
  
  public void Gx()
  {
    int i = 0;
    if (!this.aEe) {}
    for (boolean bool = true;; bool = false)
    {
      this.aEe = bool;
      Gz();
      while (i < this.azV.size())
      {
        int j = this.azV.keyAt(i);
        ap localap = (ap)this.azV.get(j);
        if (localap != null) {
          localap.setFullscreen(this.aEe);
        }
        i += 1;
      }
    }
    this.aEc.setFullscreen(this.aEe);
  }
  
  public boolean Gy()
  {
    return this.aEg;
  }
  
  public boolean X(long paramLong)
  {
    return this.mCheckedIds.contains(Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == -1) || (paramInt1 == -1)) {
      return;
    }
    this.alP = paramFloat1;
    this.mTranslationX = paramFloat2;
    this.mTranslationY = paramFloat3;
    this.aEi = paramInt1;
    this.aEj = paramInt2;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!this.aEg)
    {
      if (!paramBoolean) {
        break label40;
      }
      this.mCheckedIds.add(Long.valueOf(paramLong));
      if (!this.aEf) {
        r(null);
      }
    }
    for (;;)
    {
      Er();
      return;
      label40:
      this.mCheckedIds.remove(Long.valueOf(paramLong));
      if (this.mCheckedIds.isEmpty()) {
        GA();
      }
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(com.google.android.gms.common.b paramb) {}
  
  public void bd(boolean paramBoolean)
  {
    MenuItem localMenuItem;
    if (this.aAk != null)
    {
      localMenuItem = this.aAk.findItem(2131165568);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = 2131492870;; i = 2131492871)
    {
      localMenuItem.getIcon().setAlpha(getResources().getInteger(i));
      localMenuItem.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void bh(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = 1)
    {
      gm(i);
      return;
    }
  }
  
  public void bl(int paramInt) {}
  
  public void c(com.mobisystems.mobiscanner.model.c paramc)
  {
    if (this.aEc != null)
    {
      this.aEc.g(false, true);
      this.aEd.bo(false);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      Menu localMenu = this.aAk;
      if ((!this.aEf) && (!this.aEg) && (localMenu != null) && (localMenu.findItem(2131165556) != null))
      {
        localMenu.performIdentifierAction(2131165556, 0);
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void g(int paramInt)
  {
    this.mLog.dl("Page selected:" + (paramInt + 1));
    Object localObject = this.aEd.gv(paramInt + 1);
    if (localObject != null)
    {
      this.aDX = ((com.mobisystems.mobiscanner.model.c)localObject).IU();
      Er();
      localObject = (ap)this.azV.get(this.aEh);
      if (localObject != null)
      {
        ((ap)localObject).GI();
        ((ap)localObject).a(this.alP, this.mTranslationX, this.mTranslationY, -1, -1, true);
      }
      ap localap = (ap)this.azV.get(this.aDX);
      localObject = localap;
      if (localap == null) {
        localObject = this.aEc;
      }
      if (localObject != null)
      {
        if (!this.aEl) {
          break label171;
        }
        ((ap)localObject).a(this.alP, this.mTranslationX, this.mTranslationY, -1, -1, true);
      }
    }
    for (;;)
    {
      ((ap)localObject).setFullscreen(this.aEe);
      this.aEh = this.aDX;
      return;
      label171:
      ((ap)localObject).a(this.alP, this.mTranslationX, this.mTranslationY, this.aEi, this.aEj, false);
    }
  }
  
  public void h(int paramInt)
  {
    if ((this.aEk == 1) && (paramInt == 2)) {}
    for (this.aEl = true;; this.aEl = false) {
      do
      {
        this.aEk = paramInt;
        return;
      } while ((this.aEk != 2) || (paramInt != 0));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mLog.dl("onActivityResult requestCode = " + paramInt1 + "; resultCode = " + paramInt2 + " ; data=" + paramIntent);
    switch (paramInt1)
    {
    case 2: 
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    case 1: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.aDZ < 0L) || (paramIntent == null));
          if (paramInt2 == -1)
          {
            paramIntent = com.mobisystems.mobiscanner.common.d.a(this, paramIntent.getData());
            if (paramIntent == null) {
              break label155;
            }
            new c(this.aDZ).execute(new String[] { paramIntent });
          }
          for (;;)
          {
            this.aDZ = -1L;
            return;
            Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
          }
        } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getExtras() == null));
        this.aDI = paramIntent.getStringExtra("authAccount");
      } while (this.aDI == null);
      paramIntent = getSharedPreferences(getString(2131297115), 4).edit();
      paramIntent.putString(CommonPreferences.Keys.apS.getKey(), this.aDI);
      paramIntent.commit();
      this.aAL.by(this.aDI);
      this.aDJ = a(this.aAL);
      GG();
      return;
    case 4: 
      label155:
      if (paramInt2 == -1)
      {
        GG();
        return;
      }
      paramInt1 = com.google.android.gms.common.d.w(this);
      if (paramInt1 != 0)
      {
        com.google.android.gms.common.d.b(paramInt1, this, 5);
        return;
      }
      try
      {
        startActivityForResult(this.aAL.wJ(), 3);
        return;
      }
      catch (ActivityNotFoundException paramIntent)
      {
        Toast.makeText(this, 2131296984, 1).show();
        return;
      }
    }
    GG();
  }
  
  public void onBackPressed()
  {
    if ((this.aEf) || (this.aEg))
    {
      GF();
      return;
    }
    GE();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165313: 
      GF();
      return;
    case 2131165320: 
      GF();
      return;
    case 2131165316: 
      gm(1);
      return;
    case 2131165317: 
      gm(-1);
      return;
    case 2131165467: 
      a(ImageProcessing.ImageOperation.aIj);
      return;
    }
    a(ImageProcessing.ImageOperation.aIl);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mLog.dl("onConfigurationChanged called, orientation = " + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    this.Eo = paramConfiguration.orientation;
    Gz();
    Er();
    Fn();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.mobisystems.mobiscanner.error.a.ay(getApplicationContext());
    this.mLog.dl("onCreate called");
    super.onCreate(paramBundle);
    this.Eo = getResources().getConfiguration().orientation;
    this.aEe = false;
    requestWindowFeature(9L);
    getWindow().addFlags(1024);
    setContentView(2130903072);
    com.mobisystems.mobiscanner.model.c localc = new com.mobisystems.mobiscanner.model.c(getIntent());
    this.aDX = localc.IU();
    this.aEh = this.aDX;
    this.axZ = localc.IS();
    if (paramBundle != null) {
      this.aDZ = paramBundle.getLong("LAST_EDIT_PAGE_ID", -1L);
    }
    Ef();
    Gt();
    this.aEb = ((GalleryViewPager)findViewById(2131165322));
    if (this.aEb != null) {
      this.aEb.a(JazzyViewPager.TransitionEffect.amk);
    }
    this.mCheckedIds = new HashSet();
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.aEf = paramBundle.getBoolean("OPEN_PAGE_SELECTION_MODE", false);
      if (!this.aEf) {
        break label221;
      }
      r(paramBundle);
    }
    for (;;)
    {
      Es();
      this.azV = new SparseArray();
      return;
      label221:
      this.aEg = paramBundle.getBoolean("OPEN_PAGE_DOCUMENT_SELECTION_MODE", false);
      if (this.aEg)
      {
        getSupportActionBar().hide();
        findViewById(2131165326).setBackgroundResource(2131427359);
        findViewById(2131165326).setVisibility(8);
        findViewById(2131165319).setVisibility(0);
        findViewById(2131165319).bringToFront();
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getSupportMenuInflater().inflate(2131689474, paramMenu);
    this.aAk = paramMenu;
    Gz();
    Er();
    return true;
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy called");
    if (this.aAr != null) {
      this.aAr.destroy();
    }
    super.onDestroy();
    this.aEd.Ii();
    e.clearCache();
  }
  
  public void onDialogNegativeAction(String paramString, Bundle paramBundle) {}
  
  public void onDialogPositiveAction(String paramString, Bundle paramBundle)
  {
    int i;
    if ("PAGE_DELETE".equals(paramString))
    {
      this.axZ = new com.mobisystems.mobiscanner.model.b(paramBundle);
      i = this.axZ.IL();
      if (i > 0)
      {
        if (this.aDX > i) {
          this.aDX = i;
        }
        this.aEb.a(null);
        be(false);
        this.aEd.d(this.axZ, true);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          GE();
          return;
          if ("PAGE_COPY".equals(paramString))
          {
            this.axZ = new com.mobisystems.mobiscanner.model.b(paramBundle);
            long l = paramBundle.getLong("NEW_DOC_ID");
            i = this.axZ.IL();
            if (i > 0)
            {
              this.aEb.a(null);
              be(false);
              if (l == this.axZ.getId())
              {
                new a(this.axZ).execute(new Long[] { Long.valueOf(this.aDY) });
                return;
              }
              if (this.aDX > i) {
                this.aDX = i;
              }
              this.aEd.d(this.axZ, true);
              return;
            }
            GE();
            return;
          }
        } while (("PAGE_PROPERTIES".equals(paramString)) || ("PAGE_EXPORT".equals(paramString)) || ("PAGE_OPEN".equals(paramString)) || ("PAGE_SHARE".equals(paramString)));
        if (!"PAGE_EXPORT_FOR_EDIT".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getStringArray("EXPORTED_FILES");
      } while ((paramString == null) || (paramString.length <= 0) || (paramString[0] == null));
      this.aEa = paramString[0];
      paramBundle = new Intent("android.intent.action.EDIT");
      paramBundle.setDataAndType(Uri.fromFile(new File(paramString[0]).getAbsoluteFile()), "image/*");
      startActivityForResult(paramBundle, 1);
      return;
      if ("PAGE_RESET".equals(paramString))
      {
        if (this.aEc != null) {
          this.aEc.g(true, true);
        }
        bd(false);
        return;
      }
    } while (!"CONFIRM_GET_FROM_MARKET".equals(paramString));
    paramString = paramBundle.getString("GET_FROM_MARKET_PACKAGE_NAME");
    try
    {
      startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(com.mobisystems.mobiscanner.common.d.jdMethod_do(paramString))), 2);
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(com.mobisystems.mobiscanner.common.d.dp(paramString))), 2);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      Toast.makeText(this, paramView.getContentDescription(), 0).show();
    }
    for (;;)
    {
      return true;
      gm(-this.aEb.F());
      continue;
      GB();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      GE();
      return true;
    case 2131165560: 
      a(ImageProcessing.ImageOperation.aIl);
      return true;
    case 2131165561: 
      a(ImageProcessing.ImageOperation.aIj);
      return true;
    case 2131165562: 
      gm(-1);
      return true;
    case 2131165563: 
      gm(1);
      return true;
    case 2131165567: 
      GC();
      return true;
    case 2131165568: 
      GD();
      return true;
    case 2131165569: 
      b(new as(), "PAGE_EXPORT");
      return true;
    case 2131165564: 
      b(new as(), "PAGE_SHARE");
      return true;
    case 2131165565: 
      b(new al(), "PAGE_COPY");
      return true;
    case 2131165573: 
      b(new aw(), "PAGE_PROPERTIES");
      return true;
    case 2131165574: 
      b(new an(), "PAGE_DELETE");
      return true;
    case 2131165594: 
      HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aDd);
      return true;
    case 2131165566: 
      paramMenuItem = new Intent(this, PageEnhanceActivity.class);
      paramMenuItem.addFlags(67108864);
      this.axZ.f(paramMenuItem);
      this.aEd.gv(this.aDX).f(paramMenuItem);
      startActivity(paramMenuItem);
      e.clearCache();
      System.gc();
      return true;
    case 2131165571: 
      this.aEc.GO();
      return true;
    case 2131165572: 
      this.aEc.GP();
      return true;
    }
    Gw();
    return true;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    if (this.aAr != null) {
      this.aAr.pause();
    }
    if (this.aEc != null) {
      this.aEc.GI();
    }
    super.onPause();
    this.aEd.flushCache();
    this.aEb.a(null);
    this.mResumed = false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    if (com.mobisystems.mobiscanner.common.d.DE()) {
      paramMenu.findItem(2131165567).setVisible(false);
    }
    paramMenu = this.aEd.gv(this.aDX);
    if (paramMenu != null)
    {
      if (paramMenu.Jc() != -1L) {
        bool = true;
      }
      bd(bool);
    }
    return true;
  }
  
  public void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
    Gz();
    Er();
    be(false);
    Gt();
    this.mResumed = true;
    if (com.mobisystems.office.a.a.aB(this).aNm == 2) {
      this.mIsPaidForAdsRemoval = true;
    }
    for (;;)
    {
      Fn();
      if (this.aAr != null) {
        this.aAr.resume();
      }
      return;
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      this.mIsPaidForAdsRemoval = localSharedPreferences.getBoolean(CommonPreferences.Keys.apJ.getKey(), false);
      if (!this.mIsPaidForAdsRemoval) {
        this.mIsPaidForAdsRemoval = localSharedPreferences.getBoolean(CommonPreferences.Keys.apK.getKey(), false);
      }
      this.aDI = getSharedPreferences(getString(2131297115), 4).getString(CommonPreferences.Keys.apS.getKey(), null);
      if (this.aDI != null)
      {
        if (this.aAL == null) {
          this.aAL = com.google.api.client.googleapis.extensions.android.gms.auth.a.b(this, Arrays.asList(new String[] { "https://www.googleapis.com/auth/drive" }));
        }
        this.aAL.by(this.aDI);
        this.aDJ = a(this.aAL);
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("LAST_EDIT_PAGE_ID", this.aDZ);
  }
  
  protected void onStart()
  {
    super.onStart();
    com.google.analytics.tracking.android.l.e(this).a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    com.google.analytics.tracking.android.l.e(this).b(this);
  }
  
  public void onSystemUiVisibilityChange(int paramInt) {}
  
  private class a
    extends AsyncTask<Long, Void, com.mobisystems.mobiscanner.model.c>
  {
    private com.mobisystems.mobiscanner.model.b axZ;
    
    public a(com.mobisystems.mobiscanner.model.b paramb)
    {
      this.axZ = paramb;
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      PageDetailActivity.a(PageDetailActivity.this, paramc.IU());
      PageDetailActivity.b(PageDetailActivity.this).d(this.axZ, true);
    }
    
    public com.mobisystems.mobiscanner.model.c c(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      com.mobisystems.mobiscanner.model.c localc = new DocumentModel().aj(l);
      paramVarArgs = localc;
      if (localc == null) {
        paramVarArgs = new com.mobisystems.mobiscanner.model.c();
      }
      return paramVarArgs;
    }
  }
  
  public class b
    extends FragmentStatePagerAdapter
  {
    public b(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      PageDetailActivity.f(PageDetailActivity.this).f(null, paramInt);
      com.mobisystems.mobiscanner.model.c localc = PageDetailActivity.b(PageDetailActivity.this).gv(paramInt + 1);
      PageDetailActivity.e(PageDetailActivity.this).remove(localc.IU());
      super.destroyItem(paramViewGroup, paramInt, paramObject);
    }
    
    public int getCount()
    {
      return PageDetailActivity.b(PageDetailActivity.this).Im().IL();
    }
    
    public Fragment getItem(int paramInt)
    {
      PageDetailActivity.a(PageDetailActivity.this).dl("Create fragment for page idx=" + (paramInt + 1));
      ap localap = new ap();
      Bundle localBundle = new Bundle();
      com.mobisystems.mobiscanner.model.c localc = PageDetailActivity.b(PageDetailActivity.this).gv(paramInt + 1);
      if (localc != null)
      {
        localc.p(localBundle);
        localap.setArguments(localBundle);
      }
      ((ap)localap).setFullscreen(PageDetailActivity.c(PageDetailActivity.this));
      ((ap)localap).b((TextView)PageDetailActivity.this.findViewById(2131165324));
      return localap;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
      PageDetailActivity.f(PageDetailActivity.this).f(paramViewGroup, paramInt);
      com.mobisystems.mobiscanner.model.c localc = PageDetailActivity.b(PageDetailActivity.this).gv(paramInt + 1);
      PageDetailActivity.e(PageDetailActivity.this).put(localc.IU(), (ap)paramViewGroup);
      return paramViewGroup;
    }
    
    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (paramObject.equals(PageDetailActivity.d(PageDetailActivity.this))) {}
      do
      {
        return;
        PageDetailActivity.a(PageDetailActivity.this, (ap)paramObject);
        int i = 0;
        while (i < PageDetailActivity.e(PageDetailActivity.this).size())
        {
          int j = PageDetailActivity.e(PageDetailActivity.this).keyAt(i);
          paramViewGroup = (ap)PageDetailActivity.e(PageDetailActivity.this).get(j);
          if (paramViewGroup != null) {
            paramViewGroup.setSelected(paramViewGroup.equals(PageDetailActivity.d(PageDetailActivity.this)));
          }
          i += 1;
        }
        paramViewGroup = PageDetailActivity.f(PageDetailActivity.this).fF(paramInt);
      } while (paramViewGroup == null);
      com.c.a.a.n(paramViewGroup, 0.0F);
      com.c.a.a.f(paramViewGroup, 1.0F);
      com.c.a.a.l(paramViewGroup, 1.0F);
      com.c.a.a.m(paramViewGroup, 1.0F);
    }
  }
  
  private class c
    extends AsyncTask<String, Void, com.mobisystems.mobiscanner.model.c>
  {
    private boolean aEq;
    private long axO;
    
    public c(long paramLong)
    {
      this.axO = paramLong;
      this.aEq = false;
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      boolean bool = true;
      if (paramc != null)
      {
        if (PageDetailActivity.d(PageDetailActivity.this) != null) {
          PageDetailActivity.d(PageDetailActivity.this).g(this.aEq, true);
        }
        paramc = PageDetailActivity.this;
        if (this.aEq) {
          break label49;
        }
      }
      for (;;)
      {
        paramc.bd(bool);
        return;
        label49:
        bool = false;
      }
    }
    
    public com.mobisystems.mobiscanner.model.c h(String... paramVarArgs)
    {
      Object localObject = paramVarArgs[0];
      paramVarArgs = null;
      DocumentModel localDocumentModel = new DocumentModel();
      boolean bool1;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        boolean bool2 = localDocumentModel.a(this.axO, (String)localObject, true);
        File localFile = new File(PageDetailActivity.g(PageDetailActivity.this));
        localObject = new File((String)localObject);
        if (!localFile.delete()) {
          PageDetailActivity.a(PageDetailActivity.this).dl("SetProcessedImageTask: could not delete" + localFile.getAbsolutePath());
        }
        bool1 = bool2;
        if (!((File)localObject).delete())
        {
          PageDetailActivity.a(PageDetailActivity.this).dl("SetProcessedImageTask: could not delete" + ((File)localObject).getAbsolutePath());
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (bool1) {
          paramVarArgs = localDocumentModel.aj(this.axO);
        }
        return paramVarArgs;
        bool1 = localDocumentModel.al(this.axO);
        this.aEq = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/PageDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */