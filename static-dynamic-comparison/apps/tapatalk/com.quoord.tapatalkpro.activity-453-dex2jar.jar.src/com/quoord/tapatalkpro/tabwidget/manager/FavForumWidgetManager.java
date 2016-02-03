package com.quoord.tapatalkpro.tabwidget.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.tabwidget.FavForumWidget;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FavForumWidgetManager {
    private static final String FORUM_ID_PREFIX = "favforums_";
    public static final String PREFS_NAME = "com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager";
    private static final Map<Integer, FavForumWidget> mWidgets = new ConcurrentHashMap();
    private static final FavForumWidgetManager sInstance = new FavForumWidgetManager();

    private FavForumWidget get(int paramInt) {
        return (FavForumWidget) mWidgets.get(Integer.valueOf(paramInt));
    }

    public static FavForumWidgetManager getInstance() {
        return sInstance;
    }

    public static int loadForumIdPref(Context paramContext, int paramInt) {
        return paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager", 0).getInt("favforums_" + paramInt, -1);
    }

    private void put(int paramInt, FavForumWidget paramFavForumWidget) {
        mWidgets.put(Integer.valueOf(paramInt), paramFavForumWidget);
    }

    private void remove(Context paramContext, int paramInt) {
        mWidgets.remove(Integer.valueOf(paramInt));
        removeWidgetPrefs(paramContext, paramInt);
    }

    public static void removeWidgetPrefs(Context paramContext, int paramInt) {
        Object localObject = paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager", 0);
        paramContext = ((SharedPreferences) localObject).edit();
        localObject = ((SharedPreferences) localObject).getAll().keySet().iterator();
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                paramContext.apply();
                return;
            }
            String str = (String) ((Iterator) localObject).next();
            if (str.endsWith("_" + paramInt)) {
                paramContext.remove(str);
            }
        }
    }

    public static void saveWidgetPrefs(Context paramContext, int paramInt1, int paramInt2) {
        paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager", 0).edit().putInt("favforums_" + paramInt1, paramInt2).commit();
    }

    /* Error */
    public void createWidgets(Context paramContext, int[] paramArrayOfInt) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_2
        //   3: arraylength
        //   4: istore 4
        //   6: iconst_0
        //   7: istore_3
        //   8: iload_3
        //   9: iload 4
        //   11: if_icmplt +6 -> 17
        //   14: aload_0
        //   15: monitorexit
        //   16: return
        //   17: aload_0
        //   18: aload_1
        //   19: aload_2
        //   20: iload_3
        //   21: iaload
        //   22: invokevirtual 145	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:getOrCreateWidget	(Landroid/content/Context;I)Lcom/quoord/tapatalkpro/tabwidget/FavForumWidget;
        //   25: pop
        //   26: iload_3
        //   27: iconst_1
        //   28: iadd
        //   29: istore_3
        //   30: goto -22 -> 8
        //   33: astore_1
        //   34: aload_0
        //   35: monitorexit
        //   36: aload_1
        //   37: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	38	0	this	FavForumWidgetManager
        //   0	38	1	paramContext	Context
        //   0	38	2	paramArrayOfInt	int[]
        //   7	23	3	i	int
        //   4	8	4	j	int
        // Exception table:
        //   from	to	target	type
        //   2	6	33	finally
        //   17	26	33	finally
    }

    /* Error */
    public void deleteAllWidgets(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: ldc 11
        //   5: iconst_0
        //   6: invokevirtual 55	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   9: invokeinterface 94 1 0
        //   14: checkcast 149	java/util/HashMap
        //   17: astore 4
        //   19: aload 4
        //   21: invokevirtual 150	java/util/HashMap:keySet	()Ljava/util/Set;
        //   24: invokeinterface 104 1 0
        //   29: astore_3
        //   30: aload 4
        //   32: invokevirtual 150	java/util/HashMap:keySet	()Ljava/util/Set;
        //   35: invokeinterface 154 1 0
        //   40: newarray <illegal type>
        //   42: astore 4
        //   44: iconst_0
        //   45: istore_2
        //   46: aload_3
        //   47: invokeinterface 110 1 0
        //   52: ifne +15 -> 67
        //   55: invokestatic 156	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:getInstance	()Lcom/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager;
        //   58: aload_1
        //   59: aload 4
        //   61: invokevirtual 159	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:deleteWidgets	(Landroid/content/Context;[I)V
        //   64: aload_0
        //   65: monitorexit
        //   66: return
        //   67: aload_3
        //   68: invokeinterface 119 1 0
        //   73: checkcast 121	java/lang/String
        //   76: astore 5
        //   78: aload 4
        //   80: iload_2
        //   81: aload 5
        //   83: aload 5
        //   85: ldc 123
        //   87: invokevirtual 163	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   90: iconst_1
        //   91: iadd
        //   92: aload 5
        //   94: invokevirtual 166	java/lang/String:length	()I
        //   97: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
        //   100: invokestatic 173	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
        //   103: invokevirtual 176	java/lang/Integer:intValue	()I
        //   106: iastore
        //   107: iload_2
        //   108: iconst_1
        //   109: iadd
        //   110: istore_2
        //   111: goto -65 -> 46
        //   114: astore_1
        //   115: aload_0
        //   116: monitorexit
        //   117: aload_1
        //   118: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	119	0	this	FavForumWidgetManager
        //   0	119	1	paramContext	Context
        //   45	66	2	i	int
        //   29	39	3	localIterator	Iterator
        //   17	62	4	localObject	Object
        //   76	17	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	44	114	finally
        //   46	64	114	finally
        //   67	107	114	finally
    }

    /* Error */
    public void deleteWidgets(Context paramContext, int[] paramArrayOfInt) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_2
        //   3: arraylength
        //   4: istore 4
        //   6: iconst_0
        //   7: istore_3
        //   8: iload_3
        //   9: iload 4
        //   11: if_icmplt +6 -> 17
        //   14: aload_0
        //   15: monitorexit
        //   16: return
        //   17: aload_2
        //   18: iload_3
        //   19: iaload
        //   20: istore 5
        //   22: invokestatic 156	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:getInstance	()Lcom/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager;
        //   25: iload 5
        //   27: invokespecial 178	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:get	(I)Lcom/quoord/tapatalkpro/tabwidget/FavForumWidget;
        //   30: astore 6
        //   32: aload 6
        //   34: ifnull +8 -> 42
        //   37: aload 6
        //   39: invokevirtual 181	com/quoord/tapatalkpro/tabwidget/FavForumWidget:onDeleted	()V
        //   42: aload_0
        //   43: aload_1
        //   44: iload 5
        //   46: invokespecial 183	com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager:remove	(Landroid/content/Context;I)V
        //   49: iload_3
        //   50: iconst_1
        //   51: iadd
        //   52: istore_3
        //   53: goto -45 -> 8
        //   56: astore_1
        //   57: aload_0
        //   58: monitorexit
        //   59: aload_1
        //   60: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	FavForumWidgetManager
        //   0	61	1	paramContext	Context
        //   0	61	2	paramArrayOfInt	int[]
        //   7	46	3	i	int
        //   4	8	4	j	int
        //   20	25	5	k	int
        //   30	8	6	localFavForumWidget	FavForumWidget
        // Exception table:
        //   from	to	target	type
        //   2	6	56	finally
        //   22	32	56	finally
        //   37	42	56	finally
        //   42	49	56	finally
    }

    /* Error */
    public void deleteWidgetsByForumId(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: ldc 11
        //   5: iconst_0
        //   6: invokevirtual 55	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   9: astore 4
        //   11: aload 4
        //   13: invokeinterface 94 1 0
        //   18: checkcast 149	java/util/HashMap
        //   21: astore 6
        //   23: aload 6
        //   25: invokevirtual 150	java/util/HashMap:keySet	()Ljava/util/Set;
        //   28: invokeinterface 104 1 0
        //   33: astore 5
        //   35: aload 6
        //   37: invokevirtual 150	java/util/HashMap:keySet	()Ljava/util/Set;
        //   40: invokeinterface 154 1 0
        //   45: newarray <illegal type>
        //   47: astore 6
        //   49: iconst_0
        //   50: istore_3
        //   51: aload 5
        //   53: invokeinterface 110 1 0
        //   58: ifne +30 -> 88
        //   61: new 187	android/content/Intent
        //   64: dup
        //   65: ldc -67
        //   67: invokespecial 190	android/content/Intent:<init>	(Ljava/lang/String;)V
        //   70: astore_2
        //   71: aload_2
        //   72: ldc -64
        //   74: aload 6
        //   76: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
        //   79: pop
        //   80: aload_1
        //   81: aload_2
        //   82: invokevirtual 200	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
        //   85: aload_0
        //   86: monitorexit
        //   87: return
        //   88: aload 5
        //   90: invokeinterface 119 1 0
        //   95: checkcast 121	java/lang/String
        //   98: astore 7
        //   100: new 57	java/lang/StringBuilder
        //   103: dup
        //   104: aload 4
        //   106: aload 7
        //   108: iconst_0
        //   109: invokeinterface 74 3 0
        //   114: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   117: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   120: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   123: aload_2
        //   124: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   127: ifeq -76 -> 51
        //   130: aload 6
        //   132: iload_3
        //   133: aload 7
        //   135: aload 7
        //   137: ldc 123
        //   139: invokevirtual 163	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   142: iconst_1
        //   143: iadd
        //   144: aload 7
        //   146: invokevirtual 166	java/lang/String:length	()I
        //   149: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
        //   152: invokestatic 173	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
        //   155: invokevirtual 176	java/lang/Integer:intValue	()I
        //   158: iastore
        //   159: iload_3
        //   160: iconst_1
        //   161: iadd
        //   162: istore_3
        //   163: goto -112 -> 51
        //   166: astore_1
        //   167: aload_0
        //   168: monitorexit
        //   169: aload_1
        //   170: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	171	0	this	FavForumWidgetManager
        //   0	171	1	paramContext	Context
        //   0	171	2	paramString	String
        //   50	113	3	i	int
        //   9	96	4	localSharedPreferences	SharedPreferences
        //   33	56	5	localIterator	Iterator
        //   21	110	6	localObject	Object
        //   98	47	7	str	String
        // Exception table:
        //   from	to	target	type
        //   2	49	166	finally
        //   51	85	166	finally
        //   88	159	166	finally
    }

    public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        int i = 0;
        paramFileDescriptor = mWidgets.values().iterator();
        for (; ; ) {
            if (!paramFileDescriptor.hasNext()) {
                return;
            }
            paramArrayOfString = (FavForumWidget) paramFileDescriptor.next();
            StringBuilder localStringBuilder = new StringBuilder("Widget #");
            i += 1;
            paramPrintWriter.println(i);
            paramPrintWriter.println("    " + paramArrayOfString.toString());
        }
    }

    public FavForumWidget getOrCreateWidget(Context paramContext, int paramInt) {
        try {
            FavForumWidget localFavForumWidget2 = getInstance().get(paramInt);
            FavForumWidget localFavForumWidget1 = localFavForumWidget2;
            if (localFavForumWidget2 == null) {
                localFavForumWidget1 = new FavForumWidget(paramContext, paramInt, loadForumIdPref(paramContext, paramInt));
                put(paramInt, localFavForumWidget1);
                localFavForumWidget1.start();
            }
            return localFavForumWidget1;
        } finally {
        }
    }

    public void updateWidgets(Context paramContext, int[] paramArrayOfInt) {
        for (; ; ) {
            int i;
            try {
                int j = paramArrayOfInt.length;
                i = 0;
                if (i >= j) {
                    return;
                }
                int k = paramArrayOfInt[i];
                FavForumWidget localFavForumWidget = getInstance().get(k);
                if (localFavForumWidget != null) {
                    localFavForumWidget.reset();
                } else {
                    getOrCreateWidget(paramContext, k);
                }
            } finally {
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/manager/FavForumWidgetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */