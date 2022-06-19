package com.beok.accountmanagersample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beok.accountmanagersample.ui.theme.AccountManagerSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AccountManagerSampleTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "이메일") }
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "패스워드") }
                    )
                    Button(onClick = {
                        viewModel.login(email, password)
                    }) {
                        Text(text = "로그인")
                    }
                    Button(onClick = {
                        Toast.makeText(this@MainActivity, viewModel.token(), Toast.LENGTH_SHORT)
                            .show()
                    }) {
                        Text(text = "토큰 조회")
                    }
                    Button(onClick = { viewModel.logout() }) {
                        Text(text = "로그아웃")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AccountManagerSampleTheme {
    }
}
