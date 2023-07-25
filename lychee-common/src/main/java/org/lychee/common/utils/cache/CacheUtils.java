package org.lychee.common.utils.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.time.Duration;
import java.util.concurrent.*;

/**
 * Cache 工具类
 *
 * @author xu
 * @since 1.0
 */
public class CacheUtils {

    private static ExecutorService executorService;

    static {
        executorService = new ThreadPoolExecutor(20, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200), Executors.defaultThreadFactory());
    }

    public static <K, V> LoadingCache<K, V> buildAsyncReloadingCache(Duration duration, CacheLoader<K, V> loader) {
        return CacheBuilder.newBuilder()
                // 只阻塞当前数据加载线程，其他线程返回旧值
                .refreshAfterWrite(duration)
                // 通过 asyncReloading 实现全异步加载，包括 refreshAfterWrite 被阻塞的加载线程
                // TODO 做成可配置
                .build(CacheLoader.asyncReloading(loader, executorService));
    }

}
