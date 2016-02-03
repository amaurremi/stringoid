package com.quoord.tapatalkpro.util;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NewForumColor;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class ThemeUtil {
    public static final int AQUAMARINE = 2;
    public static final int BLUE = 1;
    public static final int BROWN = 6;
    public static final String DARK_POSTFIX = "_dark";
    public static final int DEEPBLUE = 7;
    public static final int DEEPGREEN = 8;
    public static final int GREEN = 9;
    public static final int GREENBLUE = 10;
    public static final int ORANGE = 0;
    public static final String PACKAGE_NAME = "com.quoord.tapatalkpro.activity";
    public static final int PINK = 5;
    public static final int PURLPE = 3;
    public static final int RED = 11;
    public static final int YELLOW = 4;

    public static int getActionModeDrawableId(String paramString, Context paramContext) {
        Object localObject = Prefs.get(paramContext);
        int i = 0;
        try {
            int j = ((SharedPreferences) localObject).getInt("ics_custom_select_position", 0);
            if (paramContext.getResources().getBoolean(2131558411)) {
                i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
            } else if (j == 0) {
                if (!paramContext.getResources().getBoolean(2131558401)) {
                    Resources localResources = paramContext.getResources();
                    if (SettingsFragment.isLightTheme(paramContext)) {
                    }
                    for (localObject = paramString; ; localObject = paramString + "_dark") {
                        j = localResources.getIdentifier((String) localObject, "drawable", "com.quoord.tapatalkpro.activity");
                        i = j;
                        if (j > 0) {
                            break;
                        }
                        i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
                        break;
                    }
                }
                if (((SharedPreferences) localObject).contains("primary_color")) {
                    i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
                }
            } else {
                i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
            }
        } catch (Exception paramString) {
            paramString.printStackTrace();
            return 0;
        }
        return i;
    }

    public static int getAuthorColor(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        int i = localSharedPreferences.getInt("ics_custom_colorstyle", 0);
        if (i == 0) {
            if ((paramContext.getResources().getBoolean(2131558401)) && (localSharedPreferences.contains("primary_color"))) {
                return Color.parseColor("#" + localSharedPreferences.getString("primary_color", ""));
            }
            return paramContext.getResources().getColor(2131165232);
        }
        return i;
    }

    public static Drawable getBgDrawableByPicNameForList(String paramString, Context paramContext, boolean paramBoolean) {
        if (paramBoolean) {
            paramString = paramString + "_bottom";
        }
        for (; ; ) {
            return getDrawableByPicName(paramString, paramContext);
        }
    }

    private static Boolean getColor(Context paramContext) {
        if (SettingsFragment.getColorMode(paramContext).booleanValue()) {
        }
        for (boolean bool = false; ; bool = true) {
            return Boolean.valueOf(bool);
        }
    }

    public static void getCustomActionBarBackground(Activity paramActivity, int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                paramActivity.getActionBar().setBackgroundDrawable(null);
                return;
            case 1:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838922));
                return;
            case 2:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838923));
                return;
            case 3:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838943));
                return;
            case 4:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838926));
                return;
            case 5:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838925));
                return;
            case 6:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838933));
                return;
            case 7:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838934));
                return;
            case 8:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838935));
                return;
            case 9:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838937));
                return;
            case 10:
                paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838938));
                return;
        }
        paramActivity.getActionBar().setBackgroundDrawable(paramActivity.getResources().getDrawable(2130838921));
    }

    public static void getDateColor(Context paramContext, TextView paramTextView) {
        if (getColor(paramContext).booleanValue()) {
            switch (getIndex(paramContext)) {
                default:
                    return;
                case 0:
                    if ((paramContext instanceof ForumActivityStatus)) {
                        ForumStatus localForumStatus = ((ForumActivityStatus) paramContext).getForumStatus();
                        if ((localForumStatus != null) && (localForumStatus.forumColor.getTextColor() != null)) {
                            paramTextView.setTextColor(Color.parseColor(localForumStatus.forumColor.getTextColor()));
                            return;
                        }
                        paramTextView.setTextColor(paramContext.getResources().getColor(2131165312));
                        return;
                    }
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165312));
                    return;
                case 1:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165369));
                    return;
                case 9:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165388));
                    return;
                case 3:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165406));
                    return;
                case 4:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165379));
                    return;
                case 5:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165360));
                    return;
                case 6:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165397));
                    return;
                case 7:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165442));
                    return;
                case 8:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165433));
                    return;
                case 2:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165424));
                    return;
                case 10:
                    paramTextView.setTextColor(paramContext.getResources().getColor(2131165415));
                    return;
            }
            paramTextView.setTextColor(paramContext.getResources().getColor(2131165451));
            return;
        }
        switch (getIndex(paramContext)) {
            default:
                return;
            case 0:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165312));
                return;
            case 1:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165370));
                return;
            case 9:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165390));
                return;
            case 3:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165408));
                return;
            case 4:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165381));
                return;
            case 5:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165361));
                return;
            case 6:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165399));
                return;
            case 7:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165444));
                return;
            case 8:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165435));
                return;
            case 2:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165426));
                return;
            case 10:
                paramTextView.setTextColor(paramContext.getResources().getColor(2131165417));
                return;
        }
        paramTextView.setTextColor(paramContext.getResources().getColor(2131165453));
    }

    public static int getDialogDrawableId(String paramString, Context paramContext) {
        Resources localResources = paramContext.getResources();
        if (SettingsFragment.isLightTheme(paramContext)) {
        }
        for (String str = paramString; ; str = paramString + "_dark") {
            int j = localResources.getIdentifier(str, "drawable", "com.quoord.tapatalkpro.activity");
            int i = j;
            if (j <= 0) {
                i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
            }
            return i;
        }
    }

    public static Drawable getDrawableByPicName(String paramString, Context paramContext) {
        try {
            paramString = paramContext.getResources().getDrawable(getDrawableIDByPicName(paramString, paramContext));
            return paramString;
        } catch (Exception paramString) {
        }
        return null;
    }

    public static int getDrawableIDByPicName(String paramString, Context paramContext) {
        Resources localResources = paramContext.getResources();
        if (SettingsFragment.isLightTheme(paramContext)) {
        }
        for (String str = paramString; ; str = paramString + "_dark") {
            int j = localResources.getIdentifier(str, "drawable", "com.quoord.tapatalkpro.activity");
            int i = j;
            if (j <= 0) {
                i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
            }
            return i;
        }
    }

    public static int getDrawableIdByPicName(String paramString, Context paramContext) {
        Object localObject = Prefs.get(paramContext);
        int i;
        try {
            i = ((SharedPreferences) localObject).getInt("ics_custom_select_position", 0);
            if (paramContext.getResources().getBoolean(2131558411)) {
                i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
            } else if (i == 0) {
                if (!paramContext.getResources().getBoolean(2131558401)) {
                    Resources localResources = paramContext.getResources();
                    if (!SettingsFragment.isLightTheme(paramContext)) {
                    }
                    for (localObject = paramString; ; localObject = paramString + "_dark") {
                        int j = localResources.getIdentifier((String) localObject, "drawable", "com.quoord.tapatalkpro.activity");
                        i = j;
                        if (j > 0) {
                            break;
                        }
                        i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
                        break;
                    }
                }
                if (((SharedPreferences) localObject).contains("primary_color")) {
                    i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
                } else {
                    localObject = paramContext.getResources();
                    if (SettingsFragment.isLightTheme(paramContext)) {
                    }
                    for (; ; ) {
                        i = ((Resources) localObject).getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
                        break;
                        paramString = paramString + "_dark";
                    }
                }
            } else {
                i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
            }
        } catch (Exception paramString) {
            paramString.printStackTrace();
            return 0;
        }
        return i;
    }

    public static int getDrawableIdByPicNameDark(String paramString, Context paramContext) {
        if (Prefs.get(paramContext).getInt("ics_custom_select_position", 0) == 0) {
        }
        int i;
        try {
            Resources localResources = paramContext.getResources();
            if (SettingsFragment.isLightTheme(paramContext)) {
            }
            for (String str = paramString; ; str = paramString + "_dark") {
                int j = localResources.getIdentifier(str, "drawable", "com.quoord.tapatalkpro.activity");
                i = j;
                if (j > 0) {
                    break;
                }
                i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
                break;
            }
            i = paramContext.getResources().getIdentifier(paramString + "_dark", "drawable", "com.quoord.tapatalkpro.activity");
        } catch (Exception paramString) {
            paramString.printStackTrace();
            return 0;
        }
        return i;
    }

    public static void getHighlightColor(Activity paramActivity, View paramView) {
        if (getColor(paramActivity).booleanValue()) {
            switch (getIndex(paramActivity)) {
                default:
                    return;
                case 0:
                    if ((paramActivity instanceof ForumActivityStatus)) {
                        ForumStatus localForumStatus = ((ForumActivityStatus) paramActivity).getForumStatus();
                        if ((localForumStatus != null) && (localForumStatus.forumColor.getHighLightColor() != null)) {
                            paramView.setBackgroundColor(Color.parseColor(localForumStatus.forumColor.getHighLightColor()));
                            return;
                        }
                        paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165322));
                        return;
                    }
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165322));
                    return;
                case 1:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165366));
                    return;
                case 9:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165385));
                    return;
                case 3:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165403));
                    return;
                case 4:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165376));
                    return;
                case 5:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165357));
                    return;
                case 6:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165394));
                    return;
                case 7:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165439));
                    return;
                case 8:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165430));
                    return;
                case 2:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165421));
                    return;
                case 10:
                    paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165412));
                    return;
            }
            paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165448));
            return;
        }
        switch (getIndex(paramActivity)) {
            default:
                return;
            case 0:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165323));
                return;
            case 1:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165373));
                return;
            case 9:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165392));
                return;
            case 3:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165410));
                return;
            case 4:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165383));
                return;
            case 5:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165364));
                return;
            case 6:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165401));
                return;
            case 7:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165446));
                return;
            case 8:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165437));
                return;
            case 2:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165428));
                return;
            case 10:
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165419));
                return;
        }
        paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165455));
    }

    public static int getIndex(Context paramContext) {
        return Integer.parseInt(SettingsFragment.getTheme(paramContext));
    }

    /* Error */
    public static Drawable getMenuIconByPicName(String paramString, Context paramContext) {
        // Byte code:
        //   0: aload_1
        //   1: invokestatic 51	com/quoord/tapatalkpro/util/Prefs:get	(Landroid/content/Context;)Landroid/content/SharedPreferences;
        //   4: astore 4
        //   6: aconst_null
        //   7: astore 5
        //   9: aload 4
        //   11: ldc 53
        //   13: iconst_0
        //   14: invokeinterface 59 3 0
        //   19: istore_2
        //   20: aload_1
        //   21: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   24: ldc 66
        //   26: invokevirtual 72	android/content/res/Resources:getBoolean	(I)Z
        //   29: ifeq +45 -> 74
        //   32: aload_1
        //   33: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   36: new 74	java/lang/StringBuilder
        //   39: dup
        //   40: aload_0
        //   41: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   44: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   47: ldc 15
        //   49: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   52: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   55: ldc 93
        //   57: ldc 28
        //   59: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   62: istore_3
        //   63: aload_1
        //   64: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   67: iload_3
        //   68: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
        //   71: astore_0
        //   72: aload_0
        //   73: areturn
        //   74: iload_2
        //   75: ifne +190 -> 265
        //   78: aload_1
        //   79: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   82: ldc 98
        //   84: invokevirtual 72	android/content/res/Resources:getBoolean	(I)Z
        //   87: ifne +77 -> 164
        //   90: aload_1
        //   91: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   94: astore 6
        //   96: aload_1
        //   97: invokestatic 104	com/quoord/tapatalkpro/ics/slidingMenu/SettingsFragment:isLightTheme	(Landroid/content/Context;)Z
        //   100: ifne +40 -> 140
        //   103: aload_0
        //   104: astore 4
        //   106: aload 6
        //   108: aload 4
        //   110: ldc 93
        //   112: ldc 28
        //   114: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   117: istore_2
        //   118: iload_2
        //   119: istore_3
        //   120: iload_2
        //   121: ifgt -58 -> 63
        //   124: aload_1
        //   125: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   128: aload_0
        //   129: ldc 93
        //   131: ldc 28
        //   133: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   136: istore_3
        //   137: goto -74 -> 63
        //   140: new 74	java/lang/StringBuilder
        //   143: dup
        //   144: aload_0
        //   145: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   148: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   151: ldc 15
        //   153: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   156: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   159: astore 4
        //   161: goto -55 -> 106
        //   164: aload 4
        //   166: ldc 106
        //   168: invokeinterface 110 2 0
        //   173: ifeq +37 -> 210
        //   176: aload_1
        //   177: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   180: new 74	java/lang/StringBuilder
        //   183: dup
        //   184: aload_0
        //   185: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   188: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   191: ldc 15
        //   193: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   199: ldc 93
        //   201: ldc 28
        //   203: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   206: istore_2
        //   207: goto -89 -> 118
        //   210: aload_1
        //   211: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   214: astore 6
        //   216: aload_1
        //   217: invokestatic 104	com/quoord/tapatalkpro/ics/slidingMenu/SettingsFragment:isLightTheme	(Landroid/content/Context;)Z
        //   220: ifeq +21 -> 241
        //   223: aload_0
        //   224: astore 4
        //   226: aload 6
        //   228: aload 4
        //   230: ldc 93
        //   232: ldc 28
        //   234: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   237: istore_2
        //   238: goto -120 -> 118
        //   241: new 74	java/lang/StringBuilder
        //   244: dup
        //   245: aload_0
        //   246: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   249: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   252: ldc 15
        //   254: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   260: astore 4
        //   262: goto -36 -> 226
        //   265: aload_1
        //   266: invokevirtual 65	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   269: new 74	java/lang/StringBuilder
        //   272: dup
        //   273: aload_0
        //   274: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   277: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   280: ldc 15
        //   282: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   288: ldc 93
        //   290: ldc 28
        //   292: invokevirtual 97	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   295: istore_2
        //   296: goto -178 -> 118
        //   299: astore_0
        //   300: aload_0
        //   301: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   304: aconst_null
        //   305: areturn
        //   306: astore_0
        //   307: aload 5
        //   309: astore_0
        //   310: goto -238 -> 72
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	313	0	paramString	String
        //   0	313	1	paramContext	Context
        //   19	277	2	i	int
        //   62	75	3	j	int
        //   4	257	4	localObject1	Object
        //   7	301	5	localObject2	Object
        //   94	133	6	localResources	Resources
        // Exception table:
        //   from	to	target	type
        //   9	63	299	java/lang/Exception
        //   78	103	299	java/lang/Exception
        //   106	118	299	java/lang/Exception
        //   124	137	299	java/lang/Exception
        //   140	161	299	java/lang/Exception
        //   164	207	299	java/lang/Exception
        //   210	223	299	java/lang/Exception
        //   226	238	299	java/lang/Exception
        //   241	262	299	java/lang/Exception
        //   265	296	299	java/lang/Exception
        //   63	72	306	java/lang/Exception
    }

    public static int getMoveToDrawableId(String paramString, Context paramContext) {
        Resources localResources = paramContext.getResources();
        if (SettingsFragment.isLightTheme(paramContext)) {
        }
        for (String str = paramString; ; str = paramString + "_dark") {
            int j = localResources.getIdentifier(str, "drawable", "com.quoord.tapatalkpro.activity");
            int i = j;
            if (j <= 0) {
                i = paramContext.getResources().getIdentifier(paramString, "drawable", "com.quoord.tapatalkpro.activity");
            }
            return i;
        }
    }

    public static TextView getSectionTitle(Context paramContext) {
        return (TextView) LayoutInflater.from(paramContext).inflate(2130903357, null);
    }

    public static int getSelector(Activity paramActivity) {
        if (getColor(paramActivity).booleanValue()) {
            switch (getIndex(paramActivity)) {
                default:
                    return 0;
                case 0:
                    return 2130839002;
                case 1:
                    return 2130837574;
                case 9:
                    return 2130838845;
                case 3:
                    return 2130839244;
                case 4:
                    return 2130839549;
                case 5:
                    return 2130839207;
                case 6:
                    return 2130837584;
                case 7:
                    return 2130837847;
                case 8:
                    return 2130837850;
                case 2:
                    return 2130838965;
                case 10:
                    return 2130838848;
            }
            return 2130839273;
        }
        switch (getIndex(paramActivity)) {
            default:
                return 0;
            case 0:
                return 2130837557;
            case 1:
                return 2130837548;
            case 9:
                return 2130837554;
            case 3:
                return 2130837559;
            case 4:
                return 2130837561;
            case 5:
                return 2130837558;
            case 6:
                return 2130837549;
            case 7:
                return 2130837552;
            case 8:
                return 2130837553;
            case 2:
                return 2130837556;
            case 10:
                return 2130837555;
        }
        return 2130837560;
    }

    public static void getSubBackgroundColor(Activity paramActivity, View paramView) {
        if (getColor(paramActivity).booleanValue()) {
            switch (getIndex(paramActivity)) {
                default:
                case 0:
                    do {
                        return;
                        if (!(paramActivity instanceof ForumActivityStatus)) {
                            break;
                        }
                        paramActivity = ((ForumActivityStatus) paramActivity).getForumStatus();
                    } while (paramActivity == null);
                    paramActivity.forumColor.getTextColor();
                    return;
                paramView.setBackgroundResource(2131165330);
                return;
                case 1:
                    paramView.setBackgroundResource(2131165367);
                    return;
                case 9:
                    paramView.setBackgroundResource(2131165386);
                    return;
                case 3:
                    paramView.setBackgroundResource(2131165404);
                    return;
                case 4:
                    paramView.setBackgroundResource(2131165377);
                    return;
                case 5:
                    paramView.setBackgroundResource(2131165358);
                    return;
                case 6:
                    paramView.setBackgroundResource(2131165395);
                    return;
                case 7:
                    paramView.setBackgroundResource(2131165440);
                    return;
                case 8:
                    paramView.setBackgroundResource(2131165431);
                    return;
                case 2:
                    paramView.setBackgroundResource(2131165422);
                    return;
                case 10:
                    paramView.setBackgroundResource(2131165413);
                    return;
            }
            paramView.setBackgroundResource(2131165449);
            return;
        }
        switch (getIndex(paramActivity)) {
            default:
                return;
            case 0:
                paramView.setBackgroundResource(2131165212);
                return;
            case 1:
                paramView.setBackgroundResource(2131165372);
                return;
            case 9:
                paramView.setBackgroundResource(2131165391);
                return;
            case 3:
                paramView.setBackgroundResource(2131165409);
                return;
            case 4:
                paramView.setBackgroundResource(2131165382);
                return;
            case 5:
                paramView.setBackgroundResource(2131165363);
                return;
            case 6:
                paramView.setBackgroundResource(2131165400);
                return;
            case 7:
                paramView.setBackgroundResource(2131165445);
                return;
            case 8:
                paramView.setBackgroundResource(2131165436);
                return;
            case 2:
                paramView.setBackgroundResource(2131165427);
                return;
            case 10:
                paramView.setBackgroundResource(2131165418);
                return;
        }
        paramView.setBackgroundResource(2131165454);
    }

    public static int getSubTabTextSelector(Activity paramActivity) {
        if (!getColor(paramActivity).booleanValue()) {
            return 2130837521;
        }
        switch (getIndex(paramActivity)) {
            default:
                return 0;
            case 0:
                return 2130839354;
            case 1:
                return 2130837577;
            case 9:
                return 2130838846;
            case 3:
                return 2130839245;
            case 4:
                return 2130839550;
            case 5:
                return 2130839208;
            case 6:
                return 2130837585;
            case 7:
                return 2130837848;
            case 8:
                return 2130837851;
            case 2:
                return 2130838966;
            case 10:
                return 2130838849;
        }
        return 2130839274;
    }

    public static int getSubTextColor(Context paramContext) {
        if (!getColor(paramContext).booleanValue()) {
            return 2131165275;
        }
        return 17170437;
    }

    public static void getTabIndicatorColor(Activity paramActivity, View paramView) {
        switch (getIndex(paramActivity)) {
            default:
                return;
            case 0:
                if ((paramActivity instanceof ForumActivityStatus)) {
                    ForumStatus localForumStatus = ((ForumActivityStatus) paramActivity).getForumStatus();
                    if ((localForumStatus != null) && (localForumStatus.forumColor.getSectionTitleColor() != null)) {
                        paramView.setBackgroundDrawable(localForumStatus.forumColor.getTabIndicatorColor(paramActivity));
                        return;
                    }
                    paramView.setBackgroundResource(2130837578);
                    return;
                }
                paramView.setBackgroundResource(2130837578);
                return;
            case 1:
                paramView.setBackgroundResource(2130837578);
                return;
            case 9:
                paramView.setBackgroundResource(2130838847);
                return;
            case 3:
                paramView.setBackgroundResource(2130839246);
                return;
            case 4:
                paramView.setBackgroundResource(2130839551);
                return;
            case 5:
                paramView.setBackgroundResource(2130839209);
                return;
            case 6:
                paramView.setBackgroundResource(2130837586);
                return;
            case 7:
                paramView.setBackgroundResource(2130837849);
                return;
            case 8:
                paramView.setBackgroundResource(2130837852);
                return;
            case 2:
                paramView.setBackgroundResource(2130838967);
                return;
            case 10:
                paramView.setBackgroundResource(2130838850);
                return;
        }
        paramView.setBackgroundResource(2130839275);
    }

    public static int getTextColor(Context paramContext) {
        if (getColor(paramContext).booleanValue()) {
            return 2131165310;
        }
        return 2131165331;
    }

    public static Drawable getViewBackgroundDrawable(Activity paramActivity, int paramInt1, int paramInt2) {
        if (SettingsFragment.isLightTheme(paramActivity)) {
            return paramActivity.getResources().getDrawable(paramInt1);
        }
        return paramActivity.getResources().getDrawable(paramInt2);
    }

    public static void setAuthorColor(Context paramContext, TextView paramTextView) {
        try {
            paramTextView.setTextColor(getAuthorColor(paramContext));
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }

    public static void setCheckBox(Activity paramActivity, CheckBox paramCheckBox) {
        if (SettingsFragment.getColorMode(paramActivity).booleanValue()) {
            paramCheckBox.setTextColor(paramActivity.getResources().getColor(2131165213));
            return;
        }
        paramCheckBox.setTextColor(paramActivity.getResources().getColor(2131165214));
    }

    public static void setDiverResource(Activity paramActivity, ListView paramListView) {
        try {
            SharedPreferences localSharedPreferences = Prefs.get(paramActivity);
            if ((SettingsFragment.isRebranding(paramActivity)) && (localSharedPreferences.contains("primary_color"))) {
                paramListView.setDivider(paramActivity.getResources().getDrawable(2131165214));
                return;
            }
            if (SettingsFragment.isLightTheme(paramActivity)) {
                paramListView.setDivider(paramActivity.getResources().getDrawable(2130837876));
                return;
            }
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
            return;
        }
        paramListView.setDivider(paramActivity.getResources().getDrawable(2130837877));
    }

    public static void setEditText(Activity paramActivity, EditText paramEditText) {
        if (SettingsFragment.getColorMode(paramActivity).booleanValue()) {
            paramEditText.setTextColor(paramActivity.getResources().getColor(2131165213));
            return;
        }
        paramEditText.setTextColor(paramActivity.getResources().getColor(2131165214));
    }

    public static void setHeightLight(Activity paramActivity, View paramView) {
        try {
            SharedPreferences localSharedPreferences = Prefs.get(paramActivity);
            if ((paramActivity.getResources().getBoolean(2131558401)) && (localSharedPreferences.contains("third_color"))) {
                paramView.setBackgroundColor(Color.parseColor("#" + localSharedPreferences.getString("third_color", "")));
                return;
            }
            if (SettingsFragment.isLightTheme(paramActivity)) {
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165504));
                return;
            }
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
            return;
        }
        paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165509));
    }

    public static void setListViewStyle(ListView paramListView, Activity paramActivity) {
    }

    public static void setMenuListBackground(Activity paramActivity, View paramView) {
        try {
            SharedPreferences localSharedPreferences = Prefs.get(paramActivity);
            if ((paramActivity.getResources().getBoolean(2131558401)) && (localSharedPreferences.contains("second_color"))) {
                paramView.setBackgroundColor(Color.parseColor("#" + localSharedPreferences.getString("second_color", "")));
                return;
            }
            if (SettingsFragment.isLightTheme(paramActivity)) {
                paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165473));
                return;
            }
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
            return;
        }
        paramView.setBackgroundColor(paramActivity.getResources().getColor(2131165214));
    }

    public static void setTheme(Activity paramActivity) {
        Object localObject;
        int i;
        try {
            localObject = Prefs.get(paramActivity);
            i = ((SharedPreferences) localObject).getInt("ics_custom_select_position", 0);
            if ((paramActivity.getResources().getBoolean(2131558401)) && (((SharedPreferences) localObject).contains("second_color"))) {
                break label102;
            }
            if (i == 0) {
                if (SettingsFragment.isLightTheme(paramActivity)) {
                    paramActivity.setTheme(2131361803);
                    return;
                }
                paramActivity.setTheme(2131361804);
                return;
            }
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
            return;
        }
        if (SettingsFragment.isLightTheme(paramActivity)) {
            paramActivity.setTheme(2131361810);
        }
        for (; ; ) {
            getCustomActionBarBackground(paramActivity, i);
            return;
            paramActivity.setTheme(2131361811);
        }
        label102:
        if (SettingsFragment.isLightTheme(paramActivity)) {
            paramActivity.setTheme(2131361808);
            if (((SharedPreferences) localObject).contains("primary_color")) {
                localObject = new ColorDrawable(Color.parseColor("#" + ((SharedPreferences) localObject).getString("primary_color", "")));
                paramActivity.getActionBar().setBackgroundDrawable((Drawable) localObject);
            }
        } else {
            paramActivity.setTheme(2131361809);
            if (((SharedPreferences) localObject).contains("second_color")) {
                localObject = new ColorDrawable(Color.parseColor("#" + ((SharedPreferences) localObject).getString("second_color", "")));
                paramActivity.getActionBar().setBackgroundDrawable((Drawable) localObject);
            }
        }
    }

    public static void setThemeForLightOnlyView(Activity paramActivity) {
        paramActivity.setTheme(2131361799);
    }

    public static void setTitle(Activity paramActivity) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ThemeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */