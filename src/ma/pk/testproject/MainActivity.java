package ma.pk.testproject;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity implements
		OnEventOnActivityListener {
	private String populatedJson = "{'person':[{firstname:'wasim',lastname:'akram'},{firstname:'Javed',lastname:'miandad'},{firstname:'Umer',lastname:'Gull'},{firstname:'Ahmed',lastname:'Shahzad'},{firstname:'Shahid',lastname:'Afridi'} ]}";
	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;
	private MyAdapter mAdapter;
	ImageButton btn_add;

	ArrayList<PersonDTO> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		btn_add = (ImageButton) findViewById(R.id.fab);

		btn_add.setOnClickListener(listener);
		list = new ArrayList<PersonDTO>();
		JSONObject jsonob;
		try {
			jsonob = new JSONObject(populatedJson);

			JSONArray obarray = jsonob.getJSONArray("person");

			for (int i = 0; i < obarray.length(); i++) {
				JSONObject personobj = obarray.getJSONObject(i);

				PersonDTO dto = new PersonDTO(Utils.getCamelCase(personobj
						.getString("firstname")), Utils.getCamelCase(personobj
						.getString("lastname")));
				list.add(dto);

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mRecyclerView = (RecyclerView) findViewById(R.id.mrecycler_view);

		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		mAdapter = new MyAdapter(list);
		mRecyclerView.setAdapter(mAdapter);
	}

	View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.fab:
				showEditDialog();

				break;

			default:
				break;
			}
		}
	};

	private void showEditDialog() {
		FragmentManager fm = getSupportFragmentManager();
		EditFragment editDialog = new EditFragment();
		editDialog.show(fm, "fragment_name");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onFinishAction(String string) {
;
		mAdapter.add(list.size(), Utils.parseName(string));
		mAdapter.notifyItemInserted(list.size());

	}
}
