package org.zziggu.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {

	private int start, end, total, bno;
	private boolean next, prev;
	
	private int display, page;
	private double per;
	
	private String type;
	private String[] types;
	private String keyword;

	public PageParam() {
		// 객체가 실행 중일 때 자기 자신을 가리킨다.
		this.page = 1;
		this.display = 10;
		this.per = (double) (this.display);

	}

	public void setTotal(int total) {
		this.total = total;
		this.end = (int) (Math.ceil(this.page / this.per)) * this.display;
		this.start = this.end - this.display + 1;

		if (this.end * this.display >= total) {

			this.end = (int) (Math.ceil(this.total / this.per));
			this.next = false;
		}else {
			this.next = true;
		}
		this.prev = this.start !=1;
	}
	
	public int getSkip(){
				
		return (this.page-1)*this.display; 
	}

	public void setDisplay(int display) {
		
		this.display = display;
		this.per = (double)display;
		
	}
	public int getDisplay()
	{
		return this.display;
	}
	public String getLink(String path) {
		
		UriComponentsBuilder uriComponentsBuilder 
		= UriComponentsBuilder.fromPath(path)
		  .queryParam("bno", this.bno).queryParam("page", this.page)
		  .queryParam("type",this.type).queryParam("keyword", this.keyword);
		return uriComponentsBuilder.toString();
	}
	
	public void setType(String type){
		this.type = type;
		if(type == null || type.trim().length() == 0) {
			this.types = null; //String 기본값은 null
			return ;
		}
		this.types=type.split("");
		
	}
}
