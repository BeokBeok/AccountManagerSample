package com.beok.accountmanagersample.data

import com.beok.accountmanagersample.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val local: AuthLocalDataSource,
    private val remote: AuthRemoteDataSource
): AuthRepository {

    override fun login(email: String, password: String) {
        val token = remote.token(email, password)
        local.writeAccount(email, token)
    }

    override fun token(): String {
        return local.token()
    }

    override fun logout() {
        local.logout()
    }
}
