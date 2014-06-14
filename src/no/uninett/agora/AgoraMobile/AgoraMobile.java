/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package no.uninett.agora.AgoraMobile;

import android.os.Bundle;

//import com.bugsense.trace.BugSenseHandler;

import com.crashlytics.android.Crashlytics;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

public class AgoraMobile extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        //BugSenseHandler.initAndStartSession(AgoraMobile.this, "1091d936");

        Crashlytics.start(this);

        super.setIntegerProperty("splashscreen", R.drawable.splashscreen);
        super.loadUrl(Config.getStartUrl(), 5000);
        //super.loadUrl("file:///android_asset/www/index.html")
    }
}

