package com.example.tasklist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddTaskActivity extends AppCompatActivity {

    DBHelper dbHelper;
    TaskDAO tasksDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tasksDAO = new TaskDAO(this);



        EditText edit_title = findViewById(R.id.txt_task_name);
        AppCompatImageButton btn_add_task = findViewById(R.id.btn_add_task);


        btn_add_task.setOnClickListener(v -> {
            String taskName = edit_title.getText().toString().trim();
            Toast.makeText(this,"teste",Toast.LENGTH_SHORT).show();

            tasksDAO.addTask(taskName);
            finish();

        });


    }
}