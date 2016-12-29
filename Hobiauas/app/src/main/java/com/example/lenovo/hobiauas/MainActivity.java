package com.example.lenovo.hobiauas;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button submit;
    EditText Email;
    EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.buttonSubmit);

        Email = (EditText) findViewById(R.id.emaillogin);
        Password = (EditText) findViewById(R.id.passwordlogin);

        submit.setOnClickListener(this);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itempertama, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.register:
                Intent selanjutnya = new Intent(MainActivity.this, Register.class);
                startActivity(selanjutnya);
                Toast.makeText(getApplicationContext(), "Menu  registrasi dipilih", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }




    }

    @Override
    public void onClick(View v) {

    }
}
