package com.scoreloop.client.android.core.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.server.Server;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.BitSet;
import java.util.Properties;

public class Client
  implements SessionObserver
{
  private final BitSet a = new BitSet();
  private final ClientObserver b;
  private final Server c;
  private final Session d;
  
  @PublishedFor__1_0_0
  public Client(Context paramContext, String paramString1, String paramString2, ClientObserver paramClientObserver)
  {
    this(paramContext, paramString1, paramString2, paramClientObserver, "https://api.scoreloop.com/bayeux");
  }
  
  Client(Context paramContext, String paramString1, String paramString2, ClientObserver paramClientObserver, String paramString3)
  {
    this.b = paramClientObserver;
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new Game(paramString1, paramString2);
      paramString1.setVersion("1.0");
    }
    for (;;)
    {
      try
      {
        this.c = new Server(new URL(paramString3));
        this.c.a(paramString1);
        this.d = new Session(this, this.c);
        this.d.a(paramString1);
        this.d.a(paramContext);
        Session.a(this.d);
        this.d.a().a(paramContext);
        paramString1 = (String)localObject;
        if (paramContext != null) {
          paramString1 = a(paramContext);
        }
        if (paramString1 != null)
        {
          Money.a(paramString1.getProperty("currency.code"));
          Money.b(paramString1.getProperty("currency.symbol"));
          Money.c(paramString1.getProperty("currency.name.singular"));
          Money.d(paramString1.getProperty("currency.name.plural"));
        }
        return;
      }
      catch (MalformedURLException paramContext)
      {
        throw new IllegalStateException(paramContext);
      }
      paramString1 = null;
    }
  }
  
  private Game a()
  {
    return this.d.getGame();
  }
  
  private Properties a(Context paramContext)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open("scoreloop.properties");
      Properties localProperties;
      return null;
    }
    catch (IOException paramContext)
    {
      try
      {
        localProperties = new Properties();
        localProperties.load(paramContext);
        return localProperties;
      }
      catch (IOException paramContext)
      {
        Logger.c("Client", "Failed to load scoreloop.properties file");
      }
      paramContext = paramContext;
      Logger.c("Client", "No scoreloop.properties file found");
      return null;
    }
  }
  
  @PublishedFor__1_0_0
  public Range getGameLevels()
  {
    if (!a().hasLevels()) {
      return new Range(0, 1);
    }
    return new Range(a().getMinLevel().intValue(), a().getLevelCount().intValue());
  }
  
  @PublishedFor__1_0_0
  public Range getGameModes()
  {
    if (!a().hasModes()) {
      return new Range(0, 1);
    }
    return new Range(a().getMinMode().intValue(), a().getModeCount().intValue());
  }
  
  @PublishedFor__1_0_0
  public Session getSession()
  {
    return this.d;
  }
  
  @PublishedFor__1_0_0
  public void setGameLevels(Range paramRange)
  {
    if (a() == null) {
      return;
    }
    a().setMinLevel(Integer.valueOf(paramRange.a()));
    a().setMaxLevel(Integer.valueOf(paramRange.b()));
  }
  
  @PublishedFor__1_0_0
  public void setGameModes(Range paramRange)
  {
    if (a() == null) {
      return;
    }
    a().setMinMode(Integer.valueOf(paramRange.a()));
    a().setMaxMode(Integer.valueOf(paramRange.b()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */