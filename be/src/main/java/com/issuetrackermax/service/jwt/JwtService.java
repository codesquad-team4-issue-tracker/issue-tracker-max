package com.issuetrackermax.service.jwt;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issuetrackermax.domain.jwt.JwtRepository;
import com.issuetrackermax.domain.jwt.JwtValidator;
import com.issuetrackermax.domain.jwt.entity.Jwt;
import com.issuetrackermax.domain.member.MemberRepository;
import com.issuetrackermax.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JwtService {
	private final JwtValidator jwtValidator;
	private final JwtRepository jwtRepository;
	private final MemberRepository memberRepository;
	private final JwtProvider jwtProvider;

	@Transactional
	public Jwt login(String email, String password) {
		Member member = memberRepository.findByMemberLoginId(email).get();
		jwtValidator.verifyPassword(member, password);
		Jwt jwt = jwtProvider.createJwt(generateMemberClaims(member.getId()));
		jwtRepository.saveRefreshToken(jwt.getRefreshToken(), member.getId());
		return jwt;
	}

	@Transactional
	public Jwt reissueAccessToken(String refreshToken) {
		Long memberId = jwtRepository.findByRefreshToken(refreshToken);
		return jwtProvider.reissueAccessToken(generateMemberClaims(memberId), refreshToken);
	}

	@Transactional
	public void logout(String refreshToken) {
		Long memberId = jwtRepository.findByRefreshToken(refreshToken);
		jwtRepository.deleteRefreshToken(refreshToken, memberId);
		return;
	}

	private Map<String, Object> generateMemberClaims(Long memberId) {
		return Map.of(
			"memberId", memberId
		);
	}

}
