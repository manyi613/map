package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class map {
	static Map<String, String> map1 = new HashMap<String, String>();
	static Map<String, String> map2 = new HashMap<String, String>();
	static Map<String, String> map3 = new HashMap<String, String>();
	static Map<String, String> map4 = new HashMap<String, String>();
	static Map<String, String> map5 = new HashMap<String, String>();
	static Map<String, String> map6 = new HashMap<String, String>();
	static List<Map> mapKeyList = new ArrayList<Map>();
	static List<Map> UserList = new ArrayList<Map>();
	static String word = "法律实体";
	static String word1 = "法律实体编号";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		data();
		userdata();
		printList(mapKeyList);
		printList(UserList);
		verifyListDup(word, mapKeyList);
		Boolean b = verifyExist(word,word1);
		System.out.println(b);
	}

	public static String getMapValue(String key, Map<Integer, Integer> map) {
		boolean flag = map.containsKey(key);
		if (!flag) {
			System.out.println(key + "不存在！");
			return null;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			System.out.println(entry.getKey());
			Object  objkey = entry.getKey();
			String str = objkey.toString();
			if (str.equals(key)) {
//				System.out.println("Key =" + entry.getKey() + ", Value =" + entry.getValue());
				Object  objvalue = entry.getValue();
				return objvalue.toString();
			}
		}
		return null;

	}

	public static void verifyListDup(String key, List<Map> list) {
		for (int i = 0; i < list.size(); i++) {
			//
			String result = null;
			String compare = null;
//			System.out.println(list.get(i));
//			System.out.println("第" + i + "行List中的值：");
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map = list.get(i);
			result = getMapValue(key, map);
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
					map1 = list.get(j);
					compare = getMapValue(key, map1);
					if (result.equals(compare)) {
						System.out.println("第" + i + "行" + "和第" + j + "行的 "+ key + " 重复，" + "值为：" + compare);
					}

				}
			}

		}

	}

	
	public static Boolean verifyExist(String key1 , String key2) {
		int j = -1;
		for (int i = 0; i < UserList.size(); i++) {
			//
			String result1 = null;
			String result2 = null;
			String act1 = null;
			String act2 = null;
//			System.out.println(list.get(i));
//			System.out.println("第" + i + "行List中的值：");
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map = UserList.get(i);
			result1 = getMapValue(key1, map);
			result2 = getMapValue(key2, map);
			for (j = 0; j < mapKeyList.size(); j++) {
					Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
					map1 = mapKeyList.get(j);
					act1 = getMapValue(key1, map1);
					act2 = getMapValue(key2, map1);
					if(result1.equals(act1) && result2.equals(act2)) {
						break;
					}
			}
			if(j >= mapKeyList.size()) {
				System.out.println("第" + i + "行，" + key1 + "：" + result1 +  "和" + key2+ "：" + result2 + "不存在或者不匹配！");
			}
		}
		return false;

	}
	
	
	
	public static void data() {
		map1.put("法律实体", "支出宝");
		map1.put("电话", "13684932834");
		map1.put("地址", "北京");
		map1.put("法律实体编号", "ZCB");
		mapKeyList.add(map1);
		map2.put("法律实体", "阿里"); 
		map2.put("电话", "13684522834");
		map2.put("地址", "上海");
		map2.put("法律实体编号", "ALI");
		mapKeyList.add(map2);
		map3.put("法律实体", "京东");
		map3.put("电话", "13434213432");
		map3.put("地址", "广州");
		map3.put("法律实体编号", "JD");
		mapKeyList.add(map3);
	}
	public static void userdata() {
		map4.put("姓名", "张三");
		map4.put("法律实体", "京东");
		map4.put("法律实体编号", "JD");
		UserList.add(map4);
		map5.put("姓名", "李思");
		map5.put("法律实体", "支出宝");
		map5.put("法律实体编号", "ZCB");
		UserList.add(map5);
		map6.put("姓名", "王五");
		map6.put("法律实体", "腾讯");
		map6.put("法律实体编号", "TX");
		UserList.add(map6);
	}

	public static void printList(List<Map> list) {
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			System.out.println("第" + i + "行List中的值：");
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map = list.get(i);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				System.out.println("Key =" + entry.getKey() + ", Value =" + entry.getValue());
			}
		}
	}
}
