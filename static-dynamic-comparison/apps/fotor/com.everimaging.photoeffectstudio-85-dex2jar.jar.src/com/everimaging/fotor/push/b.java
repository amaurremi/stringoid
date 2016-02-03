package com.everimaging.fotor.push;

import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class b {
    private static final String a = b.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static b c;
    private LinkedList<PushMessageEntity.MessageEntity> d = new LinkedList();

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private boolean a(LinkedList<PushMessageEntity.MessageEntity> paramLinkedList, PushMessageEntity.MessageEntity paramMessageEntity) {
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext()) {
            if (((PushMessageEntity.MessageEntity) paramLinkedList.next()).getId() == paramMessageEntity.getId()) {
                return true;
            }
        }
        return false;
    }

    public PushMessageEntity.MessageEntity a(int paramInt) {
        b.c(new Object[]{"getMeesage where:" + paramInt, "meesgaes size:" + this.d.size()});
        long l = System.currentTimeMillis();
        for (; ; ) {
            synchronized (this.d) {
                Object localObject2 = (LinkedList) this.d.clone();
                if (localObject2 == null) {
                    break;
                }
                ???=((LinkedList) localObject2).iterator();
                if (!((Iterator) ? ??).hasNext()){
                    break;
                }
                localObject2 = (PushMessageEntity.MessageEntity) ((Iterator) ? ??).next();
                if (!((PushMessageEntity.MessageEntity) localObject2).isShouldDisplay(paramInt)) {
                    continue;
                }
                b.c(new Object[]{"should display location,location time:" + ((PushMessageEntity.MessageEntity) localObject2).getLocalTime() + ",exire duration:" + ((PushMessageEntity.MessageEntity) localObject2).getExpireDuration(), "currentMS:" + l});
                if (((PushMessageEntity.MessageEntity) localObject2).getLocalTime() + ((PushMessageEntity.MessageEntity) localObject2).getExpireDuration() > l) {
                    b.c(new Object[]{"message not exire, u can use it to display"});
                    return (PushMessageEntity.MessageEntity) localObject2;
                }
            }
            b.c(new Object[]{"remove exire message." + localMessageEntity.getMsgDescription()});
            b(localMessageEntity);
        }
        return null;
    }

    public void a(PushMessageEntity.MessageEntity paramMessageEntity) {
        LinkedList localLinkedList = this.d;
        if (paramMessageEntity != null) {
        }
        try {
            if (!a(this.d, paramMessageEntity)) {
                this.d.add(paramMessageEntity);
            }
            return;
        } finally {
        }
    }

    public void a(Collection<PushMessageEntity.MessageEntity> paramCollection) {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            a((PushMessageEntity.MessageEntity) paramCollection.next());
        }
    }

    public void b(PushMessageEntity.MessageEntity paramMessageEntity) {
        synchronized (this.d) {
            this.d.remove(paramMessageEntity);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */