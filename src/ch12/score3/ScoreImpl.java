package ch12.score3;

import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score{
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	
	@Override
	public void insertScore(ScoreVO vo) {
		list.add(vo);
	}

	@Override
	public boolean deleteScore(String hak) {
		ScoreVO vo = findByHak(hak);
		
		return list.remove(vo);
	}

	@Override
	public ScoreVO findByHak(String hak) {
			for(ScoreVO vo : list) {
				if(vo.getHak().equals(hak)) {
					return vo;
				}
			}
		return null;
	}

	@Override
	public List<ScoreVO> findByName(String name) {
		List<ScoreVO> searchList = new ArrayList<ScoreVO>();
		
		for(ScoreVO vo : list) {
			if(vo.getName().contains(name)) {
				searchList.add(vo);
			}
		}
		return searchList;
	}

	@Override
	public List<ScoreVO> findByAll() {
		return list;
	}

}
