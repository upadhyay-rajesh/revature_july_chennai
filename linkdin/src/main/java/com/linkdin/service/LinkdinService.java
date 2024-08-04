package com.linkdin.service;

import java.util.List;

import com.linkdin.dao.LinkdinDAO;
import com.linkdin.dao.LinkdinDAOInterface;
import com.linkdin.entity.LinkdinUser;

public class LinkdinService implements LinkdinServiceInterface {

	@Override
	public int createProfileService(LinkdinUser lu) {
		LinkdinDAOInterface ld=new LinkdinDAO();
		return ld.createProfileDAO(lu);
	}

	@Override
	public LinkdinUser viewProfileService(LinkdinUser lu) {
		LinkdinDAOInterface ld=new LinkdinDAO();
		return ld.viewProfileDAO(lu);
	}

	@Override
	public List<LinkdinUser> viewAllProfileService() {
		LinkdinDAOInterface ld=new LinkdinDAO();
		return ld.viewAllProfileDAO();
	}

	@Override
	public int editProfileService(LinkdinUser lu) {
		LinkdinDAOInterface ld=new LinkdinDAO();
		return ld.editProfileDAO(lu); 
	}

	@Override
	public int deleteProfileService(LinkdinUser lu) {
		LinkdinDAOInterface ld=new LinkdinDAO();
		return ld.deleteProfileDAO(lu);
	}

}









