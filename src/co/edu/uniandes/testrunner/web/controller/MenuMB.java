package co.edu.uniandes.testrunner.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.testrunner.web.transversal.WebConstants;

@ManagedBean
@ViewScoped
public class MenuMB {

	private String testCasesHeader = WebConstants.TEST_CASES_HEADER;
	private String reportsHeader = WebConstants.REPORT_HEADER;
	private String aboutHeader = WebConstants.ABOUT_HEADER;

	@PostConstruct
	void init() {
		System.out.println("Bean Up!!!");
	}

	public String getTestCasesHeader() {
		return testCasesHeader;
	}

	public void setTestCasesHeader(String testCasesHeader) {
		this.testCasesHeader = testCasesHeader;
	}

	public String getReportsHeader() {
		return reportsHeader;
	}

	public void setReportsHeader(String reportsHeader) {
		this.reportsHeader = reportsHeader;
	}

	public String getAboutHeader() {
		return aboutHeader;
	}

	public void setAboutHeader(String aboutHeader) {
		this.aboutHeader = aboutHeader;
	}

}