package com.actionbarsherlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.View;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class MenuInflater
{
  private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = { Context.class };
  private static final String LOG_TAG = "MenuInflater";
  private static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  private final Object[] mActionProviderConstructorArguments;
  private final Object[] mActionViewConstructorArguments;
  private Context mContext;
  private Object mRealOwner;
  
  public MenuInflater(Context paramContext)
  {
    this.mContext = paramContext;
    this.mRealOwner = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  public MenuInflater(Context paramContext, Object paramObject)
  {
    this.mContext = paramContext;
    this.mRealOwner = paramObject;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label49:
    int k;
    int j;
    if (i == 2)
    {
      paramMenu = paramXmlPullParser.getName();
      if (paramMenu.equals("menu"))
      {
        i = paramXmlPullParser.next();
        paramMenu = null;
        int m = 0;
        k = i;
        j = 0;
        i = m;
        label65:
        if (j != 0) {
          return;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label65;
        throw new RuntimeException("Expecting menu, got " + paramMenu);
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label49;
        if (i == 0)
        {
          String str = paramXmlPullParser.getName();
          if (str.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
          }
          else if (str.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
          }
          else if (str.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
          }
          else
          {
            paramMenu = str;
            i = 1;
            continue;
            str = paramXmlPullParser.getName();
            if ((i != 0) && (str.equals(paramMenu)))
            {
              paramMenu = null;
              i = 0;
            }
            else if (str.equals("group"))
            {
              localMenuState.resetGroup();
            }
            else if (str.equals("item"))
            {
              if (!localMenuState.hasAddedItem()) {
                if ((localMenuState.itemActionProvider != null) && (localMenuState.itemActionProvider.hasSubMenu())) {
                  localMenuState.addSubMenuItem();
                } else {
                  localMenuState.addItem();
                }
              }
            }
            else if (str.equals("menu"))
            {
              j = 1;
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 54	com/actionbarsherlock/view/MenuInflater:mContext	Landroid/content/Context;
    //   12: invokevirtual 156	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   15: iload_1
    //   16: invokevirtual 162	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   19: astore 6
    //   21: aload 6
    //   23: astore 4
    //   25: aload 6
    //   27: astore_3
    //   28: aload 6
    //   30: astore 5
    //   32: aload_0
    //   33: aload 6
    //   35: aload 6
    //   37: invokestatic 168	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   40: aload_2
    //   41: invokespecial 125	com/actionbarsherlock/view/MenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/actionbarsherlock/view/Menu;)V
    //   44: aload 6
    //   46: ifnull +10 -> 56
    //   49: aload 6
    //   51: invokeinterface 173 1 0
    //   56: return
    //   57: astore_2
    //   58: aload 4
    //   60: astore_3
    //   61: new 175	android/view/InflateException
    //   64: dup
    //   65: ldc -79
    //   67: aload_2
    //   68: invokespecial 180	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: athrow
    //   72: astore_2
    //   73: aload_3
    //   74: ifnull +9 -> 83
    //   77: aload_3
    //   78: invokeinterface 173 1 0
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: aload 5
    //   88: astore_3
    //   89: new 175	android/view/InflateException
    //   92: dup
    //   93: ldc -79
    //   95: aload_2
    //   96: invokespecial 180	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	MenuInflater
    //   0	100	1	paramInt	int
    //   0	100	2	paramMenu	Menu
    //   1	88	3	localObject1	Object
    //   6	53	4	localObject2	Object
    //   3	84	5	localObject3	Object
    //   19	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   8	21	57	org/xmlpull/v1/XmlPullParserException
    //   32	44	57	org/xmlpull/v1/XmlPullParserException
    //   8	21	72	finally
    //   32	44	72	finally
    //   61	72	72	finally
    //   89	100	72	finally
    //   8	21	85	java/io/IOException
    //   32	44	85	java/io/IOException
  }
  
  private static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      this.mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    private ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      this.menu = paramMenu;
      resetGroup();
    }
    
    private char getShortcut(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = MenuInflater.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        Log.w("MenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
      }
      return null;
    }
    
    private void setItem(MenuItem paramMenuItem)
    {
      int i = 1;
      MenuItem localMenuItem = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      if (this.itemCheckable >= 1) {}
      for (boolean bool = true;; bool = false)
      {
        localMenuItem.setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
        if (this.itemShowAsAction >= 0) {
          paramMenuItem.setShowAsAction(this.itemShowAsAction);
        }
        if (this.itemListenerMethodName == null) {
          break label164;
        }
        if (!MenuInflater.this.mContext.isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new MenuInflater.InflatedOnMenuItemClickListener(MenuInflater.this.mRealOwner, this.itemListenerMethodName));
      label164:
      if (this.itemCheckable >= 2)
      {
        if ((paramMenuItem instanceof MenuItemImpl)) {
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      else
      {
        if (this.itemActionViewClassName == null) {
          break label292;
        }
        paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
      }
      for (;;)
      {
        if (this.itemActionViewLayout > 0)
        {
          if (i != 0) {
            break label281;
          }
          paramMenuItem.setActionView(this.itemActionViewLayout);
        }
        for (;;)
        {
          if (this.itemActionProvider != null) {
            paramMenuItem.setActionProvider(this.itemActionProvider);
          }
          return;
          this.menu.setGroupCheckable(this.groupId, true, true);
          break;
          label281:
          Log.w("MenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
        label292:
        i = 0;
      }
    }
    
    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuGroup);
      this.groupId = paramAttributeSet.getResourceId(1, 0);
      this.groupCategory = paramAttributeSet.getInt(3, 0);
      this.groupOrder = paramAttributeSet.getInt(4, 0);
      this.groupCheckable = paramAttributeSet.getInt(5, 0);
      this.groupVisible = paramAttributeSet.getBoolean(2, true);
      this.groupEnabled = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      int j = 1;
      TypedArray localTypedArray = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuItem);
      this.itemId = localTypedArray.getResourceId(2, 0);
      this.itemCategoryOrder = (localTypedArray.getInt(5, this.groupCategory) & 0xFFFF0000 | localTypedArray.getInt(6, this.groupOrder) & 0xFFFF);
      this.itemTitle = localTypedArray.getText(7);
      this.itemTitleCondensed = localTypedArray.getText(8);
      this.itemIconResId = localTypedArray.getResourceId(0, 0);
      this.itemAlphabeticShortcut = getShortcut(localTypedArray.getString(9));
      this.itemNumericShortcut = getShortcut(localTypedArray.getString(10));
      int i;
      if (localTypedArray.hasValue(11)) {
        if (localTypedArray.getBoolean(11, false))
        {
          i = 1;
          this.itemCheckable = i;
          label154:
          this.itemChecked = localTypedArray.getBoolean(3, false);
          this.itemVisible = localTypedArray.getBoolean(4, this.groupVisible);
          this.itemEnabled = localTypedArray.getBoolean(1, this.groupEnabled);
          paramAttributeSet = new TypedValue();
          localTypedArray.getValue(13, paramAttributeSet);
          if (paramAttributeSet.type != 17) {
            break label407;
          }
          i = paramAttributeSet.data;
          label224:
          this.itemShowAsAction = i;
          this.itemListenerMethodName = localTypedArray.getString(12);
          this.itemActionViewLayout = localTypedArray.getResourceId(14, 0);
          paramAttributeSet = new TypedValue();
          localTypedArray.getValue(15, paramAttributeSet);
          if (paramAttributeSet.type != 3) {
            break label412;
          }
          paramAttributeSet = paramAttributeSet.string.toString();
          label285:
          this.itemActionViewClassName = paramAttributeSet;
          paramAttributeSet = new TypedValue();
          localTypedArray.getValue(16, paramAttributeSet);
          if (paramAttributeSet.type != 3) {
            break label417;
          }
          paramAttributeSet = paramAttributeSet.string.toString();
          label323:
          this.itemActionProviderClassName = paramAttributeSet;
          if (this.itemActionProviderClassName == null) {
            break label422;
          }
          i = j;
          label337:
          if ((i == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null)) {
            break label427;
          }
        }
      }
      for (this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments));; this.itemActionProvider = null)
      {
        localTypedArray.recycle();
        this.itemAdded = false;
        return;
        i = 0;
        break;
        this.itemCheckable = this.groupCheckable;
        break label154;
        label407:
        i = -1;
        break label224;
        label412:
        paramAttributeSet = null;
        break label285;
        label417:
        paramAttributeSet = null;
        break label323;
        label422:
        i = 0;
        break label337;
        label427:
        if (i != 0) {
          Log.w("MenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        }
      }
    }
    
    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/view/MenuInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */