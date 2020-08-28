package com.app.greedygameintegration.adutility

import com.greedygame.core.adview.GGAdview
import com.greedygame.core.adview.interfaces.AdLoadCallback

/**
 * Extension function that accepts an UnitId(Optional if defined im XML), AdLoadCallback and loads add to GGAdview
 */
fun GGAdview.initAndLoadAd(adId: String? = null, adLoadCallback: AdLoadCallback) {
    if (!adId.isNullOrBlank()) unitId = adId
    loadAd(adLoadCallback)
}