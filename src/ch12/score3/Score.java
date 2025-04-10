package ch12.score3;

import java.util.List;

public interface Score {
	public void insertScore(ScoreVO vo);
	public boolean deleteScore(String hak);
	
	public ScoreVO findByHak(String hak);
	public List<ScoreVO> findByName(String name);
	public List<ScoreVO> findByAll();
}
