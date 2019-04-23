package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class broadcast extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
            if (bundle !=null)
                try {
            final Object[] emmaObj = (Object[]) bundle.get("emma");
            for (int i = 0;i<emmaObj.length;i++){
            SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) emmaObj[i]);
            String phoneNumber = currentMessage.getDisplayOriginatingAddress();
            String sendNum = phoneNumber;
            String message = currentMessage.getDisplayMessageBody();
            Log.i("SmsReceiver", "SenderNum:" + sendNum + "; message:" + message);
            //show duration
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context,"sendNum:" + sendNum + ",message:" + message, duration);
            toast.show();


        }//end for loop

    }//bundle is null
catch(Exception e)

    {
        Log.e ("SmsReceiver", "Exception smsReceiver" + e);
    }
}
}
