package com.kabank.mvc.util;

public class FactoryTest {
	public static void main(String[] args) {
//		"INSERT INTO VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')"
//		 123456789012
//		"[0]c_pw/[1]m_pw/[2]c_phone/[3]m_phone/[4]c_email/[5]m_email/[6]c_profile/[7]m_profile/[8]c_addr/[9]m_addr/[10]id/[11]m_pwch"
		String column2 = "c_pw/m_pw/c_phone/m_phone/c_email/m_email/c_profile/m_profile/c_addr/m_addr/id/m_pwch";
		String res = "";
		String[] info = ("1234/a1234/010-5627-1726/010-1242-1231/jipegaja@gmail.com/aasdfq///집에산다 어디에//jk_pon/a1234").split("/");
		String[] column = column2.split("/");
		for(int i = column.length - 4; i >= 0; i = i - 2) {
			if(i != 0) {
				if(!(info[i].equals(info[i+1])) && !(info[i+1].equals(""))) {
					res += column[i].split("_")[1] + "=" + "'" + info[i+1] + "',";
				}
			} else {
				if(!(info[i].equals(info[i+1])) && !(info[i+1].equals(""))) {
					res += column[i].split("_")[1] + "=" + "'" + info[i+1] + "'";
				}
			}
		}
//		for(int i = 0; i < column.length - 1; i = i + 2) {
//			System.out.println(column[i] + "=" + info[i]);
//		}
		System.out.println(res);
	}
}
