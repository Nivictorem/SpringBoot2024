package ru.arkhipov.myFirstTestAppSpingBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
public class HelloController {
    ArrayList<String> arrayList;
    HashMap<Integer, String> hashMap;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name)
    {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "name",
            defaultValue = "World") String name)
    {
        if(arrayList == null)
        {
            arrayList = new ArrayList<>();
        }
        arrayList.add(name);
    }
    @GetMapping("/show-array")
    public ArrayList<String> showArrayList(@RequestParam(value = "s")
                                           String name)
    {
        if(arrayList != null)
        {
            return arrayList;
        }
        return null;
    }
    @GetMapping("/update-map")
    public void updateHashMAp(@RequestParam(value = "s")
                              String s)
    {
        int i = 0;
        if(hashMap == null)
        {
            hashMap = new HashMap<>();
        }
        else
        {
            i = hashMap.size();
        }
        hashMap.put(i+1,s);
    }
    @GetMapping("/show-map")
    public HashMap<Integer, String> updateHashMAp()
    {
        if(hashMap != null)
        {
            return hashMap;
        }
        return null;
    }
    @GetMapping("/show-all-len")
    public String ShowAllLength()
    {
        if(hashMap != null & arrayList!=null)
        {
            return Integer.toString(arrayList.size()) +
                    Integer.toString(hashMap.size());
        }
        return null;
    }
}
