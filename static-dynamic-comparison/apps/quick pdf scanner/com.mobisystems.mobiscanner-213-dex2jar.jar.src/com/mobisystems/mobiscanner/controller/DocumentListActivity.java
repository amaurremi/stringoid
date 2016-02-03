package com.mobisystems.mobiscanner.controller;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Watson.OnOptionsItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnActionExpandListener;
import com.google.analytics.tracking.android.l;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.d.a;
import com.google.android.gms.analytics.d.d;
import com.google.android.gms.analytics.d.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.b.b;
import com.google.android.gms.drive.e.a;
import com.google.android.gms.drive.f;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.a;
import com.google.api.a.a.a.b;
import com.google.api.a.a.a.b.c;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d.b;
import com.mobisystems.mobiscanner.common.util.e;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DocumentListActivity
  extends SherlockFragmentActivity
  implements Watson.OnOptionsItemSelectedListener, View.OnClickListener, View.OnLongClickListener, SearchView.OnQueryTextListener, ActionMode.Callback, MenuItem.OnActionExpandListener, com.google.android.gms.common.api.c.c, c.d, aa.a, c.a, k, s
{
  private ViewGroup aAA;
  private com.google.android.gms.common.api.c aAB;
  private boolean aAC = true;
  private boolean aAD = false;
  private com.google.android.gms.drive.c aAE;
  private DriveId aAF = null;
  private DriveId aAG = null;
  private DriveId aAH = null;
  private ProgressDialog aAI;
  private ProgressDialog aAJ;
  private boolean aAK = false;
  private com.google.api.client.googleapis.extensions.android.gms.auth.a aAL;
  private boolean aAM = false;
  private Menu aAk;
  private Menu aAl;
  private boolean aAm = false;
  private String aAn = "";
  private DocumentListFragment aAo;
  private String aAp;
  private boolean aAq;
  private AdView aAr;
  private boolean aAs = true;
  private Handler aAt = new Handler();
  private Handler aAu = new Handler();
  private Runnable aAv = new Runnable()
  {
    public void run()
    {
      if ((DocumentListActivity.a(DocumentListActivity.this) != null) && (DocumentListActivity.a(DocumentListActivity.this).isConnected())) {
        com.google.android.gms.drive.a.sO.c(DocumentListActivity.a(DocumentListActivity.this)).a(new com.google.android.gms.common.api.g()
        {
          public void i(Status paramAnonymous2Status) {}
        });
      }
      DocumentListActivity.c(DocumentListActivity.this).postDelayed(DocumentListActivity.b(DocumentListActivity.this), 10000L);
    }
  };
  Runnable aAw = new Runnable()
  {
    public void run()
    {
      DocumentListActivity.a(DocumentListActivity.this, false);
      DocumentListActivity.d(DocumentListActivity.this);
    }
  };
  Runnable aAx = new Runnable()
  {
    public void run()
    {
      DocumentListActivity.e(DocumentListActivity.this);
    }
  };
  private BroadcastReceiver aAy;
  private ActionBarDrawerToggle aAz;
  private ActionMode mActionMode = null;
  private DrawerLayout mDrawerLayout;
  final com.mobisystems.mobiscanner.common.util.c.c mGotInventoryListener = new com.mobisystems.mobiscanner.common.util.c.c()
  {
    public void onQueryInventoryFinished(com.mobisystems.mobiscanner.common.util.d paramAnonymousd, e paramAnonymouse)
    {
      DocumentListActivity.f(DocumentListActivity.this).dl("Query inventory finished.");
      if (DocumentListActivity.h(DocumentListActivity.this) != null)
      {
        if (paramAnonymousd.isFailure())
        {
          DocumentListActivity.f(DocumentListActivity.this).A("**** IAB Error: Failed to query inventory: " + paramAnonymousd);
          DocumentListActivity.d(DocumentListActivity.this);
        }
      }
      else
      {
        DocumentListActivity.g(DocumentListActivity.this);
        return;
      }
      DocumentListActivity.f(DocumentListActivity.this).dl("Query inventory was successful.");
      paramAnonymousd = paramAnonymouse.dw("mobiscanner.remove_ads");
      com.mobisystems.mobiscanner.common.util.g localg = paramAnonymouse.dw("mobiscanner.year1");
      paramAnonymouse = paramAnonymouse.dw("mobiscanner.year1.sony");
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(DocumentListActivity.this);
      boolean bool;
      label143:
      int i;
      if (((localg != null) && (com.mobisystems.mobiscanner.common.d.a(localg))) || ((paramAnonymouse != null) && (com.mobisystems.mobiscanner.common.d.a(paramAnonymouse))))
      {
        bool = true;
        if (com.mobisystems.office.a.a.aB(DocumentListActivity.this).aNm != 2) {
          break label263;
        }
        i = 1;
        label159:
        if (((paramAnonymousd != null) && (com.mobisystems.mobiscanner.common.d.a(paramAnonymousd))) || (bool) || (i != 0)) {
          break label268;
        }
        DocumentListActivity.d(DocumentListActivity.this, false);
      }
      for (;;)
      {
        paramAnonymousd = localSharedPreferences.edit();
        paramAnonymousd.putBoolean(CommonPreferences.Keys.apJ.getKey(), DocumentListActivity.q(DocumentListActivity.this));
        paramAnonymousd.putBoolean(CommonPreferences.Keys.apK.getKey(), bool);
        paramAnonymousd.commit();
        if ((!bool) && (i == 0)) {
          break;
        }
        DocumentListActivity.j(DocumentListActivity.this);
        break;
        bool = false;
        break label143;
        label263:
        i = 0;
        break label159;
        label268:
        DocumentListActivity.d(DocumentListActivity.this, true);
      }
    }
  };
  private com.mobisystems.mobiscanner.common.util.c mHelper;
  private boolean mIsPaidForAdsRemoval = false;
  private boolean mIsSonyReferrer = false;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  com.mobisystems.mobiscanner.common.util.c.a mPurchaseFinishedListener = new com.mobisystems.mobiscanner.common.util.c.a()
  {
    public void onIabPurchaseFinished(com.mobisystems.mobiscanner.common.util.d paramAnonymousd, com.mobisystems.mobiscanner.common.util.g paramAnonymousg)
    {
      DocumentListActivity.f(DocumentListActivity.this).dl("Purchase finished: " + paramAnonymousd + ", purchase: " + paramAnonymousg);
      if (DocumentListActivity.h(DocumentListActivity.this) == null) {}
      com.google.android.gms.analytics.g localg;
      do
      {
        return;
        localg = ((MyApplication)DocumentListActivity.this.getApplication()).a(MyApplication.TrackerName.aDE);
        if (paramAnonymousd.isFailure())
        {
          DocumentListActivity.f(DocumentListActivity.this).dl("Error purchasing: " + paramAnonymousd);
          Toast.makeText(DocumentListActivity.this, paramAnonymousd.getMessage(), 1).show();
          localg.c(new d.a().O("QPDF Prem No").P(paramAnonymousd.getMessage()).Q(Build.BRAND + " - " + Build.MODEL).kg());
          return;
        }
        if (!com.mobisystems.mobiscanner.common.d.a(paramAnonymousg))
        {
          DocumentListActivity.f(DocumentListActivity.this).dl("Error purchasing. Authenticity verification failed.");
          return;
        }
        DocumentListActivity.f(DocumentListActivity.this).dl("Purchase successful.");
      } while ((!paramAnonymousg.DY().equals("mobiscanner.year1")) && (!paramAnonymousg.DY().equals("mobiscanner.year1.sony")));
      localg.c(new d.a().O("QPDF Prem Yes").P(paramAnonymousd.getMessage()).Q(Build.BRAND + " - " + Build.MODEL).kg());
      localg.c(new d.e().W(paramAnonymousg.DX()).X("Quick PDF").f(4.99D).Y("USD").h(0.0D).g(0.3D * 4.99D).kg());
      localg.c(new d.d().T(paramAnonymousg.DX()).U("Quick PDF Premium Account").V(paramAnonymousg.DY()).e(4.99D).c(1L).kg());
      DocumentListActivity.f(DocumentListActivity.this).dl("Purchase is premium upgrade. Congratulating user.");
      paramAnonymousd = PreferenceManager.getDefaultSharedPreferences(DocumentListActivity.this).edit();
      paramAnonymousd.putBoolean(CommonPreferences.Keys.apK.getKey(), true);
      DocumentListActivity.j(DocumentListActivity.this);
      paramAnonymousd.commit();
    }
  };
  private boolean mResumed = false;
  
  private void FA()
  {
    try
    {
      if (com.mobisystems.mobiscanner.common.d.ab(this).exists())
      {
        DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            DocumentListActivity.l(DocumentListActivity.this);
          }
        };
        com.mobisystems.mobiscanner.common.d.a(this, 2131296752, -1, getString(2131296806), 2131296831, local7, 2131296834, null);
        return;
      }
      com.mobisystems.mobiscanner.common.d.a(this, 2131296752, -1, getString(2131296807), 2131296831, null, -1, null);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void FB()
  {
    b(new c()
    {
      public void a(DriveId paramAnonymousDriveId, Date paramAnonymousDate)
      {
        if (paramAnonymousDriveId == null)
        {
          com.google.android.gms.drive.a.sO.a(DocumentListActivity.a(DocumentListActivity.this)).a(new h(this.aAV, this.aAW, DocumentListActivity.a(DocumentListActivity.this), com.google.android.gms.drive.a.sO.b(DocumentListActivity.a(DocumentListActivity.this)).mV(), new z(DocumentListActivity.a(DocumentListActivity.this), null, DocumentListActivity.this, this.aAV, DocumentListActivity.this)));
          return;
        }
        DocumentListActivity.a(DocumentListActivity.this, com.google.android.gms.drive.a.sO.a(DocumentListActivity.a(DocumentListActivity.this), paramAnonymousDriveId));
        DocumentListActivity.n(DocumentListActivity.this).a(DocumentListActivity.a(DocumentListActivity.this), 536870912, new com.google.android.gms.drive.c.a()
        {
          public void a(long paramAnonymous2Long1, long paramAnonymous2Long2) {}
        }).a(new aa(paramAnonymousDriveId, DocumentListActivity.a(DocumentListActivity.this), DocumentListActivity.this, this.aAV, DocumentListActivity.this));
      }
    });
  }
  
  private void FE()
  {
    this.aAt.postDelayed(this.aAw, 3000L);
  }
  
  private void Fi()
  {
    final Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this);
    Object localObject2 = getSharedPreferences(getString(2131297115), 4);
    boolean bool1 = ((SharedPreferences)localObject2).getBoolean(CommonPreferences.Keys.apT.getKey(), false);
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean(CommonPreferences.Keys.apU.getKey(), false);
    if ((bool1) || (!bool2)) {
      return;
    }
    localObject2 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (this.aAZ == null)
        {
          paramAnonymousInt = com.google.android.gms.common.d.w(DocumentListActivity.this);
          if (paramAnonymousInt != 0)
          {
            com.google.android.gms.common.d.b(paramAnonymousInt, DocumentListActivity.this, 9003);
            return;
          }
          new Thread(new Runnable()
          {
            public void run()
            {
              if (DocumentListActivity.i(DocumentListActivity.this) == null) {
                DocumentListActivity.a(DocumentListActivity.this, com.google.api.client.googleapis.extensions.android.gms.auth.a.b(DocumentListActivity.this, Arrays.asList(new String[] { "https://www.googleapis.com/auth/drive" })));
              }
              try
              {
                DocumentListActivity.this.startActivityForResult(DocumentListActivity.i(DocumentListActivity.this).wJ(), 9001);
                return;
              }
              catch (ActivityNotFoundException localActivityNotFoundException)
              {
                DocumentListActivity.this.runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    Toast.makeText(DocumentListActivity.this, 2131296984, 1).show();
                  }
                });
              }
            }
          }).start();
          return;
        }
        if (DocumentListActivity.i(DocumentListActivity.this) == null) {
          DocumentListActivity.a(DocumentListActivity.this, com.google.api.client.googleapis.extensions.android.gms.auth.a.b(DocumentListActivity.this, Arrays.asList(new String[] { "https://www.googleapis.com/auth/drive" })));
        }
        DocumentListActivity.i(DocumentListActivity.this).by(this.aAZ);
        new Thread(new Runnable()
        {
          public void run()
          {
            com.google.api.a.a.a locala = new com.google.api.a.a.a.a(com.google.api.client.a.a.a.a.wI(), new com.google.api.client.json.gson.a(), DocumentListActivity.i(DocumentListActivity.this)).yY();
            try
            {
              locala.yX().yZ().xe();
              return;
            }
            catch (UserRecoverableAuthIOException localUserRecoverableAuthIOException)
            {
              DocumentListActivity.this.startActivityForResult(localUserRecoverableAuthIOException.getIntent(), 9002);
              return;
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
        }).start();
      }
    };
    localObject1 = new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        paramAnonymousCompoundButton = localObject1.edit();
        paramAnonymousCompoundButton.putBoolean(CommonPreferences.Keys.apQ.getKey(), paramAnonymousBoolean);
        paramAnonymousCompoundButton.commit();
      }
    };
    com.mobisystems.mobiscanner.common.d.a(this, 2130903079, 2131296872, 2131296754, -1, getString(2131296810), 2131296832, (DialogInterface.OnClickListener)localObject2, 2131296833, null, null, (CompoundButton.OnCheckedChangeListener)localObject1, true);
  }
  
  private void Fj()
  {
    if (this.aAB.isConnected()) {
      new a(this, false).execute(new Void[0]);
    }
  }
  
  private void Fk()
  {
    this.aAu.removeCallbacks(this.aAx);
    this.aAu.postDelayed(this.aAx, 30000L);
  }
  
  private void Fl()
  {
    startService(new Intent(this, GDriveChangeService.class));
  }
  
  private void Fm()
  {
    this.mDrawerLayout = ((DrawerLayout)findViewById(2131165298));
    this.aAz = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130837802, 2131296327, 2131296327)
    {
      public void onDrawerClosed(View paramAnonymousView)
      {
        super.onDrawerClosed(paramAnonymousView);
        DocumentListActivity.this.getActionBar().setTitle(2131296327);
        DocumentListActivity.this.invalidateOptionsMenu();
      }
      
      public void onDrawerOpened(View paramAnonymousView)
      {
        super.onDrawerOpened(paramAnonymousView);
        DocumentListActivity.this.getActionBar().setTitle(2131296327);
        DocumentListActivity.this.invalidateOptionsMenu();
      }
    };
    this.mDrawerLayout.a(this.aAz);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);
    this.aAA = ((ViewGroup)findViewById(2131165434));
    ViewGroup localViewGroup = (ViewGroup)this.aAA.findViewById(2131165435);
    int i = 0;
    while (i < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(i);
      if (localView != null)
      {
        localView.setOnClickListener(this);
        localView.setOnLongClickListener(this);
      }
      i += 1;
    }
    localViewGroup.findViewById(2131165436).setSelected(true);
  }
  
  private void Fn()
  {
    if (!this.mIsPaidForAdsRemoval) {
      this.aAr = com.mobisystems.mobiscanner.common.d.a(this, (FrameLayout)findViewById(2131165299), this.aAr, "", this.aAs, false);
    }
  }
  
  private void Fo()
  {
    findViewById(2131165439).setVisibility(8);
  }
  
  private void Fs()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, CameraActivity.class);
    startActivity(localIntent);
  }
  
  private void Ft()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, SettingsActivity.class);
    startActivity(localIntent);
  }
  
  private void Fu()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, AboutActivity.class);
    startActivity(localIntent);
  }
  
  private void Fv()
  {
    this.aAo.reloadContent();
  }
  
  private DocumentListFragment Fw()
  {
    DocumentListFragment localDocumentListFragment2 = (DocumentListFragment)getSupportFragmentManager().findFragmentByTag("DOCUMENT_LIST_FRAGMENT");
    DocumentListFragment localDocumentListFragment1 = localDocumentListFragment2;
    if (localDocumentListFragment2 == null)
    {
      localDocumentListFragment1 = new DocumentListFragment();
      getSupportFragmentManager().beginTransaction().add(2131165300, localDocumentListFragment1, "DOCUMENT_LIST_FRAGMENT").commit();
    }
    return localDocumentListFragment1;
  }
  
  private void Fx()
  {
    this.aAC = false;
    if (!this.aAB.isConnected())
    {
      ge(2131296750);
      return;
    }
    DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DocumentListActivity.k(DocumentListActivity.this);
      }
    };
    try
    {
      if (com.mobisystems.mobiscanner.common.d.aa(this).exists())
      {
        com.mobisystems.mobiscanner.common.d.a(this, 2131296751, -1, getString(2131297110), 2131296831, local6, 2131296834, null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      com.mobisystems.mobiscanner.common.d.a(this, 2131296750, -1, getString(2131297111), 2131296831, local6, 2131296834, null);
      return;
    }
    com.mobisystems.mobiscanner.common.d.a(this, 2131296750, -1, getString(2131297111), 2131296831, local6, 2131296834, null);
  }
  
  private void Fy()
  {
    this.aAI = new ProgressDialog(this);
    this.aAI.setIndeterminate(true);
    this.aAI.setMessage(getString(2131297112));
    this.aAI.setCancelable(false);
    this.aAI.setCanceledOnTouchOutside(false);
    this.aAI.show();
    new c(this, this).execute(new Void[0]);
  }
  
  private void Fz()
  {
    this.aAJ = new ProgressDialog(this);
    this.aAJ.setIndeterminate(true);
    this.aAJ.setMessage(getString(2131297113));
    this.aAJ.setCancelable(false);
    this.aAJ.setCanceledOnTouchOutside(false);
    this.aAJ.show();
    new d(null).execute(new Void[0]);
  }
  
  private void a(com.google.android.gms.drive.d paramd, Query paramQuery, final c paramc)
  {
    paramd.a(this.aAB, paramQuery).a(new com.google.android.gms.common.api.g()
    {
      public void a(b.b paramAnonymousb)
      {
        Object localObject1 = null;
        if (!paramAnonymousb.mq().mu())
        {
          DocumentListActivity.f(DocumentListActivity.this).dl("Error while trying to create new file contents");
          return;
        }
        com.google.android.gms.drive.g localg = paramAnonymousb.mR();
        int j = localg.getCount();
        int i = 0;
        label44:
        if (i < j)
        {
          paramAnonymousb = localg.bs(i);
          if (!paramAnonymousb.mY())
          {
            localObject1 = paramAnonymousb.mV();
            paramAnonymousb = (Date)paramAnonymousb.mX().clone();
          }
        }
        for (;;)
        {
          localg.close();
          if (paramc == null) {
            break;
          }
          paramc.a((DriveId)localObject1, paramAnonymousb);
          return;
          i += 1;
          break label44;
          Object localObject2 = null;
          paramAnonymousb = (b.b)localObject1;
          localObject1 = localObject2;
        }
      }
    });
  }
  
  private void a(final c paramc)
  {
    if (this.aAH == null)
    {
      a(com.mobisystems.mobiscanner.common.d.ak(this), getString(2131297107), new c()
      {
        public void a(DriveId paramAnonymousDriveId, Date paramAnonymousDate)
        {
          DocumentListActivity.a(DocumentListActivity.this, paramAnonymousDriveId);
          paramc.a(paramAnonymousDriveId, paramAnonymousDate);
        }
      });
      return;
    }
    com.google.android.gms.drive.a.sO.a(this.aAB, this.aAH).d(this.aAB).a(new com.google.android.gms.common.api.g()
    {
      public void a(e.a paramAnonymousa)
      {
        if (!paramAnonymousa.mq().mu())
        {
          DocumentListActivity.f(DocumentListActivity.this).dl("Error while trying to get metadata of META file");
          return;
        }
        paramc.a(DocumentListActivity.o(DocumentListActivity.this), paramAnonymousa.mW().mX());
      }
    });
  }
  
  private void a(bd parambd, String paramString)
  {
    long[] arrayOfLong = this.aAo.getCheckedItemIds();
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      this.mLog.dl("startDocumentProgressTask: action=" + paramString + ", number of selected positions=" + arrayOfLong.length);
      Bundle localBundle = new Bundle();
      localBundle.putLongArray("DOCUMENTS", arrayOfLong);
      parambd.setArguments(localBundle);
      parambd.show(getSupportFragmentManager(), paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, c paramc)
  {
    paramString1 = new Query.a().a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ug, paramString1)).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.uh, paramString2)).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ui, Boolean.valueOf(false))).nx();
    a(com.google.android.gms.drive.a.sO.b(this.aAB), paramString1, paramc);
  }
  
  private void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    ae localae = new ae();
    Bundle localBundle = new Bundle();
    new com.mobisystems.mobiscanner.model.b().p(localBundle);
    localBundle.putStringArray("IMAGE_IMPORT_FILES", paramArrayOfString);
    localBundle.putBoolean("COPY_FLAG", paramBoolean);
    localae.setArguments(localBundle);
    localae.show(getSupportFragmentManager(), "PAGE_ADD");
  }
  
  private void a(String[] paramArrayOfString, boolean paramBoolean, com.mobisystems.mobiscanner.model.b paramb)
  {
    af localaf = new af();
    Bundle localBundle = new Bundle();
    paramb.p(localBundle);
    localBundle.putStringArray("IMAGE_IMPORT_FILES", paramArrayOfString);
    localBundle.putBoolean("COPY_FLAG", paramBoolean);
    localaf.setArguments(localBundle);
    localaf.show(getSupportFragmentManager(), "PAGE_ADD");
  }
  
  private void aV(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    try
    {
      Object localObject = Uri.fromFile(com.mobisystems.mobiscanner.common.d.af(this));
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
  
  private void b(final c paramc)
  {
    if (this.aAG == null)
    {
      a(com.mobisystems.mobiscanner.common.d.aj(this), getString(2131297104), new c()
      {
        public void a(DriveId paramAnonymousDriveId, Date paramAnonymousDate)
        {
          DocumentListActivity.b(DocumentListActivity.this, paramAnonymousDriveId);
          paramc.a(paramAnonymousDriveId, paramAnonymousDate);
        }
      });
      return;
    }
    com.google.android.gms.drive.a.sO.a(this.aAB, this.aAG).d(this.aAB).a(new com.google.android.gms.common.api.g()
    {
      public void a(e.a paramAnonymousa)
      {
        if (!paramAnonymousa.mq().mu())
        {
          DocumentListActivity.f(DocumentListActivity.this).dl("Error while trying to get metadata of BackUP file");
          return;
        }
        paramc.a(DocumentListActivity.p(DocumentListActivity.this), paramAnonymousa.mW().mX());
      }
    });
  }
  
  private void b(com.mobisystems.mobiscanner.model.b paramb, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(this, PageGridActivity.class);
    t localt = new t();
    localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramb.getId());
    localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", 0);
    if (this.aAk != null)
    {
      paramb = ((SearchView)this.aAk.findItem(2131165555).getActionView()).getQuery();
      if (paramb == null) {}
    }
    for (paramb = paramb.toString().trim();; paramb = "")
    {
      localt.setFilterText(paramb);
      localt.f(localIntent);
      localIntent.putExtra("OPEN_DOCUMENT_FROM_SUGGESTION", paramBoolean);
      startActivityForResult(localIntent, 3);
      return;
    }
  }
  
  private void d(Intent paramIntent)
  {
    int k = 1;
    String str = paramIntent.getAction();
    Object localObject;
    int i;
    if (("android.intent.action.SEND".equals(str)) || ("android.intent.action.VIEW".equals(str)))
    {
      localObject = null;
      if ("android.intent.action.SEND".equals(str))
      {
        localObject = (Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM");
        if (localObject == null) {
          break label294;
        }
        paramIntent = com.mobisystems.mobiscanner.common.d.a(this, (Uri)localObject);
        if (paramIntent == null) {
          break label294;
        }
        a(new String[] { paramIntent }, true);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
      }
      return;
      if (!"android.intent.action.VIEW".equals(str)) {
        break;
      }
      localObject = paramIntent.getData();
      break;
      label170:
      int j;
      if ("android.intent.action.SEND_MULTIPLE".equals(str))
      {
        localObject = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (localObject != null)
        {
          paramIntent = new String[((ArrayList)localObject).size()];
          localObject = ((ArrayList)localObject).iterator();
          i = 0;
          if (((Iterator)localObject).hasNext())
          {
            str = com.mobisystems.mobiscanner.common.d.a(this, (Uri)((Iterator)localObject).next());
            if (str == null) {
              break label291;
            }
            j = i + 1;
            paramIntent[i] = str;
            i = j;
          }
        }
      }
      label233:
      label283:
      label291:
      for (;;)
      {
        break label170;
        if (i > 0)
        {
          localObject = new String[i];
          int n = paramIntent.length;
          j = 0;
          i = 0;
          if (j < n)
          {
            str = paramIntent[j];
            if (str == null) {
              break label283;
            }
            int m = i + 1;
            localObject[i] = str;
            i = m;
          }
          for (;;)
          {
            j += 1;
            break label233;
            a((String[])localObject, true);
            i = k;
            break;
          }
        }
        i = 0;
        break;
      }
      label294:
      i = 0;
    }
  }
  
  private void f(int paramInt, boolean paramBoolean)
  {
    if (this.aAk != null)
    {
      MenuItem localMenuItem = this.aAk.findItem(paramInt);
      if (localMenuItem != null)
      {
        localMenuItem.setChecked(paramBoolean);
        onPrepareOptionsMenu(this.aAk);
      }
    }
  }
  
  private void ge(int paramInt)
  {
    final Object localObject = PreferenceManager.getDefaultSharedPreferences(this);
    DialogInterface.OnClickListener local23 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DocumentListActivity.c(DocumentListActivity.this, true);
        DocumentListActivity.a(DocumentListActivity.this).connect();
      }
    };
    localObject = new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        paramAnonymousCompoundButton = localObject.edit();
        paramAnonymousCompoundButton.putBoolean(CommonPreferences.Keys.apP.getKey(), paramAnonymousBoolean);
        paramAnonymousCompoundButton.commit();
      }
    };
    com.mobisystems.mobiscanner.common.d.a(this, 2130903079, 2131296871, paramInt, -1, getString(2131296811), 2131296832, local23, 2131296833, null, null, (CompoundButton.OnCheckedChangeListener)localObject, true);
  }
  
  private void handleIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject != null) {
      this.mLog.dl("handleIntent, action=" + (String)localObject);
    }
    if (paramIntent.getBooleanExtra("GDRIVE_SERVICE_DOWNLOAD_COMPLETE", false)) {
      FA();
    }
    if (("android.intent.action.SEND".equals(localObject)) || ("android.intent.action.SEND_MULTIPLE".equals(localObject))) {
      d(paramIntent);
    }
    for (;;)
    {
      setIntent(new Intent());
      return;
      if ("android.intent.action.SEARCH".equals(localObject))
      {
        paramIntent = paramIntent.getStringExtra("query");
        if (this.aAk != null) {
          ((SearchView)this.aAk.findItem(2131165555).getActionView()).setQuery(paramIntent, true);
        }
      }
      else if ("android.intent.action.MAIN".equals(localObject))
      {
        if (this.aAk != null)
        {
          paramIntent = this.aAk.findItem(2131165555);
          if (paramIntent.isActionViewExpanded()) {
            paramIntent.collapseActionView();
          }
        }
      }
      else if (("android.intent.action.VIEW".equals(localObject)) && (paramIntent.getData() != null))
      {
        localObject = paramIntent.getData();
        try
        {
          long l = Long.parseLong(((Uri)localObject).toString());
          new b().execute(new Long[] { Long.valueOf(l) });
        }
        catch (NumberFormatException localNumberFormatException)
        {
          d(paramIntent);
        }
      }
    }
  }
  
  private void setContextualActionBar(int paramInt)
  {
    String str = String.format(getResources().getString(2131297012), new Object[] { Integer.valueOf(paramInt) });
    this.mActionMode.setTitle(str);
  }
  
  private void setupIABHelper()
  {
    this.mLog.dl("Creating IAB helper.");
    this.mHelper = new com.mobisystems.mobiscanner.common.util.c(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg7dOuFQyWGPaI1wO7gD21nt4hG8v8hiXVh41n1b0WkSjE4NI6tnFnFzubk25cNlSaydZXvBUrtSMo53MsrxqINWiHI56SrkCPEu4h64u6uWJQluGSMXqxkd09Ay6jVD7KtQTPCGkxUpW3/vYzEKcsM55mtyQvxqqv6i0llkhcCyO9NRJSvYF1LL05ObMmFff+ZHI83TAfanw7FZo+wowr0zqNXxzSn6TMFlUfYeMuoJ3aIRd2X+pptPQ1Ns3VisnI3cVNiL9LCKDPHasVg67abxzFw0SQFAvd0RsvRAo8WiE6rEydmf6Qjj5PgipyBnHiHP6Wp7j7GDgliLoRBbPpQIDAQAB");
    this.mHelper.enableDebugLogging(false);
    this.mLog.dl("Starting setup.");
    this.aAM = false;
    this.mHelper.a(new com.mobisystems.mobiscanner.common.util.c.b()
    {
      public void onIabSetupFinished(com.mobisystems.mobiscanner.common.util.d paramAnonymousd)
      {
        DocumentListActivity.f(DocumentListActivity.this).dl("Setup finished.");
        if (!paramAnonymousd.mu())
        {
          DocumentListActivity.f(DocumentListActivity.this).A("**** IAB Error: Problem setting up in-app billing: " + paramAnonymousd);
          DocumentListActivity.g(DocumentListActivity.this);
          return;
        }
        if (DocumentListActivity.h(DocumentListActivity.this) == null)
        {
          DocumentListActivity.g(DocumentListActivity.this);
          return;
        }
        DocumentListActivity.f(DocumentListActivity.this).dl("Setup successful. Querying inventory.");
        DocumentListActivity.b(DocumentListActivity.this, true);
        DocumentListActivity.h(DocumentListActivity.this).a(DocumentListActivity.this.mGotInventoryListener);
      }
    });
  }
  
  public void Em()
  {
    a(new c()
    {
      public void a(DriveId paramAnonymousDriveId, Date paramAnonymousDate)
      {
        if (paramAnonymousDriveId == null)
        {
          com.google.android.gms.drive.a.sO.a(DocumentListActivity.a(DocumentListActivity.this)).a(new h(this.aAS, this.aAT, DocumentListActivity.a(DocumentListActivity.this), com.google.android.gms.drive.a.sO.b(DocumentListActivity.a(DocumentListActivity.this)).mV(), new z(DocumentListActivity.a(DocumentListActivity.this), null, DocumentListActivity.this, this.aAS, DocumentListActivity.this)));
          DocumentListActivity.m(DocumentListActivity.this);
          return;
        }
        com.google.android.gms.drive.a.sO.a(DocumentListActivity.a(DocumentListActivity.this), paramAnonymousDriveId).a(DocumentListActivity.a(DocumentListActivity.this), 536870912, new com.google.android.gms.drive.c.a()
        {
          public void a(long paramAnonymous2Long1, long paramAnonymous2Long2) {}
        }).a(new aa(paramAnonymousDriveId, DocumentListActivity.a(DocumentListActivity.this), DocumentListActivity.this, this.aAS, DocumentListActivity.this));
        DocumentListActivity.m(DocumentListActivity.this);
      }
    });
  }
  
  public int FC()
  {
    View localView = findViewById(2131165299);
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public void FD()
  {
    SharedPreferences localSharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences localSharedPreferences2 = getSharedPreferences(getString(2131297115), 4);
    if ((localSharedPreferences1.getBoolean(CommonPreferences.Keys.apQ.getKey(), true)) && (!localSharedPreferences2.getBoolean(CommonPreferences.Keys.apT.getKey(), false))) {
      Fi();
    }
  }
  
  public ActionMode Fp()
  {
    return this.mActionMode;
  }
  
  public void Fq()
  {
    if (-1 < com.mobisystems.mobiscanner.common.d.Du())
    {
      if ((CommonPreferences.Keys.apr.Dm()) && (!com.mobisystems.mobiscanner.common.d.DF()))
      {
        Fs();
        return;
      }
      aV(true);
      return;
    }
    aV(false);
  }
  
  public void Fr()
  {
    startActivityForResult(Intent.createChooser(com.mobisystems.mobiscanner.common.d.DG(), getResources().getText(2131296739)), 2);
  }
  
  public void a(Bundle paramBundle)
  {
    this.mLog.dl("onConnected ");
    paramBundle = PreferenceManager.getDefaultSharedPreferences(this).edit();
    paramBundle.putBoolean(CommonPreferences.Keys.apR.getKey(), true);
    paramBundle.commit();
    if (!this.aAD)
    {
      if (this.aAC) {
        FA();
      }
    }
    else {
      return;
    }
    Fx();
  }
  
  public void a(Status paramStatus, String paramString)
  {
    boolean bool = paramStatus.mu();
    if (!bool) {
      Toast.makeText(this, "Problem while writing backup " + paramStatus.toString(), 1).show();
    }
    if ((this.aAI != null) && ((com.mobisystems.mobiscanner.common.d.ak(this).equals(paramString)) || (!bool)))
    {
      this.aAI.hide();
      this.aAI = null;
      com.mobisystems.mobiscanner.common.d.a(this, 2131296750, -1, getString(2131297109), 2131296831, null, -1, null);
    }
  }
  
  public void a(com.google.android.gms.common.b paramb)
  {
    if (paramb.mh()) {
      try
      {
        paramb.a(this, 9000);
        return;
      }
      catch (IntentSender.SendIntentException paramb)
      {
        paramb.printStackTrace();
        return;
      }
    }
    this.mLog.dl("onConnectionFailed error = " + paramb.toString() + " ; code = " + paramb.getErrorCode());
    com.google.android.gms.common.d.a(paramb.getErrorCode(), this, 0).show();
  }
  
  public void aW(boolean paramBoolean)
  {
    f(2131165557, paramBoolean);
  }
  
  public void aX(boolean paramBoolean)
  {
    f(2131165558, paramBoolean);
  }
  
  public void bl(int paramInt)
  {
    this.mLog.dl("onConnected suspended ");
  }
  
  public void dA(String paramString)
  {
    startActionMode(this);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      Menu localMenu = this.aAk;
      if (Fp() != null) {
        localMenu = this.aAl;
      }
      if ((localMenu != null) && (localMenu.findItem(2131165556) != null))
      {
        localMenu.performIdentifierAction(2131165556, 0);
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void k(String paramString, int paramInt)
  {
    if (paramInt > 0) {
      if (this.mActionMode == null) {
        dA(paramString);
      }
    }
    while (this.mActionMode == null)
    {
      return;
      setContextualActionBar(paramInt);
      return;
    }
    Fp().finish();
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return this.aAo.onActionItemClicked(paramActionMode, paramMenuItem);
    case 2131165586: 
      a(new q(), "DOCUMENT_EXPORT");
      return true;
    case 2131165582: 
      a(new q(), "DOCUMENT_SHARE");
      return true;
    case 2131165607: 
      a(new m(), "DOCUMENT_COPY");
      return true;
    case 2131165589: 
      a(new o(), "DOCUMENT_DELETE");
      return true;
    case 2131165557: 
      if (!paramMenuItem.isChecked()) {
        bool1 = true;
      }
      paramMenuItem.setChecked(bool1);
      this.aAo.d(bool1, true);
      onPrepareOptionsMenu(paramActionMode.getMenu());
      return true;
    case 2131165558: 
      bool1 = bool2;
      if (!paramMenuItem.isChecked()) {
        bool1 = true;
      }
      paramMenuItem.setChecked(bool1);
      this.aAo.e(bool1, true);
      onPrepareOptionsMenu(paramActionMode.getMenu());
      return true;
    }
    HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aDa);
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    final SharedPreferences.Editor localEditor = null;
    boolean bool = true;
    this.mLog.dl("onActivityResult called, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if ((this.aAM) && (this.mHelper.a(paramInt1, paramInt2, paramIntent))) {
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == -1) {
        if (paramInt1 == 1)
        {
          String str = this.aAn;
          if (str == null) {
            break label424;
          }
          paramIntent = new String[1];
          paramIntent[0] = str;
          bool = false;
        }
      }
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.length > 0))
      {
        a(paramIntent, bool, new com.mobisystems.mobiscanner.model.b());
        return;
        paramIntent = com.mobisystems.mobiscanner.common.d.d(this, paramIntent);
      }
      else
      {
        Toast.makeText(this, OperationStatus.avL.Ds(), 0).show();
        return;
        if (paramInt2 == 0) {
          break;
        }
        Toast.makeText(this, OperationStatus.avK.Ds(), 0).show();
        return;
        if (3 == paramInt1)
        {
          this.aAo.e(paramIntent);
          return;
        }
        if (paramInt1 == 9000)
        {
          if (paramInt2 != -1) {
            break;
          }
          this.aAB.connect();
          return;
        }
        if (paramInt1 == 9001)
        {
          if ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getExtras() == null)) {
            break;
          }
          paramIntent = paramIntent.getStringExtra("authAccount");
          if (paramIntent == null) {
            break;
          }
          localEditor = getSharedPreferences(getString(2131297115), 4).edit();
          localEditor.putString(CommonPreferences.Keys.apS.getKey(), paramIntent);
          localEditor.commit();
          com.mobisystems.mobiscanner.common.d.an(this);
          this.aAL.by(paramIntent);
          new Thread(new Runnable()
          {
            public void run()
            {
              com.google.api.a.a.a locala = new com.google.api.a.a.a.a(com.google.api.client.a.a.a.a.wI(), new com.google.api.client.json.gson.a(), DocumentListActivity.i(DocumentListActivity.this)).yY();
              try
              {
                locala.yX().yZ().xe();
                localEditor.putBoolean(CommonPreferences.Keys.apT.getKey(), true);
                localEditor.commit();
                com.mobisystems.mobiscanner.common.d.an(DocumentListActivity.this);
                return;
              }
              catch (UserRecoverableAuthIOException localUserRecoverableAuthIOException)
              {
                DocumentListActivity.this.startActivityForResult(localUserRecoverableAuthIOException.getIntent(), 9002);
                return;
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
          }).start();
          com.mobisystems.mobiscanner.common.d.a(this, 2131296754, -1, getString(2131296812), 2131296831, null, -1, null);
          return;
        }
        if (paramInt1 == 9002)
        {
          if (paramInt2 != -1) {
            break;
          }
          paramIntent = getSharedPreferences(getString(2131297115), 4).edit();
          paramIntent.putBoolean(CommonPreferences.Keys.apT.getKey(), true);
          paramIntent.commit();
          com.mobisystems.mobiscanner.common.d.an(this);
          return;
        }
        if (paramInt1 == 9003)
        {
          if (paramInt2 != -1) {
            break;
          }
          Fi();
          return;
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
        label424:
        bool = false;
        paramIntent = localEditor;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.mDrawerLayout.v(this.aAA))
    {
      this.mDrawerLayout.u(this.aAA);
      return;
    }
    if (this.aAB.isConnected())
    {
      new a(this, true).execute(new Void[0]);
      return;
    }
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    this.mDrawerLayout.u(this.aAA);
    paramView = ((MyApplication)getApplication()).a(MyApplication.TrackerName.aDE);
    switch (i)
    {
    default: 
      return;
    case 2131165437: 
      paramView.c(new d.a().O("Cloud new API").P("Backup").Q(Build.BRAND + " - " + Build.MODEL).kg());
      Fx();
      return;
    case 2131165438: 
      paramView.c(new d.a().O("Cloud new API").P("Restore").Q(Build.BRAND + " - " + Build.MODEL).kg());
      this.aAC = true;
      if (!this.aAB.isConnected())
      {
        ge(2131296752);
        return;
      }
      FA();
      return;
    case 2131165440: 
      Ft();
      return;
    case 2131165442: 
      HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aCZ);
      return;
    case 2131165441: 
      try
      {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setClassName("com.google.android.apps.plus", "com.google.android.apps.plus.phone.UrlGatewayActivity");
        paramView.putExtra("customAppUri", "communities/110079358811518655952");
        startActivity(paramView);
        return;
      }
      catch (ActivityNotFoundException paramView)
      {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/" + "communities/110079358811518655952")));
        return;
      }
    case 2131165443: 
      Fu();
      return;
    }
    if (this.aAM)
    {
      paramView = "mobiscanner.year1";
      if (this.mIsSonyReferrer) {
        paramView = "mobiscanner.year1.sony";
      }
      this.mHelper.a(this, paramView, 4, this.mPurchaseFinishedListener, "");
      return;
    }
    Toast.makeText(this, 2131296983, 1).show();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.aAz.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.mobisystems.mobiscanner.error.a.ay(getApplicationContext());
    this.mLog.dl("OnCreate called");
    super.onCreate(paramBundle);
    setContentView(2130903070);
    this.aAo = Fw();
    this.aAm = false;
    if (paramBundle != null)
    {
      this.aAn = paramBundle.getString("CAMERA_IMAGE_PATH");
      if (this.aAn == null) {
        this.aAn = "";
      }
      this.aAm = paramBundle.getBoolean("ACTION_MODE_STARTED", false);
      this.aAq = paramBundle.getBoolean("SEARCH_EXPANDED", false);
      this.aAp = paramBundle.getString("SEARCH_QUERY");
      if (this.aAp == null) {
        this.aAp = "";
      }
      this.aAs = paramBundle.getBoolean("SHOW_STATIC_BANNER");
    }
    Fm();
    setupIABHelper();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.aAy = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        DocumentListActivity.d(DocumentListActivity.this);
      }
    };
    registerReceiver(this.aAy, paramBundle);
    this.aAB = new com.google.android.gms.common.api.c.b(this).a(com.google.android.gms.drive.a.sN).a(com.google.android.gms.drive.a.sK).a(this).a(this).mp();
    paramBundle = PreferenceManager.getDefaultSharedPreferences(this);
    if (paramBundle.getBoolean(CommonPreferences.Keys.apR.getKey(), false))
    {
      this.aAD = true;
      this.aAB.connect();
    }
    for (;;)
    {
      if (paramBundle.getString(CommonPreferences.Keys.aqb.getKey(), "").equals("sonymobile-reco")) {
        this.mIsSonyReferrer = true;
      }
      Fl();
      return;
      if (paramBundle.getBoolean(CommonPreferences.Keys.apP.getKey(), true)) {
        ge(2131296753);
      }
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    this.mLog.dl("onCreateActionMode called");
    this.mActionMode = paramActionMode;
    paramActionMode.getMenuInflater().inflate(2131689479, paramMenu);
    this.aAl = paramMenu;
    this.aAo.onCreateActionMode(paramActionMode, paramMenu);
    setContextualActionBar(this.aAo.FI());
    return true;
  }
  
  public boolean onCreateOptionsMenu(final Menu paramMenu)
  {
    getSupportMenuInflater().inflate(2131689473, paramMenu);
    this.aAk = paramMenu;
    paramMenu = this.aAk.findItem(2131165555);
    paramMenu.setOnActionExpandListener(this);
    final SearchView localSearchView = (SearchView)paramMenu.getActionView();
    localSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        DocumentListActivity.f(DocumentListActivity.this).dl("onFocusChange focus = " + paramAnonymousBoolean + " ; query = " + localSearchView.getQuery());
        if (!paramAnonymousBoolean) {
          paramMenu.collapseActionView();
        }
      }
    });
    if ((this.aAq) && (!paramMenu.isActionViewExpanded())) {
      paramMenu.expandActionView();
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.aAr != null) {
      this.aAr.destroy();
    }
    unregisterReceiver(this.aAy);
    super.onDestroy();
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mLog.dl("onDestroyActionMode called");
    setContextualActionBar(0);
    this.mActionMode = null;
    this.aAm = false;
    if (this.aAk != null) {
      onPrepareOptionsMenu(this.aAk);
    }
    this.aAo.onDestroyActionMode(paramActionMode);
  }
  
  public void onDialogNegativeAction(String paramString, Bundle paramBundle) {}
  
  public void onDialogPositiveAction(String paramString, Bundle paramBundle)
  {
    if (("DOCUMENT_PROPERTIES".equals(paramString)) || ("DOCUMENT_DELETE".equals(paramString)) || ("DOCUMENT_RENAME".equals(paramString)))
    {
      if (this.mActionMode != null) {
        this.mActionMode.finish();
      }
      Fv();
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!"DOCUMENT_EXPORT".equals(paramString)) && (!"DOCUMENT_OPEN".equals(paramString)) && (!"DOCUMENT_SHARE".equals(paramString))) {
            break;
          }
        } while (this.mActionMode == null);
        this.mActionMode.finish();
        return;
      } while ((!"PAGE_ADD".equals(paramString)) && (!"DOCUMENT_COPY".equals(paramString)));
      if (this.mActionMode != null) {
        this.mActionMode.finish();
      }
      Fv();
      paramBundle = new com.mobisystems.mobiscanner.model.b(paramBundle);
    } while (paramBundle.getId() == -1L);
    if ("PAGE_ADD".equals(paramString))
    {
      paramString = new Intent();
      paramString.setAction("android.intent.action.MAIN");
      paramString.setClass(this, PageEnhanceActivity.class);
      paramBundle.f(paramString);
      paramString.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramBundle.getId());
      startActivity(paramString);
      return;
    }
    b(paramBundle, false);
  }
  
  public boolean onLongClick(View paramView)
  {
    Toast.makeText(this, paramView.getContentDescription(), 0).show();
    return true;
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131165555)
    {
      paramMenuItem = this.aAk.findItem(2131165556);
      if (paramMenuItem != null) {
        paramMenuItem.setVisible(true);
      }
      this.aAp = "";
      this.aAo.FP();
    }
    return true;
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    this.mLog.dl("onMenuItemActionExpand");
    SearchView localSearchView;
    if (paramMenuItem.getItemId() == 2131165555)
    {
      this.aAo.a(DocumentListFragment.ProcType.aCc);
      paramMenuItem = "";
      this.aAo.FO();
      this.aAo.e(false, false);
      aX(false);
      SearchManager localSearchManager = (SearchManager)getSystemService("search");
      localSearchView = (SearchView)this.aAk.findItem(2131165555).getActionView();
      localSearchView.setSearchableInfo(localSearchManager.getSearchableInfo(getComponentName()));
      localSearchView.setSubmitButtonEnabled(false);
      localSearchView.setOnQueryTextListener(this);
      localSearchView.setQueryRefinementEnabled(false);
      if (!this.aAq) {
        break label169;
      }
      paramMenuItem = this.aAp;
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      localSearchView.setQuery(paramMenuItem, bool);
      localSearchView.requestFocus();
      paramMenuItem = this.aAk.findItem(2131165556);
      if (paramMenuItem != null) {
        paramMenuItem.setVisible(false);
      }
      return true;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.mLog.dl("onNewIntent called");
    setIntent(paramIntent);
    if (this.mResumed) {
      handleIntent(getIntent());
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      if (this.mDrawerLayout.z(8388611))
      {
        this.mDrawerLayout.x(8388611);
        return true;
      }
      this.mDrawerLayout.w(8388611);
      return true;
    case 2131165557: 
      if (!paramMenuItem.isChecked()) {
        bool1 = true;
      }
      this.aAo.d(bool1, true);
      aW(bool1);
      return true;
    }
    bool1 = bool2;
    if (!paramMenuItem.isChecked()) {
      bool1 = true;
    }
    this.aAo.e(bool1, true);
    aX(bool1);
    return true;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    if (this.aAr != null) {
      this.aAr.pause();
    }
    this.aAu.removeCallbacks(this.aAv);
    this.aAu.removeCallbacks(this.aAx);
    super.onPause();
    this.mResumed = false;
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.aAz.syncState();
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    this.mLog.dl("prepare action mode ");
    this.aAo.onPrepareActionMode(paramActionMode, paramMenu);
    onPrepareOptionsMenu(paramMenu);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = this.mDrawerLayout.v(this.aAA);
    MenuItem localMenuItem = paramMenu.findItem(2131165555);
    boolean bool1;
    label70:
    boolean bool4;
    if (localMenuItem != null)
    {
      if (!bool3)
      {
        bool1 = true;
        localMenuItem.setVisible(bool1);
      }
    }
    else
    {
      localMenuItem = paramMenu.findItem(2131165556);
      if (localMenuItem != null)
      {
        if (bool3) {
          break label274;
        }
        bool1 = true;
        localMenuItem.setVisible(bool1);
      }
      bool1 = this.aAo.FK();
      localMenuItem = paramMenu.findItem(2131165557);
      localMenuItem.setChecked(bool1);
      bool4 = this.aAo.FX();
      if ((!bool1) && (2 == com.mobisystems.mobiscanner.common.d.ah(this)) && (bool4)) {
        break label279;
      }
      localMenuItem.getIcon().setAlpha(getResources().getInteger(2131492872));
      label153:
      localMenuItem.setCheckable(bool4);
      if (bool3) {
        break label302;
      }
      bool1 = true;
      label170:
      localMenuItem.setVisible(bool1);
      bool1 = this.aAo.FL();
      paramMenu = paramMenu.findItem(2131165558);
      if ((!bool1) && (2 == com.mobisystems.mobiscanner.common.d.ah(this)) && (bool4)) {
        break label307;
      }
      paramMenu.getIcon().setAlpha(getResources().getInteger(2131492872));
    }
    for (;;)
    {
      paramMenu.setCheckable(bool4);
      paramMenu.setChecked(bool1);
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      paramMenu.setVisible(bool1);
      return true;
      bool1 = false;
      break;
      label274:
      bool1 = false;
      break label70;
      label279:
      localMenuItem.getIcon().setAlpha(getResources().getInteger(2131492873));
      break label153;
      label302:
      bool1 = false;
      break label170;
      label307:
      paramMenu.getIcon().setAlpha(getResources().getInteger(2131492873));
    }
  }
  
  public boolean onQueryTextChange(String paramString)
  {
    this.aAp = paramString;
    return false;
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.aAk.findItem(2131165555).collapseActionView();
    }
    for (;;)
    {
      return true;
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.aAk.findItem(2131165555).getActionView().getWindowToken(), 0);
    }
  }
  
  public void onResume()
  {
    int j = 0;
    this.mLog.dl("onResume called");
    super.onResume();
    this.mResumed = true;
    this.aAu.postDelayed(this.aAv, 10000L);
    handleIntent(getIntent());
    if ((this.aAB.isConnected()) || (this.aAD)) {
      Fj();
    }
    com.google.android.gms.analytics.g localg = ((MyApplication)getApplication()).a(MyApplication.TrackerName.aDE);
    Object localObject = com.mobisystems.office.a.a.aB(this);
    String str = "FREE";
    int i;
    label140:
    StringBuilder localStringBuilder;
    switch (((com.mobisystems.office.a.a.a)localObject).aNm)
    {
    default: 
      if (((com.mobisystems.office.a.a.a)localObject).aNm == 2)
      {
        this.mIsPaidForAdsRemoval = true;
        Fo();
        i = 0;
        localObject = new d.a().O("QPDF premium check").P("OfficeSuite : " + str);
        localStringBuilder = new StringBuilder().append("Quick PDF : ");
        if (j == 0) {
          break label334;
        }
        str = "Premium";
      }
      break;
    }
    for (;;)
    {
      localg.c(((d.a)localObject).Q(str).kg());
      if (this.aAr != null) {
        this.aAr.resume();
      }
      return;
      str = "PRO";
      break;
      str = "PREMIUM";
      break;
      localObject = PreferenceManager.getDefaultSharedPreferences(this);
      boolean bool1 = ((SharedPreferences)localObject).getBoolean(CommonPreferences.Keys.apJ.getKey(), false);
      this.mIsPaidForAdsRemoval = bool1;
      boolean bool2 = ((SharedPreferences)localObject).getBoolean(CommonPreferences.Keys.apK.getKey(), false);
      if (!this.mIsPaidForAdsRemoval) {
        this.mIsPaidForAdsRemoval = bool2;
      }
      j = bool2;
      i = bool1;
      if (!bool2) {
        break label140;
      }
      Fo();
      j = bool2;
      i = bool1;
      break label140;
      label334:
      if (i != 0) {
        str = "No ads";
      } else {
        str = "Free";
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLog.dl("onSaveInstanceState called");
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("CAMERA_IMAGE_PATH", this.aAn);
    if (this.mActionMode != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("ACTION_MODE_STARTED", bool);
      paramBundle.putBoolean("SHOW_STATIC_BANNER", this.aAs);
      if (this.aAk != null)
      {
        paramBundle.putBoolean("SEARCH_EXPANDED", this.aAk.findItem(2131165555).isActionViewExpanded());
        paramBundle.putString("SEARCH_QUERY", this.aAp);
      }
      return;
    }
  }
  
  public boolean onSearchRequested()
  {
    if (this.aAk != null)
    {
      MenuItem localMenuItem = this.aAk.findItem(2131165555);
      if ((localMenuItem != null) && (!localMenuItem.isActionViewExpanded())) {
        localMenuItem.expandActionView();
      }
    }
    return false;
  }
  
  public void onStart()
  {
    this.mLog.dl("OnStart called");
    super.onStart();
    if (CommonPreferences.Keys.apu.Dm()) {
      getWindow().clearFlags(1024);
    }
    for (;;)
    {
      if (this.aAm) {
        dA("");
      }
      l.e(this).a(this);
      return;
      getWindow().addFlags(1024);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
  
  private class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private String aBd;
    private String aBe;
    private SharedPreferences aBf;
    private File aBg;
    private boolean aBh;
    private Context mContext;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      this.mContext = paramContext;
      this.aBh = paramBoolean;
    }
    
    protected Boolean d(Void... paramVarArgs)
    {
      for (boolean bool = true;; bool = false) {
        try
        {
          this.aBg = com.mobisystems.mobiscanner.common.d.ab(this.mContext);
          this.aBf = PreferenceManager.getDefaultSharedPreferences(DocumentListActivity.this);
          this.aBd = CommonPreferences.Keys.apN.getKey();
          this.aBe = CommonPreferences.Keys.apO.getKey();
          if (((!this.aBf.getBoolean(this.aBd, true)) || (DocumentListActivity.t(DocumentListActivity.this))) && (!this.aBh)) {
            return Boolean.valueOf(false);
          }
          long l1 = DocumentModel.Ip();
          if (this.aBg.exists())
          {
            long l2 = com.mobisystems.mobiscanner.common.d.al(this.mContext);
            DocumentListActivity.f(DocumentListActivity.this).dl("lastModificationFromMeta = " + l2 + "; lastModificationFromDB  = " + l1 + " ; mOnExit = " + this.aBh);
            if (l2 > l1) {
              return Boolean.valueOf(true);
            }
            if ((l2 == l1) && (this.aBh)) {
              return Boolean.valueOf(true);
            }
            return Boolean.valueOf(false);
          }
          if (this.aBh)
          {
            if (l1 == 0L) {
              return Boolean.valueOf(bool);
            }
          }
          else {
            return Boolean.valueOf(false);
          }
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          DocumentListActivity.u(DocumentListActivity.this);
          return Boolean.valueOf(false);
        }
      }
    }
    
    protected void f(Boolean paramBoolean)
    {
      if (!DocumentListActivity.a(DocumentListActivity.this).isConnected())
      {
        DocumentListActivity.a(DocumentListActivity.this).connect();
        DocumentListActivity.u(DocumentListActivity.this);
        return;
      }
      Object localObject1;
      final Object localObject2;
      if (this.aBh)
      {
        boolean bool = this.aBf.getBoolean(this.aBe, true);
        if ((!paramBoolean.booleanValue()) && (bool))
        {
          paramBoolean = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              DocumentListActivity.k(DocumentListActivity.this);
            }
          };
          localObject1 = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              DocumentListActivity.v(DocumentListActivity.this);
            }
          };
          localObject2 = new CompoundButton.OnCheckedChangeListener()
          {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
              paramAnonymousCompoundButton = DocumentListActivity.a.a(DocumentListActivity.a.this).edit();
              String str = DocumentListActivity.a.b(DocumentListActivity.a.this);
              if (!paramAnonymousBoolean) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                paramAnonymousCompoundButton.putBoolean(str, paramAnonymousBoolean);
                paramAnonymousCompoundButton.commit();
                return;
              }
            }
          };
          com.mobisystems.mobiscanner.common.d.a(DocumentListActivity.this, 2130903079, 2131296870, 2131297111, -1, DocumentListActivity.this.getString(2131296805), 2131296831, paramBoolean, 2131296833, (DialogInterface.OnClickListener)localObject1, null, (CompoundButton.OnCheckedChangeListener)localObject2);
          return;
        }
        DocumentListActivity.w(DocumentListActivity.this);
        return;
      }
      if (paramBoolean.booleanValue())
      {
        localObject2 = new boolean[1];
        localObject2[0] = 0;
        paramBoolean = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            DocumentListActivity.l(DocumentListActivity.this);
          }
        };
        localObject1 = new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            if (localObject2[0] == 0)
            {
              DocumentListActivity.e(DocumentListActivity.this, false);
              DocumentListActivity.u(DocumentListActivity.this);
            }
          }
        };
        localObject2 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            localObject2[0] = true;
            paramAnonymousDialogInterface = new AlertDialog.Builder(DocumentListActivity.this);
            final View localView = DocumentListActivity.this.getLayoutInflater().inflate(2130903090, null);
            ((CheckBox)localView.findViewById(2131165414)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
              public void onCheckedChanged(CompoundButton paramAnonymous2CompoundButton, boolean paramAnonymous2Boolean)
              {
                boolean bool = false;
                if (paramAnonymous2Boolean) {}
                for (int i = 0;; i = 8)
                {
                  localView.findViewById(2131165415).setVisibility(i);
                  paramAnonymous2CompoundButton = DocumentListActivity.a.a(DocumentListActivity.a.this).edit();
                  String str = DocumentListActivity.a.c(DocumentListActivity.a.this);
                  if (!paramAnonymous2Boolean) {
                    bool = true;
                  }
                  paramAnonymous2CompoundButton.putBoolean(str, bool);
                  paramAnonymous2CompoundButton.commit();
                  return;
                }
              }
            });
            paramAnonymousDialogInterface.setView(localView);
            paramAnonymousDialogInterface.setTitle(2131296751);
            paramAnonymousDialogInterface.setPositiveButton(2131296831, null);
            paramAnonymousDialogInterface.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                DocumentListActivity.u(DocumentListActivity.this);
                DocumentListActivity.e(DocumentListActivity.this, false);
              }
            });
            paramAnonymousDialogInterface.create().show();
          }
        };
        DocumentListActivity.c(DocumentListActivity.this).removeCallbacks(DocumentListActivity.this.aAx);
        com.mobisystems.mobiscanner.common.d.a(DocumentListActivity.this, 2131296751, -1, DocumentListActivity.this.getString(2131296809) + new Date(this.aBg.lastModified()).toString() + " ? ", 2131296831, paramBoolean, 2131296834, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnDismissListener)localObject1);
        DocumentListActivity.e(DocumentListActivity.this, true);
        return;
      }
      DocumentListActivity.u(DocumentListActivity.this);
    }
  }
  
  protected class b
    extends AsyncTask<Long, Void, com.mobisystems.mobiscanner.model.b>
  {
    protected b() {}
    
    protected com.mobisystems.mobiscanner.model.b a(Long... paramVarArgs)
    {
      long l = paramVarArgs[0].longValue();
      return new DocumentModel().ae(l);
    }
    
    protected void b(com.mobisystems.mobiscanner.model.b paramb)
    {
      DocumentListActivity.a(DocumentListActivity.this, paramb, true);
    }
  }
  
  private static abstract interface c
  {
    public abstract void a(DriveId paramDriveId, Date paramDate);
  }
  
  private class d
    extends AsyncTask<Void, Void, Void>
    implements d.b
  {
    private boolean aBm = false;
    
    private d() {}
    
    private void FF()
    {
      com.mobisystems.mobiscanner.common.d.a(DocumentListActivity.this, this);
    }
    
    public void aT(boolean paramBoolean)
    {
      DocumentModel.aA(DocumentListActivity.this);
      DocumentListActivity.s(DocumentListActivity.this);
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      this.aBm = false;
      FF();
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (DocumentListActivity.r(DocumentListActivity.this) != null)
      {
        DocumentListActivity.r(DocumentListActivity.this).hide();
        DocumentListActivity.a(DocumentListActivity.this, null);
      }
      if (this.aBm) {
        com.mobisystems.mobiscanner.common.d.a(DocumentListActivity.this, 2131296752, -1, DocumentListActivity.this.getString(2131296808), 2131296831, null, -1, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/DocumentListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */