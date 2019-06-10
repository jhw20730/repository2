package come.team.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo;
	private int inquiryNo;
	private String id;
	private String title;
	private String content;
	private Date replyDate;

}
