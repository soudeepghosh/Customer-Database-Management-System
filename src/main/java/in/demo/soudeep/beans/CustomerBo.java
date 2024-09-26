package in.demo.soudeep.beans;

public class CustomerBo {
	
	private Integer cid;
	private String cname;
	private String caddr;
	private Float pamt;
	private Float rate;
	private Float time;
	private Float si;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
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
	public Float getSi() {
		return si;
	}
	public void setSi(Float si) {
		this.si = si;
	}
	@Override
	public String toString() {
		return "CustomerBo [cid=" + cid + ", cname=" + cname + ", caddr=" + caddr + ", pamt=" + pamt + ", rate=" + rate
				+ ", time=" + time + ", si=" + si + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
}
