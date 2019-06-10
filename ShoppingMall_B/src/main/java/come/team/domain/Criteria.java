package come.team.domain;


import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	private int price;

	public Criteria() {
		this(1, 10, 1000000);
	}
		
	
	public Criteria(int pageNum, int amount, int price) {
		this.pageNum = pageNum;
		this.amount = amount;
		if(price == 0) {
			this.price = 1000000;
		} else {
			this.price = price;
		}
	}
	
	  public String[] getTypeArr() {
		  return type == null? new String[] {} : type.split("");
		  //productType = T
		  //productCode = C
		  //productName = N
		  //manufacturer = M
		  //description = D
	  }
	  
	  public String getListLink() {
		  UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				  .queryParam("pageNum", this.pageNum)
				  .queryParam("amount", this.amount)
				  .queryParam("type", this.type)
				  .queryParam("keyword", this.keyword);
		  
		  return builder.toUriString();  
		}	


}
