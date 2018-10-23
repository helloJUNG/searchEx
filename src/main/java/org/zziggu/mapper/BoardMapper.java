package org.zziggu.mapper;

import java.util.List;

import org.zziggu.domain.Board;
import org.zziggu.domain.PageParam;

public interface BoardMapper {
	
	public List<Board> getList(PageParam pageParam);
	
	public int delete(PageParam pageParam);
	
	public int update(Board board);
	
	public int insert(Board board);
	
	public Board get(PageParam pageParam);
	
	public int count(PageParam pageParam);
	

}
