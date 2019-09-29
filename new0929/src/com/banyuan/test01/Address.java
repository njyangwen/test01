/**
 * 
 */
package com.banyuan.test01;

/**
 * @author yw
 * 2019年9月29日  下午1:40:05
 *
 */
public class Address {
	private String homeAddress;
	private String companyAddress;
	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	@Override
	public String toString() {
		return "Address [homeAddress=" + homeAddress + ", companyAddress=" + companyAddress + "]";
	}
	
	

}
