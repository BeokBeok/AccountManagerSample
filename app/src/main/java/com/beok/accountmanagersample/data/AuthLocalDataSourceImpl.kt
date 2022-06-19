package com.beok.accountmanagersample.data

import android.accounts.Account
import android.accounts.AccountManager
import androidx.core.os.bundleOf
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(
    private val accountManager: AccountManager
) : AuthLocalDataSource {

    private val account
        get() = accountManager.getAccountsByType(ACCOUNT_TYPE)
            .firstOrNull()

    override fun writeAccount(email: String, token: String) {
        if (account != null) {
            logout()
        }
        accountManager.addAccountExplicitly(
            Account(email, ACCOUNT_TYPE),
            null,
            bundleOf(KEY_TOKEN to token)
        )
    }

    override fun token(): String {
        if (account == null) return ""
        return accountManager.getUserData(account, KEY_TOKEN) ?: ""
    }

    override fun logout() {
        accountManager.getAccountsByType(ACCOUNT_TYPE)
            .forEach(accountManager::removeAccountExplicitly)
    }

    companion object {
        private const val ACCOUNT_TYPE = "com.beok.accountmanagersample.auth"
        private const val KEY_TOKEN = "key_token"
    }
}
