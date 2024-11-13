package com.example.aviapicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateFrom = findViewById<EditText>(R.id.date_from)
        val dateTo = findViewById<EditText>(R.id.date_to)

        dateFrom.setOnClickListener { showDatePickerDialog(dateFrom) }
        dateTo.setOnClickListener { showDatePickerDialog(dateTo) }
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                editText.setText(date)
            },
            year, month, day
        )

        datePickerDialog.show()
    }
}