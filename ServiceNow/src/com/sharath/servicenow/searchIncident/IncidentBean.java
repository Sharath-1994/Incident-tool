package com.sharath.servicenow.searchIncident;

public class IncidentBean {

	private int incidentNumber;
	private	String incidentReportedUser;
	private long contactNumber;
	private String applicationImpacted;
	private String incidentStatus;
	private String shortDesciption;
	private String incidentPriority;
	

	@Override
	public String toString() {
		return  incidentNumber + " " + incidentReportedUser+ " " + contactNumber + " " + applicationImpacted + " " + incidentStatus + 
				" "+ shortDesciption + " " + incidentPriority ;
	}

	public int getIncidentNumber() {
		return incidentNumber;
	}

	public void setIncidentNumber(int incidentNumber) {
		this.incidentNumber = incidentNumber;
	}

	public String getIncidentReportedUser() {
		return incidentReportedUser;
	}

	public void setIncidentReportedUser(String incidentReportedUser) {
		this.incidentReportedUser = incidentReportedUser;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getApplicationImpacted() {
		return applicationImpacted;
	}

	public void setApplicationImpacted(String applicationImpacted) {
		this.applicationImpacted = applicationImpacted;
	}

	public String getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public String getShortDesciption() {
		return shortDesciption;
	}

	public void setShortDesciption(String shortDesciption) {
		this.shortDesciption = shortDesciption;
	}

	public String getIncidentPriority() {
		return incidentPriority;
	}

	public void setIncidentPriority(String incidentPriority) {
		this.incidentPriority = incidentPriority;
	}
}
