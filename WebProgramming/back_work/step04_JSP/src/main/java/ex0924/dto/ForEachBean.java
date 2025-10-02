package ex0924.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String[] names = { "test1", "test2", "test3", "test4", "test5" };
	private List<String> menus = Arrays.asList("menu1", "menu2", "menu3", "menu4", "menu5");
	private List<Board> boardList = new ArrayList<Board>();
	private Map<String, String> map = new HashMap<>();

	public ForEachBean() {
		System.out.println("ForEachBean call...");
		boardList.add(new Board(1, "title1", "content1"));
		boardList.add(new Board(2, "title2", "content2"));
		boardList.add(new Board(3, "title3", "content3"));
		boardList.add(new Board(4, "title4", "content4"));
		boardList.add(new Board(5, "title5", "content5"));

		map.put("kr", "대한민국");
		map.put("jp", "일본");
		map.put("us", "미국");
		map.put("cn", "중국");
		map.put("au", "호주");
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
