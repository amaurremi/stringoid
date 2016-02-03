package mobi.beyondpod.ui.views;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.FeedSorter;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.services.player.SmartPlaylistTemplate.SmartPlaylistEntry;
import mobi.beyondpod.ui.core.ActionBarActivityBase;

public class SmartPlaylistEditorView
  extends ActionBarActivityBase
{
  private static final String START_WITH = CoreHelper.LoadResourceString(2131297102);
  private static final String TAG = SmartPlaylistEditorView.class.getSimpleName();
  private static final String THEN_PLAY = CoreHelper.LoadResourceString(2131297101);
  ArrayList<SmartPlaylistTemplate.SmartPlaylistEntry> _AllEntries;
  Button _CancelButton;
  private LinearLayout _ListHolder;
  String[] _NumEpisodes;
  Button _OKButton;
  private View.OnClickListener _OnCancelListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      SmartPlaylistEditorView.this.finish();
    }
  };
  private View.OnClickListener _OnOKListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      SmartPlaylistEditorView.this._Template.SaveToFile();
      SmartPlaylistEditorView.this.finish();
    }
  };
  private ScrollView _ScrollView;
  SmartPlaylistTemplate _Template;
  
  void BindTemplates()
  {
    int i;
    if (this._Template.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == this._Template.size()) {
        return;
      }
      View localView = BuildItem((SmartPlaylistTemplate.SmartPlaylistEntry)this._Template.Entries().get(i), i);
      this._ListHolder.addView(localView, this._ListHolder.getChildCount());
      i += 1;
    }
  }
  
  View BuildItem(final SmartPlaylistTemplate.SmartPlaylistEntry paramSmartPlaylistEntry, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2130903164, null);
    Object localObject2 = (TextView)localView.findViewById(2131231195);
    Object localObject1;
    int j;
    int i;
    Iterator localIterator;
    if (paramInt == 0)
    {
      localObject1 = START_WITH;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((ImageView)localView.findViewById(2131231197)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SmartPlaylistEditorView.this._Template.Entries().remove(paramSmartPlaylistEntry);
          SmartPlaylistEditorView.this.ReBindTemplates();
        }
      });
      localObject1 = (Spinner)localView.findViewById(2131231202);
      localObject2 = new ArrayAdapter(this, 17367048, GetEntriesForAssignment());
      ((ArrayAdapter)localObject2).setDropDownViewResource(17367049);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      j = 0;
      i = 0;
      if ((paramSmartPlaylistEntry.Category != null) || (paramSmartPlaylistEntry.Feed != null))
      {
        localIterator = GetEntriesForAssignment().iterator();
        label132:
        if (localIterator.hasNext()) {
          break label416;
        }
        j = i;
      }
      label145:
      if (j < ((ArrayAdapter)localObject2).getCount()) {
        ((Spinner)localObject1).setSelection(j);
      }
      ((Spinner)localObject1).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (SmartPlaylistTemplate.SmartPlaylistEntry)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          paramSmartPlaylistEntry.Feed = paramAnonymousAdapterView.Feed;
          paramSmartPlaylistEntry.Category = paramAnonymousAdapterView.Category;
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      localObject1 = (Spinner)localView.findViewById(2131231196);
      localObject2 = ArrayAdapter.createFromResource(this, 2131623967, 17367048);
      ((ArrayAdapter)localObject2).setDropDownViewResource(17367049);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      if (paramSmartPlaylistEntry.SortOrder != 3) {
        break label462;
      }
      i = 0;
      label222:
      ((Spinner)localObject1).setSelection(i);
      ((Spinner)localObject1).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = paramSmartPlaylistEntry;
          if (paramAnonymousInt == 0) {}
          for (paramAnonymousInt = 3;; paramAnonymousInt = 2)
          {
            paramAnonymousAdapterView.SortOrder = paramAnonymousInt;
            return;
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      localObject1 = (Spinner)localView.findViewById(2131231200);
      localObject2 = ArrayAdapter.createFromResource(this, 2131623968, 17367048);
      ((ArrayAdapter)localObject2).setDropDownViewResource(17367049);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      ((Spinner)localObject1).setSelection(GetEpisodesPositionFromNumEpisodes(paramSmartPlaylistEntry.NumTracks));
      ((Spinner)localObject1).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramSmartPlaylistEntry.NumTracks = SmartPlaylistEditorView.this.GetNumEpisodesFromPosition(paramAnonymousInt);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      localObject1 = (ImageView)localView.findViewById(2131231199);
      ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = SmartPlaylistEditorView.this._Template.Entries().indexOf(paramSmartPlaylistEntry);
          SmartPlaylistEditorView.this._Template.SwapItems(i, i + 1);
          SmartPlaylistEditorView.this.ReBindTemplates();
        }
      });
      if (paramInt != this._Template.size() - 1) {
        break label467;
      }
      i = 4;
      label346:
      ((ImageView)localObject1).setVisibility(i);
      localObject1 = (ImageView)localView.findViewById(2131231198);
      ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = SmartPlaylistEditorView.this._Template.Entries().indexOf(paramSmartPlaylistEntry);
          SmartPlaylistEditorView.this._Template.SwapItems(i, i - 1);
          SmartPlaylistEditorView.this.ReBindTemplates();
        }
      });
      if (paramInt != 0) {
        break label472;
      }
      i = 4;
      label384:
      ((ImageView)localObject1).setVisibility(i);
      if (paramInt % 2 != 0) {
        break label477;
      }
    }
    label416:
    label462:
    label467:
    label472:
    label477:
    for (paramInt = -12303292;; paramInt = 0)
    {
      localView.setBackgroundColor(paramInt);
      return localView;
      localObject1 = THEN_PLAY;
      break;
      SmartPlaylistTemplate.SmartPlaylistEntry localSmartPlaylistEntry = (SmartPlaylistTemplate.SmartPlaylistEntry)localIterator.next();
      if (localSmartPlaylistEntry.Category == paramSmartPlaylistEntry.Category)
      {
        j = i;
        if (localSmartPlaylistEntry.Feed == paramSmartPlaylistEntry.Feed) {
          break label145;
        }
      }
      i += 1;
      break label132;
      i = 1;
      break label222;
      i = 0;
      break label346;
      i = 0;
      break label384;
    }
  }
  
  ArrayList<SmartPlaylistTemplate.SmartPlaylistEntry> GetEntriesForAssignment()
  {
    Object localObject1;
    if (this._AllEntries == null)
    {
      localObject1 = CategoryManager.GetCategoriesForFilter();
      this._AllEntries = new ArrayList();
      localObject1 = ((CategoryList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        break label74;
      }
      localObject1 = FeedRepository.getRootFeed().SubFeeds();
      Collections.sort((List)localObject1, new FeedSorter(0));
      localObject1 = ((FeedList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        return this._AllEntries;
        label74:
        localObject2 = (FeedCategory)((Iterator)localObject1).next();
        this._AllEntries.add(new SmartPlaylistTemplate.SmartPlaylistEntry((FeedCategory)localObject2, Integer.valueOf(0), Integer.valueOf(0)));
        break;
      }
      Object localObject2 = (Feed)((Iterator)localObject1).next();
      this._AllEntries.add(new SmartPlaylistTemplate.SmartPlaylistEntry((Feed)localObject2, Integer.valueOf(0), Integer.valueOf(0)));
    }
  }
  
  int GetEpisodesPositionFromNumEpisodes(int paramInt)
  {
    String str = Integer.toString(paramInt);
    paramInt = 0;
    String[] arrayOfString = this._NumEpisodes;
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
  
  int GetNumEpisodesFromPosition(int paramInt)
  {
    return Integer.parseInt(this._NumEpisodes[paramInt]);
  }
  
  void ReBindTemplates()
  {
    int i = this._ScrollView.getScrollY();
    this._ListHolder.removeAllViews();
    BindTemplates();
    this._ScrollView.scrollTo(0, i);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
    }
    do
    {
      return;
      setContentView(2130903163);
      this._NumEpisodes = getResources().getStringArray(2131623969);
      this._ScrollView = ((ScrollView)findViewById(2131231191));
      this._ListHolder = ((LinearLayout)findViewById(2131231193));
      ImageView localImageView = (ImageView)findViewById(2131231194);
      this._CancelButton = ((Button)findViewById(2131230929));
      this._OKButton = ((Button)findViewById(2131230928));
      this._CancelButton.setOnClickListener(this._OnCancelListener);
      this._OKButton.setOnClickListener(this._OnOKListener);
      this._Template = ((SmartPlaylistTemplate)getLastNonConfigurationInstance());
      if (this._Template == null) {
        this._Template = new SmartPlaylistTemplate();
      }
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new SmartPlaylistTemplate.SmartPlaylistEntry(Integer.valueOf(0), Integer.valueOf(3));
          SmartPlaylistEditorView.this._Template.Entries().add(paramAnonymousView);
          SmartPlaylistEditorView.this.ReBindTemplates();
        }
      });
      BindTemplates();
    } while (paramBundle == null);
    int i = paramBundle.getInt("ScrollPos");
    this._ScrollView.scrollTo(0, i);
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this._Template;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("ScrollPos", this._ScrollView.getScrollY());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/SmartPlaylistEditorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */