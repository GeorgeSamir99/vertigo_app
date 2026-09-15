package com.georgeayad.vertigoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.georgeayad.vertigoapp.ui.theme.AppTheme.colors
import com.georgeayad.vertigoapp.ui.theme.AppTheme.dimens
import com.georgeayad.vertigoapp.ui.theme.AppTheme.typography
import com.georgeayad.vertigoapp.ui.theme.PreviewContainer
import com.georgeayad.vertigoapp.ui.theme.Previews
import com.georgeayad.vertigoapp.ui.theme.VertigoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VertigoTheme {
                SplashContent()
            }
        }
    }
}

@Composable
fun SplashContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colors.onBackground)) {
                    append("VERTIGO")
                }
                withStyle(style = SpanStyle(color = colors.primary)) {
                    append("AI")
                }
            },
            style = typography.headlineLarge
        )

        Text(
            text = "CREATE CINEMATIC DOLLY ZOOMS IN SECONDS",
            color = colors.onSurfaceVariant,
            style = typography.bodySmall,
            modifier = Modifier.padding(top = dimens.small)
        )
    }
}

@Previews
@Composable
private fun Preview() {
    PreviewContainer {
        SplashContent()
    }
}