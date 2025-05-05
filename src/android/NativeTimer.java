package com.benkesmith.nativetimer;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.os.Handler;

import java.util.HashMap;

public class NativeTimer extends CordovaPlugin {
  private final HashMap<Integer, Runnable> timers = new HashMap<>();
  private final Handler handler = new Handler();

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if ("setTimeout".equals(action)) {
      final int id = args.getInt(0);
      int delay = args.getInt(1);

      Runnable task = () -> {
        callbackContext.success();
        timers.remove(id);
      };

      timers.put(id, task);
      handler.postDelayed(task, delay);
      return true;
    } else if ("clearTimeout".equals(action)) {
      int id = args.getInt(0);
      Runnable task = timers.remove(id);
      if (task != null) handler.removeCallbacks(task);
      return true;
    }
    return false;
  }
}
