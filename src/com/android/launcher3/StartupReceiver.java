package com.android.launcher3;

import com.android.launcher3.NotificationController;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupReceiver extends BroadcastReceiver {

    static final String SYSTEM_READY = "com.android.launcher3.SYSTEM_READY";

    @Override
    public void onReceive(Context context, Intent intent) {
        CharSequence isPrescan = intent.getExtras().getCharSequence("com.android.pms.PRESCAN");
        Log.d("cw", "haha,getExtra:" + isPrescan);
        if (isPrescan != null && isPrescan.equals("true")) {
            Log.d("cw", "haha,in");
            if(NotificationController.hasNotification == true){
                NotificationController.clearAllNotify(context);
            }
            context.sendStickyBroadcast(new Intent(SYSTEM_READY));
        }
    }
}
