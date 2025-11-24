package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> tasks;
    private TaskDAO tasksDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tasks = new ArrayList<Task>();
        tasksDAO = new TaskDAO(this);
        recyclerView = findViewById(R.id.recycler_tasks);

        Intent intent = new Intent(this, AddTaskActivity.class);

        FloatingActionButton btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> {
            startActivity(intent);
        });
    }

    protected void onResume(){
        super.onResume();
        fetchTasks();
    }

    private void fetchTasks(){
        tasks.clear();
        tasks.addAll(tasksDAO.getTasks());

        taskAdapter = new TaskAdapter(tasks);

        taskAdapter.setOnItemClickListener(task -> { //EDIT TASK NOT IMPLEMENTED YET
            Toast.makeText(MainActivity.this, "Editar: " + task.getId(), Toast.LENGTH_SHORT).show();
        });

        taskAdapter.setOnItemLongClickListener(task -> {
            Toast.makeText(MainActivity.this, "Remover: " + task.getId(), Toast.LENGTH_SHORT).show();
            tasksDAO.deleteTask(task.getId());
            fetchTasks();
        });

        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
