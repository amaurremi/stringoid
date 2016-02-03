package com.mobisystems.pdf.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.mobisystems.pdf.PDFDocument;

public class DocumentAdapter
  extends FragmentStatePagerAdapter
{
  protected PageFragment _currentPageFragment;
  PDFDocument _document;
  DocumentPager _pager;
  
  public DocumentAdapter(FragmentManager paramFragmentManager, PDFDocument paramPDFDocument)
  {
    super(paramFragmentManager);
    this._document = paramPDFDocument;
  }
  
  public int getCount()
  {
    return this._document.pageCount();
  }
  
  public PageFragment getCurrentPageFragment()
  {
    return this._currentPageFragment;
  }
  
  public Fragment getItem(int paramInt)
  {
    return PageFragment.create(paramInt);
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    if (paramObject == this._currentPageFragment) {}
    do
    {
      return;
      if (this._currentPageFragment != null) {
        this._currentPageFragment.onPageDeactivate();
      }
      this._currentPageFragment = ((PageFragment)paramObject);
      this._currentPageFragment.onPageActivate();
    } while (this._pager == null);
    this._pager.onPageChanged(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/DocumentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */