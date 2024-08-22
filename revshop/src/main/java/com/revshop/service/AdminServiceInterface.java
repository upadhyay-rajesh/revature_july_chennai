package com.revshop.service;

import java.util.List;

import com.revshop.entity.Buyer;
import com.revshop.entity.Complains;
import com.revshop.entity.Retailer;

public interface AdminServiceInterface {
	List<Buyer> ViewAllUsers();
	List<Retailer> viewAllretailers();
	List<Buyer> manageUsers();
	List<Retailer> manageRetailers();
	List<Complains> viewComplaints();
	List<Retailer> viewAllTheRegistrationRequestsSubmittedByTheSellers();
}
