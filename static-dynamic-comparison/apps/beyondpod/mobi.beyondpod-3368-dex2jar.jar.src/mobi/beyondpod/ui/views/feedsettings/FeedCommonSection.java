package mobi.beyondpod.ui.views.feedsettings;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.settings.SettingsView;

public class FeedCommonSection
  extends SettingsSectionBase
{
  private static final String HTTP = "http://";
  private static final String THIS_FEED_ALREADY_EXISTS_IN_CATEGORY = CoreHelper.LoadResourceString(2131297042);
  FeedAdvancedSection _AdvancedSettings;
  View _Cat1Num;
  View _Cat2Num;
  ImageButton _Cat2Toggle;
  CategoryList _Categories;
  Spinner _Category1;
  Spinner _Category2;
  View _CustomizeDefaults;
  EditText _DeleteIfOlderThan;
  String[] _DownloadActions;
  Spinner _DownloadPodcasts;
  Handler _Handler;
  EditText _KeepAtMost;
  EditText _NumPodcastsToDownload;
  TextView _NumPodcastsToDownloadAction;
  int _Old_keep_at_Most = -1;
  int _Old_max_age = -1;
  View.OnFocusChangeListener _OnURLFocusChanged = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        if (FeedCommonSection.this._Url.getText().toString().length() == 0) {
          FeedCommonSection.this._Url.setText("http://");
        }
      }
      while (!StringUtils.Equals(FeedCommonSection.this._Url.getText().toString().trim(), "http://")) {
        return;
      }
      FeedCommonSection.this._Url.setText("");
    }
  };
  String _OriginalFeedUrl = null;
  TextView _PodcastDefaults;
  View _PodcastSectionFull;
  View _PodcastSectionSimple;
  TextView _ShowGlobals;
  View _SpaceSaversArea;
  ImageView _ToggleAdvancedPrefs;
  View _ToggleAdvancedPrefsHolder;
  View.OnClickListener _ToggleAdvancedPrefsListener;
  TextView _ToggleAdvancedPrefsMsg;
  EditText _Url;
  
  FeedCommonSection(FeedPropertiesView paramFeedPropertiesView)
  {
    super(paramFeedPropertiesView);
    this._StubId = 2131231051;
  }
  
  private String GenerateSimplePodcastSectionText()
  {
    int i = GetDownloadAction();
    int j = StringUtils.TryParseIntFromString(this._NumPodcastsToDownload.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultNumberPodcastsToDownload())).intValue();
    TimeSpan localTimeSpan = new TimeSpan(StringUtils.TryParseIntFromString(this._DeleteIfOlderThan.getText().toString(), Integer.valueOf(99999)).intValue(), 0L, 0L, 0L);
    String str = "";
    if (localTimeSpan.getTotalDays() < 99999.0D) {
      str = this._Owner.getResources().getString(2131296813, new Object[] { Integer.valueOf((int)localTimeSpan.getTotalDays()) });
    }
    int k = StringUtils.TryParseIntFromString(this._KeepAtMost.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultKeepAtMostPodcasts())).intValue();
    if (i == 0) {
      return this._Owner.getResources().getString(2131296807);
    }
    if (i == 3) {
      return this._Owner.getResources().getString(2131296812);
    }
    if (i == 1) {
      return this._Owner.getResources().getString(2131296808, new Object[] { this._Owner.getResources().getQuantityString(2131689472, j, new Object[] { Integer.valueOf(j) }), this._Owner.getResources().getQuantityString(2131689472, k, new Object[] { Integer.valueOf(k) }), str });
    }
    if (i == 2) {
      return this._Owner.getResources().getString(2131296809, new Object[] { this._Owner.getResources().getQuantityString(2131689472, j, new Object[] { Integer.valueOf(j) }), this._Owner.getResources().getQuantityString(2131689472, k, new Object[] { Integer.valueOf(k) }), str });
    }
    if (i == 4) {
      return this._Owner.getResources().getString(2131296810, new Object[] { this._Owner.getResources().getQuantityString(2131689472, j, new Object[] { Integer.valueOf(j) }) });
    }
    if (i == 5) {
      return this._Owner.getResources().getString(2131296811, new Object[] { this._Owner.getResources().getQuantityString(2131689472, j, new Object[] { Integer.valueOf(j) }) });
    }
    return "";
  }
  
  private void ToggleCat2(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this._Cat1Num.setVisibility(0);
      this._Cat2Num.setVisibility(0);
      this._Category2.setVisibility(0);
      this._Cat2Toggle.setImageResource(2130837837);
      return;
    }
    this._Cat1Num.setVisibility(8);
    this._Cat2Num.setVisibility(8);
    this._Category2.setVisibility(8);
    this._Cat2Toggle.setImageResource(2130837828);
  }
  
  private void ToggleDownloadOptions(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this._PodcastSectionSimple.setVisibility(8);
      this._PodcastSectionFull.setVisibility(0);
      return;
    }
    this._PodcastDefaults.setText(GenerateSimplePodcastSectionText());
    this._PodcastSectionSimple.setVisibility(0);
    this._PodcastSectionFull.setVisibility(8);
  }
  
  int GetDownloadAction()
  {
    return Integer.parseInt(this._DownloadActions[this._DownloadPodcasts.getSelectedItemPosition()]);
  }
  
  int GetDownloadActionPosition(int paramInt)
  {
    String str = Integer.toString(paramInt);
    paramInt = 0;
    String[] arrayOfString = this._DownloadActions;
    int k = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= k) {
        j = 0;
      }
      do
      {
        return j;
        j = paramInt;
      } while (arrayOfString[i].equals(str));
      paramInt += 1;
      i += 1;
    }
  }
  
  public boolean HasFeedAddressChanged()
  {
    return !StringUtils.EqualsIgnoreCase(this._OriginalFeedUrl, this._Url.getText().toString().trim());
  }
  
  protected void Initialize()
  {
    this._Handler = new Handler();
    this._Url = ((EditText)this._Owner.findViewById(2131231026));
    this._Url.setInputType(0);
    this._Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        FeedCommonSection.this._Url.setInputType(16);
      }
    }, 1000L);
    this._Url.setOnFocusChangeListener(this._OnURLFocusChanged);
    this._DownloadActions = this._Owner.getResources().getStringArray(2131623937);
    this._SpaceSaversArea = this._Owner.findViewById(2131231042);
    this._NumPodcastsToDownload = ((EditText)this._Owner.findViewById(2131231039));
    this._NumPodcastsToDownloadAction = ((TextView)this._Owner.findViewById(2131231038));
    this._DeleteIfOlderThan = ((EditText)this._Owner.findViewById(2131231046));
    this._KeepAtMost = ((EditText)this._Owner.findViewById(2131231044));
    this._Category1 = ((Spinner)this._Owner.findViewById(2131231028));
    this._Category2 = ((Spinner)this._Owner.findViewById(2131231031));
    this._Cat1Num = this._Owner.findViewById(2131231027);
    this._Cat2Num = this._Owner.findViewById(2131231030);
    this._Cat2Toggle = ((ImageButton)this._Owner.findViewById(2131231029));
    this._Cat2Toggle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = FeedCommonSection.this;
        if (FeedCommonSection.this._Category2.getVisibility() == 8) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.ToggleCat2(bool);
          return;
        }
      }
    });
    this._CustomizeDefaults = this._Owner.findViewById(2131231032);
    this._PodcastDefaults = ((TextView)this._Owner.findViewById(2131231034));
    this._PodcastSectionFull = this._Owner.findViewById(2131231035);
    this._PodcastSectionSimple = this._Owner.findViewById(2131231033);
    this._CustomizeDefaults.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = FeedCommonSection.this;
        if (FeedCommonSection.this._PodcastSectionSimple.getVisibility() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.ToggleDownloadOptions(bool);
          return;
        }
      }
    });
    this._DownloadPodcasts = ((Spinner)this._Owner.findViewById(2131231036));
    this._ToggleAdvancedPrefsHolder = this._Owner.findViewById(2131231055);
    this._ToggleAdvancedPrefsMsg = ((TextView)this._Owner.findViewById(2131231056));
    this._ToggleAdvancedPrefs = ((ImageView)this._Owner.findViewById(2131231057));
    this._ToggleAdvancedPrefsHolder.setVisibility(0);
    this._Categories = CategoryManager.GetCategoriesForAssignment();
    this._ShowGlobals = ((TextView)this._Owner.findViewById(2131231047));
    this._ShowGlobals.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(BeyondPodApplication.GetInstance(), SettingsView.class);
        paramAnonymousView.putExtra("StartScreen", 5);
        CommandManager.StartActivity(paramAnonymousView);
      }
    });
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this._Owner, 17367048, CategoryManager.GetCategoriesForAssignment());
    localArrayAdapter.setDropDownViewResource(17367049);
    this._Category1.setAdapter(localArrayAdapter);
    localArrayAdapter = new ArrayAdapter(this._Owner, 17367048, CategoryManager.GetCategoriesForAssignment());
    localArrayAdapter.setDropDownViewResource(17367049);
    this._Category2.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623936, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._DownloadPodcasts.setAdapter(localArrayAdapter);
    this._DownloadPodcasts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = FeedCommonSection.this._Owner.findViewById(2131231037);
        paramAnonymousView = (TextView)FeedCommonSection.this._Owner.findViewById(2131231041);
        paramAnonymousInt = FeedCommonSection.this.GetDownloadAction();
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2))
        {
          paramAnonymousAdapterView.setVisibility(0);
          FeedCommonSection.this._SpaceSaversArea.setVisibility(0);
        }
        for (;;)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
            if ((paramAnonymousInt == 5) || (paramAnonymousInt == 4))
            {
              paramAnonymousAdapterView.setVisibility(0);
              FeedCommonSection.this._SpaceSaversArea.setVisibility(8);
            }
            else
            {
              paramAnonymousAdapterView.setVisibility(8);
              FeedCommonSection.this._SpaceSaversArea.setVisibility(8);
            }
            break;
          }
        }
        paramAnonymousView.setText(2131296801);
        return;
        paramAnonymousView.setText(2131296802);
        FeedCommonSection.this._NumPodcastsToDownloadAction.setText(2131297136);
        return;
        paramAnonymousView.setText(2131296803);
        FeedCommonSection.this._NumPodcastsToDownloadAction.setText(2131297137);
        return;
        paramAnonymousView.setText(2131296806);
        return;
        paramAnonymousView.setText(2131296804);
        FeedCommonSection.this._NumPodcastsToDownloadAction.setText(2131297136);
        return;
        paramAnonymousView.setText(2131296805);
        FeedCommonSection.this._NumPodcastsToDownloadAction.setText(2131297137);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this._AdvancedSettings = new FeedAdvancedSection(this._Owner);
  }
  
  public boolean IsURLFeed()
  {
    return true;
  }
  
  public void LoadFromFeed(final Feed paramFeed)
  {
    boolean bool = false;
    int i;
    if (paramFeed != null)
    {
      this._Url.setText(paramFeed.getFeedUrl());
      this._OriginalFeedUrl = paramFeed.getFeedUrl();
      i = this._Categories.indexOf(paramFeed.getCategories().getPrimary());
      this._Category1.setSelection(i);
      i = this._Categories.indexOf(paramFeed.getCategories().getSecondary());
      this._Category2.setSelection(i);
      this._DownloadPodcasts.setSelection(GetDownloadActionPosition(paramFeed.getPodcastDownloadAction()));
      this._NumPodcastsToDownload.setText(Integer.toString(paramFeed.getMaxNumberPodcastToDownload()));
      this._Old_max_age = ((int)paramFeed.getMaximumPodcastAge().getTotalDays());
      this._DeleteIfOlderThan.setText(Integer.toString(this._Old_max_age));
      this._Old_keep_at_Most = paramFeed.getKeepAtMostPodcasts();
      this._KeepAtMost.setText(Integer.toString(this._Old_keep_at_Most));
      this._ShowGlobals.setVisibility(0);
      if (CategoryManager.Unassigned.equals(paramFeed.getCategories().getSecondary())) {}
      for (;;)
      {
        ToggleCat2(bool);
        this._ToggleAdvancedPrefsListener = new View.OnClickListener()
        {
          public void onClick(final View paramAnonymousView)
          {
            if (FeedCommonSection.this._AdvancedSettings.IsVisible())
            {
              FeedCommonSection.this._AdvancedSettings.Hide();
              FeedCommonSection.this._ToggleAdvancedPrefsMsg.setText(2131296877);
              FeedCommonSection.this._ToggleAdvancedPrefs.setImageResource(2130837961);
              return;
            }
            FeedCommonSection.this._AdvancedSettings.Show();
            FeedCommonSection.this._ToggleAdvancedPrefsMsg.setText(2131296854);
            FeedCommonSection.this._ToggleAdvancedPrefs.setImageResource(2130837973);
            if (!FeedCommonSection.this._AdvancedSettings.IsDataLoaded()) {
              FeedCommonSection.this._AdvancedSettings.LoadFromFeed(paramFeed);
            }
            paramAnonymousView = (ScrollView)FeedCommonSection.this._Owner.findViewById(2131231049);
            paramAnonymousView.postDelayed(new Runnable()
            {
              public void run()
              {
                paramAnonymousView.smoothScrollTo(0, FeedCommonSection.this._ToggleAdvancedPrefsHolder.getTop() - 20);
              }
            }, 100L);
          }
        };
        this._ToggleAdvancedPrefs.setOnClickListener(this._ToggleAdvancedPrefsListener);
        this._PodcastDefaults.setText(GenerateSimplePodcastSectionText());
        super.LoadFromFeed(paramFeed);
        return;
        bool = true;
      }
    }
    String str = this._Owner.getIntent().getDataString();
    if (StringUtils.IsNullOrEmpty(str)) {
      this._Url.setText("http://");
    }
    for (;;)
    {
      this._NumPodcastsToDownload.setText(Integer.toString(Configuration.getGlobalDefaultNumberPodcastsToDownload()));
      this._DeleteIfOlderThan.setText(Integer.toString((int)Configuration.getGlobalDefaultMaximumPodcastAge().getTotalDays()));
      this._KeepAtMost.setText(Integer.toString(Configuration.getGlobalDefaultKeepAtMostPodcasts()));
      this._DownloadPodcasts.setSelection(GetDownloadActionPosition(Configuration.getGlobalDefaultPodcastDownloadAction()));
      i = this._Categories.indexOf(Configuration.getActiveFeedCategory());
      this._Category1.setSelection(i);
      i = this._Categories.indexOf(CategoryManager.Unassigned);
      this._Category2.setSelection(i);
      this._ShowGlobals.setVisibility(0);
      ToggleCat2(false);
      break;
      this._Url.setText(str);
    }
  }
  
  void PatchFeedUrl(String paramString)
  {
    this._Url.setText(paramString);
    this._Url.requestFocus();
  }
  
  void Refresh(Feed paramFeed)
  {
    this._AdvancedSettings.Refresh(paramFeed);
  }
  
  public void SaveToFeed(Feed paramFeed)
  {
    paramFeed.setFeedUrl(this._Url.getText().toString().trim());
    paramFeed.getCategories().setPrimary((FeedCategory)this._Category1.getSelectedItem());
    if (this._Category2.getVisibility() == 0)
    {
      paramFeed.getCategories().setSecondary((FeedCategory)this._Category2.getSelectedItem());
      paramFeed.setPodcastDownloadAction(GetDownloadAction());
      int i = StringUtils.TryParseIntFromString(this._NumPodcastsToDownload.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultNumberPodcastsToDownload())).intValue();
      if (i <= 0) {
        break label203;
      }
      paramFeed.setMaxNumberPodcastsToDownload(i);
    }
    for (;;)
    {
      paramFeed.setMaximumPodcastAge(new TimeSpan(StringUtils.TryParseIntFromString(this._DeleteIfOlderThan.getText().toString(), Integer.valueOf(99999)).intValue(), 0L, 0L, 0L));
      paramFeed.setKeepAtMostPodcasts(StringUtils.TryParseIntFromString(this._KeepAtMost.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultKeepAtMostPodcasts())).intValue());
      if (!this._AdvancedSettings.IsDataLoaded()) {
        break label211;
      }
      this._AdvancedSettings.SaveToFeed(paramFeed);
      return;
      paramFeed.getCategories().setSecondary(CategoryManager.Unassigned);
      break;
      label203:
      paramFeed.setPodcastDownloadAction(0);
    }
    label211:
    this._AdvancedSettings.UpdateFeedNameToFeedURLIfNeeded(paramFeed);
  }
  
  public boolean ValidateControls(Feed paramFeed)
  {
    this._OnURLFocusChanged.onFocusChange(null, false);
    final Object localObject2 = this._Url.getText().toString().trim();
    String str = ((String)localObject2).toLowerCase();
    Object localObject1 = localObject2;
    if (str.length() > 5)
    {
      localObject1 = localObject2;
      if (str.startsWith("feed:")) {
        localObject1 = "http:" + ((String)localObject2).substring(5);
      }
    }
    if ((((String)localObject1).length() < 5) || (CoreHelper.SafeCreateUri((String)localObject1) == null))
    {
      Toast.makeText(this._Owner, 2131296789, 1).show();
      this._Url.requestFocus();
      return false;
    }
    localObject2 = FeedRepository.GetFeedByUrl((String)localObject1);
    if ((localObject2 != null) && (localObject2 != paramFeed))
    {
      Toast.makeText(this._Owner, String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { ((Feed)localObject2).getCategories().getPrimary().Name() }), 1).show();
      this._Url.requestFocus();
      return false;
    }
    int k = StringUtils.TryParseIntFromString(this._KeepAtMost.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultKeepAtMostPodcasts())).intValue();
    int m = StringUtils.TryParseIntFromString(this._NumPodcastsToDownload.getText().toString(), Integer.valueOf(Configuration.getGlobalDefaultNumberPodcastsToDownload())).intValue();
    int n = StringUtils.TryParseIntFromString(this._DeleteIfOlderThan.getText().toString(), Integer.valueOf(99999)).intValue();
    int i;
    if (this._Old_keep_at_Most != k)
    {
      i = 1;
      if (this._Old_max_age == n) {
        break label342;
      }
    }
    label342:
    for (int j = 1;; j = 0)
    {
      if (((GetDownloadAction() != 1) && (GetDownloadAction() != 2)) || (m <= k)) {
        break label347;
      }
      Toast.makeText(this._Owner, 2131296792, 1).show();
      this._KeepAtMost.requestFocus();
      return false;
      i = 0;
      break;
    }
    label347:
    if (((i != 0) || (j != 0)) && ((GetDownloadAction() == 1) || (GetDownloadAction() == 2)) && (paramFeed != null))
    {
      localObject2 = FeedRepository.GetOldTracksForFeed(paramFeed, k, new TimeSpan(n, 0L, 0L, 0L), false);
      if (((TrackList)localObject2).size() > 0)
      {
        new AlertDialog.Builder(this._Owner).setMessage(this._Owner.getString(2131296793, new Object[] { Integer.valueOf(((TrackList)localObject2).size()) })).setPositiveButton(2131296977, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            CommandManager.CmdDeletePodcasts(FeedCommonSection.this._Owner, localObject2);
          }
        }).setNegativeButton(2131296315, null).create().show();
        return false;
      }
    }
    this._Url.setText((CharSequence)localObject1);
    return this._AdvancedSettings.ValidateControls(paramFeed);
  }
  
  public void focusControl(int paramInt)
  {
    if ((paramInt == 2131230998) && (!this._AdvancedSettings.IsVisible())) {
      this._ToggleAdvancedPrefsListener.onClick(this._ToggleAdvancedPrefs);
    }
    for (;;)
    {
      super.focusControl(paramInt);
      return;
      ToggleDownloadOptions(true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/FeedCommonSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */