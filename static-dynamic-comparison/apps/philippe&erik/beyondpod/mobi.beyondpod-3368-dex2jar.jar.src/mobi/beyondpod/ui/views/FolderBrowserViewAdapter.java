package mobi.beyondpod.ui.views;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class FolderBrowserViewAdapter
  extends BaseAdapter
{
  private static final String BACK_TO = CoreHelper.LoadResourceString(2131297064);
  private static final String FILES = CoreHelper.LoadResourceString(2131297062);
  private static final String IN = CoreHelper.LoadResourceString(2131297063);
  boolean _CanNavigateBack = false;
  private LayoutInflater _Inflater;
  ArrayList<File> _Items = new ArrayList();
  FolderBrowserDialog _Owner;
  private File _Root;
  private ArrayList<File> _RootMounts = new ArrayList();
  
  public FolderBrowserViewAdapter(FolderBrowserDialog paramFolderBrowserDialog)
  {
    this._Owner = paramFolderBrowserDialog;
    this._Inflater = LayoutInflater.from(paramFolderBrowserDialog);
    paramFolderBrowserDialog = Environment.getExternalStorageDirectory();
    File localFile = CoreHelper.GetOptionalStorageMount();
    if (paramFolderBrowserDialog != null) {
      this._RootMounts.add(paramFolderBrowserDialog);
    }
    if (localFile != null) {
      this._RootMounts.add(localFile);
    }
  }
  
  private void BuildViewItem(FolderListViewItem paramFolderListViewItem, File paramFile, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (IsParentOf(paramFile, this._Root))
    {
      paramFolderListViewItem.PrimaryText.setText(BACK_TO + " " + paramFile.getName());
      paramFolderListViewItem.SecondaryText.setVisibility(8);
      paramFolderListViewItem.SelectFolderBtn.setVisibility(8);
      paramFolderListViewItem.FolderIcon.setImageResource(2130837845);
      return;
    }
    paramFolderListViewItem.PrimaryText.setText(paramFile.getName());
    paramViewGroup = FeedRepository.GetVirtualFeedByDownloadPath(paramFile.getPath());
    int i = 0;
    Object localObject;
    if (paramViewGroup != null)
    {
      paramFolderListViewItem.SecondaryText.setText(IN + " " + paramViewGroup.getCategories().getPrimary().Name());
      localObject = paramFolderListViewItem.SecondaryText;
      if ((paramViewGroup == null) && (i <= 0)) {
        break label263;
      }
      i = 0;
      label163:
      ((TextView)localObject).setVisibility(i);
      localObject = paramFolderListViewItem.SelectFolderBtn;
      if (paramViewGroup != null) {
        break label270;
      }
    }
    label263:
    label270:
    for (i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      paramFolderListViewItem.FolderIcon.setImageResource(2130837833);
      paramFolderListViewItem.SelectFolderBtn.setOnClickListener(this._Owner);
      paramFolderListViewItem.SelectFolderBtn.setTag(paramFile);
      return;
      i = GetNumberOfFiles(paramFile);
      paramFolderListViewItem.SecondaryText.setText(i + " " + FILES);
      break;
      i = 8;
      break label163;
    }
  }
  
  private int GetNumberOfFiles(File paramFile)
  {
    if (paramFile == null) {
      return 0;
    }
    paramFile.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return (paramAnonymousFile.isFile()) && (!paramAnonymousFile.getName().startsWith("."));
      }
    }).length;
  }
  
  private boolean IsParentOf(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    while ((paramFile2.getPath().length() <= paramFile1.getPath().length()) || (!paramFile2.getPath().startsWith(paramFile1.getPath()))) {
      return false;
    }
    return true;
  }
  
  public boolean CanGoUp()
  {
    return this._CanNavigateBack;
  }
  
  public void Clear()
  {
    this._Items.clear();
  }
  
  File GetParentDirectory()
  {
    return new File(this._Root.getPath().replace(this._Root.getName(), ""));
  }
  
  public void Refresh()
  {
    this._CanNavigateBack = false;
    this._Items.clear();
    if ((this._Root == null) && (this._RootMounts.size() > 1))
    {
      this._Items.addAll(this._RootMounts);
      notifyDataSetChanged();
      return;
    }
    if (this._Root == null) {
      this._Root = ((File)this._RootMounts.get(0));
    }
    for (;;)
    {
      try
      {
        arrayOfFile = this._Root.listFiles(new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            return (paramAnonymousFile.isDirectory()) && (!paramAnonymousFile.isHidden()) && (!paramAnonymousFile.getName().startsWith("com.android.")) && (!paramAnonymousFile.getName().startsWith("com.google.")) && (!paramAnonymousFile.getName().startsWith("."));
          }
        });
        int j = arrayOfFile.length;
        i = 0;
        if (i < j) {
          continue;
        }
      }
      catch (Exception localException)
      {
        File[] arrayOfFile;
        int i;
        File localFile;
        continue;
      }
      Collections.sort(this._Items, new FileNameComparator(null));
      if (this._CanNavigateBack) {
        this._Items.add(0, GetParentDirectory());
      }
      notifyDataSetChanged();
      return;
      this._CanNavigateBack = true;
      continue;
      localFile = arrayOfFile[i];
      this._Items.add(localFile);
      i += 1;
    }
  }
  
  public void SetRoot(File paramFile)
  {
    File localFile1 = paramFile;
    if (paramFile != null)
    {
      if ((this._RootMounts.size() != 1) || (!paramFile.equals(this._RootMounts.get(0)))) {
        break label44;
      }
      localFile1 = null;
    }
    for (;;)
    {
      this._Root = localFile1;
      Refresh();
      return;
      label44:
      Iterator localIterator = this._RootMounts.iterator();
      File localFile2;
      do
      {
        localFile1 = paramFile;
        if (!localIterator.hasNext()) {
          break;
        }
        localFile2 = (File)localIterator.next();
        localFile1 = paramFile;
        if (paramFile.equals(localFile2)) {
          break;
        }
      } while (!IsParentOf(paramFile, localFile2));
      localFile1 = null;
    }
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  public File getFileAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return (File)localObject;
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < getCount()) {
      return this._Items.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((File)this._Items.get(paramInt) == null) {
      return -1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    File localFile = (File)this._Items.get(paramInt);
    if (localFile != null)
    {
      if (paramView == null) {
        localView = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this._Inflater.inflate(2130903127, null);
          localView = paramView;
          localFolderListViewItem = new FolderListViewItem(null);
          localView = paramView;
          localFolderListViewItem.PrimaryText = ((TextView)paramView.findViewById(2131231075));
          localView = paramView;
          localFolderListViewItem.SecondaryText = ((TextView)paramView.findViewById(2131231076));
          localView = paramView;
          localFolderListViewItem.SelectFolderBtn = paramView.findViewById(2131231077);
          localView = paramView;
          localFolderListViewItem.FolderIcon = ((ImageView)paramView.findViewById(2131231074));
          localView = paramView;
          paramView.setTag(localFolderListViewItem);
          localView = paramView;
          BuildViewItem(localFolderListViewItem, localFile, paramViewGroup);
          return paramView;
        }
        catch (Exception paramView)
        {
          FolderListViewItem localFolderListViewItem;
          paramView.printStackTrace();
        }
        localView = paramView;
        localFolderListViewItem = (FolderListViewItem)paramView.getTag();
      }
    }
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramView;
      paramView = this._Inflater.inflate(2130903173, null);
      return paramView;
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  private static class FileNameComparator
    implements Comparator<File>
  {
    public int compare(File paramFile1, File paramFile2)
    {
      return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
    }
  }
  
  private static class FolderListViewItem
  {
    ImageView FolderIcon;
    TextView PrimaryText;
    TextView SecondaryText;
    View SelectFolderBtn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FolderBrowserViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */