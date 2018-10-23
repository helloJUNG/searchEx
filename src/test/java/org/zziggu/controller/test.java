package org.zziggu.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zziggu.domain.PageParam;
import org.zziggu.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class test {

	@Setter(onMethod_=@Autowired)
	BoardService service;
	
	@Test
	public void test(PageParam pageParam) {
		log.info(service.getTotal(pageParam));
	}
	
}
