package com.mobisystems.mobiscanner.controller;

import android.content.Intent;
import android.os.Bundle;
import com.mobisystems.mobiscanner.model.DocumentModel.DocListSortBy;
import com.mobisystems.mobiscanner.model.DocumentModel.SortOrder;

public class t
{
  private DocumentModel.SortOrder aCl = DocumentModel.SortOrder.aIQ;
  private String aCv = "";
  private DocumentModel.DocListSortBy mSortBy = DocumentModel.DocListSortBy.aIL;
  
  public t() {}
  
  public t(Intent paramIntent)
  {
    a(DocumentModel.DocListSortBy.values()[paramIntent.getIntExtra("SORT_BY", 0)]);
    a(DocumentModel.SortOrder.values()[paramIntent.getIntExtra("SORT_ORDER", 0)]);
    setFilterText(paramIntent.getStringExtra("FILTER_TEXT"));
  }
  
  public t(Bundle paramBundle)
  {
    a(DocumentModel.DocListSortBy.values()[paramBundle.getInt("SORT_BY")]);
    a(DocumentModel.SortOrder.values()[paramBundle.getInt("SORT_ORDER")]);
    setFilterText(paramBundle.getString("FILTER_TEXT"));
  }
  
  public t(t paramt)
  {
    a(paramt.Gd());
    a(paramt.Gc());
    setFilterText(paramt.FJ());
  }
  
  public String FJ()
  {
    return this.aCv;
  }
  
  public DocumentModel.SortOrder Gc()
  {
    return this.aCl;
  }
  
  public DocumentModel.DocListSortBy Gd()
  {
    return this.mSortBy;
  }
  
  public void a(DocumentModel.DocListSortBy paramDocListSortBy)
  {
    this.mSortBy = paramDocListSortBy;
  }
  
  public void a(DocumentModel.SortOrder paramSortOrder)
  {
    this.aCl = paramSortOrder;
  }
  
  public void f(Intent paramIntent)
  {
    paramIntent.putExtra("SORT_BY", this.mSortBy.ordinal());
    paramIntent.putExtra("SORT_ORDER", this.aCl.ordinal());
    paramIntent.putExtra("FILTER_TEXT", this.aCv);
  }
  
  public void p(Bundle paramBundle)
  {
    paramBundle.putInt("SORT_BY", this.mSortBy.ordinal());
    paramBundle.putInt("SORT_ORDER", this.aCl.ordinal());
    paramBundle.putString("FILTER_TEXT", this.aCv);
  }
  
  public void setFilterText(String paramString)
  {
    this.aCv = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */