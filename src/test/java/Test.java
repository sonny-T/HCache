import com.ucas.hcache.TopCache.Entry;

import java.util.*;

/**
 * Created by sonny on 2016/6/11.
 */

public class Test {
    public static void main(String args[])
    {
        final Hashtable<String, Integer> h = new Hashtable<String, Integer>();
        h.put("a", 3);
        h.put("b", 2);
        h.put("c", 2);
        h.put("c", 1);
        h.put("c", 1);
        for (String str : h.keySet())
        {
            System.out.println(str);
        }
        List<String> v = new ArrayList<String>(h.keySet());
        Collections.sort(v,new Comparator<String>()
        {
            public int compare(String arg0,String arg1)
            {
                return h.get(arg1) - (h.get(arg0));
            }
        });
        int Top_K = v.size();
        Top_K = (int)(Top_K*0.8);
        Hashtable<String, Integer> replace = new Hashtable<String, Integer>();
        List<String> subList = v.subList(0,Top_K);
        Iterator it = subList.iterator();
        while(it.hasNext())
        {
            String str = (String) it.next();
            replace.put(str,h.get(str));
        }
        h.clear();
        for (String str : v)
        {
            System.out.println(str + " " + h.get(str));
        }
        h.putAll(replace);

        for (String str : h.keySet())
        {
            System.out.println(str);
        }

    }
}
