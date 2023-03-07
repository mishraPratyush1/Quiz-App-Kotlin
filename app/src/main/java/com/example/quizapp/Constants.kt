package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answer"
    fun getQuestions(): ArrayList<Question> {
        val QuestionsList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "India",
            "Australia",
            "Kenya",
            1
        )
        val ques2 = Question(
            2,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia",
            "India",
            "Argentina",
            "Kenya",
            1
        )
        val ques3 = Question(
            3,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "belgium",
            "Australia",
            "Kenya",
            2
        )
        val ques4 = Question(
            4,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "India",
            "Australia",
            "brazil",
            4
        )
        val ques5 = Question(
            5,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "denmark",
            "India",
            "Australia",
            "Kenya",
            1
        )
        val ques6 = Question(
            6,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "fiji",
            "Australia",
            "Kenya",
            2
        )
        val ques7 = Question(
            7,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Argentina",
            "India",
            "Australia",
            "germany",
            4
        )
        val ques8 = Question(
            8,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "India",
            "Australia",
            "Kenya",
            2
        )
        val ques9 = Question(
            9,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "kuwait",
            "India",
            "Australia",
            "Kenya",
            1
        )
        val ques10 = Question(
            10,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "India",
            "Australia",
            "new zealand",
            4
        )

        QuestionsList.add(ques1)
        QuestionsList.add(ques2)
        QuestionsList.add(ques3)
        QuestionsList.add(ques4)
        QuestionsList.add(ques5)
        QuestionsList.add(ques6)
        QuestionsList.add(ques7)
        QuestionsList.add(ques8)
        QuestionsList.add(ques9)
        QuestionsList.add(ques10)

        return QuestionsList
    }
}