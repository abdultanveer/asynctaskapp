package com.example.asynctaskapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        if (bundle != null) {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                //str += "SMS from " + msgs[i].getOriginatingAddress();
               // str += " :";
                str += msgs[i].getMessageBody().toString();
               // str += "\n";
            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            if(str.contains("getcalllog")){
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("5554",null,
                        "1234567890,987654321",null,null);
            }

        }
    }
}
