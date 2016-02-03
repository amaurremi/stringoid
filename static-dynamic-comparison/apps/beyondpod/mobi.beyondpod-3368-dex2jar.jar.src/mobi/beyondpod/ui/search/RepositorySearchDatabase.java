package mobi.beyondpod.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.FeedSorter;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FeedRepository.FeedSearchArguments;

public class RepositorySearchDatabase
{
  private String EPISODES = "Episodes";
  private String IN = "In";
  
  public RepositorySearchDatabase(Context paramContext)
  {
    this.IN = paramContext.getResources().getString(2131297063);
    this.EPISODES = paramContext.getResources().getString(2131297131);
  }
  
  private Cursor query(String paramString, String[] paramArrayOfString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      paramString = null;
    }
    MatrixCursor localMatrixCursor;
    label251:
    label304:
    label322:
    label471:
    label478:
    label485:
    label491:
    label600:
    label727:
    do
    {
      return paramString;
      Object localObject1 = new FeedRepository.FeedSearchArguments(paramString);
      ((FeedRepository.FeedSearchArguments)localObject1).LeafFeedsOnly = false;
      paramString = FeedRepository.SearchForFeeds(FeedRepository.getRootFeed(), (FeedRepository.FeedSearchArguments)localObject1);
      Object localObject3 = FeedRepository.SearchForTracks(null, (FeedRepository.FeedSearchArguments)localObject1);
      if ((paramString.SubFeeds().size() == 0) && (((TrackList)localObject3).size() == 0)) {
        return null;
      }
      Collections.sort(paramString.SubFeeds(), new FeedSorter(Configuration.getFeedsSortOrder()));
      Collections.sort((List)localObject3, new TrackSorter(Configuration.getPodcastsSortOrder()));
      localMatrixCursor = new MatrixCursor(paramArrayOfString, paramString.SubFeeds().size() + ((TrackList)localObject3).size());
      Iterator localIterator = paramString.SubFeeds().iterator();
      int i;
      if (!localIterator.hasNext())
      {
        localObject1 = ((TrackList)localObject3).iterator();
        if (!((Iterator)localObject1).hasNext())
        {
          if (localMatrixCursor != null) {
            break label727;
          }
          return null;
        }
      }
      else
      {
        Feed localFeed = (Feed)localIterator.next();
        ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(localFeed.getName());
        paramString = localFeed.getCategories().getPrimary();
        localObject1 = localFeed.getCategories().getSecondary();
        int j;
        if ((paramString.equals(CategoryManager.Unassigned)) && (((FeedCategory)localObject1).equals(CategoryManager.Unassigned)))
        {
          paramString = paramString.Name();
          if (localFeed.Tracks().size() <= 0) {
            break label471;
          }
          localObject1 = " - " + localFeed.Tracks().size() + " " + this.EPISODES + ", ";
          if (localFeed.getLastModifiedDate() == null) {
            break label478;
          }
          localObject2 = DateTime.FormatDateTime(localFeed.getLastModifiedDate());
          localArrayList.add(localObject2 + (String)localObject1 + this.IN + " " + paramString);
          i = 2130837785;
          j = localFeed.getType();
          if (j != 1) {
            break label491;
          }
          if (!localFeed.IsSubFeed()) {
            break label485;
          }
          i = 2130838097;
        }
        for (;;)
        {
          localArrayList.add(Integer.toString(i));
          localArrayList.add(localFeed.ID().toString());
          localMatrixCursor.addRow(localArrayList);
          break;
          if (paramString.equals(CategoryManager.Unassigned))
          {
            paramString = ((FeedCategory)localObject1).Name();
            break label251;
          }
          if (((FeedCategory)localObject1).equals(CategoryManager.Unassigned))
          {
            paramString = paramString.Name();
            break label251;
          }
          paramString = paramString.Name();
          break label251;
          localObject1 = " - ";
          break label304;
          localObject2 = "";
          break label322;
          i = 2130837824;
          continue;
          if (j == 4) {
            i = 2130837789;
          } else if ((j == 2) || (j == 3)) {
            i = 2130837787;
          }
        }
      }
      Object localObject2 = (Track)((Iterator)localObject1).next();
      localObject3 = new ArrayList(paramArrayOfString.length);
      ((ArrayList)localObject3).add(Integer.valueOf(0));
      ((ArrayList)localObject3).add(((Track)localObject2).DisplayName());
      if (((Track)localObject2).getLastModifiedDate() != null)
      {
        paramString = DateTime.FormatDateTime(((Track)localObject2).getLastModifiedDate()) + " - ";
        ((ArrayList)localObject3).add(paramString + ((Track)localObject2).getParentFeed().getName());
        i = 2130838071;
        switch (((Track)localObject2).ContentType())
        {
        }
      }
      for (;;)
      {
        ((ArrayList)localObject3).add(Integer.toString(i));
        ((ArrayList)localObject3).add(((Track)localObject2).TrackPath());
        localMatrixCursor.addRow((Iterable)localObject3);
        break;
        paramString = "";
        break label600;
        i = 2130838072;
        continue;
        i = 2130838076;
        continue;
        i = 2130838074;
      }
      paramString = localMatrixCursor;
    } while (localMatrixCursor.moveToFirst());
    localMatrixCursor.close();
    return null;
  }
  
  public Cursor getFeedTrackMatches(String paramString, String[] paramArrayOfString)
  {
    return query(paramString, paramArrayOfString);
  }
  
  public Cursor getWord(String paramString, String[] paramArrayOfString)
  {
    return query(paramString, paramArrayOfString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/search/RepositorySearchDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */