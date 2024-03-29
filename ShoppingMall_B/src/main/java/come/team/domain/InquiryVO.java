package come.team.domain;

import java.util.Date;

import lombok.Data;

@Data
public class InquiryVO {
	
	private int inquiryNo;
	private String id;
	private String name;
	private String title;
	private String content;
	private String password;
	private Date inquiryDate;
	
}
