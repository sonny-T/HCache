package hcache.H_Client;

import  hcache.memcached.*;

// import package write or read .
/**
 * Created by liujingkun on 16/6/10.
 */

/*
   modify by hcs on 16/6/10
*/

public class HCacheClient {
    private boolean memecached = false;
    private boolean local_cache = false;
    private MemCached memcache;
    private cache local;
    private String tableName;
    public HCacheClient() {

    }

    public void put(String key, String value){
        if(local_cache)
        {
             memcache.delete(key);
        }
        if(memecached)
        {
            local.delete(key);
        }
        write()

    }

    public String get(String key){
        if(local_cache.cotain(key)) {
            return local_cache.get(tableName,key);
        }
        if(memecached.contain(key)) {
            return memecached.get(tableName,key);
        }

        return read(tableName,key);
    }
}
