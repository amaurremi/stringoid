package com.mobisystems.pdf.ui;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.image.f;
import com.mobisystems.mobiscanner.view.DragAndDropGridViewV3;
import com.mobisystems.mobiscanner.view.DragAndDropGridViewV3.b;
import com.mobisystems.pdf.PDFDocument;
import java.util.HashSet;
import java.util.Iterator;

public class PDFImportFragment
  extends Fragment
  implements AdapterView.OnItemClickListener
{
  private PDFImportActivity mActivity;
  HashSet<Integer> mCheckedIds = new HashSet();
  private PDFDocument mDoc;
  private DragAndDropGridViewV3 mGrid;
  private final c mLog = new c(this);
  private int mPageCount = -1;
  
  public int[] getCheckedItems()
  {
    int[] arrayOfInt = new int[this.mCheckedIds.size()];
    Iterator localIterator = this.mCheckedIds.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mActivity.selectedCountChanged(this.mCheckedIds.size());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof PDFImportActivity))
    {
      this.mActivity = ((PDFImportActivity)paramActivity);
      this.mActivity.selectedCountChanged(this.mCheckedIds.size());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public void onCreateActionMode()
  {
    redrawList();
    this.mActivity.selectedCountChanged(this.mCheckedIds.size());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903115, paramViewGroup, false);
  }
  
  public void onDestroyActionMode()
  {
    selectAll();
  }
  
  public void onDetach()
  {
    this.mActivity = null;
    super.onDetach();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mActivity.isActionMode())
    {
      boolean bool = this.mCheckedIds.contains(Integer.valueOf((int)paramLong));
      if (bool)
      {
        this.mCheckedIds.remove(Integer.valueOf((int)paramLong));
        paramAdapterView = paramView.findViewById(2131165547);
        if (!bool) {
          break label96;
        }
      }
      label96:
      for (paramInt = 8;; paramInt = 0)
      {
        paramAdapterView.setVisibility(paramInt);
        this.mActivity.selectedCountChanged(this.mCheckedIds.size());
        return;
        this.mCheckedIds.add(Integer.valueOf((int)paramLong));
        break;
      }
    }
    this.mCheckedIds.clear();
    this.mCheckedIds.add(Integer.valueOf((int)paramLong));
    this.mActivity.startActionMode(this.mActivity);
  }
  
  public void onPDFDocLoaded(PDFDocument paramPDFDocument)
  {
    this.mDoc = paramPDFDocument;
    this.mPageCount = this.mDoc.pageCount();
    selectAll();
    this.mGrid = ((DragAndDropGridViewV3)getView().findViewById(2131165463));
    this.mGrid.a(new PDFImportAdapter(this.mDoc));
    this.mGrid.bw(false);
    this.mGrid.setOnItemClickListener(this);
  }
  
  public void redrawList()
  {
    if (this.mGrid != null) {
      this.mGrid.invalidateViews();
    }
  }
  
  public void selectAll()
  {
    int i = 0;
    while (i < this.mPageCount)
    {
      this.mCheckedIds.add(Integer.valueOf(i));
      i += 1;
    }
    if (this.mActivity != null) {
      this.mActivity.selectedCountChanged(this.mPageCount);
    }
    redrawList();
  }
  
  public void selectInverse()
  {
    int i = 0;
    if (i < this.mPageCount)
    {
      if (this.mCheckedIds.contains(Integer.valueOf(i))) {
        this.mCheckedIds.remove(Integer.valueOf(i));
      }
      for (;;)
      {
        i += 1;
        break;
        this.mCheckedIds.add(Integer.valueOf(i));
      }
    }
    this.mActivity.selectedCountChanged(this.mCheckedIds.size());
    redrawList();
  }
  
  private class PDFImportAdapter
    implements DragAndDropGridViewV3.b
  {
    PDFDocument mDocument;
    
    public PDFImportAdapter(PDFDocument paramPDFDocument)
    {
      this.mDocument = paramPDFDocument;
    }
    
    public boolean areAllItemsEnabled()
    {
      return true;
    }
    
    public int getCount()
    {
      return this.mDocument.pageCount();
    }
    
    public Bitmap getDragBitmap(int paramInt)
    {
      return null;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      long l1 = System.nanoTime();
      PDFImportFragment.this.mLog.dl("getView pos= " + paramInt + " ; convertView = " + paramView + "; startTime = " + l1);
      View localView = paramView;
      if (paramView == null) {
        localView = PDFImportFragment.this.mActivity.getLayoutInflater().inflate(2130903155, paramViewGroup, false);
      }
      paramView = (ImageView)localView.findViewById(2131165225);
      paramView = (ViewGroup)localView.findViewById(2131165545);
      if (paramView != null) {
        PDFImportFragment.this.mActivity.getPDFImportThumbnailLoader().a(paramInt, 0L, paramView);
      }
      ((TextView)localView.findViewById(2131165549)).setText(String.valueOf(paramInt + 1));
      paramView = localView.findViewById(2131165547);
      boolean bool1 = PDFImportFragment.this.mCheckedIds.contains(Integer.valueOf(paramInt));
      boolean bool2 = PDFImportFragment.this.mActivity.isActionMode();
      if ((bool1) && (bool2)) {}
      for (paramInt = 0;; paramInt = 8)
      {
        paramView.setVisibility(paramInt);
        long l2 = System.nanoTime();
        PDFImportFragment.this.mLog.dl("getView end = " + l2 + "; total = " + (l2 - l1));
        return localView;
      }
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public boolean isEnabled(int paramInt)
    {
      return true;
    }
    
    public void moveItem(int paramInt1, int paramInt2) {}
    
    public void performLongClick(int paramInt) {}
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/PDFImportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */