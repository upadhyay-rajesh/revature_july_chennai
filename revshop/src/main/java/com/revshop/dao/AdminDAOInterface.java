package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Buyer;
import com.revshop.entity.Complains;
import com.revshop.entity.Retailer;

public interface AdminDAOInterface {
	List<Buyer> ViewAllUsersDAO();
	List<Retailer> viewAllretailersDAO();
	List<Buyer> manageUsersDAO();
	List<Retailer> manageRetailersDAO();
	List<Complains> viewComplaintsDAO();
	List<Retailer> viewAllTheRegistrationRequestsSubmittedByTheSellersDAO();
}
