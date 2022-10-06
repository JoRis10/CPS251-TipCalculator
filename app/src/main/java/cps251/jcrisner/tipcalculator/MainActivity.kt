package cps251.jcrisner.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cps251.jcrisner.tipcalculator.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.displayText.text = "Tip amounts will display here"
    }
    fun getTip(view: View) {
        var convert : Double
        var returnText = ""
        if(binding.inputAmount.text.isNotEmpty()){
            try{
                convert = binding.inputAmount.text.toString().toDouble()
                val ten = String.format("%.2f", convert + (convert * .1))
                val fifteen = String.format("%.2f", convert + (convert * .15))
                val twenty = String.format("%.2f", convert + (convert * .2))
                returnText = "The tips are as follows:\n10% = \$$ten\n15% = \$$fifteen\n20% = \$$twenty"
            }
            catch(e: Exception){
                returnText = "A BILL AMOUNT MUST BE ENTERED"
            }
        }
        else{
            returnText = "A BILL AMOUNT MUST BE ENTERED"
        }
        binding.displayText.text = returnText
    }

}