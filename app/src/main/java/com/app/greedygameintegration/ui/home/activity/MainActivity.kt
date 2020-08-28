package com.app.greedygameintegration.ui.home.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.greedygameintegration.R
import com.app.greedygameintegration.adutility.AdUtility
import com.app.greedygameintegration.adutility.initAndLoadAd
import com.greedygame.core.adview.interfaces.AdLoadCallback
import com.greedygame.core.adview.modals.AdRequestErrors
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
class MainActivity: AppCompatActivity() {
    private val addListener = object: AdLoadCallback {
        override fun onAdLoadFailed(cause: AdRequestErrors) {
            Log.e(TAG, "onAdLoadFailed: cause: $cause")
        }

        override fun onAdLoaded() {
            Log.d(TAG, "onAdLoaded")
        }

        override fun onReadyForRefresh() {
            Log.d(TAG, "onReadyForRefresh")
        }

        override fun onUiiClosed() {
            Log.d(TAG, "onUiiClosed")
        }

        override fun onUiiOpened() {
            Log.d(TAG, "onUiiOpened")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing GreedyGame Ads SDK
        AdUtility.initAdSdk(applicationContext = applicationContext)

        buttonLoadAd.setOnClickListener {
            // Initializing and loads Ads to GGAdview
            adViewHomeBanner.initAndLoadAd(getString(R.string.home_ad_unit_id), addListener)
        }
    }
}