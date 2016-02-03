package com.chartboost.sdk.Libraries;

import android.content.Context;
import com.chartboost.sdk.Chartboost;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class d
{
  protected static String a()
  {
    Object localObject1 = Chartboost.sharedChartboost().getContext();
    try
    {
      localObject1 = AdvertisingIdClient.getAdvertisingIdInfo((Context)localObject1);
      if (localObject1 == null)
      {
        c.a(c.a.c);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        Object localObject4 = null;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        CBLogging.a("CBIdentityAdv", "Security Exception when retrieving AD id", localSecurityException);
        Object localObject5 = null;
      }
    }
    catch (Exception localException)
    {
      Object localObject6;
      for (;;)
      {
        CBLogging.a("CBIdentityAdv", "General Exception when retrieving AD id", localException);
        localObject6 = null;
      }
      if (((AdvertisingIdClient.Info)localObject6).isLimitAdTrackingEnabled()) {
        c.a(c.a.e);
      }
      for (;;)
      {
        try
        {
          Object localObject7 = UUID.fromString(((AdvertisingIdClient.Info)localObject6).getId());
          ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[16]);
          localByteBuffer.putLong(((UUID)localObject7).getMostSignificantBits());
          localByteBuffer.putLong(((UUID)localObject7).getLeastSignificantBits());
          localObject7 = b.b(localByteBuffer.array());
          return (String)localObject7;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          CBLogging.b("CBIdentityAdv", "Exception raised retrieveAdvertisingID", localIllegalArgumentException);
        }
        c.a(c.a.d);
      }
      return ((AdvertisingIdClient.Info)localObject6).getId().replace("-", "");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */