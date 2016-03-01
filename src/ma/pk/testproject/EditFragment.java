package ma.pk.testproject;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditFragment extends DialogFragment implements onDialogEventListener {

	private EditText mEditText;
	private Button btn_add;

	public EditFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialogedit, container);
		mEditText = (EditText) view.findViewById(R.id.txt_name);
		btn_add = (Button) view.findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				onAddClick();
			}
		});
		getDialog().setTitle("Add Person");

		return view;
	}

	@Override
	public void onAddClick() {
		// TODO Auto-generated method stu
		OnEventOnActivityListener listener = (OnEventOnActivityListener) getActivity();
		listener.onFinishAction((mEditText.getText().toString()));
		this.dismiss();

	}
}