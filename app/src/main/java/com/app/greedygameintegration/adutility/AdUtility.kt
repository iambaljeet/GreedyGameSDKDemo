package com.app.greedygameintegration.adutility

import android.content.Context
import com.app.greedygameintegration.R
import com.greedygame.core.AppConfig
import com.greedygame.core.GreedyGameAds
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener

object AdUtility {
    /**
     * Checks if GreedyGame Ads SDK is initialized If not than it will initialize the SDK
     */
    @JvmStatic
    @JvmOverloads
    fun initAdSdk(
        applicationContext: Context,
        greedyGameAdsEventsListener: GreedyGameAdsEventsListener? = null
    ) {
        if (!isSdkInitialized()) {
            val appConfig = AppConfig.Builder(applicationContext)
                .withAppId(applicationContext.getString(R.string.common_app_ad_id))
                .enableAdmobAds(false)
                .build()
            GreedyGameAds.initWith(appConfig, greedyGameAdsEventsListener)
        }
    }

    /**
     * Returns true if GreedyGame Ads SDK is initialized otherwise returns false
     */
    @JvmStatic
    fun isSdkInitialized(): Boolean {
        return GreedyGameAds.isSdkInitialized
    }
}