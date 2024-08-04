package com.linkdin.service;

import java.util.List;

import com.linkdin.entity.LinkdinUser;

public interface LinkdinServiceInterface {

	int createProfileService(LinkdinUser lu);

	LinkdinUser viewProfileService(LinkdinUser lu);

	List<LinkdinUser> viewAllProfileService();

	int editProfileService(LinkdinUser lu);

	int deleteProfileService(LinkdinUser lu);

}
