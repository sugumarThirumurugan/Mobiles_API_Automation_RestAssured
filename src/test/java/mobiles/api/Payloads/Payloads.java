package mobiles.api.Payloads;

public class Payloads {
	
	String MobileName;
	String MobileVersion;
	String Ram;
	String Battery;
	
	public String getMobileName() {
		return MobileName;
	}
	public void setMobileName(String mobileName) {
		MobileName = mobileName;
	}
	public String getMobileVersion() {
		return MobileVersion;
	}
	public void setMobileVersion(String mobileVersion) {
		MobileVersion = mobileVersion;
	}
	public String getRam() {
		return Ram;
	}
	public void setRam(String ram) {
		Ram = ram;
	}
	public String getBattery() {
		return Battery;
	}
	public void setBattery(String battery) {
		Battery = battery;
	}

}
