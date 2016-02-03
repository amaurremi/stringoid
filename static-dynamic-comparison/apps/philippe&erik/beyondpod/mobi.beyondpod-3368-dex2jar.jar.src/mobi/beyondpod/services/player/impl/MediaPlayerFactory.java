package mobi.beyondpod.services.player.impl;

import android.content.Context;
import com.aocate.media.MediaPlayer;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.rss.LicenseManager;

public class MediaPlayerFactory
{
  public static IMediaPlayerImpl CreatePlayer(Context paramContext)
  {
    Object localObject2 = null;
    if (ChromecastDevice.IsConnected()) {
      return new MediaPlayerChromecast(paramContext);
    }
    Object localObject1 = localObject2;
    if (Configuration.EnableAudioPlugins())
    {
      localObject1 = localObject2;
      if (IsSpeedAlterationPlayerInstalled(paramContext))
      {
        localObject1 = localObject2;
        if (!Configuration.UseAudioPluginForConfiguredFeedsOnly()) {
          localObject1 = GetSpeedCapabaleMediaPlayer(paramContext);
        }
      }
    }
    if (localObject1 != null) {
      return (IMediaPlayerImpl)localObject1;
    }
    return new MediaPlayerAndroid(paramContext);
  }
  
  private static IMediaPlayerImpl GetSpeedCapabaleMediaPlayer(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1;
    if (MediaPlayer.isPrestoLibraryInstalled(paramContext)) {
      localObject1 = new MediaPlayerOSPlay(paramContext);
    }
    do
    {
      do
      {
        return (IMediaPlayerImpl)localObject1;
        localObject1 = localObject2;
      } while (LicenseManager.IfInRestrictedMode());
      if (SonicPlayer.isSonicLibraryInstalled()) {
        return new MediaPlayerSonic(paramContext);
      }
      localObject1 = localObject2;
    } while (!Mpg123Player.isSonicLibraryInstalled());
    return new MediaPlayerMpg123(paramContext);
  }
  
  public static boolean IsSpeedAlterationPlayerInstalled(Context paramContext)
  {
    return (SonicPlayer.isSonicLibraryInstalled()) || (Mpg123Player.isSonicLibraryInstalled()) || (MediaPlayer.isPrestoLibraryInstalled(paramContext));
  }
  
  public static IMediaPlayerImpl SwitchToChromecastPlayerIfNeeded(IMediaPlayerImpl paramIMediaPlayerImpl, Context paramContext, int paramInt)
  {
    if (paramIMediaPlayerImpl.playerType() != 5)
    {
      paramIMediaPlayerImpl.release();
      paramIMediaPlayerImpl = new MediaPlayerChromecast(paramContext);
      paramIMediaPlayerImpl.setWakeMode(paramContext, paramInt);
      return paramIMediaPlayerImpl;
    }
    return paramIMediaPlayerImpl;
  }
  
  public static IMediaPlayerImpl SwitchToLocalPlayerIfNeeded(IMediaPlayerImpl paramIMediaPlayerImpl, float paramFloat, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = IsSpeedAlterationPlayerInstalled(paramContext);
    if ((paramFloat == 1.0F) && (Configuration.UseAudioPluginForConfiguredFeedsOnly())) {}
    for (int i = 1; (!paramIMediaPlayerImpl.supportsSpeedAlteration()) && (bool) && (Configuration.EnableAudioPlugins()) && (i == 0); i = 0)
    {
      paramIMediaPlayerImpl.release();
      IMediaPlayerImpl localIMediaPlayerImpl = GetSpeedCapabaleMediaPlayer(paramContext);
      if (localIMediaPlayerImpl != null)
      {
        paramIMediaPlayerImpl = localIMediaPlayerImpl;
        if (localIMediaPlayerImpl.supportsFileFormatFor(paramString1, paramString2)) {}
      }
      else
      {
        if (localIMediaPlayerImpl != null) {
          localIMediaPlayerImpl.release();
        }
        paramIMediaPlayerImpl = new MediaPlayerAndroid(paramContext);
      }
      paramIMediaPlayerImpl.setWakeMode(paramContext, paramInt);
      return paramIMediaPlayerImpl;
    }
    if (!paramIMediaPlayerImpl.supportsFileFormatFor(paramString1, paramString2)) {
      i = 1;
    }
    if ((paramIMediaPlayerImpl.playerType() != 0) && ((!Configuration.EnableAudioPlugins()) || (!bool) || (i != 0)))
    {
      paramIMediaPlayerImpl.release();
      paramIMediaPlayerImpl = new MediaPlayerAndroid(paramContext);
      paramIMediaPlayerImpl.setWakeMode(paramContext, paramInt);
      return paramIMediaPlayerImpl;
    }
    return paramIMediaPlayerImpl;
  }
  
  public static IMediaPlayerImpl SwitchToStreamingPlayerIfNeeded(IMediaPlayerImpl paramIMediaPlayerImpl, Context paramContext, int paramInt)
  {
    if (paramIMediaPlayerImpl.playerType() != 0)
    {
      paramIMediaPlayerImpl.release();
      paramIMediaPlayerImpl = new MediaPlayerAndroid(paramContext);
      paramIMediaPlayerImpl.setWakeMode(paramContext, paramInt);
      return paramIMediaPlayerImpl;
    }
    return paramIMediaPlayerImpl;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */