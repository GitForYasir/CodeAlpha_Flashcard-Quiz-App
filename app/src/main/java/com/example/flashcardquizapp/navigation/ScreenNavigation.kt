package com.example.flashcardquizapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flashcardquizapp.view.AddFlashcard
import com.example.flashcardquizapp.view.MainScreen
import com.example.flashcardquizapp.view.ShowQuizzes
import com.example.flashcardquizapp.viewModel.FlashcardViewModel

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: FlashcardViewModel) {
    NavHost(navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable("addFlashCard") { AddFlashcard(viewModel, navController) }
        composable("showQuizzes") { ShowQuizzes(viewModel, navController) }
    }
}



/*
@Composable
fun ScreenNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main"){
        composable("main") {
            MainScreen(navController)
        }

        composable("addFlashCard") {
            AddFlashcard()
        }

        composable("showQuizzes") {
            ShowQuizzes(question = "What is What", answer = "What is What")
        }
    }

}*/


