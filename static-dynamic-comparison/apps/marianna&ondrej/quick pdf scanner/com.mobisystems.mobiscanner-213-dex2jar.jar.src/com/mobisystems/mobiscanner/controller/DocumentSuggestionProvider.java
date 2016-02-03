package com.mobisystems.mobiscanner.controller;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.DocumentModel.DocListSortBy;
import com.mobisystems.mobiscanner.model.DocumentModel.SortOrder;

public class DocumentSuggestionProvider
  extends ContentProvider
{
  private DocumentModel aBL;
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return "vnd.android.cursor.item/vnd.com.mobisystems.mobiscanner.documents";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    this.aBL = new DocumentModel();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {}
    for (paramUri = paramArrayOfString2[0];; paramUri = "") {
      return this.aBL.b(paramUri.trim(), DocumentModel.DocListSortBy.aIL, DocumentModel.SortOrder.aIQ, 0, -1);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/DocumentSuggestionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */