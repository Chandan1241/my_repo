package com.mail.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;

import org.springframework.stereotype.Service;

import com.mail.TO.ResponseObject;
import com.mail.TO.UserLogin;
import com.mail.util.MailUtils;

@Service
public class LoginServiceImpl implements ILoginService {

	@Override
	public ResponseObject login(UserLogin user) {
		if (null != user && null != user.getUserName() && null != user.getPassword()) {
			try {
				if (user.getUserName().contains("gmail.com")) {
					loginWithGmail(user.getUserName(), user.getPassword());
				} else {
					loginWithYahoo(user.getUserName(), user.getPassword());
				}
			} catch (Exception ex) {
				//When you want to connect gmail with correct details, will get below error message because some security issues
				//And will get a mail from The Google Accounts team to gmail account
				//If you are not getting bellow message means given user name or password is invalid/mismatch 
				String msg = "Web login required";
				if (!ex.getMessage().contains(msg)) {
					return buildResponse(ex.getMessage(), MailUtils.ERROR_STATE);
				}
			}
			ResponseObject response = buildResponse(MailUtils.SUCCESS_MSG, MailUtils.SUCCESS_STATE);
			List<String> combs = combinationPhoneNumbers(user.getPhoneNumber());
			response.setPossiblePhoneNumbers(combs);
			response.setTotalNoofCombinations(null != combs ? combs.size() : 0);
			System.out.println("Given username and password are valid.");
			return response;
		}

		return buildResponse(MailUtils.EMPTY_MSG, MailUtils.ERROR_STATE);
	}

	/***
	 * login on yahoo mail account with given credentials
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	private void loginWithYahoo(String userName, String password) throws Exception {
		Properties properties = getProperties(MailUtils.YAHOO_HOST, userName, password, MailUtils.YAHOO_PORT);
		Session session = Session.getDefaultInstance(properties);

		Transport transport = session.getTransport("smtp");

		transport.connect(MailUtils.YAHOO_HOST, userName, password);

		transport.close();
	}

	/***
	 * login on google gmail account with given credentials
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	private void loginWithGmail(String userName, String password) throws Exception {
		Properties properties = getPropertiesWithPop(MailUtils.GMAIL_HOST, MailUtils.GMAIL_PORT);
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3s");
		store.connect(MailUtils.GMAIL_HOST, userName, password);
		store.close();
	}

	private ResponseObject buildResponse(String msg, int status) {
		ResponseObject object = new ResponseObject();
		object.setMessage(msg);
		object.setStatus(status);
		return object;
	}

	private Properties getProperties(String host, String userName, String password, String port) {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", userName);
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		return properties;

	}

	private Properties getPropertiesWithPop(String host, String port) {
		Properties properties = System.getProperties();

		properties.put("mail.pop3.host", host);
		properties.put("mail.pop3.port", port);
		properties.put("mail.pop3.starttls.enable", "true");

		return properties;

	}

	private static List<String> combinationPhoneNumbers(String number) {
		if (null == number || number.isEmpty()) {
			return null;
		}
		String[] digits = number.split("");
		List<String> phoneNumbers = new ArrayList<String>();
		Map<String, List<String>> finalMap = getPossibleNumbers();
		int j = 1;
		for (int i = digits.length - 1; i > 0; i--) {
			String c = digits[i];
			String temp = number;
			List<String> charList = finalMap.get(c);
			if (null != charList) {
				for (String chars : charList) {
					temp = number.substring(0, digits.length - 1 - j) + chars;
					int less = number.length() - temp.length();
					if (less != 0) {
						for (int k = 1; k <= less; k++) {
							temp += digits[(temp.length() + 1)];
						}
					}
					phoneNumbers.add(temp);
				}
			} else {
				phoneNumbers.add(temp);
			}
			j++;
		}

		return phoneNumbers;
	}

	/***
	 * possible number with alphabets
	 * 
	 * @return
	 */
	private static Map<String, List<String>> getPossibleNumbers() {

		Map<String, List<String>> numberMap = new HashMap<String, List<String>>();
		List<String> alphabets = new ArrayList<String>();
		alphabets.add("A");
		alphabets.add("B");
		alphabets.add("C");
		numberMap.put("2", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("D");
		alphabets.add("E");
		alphabets.add("F");
		numberMap.put("3", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("G");
		alphabets.add("H");
		alphabets.add("I");
		numberMap.put("4", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("J");
		alphabets.add("K");
		alphabets.add("L");
		numberMap.put("5", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("M");
		alphabets.add("N");
		alphabets.add("O");

		numberMap.put("6", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("P");
		alphabets.add("Q");
		alphabets.add("R");
		alphabets.add("S");
		numberMap.put("7", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("T");
		alphabets.add("U");
		alphabets.add("V");

		numberMap.put("8", alphabets);
		alphabets = new ArrayList<String>();

		alphabets.add("W");
		alphabets.add("X");
		alphabets.add("Y");
		alphabets.add("Z");
		numberMap.put("9", alphabets);
		return numberMap;

	}

	public static void main(String[] args) {
		/*
		 * String phoneNumber = "2589635419"; LoginServiceImpl imp = new
		 * LoginServiceImpl(); List<String> data =
		 * imp.combinationPhoneNumbers(phoneNumber);
		 * 
		 * for (String string : data) { System.out.println(string); }
		 */

		String userName = "chandan.1241@gmail.com";
		if (userName.contains("gmail.com")) {
			System.out.println("Yes");
		}

	}

}
