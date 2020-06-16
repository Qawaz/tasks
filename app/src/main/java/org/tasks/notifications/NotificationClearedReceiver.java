package org.tasks.notifications;

import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import org.tasks.injection.InjectingBroadcastReceiver;
import timber.log.Timber;

@AndroidEntryPoint
public class NotificationClearedReceiver extends InjectingBroadcastReceiver {

  @Inject NotificationManager notificationManager;

  @Override
  public void onReceive(Context context, Intent intent) {
    super.onReceive(context, intent);

    long notificationId = intent.getLongExtra(NotificationManager.EXTRA_NOTIFICATION_ID, -1L);
    Timber.d("cleared %s", notificationId);
    notificationManager.cancel(notificationId);
  }
}
