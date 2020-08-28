package com.app.greedygameintegration.app

import android.app.Application
import android.util.Log
import com.app.greedygameintegration.adutility.AdUtility
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener
import com.greedygame.core.models.InitErrors

private const val TAG = "DemoApp"
class DemoApp: Application() {
    private val greedyGameAdsEventsListener = object: GreedyGameAdsEventsListener {
        override fun onInitSuccess() {
            Log.d(TAG, "onInitSuccess")
        }

        override fun onInitFailed(cause: InitErrors) {
            Log.e(TAG, "onInitFailed: cause: $cause")
        }

        override fun onDestroyed() {
            Log.d(TAG, "onDestroyed")
        }
    }

    override fun onCreate() {
        super.onCreate()

        // Initializing GreedyGame Ads SDK
        AdUtility.initAdSdk(this, greedyGameAdsEventsListener)
    }
}