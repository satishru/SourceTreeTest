package com.example.mvptask.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.mvptask.R;
import com.example.mvptask.model.BankDetails;
import com.example.mvptask.model.BankDetailsChildList;
import com.example.mvptask.utils.CommonUtils;

import java.util.List;

public class AccountAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<BankDetails> dataList;

    /**
     *
     * @param mContext
     * @param dataList
     */
    public AccountAdapter(Context mContext, List<BankDetails> dataList) {
        inflater = LayoutInflater.from(mContext);
        this.dataList = dataList;
    }

    /**
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parentView
     * @return parent view
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parentView) {
        final BankDetails bankDetail = dataList.get(groupPosition);
        final GroupViewHolder groupViewholder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.row_account_parent, parentView, false);
            groupViewholder= new GroupViewHolder(convertView);
            convertView.setTag(groupViewholder);
        }else {
            groupViewholder = (GroupViewHolder) convertView.getTag();
        }
        groupViewholder.text_name_parent.setText(bankDetail.getName());
        groupViewholder.text_amount_parent.setText(bankDetail.getCurrencySymbol()+
                CommonUtils.formatDecimal(bankDetail.getAmount()));

        /**
         * Comment this lines if Expand/Collapse is needed
         */
        ExpandableListView eLV = (ExpandableListView) parentView;
        eLV.expandGroup(groupPosition);

        return convertView;
    }

    /**
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parentView
     * @return child view
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parentView) {
        final BankDetailsChildList bankDetailChild = dataList.get(groupPosition).getAccountChildDetails().get(childPosition);
        final ChildViewHolder childViewholder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.row_account_child, parentView, false);
            childViewholder= new ChildViewHolder(convertView);
            convertView.setTag(childViewholder);
        }else {
            childViewholder = (ChildViewHolder) convertView.getTag();
        }

        childViewholder.text_child_name.setText(bankDetailChild.getNameChild());
        childViewholder.text_frost_id.setText(bankDetailChild.getFrostId());
        childViewholder.text_amount.setText(bankDetailChild.getCurrencySymbol()+
                CommonUtils.formatDecimal(bankDetailChild.getAmount()));

        return convertView;
    }

    /**
     *
     * @param groupPosition
     * @param childPosition
     * @return child object
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return dataList.get(groupPosition).getAccountChildDetails().get(childPosition);
    }

    /**
     *
     * @param groupPosition
     * @param childPosition
     * @return child view id
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     *
     * @param groupPosition
     * @return child list count
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        int size=0;
        if(dataList.get(groupPosition).getAccountChildDetails()!=null)
            size = dataList.get(groupPosition).getAccountChildDetails().size();
        return size;
    }


    /**
     *
     * @param groupPosition
     * @return parent object
     */
    @Override
    public Object getGroup(int groupPosition) {
        return dataList.get(groupPosition);
    }

    /**
     *
     * @return list size
     */
    @Override
    public int getGroupCount() {
        return dataList.size();
    }

    /**
     *
     * @param groupPosition
     * @return parent view id
     */
    @Override
    public long getGroupId(int groupPosition)  {
        return groupPosition;
    }

    /**
     * Refresh Adapter
     */
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    /**
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return ((dataList == null) || dataList.isEmpty());
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    /**
     * View holder for Main Group List
     */
    public final class GroupViewHolder {
        private TextView text_name_parent;
        private TextView text_amount_parent;

        public GroupViewHolder(View view) {
            text_name_parent   =  view.findViewById(R.id.text_name_parent);
            text_amount_parent =  view.findViewById(R.id.text_amount_parent);
        }
    }

    /**
     * View holder for Sub Group List
     */
    public final class ChildViewHolder {
        private TextView text_child_name;
        private TextView text_frost_id ;
        private TextView text_amount;

        public ChildViewHolder(View view) {
            text_child_name =  view.findViewById(R.id.text_child_name);
            text_frost_id =  view.findViewById(R.id.text_frost_id);
            text_amount =  view.findViewById(R.id.text_amount);
        }
    }
}

