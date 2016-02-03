package mobi.beyondpod.services.player;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.RemoteViews;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.NotificationBuilderHelper;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.volley.ImageUtils;
import mobi.beyondpod.ui.dialogs.WidgetActionPicker;

public class MediaAppWidgetProvider
  extends MediaAppWidgetProviderBase
{
  private static final String PLAYBACK_ERROR = CoreHelper.LoadResourceString(2131297041);
  private static final String PLAYBACK_ERROR_STREAMING_DISABLED = CoreHelper.LoadResourceString(2131297080);
  private static final String PLAYLIST_IS_EMPTY = CoreHelper.LoadResourceString(2131296902);
  private static final String PLAYLIST_IS_EMPTY_START_SMARTPLAY = CoreHelper.LoadResourceString(2131296903);
  private static final String STARTING_STREAM_S = CoreHelper.LoadResourceString(2131297040);
  static String TAG = MediaAppWidgetProvider.class.getSimpleName();
  static final ComponentName THIS_APPWIDGET = new ComponentName(mobi.beyondpod.rsscore.Configuration.PackageName(), "mobi.beyondpod.services.player.MediaAppWidgetProvider");
  public static NotificationState _NotificationState;
  public static Notification _PlayerNotification;
  
  @TargetApi(16)
  public static Notification CreatePlayerNotification(Context paramContext, Track paramTrack, boolean paramBoolean)
  {
    Object localObject1 = NotificationState.BuildFromTrack(paramTrack, false, paramContext);
    if ((paramBoolean) && (_NotificationState != null) && (_NotificationState.equals(localObject1))) {
      return null;
    }
    _NotificationState = (NotificationState)localObject1;
    int i;
    int j;
    if ((paramTrack != null) && (paramTrack.getCurrentPlayState() == 1))
    {
      i = 1;
      localObject1 = new Intent(paramContext, BeyondPodApplication.GetInstance().MasterViewClass());
      ((Intent)localObject1).setData(Uri.parse("mobi.beyondpod.services.player.MediaPlaybackService"));
      Object localObject2 = paramContext.getPackageName();
      if (paramContext.getResources().getConfiguration().orientation != 2) {
        break label284;
      }
      j = 2130903170;
      label101:
      localObject2 = new RemoteViews((String)localObject2, j);
      WireRemoteNotificationViews(_NotificationState, (RemoteViews)localObject2);
      WireRemoteNotificationViewImage((RemoteViews)localObject2, paramTrack, paramContext, false);
      WireRemoteNotificationViewButtons(paramContext, (RemoteViews)localObject2);
      NotificationBuilderHelper localNotificationBuilderHelper = NotificationBuilderHelper.getInstance(paramContext);
      if (i == 0) {
        break label291;
      }
      i = 0;
      label148:
      _PlayerNotification = localNotificationBuilderHelper.setSmallIcon(2130838092, i).setContentIntent(PendingIntent.getActivity(paramContext, 0, (Intent)localObject1, 134217728)).setOngoing(true).setContent((RemoteViews)localObject2).getNotification(_PlayerNotification);
      if (CoreHelper.ApiLevel() > 15)
      {
        if ((paramContext.getResources().getConfiguration().orientation != 1) && (!paramContext.getResources().getConfiguration().isLayoutSizeAtLeast(3))) {
          break label296;
        }
        _PlayerNotification.bigContentView = new RemoteViews(paramContext.getPackageName(), 2130903169);
        WireRemoteNotificationViews(_NotificationState, _PlayerNotification.bigContentView);
        WireRemoteNotificationViewImage(_PlayerNotification.bigContentView, paramTrack, paramContext, true);
        WireRemoteNotificationViewButtons(paramContext, _PlayerNotification.bigContentView);
      }
    }
    for (;;)
    {
      return _PlayerNotification;
      i = 0;
      break;
      label284:
      j = 2130903171;
      break label101;
      label291:
      i = 1;
      break label148;
      label296:
      _PlayerNotification.bigContentView = null;
    }
  }
  
  static void WireRemoteNotificationViewButtons(Context paramContext, RemoteViews paramRemoteViews)
  {
    ComponentName localComponentName = new ComponentName(paramContext, MediaPlaybackService.class);
    Object localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.playpause");
    ((Intent)localObject).putExtra("command", "togglepause");
    ((Intent)localObject).setComponent(localComponentName);
    paramRemoteViews.setOnClickPendingIntent(2131230847, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
    if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == -1) {}
    for (localObject = "mobi.beyondpod.services.musicservicewidgetcommand.nexttrack";; localObject = "mobi.beyondpod.services.musicservicewidgetcommand.skiptoend")
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setComponent(localComponentName);
      paramRemoteViews.setOnClickPendingIntent(2131230851, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.skipforward");
      ((Intent)localObject).setComponent(localComponentName);
      paramRemoteViews.setOnClickPendingIntent(2131230859, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.skipback");
      ((Intent)localObject).setComponent(localComponentName);
      paramRemoteViews.setOnClickPendingIntent(2131230858, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.stop");
      ((Intent)localObject).setComponent(localComponentName);
      paramRemoteViews.setOnClickPendingIntent(2131231215, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      if (!PlayList.IsEmpty()) {
        paramRemoteViews.setOnClickPendingIntent(2131230852, createOpenPlaylistEditorPendingIntent(paramContext));
      }
      return;
    }
  }
  
  protected static void WireRemoteNotificationViewImage(RemoteViews paramRemoteViews, Track paramTrack, Context paramContext, boolean paramBoolean)
  {
    if (paramTrack == null)
    {
      paramRemoteViews.setImageViewResource(2131230856, 2130837601);
      paramRemoteViews.setViewVisibility(2131230856, 0);
      return;
    }
    if (paramBoolean) {}
    for (paramTrack = NotificationState.getBigBitmapForTrack(paramContext, paramTrack);; paramTrack = NotificationState.getSmallBitmapForTrack(paramContext, paramTrack))
    {
      paramRemoteViews.setImageViewBitmap(2131230856, paramTrack);
      break;
    }
  }
  
  public static void WireRemoteNotificationViews(NotificationState paramNotificationState, RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setImageViewResource(2131230848, paramNotificationState.ProgressResource);
    paramRemoteViews.setTextViewText(2131230782, paramNotificationState.Title);
    paramRemoteViews.setTextViewText(2131230854, paramNotificationState.Artist);
    paramRemoteViews.setTextViewText(2131230855, paramNotificationState.InfoMessage);
    paramRemoteViews.setTextViewText(2131230852, paramNotificationState.PlaylistSize);
    paramRemoteViews.setImageViewResource(2131230849, paramNotificationState.PlayPauseResource);
    paramRemoteViews.setViewVisibility(2131230850, paramNotificationState.StreamVisibility);
    paramRemoteViews.setViewVisibility(2131230851, paramNotificationState.NextVisibility);
  }
  
  static void WireRemoteViewButtons(Context paramContext, RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    ComponentName localComponentName = new ComponentName(paramContext, MediaPlaybackService.class);
    if (paramBoolean) {
      paramRemoteViews.setOnClickPendingIntent(2131230853, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, WidgetActionPicker.class), 0));
    }
    Object localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.playpause");
    ((Intent)localObject).putExtra("command", "togglepause");
    ((Intent)localObject).setComponent(localComponentName);
    paramRemoteViews.setOnClickPendingIntent(2131230847, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
    switch (mobi.beyondpod.rsscore.Configuration.WidgetSecondaryButtonAction())
    {
    case 2: 
    default: 
      localObject = "mobi.beyondpod.services.musicservicewidgetcommand.skiptoend";
    }
    for (;;)
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setComponent(localComponentName);
      paramRemoteViews.setOnClickPendingIntent(2131230851, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      if (!paramBoolean)
      {
        localObject = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.stop");
        ((Intent)localObject).setComponent(localComponentName);
        paramRemoteViews.setOnClickPendingIntent(2131231215, PendingIntent.getService(paramContext, 0, (Intent)localObject, 0));
      }
      return;
      localObject = "mobi.beyondpod.services.musicservicewidgetcommand.nexttrack";
      continue;
      localObject = "mobi.beyondpod.services.musicservicewidgetcommand.skiptoend";
      continue;
      localObject = "mobi.beyondpod.services.musicservicewidgetcommand.skipforward";
      continue;
      localObject = "mobi.beyondpod.services.musicservicewidgetcommand.skipback";
    }
  }
  
  public static void WireRemoteViews(Context paramContext, RemoteViews paramRemoteViews, Track paramTrack)
  {
    Resources localResources = BeyondPodApplication.GetInstance().getResources();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    String str = "";
    label113:
    Object localObject1;
    switch (mobi.beyondpod.rsscore.Configuration.WidgetBackgroundColor())
    {
    default: 
      paramRemoteViews.setViewVisibility(2131230845, 8);
      paramRemoteViews.setViewVisibility(2131230846, 0);
      switch (mobi.beyondpod.rsscore.Configuration.WidgetSecondaryButtonAction())
      {
      case 2: 
      default: 
        paramRemoteViews.setImageViewResource(2131230851, 2130837608);
        if (paramTrack != null)
        {
          localObject3 = paramTrack.getParentFeed();
          localObject2 = paramTrack.DisplayName();
          localObject1 = localObject2;
          if (((Feed)localObject3).getLeftTruncateLongTrackNames())
          {
            if (paramContext.getResources().getConfiguration().orientation != 2) {
              break label511;
            }
            i = 31;
            label158:
            localObject1 = localObject2;
            if (((String)localObject2).length() > i) {
              localObject1 = "..." + ((String)localObject2).substring(((String)localObject2).length() - i);
            }
          }
          if ((paramTrack.getCurrentPlayState() == 3) && (paramTrack.HasUrl()) && (paramTrack.getBufferedPercent() < 100))
          {
            paramContext = String.format(STARTING_STREAM_S, new Object[] { Integer.valueOf(paramTrack.getBufferedPercent()) });
            label246:
            paramRemoteViews.setImageViewResource(2131230848, GetProgressResource(paramTrack.PlayedAsFraction()));
            localObject3 = localObject1;
            localObject2 = paramContext;
            label267:
            paramContext = CoreHelper.ExternalStorageState();
            if ((!paramContext.equals("shared")) && (!paramContext.equals("unmounted"))) {
              break label571;
            }
            paramContext = localResources.getText(2131296905);
            localObject1 = str;
            label304:
            paramRemoteViews.setViewVisibility(2131230782, 0);
            paramRemoteViews.setViewVisibility(2131230854, 0);
            paramRemoteViews.setViewVisibility(2131230855, 0);
            paramRemoteViews.setViewVisibility(2131230852, 0);
            if (paramContext == null) {
              break label687;
            }
            paramRemoteViews.setViewVisibility(2131230782, 8);
            paramRemoteViews.setTextViewText(2131230854, paramContext);
            paramRemoteViews.setTextViewText(2131230852, "");
            paramRemoteViews.setViewVisibility(2131230855, 0);
            paramRemoteViews.setTextViewText(2131230855, (CharSequence)localObject1);
            if ((paramTrack == null) || (paramTrack.getCurrentPlayState() != 1)) {
              break label769;
            }
            i = 1;
            label398:
            if (i == 0) {
              break label774;
            }
            paramRemoteViews.setImageViewResource(2131230849, 2130837609);
            label412:
            if ((paramTrack == null) || (paramTrack.HasDownloadStarted())) {
              break label787;
            }
          }
        }
        break;
      }
      break;
    }
    label511:
    label571:
    label647:
    label679:
    label687:
    label769:
    label774:
    label787:
    for (int i = 0;; i = 8)
    {
      paramRemoteViews.setViewVisibility(2131230850, i);
      return;
      paramRemoteViews.setViewVisibility(2131230845, 8);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break;
      paramRemoteViews.setViewVisibility(2131230845, 0);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break;
      paramRemoteViews.setImageViewResource(2131230851, 2130837608);
      break label113;
      paramRemoteViews.setImageViewResource(2131230851, 2130837624);
      break label113;
      paramRemoteViews.setImageViewResource(2131230851, 2130837623);
      break label113;
      i = 20;
      break label158;
      if (paramTrack.getCurrentPlayState() == 7)
      {
        paramContext = PLAYBACK_ERROR;
        break label246;
      }
      if (paramTrack.getCurrentPlayState() == 8)
      {
        paramContext = PLAYBACK_ERROR_STREAMING_DISABLED;
        break label246;
      }
      paramContext = ((Feed)localObject3).getName();
      break label246;
      paramRemoteViews.setImageViewResource(2131230848, 2130837612);
      break label267;
      if (paramContext.equals("removed"))
      {
        paramContext = localResources.getText(2131296906);
        localObject1 = str;
        break label304;
      }
      if ((FeedRepository.RepositoryLoadState() == 0) || (FeedRepository.RepositoryLoadState() == 1))
      {
        paramContext = localResources.getText(2131296904);
        localObject1 = str;
        break label304;
      }
      paramContext = (Context)localObject4;
      localObject1 = str;
      if (localObject3 != null) {
        break label304;
      }
      if (PlayList.IsEmpty())
      {
        i = 2131296902;
        paramContext = localResources.getText(i);
        if (!SmartPlaylistTemplate.IsConfigured()) {
          break label679;
        }
      }
      for (localObject1 = localResources.getText(2131296903);; localObject1 = "")
      {
        break;
        i = 2131296944;
        break label647;
      }
      paramRemoteViews.setViewVisibility(2131230782, 0);
      paramRemoteViews.setTextViewText(2131230782, (CharSequence)localObject3);
      paramRemoteViews.setTextViewText(2131230854, (CharSequence)localObject2);
      paramRemoteViews.setViewVisibility(2131230855, 8);
      i = BeyondPodApplication.GetInstance().PlayList().PlaylistSize() - BeyondPodApplication.GetInstance().PlayList().GetCurrentPlayingTrackPosition();
      if (i > 0) {}
      for (paramContext = Integer.toString(i);; paramContext = "")
      {
        paramRemoteViews.setTextViewText(2131230852, paramContext);
        break;
      }
      i = 0;
      break label398;
      paramRemoteViews.setImageViewResource(2131230849, 2130837610);
      break label412;
    }
  }
  
  protected ComponentName ThisAppWidget()
  {
    return THIS_APPWIDGET;
  }
  
  protected void performNotificationUpdate()
  {
    if (!PlayList.IsCurrentlyPlaying()) {}
    Notification localNotification;
    do
    {
      return;
      localNotification = CreatePlayerNotification(BeyondPodApplication.GetInstance(), BeyondPodApplication.GetInstance().PlayList().CurrentTrack(), true);
    } while (localNotification == null);
    NotificationHelper.getInstance().UpdateNotification(BeyondPodApplication.GetInstance(), 1, localNotification);
  }
  
  protected void performWidgetUpdate(Context paramContext, int[] paramArrayOfInt)
  {
    Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfInt[i];
      RemoteViews localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903072);
      WireRemoteViews(paramContext, localRemoteViews, localTrack);
      WireRemoteViewButtons(paramContext, localRemoteViews, true);
      pushUpdate(paramContext, k, localRemoteViews);
      i += 1;
    }
  }
  
  public static class NotificationState
  {
    private static Bitmap _AlbumArt = null;
    private static Bitmap _AlbumArtBig = null;
    private static int _trackBigHash = 0;
    private static int _trackHash;
    public CharSequence Artist;
    public CharSequence InfoMessage;
    public int NextVisibility;
    public int PlayPauseResource;
    public CharSequence PlaylistSize;
    public int ProgressResource;
    public int StreamVisibility;
    public CharSequence Title;
    
    public static NotificationState BuildFromTrack(Track paramTrack, boolean paramBoolean, Context paramContext)
    {
      NotificationState localNotificationState = new NotificationState();
      Feed localFeed;
      Object localObject2;
      if (paramTrack != null)
      {
        localFeed = paramTrack.getParentFeed();
        localObject2 = paramTrack.DisplayName();
        Object localObject1 = localObject2;
        if (localFeed.getLeftTruncateLongTrackNames())
        {
          if (paramContext.getResources().getConfiguration().orientation != 2) {
            break label263;
          }
          i = 31;
          localObject1 = localObject2;
          if (((String)localObject2).length() > i) {
            localObject1 = "..." + ((String)localObject2).substring(((String)localObject2).length() - i);
          }
        }
        if ((paramTrack.getCurrentPlayState() == 3) && (paramTrack.HasUrl()) && (paramTrack.getBufferedPercent() < 100))
        {
          paramContext = String.format(MediaAppWidgetProvider.STARTING_STREAM_S, new Object[] { Integer.valueOf(paramTrack.getBufferedPercent()) });
          label141:
          localNotificationState.ProgressResource = MediaAppWidgetProvider.GetProgressResource(paramTrack.PlayedAsFraction());
          localNotificationState.Title = ((CharSequence)localObject1);
          localNotificationState.Artist = paramContext;
          i = BeyondPodApplication.GetInstance().PlayList().PlaylistSize() - BeyondPodApplication.GetInstance().PlayList().GetCurrentPlayingTrackPosition();
          if (i <= 0) {
            break label400;
          }
          paramContext = Integer.toString(i);
          label195:
          localNotificationState.PlaylistSize = paramContext;
          if ((paramTrack == null) || (paramTrack.getCurrentPlayState() != 1)) {
            break label460;
          }
          i = 1;
          label215:
          if (i == 0) {
            break label465;
          }
          localNotificationState.PlayPauseResource = 2130837609;
          label226:
          if ((paramTrack == null) || (paramTrack.HasDownloadStarted())) {
            break label475;
          }
          i = 0;
          label239:
          localNotificationState.StreamVisibility = i;
          if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() != 3) {
            break label481;
          }
        }
      }
      label263:
      label319:
      label392:
      label400:
      label460:
      label465:
      label475:
      label481:
      for (int i = 4;; i = 0)
      {
        localNotificationState.NextVisibility = i;
        return localNotificationState;
        i = 20;
        break;
        if (paramTrack.getCurrentPlayState() == 7)
        {
          paramContext = MediaAppWidgetProvider.PLAYBACK_ERROR;
          break label141;
        }
        if (paramTrack.getCurrentPlayState() == 8)
        {
          paramContext = MediaAppWidgetProvider.PLAYBACK_ERROR_STREAMING_DISABLED;
          break label141;
        }
        if ((!paramBoolean) || (!localFeed.HasUrl()))
        {
          paramContext = localFeed.getName();
          if (!ChromecastDevice.IsConnected()) {
            break label392;
          }
          paramContext = ChromecastUtils.buildCastingToTitle(null);
          break label141;
        }
        localObject2 = new StringBuilder(String.valueOf(DateTime.FormatDateTimeToday(paramTrack.getLastModifiedDate())));
        if (paramTrack.getTotalTime() > 0L) {}
        for (paramContext = " • " + paramTrack.TotalTimeAsMinuteString();; paramContext = "")
        {
          paramContext = paramContext;
          break label319;
          break;
        }
        paramContext = "";
        break label195;
        localNotificationState.ProgressResource = 2130837612;
        localNotificationState.InfoMessage = "";
        localNotificationState.PlaylistSize = "";
        if (SmartPlaylistTemplate.IsConfigured()) {}
        for (paramContext = MediaAppWidgetProvider.PLAYLIST_IS_EMPTY_START_SMARTPLAY;; paramContext = "")
        {
          localNotificationState.Artist = paramContext;
          localNotificationState.Title = MediaAppWidgetProvider.PLAYLIST_IS_EMPTY;
          break;
        }
        i = 0;
        break label215;
        localNotificationState.PlayPauseResource = 2130837610;
        break label226;
        i = 8;
        break label239;
      }
    }
    
    static Bitmap getBigBitmapForTrack(Context paramContext, Track paramTrack)
    {
      if (_trackBigHash != paramTrack.hashCode())
      {
        _trackBigHash = paramTrack.hashCode();
        int i = (int)paramContext.getResources().getDimension(2131492882);
        int j = (int)paramContext.getResources().getDimension(2131492883);
        _AlbumArtBig = null;
        _AlbumArtBig = ImageUtils.LoadEpisodeImage(paramTrack, i, j);
        if (_AlbumArtBig == null) {
          _AlbumArtBig = FeedImageCache.GetSizedFeedImageFor(paramTrack.getParentFeed(), i, j);
        }
        if (_AlbumArtBig == null) {
          _AlbumArtBig = BitmapFactory.decodeResource(paramContext.getResources(), 2130837601);
        }
        CoreHelper.WriteTraceEntry(MediaAppWidgetProvider.TAG, "----- Loaded large notification image for track: " + paramTrack.getName());
      }
      return _AlbumArtBig;
    }
    
    static Bitmap getSmallBitmapForTrack(Context paramContext, Track paramTrack)
    {
      if (_trackHash != paramTrack.hashCode())
      {
        _trackHash = paramTrack.hashCode();
        int i = (int)paramContext.getResources().getDimension(17104901);
        int j = (int)paramContext.getResources().getDimension(17104902);
        _AlbumArt = null;
        _AlbumArt = ImageUtils.LoadEpisodeImage(paramTrack, i, j);
        if (_AlbumArt == null) {
          _AlbumArt = FeedImageCache.GetSizedFeedImageFor(paramTrack.getParentFeed(), i, j);
        }
        if (_AlbumArt == null) {
          _AlbumArt = BitmapFactory.decodeResource(paramContext.getResources(), 2130837601);
        }
        CoreHelper.WriteTraceEntry(MediaAppWidgetProvider.TAG, "----- Loaded small notification image for track: " + paramTrack.getName());
      }
      return _AlbumArt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (!(paramObject instanceof NotificationState)) {
            return false;
          }
          paramObject = (NotificationState)paramObject;
          if (this.Artist == null)
          {
            if (((NotificationState)paramObject).Artist != null) {
              return false;
            }
          }
          else if (!this.Artist.equals(((NotificationState)paramObject).Artist)) {
            return false;
          }
          if (this.InfoMessage == null)
          {
            if (((NotificationState)paramObject).InfoMessage != null) {
              return false;
            }
          }
          else if (!this.InfoMessage.equals(((NotificationState)paramObject).InfoMessage)) {
            return false;
          }
          if (this.NextVisibility != ((NotificationState)paramObject).NextVisibility) {
            return false;
          }
          if (this.PlayPauseResource != ((NotificationState)paramObject).PlayPauseResource) {
            return false;
          }
          if (this.PlaylistSize == null)
          {
            if (((NotificationState)paramObject).PlaylistSize != null) {
              return false;
            }
          }
          else if (!this.PlaylistSize.equals(((NotificationState)paramObject).PlaylistSize)) {
            return false;
          }
          if (this.ProgressResource != ((NotificationState)paramObject).ProgressResource) {
            return false;
          }
          if (this.StreamVisibility != ((NotificationState)paramObject).StreamVisibility) {
            return false;
          }
          if (this.Title != null) {
            break;
          }
        } while (((NotificationState)paramObject).Title == null);
        return false;
      } while (this.Title.equals(((NotificationState)paramObject).Title));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i;
      int j;
      label21:
      int n;
      int i1;
      int k;
      label42:
      int i2;
      int i3;
      if (this.Artist == null)
      {
        i = 0;
        if (this.InfoMessage != null) {
          break label117;
        }
        j = 0;
        n = this.NextVisibility;
        i1 = this.PlayPauseResource;
        if (this.PlaylistSize != null) {
          break label128;
        }
        k = 0;
        i2 = this.ProgressResource;
        i3 = this.StreamVisibility;
        if (this.Title != null) {
          break label139;
        }
      }
      for (;;)
      {
        return (((((((i + 31) * 31 + j) * 31 + n) * 31 + i1) * 31 + k) * 31 + i2) * 31 + i3) * 31 + m;
        i = this.Artist.hashCode();
        break;
        label117:
        j = this.InfoMessage.hashCode();
        break label21;
        label128:
        k = this.PlaylistSize.hashCode();
        break label42;
        label139:
        m = this.Title.hashCode();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaAppWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */