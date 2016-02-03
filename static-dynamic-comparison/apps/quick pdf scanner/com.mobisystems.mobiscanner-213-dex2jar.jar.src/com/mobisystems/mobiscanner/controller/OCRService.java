package com.mobisystems.mobiscanner.controller;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.d.a;
import com.google.android.gms.analytics.g;
import com.google.api.a.a.a.a;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.OCRLanguage;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OCRService
  extends Service
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private com.google.api.client.googleapis.extensions.android.gms.auth.a aAL;
  private String aDI;
  private com.google.api.a.a.a aDJ;
  private Runnable aDK = new Runnable()
  {
    public void run()
    {
      OCRService.a(OCRService.this);
    }
  };
  private boolean aDL = false;
  private Handler mHandler = new Handler();
  
  private void Go()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        OCRService.b(OCRService.this);
      }
    }).start();
  }
  
  private void Gp()
  {
    DocumentModel localDocumentModel = new DocumentModel();
    Cursor localCursor = localDocumentModel.Iy();
    boolean bool;
    if (localCursor != null)
    {
      apd.dl("OCRService cursorCount = " + localCursor.getCount());
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        do
        {
          localDocumentModel.aG(localCursor.getLong(localCursor.getColumnIndex("_id")));
        } while (localCursor.moveToNext());
        bool = d.ap(this);
        localCursor.moveToFirst();
      }
    }
    else
    {
      for (;;)
      {
        com.mobisystems.mobiscanner.model.c localc = localDocumentModel.aj(localCursor.getLong(localCursor.getColumnIndex("_id")));
        if (localc == null) {}
        while (!localCursor.moveToNext())
        {
          this.mHandler.postDelayed(this.aDK, 60000L);
          return;
          long l = localc.getId();
          if (bool)
          {
            b localb = localDocumentModel.af(l);
            try
            {
              Object localObject = localDocumentModel.aq(l);
              if (localObject == null) {
                continue;
              }
              File localFile = new File(((Image)localObject).Ia().getPath());
              CommonPreferences.OCRLanguage localOCRLanguage = localc.Jt();
              localObject = localOCRLanguage;
              if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh))
              {
                localOCRLanguage = localb.IQ();
                localObject = localOCRLanguage;
                if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh)) {
                  localObject = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apW.Dl());
                }
              }
              String str = d.a(this.aDJ, localFile, ((CommonPreferences.OCRLanguage)localObject).getValue());
              localOCRLanguage = localc.Ju();
              localObject = localOCRLanguage;
              if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh))
              {
                localOCRLanguage = localb.IR();
                localObject = localOCRLanguage;
                if (localOCRLanguage.equals(CommonPreferences.OCRLanguage.aqh)) {
                  localObject = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apX.Dl());
                }
              }
              localDocumentModel.a(l, str, d.a(this.aDJ, localFile, ((CommonPreferences.OCRLanguage)localObject).getValue()));
              ((MyApplication)getApplication()).a(MyApplication.TrackerName.aDE).c(new d.a().O("Cloud old API").P("OCR").Q(Build.BRAND + " - " + Build.MODEL).kg());
            }
            catch (UserRecoverableAuthIOException localUserRecoverableAuthIOException)
            {
              apd.dl("Auth exception");
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
          else if (localc.Jv() != -2)
          {
            localDocumentModel.aH(l);
          }
        }
      }
    }
    apd.dl("no more images to process");
    if (this.aDL)
    {
      this.aDL = false;
      this.mHandler.postDelayed(this.aDK, 1000L);
      return;
    }
    stopSelf();
  }
  
  private com.google.api.a.a.a a(com.google.api.client.googleapis.extensions.android.gms.auth.a parama)
  {
    return new a.a(com.google.api.client.a.a.a.a.wI(), new com.google.api.client.json.gson.a(), parama).yY();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    apd.dl(" OCR service onCreate ");
    this.aDI = getSharedPreferences(getString(2131297115), 4).getString(CommonPreferences.Keys.apS.getKey(), null);
    if (this.aDI != null)
    {
      if (this.aAL == null) {
        this.aAL = com.google.api.client.googleapis.extensions.android.gms.auth.a.b(this, Arrays.asList(new String[] { "https://www.googleapis.com/auth/drive" }));
      }
      this.aAL.by(this.aDI);
      this.aDJ = a(this.aAL);
      Go();
      return;
    }
    apd.dl("Not connected to Google drive");
    DocumentModel localDocumentModel = new DocumentModel();
    Cursor localCursor = localDocumentModel.Iy();
    if (localCursor != null)
    {
      apd.dl("OCRService cursorCount = " + localCursor.getCount());
      if (localCursor.getCount() > 0) {
        localCursor.moveToFirst();
      }
    }
    for (;;)
    {
      com.mobisystems.mobiscanner.model.c localc = localDocumentModel.aj(localCursor.getLong(localCursor.getColumnIndex("_id")));
      if (localc == null) {}
      while (!localCursor.moveToNext())
      {
        stopSelf();
        return;
        long l = localc.getId();
        if (localc.Jv() != -2) {
          localDocumentModel.aH(l);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    apd.dl("ocr service onDestroy");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    apd.dl(" OCR service onStartCommand id " + paramInt2 + ": " + paramIntent);
    this.aDL = true;
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/OCRService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */