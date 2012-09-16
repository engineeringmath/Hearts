package network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringSerializer {
	public static byte[] serialize(Map<String, String> map){
		ArrayList<Byte> array = new ArrayList<Byte>();
		for(String key : map.keySet()){
			array.add((byte)key.getBytes().length);
			for(Byte b : key.getBytes())
				array.add(b);

			String value = map.get(key);
			array.add((byte)value.getBytes().length);
			for(Byte b : value.getBytes())
				array.add(b);
		}
		byte[] byteArray = new byte[array.size()];
		for(int i = 0; i<array.size(); i++)
			byteArray[i] = array.get(i);
		return byteArray;
	}
	
	public static Map<String, String> deserialize (byte[] bytes){
		Map<String, String> map = new HashMap<String,String>();
		int i = 0;
		while(i < bytes.length){
			
			byte keySize = bytes[i++];
			String key = readString(bytes, i, i + keySize);
			i += keySize;

			byte valSize = bytes[i++];
			String value = readString(bytes, i, i + valSize);
			i += valSize;

			map.put(key, value);
		}
		return map;
	}
	
	private static String readString(byte[] bytes, int start, int end){
		int size = end-start;
		byte[] tmp = new byte[size];
		for(int i = start; i<end; i++)
			tmp[i-start] = bytes[i];
		return new String(tmp);
	}
}
