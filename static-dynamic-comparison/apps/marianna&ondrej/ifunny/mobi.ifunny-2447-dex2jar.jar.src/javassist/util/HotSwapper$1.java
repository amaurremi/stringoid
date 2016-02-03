package javassist.util;

import com.sun.jdi.event.EventIterator;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.MethodEntryEvent;

import java.io.PrintStream;

class HotSwapper$1
        extends Thread {
    HotSwapper$1(HotSwapper paramHotSwapper) {
    }

    private void errorMsg(Throwable paramThrowable) {
        System.err.print("Exception in thread \"HotSwap\" ");
        paramThrowable.printStackTrace(System.err);
    }

    public void run() {
        Object localObject1 = null;
        try {
            EventSet localEventSet = this.this$0.waitEvent();
            localObject1 = localEventSet;
            EventIterator localEventIterator = localEventSet.eventIterator();
            do {
                localObject2 = localEventSet;
                localObject1 = localEventSet;
                if (!localEventIterator.hasNext()) {
                    break;
                }
                localObject1 = localEventSet;
            } while (!(localEventIterator.nextEvent() instanceof MethodEntryEvent));
            localObject1 = localEventSet;
            this.this$0.hotswap();
            localObject2 = localEventSet;
        } catch (Throwable localThrowable2) {
            for (; ; ) {
                try {
                    ((EventSet) localObject2).resume();
                    return;
                } catch (Throwable localThrowable1) {
                    Object localObject2;
                    errorMsg(localThrowable1);
                }
                localThrowable2 = localThrowable2;
                errorMsg(localThrowable2);
                localObject2 = localObject1;
            }
        }
        if (localObject2 != null) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/HotSwapper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */