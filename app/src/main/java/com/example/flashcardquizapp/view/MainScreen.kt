package com.example.flashcardquizapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashcardquizapp.view.components.ScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {




    Column(
        modifier = Modifier.fillMaxSize()
    ){

        ScreenTopBar(topBarText = "Flashcard Quiz App")

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedButton(
                onClick = {
                    navController.navigate("addFlashCard")
                },
                modifier = Modifier
                    .size(180.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2C6EFF)
                )
            ) {
                Text(
                    text = "Add Flashcard",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )

            }



            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("showQuizzes")
                },
                modifier = Modifier
                    .size(180.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2C6EFF)
                )
            ) {
                Text(
                    text = "Quiz Flashcard",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )

            }
        }
    }


}

@Preview
@Composable
fun Livens() {

//    MainScreen(navController = NavController(@MainThread))

}