package dao;

import consts.Definition;

public class CommonDao {
	protected final String URL  = Definition.URL;
	protected final String USER = Definition.USER;
	protected final String PASS = Definition.PASS;

	public void delete(int id) {
		System.err.println("deleteをオーバーライドしてください。");
	}
}
