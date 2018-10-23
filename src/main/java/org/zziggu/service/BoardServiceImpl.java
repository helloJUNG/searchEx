package org.zziggu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zziggu.domain.Board;
import org.zziggu.domain.PageParam;
import org.zziggu.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public List<Board> getList(PageParam pageParam) {
		// TODO Auto-generated method stub
		return mapper.getList(pageParam);
	}

	@Override
	public int register(Board board) {
		// TODO Auto-generated method stub
		return mapper.insert(board);
	}

	@Override
	public int remove(PageParam pageParam) {
		// TODO Auto-generated method stub
		return mapper.delete(pageParam);
	}

	@Override
	public int modify(Board board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}

	@Override
	public int getTotal(PageParam pageParam) {
		// TODO Auto-generated method stub
		return mapper.count(pageParam);
	}

	@Override
	public Board read(PageParam pageParam) {
		// TODO Auto-generated method stub
		return mapper.get(pageParam);
	}

}
