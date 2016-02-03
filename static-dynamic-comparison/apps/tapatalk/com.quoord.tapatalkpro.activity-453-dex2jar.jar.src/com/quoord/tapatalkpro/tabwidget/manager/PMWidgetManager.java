package com.quoord.tapatalkpro.tabwidget.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.tabwidget.PMWidget;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PMWidgetManager {
    private static final String PM_ID_PREFIX = "pm_";
    public static final String PREFS_NAME = "com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager";
    private static final Map<Integer, PMWidget> mWidgets = new ConcurrentHashMap();
    private static final PMWidgetManager sInstance = new PMWidgetManager();

    private PMWidget get(int paramInt) {
        return (PMWidget) mWidgets.get(Integer.valueOf(paramInt));
    }

    public static PMWidgetManager getInstance() {
        return sInstance;
    }

    public static int loadForumIdPref(Context paramContext, int paramInt) {
        return paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager", 0).getInt("pm_" + paramInt, -1);
    }

    private void put(int paramInt, PMWidget paramPMWidget) {
        mWidgets.put(Integer.valueOf(paramInt), paramPMWidget);
    }

    private void remove(Context paramContext, int paramInt) {
        mWidgets.remove(Integer.valueOf(paramInt));
        removeWidgetPrefs(paramContext, paramInt);
    }

    public static void removeWidgetPrefs(Context paramContext, int paramInt) {
        Object localObject = paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager", 0);
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
        paramContext.getSharedPreferences("com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager", 0).edit().putInt("pm_" + paramInt1, paramInt2).commit();
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
        //   22: invokevirtual 145	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:getOrCreateWidget	(Landroid/content/Context;I)Lcom/quoord/tapatalkpro/tabwidget/PMWidget;
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
        //   0	38	0	this	PMWidgetManager
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
        //   52: ifne +13 -> 65
        //   55: aload_0
        //   56: aload_1
        //   57: aload 4
        //   59: invokevirtual 157	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:deleteWidgets	(Landroid/content/Context;[I)V
        //   62: aload_0
        //   63: monitorexit
        //   64: return
        //   65: aload_3
        //   66: invokeinterface 119 1 0
        //   71: checkcast 121	java/lang/String
        //   74: astore 5
        //   76: aload 4
        //   78: iload_2
        //   79: aload 5
        //   81: aload 5
        //   83: ldc 123
        //   85: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   88: iconst_1
        //   89: iadd
        //   90: aload 5
        //   92: invokevirtual 164	java/lang/String:length	()I
        //   95: invokevirtual 168	java/lang/String:substring	(II)Ljava/lang/String;
        //   98: invokestatic 171	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
        //   101: invokevirtual 174	java/lang/Integer:intValue	()I
        //   104: iastore
        //   105: iload_2
        //   106: iconst_1
        //   107: iadd
        //   108: istore_2
        //   109: goto -63 -> 46
        //   112: astore_1
        //   113: aload_0
        //   114: monitorexit
        //   115: aload_1
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	PMWidgetManager
        //   0	117	1	paramContext	Context
        //   45	64	2	i	int
        //   29	37	3	localIterator	Iterator
        //   17	60	4	localObject	Object
        //   74	17	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	44	112	finally
        //   46	62	112	finally
        //   65	105	112	finally
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
        //   22: invokestatic 176	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:getInstance	()Lcom/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager;
        //   25: iload 5
        //   27: invokespecial 178	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:get	(I)Lcom/quoord/tapatalkpro/tabwidget/PMWidget;
        //   30: astore 6
        //   32: aload 6
        //   34: ifnull +8 -> 42
        //   37: aload 6
        //   39: invokevirtual 181	com/quoord/tapatalkpro/tabwidget/PMWidget:onDeleted	()V
        //   42: aload_0
        //   43: aload_1
        //   44: iload 5
        //   46: invokespecial 183	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:remove	(Landroid/content/Context;I)V
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
        //   0	61	0	this	PMWidgetManager
        //   0	61	1	paramContext	Context
        //   0	61	2	paramArrayOfInt	int[]
        //   7	46	3	i	int
        //   4	8	4	j	int
        //   20	25	5	k	int
        //   30	8	6	localPMWidget	PMWidget
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
        //   58: ifne +13 -> 71
        //   61: aload_0
        //   62: aload_1
        //   63: aload 6
        //   65: invokevirtual 157	com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager:deleteWidgets	(Landroid/content/Context;[I)V
        //   68: aload_0
        //   69: monitorexit
        //   70: return
        //   71: aload 5
        //   73: invokeinterface 119 1 0
        //   78: checkcast 121	java/lang/String
        //   81: astore 7
        //   83: new 57	java/lang/StringBuilder
        //   86: dup
        //   87: aload 4
        //   89: aload 7
        //   91: iconst_0
        //   92: invokeinterface 74 3 0
        //   97: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   100: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   103: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   106: aload_2
        //   107: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   110: ifeq -59 -> 51
        //   113: aload 6
        //   115: iload_3
        //   116: aload 7
        //   118: aload 7
        //   120: ldc 123
        //   122: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   125: iconst_1
        //   126: iadd
        //   127: aload 7
        //   129: invokevirtual 164	java/lang/String:length	()I
        //   132: invokevirtual 168	java/lang/String:substring	(II)Ljava/lang/String;
        //   135: invokestatic 171	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
        //   138: invokevirtual 174	java/lang/Integer:intValue	()I
        //   141: iastore
        //   142: iload_3
        //   143: iconst_1
        //   144: iadd
        //   145: istore_3
        //   146: goto -95 -> 51
        //   149: astore_1
        //   150: aload_0
        //   151: monitorexit
        //   152: aload_1
        //   153: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	154	0	this	PMWidgetManager
        //   0	154	1	paramContext	Context
        //   0	154	2	paramString	String
        //   50	96	3	i	int
        //   9	79	4	localSharedPreferences	SharedPreferences
        //   33	39	5	localIterator	Iterator
        //   21	93	6	localObject	Object
        //   81	47	7	str	String
        // Exception table:
        //   from	to	target	type
        //   2	49	149	finally
        //   51	68	149	finally
        //   71	142	149	finally
    }

    public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        int i = 0;
        paramFileDescriptor = mWidgets.values().iterator();
        for (; ; ) {
            if (!paramFileDescriptor.hasNext()) {
                return;
            }
            paramArrayOfString = (PMWidget) paramFileDescriptor.next();
            StringBuilder localStringBuilder = new StringBuilder("Widget #");
            i += 1;
            paramPrintWriter.println(i);
            paramPrintWriter.println("    " + paramArrayOfString.toString());
        }
    }

    public PMWidget getOrCreateWidget(Context paramContext, int paramInt) {
        try {
            PMWidget localPMWidget2 = getInstance().get(paramInt);
            PMWidget localPMWidget1 = localPMWidget2;
            if (localPMWidget2 == null) {
                localPMWidget1 = new PMWidget(paramContext, paramInt, loadForumIdPref(paramContext, paramInt));
                put(paramInt, localPMWidget1);
                localPMWidget1.start();
            }
            return localPMWidget1;
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
                PMWidget localPMWidget = getInstance().get(k);
                if (localPMWidget != null) {
                    localPMWidget.reset();
                } else {
                    getOrCreateWidget(paramContext, k);
                }
            } finally {
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/manager/PMWidgetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */