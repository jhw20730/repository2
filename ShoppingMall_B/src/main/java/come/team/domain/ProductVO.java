package come.team.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductVO {
	
	private String productCode;
	private String productName;
	private String manufacturer;
	private BigDecimal price;
	private String description;
	private String os;
	private String productType;
	private BigDecimal stock;
	private String usability;

}
