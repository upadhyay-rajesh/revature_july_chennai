package com.linkdin.dao;

import java.util.List;

import com.linkdin.entity.LinkdinUser;

public interface LinkdinDAOInterface {

	int createProfileDAO(LinkdinUser lu);

	LinkdinUser viewProfileDAO(LinkdinUser lu);

	List<LinkdinUser> viewAllProfileDAO();

	int editProfileDAO(LinkdinUser lu);

	int deleteProfileDAO(LinkdinUser lu);

}
