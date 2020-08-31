package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoService {
	
	private Repository<Member> memberRepository;
	
	@Autowired
	public DemoService(Repository<Member> memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void store(Member member) {
		memberRepository.inputElement(member);
	}
	
	public Member getMemberById(int id) {
		return memberRepository.getElementById(id);
	}
}
