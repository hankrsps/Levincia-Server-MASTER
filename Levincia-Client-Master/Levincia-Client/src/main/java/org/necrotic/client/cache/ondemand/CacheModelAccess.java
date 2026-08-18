package org.necrotic.client.cache.ondemand;

/**
 * Small bridge that lets the model loader read model bytes directly from the
 * packed cache before falling back to asynchronous on-demand requests.
 */
public interface CacheModelAccess {
    byte[] getModelData(int modelId);
}
