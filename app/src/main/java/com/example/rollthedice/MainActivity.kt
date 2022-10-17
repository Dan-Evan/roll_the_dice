package com.example.rollthedice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the main class that holds the main activities in the
 * app and allows for processing and displaying results from the
 * dice roll
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Runs a random dice roll at the start of app
        rollDice()
    }

    /**
     * Rolls the dice and updates the results and displays
     * it to the user screen
     */
    private fun rollDice() {
        // Creates a new dice object with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()// "rolls one of the dice"

        // Creates a new dice object with 6 sides
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()// "rolls one of the dice"

        // Adds the to rolled values to give a sum
        val diceSum = diceRoll + diceRoll2

        // Determines which image to display based on the rolled results
        val drawableResources = when (diceRoll) {
            1 -> R.drawable.dice_01
            2 -> R.drawable.dice_02
            3 -> R.drawable.dice_03
            4 -> R.drawable.dice_04
            5 -> R.drawable.dice_05
            else -> R.drawable.dice_06
        }

        // Determines which image to display based on the rolled results
        val drawableResources2 = when (diceRoll2) {
            1 -> R.drawable.dice_01
            2 -> R.drawable.dice_02
            3 -> R.drawable.dice_03
            4 -> R.drawable.dice_04
            5 -> R.drawable.dice_05
            else -> R.drawable.dice_06
        }

        // Finds the image that matches the rolled results
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(drawableResources)

        //updates content description for image
        diceImage.contentDescription = diceRoll.toString()

        // Finds the image that matches the rolled results
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        diceImage2.setImageResource(drawableResources2)

        //updates content description for image
        diceImage.contentDescription = diceRoll2.toString()

        // Updates the screen with the sum of the displayed dices
        val sumTextView: TextView = findViewById(R.id.textView)
        sumTextView.text = diceSum.toString()

    }

}

/**
 * Public class for a dice object that has a function
 * to generate a random number within the range of the number of sides
 * */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}