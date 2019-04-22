package yaros.com.textrpg.Ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;

public class InformationFragment extends Fragment {

    static int informNum;

    public static ArrayList<TextView> informations;

    public final int DIALOG_ADD = 1;
    public final int DIALOG_DELETE = 2;
    public final int DIALOG_MOVETO = 3;

    public static FloatingActionButton moveToButton;

    public static EditText moveToEditText;

    static EditText editText;

    static int selectToDeleteTvNum;

    public static final String TAG = "InformationFragment";

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
        AlertDialog alertDialogDelete =  onCreateDialog(DIALOG_DELETE);
        AlertDialog alertDialogMoveTo = onCreateDialog(DIALOG_MOVETO);

        moveToButton = getView().findViewById(R.id.moveToFloatingActionButton);
        moveToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogMoveTo.show();
            }
        });

        informations = new ArrayList<TextView>(15);
        for (int i = 0; i < 15; i++) {
            informations.add(getView().findViewById(this.getResources().getIdentifier(("informationText" + i),
                    "id", getContext().getPackageName())));
            informations.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectToDeleteTvNum = informations.indexOf(v);
                    alertDialogDelete.show();
                }
            });
        }

        FloatingActionButton fab = getView().findViewById(R.id.informationFloatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (informNum < 14) {
                    alertDialog.show();
                } else {
                    Toast.makeText(getContext(), "Максимум заметок", Toast.LENGTH_SHORT).show();
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
            EditText dialogEditText = new EditText(getContext());
            adb.setView(dialogEditText);
            editText = dialogEditText;
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_positive_button, myClickListener);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListener);
            return adb.create();
        }else if (id == DIALOG_DELETE) {
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setMessage(R.string.information_delete_dialog_title);
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_delete_negative_button, myClickListenerDeleteDialog);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListenerDeleteDialog);
            return adb.create();
        }else if (id == DIALOG_MOVETO){
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setMessage(R.string.dialog_move_to_message);
            adb.setIcon(R.drawable.ic_arrow_24dp);
            adb.setPositiveButton(R.string.dialog_move_to_positive_button, myClickListenerMoveToDialog);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListenerMoveToDialog);
            EditText dialogEditText = new EditText(getContext());
            dialogEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
            adb.setView(dialogEditText);
            moveToEditText = dialogEditText;
            return adb.create();
        }
        return onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    if (!editText.getText().toString().equals("")) {
                        informations.get(informNum).setVisibility(View.VISIBLE);
                        informations.get(informNum).setText(editText.getText());
                        informNum++;
                    }
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };

    DialogInterface.OnClickListener myClickListenerDeleteDialog = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    for (int i = selectToDeleteTvNum; i < 14; i++){
                        informations.get(i).setText(informations.get(i + 1).getText());
                    }
                    informNum--;
                    informations.get(informNum).setText("");
                    informations.get(informNum).setVisibility(View.GONE);
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };

    DialogInterface.OnClickListener myClickListenerMoveToDialog = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    if (Integer.parseInt(moveToEditText.getText().toString()) > 617 || Integer.parseInt(moveToEditText.getText().toString()) < 0){
                        Toast.makeText(getContext(), "Такой главы нет", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    PageFragment pageFragment = (PageFragment) getActivity().getSupportFragmentManager().findFragmentByTag(PageFragment.TAG);
                    pageFragment.Update(Integer.parseInt(moveToEditText.getText().toString()));
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };
}
