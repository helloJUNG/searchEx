package org.zziggu.service;

import java.util.List;

import org.zziggu.domain.Board;
import org.zziggu.domain.PageParam;

public interface BoardService {
	
	public List<Board> getList(PageParam pageParam);
	
	public int register(Board board);
	
	public int remove(PageParam pageParam);
	
	public int modify(Board board);
	
	public int getTotal(PageParam pageParam);
	
	public Board read(PageParam pageParam); 

}
