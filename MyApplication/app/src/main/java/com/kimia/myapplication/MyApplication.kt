package com.kimia.myapplication

import android.app.Application
import com.kinexcs.kimia.move.deskercise.exercise.sdk.MoveSDK

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MoveSDK.init(this)
    }
}