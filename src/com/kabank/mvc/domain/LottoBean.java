package com.kabank.mvc.domain;

public class LottoBean {
	private String lottoNum;

	public String getLottoNum() {
		return lottoNum;
	}

	public void setLottoNum(String lottoNum) {
		this.lottoNum = lottoNum;
	}

	@Override
	public String toString() {
		return "로또번호 : [" + lottoNum + "]";
	}
}
