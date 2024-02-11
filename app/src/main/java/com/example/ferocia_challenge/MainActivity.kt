package com.example.ferocia_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ferocia_challenge.features.home.HomeScreen
import com.example.ferocia_challenge.ui.theme.Ferocia_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            Ferocia_challengeTheme {
                HomeScreen()
            }
        }
    }
}