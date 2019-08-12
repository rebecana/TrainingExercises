package ro.iss.trainingexexrcises

import io.reactivex.Observable
import retrofit2.http.GET


interface QuizMethods {
    @GET(value = "training-feedback/v1/questions")
    fun getQuestions() : Observable<ArrayList<Question>>
}