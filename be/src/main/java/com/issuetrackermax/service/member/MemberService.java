package com.issuetrackermax.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issuetrackermax.controller.auth.dto.response.MemberProfileResponse;
import com.issuetrackermax.controller.member.dto.request.SignUpRequest;
import com.issuetrackermax.domain.member.MemberRepository;
import com.issuetrackermax.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;

	@Transactional
	public void registerMember(SignUpRequest signUpRequest) {
		/*
		 * TODO
		 */
		// if(memberRepository.existEmail(memberRegisterDto.getEmail())){
		// 	return;
		// }
		memberRepository.save(signUpRequest.toMember());
	}

	@Transactional
	public Member saveOrUpdate(MemberProfileResponse memberProfileResponse) {
		try {
			return memberRepository.findByMemberLoginId(memberProfileResponse.getLoginId()).get();
		} catch (Exception e) {
			memberRepository.save(memberProfileResponse.toMember());
			return memberRepository.findByMemberLoginId(memberProfileResponse.getLoginId()).get();
		}
	}
}
