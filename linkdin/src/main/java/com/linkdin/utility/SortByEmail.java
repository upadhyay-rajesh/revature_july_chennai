package com.linkdin.utility;

import java.util.Comparator;

import com.linkdin.entity.LinkdinUser;

public class SortByEmail implements Comparator<LinkdinUser>{

	@Override
	public int compare(LinkdinUser o1, LinkdinUser o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
