package com.beok.accountmanagersample.domain

interface AuthRepository {

    fun login(email: String, password: String)

    fun token(): String

    fun logout()
}
