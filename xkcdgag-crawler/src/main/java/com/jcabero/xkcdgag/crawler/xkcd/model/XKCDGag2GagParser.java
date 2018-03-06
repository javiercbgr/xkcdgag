package com.jcabero.xkcdgag.crawler.xkcd.model;

import com.jcabero.xkcdgag.gag.model.Gag;

public class XKCDGag2GagParser {

	public static Gag parse(XKCDGag xkcdGag) {
		return new Gag((long) xkcdGag.getNum(),
					   xkcdGag.getImg(),
					   xkcdGag.getTitle(),
					   0L);
	}
}
