package in.demo.soudeep.beans;

public class CustomerDto {
	private Integer cid;
	private String cname;
	private String caddress;
	private Float pamt;
	private Float rate;
	private Float time;
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
	public Float getPamt() {
		return pamt;
	}
	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Float getTime() {
		return time;
	}
	public void setTime(Float time) {
		this.time = time;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", pamt=" + pamt + ", rate="
				+ rate + ", time=" + time + "]";
	}
	
}
