package podspec;
import android.webkit.WebView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import ch.apgsga.apgconnect.APGSDKManager;

/**
 * Apache Cordova plugin for APGconnect
 */
public class apgconnect extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")){
            this.initAPGSDK();
            return true;
        }

        if (action.equals("permissionGranted")) {
            APGSDKManager.notifyPermissionChange();
            return true;
        }

        if (action.equals("newPage")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    WebView webView = getWebView();
                    webView.getSettings().setJavaScriptEnabled(true);
                    APGSDKManager.updateWebview(webView);
                }
            });
            return true;
        }

        return false;
    }
    // Helper to be compile-time compatible with both Cordova 3.x and 4.x.
    private WebView getWebView() {
        try {
            return (WebView)webView.getClass().getMethod("getView").invoke(webView);
        } catch (Exception e) {
            return (WebView)webView;
        }
    }

    private void initAPGSDK() {
        APGSDKManager.setup("AUTH-TOKEN",  cordova.getActivity().getApplication());
     }

}
