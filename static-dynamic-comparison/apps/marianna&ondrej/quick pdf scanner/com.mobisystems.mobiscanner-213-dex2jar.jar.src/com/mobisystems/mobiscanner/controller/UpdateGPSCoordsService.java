package com.mobisystems.mobiscanner.controller;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.ArrayList;

public class UpdateGPSCoordsService
  extends Service
  implements c.a, c.b
{
  private static final c apd = new c();
  private LocationRequest aGD;
  private d aGE;
  private Handler aGF = new Handler();
  private Handler aGG = new Handler();
  private boolean aGH;
  private int aGI = 0;
  private ArrayList<Location> aGJ;
  
  private Location HO()
  {
    Object localObject = (Location)this.aGJ.get(this.aGJ.size() - 1);
    double d1 = ((Location)localObject).getLongitude();
    double d2 = ((Location)localObject).getLatitude();
    float f = ((Location)localObject).getAccuracy();
    int i = this.aGJ.size() - 2;
    if (i >= 0)
    {
      Location localLocation = (Location)this.aGJ.get(i);
      double d3 = localLocation.getLongitude();
      double d4 = localLocation.getLatitude();
      if ((Math.abs(d3 - d1) < 1.0E-4D) && (Math.abs(d4 - d2) < 1.0E-4D))
      {
        if (localLocation.getAccuracy() >= f) {
          break label146;
        }
        localObject = localLocation;
      }
    }
    label146:
    for (;;)
    {
      i -= 1;
      break;
      this.aGJ.clear();
      return (Location)localObject;
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(b paramb) {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    apd.dl(" updateGPS service onCreate ");
    this.aGD = LocationRequest.tX();
    this.aGD.t(5000L);
    this.aGD.dJ(100);
    this.aGD.u(1000L);
    this.aGE = new d(this, this, this);
    this.aGE.connect();
    this.aGJ = new ArrayList();
  }
  
  public void onDestroy()
  {
    apd.dl("lastLocation in service onDestroy");
    this.aGE.disconnect();
  }
  
  public void onDisconnected()
  {
    Toast.makeText(this, "Disconnected. Please re-connect.", 0).show();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    apd.dl(" updateGPS service onStartCommand id " + paramInt2 + ": " + paramIntent);
    if (paramIntent == null)
    {
      new b(null).execute(new Void[0]);
      apd.dl("lastLocation in null intent stopSelf");
      stopSelf();
    }
    do
    {
      return 1;
      if (paramIntent.getBooleanExtra("START_LOCATION_SERVICE", false))
      {
        this.aGG.postDelayed(new Runnable()
        {
          public void run()
          {
            if (UpdateGPSCoordsService.a(UpdateGPSCoordsService.this).isConnected())
            {
              Location localLocation = UpdateGPSCoordsService.a(UpdateGPSCoordsService.this).rf();
              if (UpdateGPSCoordsService.b(UpdateGPSCoordsService.this)) {
                UpdateGPSCoordsService.c(UpdateGPSCoordsService.this).add(localLocation);
              }
              if ((UpdateGPSCoordsService.d(UpdateGPSCoordsService.this) > 0) || (UpdateGPSCoordsService.b(UpdateGPSCoordsService.this))) {
                UpdateGPSCoordsService.e(UpdateGPSCoordsService.this).postDelayed(this, 1000L);
              }
            }
          }
        }, 1000L);
        if (!this.aGH)
        {
          this.aGF.postDelayed(new Runnable()
          {
            public void run()
            {
              Location localLocation;
              if (UpdateGPSCoordsService.a(UpdateGPSCoordsService.this).isConnected())
              {
                localLocation = UpdateGPSCoordsService.a(UpdateGPSCoordsService.this).rf();
                if (localLocation != null)
                {
                  if (UpdateGPSCoordsService.c(UpdateGPSCoordsService.this).size() <= 0) {
                    break label167;
                  }
                  UpdateGPSCoordsService.c(UpdateGPSCoordsService.this).add(localLocation);
                  localLocation = UpdateGPSCoordsService.f(UpdateGPSCoordsService.this);
                }
              }
              label167:
              for (;;)
              {
                long l = (System.currentTimeMillis() - 15000L - 1000L) / 1000L;
                new UpdateGPSCoordsService.a(localLocation.getLongitude(), localLocation.getLatitude(), localLocation.getAltitude(), localLocation.getAccuracy(), null).execute(new Long[] { Long.valueOf(l) });
                UpdateGPSCoordsService.a(UpdateGPSCoordsService.this, false);
                if (UpdateGPSCoordsService.d(UpdateGPSCoordsService.this) != 0) {
                  break;
                }
                new UpdateGPSCoordsService.b(null).execute(new Void[0]);
                UpdateGPSCoordsService.HP().dl("lastLocation in service stopSelf");
                UpdateGPSCoordsService.this.stopSelf();
                return;
              }
              UpdateGPSCoordsService.g(UpdateGPSCoordsService.this).postDelayed(this, 2000L);
            }
          }, 15000L);
          this.aGH = true;
        }
        this.aGI += 1;
        return 1;
      }
      if (paramIntent.getBooleanExtra("STOP_LOCATION_SERVICE", false))
      {
        this.aGI -= 1;
        return 1;
      }
    } while (!paramIntent.getBooleanExtra("LOCATION_SERVICE_IMAGE_TAKEN", false));
    paramIntent.getLongExtra("LOCATION_SERVICE_IMAGE_TAKEN_IMAGE_ID", -1L);
    return 1;
  }
  
  private static class a
    extends AsyncTask<Long, Void, Void>
  {
    private final double aGL;
    private double aGM;
    private double aGN;
    private float aGO;
    private long aGP;
    
    private a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat)
    {
      this.aGM = paramDouble1;
      this.aGN = paramDouble2;
      this.aGL = paramDouble3;
      this.aGO = paramFloat;
    }
    
    protected Void e(Long... paramVarArgs)
    {
      this.aGP = paramVarArgs[0].longValue();
      new DocumentModel().a(this.aGP, this.aGM, this.aGN, this.aGL, this.aGO);
      return null;
    }
  }
  
  private static class b
    extends AsyncTask<Void, Void, Void>
  {
    protected Void doInBackground(Void... paramVarArgs)
    {
      new DocumentModel().Iw();
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/UpdateGPSCoordsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */