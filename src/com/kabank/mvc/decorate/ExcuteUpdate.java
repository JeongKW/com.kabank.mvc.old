package com.kabank.mvc.decorate;

public class ExcuteUpdate extends QueryDecorator{
	public ExcuteUpdate(IQuery query) {
		super(query);
	}
	@Override
	public Object excute() {
		return super.excute();
	}
}
