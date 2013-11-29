package no.uninett.agora.AgoraMobile;

import android.util.Log;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Brian Chen on 7/9/13.
 * Phonegap Plugin for Cookie Management
 */
public class CookieManager extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("deleteCookies")) {
            Log.v("AgoraMobilePlugin","deleteCookies function");
            this.deleteCookies(callbackContext);
            return true;
        }
        return false;
    }

    private void deleteCookies(final CallbackContext callbackContext){
        try{
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                android.webkit.CookieManager.getInstance().removeAllCookie();
                Log.v("AgoraMobilePlugin","deleteCookies success");
                callbackContext.success("cookies delete natively"); // Thread-safe.
            }
        });
        }catch (Exception ex){
            callbackContext.error("delete cookie failed");
        }
    }
}
