package in.demo.soudeep.beans;

public class CustomerVo {
	private String cid;
	private String cname;
	private String caddress;
	private String pamt;
	private String rate;
	private String time;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getPamt() {
		return pamt;
	}
	public void setPamt(String pamt) {
		this.pamt = pamt;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "CustomerVo [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", pamt=" + pamt + ", rate="
				+ rate + ", time=" + time + "]";
	}
	
}
