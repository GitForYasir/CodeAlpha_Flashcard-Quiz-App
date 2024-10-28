package com.example.flashcardquizapp.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashcardquizapp.model.db.QAEntity
import com.example.flashcardquizapp.view.components.ScreenTopBar
import com.example.flashcardquizapp.viewModel.FlashcardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddFlashcard(viewModel: FlashcardViewModel, navController: NavController) {
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        ScreenTopBar(topBarText = "Add Flashcard")


        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = question,
                onValueChange = { question = it },
                label = { Text(text = "Enter Question", color = Color.Black) },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text(text = "Enter Answer", color = Color.Black) },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = {
                    if (question.isNotEmpty() && answer.isNotEmpty()){
                        viewModel.insertFlashcard(QAEntity(question = question, answer = answer))
                        navController.navigate("mainScreen")
                    }
                },
                modifier = Modifier
                    .size(180.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C6EFF))
            ) {
                Text(
                    text = "Add Flashcard",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

