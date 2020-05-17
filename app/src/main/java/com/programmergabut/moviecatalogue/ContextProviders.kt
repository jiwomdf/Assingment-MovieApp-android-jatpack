package com.programmergabut.moviecatalogue

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/*
 *  Created by Katili Jiwo Adi Wiyono on 17/05/20.
 */

open class ContextProviders {
    open val Main: CoroutineContext = Dispatchers.Main
    open val IO: CoroutineContext = Dispatchers.IO

    companion object {
        @Volatile
        private var INSTANCE: ContextProviders? = null

        fun getInstance() : ContextProviders {
            return INSTANCE
                ?: synchronized(this) {
                    ContextProviders()
            }.also {
                INSTANCE = it
            }
        }
    }
}