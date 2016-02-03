package com.mobisystems.mobiscanner.controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.analytics.tracking.android.l;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.error.a;
import com.mobisystems.mobiscanner.image.g;
import com.mobisystems.mobiscanner.image.g.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PageEnhanceActivity
  extends SherlockFragmentActivity
  implements View.OnClickListener, View.OnLongClickListener, g.c
{
  private int aDX;
  private int aEM;
  private ar aEN;
  private SparseArray<h> aEO;
  private SparseArray<h> aEP;
  private SparseArray<Float> aEQ;
  private boolean aER;
  List<Long> aES;
  private boolean aET;
  private g aEd = null;
  private com.mobisystems.mobiscanner.model.b axZ;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  private int progressCounter;
  private ProgressDialog progressDialog;
  
  private void GT()
  {
    ((TextView)findViewById(2131165334)).setText(this.aDX + "/" + this.axZ.IL());
  }
  
  private void GU()
  {
    if (this.aEd == null)
    {
      this.aEd = new com.mobisystems.mobiscanner.image.b(getApplicationContext(), getSupportFragmentManager(), this.axZ);
      this.aEd.a(this);
    }
    for (;;)
    {
      GT();
      return;
      this.aEd.d(this.axZ, true);
    }
  }
  
  private void GV()
  {
    ar localar = new ar();
    Bundle localBundle = new Bundle();
    com.mobisystems.mobiscanner.model.c localc = this.aEd.gv(this.aDX);
    Object localObject;
    int i;
    if (localc != null)
    {
      if (this.aEN != null)
      {
        localObject = this.aEN.Hb();
        if (localObject != null) {
          this.aEO.put(this.aEM, new h((h)localObject));
        }
        getSupportFragmentManager().beginTransaction().detach(this.aEN).commit();
      }
      if ((this.aEP.get(this.aDX) == null) && (this.aEO.get(this.aDX) == null))
      {
        localObject = new DocumentModel();
        if (localc.Jx() != -1) {
          break label349;
        }
        Toast.makeText(this, "AutoCrop in progress", 1).show();
      }
      Float localFloat = (Float)this.aEQ.get(this.aDX);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(localc.Jy());
      }
      if ((localObject != null) && (0.0F < ((Float)localObject).floatValue())) {
        localar.C(((Float)localObject).floatValue());
      }
      localObject = (h)this.aEO.get(this.aDX);
      if (localObject == null) {
        break label412;
      }
      localar.e((h)localObject);
      i = 2130837671;
      label230:
      if (localObject != null) {
        break label419;
      }
    }
    label349:
    label412:
    label419:
    for (boolean bool = true;; bool = false)
    {
      this.aER = bool;
      ((ImageButton)findViewById(2131165332)).setImageDrawable(getResources().getDrawable(i));
      localc.p(localBundle);
      localar.setArguments(localBundle);
      getSupportFragmentManager().beginTransaction().add(2131165337, localar, "").commit();
      this.aEN = localar;
      GT();
      findViewById(2131165335).setVisibility(0);
      findViewById(2131165332).setVisibility(0);
      findViewById(2131165333).setVisibility(8);
      findViewById(2131165336).setVisibility(8);
      return;
      if (localc.Jx() <= 0) {
        break;
      }
      localObject = ((DocumentModel)localObject).aI(localc.getId());
      this.aEP.put(this.aDX, localObject);
      if ((localObject == null) || (((h)localObject).vh() == null)) {
        break;
      }
      this.aEO.put(this.aDX, new h((h)localObject));
      break;
      i = 2130837672;
      break label230;
    }
  }
  
  private void GX()
  {
    this.progressDialog.dismiss();
    Intent localIntent = d.a(this, this.axZ);
    if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(CommonPreferences.Keys.aqa.getKey(), false)) {
      localIntent.putExtra("CROP_SHOW_RATE", true);
    }
    startActivity(localIntent);
    finish();
  }
  
  private void U(long paramLong)
  {
    this.aES.remove(Long.valueOf(paramLong));
    if (this.aES.isEmpty())
    {
      GX();
      return;
    }
    new a(this, ((Long)this.aES.get(0)).longValue()).execute(new Void[0]);
  }
  
  private void b(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(paramOnClickListener);
          localView.setOnLongClickListener(paramOnLongClickListener);
        }
        i += 1;
      }
    }
  }
  
  private void d(Integer paramInteger)
  {
    this.progressCounter += 1;
    this.progressDialog.setProgress(this.progressCounter);
  }
  
  public void B(float paramFloat)
  {
    this.aEQ.put(this.aDX, Float.valueOf(paramFloat));
  }
  
  public void GS()
  {
    this.aET = true;
    Object localObject = getSupportFragmentManager().findFragmentByTag("CROP_DEMO");
    if (localObject != null) {
      getSupportFragmentManager().beginTransaction().detach((Fragment)localObject).commit();
    }
    localObject = PreferenceManager.getDefaultSharedPreferences(this).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(CommonPreferences.Keys.apZ.getKey(), true);
    ((SharedPreferences.Editor)localObject).commit();
    GU();
  }
  
  public g GW()
  {
    return this.aEd;
  }
  
  public void Gu()
  {
    GV();
  }
  
  public void Gv()
  {
    if (this.aEN != null) {
      this.aEN.Gv();
    }
  }
  
  public void c(h paramh)
  {
    this.mLog.dl("onCropPointsChanged");
    this.aEO.put(this.aDX, new h(paramh));
    this.aEQ.remove(this.aDX);
    ((ImageButton)findViewById(2131165332)).setImageDrawable(getResources().getDrawable(2130837671));
  }
  
  public void d(h paramh)
  {
    this.aEP.put(this.aDX, new h(paramh));
    this.aEO.put(this.aDX, new h(paramh));
    this.aER = false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = this.axZ.IL();
    switch (i)
    {
    default: 
    case 2131165320: 
    case 2131165329: 
    case 2131165317: 
    case 2131165332: 
    case 2131165333: 
    case 2131165316: 
    case 2131165335: 
      do
      {
        do
        {
          do
          {
            do
            {
              Object localObject;
              do
              {
                do
                {
                  do
                  {
                    return;
                    onBackPressed();
                    return;
                    this.progressCounter = 0;
                    this.progressDialog = new ProgressDialog(this);
                    this.progressDialog.setMax(j);
                    this.progressDialog.setProgress(0);
                    this.progressDialog.setCancelable(false);
                    this.progressDialog.setProgressStyle(1);
                    this.progressDialog.setTitle(2131297086);
                    this.progressDialog.setMessage(getString(2131296818));
                    this.progressDialog.setProgressNumberFormat(getString(2131296817));
                    this.progressDialog.show();
                    paramView = new ArrayList();
                    localObject = new DocumentModel();
                    i = 1;
                    if (i <= j)
                    {
                      com.mobisystems.mobiscanner.model.c localc = ((DocumentModel)localObject).c(this.axZ.getId(), i);
                      long l = localc.getId();
                      if (localc.Jx() != 2) {
                        paramView.add(Integer.valueOf(i));
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        h localh1 = (h)this.aEO.get(i);
                        if (localh1 != null)
                        {
                          h localh2 = (h)this.aEP.get(i);
                          Float localFloat = (Float)this.aEQ.get(i);
                          if ((localh2 != null) && (((Point)localh2.vh().get(0)).equals(((Point)localh1.vh().get(0)).x, ((Point)localh1.vh().get(0)).y)) && (((Point)localh2.vh().get(1)).equals(((Point)localh1.vh().get(1)).x, ((Point)localh1.vh().get(1)).y)) && (((Point)localh2.vh().get(2)).equals(((Point)localh1.vh().get(2)).x, ((Point)localh1.vh().get(2)).y)) && (((Point)localh2.vh().get(3)).equals(((Point)localh1.vh().get(3)).x, ((Point)localh1.vh().get(3)).y)))
                          {
                            if (((localFloat == null) || (localc.Jy() != localFloat.floatValue())) && ((localFloat != null) || (localc.Jy() != 0.0F))) {
                              paramView.add(Integer.valueOf(i));
                            }
                          }
                          else {
                            paramView.add(Integer.valueOf(i));
                          }
                        }
                        else if (((DocumentModel)localObject).aI(l) == null)
                        {
                          paramView.add(Integer.valueOf(i));
                        }
                      }
                    }
                    if (paramView.size() == 0)
                    {
                      GX();
                      return;
                    }
                    this.progressDialog.setMax(paramView.size());
                    new b(paramView).execute(new Void[0]);
                    return;
                  } while (j <= 1);
                  this.aEM = this.aDX;
                  this.aDX -= 1;
                  if (this.aDX < 1) {
                    this.aDX = j;
                  }
                  GV();
                  return;
                } while (this.aEN == null);
                if (!this.aER) {
                  break;
                }
                localObject = (h)this.aEP.get(this.aDX);
                if (localObject != null)
                {
                  this.aEN.e((h)localObject);
                  this.aEO.put(this.aDX, new h((h)localObject));
                  this.aER = false;
                  ((ImageButton)paramView).setImageDrawable(getResources().getDrawable(2130837671));
                  return;
                }
                localObject = (h)this.aEO.get(this.aDX);
              } while (localObject == null);
              this.aEN.e((h)localObject);
              this.aER = false;
              ((ImageButton)paramView).setImageDrawable(getResources().getDrawable(2130837671));
              return;
              this.aEN.GY();
              ((ImageButton)paramView).setImageDrawable(getResources().getDrawable(2130837672));
              this.aER = true;
              return;
            } while (this.aEN == null);
            paramView = (h)this.aEP.get(this.aDX);
            if (paramView != null)
            {
              this.aEN.f(paramView);
              this.aEO.put(this.aDX, new h(paramView));
              this.aER = false;
              return;
            }
            paramView = (h)this.aEO.get(this.aDX);
          } while (paramView == null);
          this.aEN.f(paramView);
          this.aER = false;
          return;
        } while (j <= 1);
        this.aEM = this.aDX;
        this.aDX += 1;
        if (this.aDX > j) {
          this.aDX = 1;
        }
        GV();
        return;
      } while (!this.aEN.Hc());
      findViewById(2131165336).setVisibility(0);
      findViewById(2131165332).setVisibility(8);
      findViewById(2131165333).setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    findViewById(2131165335).setVisibility(0);
    findViewById(2131165332).setVisibility(0);
    findViewById(2131165333).setVisibility(8);
    paramView.setVisibility(8);
    this.aEN.Hd();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a.ay(getApplicationContext());
    this.mLog.dl("onCreate called");
    super.onCreate(paramBundle);
    getWindow().addFlags(1024);
    getSupportActionBar().hide();
    if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(CommonPreferences.Keys.apZ.getKey(), false))
    {
      this.aET = false;
      if (getSupportFragmentManager().findFragmentByTag("CROP_DEMO") == null)
      {
        paramBundle = new Bundle();
        i locali = new i();
        locali.setArguments(paramBundle);
        getSupportFragmentManager().beginTransaction().add(2131165338, locali, "CROP_DEMO").commit();
      }
      setContentView(2130903073);
      paramBundle = getIntent();
      if (paramBundle.getLongExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", -1L) == -1L) {
        break label291;
      }
      this.axZ = new com.mobisystems.mobiscanner.model.b(paramBundle);
      this.aDX = paramBundle.getIntExtra("START_CROP_FROM_LAST_PAGE", 1);
    }
    for (;;)
    {
      this.aEM = -1;
      b((ViewGroup)findViewById(2131165328), this, this);
      b((ViewGroup)findViewById(2131165331), this, this);
      this.aEO = new SparseArray(this.axZ.IL());
      this.aEP = new SparseArray(this.axZ.IL());
      this.aEQ = new SparseArray(this.axZ.IL());
      ((TextView)findViewById(2131165330)).setText(this.axZ.getName());
      return;
      this.aET = true;
      break;
      label291:
      paramBundle = new com.mobisystems.mobiscanner.model.c(paramBundle);
      this.aDX = paramBundle.IU();
      this.axZ = paramBundle.IS();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.aEd != null) {
      this.aEd.Ii();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Toast.makeText(this, paramView.getContentDescription(), 0).show();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.aEd != null) {
      this.aEd.flushCache();
    }
    if (this.aEN != null)
    {
      getSupportFragmentManager().beginTransaction().detach(this.aEN).commit();
      this.aEN = null;
    }
    this.aEM = -1;
  }
  
  public void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
    if (this.aET) {
      GU();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    l.e(this).a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
  
  private class a
    extends AsyncTask<Void, Void, Void>
    implements ad
  {
    private final long axO;
    private ac axP;
    private boolean axQ = false;
    private final Context mContext;
    
    a(Context paramContext, long paramLong)
    {
      this.mContext = paramContext;
      this.axO = paramLong;
    }
    
    public void El() {}
    
    public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, List<com.mobisystems.mobiscanner.common.util.b> paramList, int paramInt)
    {
      PageEnhanceActivity.a(PageEnhanceActivity.this).dl("onPostLSD");
      new be(paramList).execute(new Long[] { Long.valueOf(this.axO) });
    }
    
    public void a(com.mobisystems.mobiscanner.model.c paramc)
    {
      PageEnhanceActivity.a(PageEnhanceActivity.this).dl("onSetCropMatrixFinished");
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      this.axP = new ac(new DocumentModel().ao(this.axO), this.mContext, this, this.axO);
      this.axP.f(true, true);
      return null;
    }
    
    public void m(List<h> paramList)
    {
      if ((this.axO > 0L) && (paramList.size() > 0)) {
        new bf((h)paramList.get(0)).execute(new Long[] { Long.valueOf(this.axO) });
      }
      if (paramList.size() <= 0)
      {
        if (this.axQ)
        {
          PageEnhanceActivity.a(PageEnhanceActivity.this, this.axO);
          return;
        }
        this.axQ = true;
        this.axP.f(false, false);
        return;
      }
      PageEnhanceActivity.a(PageEnhanceActivity.this).dl("onQuadInfoAvailable");
      try
      {
        this.axP.b((h)paramList.get(0));
        PageEnhanceActivity.a(PageEnhanceActivity.this, this.axO);
        PageEnhanceActivity.a(PageEnhanceActivity.this, Integer.valueOf((int)this.axO));
        return;
      }
      catch (IOException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  private class b
    extends AsyncTask<Void, Integer, Void>
    implements ad
  {
    private long aEV;
    private List<Integer> aEW;
    
    b()
    {
      Collection localCollection;
      this.aEW = new ArrayList(localCollection);
    }
    
    public void El() {}
    
    public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, List<com.mobisystems.mobiscanner.common.util.b> paramList, int paramInt)
    {
      new be(paramList).execute(new Long[] { Long.valueOf(this.aEV) });
    }
    
    public void a(com.mobisystems.mobiscanner.model.c paramc) {}
    
    protected void a(Integer... paramVarArgs)
    {
      PageEnhanceActivity.a(PageEnhanceActivity.this, paramVarArgs[0]);
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = new DocumentModel();
      Iterator localIterator = this.aEW.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        PageEnhanceActivity.a(PageEnhanceActivity.this).dl("apply crop process page " + i);
        this.aEV = paramVarArgs.c(PageEnhanceActivity.b(PageEnhanceActivity.this).getId(), i).getId();
        PageEnhanceActivity.a(PageEnhanceActivity.this).dl("apply crop process pageId " + this.aEV);
        h localh = (h)PageEnhanceActivity.c(PageEnhanceActivity.this).get(i);
        if (localh != null)
        {
          Float localFloat = (Float)PageEnhanceActivity.d(PageEnhanceActivity.this).get(i);
          for (;;)
          {
            ac localac;
            try
            {
              localac = new ac(paramVarArgs.ao(this.aEV), PageEnhanceActivity.this, this, this.aEV);
              if (localFloat == null) {
                break label260;
              }
              localac.a(localh, localFloat.floatValue());
              paramVarArgs.a(this.aEV, localh);
              paramVarArgs.a(this.aEV, localFloat.floatValue());
              publishProgress(new Integer[] { Integer.valueOf((int)this.aEV) });
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
            break;
            label260:
            localac.b(localIOException);
            paramVarArgs.a(this.aEV, 0.0F);
            paramVarArgs.a(this.aEV, localIOException);
          }
        }
        if (PageEnhanceActivity.this.aES == null) {
          PageEnhanceActivity.this.aES = new ArrayList();
        }
        PageEnhanceActivity.this.aES.add(Long.valueOf(this.aEV));
      }
      return null;
    }
    
    public void m(List<h> paramList)
    {
      if (paramList.size() > 0) {
        new bf((h)paramList.get(0)).execute(new Long[] { Long.valueOf(this.aEV) });
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if ((PageEnhanceActivity.this.aES != null) && (this.aEW.size() > 0))
      {
        PageEnhanceActivity.a(PageEnhanceActivity.this, -1L);
        return;
      }
      PageEnhanceActivity.e(PageEnhanceActivity.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/PageEnhanceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */