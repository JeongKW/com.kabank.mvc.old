package com.kabank.mvc.decorate;

public class ExcuteQuery extends QueryDecorator{
	public ExcuteQuery(IQuery query) {
		super(query);
	}
	@Override
	public Object excute() {
		return super.excute();
	}
}
