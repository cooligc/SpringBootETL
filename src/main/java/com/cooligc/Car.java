/**
 * 
 */
package com.cooligc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sitakant
 *
 */
@Entity
@Table(name = "CARS")
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String modelYear;

	private String manufacturer;

	private String mfrCode;

	private String representedTest;

	private String testVehicleId;

	private String testConfiguration;

	private String testVehicleDisplacement;

	private String actualTestGroup;

	private String power;

	private String vehicleType;

	private String noOfCylinder;

	private String authToken;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the modelYear
	 */
	public String getModelYear() {
		return modelYear;
	}

	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the mfrCode
	 */
	public String getMfrCode() {
		return mfrCode;
	}

	/**
	 * @param mfrCode the mfrCode to set
	 */
	public void setMfrCode(String mfrCode) {
		this.mfrCode = mfrCode;
	}

	/**
	 * @return the representedTest
	 */
	public String getRepresentedTest() {
		return representedTest;
	}

	/**
	 * @param representedTest the representedTest to set
	 */
	public void setRepresentedTest(String representedTest) {
		this.representedTest = representedTest;
	}

	/**
	 * @return the testVehicleId
	 */
	public String getTestVehicleId() {
		return testVehicleId;
	}

	/**
	 * @param testVehicleId the testVehicleId to set
	 */
	public void setTestVehicleId(String testVehicleId) {
		this.testVehicleId = testVehicleId;
	}

	/**
	 * @return the testConfiguration
	 */
	public String getTestConfiguration() {
		return testConfiguration;
	}

	/**
	 * @param testConfiguration the testConfiguration to set
	 */
	public void setTestConfiguration(String testConfiguration) {
		this.testConfiguration = testConfiguration;
	}

	/**
	 * @return the testVehicleDisplacement
	 */
	public String getTestVehicleDisplacement() {
		return testVehicleDisplacement;
	}

	/**
	 * @param testVehicleDisplacement the testVehicleDisplacement to set
	 */
	public void setTestVehicleDisplacement(String testVehicleDisplacement) {
		this.testVehicleDisplacement = testVehicleDisplacement;
	}

	/**
	 * @return the actualTestGroup
	 */
	public String getActualTestGroup() {
		return actualTestGroup;
	}

	/**
	 * @param actualTestGroup the actualTestGroup to set
	 */
	public void setActualTestGroup(String actualTestGroup) {
		this.actualTestGroup = actualTestGroup;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}
	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the noOfCylinder
	 */
	public String getNoOfCylinder() {
		return noOfCylinder;
	}

	/**
	 * @param noOfCylinder the noOfCylinder to set
	 */
	public void setNoOfCylinder(String noOfCylinder) {
		this.noOfCylinder = noOfCylinder;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + id + ", modelYear=" + modelYear + ", manufacturer=" + manufacturer + ", mfrCode=" + mfrCode
				+ ", representedTest=" + representedTest + ", testVehicleId=" + testVehicleId + ", testConfiguration="
				+ testConfiguration + ", testVehicleDisplacement=" + testVehicleDisplacement + ", actualTestGroup="
				+ actualTestGroup + ", power=" + power + ", vehicleType=" + vehicleType + ", noOfCylinder="
				+ noOfCylinder + "]";
	}

	/**
	 * @return the authToken
	 */
	public String getAuthToken() {
		return authToken;
	}

	/**
	 * @param authToken the authToken to set
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	
	
	
}
