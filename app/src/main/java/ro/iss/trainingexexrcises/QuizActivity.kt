package ro.iss.trainingexexrcises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var quizAdapter : QuitAdapter
    private lateinit var observableGetQuestions : Observable<ArrayList<Question>>
    private lateinit var apiCallDisposableGetQuestions : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        configurationToolbar()
        getQuestionsList()
    }
    private fun configurationToolbar() {
        quiz_toolbar.title = "Submit answers"
        setSupportActionBar(quiz_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
    private fun getQuestionsList() {
//        val questionsList = ArrayList<Question>()
//        for (i in 0 until 10) {
//            val answers = arrayListOf("Answers 1", "Answers 2", "Answers 3", "Answers 4")
//            questionsList.add(Question(i, "Question $i", answers))
//        }
//        return questionsList

        observableGetQuestions = RetrofitCall.getQuestions()
        apiCallDisposableGetQuestions = observableGetQuestions.subscribe(
            {response ->
                setQuestionsList(response)
            },
            { setErrorMessage()},
            {apiCallDisposableGetQuestions.dispose()}
        )
    }
    private fun setQuestionsList(questions: ArrayList<Question>) {
        views_list.visibility = View.VISIBLE
        error_text_message.visibility = View.GONE

        quizAdapter = QuitAdapter(questions,this)
        views_list.adapter = quizAdapter
        views_list.layoutManager = LinearLayoutManager( this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) [android.R.id.home --> onBackPressed()]
        return super.onOptionsItemSelected(item)
    }
    private fun setErrorMessage() {
        views_list.visibility = View.GONE
        error_text_message.visibility = View.VISIBLE
    }
}



