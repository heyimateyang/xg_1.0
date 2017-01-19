package org.heyimtaeyang.test;

import java.util.List;

import org.heyimtaeyang.biz.CitationBiz;
import org.heyimtaeyang.biz.impl.CitationBizImpl;
import org.heyimtaeyang.entity.Citation;
import org.junit.Test;

public class Test2 {
	
	@Test
	public void findCitation(){
		CitationBiz citationBiz = new CitationBizImpl();
		List<Citation> list = citationBiz.find_Citation("省级");
		for(Citation citation:list){
			System.out.println(citation.getCitationName());
		}
	}

}
