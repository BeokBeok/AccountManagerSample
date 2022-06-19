package com.beok.accountmanagersample.data

import android.util.Base64
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor() : AuthRemoteDataSource {

    override fun token(email: String, password: String): String {
        return Base64.encode((email + password).toByteArray(), Base64.NO_WRAP)
            .decodeToString()
    }
}
