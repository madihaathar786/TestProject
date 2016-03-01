package ma.pk.testproject;

import java.util.ArrayList;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private ArrayList<PersonDTO> mDataset;

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView txtHeader;

		public ViewHolder(View v) {
			super(v);
			txtHeader = (TextView) v.findViewById(R.id.text1);

		}
	}

	public void add(int position, PersonDTO item) {
		mDataset.add(position, item);
		notifyItemInserted(position);
	}

	public void remove(PersonDTO item) {
		int position = mDataset.indexOf(item);
		mDataset.remove(position);
		notifyItemRemoved(position);
	}

	public MyAdapter(ArrayList<PersonDTO> myDataset) {
		mDataset = myDataset;
	}

	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.simple_list_item_1, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String name = null;
		if (mDataset.get(position).getFirstname() != null
				&& mDataset.get(position).getLastname() != null)
			name = mDataset.get(position).getFirstname() + ", "
					+ mDataset.get(position).getLastname();
		else if (mDataset.get(position).getFirstname() != null
				&& mDataset.get(position).getLastname() == null)

			name = mDataset.get(position).getFirstname();

		holder.txtHeader.setText(name);

	}

	@Override
	public int getItemCount() {
		return mDataset.size();
	}

}
