package com.beok.accountmanagersample.data

interface AuthLocalDataSource {

    fun writeAccount(email: String, token: String)

    fun token(): String

    fun logout()
}
