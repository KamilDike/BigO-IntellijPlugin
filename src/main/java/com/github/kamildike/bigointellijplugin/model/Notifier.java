package com.github.kamildike.bigointellijplugin.model;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

public class Notifier {
    private static final NotificationGroup WINDOW_GROUP =
            new NotificationGroup("notifier.notifications.toolWindow",
                NotificationDisplayType.BALLOON,
                true);

    public static void notify(Project project, Notation notation) {
        Notification msg = new Notification(
                WINDOW_GROUP.getDisplayId(), null,
                "BigOn", Notation.getLabel(notation), "",
                NotificationType.INFORMATION, null);
        synchronized (msg) {
            msg.notify(project);
        }
    }
}
