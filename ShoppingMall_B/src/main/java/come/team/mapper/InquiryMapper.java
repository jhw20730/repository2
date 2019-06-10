package come.team.mapper;

import java.util.List;

import come.team.domain.Criteria;
import come.team.domain.InquiryVO;

public interface InquiryMapper {
	
	public List<InquiryVO> getInquiryList(Criteria criteria);
	public int getInquiryNum();
	public InquiryVO getInquiryView(int inquiryNo);
	public void registerInquiry(InquiryVO inquiryVO);
	public void deleteInquiry();

}
