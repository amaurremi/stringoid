package mobi.beyondpod.ui.views.feedsettings;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class VirtualFeedSection
  extends SettingsSectionBase
{
  private static final String THIS_FEED_ALREADY_EXISTS_IN_CATEGORY = CoreHelper.LoadResourceString(2131297042);
  CheckBox _AllowDeletions;
  View _Cat1Num;
  View _Cat2Num;
  ImageButton _Cat2Toggle;
  CategoryList _Categories;
  Spinner _Category1;
  Spinner _Category2;
  Handler _Handler;
  Spinner _LongPodcasNamesHandling;
  EditText _Name;
  String _OriginalDownloadFolder = null;
  PlaybackSpeedSettings _PlaybackSpeed;
  EditText _PodcastDownloadFolder;
  Spinner _PodcastSort;
  CheckBox _SavePlayedPosition;
  
  VirtualFeedSection(FeedPropertiesView paramFeedPropertiesView)
  {
    super(paramFeedPropertiesView);
    this._StubId = 2131231053;
  }
  
  private String NormalizeFolder(File paramFile)
  {
    try
    {
      Object localObject = paramFile.getCanonicalPath();
      paramFile = new StringTokenizer((String)localObject, File.separator, false);
      localObject = new StringBuilder(File.separator);
      if (!paramFile.hasMoreTokens()) {
        return ((StringBuilder)localObject).toString();
      }
    }
    catch (IOException localIOException)
    {
      return paramFile.getPath();
    }
    String str = paramFile.nextToken();
    File[] arrayOfFile = new File(localIOException.toString()).listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if ((localFile.isDirectory()) && (StringUtils.EqualsIgnoreCase(localFile.getName(), str)))
      {
        if (localIOException.length() > 1) {
          localIOException.append(File.separator);
        }
        localIOException.append(localFile.getName());
        break;
      }
      i += 1;
    }
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
  
  public boolean HasFeedAddressChanged()
  {
    return !StringUtils.EqualsIgnoreCase(this._OriginalDownloadFolder, this._PodcastDownloadFolder.getText().toString());
  }
  
  protected void Initialize()
  {
    this._Handler = new Handler();
    this._Name = ((EditText)this._InflatedContent.findViewById(2131230994));
    this._PodcastDownloadFolder = ((EditText)this._InflatedContent.findViewById(2131231005));
    this._PodcastSort = ((Spinner)this._InflatedContent.findViewById(2131231003));
    this._LongPodcasNamesHandling = ((Spinner)this._InflatedContent.findViewById(2131231011));
    this._AllowDeletions = ((CheckBox)this._InflatedContent.findViewById(2131231015));
    this._SavePlayedPosition = ((CheckBox)this._InflatedContent.findViewById(2131231016));
    this._Category1 = ((Spinner)this._Owner.findViewById(2131231028));
    this._Category2 = ((Spinner)this._Owner.findViewById(2131231031));
    this._Cat1Num = this._Owner.findViewById(2131231027);
    this._Cat2Num = this._Owner.findViewById(2131231030);
    this._Cat2Toggle = ((ImageButton)this._Owner.findViewById(2131231029));
    this._Cat2Toggle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = VirtualFeedSection.this;
        if (VirtualFeedSection.this._Category2.getVisibility() == 8) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.ToggleCat2(bool);
          return;
        }
      }
    });
    this._PlaybackSpeed = new PlaybackSpeedSettings(this._InflatedContent);
    ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623940, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._PodcastSort.setAdapter(localArrayAdapter);
    localArrayAdapter = ArrayAdapter.createFromResource(this._Owner, 2131623956, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this._LongPodcasNamesHandling.setAdapter(localArrayAdapter);
    this._Categories = CategoryManager.GetCategoriesForAssignment();
    this._Owner.findViewById(2131231057).setVisibility(8);
    localArrayAdapter = new ArrayAdapter(this._Owner, 17367048, CategoryManager.GetCategoriesForAssignment());
    localArrayAdapter.setDropDownViewResource(17367049);
    this._Category1.setAdapter(localArrayAdapter);
    localArrayAdapter = new ArrayAdapter(this._Owner, 17367048, CategoryManager.GetCategoriesForAssignment());
    localArrayAdapter.setDropDownViewResource(17367049);
    this._Category2.setAdapter(localArrayAdapter);
    this._PodcastDownloadFolder.setInputType(0);
    this._Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        VirtualFeedSection.this._PodcastDownloadFolder.setInputType(16);
      }
    }, 1000L);
  }
  
  public boolean IsURLFeed()
  {
    return false;
  }
  
  public void LoadFromFeed(Feed paramFeed)
  {
    boolean bool2 = false;
    int i;
    Object localObject;
    label83:
    boolean bool1;
    if (paramFeed != null)
    {
      this._Name.setText(paramFeed.getName());
      this._PodcastDownloadFolder.setText(paramFeed.getFeedPath());
      this._OriginalDownloadFolder = paramFeed.getFeedPath();
      i = CoreHelper.FindIndexInNumArray(this._Owner, 2131623941, Integer.valueOf(paramFeed.getTrackSortOrder()));
      if (i != -1)
      {
        this._PodcastSort.setSelection(i);
        localObject = this._LongPodcasNamesHandling;
        if (!paramFeed.getLeftTruncateLongTrackNames()) {
          break label220;
        }
        i = 1;
        ((Spinner)localObject).setSelection(i);
        localObject = this._AllowDeletions;
        if (paramFeed.getAllowAutoTrackDeletions() == 1) {
          break label225;
        }
        bool1 = true;
        label105:
        ((CheckBox)localObject).setChecked(bool1);
        this._SavePlayedPosition.setChecked(paramFeed.getShouldRememberPlayedPosition());
        i = this._Categories.indexOf(paramFeed.getCategories().getPrimary());
        this._Category1.setSelection(i);
        i = this._Categories.indexOf(paramFeed.getCategories().getSecondary());
        this._Category2.setSelection(i);
        this._PlaybackSpeed.initialize(paramFeed.getFeedPlayer());
        if (!CategoryManager.Unassigned.equals(paramFeed.getCategories().getSecondary())) {
          break label230;
        }
        bool1 = bool2;
        label198:
        ToggleCat2(bool1);
      }
    }
    for (;;)
    {
      super.LoadFromFeed(paramFeed);
      return;
      this._PodcastSort.setSelection(0);
      break;
      label220:
      i = 0;
      break label83;
      label225:
      bool1 = false;
      break label105;
      label230:
      bool1 = true;
      break label198;
      this._PlaybackSpeed.initialize(0);
      this._AllowDeletions.setChecked(false);
      this._SavePlayedPosition.setChecked(true);
      localObject = this._Owner.getIntent().getDataString();
      if (!StringUtils.IsNullOrEmpty((String)localObject))
      {
        this._PodcastDownloadFolder.setText((CharSequence)localObject);
        localObject = new File((String)localObject).getName();
        this._Name.setText(String.format("%s%s", new Object[] { Character.valueOf(Character.toUpperCase(((String)localObject).charAt(0))), ((String)localObject).substring(1) }));
      }
      i = this._Categories.indexOf(Configuration.getActiveFeedCategory());
      this._Category1.setSelection(i);
      i = this._Categories.indexOf(CategoryManager.Unassigned);
      this._Category2.setSelection(i);
      ToggleCat2(false);
    }
  }
  
  void PatchFeedUrl(String paramString) {}
  
  void Refresh(Feed paramFeed) {}
  
  public void SaveToFeed(Feed paramFeed)
  {
    int i = 0;
    paramFeed.setName(this._Name.getText().toString());
    paramFeed.setFeedPath(this._PodcastDownloadFolder.getText().toString());
    boolean bool;
    if (this._LongPodcasNamesHandling.getSelectedItemPosition() == 1)
    {
      bool = true;
      paramFeed.setLeftTruncateLongTrackNames(bool);
      if (!this._AllowDeletions.isChecked()) {
        break label174;
      }
      label62:
      paramFeed.setAllowAutoTrackDeletions(i);
      paramFeed.setShouldRememberPlayedPosition(this._SavePlayedPosition.isChecked());
      paramFeed.setType(1);
      paramFeed.getCategories().setPrimary((FeedCategory)this._Category1.getSelectedItem());
      if (this._Category2.getVisibility() != 0) {
        break label179;
      }
      paramFeed.getCategories().setSecondary((FeedCategory)this._Category2.getSelectedItem());
    }
    for (;;)
    {
      i = CoreHelper.FindIndexValueInNumArray(this._Owner, 2131623941, this._PodcastSort.getSelectedItemPosition());
      if (i != Integer.MIN_VALUE) {
        paramFeed.setTrackSortOrder(i);
      }
      paramFeed.setFeedPlayer(this._PlaybackSpeed.getSelectedSpeed());
      return;
      bool = false;
      break;
      label174:
      i = 1;
      break label62;
      label179:
      paramFeed.getCategories().setSecondary(CategoryManager.Unassigned);
    }
  }
  
  public boolean ValidateControls(Feed paramFeed)
  {
    Object localObject1 = this._PodcastDownloadFolder.getText().toString().trim();
    Object localObject2 = new File((String)localObject1);
    if ((StringUtils.IsNullOrEmpty((String)localObject1)) || (!((File)localObject2).exists()))
    {
      Toast.makeText(this._Owner, 2131296791, 1).show();
      this._PodcastDownloadFolder.requestFocus();
      return false;
    }
    localObject1 = NormalizeFolder((File)localObject2);
    this._PodcastDownloadFolder.setText((CharSequence)localObject1);
    localObject2 = this._Name.getText().toString().trim();
    if (((String)localObject2).length() == 0)
    {
      Toast.makeText(this._Owner, 2131296790, 1).show();
      this._Name.requestFocus();
      return false;
    }
    this._Name.setText((CharSequence)localObject2);
    localObject1 = FeedRepository.GetVirtualFeedByDownloadPath((String)localObject1);
    if ((localObject1 != null) && (localObject1 != paramFeed))
    {
      Toast.makeText(this._Owner, String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { ((Feed)localObject1).getCategories().getPrimary().Name() }), 1).show();
      this._PodcastDownloadFolder.requestFocus();
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/VirtualFeedSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */