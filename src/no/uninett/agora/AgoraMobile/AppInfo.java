package no.uninett.agora.AgoraMobile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by BBC on 11/29/13.
 */
public class AppInfo extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("getVersionNumber")) {
            Log.v("AgoraMobilePlugin", "getVersionNumber function");
            this.getVersionNumber(callbackContext);
            return true;
        }
        return false;
    }

    private void getVersionNumber(final CallbackContext callbackContext){

        Context context = cordova.getActivity().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();

        String versionName = "not available"; // initialize String

        try {
            versionName = packageManager.getPackageInfo(packageName, 0).versionName;
            callbackContext.success(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            callbackContext.error("get application version number failed");
        }
    }
}
