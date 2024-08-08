package com.linkdin.utility;

import java.util.Comparator;

import com.linkdin.entity.LinkdinUser;

public class SortByName implements Comparator<LinkdinUser>{

	@Override
	public int compare(LinkdinUser o1, LinkdinUser o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
