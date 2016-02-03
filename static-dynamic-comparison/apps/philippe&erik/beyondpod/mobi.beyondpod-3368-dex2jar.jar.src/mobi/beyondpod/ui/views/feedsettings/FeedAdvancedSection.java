package mobi.beyondpod.ui.views.feedsettings;

import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.ui.core.FeedImageCache;

public class FeedAdvancedSection
  extends SettingsSectionBase
{
  private static final String TAG = FeedAdvancedSection.class.getSimpleName();
  CheckBox _AllowDeletions;
  Button _ClearCustomImage;
  Button _ClearHistory;
  Button _CustomImage;
  TextView _DownloadFolderMessage;
  TextView _DownloadFolderTitle;
  ImageView _FeedImage;
  View _FeedImageBody;
  View _FeedImageMsg;
  View _FeedImageTitle;
  EditText _FeedPassword;
  EditText _FeedUserName;
  Spinner _FingerprintType;
  CheckBox _ForceUniqueNames;
  TextView _ForceUniqueNamesMsg;
  View _GoogleProxyNumItemsArea;
  private int _ItemFingerprintTypeOnLoad;
  Spinner _ItemSortOrder;
  Spinner _LongPodcasNamesHandling;
  Button _MarkDownloaded;
  EditText _Name;
  EditText _NumGreaderItemsToGet;
  PlaybackSpeedSettings _PlaybackSpeed;
  EditText _PodcastDownloadFolder;
  Spinner _PodcastSort;
  Spinner _PreferredEnclosure;
  CheckBox _SavePlayedPosition;
  CheckBox _UseGoogleProxy;
  CompoundButton.OnCheckedChangeListener _onSyncWithGoogleChanged = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      paramAnonymousCompoundButton = FeedAdvancedSection.this._GoogleProxyNumItemsArea;
      if (paramAnonymousBoolean) {}
      for (int i = 0;; i = 8)
      {
        paramAnonymousCompoundButton.setVisibility(i);
        if ((paramAnonymousBoolean) && ((StringUtils.IsNullOrEmpty(FeedAdvancedSection.this._NumGreaderItemsToGet.getText().toString())) || (StringUtils.Equals(FeedAdvancedSection.this._NumGreaderItemsToGet.getText().toString(), "0")))) {
          FeedAdvancedSection.this._NumGreaderItemsToGet.setText(Integer.toString(Configuration.getGlobalDefaultMaximumGReaderItemsToGet()));
        }
        return;
      }
    }
  };
  
  FeedAdvancedSection(FeedPropertiesView paramFeedPropertiesView)
  {
    super(paramFeedPropertiesView);
    this._StubId = 2131231058;
  }
  
  private void RefreshFeedImage(Feed paramFeed)
  {
    this._FeedImage.setImageDrawable(FeedImageCache.GetFeedImageFor(paramFeed));
    Button localButton = this._ClearCustomImage;
    if (FeedImageCache.HasCustomImageForFeed(paramFeed)) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public boolean HasFeedAddressChanged()
  {
    return false;
  }
  
  protected void Initialize()
  {
    this._DownloadFolderTitle = ((TextView)this._InflatedContent.findViewById(2131231004));
    this._DownloadFolderMessage = ((TextView)this._InflatedContent.findViewById(2131231006));
    this._DownloadFolderMessage.setText(String.format(this._InflatedContent.getResources().getText(2131296816).toString(), new Object[] { Configuration.EnclosureDownloadRoot() }));
    this._Name = ((EditText)this._InflatedContent.findViewById(2131230994));
    this._PodcastDownloadFolder = ((EditText)this._InflatedContent.findViewById(2131231005));
    this._FeedUserName = ((EditText)this._InflatedContent.findViewById(2131231000));
    this._FeedPassword = ((EditText)this._InflatedContent.findViewById(2131231001));
    this._PodcastSort = ((Spinner)this._InflatedContent.findViewById(2131231003));
    this._LongPodcasNamesHandling = ((Spinner)this._InflatedContent.findViewById(2131231011));
    this._FingerprintType = ((Spinner)this._InflatedContent.findViewById(2131231012));
    this._AllowDeletions = ((CheckBox)this._InflatedContent.findViewById(2131231015));
    this._SavePlayedPosition = ((CheckBox)this._InflatedContent.findViewById(2131231016));
    this._ItemSortOrder = ((Spinner)this._InflatedContent.findViewById(2131231002));
    this._PreferredEnclosure = ((Spinner)this._InflatedContent.findViewById(2131231017));
    this._ClearHistory = ((Button)this._InflatedContent.findViewById(2131231019));
    this._MarkDownloaded = ((Button)this._InflatedContent.findViewById(2131231018));
    this._CustomImage = ((Button)this._InflatedContent.findViewById(2131231023));
    this._ClearCustomImage = ((Button)this._InflatedContent.findViewById(2131231024));
    this._PlaybackSpeed = new PlaybackSpeedSettings(this._InflatedContent);
    ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623940, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._PodcastSort.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623956, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._LongPodcasNamesHandling.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131624002, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._FingerprintType.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623946, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._ItemSortOrder.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623974, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._PreferredEnclosure.setAdapter(localArrayAdapter);
    this._ForceUniqueNames = ((CheckBox)this._InflatedContent.findViewById(2131231013));
    this._ForceUniqueNamesMsg = ((TextView)this._InflatedContent.findViewById(2131231014));
    this._FeedImage = ((ImageView)this._InflatedContent.findViewById(2131231022));
    this._FeedImageTitle = this._InflatedContent.findViewById(2131231020);
    this._FeedImageBody = this._InflatedContent.findViewById(2131231021);
    this._FeedImageMsg = this._InflatedContent.findViewById(2131231025);
    this._GoogleProxyNumItemsArea = this._Owner.findViewById(2131230997);
    this._NumGreaderItemsToGet = ((EditText)this._Owner.findViewById(2131230998));
    this._UseGoogleProxy = ((CheckBox)this._Owner.findViewById(2131230996));
    this._UseGoogleProxy.setOnCheckedChangeListener(this._onSyncWithGoogleChanged);
  }
  
  public boolean IsURLFeed()
  {
    return true;
  }
  
  public void LoadFromFeed(Feed paramFeed)
  {
    int j = 0;
    Object localObject;
    label133:
    boolean bool;
    if (paramFeed != null)
    {
      this._Name.setText(paramFeed.getName());
      this._NumGreaderItemsToGet.setText(Integer.toString(paramFeed.getMaxNumGReaderItemsToGet()));
      this._UseGoogleProxy.setChecked(paramFeed.IsGReaderFeed());
      this._PodcastDownloadFolder.setText(paramFeed.getFeedPath());
      i = CoreHelper.FindIndexInNumArray(this._Owner, 2131623941, Integer.valueOf(paramFeed.getTrackSortOrder()));
      if (i != -1)
      {
        this._PodcastSort.setSelection(i);
        this._ItemFingerprintTypeOnLoad = paramFeed.getItemFingerprintAlgorithm();
        i = CoreHelper.FindIndexInNumArray(this._Owner, 2131624001, Integer.valueOf(paramFeed.getItemFingerprintAlgorithm()));
        this._FingerprintType.setSelection(i);
        localObject = this._LongPodcasNamesHandling;
        if (!paramFeed.getLeftTruncateLongTrackNames()) {
          break label436;
        }
        i = 1;
        ((Spinner)localObject).setSelection(i);
        localObject = this._AllowDeletions;
        if (paramFeed.getAllowAutoTrackDeletions() == 1) {
          break label441;
        }
        bool = true;
        label156:
        ((CheckBox)localObject).setChecked(bool);
        this._SavePlayedPosition.setChecked(paramFeed.getShouldRememberPlayedPosition());
        switch (paramFeed.getForceFeedItemSort())
        {
        case 0: 
        case 1: 
        default: 
          label212:
          this._PlaybackSpeed.initialize(paramFeed.getFeedPlayer());
          this._PreferredEnclosure.setSelection(paramFeed.getPreferredEnclosureIndex());
          this._ForceUniqueNames.setChecked(paramFeed.getForceUniqueTrackNames());
          this._FeedUserName.setText(paramFeed.getUserName());
          this._FeedPassword.setText(paramFeed.getPassword());
          RefreshFeedImage(paramFeed);
          label272:
          if (paramFeed == null)
          {
            this._FeedImageTitle.setVisibility(8);
            this._FeedImageBody.setVisibility(8);
            this._FeedImageMsg.setVisibility(8);
          }
          this._ClearHistory.setOnClickListener(this._Owner._ClearHistoryListener);
          this._MarkDownloaded.setOnClickListener(this._Owner._MarkDownloadedListener);
          this._CustomImage.setOnClickListener(this._Owner._SelectCustomImageListener);
          this._ClearCustomImage.setOnClickListener(this._Owner._ClearCustomImageListener);
          localObject = this._PodcastDownloadFolder;
          if (Configuration.EnableLoggingInProduction())
          {
            i = 0;
            label373:
            ((EditText)localObject).setVisibility(i);
            localObject = this._DownloadFolderMessage;
            if (!Configuration.EnableLoggingInProduction()) {
              break label550;
            }
            i = 0;
            label393:
            ((TextView)localObject).setVisibility(i);
            localObject = this._DownloadFolderTitle;
            if (!Configuration.EnableLoggingInProduction()) {
              break label556;
            }
          }
          break;
        }
      }
    }
    label436:
    label441:
    label550:
    label556:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      super.LoadFromFeed(paramFeed);
      return;
      this._PodcastSort.setSelection(0);
      break;
      i = 0;
      break label133;
      bool = false;
      break label156;
      this._ItemSortOrder.setSelection(0);
      break label212;
      this._ItemSortOrder.setSelection(1);
      break label212;
      this._ItemSortOrder.setSelection(2);
      break label212;
      this._UseGoogleProxy.setChecked(false);
      this._NumGreaderItemsToGet.setText(Integer.toString(Configuration.getGlobalDefaultMaximumGReaderItemsToGet()));
      this._MarkDownloaded.setEnabled(false);
      this._ClearHistory.setEnabled(false);
      this._AllowDeletions.setChecked(true);
      this._SavePlayedPosition.setChecked(true);
      this._PlaybackSpeed.initialize(0);
      break label272;
      i = 8;
      break label373;
      i = 8;
      break label393;
    }
  }
  
  void PatchFeedUrl(String paramString) {}
  
  void Refresh(Feed paramFeed)
  {
    RefreshFeedImage(paramFeed);
  }
  
  public void SaveToFeed(Feed paramFeed)
  {
    int j = 0;
    paramFeed.setName(this._Name.getText().toString().trim());
    UpdateFeedNameToFeedURLIfNeeded(paramFeed);
    paramFeed.setFeedPath(this._PodcastDownloadFolder.getText().toString());
    paramFeed.setForceUniqueTrackNames(this._ForceUniqueNames.isChecked());
    paramFeed.setPreferredEnclosureIndex(this._PreferredEnclosure.getSelectedItemPosition());
    int i;
    boolean bool;
    switch (this._ItemSortOrder.getSelectedItemPosition())
    {
    default: 
      i = CoreHelper.FindIndexValueInNumArray(this._Owner, 2131623941, this._PodcastSort.getSelectedItemPosition());
      if (i != Integer.MIN_VALUE) {
        paramFeed.setTrackSortOrder(i);
      }
      i = CoreHelper.FindIndexValueInNumArray(this._Owner, 2131624001, this._FingerprintType.getSelectedItemPosition());
      if (i != Integer.MIN_VALUE) {
        paramFeed.setItemFingerprintAlgorithm(i);
      }
      if (this._ItemFingerprintTypeOnLoad != paramFeed.getItemFingerprintAlgorithm())
      {
        CoreHelper.WriteTraceEntry(TAG, "Feed Item Fingeprint Type changed! Deleting feed cache...");
        RssFeedCache.DeleteFeedCacheFor(paramFeed);
      }
      paramFeed.setFeedPlayer(this._PlaybackSpeed.getSelectedSpeed());
      if (this._LongPodcasNamesHandling.getSelectedItemPosition() == 1)
      {
        bool = true;
        label205:
        paramFeed.setLeftTruncateLongTrackNames(bool);
        if (!this._AllowDeletions.isChecked()) {
          break label389;
        }
        i = 0;
        label223:
        paramFeed.setAllowAutoTrackDeletions(i);
        paramFeed.setShouldRememberPlayedPosition(this._SavePlayedPosition.isChecked());
        if (paramFeed.getType() == 1) {
          FeedRepository.RefreshFeed(paramFeed);
        }
        String str1 = this._FeedUserName.getText().toString().trim();
        String str2 = this._FeedPassword.getText().toString().trim();
        if (StringUtils.IsNullOrEmpty(str1)) {
          break label394;
        }
        paramFeed.setUserName(str1);
        label299:
        if (StringUtils.IsNullOrEmpty(str2)) {
          break label402;
        }
        paramFeed.setPassword(str2);
      }
      break;
    }
    for (;;)
    {
      paramFeed.setMaxNumGReaderItemsToGet(StringUtils.TryParseIntFromString(this._NumGreaderItemsToGet.getText().toString(), Integer.valueOf(0)).intValue());
      i = j;
      if (this._UseGoogleProxy.isChecked()) {
        i = 5;
      }
      paramFeed.setType(i);
      return;
      paramFeed.setForceFeedItemSort(-1);
      break;
      paramFeed.setForceFeedItemSort(3);
      break;
      paramFeed.setForceFeedItemSort(2);
      break;
      bool = false;
      break label205;
      label389:
      i = 1;
      break label223;
      label394:
      paramFeed.setUserName(null);
      break label299;
      label402:
      paramFeed.setPassword(null);
    }
  }
  
  public void Show()
  {
    super.Show();
  }
  
  void UpdateFeedNameToFeedURLIfNeeded(Feed paramFeed)
  {
    if ((StringUtils.IsNullOrEmpty(paramFeed.getName())) || (paramFeed.getName().toLowerCase().startsWith("http:"))) {
      paramFeed.setName(paramFeed.getFeedUrl());
    }
  }
  
  public boolean ValidateControls(Feed paramFeed)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/FeedAdvancedSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */