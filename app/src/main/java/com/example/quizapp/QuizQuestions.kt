package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {
    private var currentPosition : Int = 0
    private var QuestionsList : ArrayList<Question>? = null
    private var SelectedOptionPosition : Int = 0
    private var noOfCorrectAnswers : Int = 0

    private var progressbar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvquestion : TextView? = null
    private var tvImage : ImageView? = null

    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var submit : Button? = null

    private var mUserName : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressbar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.progressValue)
        tvquestion = findViewById(R.id.Questions)
        tvImage = findViewById(R.id.image)
        option1 = findViewById(R.id.optionOne)
        option2 = findViewById(R.id.optionTwo)
        option3 = findViewById(R.id.optionThree)
        option4 = findViewById(R.id.optionFour)
        submit = findViewById(R.id.submit)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submit?.setOnClickListener(this)

        QuestionsList = Constants.getQuestions()
        setQuestions()
        defaultOptions()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestions() {
        defaultOptions()
        val question: Question = QuestionsList!![currentPosition]
        progressbar?.progress = currentPosition
        tvProgress?.text = "$currentPosition/${progressbar?.max}"
        tvquestion?.text = question.questions
        tvImage?.setImageResource(question.image)
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour

        if(currentPosition == QuestionsList!!.size){
            submit?.text = "FINISH"
        }else{
            submit?.text = "SUBMIT"
        }
    }
    private fun defaultOptions(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.border
            )
        }
    }
    private fun selectedOptionView(tv : TextView,selectedNum : Int){
        defaultOptions()

        SelectedOptionPosition = selectedNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
        R.drawable.selectedoption)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                option1?.let {
                    selectedOptionView(it,1)
                }
            }

            R.id.optionTwo -> {
                option2?.let {
                    selectedOptionView(it,2)
                }
            }

            R.id.optionThree -> {
                option3?.let {
                    selectedOptionView(it,3)
                }
            }

            R.id.optionFour -> {
                option4?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.submit ->{
                    if(SelectedOptionPosition == 0){
                        currentPosition++

                        when{
                            currentPosition  < QuestionsList!!.size ->{
                                setQuestions()
                            }else->{
                                val intent = Intent(this,ResultsActivity::class.java)
                                intent.putExtra(Constants.USER_NAME,mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWER,noOfCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTION,QuestionsList!!.size)
                                startActivity(intent)
                                finish()
                                Toast.makeText(this,"You Made it to the end",Toast.LENGTH_LONG).show()
                            }
                        }
                    }else{
                        val question = QuestionsList?.get(currentPosition)

                        if(question!!.correctAnswer != SelectedOptionPosition){
                            answerView(SelectedOptionPosition,R.drawable.wrong_border)
                        }else {
                            noOfCorrectAnswers++;
                            answerView(question.correctAnswer, R.drawable.correct_border)
                        }
                        if(currentPosition == QuestionsList!!.size - 1){
                            submit?.text = "FINISH"
                        }else{
                            submit?.text = "NEXT QUESTION"
                        }
                        SelectedOptionPosition = 0
                    }
            }
        }
    }

    private fun answerView(answer : Int,drawableView : Int){
        when(answer){
            1 -> {
                option1?.background = ContextCompat.getDrawable(this,drawableView)
            } 2 -> {
                option2?.background = ContextCompat.getDrawable(this,drawableView)
            } 3 -> {
                option3?.background = ContextCompat.getDrawable(this,drawableView)
            } 4 -> {
                option4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}