package come.team.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private int reviewNo;
	private int cartNo;
	private String productCode;
	private String payCode;
	private String id;
	private String name;
	private String content;
	private int reviewPoint;
	private Date reviewDate;
}
