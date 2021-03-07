package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import com.sun.org.apache.xalan.internal.xsltc.runtime.Constants;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static Map<String, String> countries = new HashMap<String, String>();

	static {
		countries.put("UA", "Ukraine");
		countries.put("RU", "Russia");
		countries.put("CA", "Canada");
	}

	public static void main(String[] args) {
		MyIncomeData myIncomeData = new MyIncomeData();
		Contact contact = new IncomeDataAdapter(myIncomeData);
		String phone = contact.getPhoneNumber();

		System.out.println(phone);
	}

	public static class MyIncomeData implements IncomeData {
		@Override
		public String getCountryCode() {
			return null;
		}

		@Override
		public int getPhoneNumber() {
			return 50756897;
		}

		@Override
		public int getCountryPhoneCode() {
			return 56;
		}

		@Override
		public String getContactLastName() {
			return null;
		}

		@Override
		public String getContactFirstName() {
			return null;
		}

		@Override
		public String getCompany() {
			return null;
		}
	}

	public static class IncomeDataAdapter implements Customer, Contact {
		private IncomeData data;

		public IncomeDataAdapter(IncomeData incomeData) {
			this.data = incomeData;
		}

		@Override
		public String getName() {
			String result = data.getContactLastName() + ", " + data.getContactFirstName();
			return result;
		}

		@Override
		public String getPhoneNumber() {
			int cityCode = data.getPhoneNumber() / 10000000;
			int phoneNum = data.getPhoneNumber() % 10000000;
			DecimalFormat decimalFormat = new DecimalFormat("0000000");
			String strPhoneNum = decimalFormat.format(phoneNum);
			String s1 = strPhoneNum.substring(0, 3);
			String s2 = strPhoneNum.substring(3, 5);
			String s3 = strPhoneNum.substring(5, 7);


			String phone = String.format("+%d(%03d)%s-%s-%s", data.getCountryPhoneCode(), cityCode, s1, s2,s3);
			return phone;
		}

		@Override
		public String getCountryName() {
			return countries.get(data.getCountryCode());
		}

		@Override
		public String getCompanyName() {
			return data.getCompany();
		}
	}


	public static interface IncomeData {
		String getCountryCode();        //For example: UA

		String getCompany();            //For example: JavaRush Ltd.

		String getContactFirstName();   //For example: Ivan

		String getContactLastName();    //For example: Ivanov

		int getCountryPhoneCode();      //For example: 38

		int getPhoneNumber();           //For example: 501234567
	}

	public static interface Customer {
		String getCompanyName();        //For example: JavaRush Ltd.

		String getCountryName();        //For example: Ukraine
	}

	public static interface Contact {
		String getName();               //For example: Ivanov, Ivan

		String getPhoneNumber();        //For example: +38(050)123-45-67
	}
}