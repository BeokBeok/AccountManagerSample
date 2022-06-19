package com.beok.accountmanagersample.auth

import android.app.Service
import android.content.Intent
import android.os.IBinder
import javax.inject.Inject

class SampleAuthService : Service() {

    @Inject
    lateinit var authenticator: SampleAuthenticator

    override fun onCreate() {
        authenticator = SampleAuthenticator(this)
    }

    override fun onBind(intent: Intent): IBinder =
        authenticator.iBinder
}
