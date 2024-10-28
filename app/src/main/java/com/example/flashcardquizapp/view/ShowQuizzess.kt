package com.example.flashcardquizapp.view

/*
@Composable
fun ShowQuizzes(
    modifier: Modifier = Modifier,
    question: String,
    answer: String
) {

    var showAnswer by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question,
            fontSize = 26.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "First Guess the Answer.",
            fontSize = 23.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                showAnswer = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF2C6EFF)
            )
        ) {
            Text(text = "Show Answer")

        }

        Spacer(modifier = Modifier.height(8.dp))

        if (showAnswer){
            Text(
                text = answer,
                fontSize = 23.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,

                )
        }


        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Are you guess it, ",
            fontSize = 23.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { */
/*TODO*//*
 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF2C6EFF)
                )
            ) {
                Text(text = "Right")
            }
            Button(
                onClick = { */
/*TODO*//*
 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF2C6EFF)
                )
            ) {
                Text(text = "Wrong")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { */
/*TODO*//*
 },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF2C6EFF)
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(250.dp)
        ) {
            Text(text = "Next")
        }


    }

}
*/

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashcardquizapp.view.components.ScreenTopBar
import com.example.flashcardquizapp.viewModel.FlashcardViewModel


@Composable
fun ShowQuizzes(viewModel: FlashcardViewModel, navController: NavController) {
    val flashcards by viewModel.flashcards.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var totalQuestions by remember { mutableStateOf(0) }
    var quizComplete by remember { mutableStateOf(false) }


        Column(

        ) {
            if (flashcards.isEmpty()) {
                Text(text = "No flashcards available. Please add some.")
            } else if (quizComplete) {
                // Show final score
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Quiz Complete! Your score: $score out of $totalQuestions")
                    Box(contentAlignment = Alignment.Center) {
                        Button(
                            onClick = { navController.navigate("mainScreen") }
                        ) {
                            Text("Back to Main Menu")
                        }
                    }
                }
            } else {
                val currentFlashcard = flashcards[currentIndex]
            
            ScreenTopBar(modifier = Modifier.weight(4f),topBarText = "Quiz Yourself.")

            Column(
                modifier = Modifier.weight(2f).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Text(text = currentFlashcard.question, fontSize = 24.sp)

                if (!showAnswer) {
                    Text(text = "Guess the answer!!", color = Color.White)
                }


                if (showAnswer) {
                    Text(
                        text = currentFlashcard.answer,
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Are you Guess it:")
                    Spacer(modifier = Modifier.height(6.dp))
                    // Buttons for user to guess
                    Row(
                        modifier = Modifier.padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                score++ // Increment score for correct guess
                                totalQuestions++
                                currentIndex++
                                showAnswer = false
                                if (currentIndex >= flashcards.size) {
                                    quizComplete = true
                                }
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C6EFF))
                        ) {
                            Text("Right", color = Color.White)
                        }

                        Button(
                            onClick = {
                                totalQuestions++
                                currentIndex++
                                showAnswer = false
                                if (currentIndex >= flashcards.size) {
                                    quizComplete = true
                                }
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C6EFF))
                        ) {
                            Text("Wrong", color = Color.White)
                        }
                    }
                } else {
                    Button(
                        onClick = {
                            showAnswer = true
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Show Answer")
                    }
                }

                // Next button only shows when answer is displayed
                if (showAnswer) {
                    Button(
                        onClick = {
                            currentIndex++
                            showAnswer = false
                            if (currentIndex >= flashcards.size) {
                                quizComplete = true
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
                    ) {
                        Text("Next")
                    }
                }
            }
            

        }
    }
}
