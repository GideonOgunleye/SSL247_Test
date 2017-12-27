package Smoke_Test;

import org.testng.annotations.DataProvider;
//import utilities.Constants;
//import utilities.ExcelUtility;
import org.testng.annotations.Test;

public class Test_DataSmoke {
	
	@DataProvider (name ="LoginUser")
	public static Object[][] LoginUser(){
		Object[][] obj = new Object[1][3];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1234";
		//Url
		obj[0][2]="Valid Credentilas";
		
		
		/*---------2st Parameter-------------
		//Username
		obj[1][0]="qa@ssl247.co.uk";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="Valid Credentilas";
		*/	
		
		/*---------2st Parameter-------------	
		//Username
		obj[2][0]="qa@ssl247.co.uk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[2][3]="UKTE001";
		//Column Product
		obj[2][4]="RapidSSL Pro";
		*/
		return obj;
		
	}
	
	@DataProvider (name ="AdminLogin")
	public static Object[][] AdminLogin(){
		Object[][] obj = new Object[2][5];
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="Uk Website";
		//Domain
		obj[1][1]="Url";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdInvalidPassword";
		//Url
		obj[1][4]="InValid Credentials";
		
		return obj;
		
	}
	
	@DataProvider (name ="AdminLoginAllSites")
	public static Object[][] AdminLoginAllSites(){
		Object[][] obj = new Object[1][5];
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		return obj;
		
	}
	
	@DataProvider (name ="ReissueCertificate")
	public static Object[][] ReissueCertificate(){
		Object[][] obj = new Object[1][5];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1234";
		//Url
		obj[0][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[0][3]="UKTE001";
		//Column Product
		obj[0][4]="Symantec Secure Site Pro EV";
		
		
		/*---------2st Parameter-------------
		//Username
		obj[1][0]="qa@ssl247.co.uk";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[1][3]="UKTE001";
		//Column Product
		obj[1][4]="Symantec Secure Site EV";
		*/	
		
		/*---------2st Parameter-------------	
		//Username
		obj[2][0]="qa@ssl247.co.uk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[2][3]="UKTE001";
		//Column Product
		obj[2][4]="RapidSSL Pro";
		*/
		return obj;
		
	}
	
	@DataProvider (name ="CreateUser")
	public static Object[][] CreateUser(){
		Object[][] obj = new Object[2][8];
		
		/*---------1st Parameter-------------*/	
		//Firstname
		obj[0][0]="Gideon";
		//Lastname
		obj[0][1]="Ogunleye1";
		//Email
		obj[0][2]="Gid1@ssl247-test.com";
		//Phone Number
		obj[0][3]="02037610541";
		//Address 1
		obj[0][4]="63 Lisson St, Marylebone";
		//State
		obj[0][5]="London";
		//Post code
		obj[0][6]="NW1 5DD";
		//Country
		obj[0][7]="United Kingdom";
		
		/*---------2nd Parameter-------------*/	
		//Firstname
		obj[1][0]="Gideon";
		//Lastname
		obj[1][1]="Ogunleye2";
		//Email
		obj[1][2]="Gid2@ssl247-test.com";
		//Phone Number
		obj[1][3]="02037610541";
		//Address 1
		obj[1][4]="63 Lisson St, Marylebone";
		//State
		obj[1][5]="London";
		//Post code
		obj[1][6]="NW1 5DD";
		//Country
		obj[1][7]="United Kingdom";

		
		return obj;
		
	}
	
	@DataProvider (name ="AdminLogin")
	public static Object[][] EditUserAllSites(){
		Object[][] obj = new Object[18][5];
		
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website-01";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="French Website-02";
		//Domain
		obj[1][1]="FrenchUrl";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdValidPassword";
		//Url
		obj[1][4]="Valid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="AE Website-03";
		//Domain
		obj[2][1]="AeUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="BE Website-04";
		//Domain
		obj[3][1]="BeUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdValidPassword";
		//Url
		obj[3][4]="Valid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="CL Website-05";
		//Domain
		obj[4][1]="ClUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="Com Website-06";
		//Domain
		obj[5][1]="ComUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdValidPassword";
		//Url
		obj[5][4]="Valid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="Com.Br Website-07";
		//Domain
		obj[6][1]="Com.brUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="Valid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="Com.co Website-08";
		//Domain
		obj[7][1]="Com.coUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdValidPassword";
		//Url
		obj[7][4]="Valid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="Com.mx Website-09";
		//Domain
		obj[8][1]="Com.mxUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="Valid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="Com.pe Website-10";
		//Domain
		obj[9][1]="Com.peUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdValidPassword";
		//Url
		obj[9][4]="Valid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="DE Website-11";
		//Domain
		obj[10][1]="DeUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="Valid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="DK Website-12";
		//Domain
		obj[11][1]="DkUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdValidPassword";
		//Url
		obj[11][4]="Valid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="ES Website-13";
		//Domain
		obj[12][1]="EsUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="Valid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="IE Website-14";
		//Domain
		obj[13][1]="IeUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdValidPassword";
		//Url
		obj[13][4]="Valid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="IT Website-15";
		//Domain
		obj[14][1]="ItUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="Valid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="NI Website-16";
		//Domain
		obj[15][1]="NlUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdValidPassword";
		//Url
		obj[15][4]="Valid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="PT Website-17";
		//Domain
		obj[16][1]="PtUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="Valid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="SE Website-18";
		//Domain
		obj[17][1]="SeUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdValidPassword";
		//Url
		obj[17][4]="Valid Credentials";
		
		
		return obj;
		
	}
	
	@DataProvider (name ="DataAllSites")
	public static Object[][] DataAllSites(){
		Object[][] obj = new Object[18][5];
		
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website-01";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="French Website-02";
		//Domain
		obj[1][1]="FrenchUrl";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdValidPassword";
		//Url
		obj[1][4]="Valid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="AE Website-03";
		//Domain
		obj[2][1]="AeUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="BE Website-04";
		//Domain
		obj[3][1]="BeUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdValidPassword";
		//Url
		obj[3][4]="Valid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="CL Website-05";
		//Domain
		obj[4][1]="ClUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="Com Website-06";
		//Domain
		obj[5][1]="ComUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdValidPassword";
		//Url
		obj[5][4]="Valid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="Com.Br Website-07";
		//Domain
		obj[6][1]="Com.brUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="Valid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="Com.co Website-08";
		//Domain
		obj[7][1]="Com.coUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdValidPassword";
		//Url
		obj[7][4]="Valid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="Com.mx Website-09";
		//Domain
		obj[8][1]="Com.mxUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="Valid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="Com.pe Website-10";
		//Domain
		obj[9][1]="Com.peUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdValidPassword";
		//Url
		obj[9][4]="Valid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="DE Website-11";
		//Domain
		obj[10][1]="DeUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="Valid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="DK Website-12";
		//Domain
		obj[11][1]="DkUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdValidPassword";
		//Url
		obj[11][4]="Valid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="ES Website-13";
		//Domain
		obj[12][1]="EsUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="Valid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="IE Website-14";
		//Domain
		obj[13][1]="IeUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdValidPassword";
		//Url
		obj[13][4]="Valid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="IT Website-15";
		//Domain
		obj[14][1]="ItUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="Valid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="NI Website-16";
		//Domain
		obj[15][1]="NlUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdValidPassword";
		//Url
		obj[15][4]="Valid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="PT Website-17";
		//Domain
		obj[16][1]="PtUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="Valid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="SE Website-18";
		//Domain
		obj[17][1]="SeUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdValidPassword";
		//Url
		obj[17][4]="Valid Credentials";

		return obj;
		
	}
	
	@DataProvider
	public Object[][] testData() {
	return new Object[][] {
		
	new Object[] { "160", "45", "17.6", "Underweight"},
	new Object[] { "168", "70", "24.8", "Normal" },
	new Object[] { "181", "89", "27.2", "Overweight" },
	new Object[] { "178", "100", "31.6", "Obesity" }, };
	
	}
	

	
}
