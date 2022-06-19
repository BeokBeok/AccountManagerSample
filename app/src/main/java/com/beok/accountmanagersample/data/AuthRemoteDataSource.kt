package com.beok.accountmanagersample.data

interface AuthRemoteDataSource {

    fun token(email: String, password: String): String
}
