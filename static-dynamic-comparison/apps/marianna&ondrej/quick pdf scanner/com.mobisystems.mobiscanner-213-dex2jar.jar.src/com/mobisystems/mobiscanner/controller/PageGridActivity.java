package com.mobisystems.mobiscanner.controller;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.LoaderManager;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.ads.AdView;
import com.jfeinstein.jazzyviewpager.ImageViewPager.f;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.image.ImageProcessing.ImageOperation;
import com.mobisystems.mobiscanner.image.h;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.view.DisableableViewPager;
import com.mobisystems.office.a.a.a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PageGridActivity
  extends SherlockFragmentActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, ActionMode.Callback, ImageViewPager.f, av, k
{
  private Menu aAk;
  private Menu aAl;
  private boolean aAm;
  private String aAn = "";
  private AdView aAr;
  private t aBo;
  private long aDZ;
  private boolean aFf = false;
  private boolean aFg = false;
  private au aFh;
  private DisableableViewPager aFi;
  private int aFj;
  private int aFk;
  private long aFl = 0L;
  private long[] aFm;
  private h aFn;
  SparseArray<Fragment> aFo = new SparseArray();
  protected Intent aFp;
  public String aFq;
  private boolean aFr = false;
  private boolean aFs = true;
  private int aFt = -1;
  private com.mobisystems.mobiscanner.model.b axZ;
  private ActionMode mActionMode = null;
  private HashSet<Long> mCheckedIds;
  private boolean mIsPaidForAdsRemoval = false;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  private void EK()
  {
    d.ao(this);
    finish();
  }
  
  private void Ef()
  {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  private void Er()
  {
    if (this.mActionMode != null)
    {
      str = getResources().getString(2131297012);
      if (this.aFh == null)
      {
        i = 0;
        dH(String.format(str, new Object[] { Integer.valueOf(i) }));
      }
    }
    while (this.axZ == null) {
      for (;;)
      {
        String str;
        return;
        int i = this.aFh.FI();
      }
    }
    dG(this.axZ.getName());
  }
  
  private void Es()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131165340);
    c(localViewGroup, this, this);
    c((ViewGroup)findViewById(2131165348), this, this);
    c((ViewGroup)findViewById(2131165344), this, this);
    ((CheckBox)localViewGroup.findViewById(2131165341)).setOnCheckedChangeListener(this);
  }
  
  private void Fn()
  {
    if (!this.mIsPaidForAdsRemoval) {
      this.aAr = d.a(this, (FrameLayout)findViewById(2131165299), this.aAr, "_pg", false, true);
    }
  }
  
  private void Fr()
  {
    startActivityForResult(Intent.createChooser(d.DG(), getResources().getText(2131296739)), 2);
  }
  
  private void Fs()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, CameraActivity.class);
    if (this.axZ != null) {
      this.axZ.f(localIntent);
    }
    startActivity(localIntent);
  }
  
  private void GF()
  {
    Intent localIntent = new Intent();
    long[] arrayOfLong = null;
    if (this.aFg) {
      arrayOfLong = this.aFh.getCheckedItemIds();
    }
    for (;;)
    {
      localIntent.putExtra("DOCUMENT_SELECTION_MODE_RESULT", arrayOfLong);
      localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", this.axZ.getId());
      setResult(-1, localIntent);
      finish();
      return;
      if (this.aFf) {
        arrayOfLong = getCheckedItemIds();
      }
    }
  }
  
  private void Gz()
  {
    View localView;
    ViewGroup localViewGroup;
    if (this.aFf)
    {
      localView = findViewById(2131165340);
      localViewGroup = (ViewGroup)findViewById(2131165348);
      if (d.ah(this) == 1)
      {
        localViewGroup.setVisibility(0);
        localView.findViewById(2131165317).setVisibility(8);
        localView.findViewById(2131165316).setVisibility(8);
        ((TextView)findViewById(2131165342)).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localViewGroup.setVisibility(8);
    localView.findViewById(2131165317).setVisibility(0);
    localView.findViewById(2131165316).setVisibility(0);
    ((TextView)findViewById(2131165342)).setVisibility(0);
  }
  
  private void Hh()
  {
    final SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    final Dialog localDialog = new Dialog(this);
    localDialog.setTitle(2131296760);
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(2130903106, null);
    ((Button)localViewGroup.findViewById(2131165431)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PageGridActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.jdMethod_do(PageGridActivity.this.getPackageName()))));
        if (localEditor != null)
        {
          localEditor.putBoolean(CommonPreferences.Keys.aqa.getKey(), true);
          localEditor.commit();
        }
        localDialog.dismiss();
      }
    });
    ((Button)localViewGroup.findViewById(2131165432)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
      }
    });
    ((Button)localViewGroup.findViewById(2131165433)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (localEditor != null)
        {
          localEditor.putBoolean(CommonPreferences.Keys.aqa.getKey(), true);
          localEditor.commit();
        }
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localViewGroup);
    localDialog.show();
  }
  
  private void Hl()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(this, PageEnhanceActivity.class);
    this.axZ.f(localIntent);
    localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", this.axZ.getId());
    if (this.aFt > 0)
    {
      localIntent.putExtra("START_CROP_FROM_LAST_PAGE", this.aFt + 1);
      this.aFt = -1;
    }
    startActivity(localIntent);
  }
  
  private void Hm()
  {
    if (this.aFh != null) {
      this.aFh.reloadContent();
    }
  }
  
  private au Hn()
  {
    return this.aFh;
  }
  
  private void Hp()
  {
    if (this.mCheckedIds.size() > 0)
    {
      if (!this.aFf)
      {
        Hq();
        return;
      }
      Er();
      return;
    }
    Hr();
  }
  
  private void Hq()
  {
    this.aFf = true;
    this.mCheckedIds.clear();
    getSupportActionBar().hide();
    findViewById(2131165340).setVisibility(0);
    findViewById(2131165348).setVisibility(0);
    Er();
    Gz();
  }
  
  private void Hr()
  {
    this.aFf = false;
    getSupportActionBar().show();
    findViewById(2131165340).setVisibility(4);
    findViewById(2131165348).setVisibility(4);
    Er();
    Gz();
  }
  
  private void Hs()
  {
    this.aFg = true;
    this.mCheckedIds.clear();
    getSupportActionBar().hide();
    findViewById(2131165344).setVisibility(0);
    Er();
    Gz();
  }
  
  private void Ht()
  {
    if (this.aFi.D() != null) {
      ((c)this.aFi.D()).e(this.axZ);
    }
  }
  
  private void Hu()
  {
    if ((d.Dw()) && (!d.Dy()))
    {
      this.aFi.a(JazzyViewPager.TransitionEffect.alX);
      return;
    }
    DisableableViewPager localDisableableViewPager = this.aFi;
    if (d.ah(this) == 1) {}
    for (JazzyViewPager.TransitionEffect localTransitionEffect = JazzyViewPager.TransitionEffect.alY;; localTransitionEffect = JazzyViewPager.TransitionEffect.amj)
    {
      localDisableableViewPager.a(localTransitionEffect);
      return;
    }
  }
  
  private void Hw()
  {
    b(new ay(), "PAGE_RESET");
  }
  
  private void Hx()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT");
    try
    {
      localIntent.setDataAndType(Uri.fromFile(d.af(this).getAbsoluteFile()), "image/*");
      a(getPackageManager().queryIntentActivities(localIntent, 65536), localIntent, true, "PAGE_BATCH_EDIT");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void a(MenuItem paramMenuItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramMenuItem.setIcon(2130837760);
      return;
    }
    paramMenuItem.setIcon(2130837755);
  }
  
  private void a(bd parambd, String paramString)
  {
    this.mLog.dl("startDocumentProgressTask: action=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("DOCUMENTS", new long[] { this.axZ.getId() });
    parambd.setArguments(localBundle);
    parambd.show(getSupportFragmentManager(), paramString);
  }
  
  private void aV(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    try
    {
      Object localObject = Uri.fromFile(d.af(this));
      localIntent.putExtra("output", (Parcelable)localObject);
      this.aAn = ((Uri)localObject).getPath();
      localObject = getPackageManager().queryIntentActivities(localIntent, 65536);
      if ((!paramBoolean) && (((List)localObject).size() == 1) && (((ResolveInfo)((List)localObject).get(0)).activityInfo.packageName.equals("com.android.camera")))
      {
        Toast.makeText(this, OperationStatus.avJ.Ds(), 0).show();
        return;
      }
      startActivityForResult(localIntent, 1);
      return;
    }
    catch (IOException localIOException)
    {
      this.mLog.g("Error creating camera transfer dir", localIOException);
      Toast.makeText(this, OperationStatus.avI.Ds(), 0).show();
    }
  }
  
  private void b(bd parambd, String paramString)
  {
    if (this.aFh != null)
    {
      long[] arrayOfLong = this.aFh.getCheckedItemIds();
      if ((arrayOfLong != null) && (arrayOfLong.length > 0))
      {
        this.mLog.dl("startPageProgressTask: action=" + paramString + ", number of selected positions=" + arrayOfLong.length);
        Bundle localBundle = new Bundle();
        this.axZ.p(localBundle);
        localBundle.putLongArray("PAGES", arrayOfLong);
        parambd.setArguments(localBundle);
        parambd.show(getSupportFragmentManager(), paramString);
      }
    }
  }
  
  private void b(String[] paramArrayOfString, boolean paramBoolean)
  {
    getSupportLoaderManager().destroyLoader(0);
    af localaf = new af();
    Bundle localBundle = new Bundle();
    this.axZ.p(localBundle);
    localBundle.putStringArray("IMAGE_IMPORT_FILES", paramArrayOfString);
    localBundle.putBoolean("COPY_FLAG", paramBoolean);
    localaf.setArguments(localBundle);
    localaf.show(getSupportFragmentManager(), "PAGE_ADD");
  }
  
  private void c(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.setOnClickListener(paramOnClickListener);
      localView.setOnLongClickListener(paramOnLongClickListener);
      i += 1;
    }
  }
  
  private void dG(String paramString)
  {
    int i;
    if (this.mActionMode != null)
    {
      paramString = getResources().getString(2131297012);
      if (this.aFh == null) {}
      for (i = 0;; i = this.aFh.FI())
      {
        dH(String.format(paramString, new Object[] { Integer.valueOf(i) }));
        return;
      }
    }
    TextView localTextView;
    if (this.aFf)
    {
      localTextView = (TextView)findViewById(2131165343);
      i = this.mCheckedIds.size();
      localTextView.setText(String.format(getResources().getString(2131297012), new Object[] { Integer.valueOf(i) }));
      ((TextView)findViewById(2131165342)).setText(paramString);
      ((TextView)findViewById(2131165349)).setText(paramString);
      ((CheckBox)findViewById(2131165341)).setChecked(this.mCheckedIds.contains(Long.valueOf(this.axZ.getId())));
      return;
    }
    if (this.aFg)
    {
      localTextView = (TextView)findViewById(2131165346);
      localTextView.setText(paramString);
      if (d.ah(this) == 2) {
        localTextView.setVisibility(0);
      }
      for (;;)
      {
        ((TextView)findViewById(2131165345)).setText(2131296745);
        return;
        localTextView.setVisibility(8);
      }
    }
    getSupportActionBar().setTitle(paramString);
  }
  
  private void dH(String paramString)
  {
    CharSequence localCharSequence = this.mActionMode.getTitle();
    if ((localCharSequence == null) || (!paramString.contentEquals(localCharSequence))) {
      this.mActionMode.setTitle(paramString);
    }
  }
  
  private long[] getCheckedItemIds()
  {
    long[] arrayOfLong = new long[this.mCheckedIds.size()];
    Iterator localIterator = this.mCheckedIds.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  private void h(Intent paramIntent)
  {
    this.mLog.dl("batchEditAppSelected");
    b(new aj(), "PAGE_BATCH_EDIT");
  }
  
  private void r(String paramString1, String paramString2)
  {
    ab localab = new ab();
    Bundle localBundle = new Bundle();
    localBundle.putString("GET_FROM_MARKET_APP_NAME", paramString1);
    localBundle.putString("GET_FROM_MARKET_PACKAGE_NAME", paramString2);
    localab.setArguments(localBundle);
    localab.show(getSupportFragmentManager(), "CONFIRM_GET_FROM_MARKET");
  }
  
  private void setContextualActionBar(int paramInt)
  {
    String str = String.format(getResources().getString(2131297012), new Object[] { Integer.valueOf(paramInt) });
    if (this.mActionMode != null) {
      this.mActionMode.setTitle(str);
    }
  }
  
  public ActionMode Fp()
  {
    return this.mActionMode;
  }
  
  public void Fq()
  {
    if (-1 < d.Du())
    {
      if ((CommonPreferences.Keys.apr.Dm()) && (!d.DF()))
      {
        Fs();
        return;
      }
      aV(true);
      return;
    }
    aV(false);
  }
  
  public void Hi()
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    this.aFm = null;
  }
  
  public com.mobisystems.mobiscanner.model.b Hj()
  {
    return this.axZ;
  }
  
  public h Hk()
  {
    return this.aFn;
  }
  
  public boolean Ho()
  {
    return this.aFf;
  }
  
  public boolean Hv()
  {
    return this.aFg;
  }
  
  public void Z(long paramLong)
  {
    this.aDZ = paramLong;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(String paramString, com.mobisystems.mobiscanner.model.b paramb)
  {
    this.axZ = paramb;
    Ht();
    Er();
  }
  
  public void a(String paramString, long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      setContextualActionBar(paramArrayOfLong.length);
      this.aFm = paramArrayOfLong;
    }
  }
  
  public void a(final List<ResolveInfo> paramList, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    paramList = d.a(this, paramList, paramString);
    if (paramList.length == 1)
    {
      paramString = getResources().getString(2131297029);
      if ((paramList[0].axK.startsWith(paramString)) && (paramList[0].axL.startsWith(paramString)))
      {
        paramIntent = paramList[0].axL.substring(paramString.length());
        r(paramList[0].name, paramIntent);
        paramList = null;
      }
      for (;;)
      {
        if (paramBoolean) {
          this.aFp = paramList;
        }
        return;
        paramIntent.setClassName(paramList[0].axK, paramList[0].axL);
        h(paramIntent);
        paramList = paramIntent;
        if (!paramBoolean)
        {
          startActivityForResult(paramIntent, 4);
          paramList = paramIntent;
        }
      }
    }
    paramString = new ArrayAdapter(this, 17367057, 16908308, paramList)
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(16908308);
        int i = (int)(32.0F * PageGridActivity.this.getResources().getDisplayMetrics().density + 0.5F);
        paramList[paramAnonymousInt].icon.setBounds(0, 0, i, i);
        paramAnonymousViewGroup.setCompoundDrawables(paramList[paramAnonymousInt].icon, null, null, null);
        paramAnonymousViewGroup.setCompoundDrawablePadding((int)(5.0F * PageGridActivity.this.getResources().getDisplayMetrics().density + 0.5F));
        return paramAnonymousView;
      }
    };
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(2131296744);
    localBuilder.setAdapter(paramString, new a(paramList, paramBoolean, paramIntent));
    localBuilder.create().show();
  }
  
  public void bl(boolean paramBoolean)
  {
    this.aFi.bv(paramBoolean);
  }
  
  public void dA(String paramString)
  {
    startActionMode(this);
    this.aFi.bv(false);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      Menu localMenu = this.aAk;
      if (Fp() != null) {
        localMenu = this.aAl;
      }
      if ((!this.aFf) && (localMenu != null) && (localMenu.findItem(2131165556) != null))
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
    c localc = (c)this.aFi.D();
    if (localc != null)
    {
      this.axZ = localc.go(paramInt);
      if (this.axZ != null)
      {
        if (this.axZ.getName() != null) {
          dG(this.axZ.getName());
        }
        if (this.aAk != null) {
          onPrepareOptionsMenu(this.aAk);
        }
        this.aFl = this.axZ.getId();
        new f(this.aFl).execute(new Void[0]);
      }
    }
  }
  
  public void g(Intent paramIntent)
  {
    startActivityForResult(paramIntent, 3);
  }
  
  public void h(int paramInt) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
    case 2131165609: 
    case 2131165610: 
    case 2131165613: 
    case 2131165614: 
    case 2131165615: 
    case 2131165561: 
    case 2131165560: 
      do
      {
        do
        {
          do
          {
            do
            {
              return bool;
            } while (this.aFh == null);
            this.aFh.aY(true);
            setContextualActionBar(this.aFh.FI());
            return true;
          } while (this.aFh == null);
          this.aFh.FH();
          setContextualActionBar(this.aFh.FI());
          return true;
          b(new al(), "PAGE_COPY");
          return true;
          b(new as(), "PAGE_EXPORT");
          return true;
          b(new as(), "PAGE_SHARE");
          return true;
        } while (this.aFh == null);
        this.aFh.b(ImageProcessing.ImageOperation.aIj);
        return true;
      } while (this.aFh == null);
      this.aFh.b(ImageProcessing.ImageOperation.aIl);
      return true;
    case 2131165616: 
      Toast.makeText(this, "Batch edit mode", 1).show();
      Hx();
      return true;
    case 2131165617: 
      Hw();
      return true;
    case 2131165618: 
      b(new an(), "PAGE_DELETE");
      return true;
    }
    HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aDc);
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    this.mLog.dl("onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    Object localObject;
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == -1) {
        if (paramInt1 == 1)
        {
          localObject = this.aAn;
          paramIntent = new String[1];
          paramIntent[0] = localObject;
          bool = false;
          if ((paramIntent == null) || (paramIntent.length <= 0)) {
            break label116;
          }
          this.aFt = this.axZ.IL();
          b(paramIntent, bool);
        }
      }
    }
    label116:
    label222:
    label291:
    label308:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramIntent = d.d(this, paramIntent);
            break;
            Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
            return;
          } while (paramInt2 == 0);
          Toast.makeText(this, OperationStatus.avK.Ds(), 0).show();
          return;
          if (paramInt1 != 3) {
            break label222;
          }
        } while (paramIntent == null);
        this.aFl = paramIntent.getLongExtra("PAGE_DETAIL_DOC_ID", this.aFl);
        localObject = paramIntent.getLongArrayExtra("PAGE_SELECTION_MODE_RESULT");
        if (localObject != null)
        {
          this.aFm = ((long[])localObject);
          dA("");
        }
        for (;;)
        {
          a("", new com.mobisystems.mobiscanner.model.b(paramIntent));
          return;
          Hi();
        }
        if (4 != paramInt1) {
          break label308;
        }
      } while ((this.aDZ < 0L) || (paramIntent == null));
      if (paramInt2 == -1)
      {
        paramIntent = d.a(this, paramIntent.getData());
        if (paramIntent == null) {
          break label291;
        }
        new e(this.aDZ, true).execute(new String[] { paramIntent });
      }
      for (;;)
      {
        this.aDZ = -1L;
        return;
        Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
      }
      if (5 != paramInt1) {
        break label416;
      }
    } while ((this.aDZ < 0L) || (paramIntent == null));
    if (paramInt2 == -1)
    {
      paramIntent = d.a(this, paramIntent.getData());
      if (paramIntent == null) {
        break label399;
      }
      new e(this.aDZ, false).execute(new String[] { paramIntent });
      paramIntent = (aj)getSupportFragmentManager().findFragmentByTag("PAGE_BATCH_EDIT");
      if (paramIntent != null) {
        paramIntent.Gr();
      }
    }
    for (;;)
    {
      this.aDZ = -1L;
      return;
      label399:
      Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
    }
    label416:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.aFf) || (this.aFg))
    {
      GF();
      return;
    }
    EK();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    do
    {
      return;
    } while (this.axZ == null);
    if (paramBoolean) {
      this.mCheckedIds.add(Long.valueOf(this.axZ.getId()));
    }
    for (;;)
    {
      Hp();
      return;
      this.mCheckedIds.remove(Long.valueOf(this.axZ.getId()));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165318: 
    case 2131165319: 
    default: 
      return;
    case 2131165320: 
      GF();
      return;
    case 2131165317: 
      this.aFi.j(this.aFi.F() - 1);
      return;
    }
    this.aFi.j(this.aFi.F() + 1);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = Fp();
    if (paramConfiguration != null)
    {
      paramConfiguration.finish();
      dA("");
    }
    Gz();
    Er();
    Hu();
    Fn();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.mobisystems.mobiscanner.error.a.ay(getApplicationContext());
    this.mLog.dl("onCreate called");
    super.onCreate(paramBundle);
    requestWindowFeature(9L);
    setContentView(2130903074);
    this.aAm = false;
    if (paramBundle != null)
    {
      this.aAn = paramBundle.getString("CAMERA_IMAGE_PATH");
      if (this.aAn == null) {
        this.aAn = "";
      }
      this.aAm = paramBundle.getBoolean("PAGE_GRID_ACTION_MODE_STARTED", false);
    }
    Bundle localBundle;
    Object localObject;
    for (this.aBo = new t(paramBundle);; this.aBo = new t(getIntent()))
    {
      this.aFf = false;
      this.mCheckedIds = new HashSet();
      localBundle = getIntent().getExtras();
      if (localBundle == null) {
        break label225;
      }
      if (!localBundle.getBoolean("OPEN_DOCUMENT_SELECTION_MODE", false)) {
        break;
      }
      Hq();
      localObject = localBundle.getLongArray("OPEN_DOCUMENT_SELECTION_MODE_INITIAL");
      if (localObject == null) {
        break label225;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        long l = localObject[i];
        this.mCheckedIds.add(Long.valueOf(l));
        i += 1;
      }
    }
    if (localBundle.getBoolean("TITLE_PAGE_SELECTION_ACTIVE", false)) {
      Hs();
    }
    for (;;)
    {
      label225:
      this.aFj = -1;
      this.aFk = 0;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = localBundle;
      }
      if (localObject != null)
      {
        this.aFl = ((Bundle)localObject).getLong("OPEN_DOCUMENT_SELECTED_DOC_ID", 0L);
        this.aFj = ((Bundle)localObject).getInt("OPEN_DOCUMENT_CURRENT_LIST_COUNT", -1);
        this.aFk = ((Bundle)localObject).getInt("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", 0);
        this.aFm = ((Bundle)localObject).getLongArray("PAGE_GRID_SELECTED_IDS");
        this.aFr = ((Bundle)localObject).getBoolean("OPEN_DOCUMENT_FROM_SUGGESTION", false);
      }
      this.aFs = true;
      Ef();
      Gz();
      Es();
      this.aFn = new h(getApplicationContext(), getSupportFragmentManager());
      this.aFi = ((DisableableViewPager)findViewById(2131165347));
      Hu();
      this.aFi.fB(1);
      this.aFi.a(this);
      return;
      if (localBundle.getBoolean("CROP_SHOW_RATE", false)) {
        Hh();
      }
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    this.mActionMode = paramActionMode;
    paramActionMode.getMenuInflater().inflate(2131689481, paramMenu);
    this.aAl = paramMenu;
    paramMenu.findItem(2131165617).getIcon().setAlpha(getResources().getInteger(2131492870));
    if (this.aFh != null)
    {
      this.aFh.bm(false);
      Er();
      this.aFh.bn(true);
    }
    int i = 0;
    while (i < this.aFo.size())
    {
      ((au)this.aFo.get(this.aFo.keyAt(i))).bn(true);
      i += 1;
    }
    this.aFi.bv(false);
    Gz();
    return true;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.mLog.dl("onCreateOptionsMenu called");
    getSupportMenuInflater().inflate(2131689475, paramMenu);
    this.aAk = paramMenu;
    return true;
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy called");
    if (this.aAr != null) {
      this.aAr.destroy();
    }
    super.onDestroy();
    this.aFn.Ii();
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    if (this.aFh != null)
    {
      this.aFh.bm(true);
      this.aFh.bn(false);
    }
    int i = 0;
    while (i < this.aFo.size())
    {
      ((au)this.aFo.get(this.aFo.keyAt(i))).bn(false);
      i += 1;
    }
    setContextualActionBar(0);
    this.mActionMode.setTitle("");
    this.mActionMode = null;
    this.aFi.bv(true);
    Gz();
  }
  
  public void onDialogNegativeAction(String paramString, Bundle paramBundle) {}
  
  public void onDialogPositiveAction(String paramString, Bundle paramBundle)
  {
    if ("DOCUMENT_PROPERTIES".equals(paramString))
    {
      this.axZ = new com.mobisystems.mobiscanner.model.b(paramBundle);
      Ht();
      Er();
    }
    label30:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  break label30;
                  break label30;
                  break label30;
                  break label30;
                  break label30;
                  do
                  {
                    return;
                  } while (("DOCUMENT_EXPORT".equals(paramString)) || ("DOCUMENT_OPEN".equals(paramString)) || ("DOCUMENT_SHARE".equals(paramString)) || ("PAGE_EXPORT".equals(paramString)) || ("PAGE_OPEN".equals(paramString)) || ("PAGE_SHARE".equals(paramString)));
                  if ("DOCUMENT_DELETE".equals(paramString))
                  {
                    EK();
                    return;
                  }
                  if (("PAGE_ADD".equals(paramString)) || ("PAGE_DELETE".equals(paramString)) || ("PAGE_COPY".equals(paramString)) || ("PAGE_PROPERTIES".equals(paramString)) || ("DOCUMENT_COPY".equals(paramString)))
                  {
                    if (this.mActionMode != null) {
                      this.mActionMode.finish();
                    }
                    this.axZ = new com.mobisystems.mobiscanner.model.b(paramBundle);
                    if ("PAGE_ADD".equals(paramString))
                    {
                      Hl();
                      return;
                    }
                    Ht();
                    Er();
                    Hm();
                    return;
                  }
                  if ((!"PAGE_EXPORT".equals(paramString)) && (!"PAGE_OPEN".equals(paramString)) && (!"PAGE_SHARE".equals(paramString))) {
                    break;
                  }
                } while (this.mActionMode == null);
                this.mActionMode.finish();
                return;
                if (!"DOCUMENT_RENAME".equals(paramString)) {
                  break;
                }
                paramString = paramBundle.getString("DOC_NEW_NAME");
              } while ((paramString == null) || (paramString.equals(this.axZ.getName())));
              this.axZ.setName(paramString);
              Ht();
              Er();
              return;
              if (!"PAGE_EXPORT_FOR_EDIT".equals(paramString)) {
                break;
              }
              paramString = paramBundle.getStringArray("EXPORTED_FILES");
            } while ((paramString == null) || (paramString.length <= 0) || (paramString[0] == null));
            this.aFq = paramString[0];
            paramBundle = new Intent("android.intent.action.EDIT");
            paramBundle.setDataAndType(Uri.fromFile(new File(paramString[0]).getAbsoluteFile()), "image/*");
            startActivityForResult(paramBundle, 4);
            return;
            if (!"PAGE_EXPORT_FOR_BATCH_EDIT".equals(paramString)) {
              break;
            }
            paramString = paramBundle.getStringArray("EXPORTED_FILES");
          } while ((paramString == null) || (paramString.length <= 0) || (paramString[0] == null));
          paramString = Uri.fromFile(new File(paramString[0]).getAbsoluteFile());
          this.aFp.setData(paramString);
          startActivityForResult(this.aFp, 5);
          return;
          if (!"PAGE_BATCH_EDIT".equals(paramString)) {
            break;
          }
        } while (this.aFh == null);
        this.aFh.reloadContent();
        return;
        if (!"PAGE_RESET".equals(paramString)) {
          break;
        }
      } while (this.aFh == null);
      this.aFh.reloadContent();
      return;
    } while (!"CONFIRM_GET_FROM_MARKET".equals(paramString));
    paramString = paramBundle.getString("GET_FROM_MARKET_PACKAGE_NAME");
    try
    {
      startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(d.jdMethod_do(paramString))), 5);
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(d.dp(paramString))), 5);
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
      this.aFi.j(0);
      continue;
      if (this.aFi.D() != null) {
        this.aFi.j(this.aFi.D().getCount());
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      EK();
      return true;
    case 2131165575: 
      boolean bool;
      if (this.axZ.IN() > 0)
      {
        i = 1;
        if (i != 0) {
          break label233;
        }
        bool = true;
        a(paramMenuItem, bool);
        if (i == 0) {
          break label238;
        }
      }
      for (int i = 0;; i = 1)
      {
        new d(this.axZ.getId(), i).execute(new Void[0]);
        this.axZ.gw(i);
        return true;
        i = 0;
        break;
        bool = false;
        break label182;
      }
    case 2131165577: 
      Hq();
      this.mCheckedIds.add(Long.valueOf(this.axZ.getId()));
      Hp();
      return true;
    case 2131165579: 
      Fq();
      return true;
    case 2131165578: 
      Fr();
      return true;
    case 2131165580: 
      Hl();
      return true;
    case 2131165576: 
      if (this.aFh != null) {
        this.aFh.Hy();
      }
      dA("");
      return true;
    case 2131165582: 
      a(new q(), "DOCUMENT_SHARE");
      return true;
    case 2131165585: 
      a(new q(), "DOCUMENT_OPEN");
      return true;
    case 2131165586: 
      a(new q(), "DOCUMENT_EXPORT");
      return true;
    case 2131165583: 
      a(new q(), "DOCUMENT_PRINT");
      return true;
    case 2131165584: 
      a(new q(), "DOCUMENT_FAX");
      return true;
    case 2131165581: 
      a(new m(), "DOCUMENT_COPY");
      return true;
    case 2131165589: 
      a(new o(), "DOCUMENT_DELETE");
      return true;
    case 2131165588: 
      a(new u(), "DOCUMENT_PROPERTIES");
      return true;
    case 2131165587: 
      label182:
      label233:
      label238:
      a(new w(), "DOCUMENT_RENAME");
      return true;
    }
    HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aDb);
    return true;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    if (this.aAr != null) {
      this.aAr.pause();
    }
    super.onPause();
    if (this.aFi.D() != null)
    {
      ((c)this.aFi.D()).c(null);
      this.aFi.a(null);
    }
    this.aFn.flushCache();
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if ((this.axZ != null) && (this.axZ.IN() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramMenu.findItem(2131165575), bool);
      if ((d.DD()) || (d.DE()))
      {
        paramMenu.findItem(2131165583).setVisible(false);
        paramMenu.findItem(2131165584).setVisible(false);
      }
      return true;
    }
  }
  
  public void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
    new b().execute(new Void[0]);
    if (CommonPreferences.Keys.apu.Dm())
    {
      getWindow().clearFlags(1024);
      if (this.aAm) {
        dA("");
      }
      if (com.mobisystems.office.a.a.aB(this).aNm != 2) {
        break label110;
      }
      this.mIsPaidForAdsRemoval = true;
    }
    for (;;)
    {
      Fn();
      if (this.aAr != null) {
        this.aAr.resume();
      }
      return;
      getWindow().addFlags(1024);
      break;
      label110:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      this.mIsPaidForAdsRemoval = localSharedPreferences.getBoolean(CommonPreferences.Keys.apJ.getKey(), false);
      if (!this.mIsPaidForAdsRemoval) {
        this.mIsPaidForAdsRemoval = localSharedPreferences.getBoolean(CommonPreferences.Keys.apK.getKey(), false);
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLog.dl("onSaveInstanceState called");
    super.onSaveInstanceState(paramBundle);
    this.aBo.p(paramBundle);
    long l;
    if (this.axZ != null)
    {
      l = this.axZ.getId();
      paramBundle.putLong("OPEN_DOCUMENT_SELECTED_DOC_ID", l);
      paramBundle.putInt("OPEN_DOCUMENT_CURRENT_LIST_COUNT", this.aFj);
      paramBundle.putInt("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", this.aFk);
      paramBundle.putString("CAMERA_IMAGE_PATH", this.aAn);
      if (this.mActionMode == null) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("PAGE_GRID_ACTION_MODE_STARTED", bool);
      paramBundle.putLongArray("PAGE_GRID_SELECTED_IDS", this.aFm);
      paramBundle.putBoolean("OPEN_DOCUMENT_FROM_SUGGESTION", this.aFr);
      return;
      l = -1L;
      break;
    }
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
  
  private class a
    implements DialogInterface.OnClickListener
  {
    private b[] aFx;
    private boolean aFy = true;
    private Intent mIntent;
    
    public a(b[] paramArrayOfb, boolean paramBoolean, Intent paramIntent)
    {
      this.aFx = paramArrayOfb;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.aFy = paramBoolean;
        this.mIntent = paramIntent;
        return;
      }
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      Object localObject = PageGridActivity.this.getResources().getString(2131297029);
      paramDialogInterface.dismiss();
      paramDialogInterface = null;
      if ((this.aFx[paramInt].axK.startsWith((String)localObject)) && (this.aFx[paramInt].axL.startsWith((String)localObject)))
      {
        localObject = this.aFx[paramInt].axL.substring(((String)localObject).length());
        String str = this.aFx[paramInt].name;
        PageGridActivity.a(PageGridActivity.this, str, (String)localObject);
      }
      for (;;)
      {
        if (!this.aFy) {
          PageGridActivity.this.aFp = paramDialogInterface;
        }
        return;
        localObject = this.mIntent;
        ((Intent)localObject).setClassName(this.aFx[paramInt].axK, this.aFx[paramInt].axL);
        PageGridActivity.a(PageGridActivity.this, (Intent)localObject);
        paramDialogInterface = (DialogInterface)localObject;
        if (this.aFy)
        {
          PageGridActivity.this.startActivityForResult((Intent)localObject, 4);
          paramDialogInterface = (DialogInterface)localObject;
        }
      }
    }
  }
  
  protected class b
    extends AsyncTask<Void, Void, Cursor>
  {
    private boolean aFz = false;
    
    protected b() {}
    
    protected void b(Cursor paramCursor)
    {
      PageGridActivity.c localc = new PageGridActivity.c(PageGridActivity.this, PageGridActivity.this.getSupportFragmentManager());
      PageGridActivity.g(PageGridActivity.this).a(localc);
      localc.c(paramCursor);
      if ((this.aFz) && (PageGridActivity.m(PageGridActivity.this)))
      {
        PageGridActivity.a(PageGridActivity.this, false);
        PageGridActivity.this.dA("");
      }
    }
    
    protected Cursor e(Void... paramVarArgs)
    {
      DocumentModel localDocumentModel = new DocumentModel();
      if (PageGridActivity.h(PageGridActivity.this)) {
        return localDocumentModel.b(new long[] { PageGridActivity.f(PageGridActivity.this) });
      }
      if (PageGridActivity.i(PageGridActivity.this))
      {
        PageGridActivity.c(PageGridActivity.this).dl("from Suggestions");
        Object localObject = localDocumentModel.a(PageGridActivity.j(PageGridActivity.this).FJ(), PageGridActivity.j(PageGridActivity.this).Gd(), PageGridActivity.j(PageGridActivity.this).Gc(), PageGridActivity.k(PageGridActivity.this), PageGridActivity.l(PageGridActivity.this));
        if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
        {
          int j = ((Cursor)localObject).getCount();
          PageGridActivity.c(PageGridActivity.this).dl("from Suggestions doclist count = " + j);
          paramVarArgs = new long[j];
          i = 0;
          while (i < j)
          {
            paramVarArgs[i] = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("_id"));
            ((Cursor)localObject).moveToNext();
            i += 1;
          }
          PageGridActivity.c(PageGridActivity.this).dl("from Suggestions ids = " + Arrays.toString(paramVarArgs));
        }
        for (;;)
        {
          if (localObject != null) {
            ((Cursor)localObject).close();
          }
          localObject = localDocumentModel.a(PageGridActivity.j(PageGridActivity.this).FJ(), paramVarArgs, null);
          if (((HashMap)localObject).get(Long.valueOf(PageGridActivity.f(PageGridActivity.this))) == null) {
            break;
          }
          PageGridActivity.c(PageGridActivity.this).dl("from Suggestions suggPages != null");
          paramVarArgs = localDocumentModel.b(new long[] { PageGridActivity.f(PageGridActivity.this) });
          PageGridActivity.a(PageGridActivity.this, ((bi)((HashMap)localObject).get(Long.valueOf(PageGridActivity.f(PageGridActivity.this)))).HL());
          PageGridActivity.c(PageGridActivity.this).dl("from Suggestions checkedPagesIds = " + Arrays.toString(PageGridActivity.d(PageGridActivity.this)));
          this.aFz = true;
          return paramVarArgs;
          paramVarArgs = new long[0];
        }
        PageGridActivity.c(PageGridActivity.this).dl("from Suggestions suggPages == null ");
        Set localSet = ((HashMap)localObject).keySet();
        localObject = new long[paramVarArgs.length + localSet.size()];
        System.arraycopy(paramVarArgs, 0, localObject, 0, paramVarArgs.length);
        int i = paramVarArgs.length;
        paramVarArgs = localSet.iterator();
        while (paramVarArgs.hasNext()) {
          localObject[i] = ((Long)paramVarArgs.next()).longValue();
        }
        PageGridActivity.c(PageGridActivity.this).dl("from Suggestions finalds = " + Arrays.toString((long[])localObject));
        return localDocumentModel.b((long[])localObject);
      }
      return localDocumentModel.a(PageGridActivity.j(PageGridActivity.this).FJ(), PageGridActivity.j(PageGridActivity.this).Gd(), PageGridActivity.j(PageGridActivity.this).Gc(), PageGridActivity.k(PageGridActivity.this), PageGridActivity.l(PageGridActivity.this));
    }
  }
  
  public class c
    extends FragmentStatePagerAdapter
  {
    private int aFA = 0;
    private boolean aFB = false;
    private com.mobisystems.mobiscanner.model.b[] aFC;
    private HashMap<Long, Integer> aFD = new HashMap();
    private int aFE = -1;
    private boolean[] aFF = null;
    private Cursor mCursor;
    
    public c(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public void c(Cursor paramCursor)
    {
      if (this.mCursor == paramCursor) {
        return;
      }
      Cursor localCursor = this.mCursor;
      this.mCursor = paramCursor;
      this.aFF = null;
      this.aFC = null;
      this.aFD.clear();
      int j;
      if (this.mCursor != null)
      {
        this.aFF = new boolean[this.mCursor.getCount()];
        this.aFC = new com.mobisystems.mobiscanner.model.b[this.mCursor.getCount()];
        j = 0;
        this.mCursor.moveToFirst();
      }
      for (;;)
      {
        int i = j;
        if (!this.mCursor.isAfterLast())
        {
          if (this.mCursor.getLong(this.mCursor.getColumnIndex("_id")) == PageGridActivity.f(PageGridActivity.this))
          {
            i = this.mCursor.getPosition();
            this.aFC[i] = new com.mobisystems.mobiscanner.model.b(this.mCursor);
            this.aFD.put(Long.valueOf(PageGridActivity.f(PageGridActivity.this)), Integer.valueOf(i));
          }
        }
        else
        {
          setStartPosition(i);
          j = PageGridActivity.g(PageGridActivity.this).F();
          PageGridActivity.g(PageGridActivity.this).j(i);
          if (i == j) {
            PageGridActivity.this.g(i);
          }
          notifyDataSetChanged();
          if (localCursor == null) {
            break;
          }
          localCursor.close();
          return;
        }
        this.mCursor.moveToNext();
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      PageGridActivity.this.aFo.remove(paramInt);
      PageGridActivity.g(PageGridActivity.this).f(null, paramInt);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
    }
    
    public void e(com.mobisystems.mobiscanner.model.b paramb)
    {
      long l = paramb.getId();
      Integer localInteger = (Integer)this.aFD.get(Long.valueOf(l));
      if ((localInteger != null) && (localInteger.intValue() < this.aFC.length)) {
        this.aFC[localInteger.intValue()] = paramb;
      }
    }
    
    public int getCount()
    {
      if (this.mCursor == null) {
        return 0;
      }
      return this.mCursor.getCount();
    }
    
    public Fragment getItem(int paramInt)
    {
      PageGridActivity.c(PageGridActivity.this).dl("getItem pos = " + paramInt);
      if (this.mCursor == null) {
        return null;
      }
      au localau = new au();
      Bundle localBundle = new Bundle();
      this.mCursor.moveToPosition(paramInt);
      long l1 = this.mCursor.getLong(this.mCursor.getColumnIndex("_id"));
      long l2 = this.mCursor.getLong(this.mCursor.getColumnIndex("doc_title_page_id"));
      localBundle.putLong("PAGE_GRID_FRAGMENT_DOC_ID", l1);
      localBundle.putLong("PAGE_GRID_FRAGMENT_TITLE_PAGE_ID", l2);
      int j = 0;
      int i = j;
      if (this.aFF != null)
      {
        i = j;
        if (this.aFF.length > paramInt) {
          i = this.aFF[paramInt];
        }
      }
      localBundle.putBoolean("DOC_DISPLAYED_FLAG", i);
      localau.setArguments(localBundle);
      if (this.aFC[paramInt] == null)
      {
        this.aFC[paramInt] = new com.mobisystems.mobiscanner.model.b(this.mCursor);
        this.aFD.put(Long.valueOf(l1), Integer.valueOf(paramInt));
      }
      return localau;
    }
    
    public com.mobisystems.mobiscanner.model.b go(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.aFC != null)
      {
        localObject1 = localObject2;
        if (paramInt < this.aFC.length) {
          localObject1 = this.aFC[paramInt];
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.mCursor != null)
        {
          localObject2 = localObject1;
          if (this.mCursor.moveToPosition(paramInt)) {
            localObject2 = new com.mobisystems.mobiscanner.model.b(this.mCursor);
          }
        }
      }
      return (com.mobisystems.mobiscanner.model.b)localObject2;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
      PageGridActivity.this.aFo.put(paramInt, paramViewGroup);
      PageGridActivity.g(PageGridActivity.this).f(paramViewGroup, paramInt);
      return paramViewGroup;
    }
    
    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      PageGridActivity.c(PageGridActivity.this).dl("setPrimaryItem pos = " + paramInt);
      if (((!this.aFB) && ((paramInt != this.aFA) || (this.mCursor == null))) || (paramObject == null)) {
        return;
      }
      this.aFB = true;
      PageGridActivity.a(PageGridActivity.this, (au)paramObject);
      if ((this.aFF != null) && (this.aFF.length > paramInt)) {
        this.aFF[paramInt] = true;
      }
      PageGridActivity.b(PageGridActivity.this).Hz();
      if (PageGridActivity.this.Fp() != null)
      {
        if (PageGridActivity.d(PageGridActivity.this) != null) {
          PageGridActivity.b(PageGridActivity.this).a(PageGridActivity.d(PageGridActivity.this));
        }
        PageGridActivity.e(PageGridActivity.this);
      }
      PageGridActivity.b(PageGridActivity.this).redrawList();
      if ((this.aFE >= 0) && (this.aFE != paramInt))
      {
        ((au)PageGridActivity.this.aFo.get(this.aFE)).HA();
        ((au)PageGridActivity.this.aFo.get(this.aFE)).redrawList();
      }
      this.aFE = paramInt;
    }
    
    public void setStartPosition(int paramInt)
    {
      this.aFA = paramInt;
    }
  }
  
  private class d
    extends AsyncTask<Void, Void, com.mobisystems.mobiscanner.model.b>
  {
    long aAa;
    int aCf;
    
    public d(long paramLong, int paramInt)
    {
      this.aAa = paramLong;
      this.aCf = paramInt;
    }
    
    public com.mobisystems.mobiscanner.model.b a(Void... paramVarArgs)
    {
      paramVarArgs = null;
      DocumentModel localDocumentModel = new DocumentModel();
      if (localDocumentModel.b(this.aAa, this.aCf)) {
        paramVarArgs = localDocumentModel.ae(this.aAa);
      }
      return paramVarArgs;
    }
    
    public void b(com.mobisystems.mobiscanner.model.b paramb)
    {
      if (paramb == null) {
        if (this.aCf <= 0) {
          Toast.makeText(PageGridActivity.a(PageGridActivity.this).getSherlockActivity(), OperationStatus.awl.Ds(), 0).show();
        }
      }
      while (PageGridActivity.b(PageGridActivity.this) == null)
      {
        return;
        Toast.makeText(PageGridActivity.a(PageGridActivity.this).getSherlockActivity(), OperationStatus.awk.Ds(), 0).show();
        return;
      }
      PageGridActivity.this.a(PageGridActivity.b(PageGridActivity.this).getTag(), paramb);
    }
  }
  
  private class e
    extends AsyncTask<String, Void, com.mobisystems.mobiscanner.model.c>
  {
    private boolean aFG;
    private long axO;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.axO = paramLong;
      this.aFG = paramBoolean;
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      if ((paramc != null) && (PageGridActivity.b(PageGridActivity.this) != null) && (this.aFG)) {
        PageGridActivity.b(PageGridActivity.this).reloadContent();
      }
    }
    
    public com.mobisystems.mobiscanner.model.c h(String... paramVarArgs)
    {
      Object localObject = paramVarArgs[0];
      paramVarArgs = null;
      DocumentModel localDocumentModel = new DocumentModel();
      boolean bool2;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        bool2 = localDocumentModel.a(this.axO, (String)localObject, true);
        File localFile = new File(PageGridActivity.this.aFq);
        localObject = new File((String)localObject);
        if (!localFile.delete()) {
          PageGridActivity.c(PageGridActivity.this).dl("SetProcessedImageTask: could not delete" + localFile.getAbsolutePath());
        }
        bool1 = bool2;
        if (!((File)localObject).delete()) {
          PageGridActivity.c(PageGridActivity.this).dl("SetProcessedImageTask: could not delete" + ((File)localObject).getAbsolutePath());
        }
      }
      for (boolean bool1 = bool2;; bool1 = localDocumentModel.al(this.axO))
      {
        if (bool1) {
          paramVarArgs = localDocumentModel.aj(this.axO);
        }
        return paramVarArgs;
      }
    }
  }
  
  private class f
    extends AsyncTask<Void, Void, com.mobisystems.mobiscanner.model.b>
  {
    long aAa;
    
    public f(long paramLong)
    {
      this.aAa = paramLong;
    }
    
    public com.mobisystems.mobiscanner.model.b a(Void... paramVarArgs)
    {
      paramVarArgs = null;
      DocumentModel localDocumentModel = new DocumentModel();
      if (localDocumentModel.ar(this.aAa)) {
        paramVarArgs = localDocumentModel.ae(this.aAa);
      }
      return paramVarArgs;
    }
    
    public void b(com.mobisystems.mobiscanner.model.b paramb) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/PageGridActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */