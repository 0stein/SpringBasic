package aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemberRepository implements Repository<Member>{

	private final List<Member> memberList = new ArrayList<Member>();
	
	public Member getElementById(int id) {
		for(Member member : memberList) {
			if(member.getId() == id)
				return member;
		}
		return null;
	}

	public void inputElement(Member e) {
		memberList.add(e);
	}
	
}
