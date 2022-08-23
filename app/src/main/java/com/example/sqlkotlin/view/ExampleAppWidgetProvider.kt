package com.example.sqlkotlin.view

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import com.example.sqlkotlin.R

class ExampleAppWidgetProvider: AppWidgetProvider() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // Perform this loop procedure for each widget that belongs to this
        // provider.
        appWidgetIds.forEach { appWidgetId ->
            // Create an Intent to launch ExampleActivity.
            val pendingIntent: PendingIntent = PendingIntent.getActivity(
                /* context = */ context,
                /* requestCode = */  0,
                /* intent = */ Intent(context, ExampleAppWidgetProvider::class.java),
                /* flags = */ PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Get the layout for the widget and attach an on-click listener
            // to the button.
            val views: RemoteViews = RemoteViews(
                context.packageName,
                R.layout.activity_widget
            ).apply {
                setOnClickPendingIntent(R.id.button, pendingIntent)
            }

            // Tell the AppWidgetManager to perform an update on the current
            // widget.
            appWidgetManager.updateAppWidget(appWidgetId, views)
// Check the view.
//            views.setCompoundButtonChecked(R.id., true)
//
//// Check a radio group.
//        views.setRadioGroupChecked(R.id.radioButton, R.id.button2)

// Listen for check changes. The intent will have an extra with the key
// EXTRA_CHECKED that specifies the current checked state of the view.
//        views.setOnCheckedChangeResponse(
//            R.id.checkBox,
//            RemoteViews.RemoteResponse.fromPendingIntent(onCheckedChangePendingIntent)
//        )

        }

    }

}

