package com.example.flashcardquizapp.view.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(
    modifier: Modifier = Modifier,
    topBarText: String
) {

    TopAppBar(
        title = {
            Text(
                text = topBarText,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF2E6EFF),
            titleContentColor = Color.White
        )
    )

}