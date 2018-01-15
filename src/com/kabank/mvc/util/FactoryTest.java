package com.kabank.mvc.util;

public class FactoryTest {
	public static void main(String[] args) {
//		"INSERT INTO VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')"
//		 123456789012
//		"c_pw/m_pw/m_pwch/c_phone/m_phone/c_email/m_email/c_profile/m_profile/c_addr/m_addr"
		String column2 = "c_pw/m_pw/c_phone/m_phone/c_email/m_email/c_profile/m_profile/c_addr/m_addr/id";
		String res = "";
		String[] info = ("1234/a1234/010-5627-1726/010-1242-1231/jipegaja@gmail.com////집에산다 어디에//jk_pon").split("/");
		String[] column = column2.split("/");
		for(int i = 0; i < column.length - 1; i = i + 2) {
			if(!(info[i].equals(info[i+1])) && !(info[i+1].equals(""))) {
				res += column[i].split("_")[1] + "=" + "'" + info[i+1] + "'";
			}
		}
//		for(int i = 0; i < column.length - 1; i = i + 2) {
//			System.out.println(column[i] + "=" + info[i]);
//		}
		System.out.println(res);
	}
}
