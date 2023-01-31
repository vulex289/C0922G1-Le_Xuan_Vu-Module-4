package com.codegym.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("apple", "táo");
        dictionary.put("blue", "xanh");
        dictionary.put("black", "đen");
        dictionary.put("pink", "hồng");
        dictionary.put("car", "xe hơi");
        dictionary.put("girl", "ngon");
    }

    @Override
    public String search(String name) {
        String result = "không tìm thấy";
        for (Map.Entry<String, String> map : dictionary.entrySet()) {
            if (map.getKey().equals(name)) {
                result = map.getValue();
                break;
            }
        }
        return result;
    }
}
