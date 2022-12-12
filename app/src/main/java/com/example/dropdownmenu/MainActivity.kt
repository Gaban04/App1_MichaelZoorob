package com.example.dropdownmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Spinner
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    //Two arrays are made for the spinners to have options.
    val droplist1= arrayOf("Sprite", "Coke")
    val droplist2= arrayOf("Banana", "Mentos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is for the pop up sheet that helps the user as a manual guide about the app.
        val popupsheet = PopUpSheet()

        //When the user clicks on the button that says "help", it will make the manual guide sheet pop up.
        help_btn.setOnClickListener {
            popupsheet.show(supportFragmentManager,"PopUpSheetDialog" )
        }

        //Adapters are made here to call for data and convert them into view items that can be displayed in the spinners.
        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, droplist1)
        val adapter2=ArrayAdapter(this, android.R.layout.simple_spinner_item, droplist2)

        //The "Done" button is given a variable of b1.
        var b1=findViewById(R.id.button) as Button

        //Adapters are made here to call for data and convert them into view items that can be displayed in the spinners.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        //Settings up the 1st spinner.
        chemical1.adapter=adapter
        chemical1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long)
            {
                if(chemical1.selectedItemPosition==0)
                {
                    component1.setText(" " + chemical1.selectedItem)
                }
                if(chemical1.selectedItemPosition==1)
                {
                    component1.setText(" " + chemical1.selectedItem)
                }
            }
        }

        //2nd spinner being setup.
        chemical2.adapter=adapter2
        chemical2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long)
            {
                if(chemical2.selectedItemPosition==0)
                {
                    component2.setText(" " + chemical2.selectedItem)

                }
                if(chemical2.selectedItemPosition==1)
                {
                    component2.setText(" " + chemical2.selectedItem)
                }
            }
        }

        //When the user clicks on the button after choosing from the spinners, it should display the text below based on the items that the user selected from the array.
        b1.setOnClickListener{
            if(chemical1.selectedItemPosition==0 && chemical2.selectedItemPosition==0)
            {
                result.setText("The outcome is a chemical reaction which is hazardous when consumed.")
            }
            if(chemical1.selectedItemPosition==0 && chemical2.selectedItemPosition==1)
            { result.setText("The outcome is erupting sprite with mentos.")}

            if(chemical1.selectedItemPosition==1 && chemical2.selectedItemPosition==0)
            {
                result.setText("The outcome is a chemical reaction which is hazardous when consumed.")
            }

            if(chemical1.selectedItemPosition==1 && chemical2.selectedItemPosition==1)
            {
                result.setText("The outcome is erupting coke with mentos.")
            }
        }
    }
}
