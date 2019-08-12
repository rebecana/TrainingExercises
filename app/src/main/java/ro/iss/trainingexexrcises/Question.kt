package ro.iss.trainingexexrcises

import com.google.gson.annotations.SerializedName

class Question(
    @SerializedName("questionId") var questionId : Int?,
    @SerializedName("question") var question : String?,
    @SerializedName("answers") var answers : ArrayList<String>)
