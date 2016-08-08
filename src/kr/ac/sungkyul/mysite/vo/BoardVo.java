package kr.ac.sungkyul.mysite.vo;

public class BoardVo {
	
	private Long no;
	private String title;
	private String content;
	private Integer count;
	private Integer groupNo;
	private Integer groupOrderNo;
	private Integer depth;
	private Long UserNo;
	private String date;
	private String name;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}
	public Integer getGroupOrderNo() {
		return groupOrderNo;
	}
	public void setGroupOrderNo(Integer groupOrderNo) {
		this.groupOrderNo = groupOrderNo;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Long getUserNo() {
		return UserNo;
	}
	public void setUserNo(Long userNo) {
		UserNo = userNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
