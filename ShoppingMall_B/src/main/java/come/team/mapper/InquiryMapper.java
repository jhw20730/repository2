package come.team.mapper;

import java.util.List;

import come.team.domain.Criteria;
import come.team.domain.InquiryVO;
import come.team.domain.ReplyVO;

public interface InquiryMapper {
	
	public List<InquiryVO> getInquiryList(Criteria criteria);
	public List<ReplyVO> getReplyList();
	
	public int getInquiryNum();
	public int getReplyNum();
	public InquiryVO getInquiryView(int inquiryNo);
	public void registerInquiry(InquiryVO inquiryVO);
	public void deleteInquiry();
	
	public void registerReplyInquiry(ReplyVO replyVO);
	public ReplyVO getReplyView(int replyNo);
	public List<ReplyVO> getReplyListByInquiryNo(int inquiryNo);
	

}
