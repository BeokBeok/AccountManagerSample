package com.beok.accountmanagersample.ui

import androidx.lifecycle.ViewModel
import com.beok.accountmanagersample.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    fun login(email: String, password: String) {
        repository.login(email, password)
    }

    fun token(): String {
        return repository.token()
    }

    fun logout() {
        repository.logout()
    }
}
