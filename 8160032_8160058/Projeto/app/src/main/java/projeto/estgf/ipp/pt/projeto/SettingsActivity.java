package projeto.estgf.ipp.pt.projeto;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {


    private CheckBox checkbox;
    private Context context;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context=this;
        checkbox = (CheckBox) findViewById(R.id.radioButtonNotificacao);
        settings= PreferenceManager.getDefaultSharedPreferences(this);
        boolean temp = settings.getBoolean("notificacao",true);
        checkbox.setChecked(temp);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                SharedPreferences.Editor editor= settings.edit();

                editor.putBoolean("notificacao",checked);
                editor.apply();
            }
        });

    }
}
