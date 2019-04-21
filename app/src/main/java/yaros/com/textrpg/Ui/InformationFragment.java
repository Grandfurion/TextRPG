package yaros.com.textrpg.Ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.R;

public class InformationFragment extends Fragment {

    static int informNum;

    public static ArrayList<TextView> informations;

    public final int DIALOG_ADD = 1;

    public static final String TAG = "InformationFragment";

    EditText ed;

    public static InformationFragment create() {
        return new InformationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.infromation_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        informNum = 0;

        AlertDialog alertDialog = onCreateDialog(DIALOG_ADD);

        informations = new ArrayList<TextView>(15);
        for (int i = 0; i < 15; i++) {
            informations.add(getView().findViewById(this.getResources().getIdentifier(("informationText" + i),
                    "id", getContext().getPackageName())));
        }

        FloatingActionButton fab = getView().findViewById(R.id.informationFloatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (informNum < 15) {
                    alertDialog.show();
                } else {
                    Toast.makeText(getContext(), "максимум заметок", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //CODE
        super.onViewCreated(view, savedInstanceState);
    }

    protected AlertDialog onCreateDialog(int id) {
        if (id == DIALOG_ADD) {
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setTitle(R.string.information_dialog_title);
            adb.setMessage(R.string.information_dialog_message);
            ed = getView().findViewById(R.id.input);
            adb.setView(ed);
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_positive_button, myClickListener);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListener);
            return adb.create();
        }
        return onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    informations.get(informNum).setVisibility(View.VISIBLE);
                    informations.get(informNum).setText(ed.getText());
                    informNum++;
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };
}
