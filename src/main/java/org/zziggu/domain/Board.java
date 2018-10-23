package org.zziggu.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Board {
	
	private Integer bno;
	private String title, content, writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate,updatedate;

}
