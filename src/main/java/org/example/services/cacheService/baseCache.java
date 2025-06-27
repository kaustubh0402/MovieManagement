package org.example.services.cacheService;

public interface baseCache {
    public int getCacheHit();
    public void clearCache();
    public void setCacheHit(int extraHits);

}
